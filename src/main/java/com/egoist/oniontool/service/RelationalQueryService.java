package com.egoist.oniontool.service;

import com.egoist.oniontool.dao.CustomQueryMapper;
import com.egoist.parent.common.utils.collection.EgoistCollectionUtil;
import com.egoist.parent.common.utils.string.EgoistStringUtil;
import com.egoist.parent.pojo.dto.EgoistResult;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: 关联查询服务
 */
@Service
public class RelationalQueryService {

    /**
     * 自定义查询mapper
     */
    @Autowired
    private CustomQueryMapper customQueryMapper;

    /**
     * 查询
     *
     * @param in          excel文件
     * @return 结果
     */
    public EgoistResult query(InputStream in) {
        try {
            //创建Excel工作薄
            Workbook wb = WorkbookFactory.create(in);
            Sheet sheet = wb.getSheetAt(0);
            // 判断标题
            Row titleRow = sheet.getRow(0);
            if (titleRow == null) {
                return new EgoistResult(400, "Excel标题行为空", null);
            }
            List<String> patternList = new ArrayList<>();
            for (Cell cell : titleRow) {
                patternList.add("{{" + String.valueOf(cell) + "}}");
            }
            // 获取sql模板
            Sheet sheet2 = wb.getSheetAt(1);
            String sqlTemplate = sheet2.getRow(0).getCell(0).getStringCellValue();

            List<LinkedHashMap<String, Object>> allResultList = new ArrayList<>();
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                if (row == null) {
                    continue;
                }
                String sql = sqlTemplate;
                boolean isAllCellNotEmpty = true;
                for (int j = 0; j < patternList.size(); j++) {
                    String cellValue = String.valueOf(row.getCell(j));
                    if (EgoistStringUtil.isBlank(cellValue)) {
                        isAllCellNotEmpty = false;
                        break;
                    }
                    sql = sql.replace(patternList.get(j), cellValue);
                }
                if (isAllCellNotEmpty) {
                    List<LinkedHashMap<String, Object>> sqlResultList = customQueryMapper.customQuery(sql);
                    allResultList.addAll(sqlResultList);
                }
            }

            return this.exportExcel(allResultList);
        } catch (Exception e) {
            e.printStackTrace();
            return new EgoistResult(400, "关联查询异常", null);
        }
    }

    private EgoistResult exportExcel(List<LinkedHashMap<String, Object>> allResultList) {
        try {
            if (EgoistCollectionUtil.isEmpty(allResultList)) {
                return new EgoistResult(400, "查询结果为空", null);
            }
            XSSFWorkbook workBook = new XSSFWorkbook();
            //创建工作表
            XSSFSheet sheet = workBook.createSheet("result");
            // 创建标题
            XSSFRow titleRow = sheet.createRow(0);
            int k = 0;
            for (Map.Entry<String, Object> entry : allResultList.get(0).entrySet()) {
                XSSFCell cell = titleRow.createCell(k, CellType.STRING);
                cell.setCellValue(String.valueOf(entry.getKey()));
                k++;
            }
            for (int i = 0; i < allResultList.size(); i++) {
                //创建行
                XSSFRow row = sheet.createRow(i+1);
                int j = 0;
                for (Map.Entry<String, Object> entry : allResultList.get(i).entrySet()) {
                    //创建单元格
                    XSSFCell cell = row.createCell(j, CellType.STRING);
                    cell.setCellValue(String.valueOf(entry.getValue()));
                    j++;
                }
            }
            return EgoistResult.ok(workBook);
        } catch (Exception e){
            return new EgoistResult(400, "导出查询结果异常", null);
        }
    }
}

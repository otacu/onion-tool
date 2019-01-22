package com.egoist.oniontool.controller;

import com.egoist.oniontool.service.RelationalQueryService;
import com.egoist.parent.pojo.dto.EgoistResult;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

/**
 * @Description: 关联查询
 */
@Controller
public class RelationalQueryController {

    @Autowired
    private RelationalQueryService relationalQueryService;

    /**
     * 跳转到关联查询页面
     *
     * @return
     */
    @RequestMapping("relationalquery")
    public String relationalQuery() {
        return "relational-query";
    }

    /**
     * 上传
     *
     * @param upfile
     * @return
     */
    @PostMapping("relationalquery/upload")
    @ResponseBody
    public void upload(MultipartFile upfile, HttpServletResponse response) {
        try {
            if (upfile == null) {
//                return new EgoistResult(400, "上传文件为空", null);
                return;
            }
            InputStream in = upfile.getInputStream();
            // select * from `onion`.tb_order_sub where sub_order_no = '{{拆单编号}}';
            EgoistResult result = relationalQueryService.query(in);
            if (EgoistResult.isOk(result)) {
                Workbook workBook = (Workbook) result.getData();
                response.setCharacterEncoding("UTF-8");
                response.setContentType("application/octet-stream");
                response.setHeader("Content-disposition", String.format("attachment;filename=%s.xlsx", new Date().getTime()));
                OutputStream ouputStream = response.getOutputStream();
                workBook.write(ouputStream);
                ouputStream.flush();
                ouputStream.close();
            }
        } catch (Exception e) {
//            return new EgoistResult(400, "上传异常", null);
        }
    }
}

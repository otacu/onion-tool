package com.egoist.oniontool.service.elasticsearch;

import com.egoist.oniontool.dao.elasticsearch.ThirdPlatformLogRepository;
import com.egoist.oniontool.pojo.elasticsearch.ThridPlatformLogDetailDoc;
import com.egoist.oniontool.service.ThirdPlatformLogService;
import com.egoist.parent.common.utils.collection.EgoistCollectionUtil;
import com.egoist.parent.pojo.dto.EgoistPagingResult;
import com.egoist.parent.pojo.dto.EgoistResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThirdPlatformLogESService {
    @Autowired
    private ThirdPlatformLogRepository repository;

    @Autowired
    private ThirdPlatformLogService thirdPlatformLogService;

    /**
     * 重建索引
     * @param pageNum
     * @param pageSize
     * @return
     * @throws InterruptedException
     */
    public EgoistResult rebuildIndex(Integer pageNum, Integer pageSize) throws InterruptedException {
        EgoistResult queryTotalPageResult = thirdPlatformLogService.queryTotalPage(pageSize);
        if (!EgoistResult.isOk(queryTotalPageResult)) {
            return queryTotalPageResult;
        }
        int totalPage = (int) queryTotalPageResult.getData();
        // 由于单词查询都要10分钟，用多线程对数据库运算压力太大，所以不用多线程。
        //TODO 但是因为一天数据就有20多万，不用多线程时间太慢，还没想到解决方法。
        for (int i = 1; i <= totalPage; i++) {
            // 查询一页
            EgoistPagingResult queryResult = thirdPlatformLogService.queryThirdPlatformLogDoc(pageNum, pageSize);
            if (EgoistResult.isOk(queryResult)) {
                // 放进ES
                List<ThridPlatformLogDetailDoc> docList = (List<ThridPlatformLogDetailDoc>) queryResult.getData();
                if (EgoistCollectionUtil.isNotEmpty(docList)) {
                    repository.saveAll(docList);
                }
            }
        }
        return EgoistResult.ok();
    }

    /**
     * 清楚索引中的数据
     * @return
     */
    public EgoistResult deleteIndex() {
        repository.deleteAll();
        return EgoistResult.ok();
    }
}

package com.egoist.oniontool.service;

import com.alibaba.fastjson.JSON;
import com.egoist.parent.pojo.dto.EgoistResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestThirdPlatformLogService {
    @Autowired
    private ThirdPlatformLogService thirdPlatformLogService;

    /**
     * 测试查询第三方日志
     */
    @Test
    public void testQueryThirdPlatformLog(){
        // 表中前面的记录没有detail记录
        EgoistResult result = thirdPlatformLogService.queryThirdPlatformLogDoc(1000, 100);
        System.out.println(JSON.toJSONString(result));
    }

    /**
     * 测试查询总页数
     */
    @Test
    public void testQueryTotalPage(){
        EgoistResult result = thirdPlatformLogService.queryTotalPage(100);
        System.out.println(JSON.toJSONString(result));
    }

}

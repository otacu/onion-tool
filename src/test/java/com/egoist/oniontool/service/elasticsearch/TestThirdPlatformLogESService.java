package com.egoist.oniontool.service.elasticsearch;

import com.alibaba.fastjson.JSON;
import com.egoist.oniontool.common.constants.OnionConstant;
import com.egoist.parent.pojo.dto.EgoistResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestThirdPlatformLogESService {
    @Autowired
    private ThirdPlatformLogESService thirdPlatformLogESService;

    /**
     * 测试重建索引
     * @throws InterruptedException
     */
    @Test
    public void testQueryThirdPlatformLog() throws InterruptedException {
        // 表中前面11897条记录没有detail记录，如果不加日期范围，就从119页开始
        int pageNum = OnionConstant.ONE;
        int pageSize = OnionConstant.ONE_HUNDRED;
        EgoistResult result = thirdPlatformLogESService.rebuildIndex(pageNum, pageSize);
        System.out.println(JSON.toJSONString(result));
    }

    /**
     * 测试清空索引数据
     */
    @Test
    public void testDeleteAll() {
        thirdPlatformLogESService.deleteIndex();
    }
}

package com.egoist.oniontool.service;

import com.egoist.oniontool.common.enums.WmsServerEnum;
import com.egoist.oniontool.pojo.wms.QueryTypeStockRequest;
import com.egoist.oniontool.pojo.wms.SaleOrderQueryRequest;
import com.egoist.parent.pojo.dto.EgoistResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestWmsService {
    @Autowired
    private WmsService wmsService;

    /**
     * 测试根据条码查询库存
     */
    @Test
    public void testQueryThirdPlatformLog() {
        QueryTypeStockRequest request = new QueryTypeStockRequest();
        request.setCusgoodsno("2016022200002");
        request.setServerType(WmsServerEnum.HONG_KONG);
        request.setCuscode("YT");
        EgoistResult result = wmsService.querySkuStock(request);
//        System.out.println(JSON.toJSONString(result));
    }

    /**
     * 测试查询订单出库状态
     */
    @Test
    public void testQuerySaleOrderOut() {
        SaleOrderQueryRequest request = new SaleOrderQueryRequest();
        request.setCusbillno("XP0019062718200244789093001598");
        request.setServerType(WmsServerEnum.GUANG_ZHOU);
        EgoistResult result = wmsService.querySaleOrderOut(request);
//        System.out.println(JSON.toJSONString(result));
    }
}

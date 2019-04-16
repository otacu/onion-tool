package com.egoist.oniontool.pojo.wms;

import com.egoist.oniontool.common.constant.WmsPathConstant;
import lombok.Data;

@Data
public class QueryTypeStockRequest extends WmsRequest {
    /**
     * 客户 SKU
     * 客户 SKU 为空时,返回所 有客户 SKU 信息 多个客户 SKU 用英文逗 号”,”隔开
     */
    private String cusgoodsno;

    /**
     * 同 customerCode
     */
    private String cuscode;


    /**
     * 库存类型
     * 为空则查全部 002001: 销售出库 002002: 调拨出库 002003: 残次品出库 002004: 其它出库 指定以上值,则只查询相 应库存类型的库存信息
     */
    private String outtype;

    /**
     * @return funtion
     */
    @Override
    public String getMethod() {
        return WmsPathConstant.QUERY_SKU_STOCK_METHOD;
    }

    /**
     * @return funtion
     */
    @Override
    public String getVersion() {
        return WmsPathConstant.VERSION_2;
    }
}

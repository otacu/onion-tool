package com.egoist.oniontool.pojo.wms;

import com.egoist.oniontool.common.constant.WmsPathConstant;
import lombok.Data;

@Data
public class SaleOrderQueryRequest extends WmsRequest {
    /**
     * 客户单号
     * 多个用逗号”,”分隔 客户单号与时间范围至 少一项为不能为空
     */
    private String cusbillno;


    /**
     * 时间范围从
     * 格式: yyyy-mm-dd hh24:mi:ss
     */
    private String timeBegin;

    /**
     * 时间范围到
     * 格式: yyyy-mm-dd hh24:mi:ss
     */
    private String timeEnd;

    /**
     * 时间范围类型
     * timeType
     */
    private String timeType;

    /**
     * @return funtion
     */
    @Override
    public String getMethod() {
        return WmsPathConstant.QUERY_SALE_ORDER_METHOD;
    }
}

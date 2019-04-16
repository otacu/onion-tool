package com.egoist.oniontool.common.constant;

public final class WmsPathConstant {

    private WmsPathConstant() {

    }

    /**
     * 服务名默认值:wmsComApiService
     */
    public static final String SERVICE_BEAN_ID = "wmsComApiService";

    /**
     * 版本
     */
    public static final String VERSION = "V1";

    /**
     * 版本2
     */
    public static final String VERSION_2 = "V2";


    /**
     * 创建SKU，方法签名:createSku
     */
    public static final String CREATE_SKU_METHOD = "createSku";

    /**
     * 查询SKU，方法签名:queryStoTotal
     */
    public static final String QUERY_SKU_METHOD = "querySku";


    /**
     * 查询SKU库存，方法签名:queryStoTotal
     */
    public static final String QUERY_SKU_STOCK_METHOD = "queryStoTotal";


    /**
     * 创建SKU，ActionCode
     */
    public static final String CREATE_SKU_ACTION_CODE = "nwmsCreateSKU";


    /**
     * 查询SKU，ActionCode
     */
    public static final String QUERY_SKU_ACTION_CODE = "nwmsQuerySKU";


    /**
     * 查询SKU库存，ActionCode
     */
    public static final String QUERY_SKU_STOCK_ACTION_CODE = "nwmsQuerySkuStock";

    /**
     * 查询SKU2库存，ActionCode
     */
    public static final String QUERY_TYPE_STOCK_ACTION_CODE = "nwmsQueryTypeStock";

    /**
     * 销售出库单，方法签名:queryStoTotal
     */
    public static final String SALE_OUT_METHOD = "createSO";


    /**
     * 销售出库单，ActionCode
     */
    public static final String SALE_OUT_ACTION_CODE = "nwmsSaleOut";


    /**
     * 销售状态推送单，方法签名:syncBillStat
     */
    public static final String SALE_STATE_PUSH_METHOD = "syncBillStat";


    /**
     * 销售状态查询，方法签名:querySOByNo
     */
    public static final String QUERY_SALE_ORDER_METHOD = "querySoStatus";


    /**
     * 销售状态修改回调
     */
    public static final String NEW_WMS_SALE_STATUS_CALL = "newWmsSaleStatusCall";


    /**
     * 物流单号接收
     */
    public static final String DISP_LOGISTICS_NO = "dispLogisticsNo";


    /**
     * 取包裹体积重量等信息
     */
    public static final String QUERY_SO_VOLUME = "querySoVolume";

}

package com.egoist.oniontool.common.constant;

public final class WmsConstant {
    private WmsConstant(){

    }

    /**
     * 出库类型  002001: 销售出库
     */
    public static final String SALE_OUT_TYPE_002001 = "002001";

    /**
     * 退货出库  002002: 退货出库
     */
    public static final String SALE_OUT_TYPE_002002 = "002002";

    /**
     * 出库类型  002003: 调货出库
     */
    public static final String SALE_OUT_TYPE_002003 = "002003";


    /**
     * 订单状态  009000: 未确认
     */
    public static final String BILL_STATE_009000 = "009000";

    /**
     * 订单状态  009001: 已确认
     */
    public static final String BILL_STATE_009001 = "009001";

    /**
     * 订单状态  009002: 已审核
     */
    public static final String BILL_STATE_009002 = "009002";

    /**
     * 订单状态  009003: 已派单
     */
    public static final String BILL_STATE_009003 = "009003";

    /**
     * 订单状态  009004: 拣货中
     */
    public static final String BILL_STATE_009004 = "009004";

    /**
     * 订单状态  009005: 已拣货
     */
    public static final String BILL_STATE_009005 = "009005";

    /**
     * 订单状态  009006: 已分拣
     */
    public static final String BILL_STATE_009006 = "009006";

    /**
     * 订单状态  009007: 已复核
     */
    public static final String BILL_STATE_009007 = "009007";

    /**
     * 订单状态  009008: 已包装
     */
    public static final String BILL_STATE_009008 = "009008";

    /**
     * 订单状态  009009: 已发货
     */
    public static final String BILL_STATE_009009 = "009009";

    /**
     * 订单状态  009010: 已取消
     */
    public static final String BILL_STATE_009010 = "009010";


    /**
     * 订单状态  已发货
     */
    public static final String BILL_SALE_OUT_STATUS = "已发货";

    /**
     * 订单状态  已取消
     */
    public static final String BILL_SALE_OUT_CANCLE_STATUS = "已取消";

    /**
     * 订单状态  已包装
     */
    public static final String BILL_PACKAGE_STATUS = "已包装";

    /**
     * 销售出库
     */
    public static final String OUTTYPE_SALE_OUT = "002001";

    /**
     * 调拨出库
     */
    public static final String OUTTYPE_TRANSFER_OUT = "002002";

    /**
     * 残次品出库
     */
    public static final String OUTTYPE_DEFECTIVE_OUT = "002003";

    /**
     * 其它出库
     */
    public static final String OUTTYPE_OTHERS_OUT = "002004";


    /**
     * 服务器 -- 香港
     */
    public static final int SERVER_TYPE_1 = 1;


    /**
     * 服务器 -- 深圳
     */
    public static final int SERVER_TYPE_2 = 2;


    /**
     * 服务器 -- 广州
     */
    public static final int SERVER_TYPE_3 = 3;


    /**
     * 运费
     */
    public static final float FREIGHT = 0F;


    /**
     * 售价
     */
    public static final float SELLING_PRICE = 0F;


    /**
     * 折扣费
     */
    public static final float DISCOUNT_FEE = 0F;


    /**
     * 分销商佣金
     */
    public static final float DISTRIBUTOR_COMM = 0F;


    /**
     * 净重
     */
    public static final double NET_WEIGHT = 0D;


    /**
     * 毛重
     */
    public static final double GROSS_WEIGHT = 0D;


    /**
     * 库存单位
     */
    public static final String GOODS_UNIT = "件";


    /**
     * 订单商品-运费条目名称
     */
    public static final String FREIGHT_SKU_NAME = "运费+清关费";

    /**
     * 订单商品-运费条目数量
     */
    public static final int FREIGHT_SKU_NUMBER = 1;

    /**
     * 订单商品-运费条目条码
     */
    public static final String FREIGHT_SKU_BARCODE = "2016022200003";

    /**
     * shopee订单收货人姓名
     */
    public static final String SHOPEE_CONSIGNEE_NAME = "LWE";

    /**
     * shopee订单收货人电话
     */
    public static final String SHOPEE_CONSIGNEE_PHONE = "852-3421-1122";

    /**
     * shopee订单收货人地址
     */
    public static final String SHOPEE_CONSIGNEE_ADDRESS = "葵涌健康街15-23号泉基工业大厦4楼";

    /**
     * shopee订单收货人省
     */
    public static final String SHOPEE_CONSIGNEE_PROVINCE = "香港特别行政区";

    /**
     * shopee订单收货人市
     */
    public static final String SHOPEE_CONSIGNEE_CITY = "新界";

    /**
     * shopee订单收货人区
     */
    public static final String SHOPEE_CONSIGNEE_AREA = "葵青区";

    /**
     * shopee订单收货人邮编
     */
    public static final String SHOPEE_CONSIGNEE_POST_CODE = "852";

    /**
     * 推wms用的运费SKU虚拟条码
     */
    public static final String PUSH_WMS_FREIGHT_VIRTUAL_BARCODE = "2016022200003";

    /**
     * 推wms用的运费SKU品名
     */
    public static final String PUSH_WMS_FREIGHT_GOOD_NAME = "运费+清关费";
}

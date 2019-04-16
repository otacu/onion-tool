package com.egoist.oniontool.common.enums;

import com.egoist.parent.common.exception.EgoistException;
import com.egoist.parent.common.utils.json.EgoistJsonUtil;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class ThirdPlatformEnum {

    private ThirdPlatformEnum() {

    }

    /**
     * 定义Map
     */
    private static Map<Short, String> map = new LinkedHashMap<Short, String>();

    /**
     * OTHER
     */
    public static final short OTHER = 100;

    /**
     * ERP
     */
    public static final short ERP = 1;

    /**
     * 高捷
     */
    public static final short CARGO = 2;

    /**
     * 云达
     */
    public static final short YUNDA = 3;

    /**
     * 新银河世纪
     */
    public static final short DSP = 4;

    /**
     * 聚合
     */
    public static final short JUHE = 5;

    /**
     * 海豚
     */
    public static final short HAITUN = 6;


    /**
     * 德邦
     */
    public static final short DEPPON = 7;


    /**
     * 广州海关
     */
    public static final short GZHG = 8;


    /**
     * 杭州海关
     */
    public static final short HZHG = 9;


    /**
     * 通联支付
     */
    public static final short UNIONPAY = 10;

    /**
     * 宝付
     */
    public static final short BAOFU = 11;

    /**
     * ECMS
     */
    public static final short NEW_WMS = 12;


    /**
     * 深圳海关
     */
    public static final short SZHG = 13;

    /**
     * OMS
     */
    public static final short OMS = 14;

    /**
     * OMS
     */
    public static final short ONION = 15;

    /**
     * 金碟K3
     */
    public static final short K3 = 16;

    /**
     * 威时
     */
    public static final short WTD = 17;


    /**
     * 顺丰优选
     */
    public static final short SFHK = 18;

    /**
     * shopee
     */
    public static final short SHOPEE = 19;

    /**
     * Unixus
     */
    public static final short UNIXUS = 20;

    /**
     * NGC2024
     */
    public static final short NGC2024 = 21;

    /**
     * 海关总署
     */
    public static final short CUSTOMS = 22;

    /**
     * 优烁韵达快递
     */
    public static final short YOUSHUO = 23;

    /**
     * 环球易购
     */
    public static final short CHINABRANDS = 24;

    static {
        map = new LinkedHashMap<Short, String>();
        map.put(OTHER, "其它");
        map.put(ERP, "ERP");
        map.put(CARGO, "高捷");
        map.put(YUNDA, "云达");
        map.put(DSP, "新银河世纪");
        map.put(JUHE, "聚合数据");
        map.put(HAITUN, "海豚");
        map.put(DEPPON, "德邦");
        map.put(GZHG, "广州海关");
        map.put(HZHG, "杭州海关");
        map.put(UNIONPAY, "通联支付");
        map.put(BAOFU, "宝付");
        map.put(NEW_WMS, "ECMS");
        map.put(SZHG, "深圳海关");
        map.put(OMS, "OMS");
        map.put(ONION, "洋葱");
        map.put(K3, "金碟K3");
        map.put(WTD, "威时");
        map.put(SFHK, "顺丰优选");
        map.put(SHOPEE, "Shopee");
        map.put(UNIXUS, "LWE");
        map.put(NGC2024, "NGC2024");
        map.put(CUSTOMS, "海关总署");
        map.put(YOUSHUO, "优烁韵达快递");
        map.put(CHINABRANDS, "Chinabrands");
    }

    /**
     * 得到描述
     *
     * @param id 传入id
     * @return String
     */
    public static String getDescription(Short id) {
        return map.get(id);
    }

    /**
     * @return String
     */
    public static String toJson() {
        try {
            return EgoistJsonUtil.objectToJson(map);
        } catch (EgoistException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param ids 传入ids
     * @return String
     */
    public static String toJson(Short... ids) {
        Map<Integer, String> newMap = getMap(ids);
        try {
            return EgoistJsonUtil.objectToJson(newMap);
        } catch (EgoistException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @return Map
     */
    public static Map getMap() {
        return map;
    }

    /**
     * @param ids 传入ids
     * @return Map
     */
    public static Map getMap(Short... ids) {
        Map<Short, String> newMap = new LinkedHashMap<Short, String>(map);
        List<Short> keys = Arrays.asList(ids);
        newMap.keySet().retainAll(keys);

        return newMap;
    }
}

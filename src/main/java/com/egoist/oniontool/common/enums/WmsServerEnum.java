package com.egoist.oniontool.common.enums;

import com.egoist.parent.common.exception.EgoistException;
import com.egoist.parent.common.utils.json.EgoistJsonUtil;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class WmsServerEnum {

    private WmsServerEnum() {

    }

    /**
     * 定义Map
     */
    private static Map<Short, String> map = new LinkedHashMap<Short, String>();


    /**
     * 香港服务器
     */
    public static final Short HONG_KONG = 1;

    /**
     * 广州服务器
     */
    public static final Short GUANG_ZHOU = 2;


    static {
        map = new LinkedHashMap<Short, String>();
        map.put(HONG_KONG, "香港服务器");
        map.put(GUANG_ZHOU, "广州服务器");
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
        Map<Short, String> newMap = getMap(ids);
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

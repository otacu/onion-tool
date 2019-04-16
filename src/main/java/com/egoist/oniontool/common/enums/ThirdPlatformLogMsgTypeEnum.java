package com.egoist.oniontool.common.enums;

import com.egoist.parent.common.exception.EgoistException;
import com.egoist.parent.common.utils.json.EgoistJsonUtil;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class ThirdPlatformLogMsgTypeEnum {
    private ThirdPlatformLogMsgTypeEnum() {

    }

    /**
     * 定义Map
     */
    private static Map<Short, String> map = new LinkedHashMap<Short, String>();

    /**
     * 请求
     */
    public static final short REQUEST = 0;

    /**
     * 响应
     */
    public static final short RESPONSE = 1;

    /**
     * 回调
     */
    public static final short CALL_BACK = 2;

    static {
        map = new LinkedHashMap<Short, String>();
        map.put(REQUEST, "请求");
        map.put(RESPONSE, "响应");
        map.put(CALL_BACK, "回调");
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

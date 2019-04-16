package com.egoist.oniontool.common.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.egoist.parent.common.exception.EgoistException;

import java.util.List;
import java.util.TreeMap;

public final class ParseUtil {

    private ParseUtil() {

    }

    /**
     * 解析POJO为TreeMap
     *
     * @param object pojo
     * @return TreeMap<String, Object>
     * @throws EgoistException the ms onion exception
     */
    public static TreeMap<String, Object> parsePojoToMap(Object object) throws EgoistException {
        try {
            String jsonString = JSONObject.toJSONString(object, SerializerFeature.WriteNonStringKeyAsString);
            TreeMap<String, Object> params = JSONObject.parseObject(jsonString,
                    new TypeReference<TreeMap<String, Object>>() {
                    });
            return params;
        } catch (Exception e) {
            throw new EgoistException(e);
        }
    }

    /**
     * 解析JSONObject为POJO
     *
     * @param jsonObject jsonObject
     * @param clazz      clazz
     * @return Object
     * @throws EgoistException the ms onion exception
     */
    public static Object parseMapToPojo(JSONObject jsonObject, Class clazz) throws EgoistException {
        try {
            return JSONObject.parseObject(jsonObject.toJSONString(), clazz);
        } catch (Exception e) {
            throw new EgoistException(e);
        }
    }

    /**
     * 解析JSONObject为POJO
     *
     * @param jsonObjectStr jsonObjectStr
     * @param clazz         clazz
     * @return Object
     * @throws EgoistException the ms onion exception
     */
    public static Object parseMapToPojo(String jsonObjectStr, Class clazz) throws EgoistException {
        try {
            return JSONObject.parseObject(jsonObjectStr, clazz);
        } catch (Exception e) {
            throw new EgoistException(e);
        }
    }

    /**
     * 解析JSONArray为POJO List
     *
     * @param jsonArray jsonArray
     * @param clazz     clazz
     * @return Object
     * @throws EgoistException the ms onion exception
     */
    public static List parseMapToPojo(JSONArray jsonArray, Class clazz) throws EgoistException {
        try {
            return JSONObject.parseArray(jsonArray.toJSONString(), clazz);
        } catch (Exception e) {
            throw new EgoistException(e);
        }
    }

}

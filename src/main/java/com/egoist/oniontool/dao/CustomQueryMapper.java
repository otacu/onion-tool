package com.egoist.oniontool.dao;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * @Description: 自定义查询mapper
 */
public interface CustomQueryMapper {

    /**
     * 自定义sql查询
     *
     * @param sqlContent sql
     * @return map
     */
    List<LinkedHashMap<String, Object>> customQuery(String sqlContent);
}

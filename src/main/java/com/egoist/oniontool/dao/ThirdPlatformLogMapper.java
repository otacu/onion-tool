package com.egoist.oniontool.dao;

import com.egoist.oniontool.pojo.ThirdPlatformLog;
import com.egoist.oniontool.pojo.ThirdPlatformLogExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ThirdPlatformLogMapper {
    long countByExample(ThirdPlatformLogExample example);

    int deleteByExample(ThirdPlatformLogExample example);

    int insert(ThirdPlatformLog record);

    int insertSelective(ThirdPlatformLog record);

    List<ThirdPlatformLog> selectByExample(ThirdPlatformLogExample example);

    int updateByExampleSelective(@Param("record") ThirdPlatformLog record, @Param("example") ThirdPlatformLogExample example);

    int updateByExample(@Param("record") ThirdPlatformLog record, @Param("example") ThirdPlatformLogExample example);
}
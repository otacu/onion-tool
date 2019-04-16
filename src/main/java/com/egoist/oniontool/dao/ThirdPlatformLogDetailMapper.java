package com.egoist.oniontool.dao;

import com.egoist.oniontool.pojo.ThirdPlatformLogDetail;
import com.egoist.oniontool.pojo.ThirdPlatformLogDetailExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ThirdPlatformLogDetailMapper {
    long countByExample(ThirdPlatformLogDetailExample example);

    int deleteByExample(ThirdPlatformLogDetailExample example);

    int insert(ThirdPlatformLogDetail record);

    int insertSelective(ThirdPlatformLogDetail record);

    List<ThirdPlatformLogDetail> selectByExampleWithBLOBs(ThirdPlatformLogDetailExample example);

    List<ThirdPlatformLogDetail> selectByExample(ThirdPlatformLogDetailExample example);

    int updateByExampleSelective(@Param("record") ThirdPlatformLogDetail record, @Param("example") ThirdPlatformLogDetailExample example);

    int updateByExampleWithBLOBs(@Param("record") ThirdPlatformLogDetail record, @Param("example") ThirdPlatformLogDetailExample example);

    int updateByExample(@Param("record") ThirdPlatformLogDetail record, @Param("example") ThirdPlatformLogDetailExample example);
}
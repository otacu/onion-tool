package com.egoist.oniontool.pojo.elasticsearch;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.util.Date;


@Data
@Document(indexName = "index_third_platform_log", type = "type_third_platform_log")
public class ThridPlatformLogDetailDoc implements Serializable {
    @Id
    private Long id;

    private Long thirdLogIdxCode;

    // ThirdPlatformEnum
    private String platform;

    private String reqAction;

    private String actionCode;
    @Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_smart")
    private String msg;
    // 0：请求，1：响应，2：回调
    private String msgType;

    @Field(type = FieldType.Date, format = DateFormat.custom,pattern ="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern ="yyyy-MM-dd HH:mm:ss",timezone ="GMT+8")
    private Date createTime;
}

package com.egoist.oniontool.pojo.wms;

import lombok.Data;

import java.io.Serializable;

@Data
public class WmsRequest implements Serializable {

    private String method;

    private Short serverType;

    private String version;

    private String siteCode;
}

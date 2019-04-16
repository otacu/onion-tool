package com.egoist.oniontool.pojo.wms;

import java.io.Serializable;

public class Header implements Serializable {


    /**
     * 客户编码
     */
    private String customerCode;

    /**
     * 仓库代码
     */
    private String sitecode;

    /**
     * 数据
     */
    private String data;

    /**
     * 摘要信息
     */
    private String digest;

    /**
     * 时间戳
     */
    private Long timestamp;


    /**
     * 版本号
     */
    private String version;


    /**
     * 服务名
     */
    private String serviceBeanId;

    /**
     * 方法签名
     */
    private String method;


    /**
     * @return customerCode
     */
    public String getCustomerCode() {
        return customerCode;
    }

    /**
     * @param customerCode customerCode
     */
    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    /**
     * @return sitecode
     */
    public String getSitecode() {
        return sitecode;
    }

    /**
     * @param sitecode sitecode
     */
    public void setSitecode(String sitecode) {
        this.sitecode = sitecode;
    }

    /**
     * @return data
     */
    public String getData() {
        return data;
    }

    /**
     * @param data data
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * @return digest
     */
    public String getDigest() {
        return digest;
    }

    /**
     * @param digest digest
     */
    public void setDigest(String digest) {
        this.digest = digest;
    }

    /**
     * @return timestamp
     */
    public Long getTimestamp() {
        return timestamp;
    }

    /**
     * @param timestamp timestamp
     */
    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * @return version
     */
    public String getVersion() {
        return version;
    }

    /**
     * @param version version
     */
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * @return serviceBeanId
     */
    public String getServiceBeanId() {
        return serviceBeanId;
    }

    /**
     * @param serviceBeanId serviceBeanId
     */
    public void setServiceBeanId(String serviceBeanId) {
        this.serviceBeanId = serviceBeanId;
    }

    /**
     * @return method
     */
    public String getMethod() {
        return method;
    }

    /**
     * @param method method
     */
    public void setMethod(String method) {
        this.method = method;
    }
}

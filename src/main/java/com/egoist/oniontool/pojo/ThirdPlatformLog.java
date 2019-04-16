package com.egoist.oniontool.pojo;

import java.util.Date;

public class ThirdPlatformLog {
    private Long idx;

    private Long idxCode;

    private Short platformId;

    private String reqAction;

    private String actionCode;

    private String remark;

    private Integer retryTimes;

    private Short status;

    private Long version;

    private Long createByMemberIdx;

    private Long updateByMemberIdx;

    private Date createTime;

    private Date updateTime;

    private String ext;

    public Long getIdx() {
        return idx;
    }

    public void setIdx(Long idx) {
        this.idx = idx;
    }

    public Long getIdxCode() {
        return idxCode;
    }

    public void setIdxCode(Long idxCode) {
        this.idxCode = idxCode;
    }

    public Short getPlatformId() {
        return platformId;
    }

    public void setPlatformId(Short platformId) {
        this.platformId = platformId;
    }

    public String getReqAction() {
        return reqAction;
    }

    public void setReqAction(String reqAction) {
        this.reqAction = reqAction == null ? null : reqAction.trim();
    }

    public String getActionCode() {
        return actionCode;
    }

    public void setActionCode(String actionCode) {
        this.actionCode = actionCode == null ? null : actionCode.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getRetryTimes() {
        return retryTimes;
    }

    public void setRetryTimes(Integer retryTimes) {
        this.retryTimes = retryTimes;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Long getCreateByMemberIdx() {
        return createByMemberIdx;
    }

    public void setCreateByMemberIdx(Long createByMemberIdx) {
        this.createByMemberIdx = createByMemberIdx;
    }

    public Long getUpdateByMemberIdx() {
        return updateByMemberIdx;
    }

    public void setUpdateByMemberIdx(Long updateByMemberIdx) {
        this.updateByMemberIdx = updateByMemberIdx;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext == null ? null : ext.trim();
    }
}
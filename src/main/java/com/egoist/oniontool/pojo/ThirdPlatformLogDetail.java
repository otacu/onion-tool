package com.egoist.oniontool.pojo;

import java.util.Date;

public class ThirdPlatformLogDetail {
    private Long idx;

    private Long idxCode;

    private Long thirdLogIdxCode;

    private Short msgType;

    private String remark;

    private Short status;

    private Long version;

    private Long createByMemberIdx;

    private Long updateByMemberIdx;

    private Date createTime;

    private Date updateTime;

    private String ext;

    private String msg;

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

    public Long getThirdLogIdxCode() {
        return thirdLogIdxCode;
    }

    public void setThirdLogIdxCode(Long thirdLogIdxCode) {
        this.thirdLogIdxCode = thirdLogIdxCode;
    }

    public Short getMsgType() {
        return msgType;
    }

    public void setMsgType(Short msgType) {
        this.msgType = msgType;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg == null ? null : msg.trim();
    }
}
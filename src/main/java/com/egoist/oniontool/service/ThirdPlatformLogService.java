package com.egoist.oniontool.service;

import com.egoist.oniontool.common.constants.MessageConstants;
import com.egoist.oniontool.common.constants.OnionConstant;
import com.egoist.oniontool.common.enums.ThirdPlatformEnum;
import com.egoist.oniontool.common.enums.ThirdPlatformLogMsgTypeEnum;
import com.egoist.oniontool.dao.ThirdPlatformLogDetailMapper;
import com.egoist.oniontool.dao.ThirdPlatformLogMapper;
import com.egoist.oniontool.pojo.ThirdPlatformLog;
import com.egoist.oniontool.pojo.ThirdPlatformLogDetail;
import com.egoist.oniontool.pojo.ThirdPlatformLogDetailExample;
import com.egoist.oniontool.pojo.ThirdPlatformLogExample;
import com.egoist.oniontool.pojo.elasticsearch.ThridPlatformLogDetailDoc;
import com.egoist.parent.common.constants.EgoistResultStatusConstants;
import com.egoist.parent.pojo.dto.EgoistPagingResult;
import com.egoist.parent.pojo.dto.EgoistResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class ThirdPlatformLogService {
    /**
     * thirdPlatformLogMapper
     */
    @Autowired
    private ThirdPlatformLogMapper thirdPlatformLogMapper;

    /**
     * thirdPlatformLogMapper
     */
    @Autowired
    private ThirdPlatformLogDetailMapper thirdPlatformLogDetailMapper;

    private Logger log = LoggerFactory.getLogger(this.getClass());

    /**
     * 查询第三方日志数据，拼装成es的记录
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    public EgoistPagingResult queryThirdPlatformLogDoc(Integer pageNum, Integer pageSize) {
        EgoistPagingResult egoistPagingResult = new EgoistPagingResult();
        try {
            // 昨天的日志
            ThirdPlatformLogExample thirdPlatformLogExample = new ThirdPlatformLogExample();
            ThirdPlatformLogExample.Criteria thirdPlatformLogExampleCriteria = thirdPlatformLogExample.createCriteria();
            thirdPlatformLogExampleCriteria.andStatusEqualTo(OnionConstant.DATA_STATUS_AVAILABLE);
            thirdPlatformLogExampleCriteria.andCreateTimeBetween(this.getYestodayZero(), this.getTodayZero());
            PageHelper.startPage(pageNum, pageSize);
            List<ThirdPlatformLog> blogList = thirdPlatformLogMapper.selectByExample(thirdPlatformLogExample);
            PageInfo<ThirdPlatformLog> pageInfo = new PageInfo<ThirdPlatformLog>(blogList);

            List<ThridPlatformLogDetailDoc> docList = new ArrayList<>();
            for (ThirdPlatformLog thirdPlatformLog : blogList) {
                ThirdPlatformLogDetailExample thirdPlatformLogDetailExample = new ThirdPlatformLogDetailExample();
                ThirdPlatformLogDetailExample.Criteria thirdPlatformLogDetailExampleCriteria = thirdPlatformLogDetailExample.createCriteria();
                thirdPlatformLogDetailExampleCriteria.andStatusEqualTo(OnionConstant.DATA_STATUS_AVAILABLE);
                thirdPlatformLogDetailExampleCriteria.andThirdLogIdxCodeEqualTo(thirdPlatformLog.getIdxCode());
                List<ThirdPlatformLogDetail> detailList = thirdPlatformLogDetailMapper.selectByExampleWithBLOBs(thirdPlatformLogDetailExample);
                for (ThirdPlatformLogDetail detail : detailList) {
                    ThridPlatformLogDetailDoc doc = new ThridPlatformLogDetailDoc();
                    doc.setId(detail.getIdxCode());
                    doc.setThirdLogIdxCode(thirdPlatformLog.getIdxCode());
                    doc.setPlatform(ThirdPlatformEnum.getDescription(thirdPlatformLog.getPlatformId()));
                    doc.setReqAction(thirdPlatformLog.getReqAction());
                    doc.setActionCode(thirdPlatformLog.getActionCode());
                    doc.setMsg(detail.getMsg());
                    doc.setMsgType(ThirdPlatformLogMsgTypeEnum.getDescription(detail.getMsgType()));
                    doc.setCreateTime(detail.getCreateTime());
                    docList.add(doc);
                }
            }
            egoistPagingResult.setPageNum(pageInfo.getPageNum());
            egoistPagingResult.setPageSize(pageInfo.getPageSize());
            egoistPagingResult.setTotalCount(pageInfo.getTotal());
            egoistPagingResult.setTotalPageNum(pageInfo.getPages());
            egoistPagingResult.setFirstPage(pageInfo.isIsFirstPage());
            egoistPagingResult.setLastPage(pageInfo.isIsLastPage());
            egoistPagingResult.setHasPrePage(pageInfo.isHasPreviousPage());
            egoistPagingResult.setHasNextPage(pageInfo.isHasNextPage());
            egoistPagingResult.setPrePage(pageInfo.getPrePage());
            egoistPagingResult.setNextPage(pageInfo.getNextPage());
            egoistPagingResult.setStatus(EgoistResultStatusConstants.STATUS_200);
            egoistPagingResult.setData(docList);
        } catch (Exception e) {
            egoistPagingResult.setStatus(EgoistResultStatusConstants.STATUS_400);
            egoistPagingResult.setMsg("查询第三方日志数据异常");
            log.error(String.format(MessageConstants.QUERY_THIRD_PLATFORM_LOG_DOC_ERROR, e.getMessage()), e);
        }
        return egoistPagingResult;
    }

    /**
     * 查询日志总页数
     * @param pageSize 页大小
     * @return
     */
    public EgoistResult queryTotalPage(Integer pageSize) {
        try {
            // 昨天的日志
            ThirdPlatformLogExample thirdPlatformLogExample = new ThirdPlatformLogExample();
            ThirdPlatformLogExample.Criteria thirdPlatformLogExampleCriteria = thirdPlatformLogExample.createCriteria();
            thirdPlatformLogExampleCriteria.andStatusEqualTo(OnionConstant.DATA_STATUS_AVAILABLE);
            thirdPlatformLogExampleCriteria.andCreateTimeBetween(this.getYestodayZero(), this.getTodayZero());
            long totalCount = thirdPlatformLogMapper.countByExample(thirdPlatformLogExample);
            int totalPage = (int) Math.ceil(totalCount * 1.0 / pageSize);
            return EgoistResult.ok(totalPage);
        } catch (Exception e) {
            return new EgoistResult(EgoistResultStatusConstants.STATUS_400, "查询总页数异常", 0);
        }
    }

    /**
     * 昨天零点
     * @return
     */
    private Date getYestodayZero() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.add(Calendar.DAY_OF_YEAR,-1);
        return calendar.getTime();
    }

    /**
     * 今天零点
     * @return
     */
    private Date getTodayZero() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }
}

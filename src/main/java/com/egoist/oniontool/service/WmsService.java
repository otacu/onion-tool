package com.egoist.oniontool.service;

import com.alibaba.fastjson.JSONObject;
import com.egoist.oniontool.common.constant.OnionConstant;
import com.egoist.oniontool.common.constant.WmsConstant;
import com.egoist.oniontool.common.constant.WmsParamConstant;
import com.egoist.oniontool.common.constant.WmsPathConstant;
import com.egoist.oniontool.common.enums.WmsServerEnum;
import com.egoist.oniontool.common.util.MD5Util;
import com.egoist.oniontool.common.util.ParseUtil;
import com.egoist.oniontool.pojo.wms.Header;
import com.egoist.oniontool.pojo.wms.QueryTypeStockRequest;
import com.egoist.oniontool.pojo.wms.WmsRequest;
import com.egoist.parent.common.constants.EgoistResultStatusConstants;
import com.egoist.parent.common.exception.EgoistException;
import com.egoist.parent.common.utils.http.EgoistOkHttp3Util;
import com.egoist.parent.common.utils.string.EgoistStringUtil;
import com.egoist.parent.pojo.dto.EgoistResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.TreeMap;

/**
 * wms接口
 */
@Service
public class WmsService {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    /**
     * 根据条码查询库存
     * @param request
     * @return
     */
    public EgoistResult querySkuStock(QueryTypeStockRequest request) {
        try {
            request.setCuscode(WmsParamConstant.CUSTOMER_CODE);
            request.setOuttype(WmsConstant.SALE_OUT_TYPE_002001);
            String domainUrl = WmsParamConstant.HK_DOMAIN_URL;
            if (WmsServerEnum.GUANG_ZHOU.equals(request.getServerType())) {
                domainUrl = WmsParamConstant.GZ_DOMAIN_URL;
            }
            TreeMap<String, Object> paramMap = signMap(request);
            JSONObject returnObject = null;
            log.info(String.format("请求报文：%s", JSONObject.toJSONString(paramMap)));
            try {
                returnObject = EgoistOkHttp3Util.postFormBody(domainUrl, paramMap);
                log.info(String.format("响应报文：%s", returnObject.toJSONString()));
            } catch (Exception e) {
                throw new EgoistException("请求失败");
            }
            return EgoistResult.ok();
        } catch (EgoistException e) {
            return new EgoistResult(EgoistResultStatusConstants.STATUS_400, e.getMessage(), null);
        }
    }

    protected TreeMap<String, Object> signMap(WmsRequest request)
            throws EgoistException {
        String jsonEncoding = JSONObject.toJSONString(request);
        Long timestamp = System.currentTimeMillis();
        Header header = new Header();
        header.setData(jsonEncoding);
        // MD5Util.code32(jsonEncoding + appsecret + timestamp,null);
        String md5String = MD5Util.string2MD5(jsonEncoding + WmsParamConstant.SECRET + timestamp);
        String digest = null;
        try {
            digest = new String(java.util.Base64.getEncoder().encode(md5String.getBytes(OnionConstant
                    .CHARSET_UTF8)), OnionConstant.CHARSET_UTF8);
        } catch (UnsupportedEncodingException e) {
            throw new EgoistException("编码错误");
        }
        header.setDigest(digest);
        header.setTimestamp(timestamp);
        header.setCustomerCode(WmsParamConstant.CUSTOMER_CODE);
        String sitecode = request.getSiteCode();
        if (request.getServerType().shortValue() == WmsServerEnum.GUANG_ZHOU.shortValue()
                && EgoistStringUtil.isEmpty(sitecode)) {
            sitecode = WmsParamConstant.GZ_SITECODE;
        } else if (request.getServerType().shortValue() == WmsServerEnum.HONG_KONG.shortValue()
                && EgoistStringUtil.isEmpty(sitecode)) {
            sitecode = WmsParamConstant.HK_SITECODE;
        }
        header.setSitecode(sitecode);
        header.setVersion(request.getVersion());
        header.setServiceBeanId(WmsPathConstant.SERVICE_BEAN_ID);
        header.setMethod(request.getMethod());
        TreeMap<String, Object> map = ParseUtil.parsePojoToMap(header);
        return map;
    }
}

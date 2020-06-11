/**
 * 广州市两棵树网络科技有限公司版权所有
 * DT Group Technology & commerce Co., LtdAll rights reserved.
 * <p>
 * 广州市两棵树网络科技有限公司，创立于2009年。旗下运营品牌洋葱小姐。
 * 洋葱小姐（Ms.Onion） 下属三大业务模块 [洋葱海外仓] , [洋葱DSP] , [洋葱海外聚合供应链]
 * [洋葱海外仓]（DFS）系中国海关批准的跨境电商自营平台(Cross-border ecommerce platform)，
 * 合法持有海外直邮保税模式的跨境电商营运资格。是渠道拓展，平台营运，渠道营运管理，及客户服务等前端业务模块。
 * [洋葱DSP]（DSP）系拥有1.3亿消费者大数据分析模型。 是基于客户的消费行为，消费轨迹，及多维度云算法(MDPP)
 * 沉淀而成的精准消费者模型。洋葱DSP能同时为超过36种各行业店铺 及200万个销售端口
 * 进行多店铺高精度配货，并能预判消费者购物需求进行精准推送。同时为洋葱供应链提供更前瞻的商品采买需求模型 。
 * [洋葱海外聚合供应链]（Super Supply Chain）由中国最大的进口贸易集团共同
 * 合资成立，拥有20余年的海外供应链营运经验。并已入股多家海外贸易企业，与欧美澳等9家顶级全球供应商达成战略合作伙伴关系。
 * 目前拥有835个国际品牌直接采买权，12万个单品的商品供应库。并已建设6大海外直邮仓库，为国内客户提供海外商品采买集货供应，
 * 跨境 物流，保税清关三合一的一体化模型。目前是中国唯一多模式聚合的海外商品供应链 。
 * <p>
 * 洋葱商城：http://m.msyc.cc/wx/indexView?tmn=1
 * <p>
 * 洋桃商城：http://www.yunyangtao.com
 */
package com.egoist.oniontool.common.util;
/**
 * @Title: Test3
 * @Package: com.egoist.oniontool.service
 * @Description:
 * @Company: 广州市两棵树网络科技有限公司
 * @Author: JingshengYe jingsheng-ye@msyc.cc
 * @Date: 2020年06月11日 10:38:12
 * @Version: V2.1.5
 * @Modify-by: JingshengYe jingsheng-ye@msyc.cc
 * @Modify-date: 2020年06月11日 10:38:12
 * @Modify-version: 2.1.5
 * @Modify-description: 新增
 */

import com.gargoylesoftware.htmlunit.*;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.Pipeline;
import com.itextpdf.tool.xml.XMLWorker;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import com.itextpdf.tool.xml.css.CssFilesImpl;
import com.itextpdf.tool.xml.css.StyleAttrCSSResolver;
import com.itextpdf.tool.xml.html.CssAppliersImpl;
import com.itextpdf.tool.xml.html.HTML;
import com.itextpdf.tool.xml.html.TagProcessorFactory;
import com.itextpdf.tool.xml.html.Tags;
import com.itextpdf.tool.xml.parser.XMLParser;
import com.itextpdf.tool.xml.pipeline.css.CssResolverPipeline;
import com.itextpdf.tool.xml.pipeline.end.PdfWriterPipeline;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipeline;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipelineContext;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;

/**
 * @ClassName: Test3
 * @Description:
 * @Company: 广州市两棵树网络科技有限公司
 * @Author: JingshengYe jingsheng-ye@msyc.cc
 * @Date: 2020年06月11日 10:38:12
 */
public class TestHtml2PDF {
    public static void main(String[] args) {
        WebClient wc = new WebClient(BrowserVersion.CHROME);

        wc.getOptions().setUseInsecureSSL(true);
        wc.getOptions().setJavaScriptEnabled(true); // 启用JS解释器，默认为true
        wc.getOptions().setCssEnabled(true); // 禁用css支持
        wc.getOptions().setThrowExceptionOnScriptError(false); // js运行错误时，是否抛出异常
        wc.getOptions().setTimeout(100000); // 设置连接超时时间 ，这里是10S。如果为0，则无限期等待
        wc.getOptions().setDoNotTrackEnabled(false);
//        wc.getOptions().setActiveXNative(true);
        HtmlPage page;
        try {
            byte[] responseContent = null;
            URL url = new URL("https://erp112.tongtool.com/file/047081/logisticAddressLabel/2020-06-04/P010337.html");
            WebRequest webRequest = new WebRequest(url, HttpMethod.POST);
            webRequest.setCharset("utf-8");
            page = wc.getPage(webRequest);
            WebResponse webResponse = page.getWebResponse();
            int status = webResponse.getStatusCode();
            // 读取数据内容
            if (status==200) {
                if (page.isHtmlPage()) {
                    // 等待JS执行完成，包括远程JS文件请求，Dom处理
                    wc.waitForBackgroundJavaScript(10000);
                    responseContent = ((HtmlPage) page).asXml().getBytes();
                } else {
                    InputStream bodyStream = webResponse.getContentAsStream();
                    responseContent = inputStream2byte(bodyStream);
                    bodyStream.close();
                }
            }
            // 关闭响应流
            webResponse.cleanUp();
            String strToHtml = new String(responseContent);
            strToHtml = strToHtml.replace("<?xml version=\"1.0\" encoding=\"UTF-8\"?>", "");
            strToHtml = strToHtml.replace("<head/>","<head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"></meta></head>");
            // 调整宽度
            strToHtml = strToHtml.replace("width: 500px","width: 700px");
            strToHtml = strToHtml.replace("Lazada Firstmile Tracking Number","Lazada Firstmile Tracking Number<br/>");

            html2pdf(strToHtml, "E:\\hello-world.pdf");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 功能描述:
     *
     * @param inputStream 输入流
     * @return byte[] 数组
     * @author xiaobu
     * @date 2019/3/28 16:03
     * @version 1.0
     */
    public static byte[] inputStream2byte(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {

            byte[] buff = new byte[100];
            int rc = 0;
            while ((rc = inputStream.read(buff, 0, 100)) > 0) {
                byteArrayOutputStream.write(buff, 0, rc);
            }
            return byteArrayOutputStream.toByteArray();
        } finally {
            byteArrayOutputStream.close();
        }
    }

    public static void html2pdf(String html, String filePath) throws Exception {
            // step 1
            Document document = new Document();
            BaseFont bfChinese;

            bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", false);
            MyFontProvider myFontProvider = new MyFontProvider(BaseColor.BLACK, "", "", false, false, 16, 1, bfChinese);

            // step 2
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filePath));
            // step 3
            document.open();

            final TagProcessorFactory tagProcessorFactory = Tags.getHtmlTagProcessorFactory();
            tagProcessorFactory.removeProcessor(HTML.Tag.IMG);
            tagProcessorFactory.addProcessor(new ImageTagProcessor(), HTML.Tag.IMG);

            final CssFilesImpl cssFiles = new CssFilesImpl();
            cssFiles.add(XMLWorkerHelper.getInstance().getDefaultCSS());
            final StyleAttrCSSResolver cssResolver = new StyleAttrCSSResolver(cssFiles);
            final HtmlPipelineContext hpc = new HtmlPipelineContext(new CssAppliersImpl(myFontProvider));
            hpc.setAcceptUnknown(true).autoBookmark(true).setTagFactory(tagProcessorFactory);
            final HtmlPipeline htmlPipeline = new HtmlPipeline(hpc, new PdfWriterPipeline(document, writer));
            final Pipeline<?> pipeline = new CssResolverPipeline(cssResolver, htmlPipeline);

            final XMLWorker worker = new XMLWorker(pipeline, true);

            final Charset charset = Charset.forName("UTF-8");
            final XMLParser xmlParser = new XMLParser(true, worker, charset);

            ByteArrayInputStream bais = new ByteArrayInputStream(html.getBytes("UTF-8"));
            xmlParser.parse(bais, charset);

            // step 5
            document.close();
            bais.close();

    }
}

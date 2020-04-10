package com.sygs;

import com.sygs.pojo.mysql.kyfkplmt.Kyfkplmt;
import com.sygs.pojo.mysql.salenotesmt.SaleNotesMt;
import com.sygs.service.mysql.kyfkplmt.KyfkplmtService;
import com.sygs.utils.XMLUtil;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest(classes = KysyApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class KysyApplicationTests {
    //http://116.54.19.107:9555/webService/erpKyfkplmt/?wsdl
    //http://192.168.9.93/services/HrmService?wsdl
    @Test//动态调用
    public void contextLoads() {
        //创建动态客户端
        JaxWsDynamicClientFactory factory = JaxWsDynamicClientFactory.newInstance();
        Client client = factory.createClient("http://kyoa.kpc.com.cn/services/HrmService?wsdl");
        // 需要密码的情况需要加上用户名和密码
       // client.getOutInterceptors().add(new ClientLoginInterceptor("admin","123456"));
        HTTPClientPolicy httpClientPolicy = new HTTPClientPolicy();
        httpClientPolicy.setConnectionTimeout(20000);  //连接超时
        httpClientPolicy.setAllowChunking(false);    //取消块编码
        httpClientPolicy.setReceiveTimeout(120000);     //响应超时
        HTTPConduit conduit = (HTTPConduit) client.getConduit();
        conduit.setClient(httpClientPolicy);
        //client.getOutInterceptors().addAll(interceptors);//设置拦截器
        try {
            Object[] objects = new Object[0];
            // invoke("方法名",参数1,参数2,参数3....);
            objects = client.invoke("checkUser","http://kyoa.kpc.com.cn","15987192713","1");
            System.err.println(objects[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test//动态调用
    public void contextLoads1() {
        //创建动态客户端
        JaxWsDynamicClientFactory factory = JaxWsDynamicClientFactory.newInstance();
        Client client = factory.createClient("http://116.54.19.107:9555/webService/erpKyfkplmt/?wsdl");
        // 需要密码的情况需要加上用户名和密码
        // client.getOutInterceptors().add(new ClientLoginInterceptor("admin","123456"));
        HTTPClientPolicy httpClientPolicy = new HTTPClientPolicy();
        httpClientPolicy.setConnectionTimeout(20000);  //连接超时
        httpClientPolicy.setAllowChunking(false);    //取消块编码
        httpClientPolicy.setReceiveTimeout(120000);     //响应超时
        HTTPConduit conduit = (HTTPConduit) client.getConduit();
        conduit.setClient(httpClientPolicy);
        //client.getOutInterceptors().addAll(interceptors);//设置拦截器
        try {
            Object[] objects = new Object[0];
            // invoke("方法名",参数1,参数2,参数3....);
            objects = client.invoke("list");
            System.err.println(objects[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test   //静态调用
    public void testWebService() {
        try {
            // 接口地址
            String address = "http://116.54.19.107:9555/webService/erpKyfkplmt/?wsdl";
            // 代理工厂
            JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
            // 设置代理地址
            jaxWsProxyFactoryBean.setAddress(address);
            // 设置接口类型
            jaxWsProxyFactoryBean.setServiceClass(KyfkplmtService.class);
            // 创建一个代理接口实现
            KyfkplmtService cs = (KyfkplmtService) jaxWsProxyFactoryBean.create();

            // 调用代理接口的方法调用并返回结果
            List<Kyfkplmt> list = cs.list();
            System.out.println("返回结果:" + list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testBeanToXml() {
        List<SaleNotesMt> saleNotesMtList = new ArrayList<>();
        SaleNotesMt saleNotesMt = new SaleNotesMt();
        saleNotesMt.setEntid("dsdas");
        saleNotesMt.setBillno("xcxcxaa");
        saleNotesMt.setBusinessname("哈哈哈");
        saleNotesMt.setStatus(false);
        String s = XMLUtil.convertBeanToXml(saleNotesMt);
        System.out.println(s);
    }

    @Test
    public void testStringToXml() {
        String str = "<SaleNotesMt>\n" +
                "    <billno>xcxcxaa</billno>\n" +
                "    <entid>dsdas</entid>\n" +
                "    <status>false</status>\n" +
                "    <businessname>哈哈哈</businessname>\n" +
                "</SaleNotesMt>";
        SaleNotesMt o = (SaleNotesMt) XMLUtil.convertXmlStrToBean(SaleNotesMt.class, str);
        System.err.println(o);
    }
}

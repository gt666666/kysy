package com.sygs;
import com.sygs.controller.mysql.hrmuserinfo.HrmuserinfoController;
import com.sygs.pojo.mysql.hrmuserinfo.Hrmuserinfo;
import com.sygs.pojo.mysql.salenotesmt.SaleNotesMt;
import com.sygs.service.mysql.hrmuserinfo.HrmuserinfoService;
import com.sygs.utils.XMLUtil;
import oaHrClient.*;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest(classes = KysyApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class KysyApplicationTests {
    //http://116.54.19.107:9555/webService/erpKyfkplmt/?wsdl
    //http://192.168.9.93/services/HrmService?wsdl
    @Resource
   public  HrmuserinfoController   hrmuserinfoController;
    @Resource
   public   HrmuserinfoService hrmuserinfoService;
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
            objects = client.invoke("getHrmUserInfo", "116.249.242.169", "", "", "", "", "");
            System.err.println(objects[0]);

            // DomParse.element(objects[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test//动态调用
    public void contextLoads1() {
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
            objects = client.invoke("checkUser", "116.249.242.169", "15987192713", "1");
            System.err.println(objects[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void testBeanToXml() {

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

    @Test
    public void testString() {
        HrmService hrmService= new HrmService();
        HrmServicePortType hrmServiceHttpPort = hrmService.getHrmServiceHttpPort();
        ArrayOfUserBean hrmUserInfo = hrmServiceHttpPort.getHrmUserInfo("116.249.242.169", "", "1012", "", "", "");
        List<UserBean> userBeans = hrmUserInfo.getUserBean();
        System.err.println("总数"+userBeans.size());
        for(UserBean  userBean:userBeans  ){
            System.err.println(userBean.getUserid().intValue());
            System.err.println(userBean.getLastname());
            System.err.println(userBean.getDepartmentid().getValue());
        }
    }
    @Test
    public void  testHrmJobTitleInfo(){
        HrmService hrmService= new HrmService();
        HrmServicePortType hrmServiceHttpPort = hrmService.getHrmServiceHttpPort();
        ArrayOfJobTitleBean arrayOfJobTitleBean = hrmServiceHttpPort.getHrmJobTitleInfo("116.249.242.169", "1012", "1063");
        List<JobTitleBean> jobTitleBeans = arrayOfJobTitleBean.getJobTitleBean();
        for (JobTitleBean  jobTitleBean:jobTitleBeans){
            System.err.println(jobTitleBean.getDepartmentid());
            System.err.println(jobTitleBean.getFullname());
        }

    }
    @Test
    public  void testHruserInfo(){
        Hrmuserinfo hrmuserinfo=new Hrmuserinfo();
        this.hrmuserinfoService.insertSelective();
    }

}

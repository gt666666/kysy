package com.sygs.config.webServiceConfig;
import com.sygs.service.mysql.creditadjmt.CreditAdjMtService;
import com.sygs.service.mysql.goodsfirstnew.GoodsFirstNewService;
import com.sygs.service.mysql.kndxy.KndxyService;
import com.sygs.service.mysql.kplfkmt.KPlfkmtService;
import com.sygs.service.mysql.kxsflxymt.KxsflxymtService;
import com.sygs.service.mysql.kyfkplmt.KyfkplmtService;
import com.sygs.service.mysql.salenotesmt.SaleNotesMtService;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.xml.ws.Endpoint;

@Configuration
public class WebServiceConfig {

    @Bean
    public ServletRegistrationBean dispatcherServlets(){

        return new ServletRegistrationBean(new CXFServlet(),"/webservice/*");//发布服务名称
    }
    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
        return new SpringBus();
    }

    @Bean
    public Endpoint saleNotesMtEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(this.springBus(), new SaleNotesMtService());
        endpoint.publish("/saleNotesMt");   //销售调价开票单
       // endpoint.getInInterceptors().add(new AuthInterceptor());
        return endpoint;
    }

    @Bean
    public Endpoint creditAdjMtendpoint() {
        EndpointImpl endpoint = new EndpointImpl(this.springBus(), new CreditAdjMtService());
        endpoint.publish("/creditAdjMt");    //信贷申请
        return endpoint;
    }
    @Bean
    public Endpoint kyfkplmtendpoint() {
        EndpointImpl endpoint = new EndpointImpl(this.springBus(), new KyfkplmtService());
        endpoint.publish("/kyfkplmt");    //预付款申请汇总单
        return endpoint;
    }
    @Bean
    public Endpoint kplfkmtendpoint() {
        EndpointImpl endpoint = new EndpointImpl(this.springBus(), new KPlfkmtService());
        endpoint.publish("/kplfkmt");    //正常付款汇总单
        return endpoint;
    }

    @Bean
    public Endpoint kxsflxymtendpoint() {
        EndpointImpl endpoint = new EndpointImpl(this.springBus(), new KxsflxymtService());
        endpoint.publish("/kxsflxymt");    //销售返利协议
        return endpoint;
    }

    @Bean
    public Endpoint kndxyendpoint() {
        EndpointImpl endpoint = new EndpointImpl(this.springBus(), new KndxyService());
        endpoint.publish("/kndxy");    //年度协议
        return endpoint;
    }
    @Bean
    public Endpoint goodsFirstNewendpoint() {
        EndpointImpl endpoint = new EndpointImpl(this.springBus(), new GoodsFirstNewService());
        endpoint.publish("/goodsFirstNew");    //首营商品
        return endpoint;
    }




}

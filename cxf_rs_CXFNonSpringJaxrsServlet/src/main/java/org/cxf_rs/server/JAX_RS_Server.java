package org.cxf_rs.server;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.jakarta.rs.json.JacksonJsonProvider;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.cxf_rs.service.LicensePublicService;
import org.cxf_rs.service.LicenseServiceImpl;



public class JAX_RS_Server {
    public static void main(String[] args) {
        // 创建业务接口实现类对象
        LicensePublicService licService = (LicensePublicService) new LicenseServiceImpl();
        // 服务器FactoryBean创建服务
        JAXRSServerFactoryBean restServer = new JAXRSServerFactoryBean();
        //restServer.setResourceClasses(org.cxf_rs.domain.IsUserLicensedParam.class, org.cxf_rs.domain.IsUserLicensedResult.class, org.cxf_rs.domain.GetVersionResult.class);
        restServer.setServiceBean(licService);
        restServer.setAddress("http://localhost:40000/");
        JacksonJsonProvider jacksonProvider = new JacksonJsonProvider();

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
        mapper.enable(DeserializationFeature.UNWRAP_ROOT_VALUE);
        jacksonProvider.setMapper(mapper);

        restServer.setProvider(jacksonProvider);
        // 打印日志
        restServer.getInInterceptors().add(new LoggingInInterceptor());
        restServer.getOutInterceptors().add(new LoggingOutInterceptor());
        // 发布服务
        restServer.create();
        System.out.println("服务器启动成功！");
    }

}
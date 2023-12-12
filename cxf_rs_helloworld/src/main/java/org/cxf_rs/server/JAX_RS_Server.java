package org.cxf_rs.server;

import com.fasterxml.jackson.jakarta.rs.json.JacksonJsonProvider;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.cxf_rs.domain.Car;
import org.cxf_rs.domain.User;
import org.cxf_rs.service.IUserService;
import org.cxf_rs.service.UserServiceImpl;



public class JAX_RS_Server {
    public static void main(String[] args) {
        // 创建业务接口实现类对象
        IUserService userService = new UserServiceImpl();
        // 服务器FactoryBean创建服务
        JAXRSServerFactoryBean restServer = new JAXRSServerFactoryBean();
        restServer.setResourceClasses(User.class, Car.class);
        restServer.setServiceBean(userService);
        restServer.setAddress("http://localhost:9999/");
        JacksonJsonProvider jacksonProvider = new JacksonJsonProvider();
        restServer.setProvider(jacksonProvider);
        // 打印日志
        restServer.getInInterceptors().add(new LoggingInInterceptor());
        restServer.getOutInterceptors().add(new LoggingOutInterceptor());
        // 发布服务
        restServer.create();
        System.out.println("服务器启动成功！");
    }
}
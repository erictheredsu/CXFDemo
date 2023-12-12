package org.cxf_rs.server;

import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import org.apache.catalina.*;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.core.StandardEngine;
import org.apache.catalina.core.StandardHost;
import org.apache.catalina.core.StandardWrapper;
import org.apache.catalina.startup.Tomcat;
import org.apache.cxf.jaxrs.servlet.CXFNonSpringJaxrsServlet;

import java.io.File;
import java.util.Enumeration;

public class TomcatBootStrap {
    public static final String INDEX_PATH_PROP = "index.path";
    public static final int PORT = 40000;
    public static void main(String[] args) throws LifecycleException {
        //这是cxf 的CXFNonSpringJaxrsServlet的实现,跟license Server 里的一样
        //参考:https://juejin.cn/post/6972168311949754399
        Tomcat tomcat = new Tomcat();
        // 看源码发现,他只能设置一个service,直接拿默认的
        Service service = tomcat.getService();

        // 创建连接器,并且添加对应的连接器,同时连接器指定端口
        Connector connector = new Connector();
        connector.setPort(PORT);
        service.addConnector(connector);

        // 创建一个引擎,放入service中
        Engine engine = new StandardEngine();
        service.setContainer(engine);
        engine.setDefaultHost("localhost");
        engine.setName("myEmbededTomcat");

        // 添加host
        Host host = new StandardHost();
        engine.addChild(host);
        host.setName("localhost");

        String workspace = System.getProperty("user.dir");
        String webapp = new File(workspace,"src/main/webapp").getPath();

        // 在对应的host下面创建一个 context 并制定他的工作路径,会加载该目录下的所有class文件,或者静态文件
        tomcat.getHost().setAppBase("webapp"); //host.setAppBase("webapps");?
        StandardContext context = (StandardContext) tomcat.addContext(host, "/", webapp);

        // 创建一个servlet
        Wrapper wrapper = new StandardWrapper();
        wrapper.setServlet(new MyServlet());
        wrapper.setName("myServlet");
        // 把servlet加入到contxt中
        context.addChild(wrapper);
        // 这里注意,要先添加到contxt中在映射路径,不然会空指针
        //http://localhost:40000/web1
        wrapper.addMapping("/web1");

        Wrapper cxf_wrapper = new StandardWrapper();
        cxf_wrapper.setName("CXFNonSpringJaxrsServlet");
        cxf_wrapper.setServletClass(CXFNonSpringJaxrsServlet.class.getName());
        //cxf_wrapper.setServlet(new CXFNonSpringJaxrsServlet());
        cxf_wrapper.addInitParameter("jakarta.ws.rs.Application", "org.cxf_rs.server.CXFApplication");
        context.addChild(cxf_wrapper);
        //这里要写/mytest , /license 的path 处理在LicensePublicService的 @Path 里处理
        //http://localhost:40000/mytest/license/GetVersion
        cxf_wrapper.addMapping("/mytest/*");
        cxf_wrapper.setLoadOnStartup(1);

        //tomcat启动
        tomcat.start();
        System.out.println("tomcat 服务器启动成功！");
        //保持主线程不退出
        tomcat.getServer().await();

    }
}
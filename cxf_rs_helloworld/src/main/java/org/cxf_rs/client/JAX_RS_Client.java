package org.cxf_rs.client;

import jakarta.ws.rs.core.MediaType;
import org.apache.cxf.jaxrs.client.WebClient;
import org.cxf_rs.domain.User;
import org.junit.Test;

public class JAX_RS_Client {

    // 测试新增
    @Test
    public void test_save(){
        /**
         * create ：建立与调用服务资源路径连接
         * path ：访问服务器的路径--->@Path
         * type ：发送给服务器数据格式--->@Consumes
         * accept ：接收服务器传输数据格式--->@Produces
         */
        User user = new User();
        user.setId(3);
        user.setUsername("小美");
        user.setCity("深圳");
        WebClient.create("http://localhost:9999/").path("userService/user").type(MediaType.APPLICATION_JSON).post(user);
    }
}

package org.cxf_rs.service;

import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;

import org.cxf_rs.domain.User;


@Path("/userService")
@Produces("*/*")
public interface IUserService {
    //增
    @POST
    @Path("/user")
    @Consumes({ "application/xml", "application/json" })
    public void saveUser(User user);
    //删
    @DELETE
    @Path("/user/{id}")
    @Consumes("application/xml")
    public void deleteUser(@PathParam("id") Integer id);
    //改
    @PUT
    @Path("/user")
    @Consumes({ "application/xml", "application/json" })
    public void updateUser(User user);
    //查-查询所有
    @GET
    @Path("/user")
    @Produces({ "application/xml", "application/json" })
    public List<User> findAllUsers();
    //查-根据id查询
    @GET
    @Path("/user/{id}")
    @Consumes("application/xml")
    @Produces({ "application/xml", "application/json" })
    public User finUserById(@PathParam("id") Integer id);
}

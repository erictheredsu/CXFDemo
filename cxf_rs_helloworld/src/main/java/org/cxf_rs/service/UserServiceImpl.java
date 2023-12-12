package org.cxf_rs.service;

import java.util.ArrayList;
import java.util.List;

import org.cxf_rs.domain.Car;
import org.cxf_rs.domain.User;


public class UserServiceImpl implements IUserService {
    //增
    public void saveUser(User user) {
        System.out.println("save user:" + user);
    }
    //删
    public void deleteUser(Integer id) {
        System.out.println("delete user id :" + id);
    }
    //改
    public void updateUser(User user) {
        System.out.println("update user:" + user);
    }
    //查-查询所有
    public List<User> findAllUsers() {
        List<User> users = new ArrayList<User>();
        User user1 = new User();
        user1.setId(1);
        user1.setUsername("小明");
        user1.setCity("北京");

        List<Car> carList1 = new ArrayList<Car>();
        Car car1 = new Car();
        car1.setId(101);
        car1.setCarName("保时捷");
        car1.setPrice(1000000d);
        carList1.add(car1);
        Car car2 = new Car();
        car2.setId(102);
        car2.setCarName("宝马");
        car2.setPrice(400000d);
        carList1.add(car2);
        user1.setCars(carList1);

        users.add(user1);

        User user2 = new User();
        user2.setId(2);
        user2.setUsername("小丽");
        user2.setCity("上海");
        users.add(user2);

        return users;
    }
    //查-根据id查询
    public User finUserById(Integer id) {
        if (id == 1) {
            User user1 = new User();
            user1.setId(1);
            user1.setUsername("小明");
            user1.setCity("北京");
            return user1;
        }
        return null;
    }
}

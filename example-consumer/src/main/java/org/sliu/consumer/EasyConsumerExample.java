package org.sliu.consumer;


import org.sliu.common.model.User;
import org.sliu.common.service.UserService;
import org.sliu.proxy.ServiceProxyFactory;

public class EasyConsumerExample {

    public static void main(String[] args) {
        // 动态代理
        UserService userService = ServiceProxyFactory.getProxy(UserService.class);
        User user = new User();
        user.setName("sliu");
        User serviceUser = userService.getUser(user);
        System.out.println(serviceUser.getName() + "调用成功");
    }
}

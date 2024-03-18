package org.sliu.consumer;

import org.sliu.bootstrap.ConsumerBootstrap;
import org.sliu.common.model.User;
import org.sliu.common.service.UserService;
import org.sliu.proxy.ServiceProxyFactory;

public class ConsumerExample {

    public static void main(String[] args) {

        // 服务提供者初始化
        ConsumerBootstrap.init();
        // 获取代理
        UserService userService = ServiceProxyFactory.getProxy(UserService.class);
        User user = new User();
        user.setName("sliu");
        // 调用
        User newUser = userService.getUser(user);
        if (newUser != null) {
            System.out.println(newUser.getName());
        } else {
            System.out.println("user == null");
        }
        System.out.println("调用结束为什么不关闭呢");
        // long number = userService.getNumber();
        // System.out.println(number);
    }


}

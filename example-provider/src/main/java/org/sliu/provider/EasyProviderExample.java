package org.sliu.provider;

import org.sliu.common.service.UserService;
import org.sliu.registry.LocalRegistry;
import org.sliu.server.HttpServer;
import org.sliu.server.VertxHttpServer;

/**
 * 简易服务提供者示例
 */
public class EasyProviderExample {

    public static void main(String[] args) {
        // 提供服务
        // 注册服务
        LocalRegistry.register(UserService.class.getName(), UserServiceImpl.class);
        // 启动 web 服务
        HttpServer httpServer = new VertxHttpServer();
        httpServer.doStart(8080);
    }
}

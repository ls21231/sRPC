package org.sliu.provider;

import org.sliu.RpcApplication;
import org.sliu.common.service.UserService;
import org.sliu.registry.LocalRegistry;
import org.sliu.server.HttpServer;
import org.sliu.server.VertxHttpServer;

/**
 *
 */
public class ProviderExample {
    public static void main(String[] args) {
        // RPC 框架初始化
        RpcApplication.init();

        // 注册服务
        LocalRegistry.register(UserService.class.getName(), UserServiceImpl.class);

        // 启动 web 服务
        HttpServer httpServer = new VertxHttpServer();
        httpServer.doStart(RpcApplication.getRpcConfig().getServerPort());
    }
}

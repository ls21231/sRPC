package org.sliu.provider;

import org.sliu.RpcApplication;
import org.sliu.common.service.UserService;
import org.sliu.config.RegistryConfig;
import org.sliu.config.RpcConfig;
import org.sliu.model.ServiceMetaInfo;
import org.sliu.registry.LocalRegistry;
import org.sliu.registry.Registry;
import org.sliu.registry.RegistryFactory;
import org.sliu.server.HttpServer;
import org.sliu.server.VertxHttpServer;
import org.sliu.server.tcp.VertxTcpServer;

public class ProviderExample {

    public static void main(String[] args) {
        // RPC 框架初始化
        RpcApplication.init();

        // 注册服务
        String serviceName = UserService.class.getName();
        LocalRegistry.register(serviceName, UserServiceImpl.class);

        // 注册服务到注册中心
        RpcConfig rpcConfig = RpcApplication.getRpcConfig();
        RegistryConfig registryConfig = rpcConfig.getRegistryConfig();
        Registry registry = RegistryFactory.getInstance(registryConfig.getRegistry());
        ServiceMetaInfo serviceMetaInfo = new ServiceMetaInfo();
        serviceMetaInfo.setServiceName(serviceName);
        serviceMetaInfo.setServiceHost(rpcConfig.getServerHost());
        serviceMetaInfo.setServicePort(rpcConfig.getServerPort());
        serviceMetaInfo.setServiceAddress(rpcConfig.getServerHost() + ":" + rpcConfig.getServerPort());
        try {
            registry.register(serviceMetaInfo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // 启动 web 服务
        // HttpServer httpServer = new VertxHttpServer();
        // httpServer.doStart(RpcApplication.getRpcConfig().getServerPort());

        // 启动 TCP 服务
        VertxTcpServer vertxTcpServer = new VertxTcpServer();
        vertxTcpServer.doStart(8088);
    }
}

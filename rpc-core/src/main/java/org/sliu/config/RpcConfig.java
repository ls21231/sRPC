package org.sliu.config;

import lombok.Data;
import org.sliu.fault.retry.RetryStrategyKeys;
import org.sliu.fault.tolerant.TolerantStrategyKeys;
import org.sliu.loadblance.LoadBalancerKeys;
import org.sliu.serializer.SerializerKeys;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * RPC 框架配置
 */
@Data
@ConfigurationProperties(prefix = "rpc")
@EnableConfigurationProperties(RpcConfig.class)
@Configuration
public class RpcConfig {

    /**
     * 名称
     */
    private String name = "S-rpc";

    /**
     * 版本号
     */
    private String version = "1.0";

    /**
     * 服务器主机名
     */
    private String serverHost = "localhost";
    
    /**
     * 服务器端口号
     */
    private Integer serverPort = 8080;
    /**
     * 模拟调用
     */
    private boolean mock = false;

    /**
     * 序列化器
     */
    private String serializer = SerializerKeys.JDK;

    /**
     * 注册中心配置
     */
    private RegistryConfig registryConfig = new RegistryConfig();

    /**
     * 负载均衡器
     */
    private String loadBalancer = LoadBalancerKeys.CONSISTENT_HASH;

    /**
     * 重试策略
     */
    private String retryStrategy = RetryStrategyKeys.NO;

    /**
     * 容错策略
     */
    private String tolerantStrategy = TolerantStrategyKeys.FAIL_FAST;

}

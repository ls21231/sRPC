package org.sliu.provider;


import org.sliu.bootstrap.ProviderBootstrap;
import org.sliu.common.service.UserService;
import org.sliu.model.ServiceRegisterInfo;
import java.util.ArrayList;
import java.util.List;

public class ProviderExample {

    public static void main(String[] args) {

        // 要注册的服务
        List<ServiceRegisterInfo<?>> serviceRegisterInfoList = new ArrayList<>();
        ServiceRegisterInfo serviceRegisterInfo = new ServiceRegisterInfo(UserService.class.getName(), UserServiceImpl.class);
        serviceRegisterInfoList.add(serviceRegisterInfo);

        // 服务提供者初始化
        ProviderBootstrap.init(serviceRegisterInfoList);

    }
}

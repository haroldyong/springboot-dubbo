package com.example.demo.service.generator;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.service.config.DubboConfig;
import java.util.List;
import java.util.Map;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.utils.ReferenceConfigCache;
import org.apache.dubbo.rpc.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * <pre>
 * Desc:
 * Author:chenlu
 * Email:chenlu@ddjf.com.cn
 * Date:15:22 2018/2/8
 * </pre>
 */

@Service
public class DubboServiceFactory {

    private ApplicationConfig application = new ApplicationConfig();

    private RegistryConfig registry = new RegistryConfig();

    @Autowired
    DubboConfig dubboConfig;

    public Object genericInvoke(String interfaceClass, String methodName, List<Map<String, Object>> parameters)
            throws ClassNotFoundException {

        ReferenceConfig<GenericService> reference = new ReferenceConfig<>();
        application.setName(dubboConfig.getName());
        registry.setAddress(dubboConfig.getAddress());
        reference.setApplication(application);
        reference.setRegistry(registry);
        reference.setInterface(interfaceClass); // 接口名
        reference.setGeneric(true); // 声明为泛化接口

        /*
         * ReferenceConfig实例很重，封装了与注册中心的连接以及与提供者的连接， 需要缓存，否则重复生成ReferenceConfig可能造成性能问题并且会有内存和连接泄漏。
         * API方式编程时，容易忽略此问题。 这里使用dubbo内置的简单缓存工具类进行缓存
         */


        // GenericService genericService = reference.get();//当时用postman测试，每访问一次，消耗的内存就增加好几兆，吓到宝宝了,所以不要用这种方式


        ReferenceConfigCache cache = ReferenceConfigCache.getCache();
        GenericService genericService = cache.get(reference);
        // 用com.alibaba.dubbo.rpc.service.GenericService可以替代所有接口引用

        int len = parameters.size();

        String[] invokeParamTypes = new String[len];
        Object[] invokeParams = new Object[len];
        for (int i = 0; i < len; i++) {
            invokeParamTypes[i] = (String) parameters.get(i).get("ParamType");
            Object paramStr = parameters.get(i).get("param");
            if (invokeParamTypes[i].equalsIgnoreCase("java.lang.Integer")
                    || invokeParamTypes[i].equalsIgnoreCase("java.lang.String")) {
                invokeParams[i] = paramStr;
            } else {
                invokeParams[i] = JSONObject.parse((String) paramStr);
            }
        }
        return genericService.$invokeAsync(methodName, invokeParamTypes, invokeParams);

    }

}



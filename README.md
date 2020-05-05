## 简单的 dubbo  genericService invoke  调用列子

# 环境说明

zookeeper server 请使用 3.5.7 版本

nacos server 使用1.1.4 
-- 切记使用1.1.4源码编译，替换掉pom.xml 中的 netty版本 => 4.1.45.Final
--- https://github.com/haroldyong/nacos/tree/update_netty_version_4.1.45


# 使用说明



### 两种注册中心  zookeeper  & nacos  任意使用
只要修改application.properties 配置中的dubbo.registry.address 皆可

#### provider

可以同时支持nacos和 zk 注册中心


#### consumer

同时只能实例化一个ref对象，如果需要同时使用zk 和 nacos的 服务。必须实例化两个ref

### 使用nacos 配置中心

在nacos配置中心，新建user.name  的 DataId.

### 测试调用

Post 

http://localhost:8083/home


{
    "interfaceName":"com.example.demo.service.QueryService",
    "methodName":"queryUserWithIndex",
    "methodParams":{
        "ParamType_1":"java.lang.Integer",
        "param_1":13,
        "ParamType_2":"com.example.demo.service.domain.ComplexReqDto",
        "param_2":"{\"id\":100000,\"name\":\"harold\",\"level\":2,\"isMarried\":true,\"isMarried\":true}"
    }
}


# 其他补充

为什么要自己重新编译nacos的原因在于，nacos源码中还使用 google开源的httpclient古老的版本com.ning.http.client ,这个中间件是
依赖netty3.x 版本，如果与zookeer 部署能兼容的话，是有包冲突的。所以我统一了netty版本
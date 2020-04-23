## 简单的 dubbo  genericService invoke  调用列子

# 环境说明

zookeeper server 请使用 3.5.7 版本

nacos server 使用1.1.4 
-- 切记使用1.1.4源码编译，替换掉pom.xml 中的 netty版本 => 4.1.45.Final
--- https://github.com/haroldyong/nacos/tree/update_netty_version_4.1.45


# 使用说明

两种方式配置 zookeeper  & nacos

测试调用

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
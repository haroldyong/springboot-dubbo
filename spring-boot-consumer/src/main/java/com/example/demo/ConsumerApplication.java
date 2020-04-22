package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 访问地址：http://localhost:8083/home
 * 访问的JSON格式
 *      {
 *          "interfaceName": "com.example.demo.service.DemoService",
 *          "methodName": "getCount",
 *          "methodParams":
 *                      {
 *                          "ParamType_1":"java.lang.Integer",
 *                          "param_1":"231",
 *                          "ParamType_1":"java.lang.String",
 *                          "param_2":"FFFFFFF",
 *                          "ParamType_3":"com.example.demo.service.domain.ComplexReqDto",
                            "param_3":"{\"id\":100000,\"name\":\"harold\",\"level\":2,\"isMarried\":true}"
 *                                  ...
 *                                  ...
 *                                  ...
 *                      }
 *      }
 */

@SpringBootApplication
public class ConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }
}

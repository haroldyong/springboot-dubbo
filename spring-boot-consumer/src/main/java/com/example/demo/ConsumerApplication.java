package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 访问地址：http://localhost:11000/core-consumer/home
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
 *                                  ...
 *                                  ...
 *                                  ...
 *                      }
 *      }
 */

@SpringBootApplication
//@ComponentScan("com.example.demo.*")
public class ConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }
}

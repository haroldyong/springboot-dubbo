package com.example.demo.service.impl;

import com.example.demo.service.DemoService;
import java.util.HashMap;
import java.util.Map;
import org.apache.dubbo.config.annotation.Service;


/**
 * <pre>
 * Desc: DemoService 的provider;
 * Author:chenlu
 * Email:chenlu@ddjf.com.cn
 * Date:11:48 2018/2/8
 * </pre>
 */
@Service
public class DemoServiceImpl implements DemoService {
    @Override
    public Map getDemoName(String demoName) {
        Map map = new HashMap();
        map.put("demo name = ", demoName);
        map.put("id", 3123);
        return map;
    }

    @Override
    public int getCount(Integer number, String param) {
        return ++number;
    }

}

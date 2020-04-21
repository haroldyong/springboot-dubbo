package com.example.demo.service.controller;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.example.demo.service.dto.RequestDto;
import com.example.demo.service.generator.DubboServiceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <pre>
 * Desc: 校验的正确性要求参数个数符合服务的方法参数的个数
 * Author:chenlu
 * Email:chenlu@ddjf.com.cn
 * Date:17:53 2018/2/7
 * </pre>
 */

@RestController
public class SampleController {
    @Autowired
    DubboServiceFactory dubboServiceFactory;

    @RequestMapping(path = "/home", method = RequestMethod.POST)
    public Object home(@RequestBody RequestDto requestDto) throws ClassNotFoundException {
        Map maps = requestDto.getMethodParams();
        List<Map<String, Object>> paramInfos = new ArrayList<>();
        if (maps == null) {
            return dubboServiceFactory.genericInvoke(requestDto.getInterfaceName(), requestDto.getMethodName(), paramInfos);
        }

        /**
         * 解析方法参数 methodParams
         */
        int j=0;
        for(j=1; j<= (maps.size()/2 ); j++)
        {
            String type = (String)maps.get("ParamType_" + j);
            Object value = maps.get("param_" + j);
            
            if(StringUtils.isBlank(type) || null == value)
            {
                continue;
            }
            
            Map map = new HashMap();
            map.put("ParamType", type);
            map.put("param",value );
            paramInfos.add(map);  
        }
        

        return dubboServiceFactory.genericInvoke(requestDto.getInterfaceName(), requestDto.getMethodName(), paramInfos);
        //return null;
    }


    @RequestMapping("/index")
    public int getIntCount(){
        return 100;
    }

}

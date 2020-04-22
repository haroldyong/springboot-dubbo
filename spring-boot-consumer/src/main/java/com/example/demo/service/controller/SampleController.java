package com.example.demo.service.controller;

import com.example.demo.service.dto.RequestDto;
import com.example.demo.service.generator.DubboServiceFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.dubbo.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

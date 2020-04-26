package com.example.demo.service.impl;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.example.demo.service.QueryService;

import com.example.demo.service.domain.ComplexReqDto;
import com.example.demo.service.domain.ResultEntry;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;

@Service
public class QueryServiceImpl implements QueryService {

    @NacosValue(value = "${useLocalCache:false}", autoRefreshed = true)
    private boolean useLocalCache;

    @NacosValue(value ="${userName}", autoRefreshed = true)
    private String userName;

    @NacosValue(value ="${userNum}", autoRefreshed = true)
    private Integer num;

    @Override
    public ResultEntry<ComplexReqDto> queryUser(ComplexReqDto complexReqDto) {

        ComplexReqDto resp = new ComplexReqDto();

        BeanUtils.copyProperties(complexReqDto, resp);

        return ResultEntry.buildSuccess(resp);
    }

    @Override
    public ResultEntry<ComplexReqDto> queryUserWithIndex(Integer id, ComplexReqDto complexReqDto) {
        ComplexReqDto resp = new ComplexReqDto();

        BeanUtils.copyProperties(complexReqDto, resp);
        String name = complexReqDto.getName();
        resp.setId((long)id);
        resp.setName(userName + id);
        resp.setIsMarried(useLocalCache);
        resp.setLevel(num);

        return ResultEntry.buildSuccess(resp);
    }

}

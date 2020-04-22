package com.example.demo.service.impl;

import com.example.demo.service.QueryService;

import com.example.demo.service.domain.ComplexReqDto;
import com.example.demo.service.domain.ResultEntry;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.BeanUtils;

@Service
public class QueryServiceImpl implements QueryService {

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
        resp.setName(name + id);

        return ResultEntry.buildSuccess(resp);
    }

}

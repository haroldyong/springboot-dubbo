package com.example.demo.service.impl;

import com.example.demo.service.QueryService;
import com.example.demo.service.domain.ComplexReqDto;
import com.example.demo.service.domain.ResultEntry;
import org.springframework.beans.BeanUtils;

public class QueryServiceImpl implements QueryService {

    @Override
    public ResultEntry<ComplexReqDto> queryUser(ComplexReqDto complexReqDto) {

        ComplexReqDto resp = new ComplexReqDto();

        BeanUtils.copyProperties(complexReqDto, resp);

        return ResultEntry.buildSuccess(resp);
    }

}

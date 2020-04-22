package com.example.demo.service;

import com.example.demo.service.domain.ComplexReqDto;
import com.example.demo.service.domain.ResultEntry;

public interface QueryService {

    ResultEntry<ComplexReqDto> queryUser(ComplexReqDto complexReqDto);

    ResultEntry<ComplexReqDto> queryUserWithIndex(Integer id,ComplexReqDto complexReqDto);

}

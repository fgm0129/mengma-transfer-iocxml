package com.mengma.edu.service;

/**
 * @author fgm
 * @description
 * @date 2020-01-12
 ***/
public interface TransferService {

    void transfer(String fromCardNo,String toCardNo,int money) throws Exception;
}

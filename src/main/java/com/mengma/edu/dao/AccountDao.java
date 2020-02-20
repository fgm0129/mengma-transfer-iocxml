package com.mengma.edu.dao;

import com.mengma.edu.pojo.Account;

/**
 * @author fgm
 * @description
 * @date 2020-01-12
 ***/
public interface AccountDao {

    Account queryAccountByCardNo(String cardNo) throws Exception;

    int updateAccountByCardNo(Account account) throws Exception;
}

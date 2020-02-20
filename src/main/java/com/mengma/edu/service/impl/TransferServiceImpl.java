package com.mengma.edu.service.impl;

import com.mengma.edu.dao.AccountDao;
import com.mengma.edu.extend.annutations.MyAutowired;
import com.mengma.edu.extend.annutations.MyService;
import com.mengma.edu.extend.annutations.transaction.MyTransaction;
import com.mengma.edu.pojo.Account;
import com.mengma.edu.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;

/**
 * @author fgm
 * @description
 * @date 2020-01-12
 ***/
@MyService(value = "transferService")
public class TransferServiceImpl implements TransferService {

    @MyAutowired
    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }


   @MyTransaction(propagation= Propagation.REQUIRED)
   @Override
    public void transfer(String fromCardNo, String toCardNo, int money) throws Exception {

            Account from = accountDao.queryAccountByCardNo(fromCardNo);
            Account to = accountDao.queryAccountByCardNo(toCardNo);

            from.setMoney(from.getMoney()-money);
            to.setMoney(to.getMoney()+money);

            accountDao.updateAccountByCardNo(to);
            int c = 1/0;
            accountDao.updateAccountByCardNo(from);

    }
}

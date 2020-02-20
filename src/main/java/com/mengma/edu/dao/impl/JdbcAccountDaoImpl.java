package com.mengma.edu.dao.impl;

import com.mengma.edu.extend.annutations.MyAutowired;
import com.mengma.edu.extend.annutations.MyService;
import com.mengma.edu.pojo.Account;
import com.mengma.edu.dao.AccountDao;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author fgm
 * @description
 * @date 2020-01-12
 ***/
@MyService(value = "accountDao")
public class JdbcAccountDaoImpl implements AccountDao {


    @MyAutowired
    private JdbcTemplate jdbcTemplate;




    public void init() {
        System.out.println("初始化方法.....");
    }

    public void destory(){
        System.out.println("销毁方法.....");
    }

    @Override
    public Account queryAccountByCardNo(String cardNo) throws Exception {
        //从连接池获取连接
        String sql = "select * from account where cardNo= ? ";

        Account account = new Account();
        jdbcTemplate.query(sql, new Object[]{cardNo}, resultSet -> {
            account.setId(resultSet.getLong("id"));
            account.setCardNo(resultSet.getString("cardNo"));
            account.setName(resultSet.getString("name"));
            account.setMoney(resultSet.getLong("money"));
        });
      return account;

    }

    @Override
    public int updateAccountByCardNo(Account account) throws Exception {

        // 从连接池获取连接
        // 改造为：从当前线程当中获取绑定的connection连接
        //Connection con = connectionUtils.getCurrentThreadConn();
        //
        String sql = "update account set money=? where cardNo=?";
        //System.out.println("con:=======================>" + con);
        //PreparedStatement preparedStatement = con.prepareStatement(sql);
        //preparedStatement.setLong(1,account.getMoney());
        //preparedStatement.setString(2,account.getCardNo());
        //int i = preparedStatement.executeUpdate();


       int num= jdbcTemplate.update(sql,new Object[]{account.getMoney(),account.getCardNo()});


      //  preparedStatement.close();
        //con.close();
        return num;
    }
}

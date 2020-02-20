package com.mengma.edu.pojo;

/**
 * @author fgm
 * @description
 * @date 2020-01-12
 ***/
public class Account {

    private Long id;
    private String cardNo;
    private String name;
    private Long money;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getMoney() {
        return money;
    }

    public void setMoney(Long money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{" +
            "id=" + id +
            ", cardNo='" + cardNo + '\'' +
            ", name='" + name + '\'' +
            ", money=" + money +
            '}';
    }
}

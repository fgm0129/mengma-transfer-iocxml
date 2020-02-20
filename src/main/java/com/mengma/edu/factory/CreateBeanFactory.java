package com.mengma.edu.factory;

import com.mengma.edu.utils.ConnectionUtils;

/**
 * @author fgm
 * @description
 * @date 2020-01-12
 ***/
public class CreateBeanFactory {



    public static ConnectionUtils getInstanceStatic() {
        return new ConnectionUtils();
    }


    public ConnectionUtils getInstance() {
        return new ConnectionUtils();
    }
}

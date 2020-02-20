package com.mengma.edu.extend.annutations.transaction;

import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;

import java.lang.annotation.*;

/**
 * @author fgm
 * @description  自定义事务
 * @date 2020-02-02
 ***/
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface MyTransaction {

    String value() default "";
    /**
     * 事务传播机制
     * @return
     */
    Propagation propagation() default Propagation.REQUIRED;

    /**
     * 事务隔离级别
     * @return
     */
    Isolation isolation() default Isolation.DEFAULT;

    /**
     * 回滚异常
     * @return
     */
    Class<? extends Throwable>[] rollbackFor() default {};

    /**
     * 事务超时时间
     * @return
     */
    int timeout() default TransactionDefinition.TIMEOUT_DEFAULT;


    boolean readOnly() default false;


}

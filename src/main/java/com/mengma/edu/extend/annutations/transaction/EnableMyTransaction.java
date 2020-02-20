package com.mengma.edu.extend.annutations.transaction;

import com.mengma.edu.extend.transaction.MyTransactionConfigurationSelector;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.Import;
import org.springframework.core.Ordered;

import java.lang.annotation.*;

/**
 * @author fgm
 * @description 开启自定义事务注解
 * @date 2020-02-02
 ***/
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(MyTransactionConfigurationSelector.class)
public @interface EnableMyTransaction {

    boolean proxyTargetClass() default false;

    /**
     * 代理模式
     * @return
     */
    AdviceMode mode() default AdviceMode.PROXY;


    int order() default Ordered.LOWEST_PRECEDENCE;

}

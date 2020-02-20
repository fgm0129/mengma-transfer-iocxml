package com.mengma.edu.extend.annutations;


import java.lang.annotation.*;

/**
 * @author fgm
 * @description  自定义IOC服务
 * @date 2020-02-02
 ***/
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyService {

    /**
     * 自定义bean的名称
     * @return
     */
    String value() default "";

}

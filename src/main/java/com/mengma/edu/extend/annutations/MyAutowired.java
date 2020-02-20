package com.mengma.edu.extend.annutations;

import java.lang.annotation.*;

/**
 * @author fgm
 * @description  自定义注入
 * @date 2020-02-02
 ***/
@Target({ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyAutowired {

    boolean required() default true;

}

package com.mengma.edu.extend;

import com.mengma.edu.extend.annutations.MyAutowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;

import java.lang.annotation.Annotation;
import java.util.LinkedHashSet;
import java.util.Set;


/**
 * @author fgm
 * @description  自定义注解定义
 * @date 2020-02-02
 ***/
@Component
public class MyAutowiredBeanPostProcessor extends AutowiredAnnotationBeanPostProcessor  {

    private final Set<Class<? extends Annotation>> autowiredAnnotationTypes = new LinkedHashSet(4);


    public MyAutowiredBeanPostProcessor(){
        this.autowiredAnnotationTypes.add(Autowired.class);
        this.autowiredAnnotationTypes.add(Value.class);
        try {
            this.autowiredAnnotationTypes.add((Class<? extends Annotation>)
                ClassUtils.forName("javax.inject.Inject", AutowiredAnnotationBeanPostProcessor.class.getClassLoader()));
        } catch (ClassNotFoundException e) {
            ;
        }
        //增加自定义注解类型
        this.autowiredAnnotationTypes.add(MyAutowired.class);
        super.setAutowiredAnnotationTypes(autowiredAnnotationTypes);
    }

    @Override
    public void postProcessMergedBeanDefinition(RootBeanDefinition beanDefinition, Class<?> beanType, String beanName) {
        super.postProcessMergedBeanDefinition(beanDefinition,beanType,beanName);
    }




}


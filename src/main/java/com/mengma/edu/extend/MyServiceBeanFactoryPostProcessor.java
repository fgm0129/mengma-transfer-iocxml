package com.mengma.edu.extend;

import com.mengma.edu.extend.annutations.MyService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationBeanNameGenerator;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.annotation.ScannedGenericBeanDefinition;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.core.type.filter.TypeFilter;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Set;

/**
 * @author fgm
 * @description  自定义BeanFactoryPostProcessor 完成自定义注解的扫描
 * @date 2020-02-02
 ***/
@Component
public class MyServiceBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    //默认扫描包
    private static final String basePackage="com.mengma.edu";
    ////是否使用默认的filter，
    private static final boolean useDefaultFilters = false;

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory)
        throws BeansException {

        AnnotationBeanNameGenerator beanNameGenerator=new AnnotationBeanNameGenerator();
        BeanDefinitionRegistry registry= ( BeanDefinitionRegistry)configurableListableBeanFactory;
        ClassPathScanningCandidateComponentProvider beanScanner = new ClassPathScanningCandidateComponentProvider(useDefaultFilters);
        //扫描自定义注解
        TypeFilter includeFilter =  new AnnotationTypeFilter(MyService.class);
        beanScanner.addIncludeFilter(includeFilter);
        String attributeName=MyService.class.getName();

        Set<BeanDefinition> beanDefinitions = beanScanner.findCandidateComponents(basePackage);
        for (BeanDefinition beanDefinition : beanDefinitions) {
            String beanName= getBeanName(beanDefinition,attributeName,beanNameGenerator,registry);
            registry.registerBeanDefinition(beanName, beanDefinition);
        }

    }

/**
     * 获取bean名称
     * @param beanDefinition
     * @param attributeName
     * @param beanNameGenerator
     * @param registry
     * @return
     */

private String getBeanName(BeanDefinition beanDefinition,String attributeName,
                               AnnotationBeanNameGenerator beanNameGenerator,BeanDefinitionRegistry registry) {

        Map<String, Object> annotationAttributes = ((ScannedGenericBeanDefinition)beanDefinition).getMetadata()
            .getAnnotationAttributes(attributeName);
        if(null==annotationAttributes.get("value")){
            return  beanNameGenerator.generateBeanName(beanDefinition,registry);
        }
        if(((String)annotationAttributes.get("value")).isEmpty()){
            return  beanNameGenerator.generateBeanName(beanDefinition,registry);
        }
        String beanName=(String)annotationAttributes.get("value");
        return beanName;
    }
}


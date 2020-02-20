package com.mengma.edu.extend.transaction;

import org.springframework.transaction.annotation.AnnotationTransactionAttributeSource;
import org.springframework.transaction.annotation.TransactionAnnotationParser;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author fgm
 * @description  自定义事务注解解析器
 * @date 2020-02-03
 ***/
public class MyTransactionAttributeSource extends AnnotationTransactionAttributeSource {

    private final static Set<TransactionAnnotationParser> annotationParsers =new LinkedHashSet<>(4);

    static {
        annotationParsers.add(new MyTransactionAnnotationParser());
    }

    public MyTransactionAttributeSource() {
       super(annotationParsers);
    }



}

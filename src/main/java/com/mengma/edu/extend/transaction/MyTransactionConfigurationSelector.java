package com.mengma.edu.extend.transaction;

import com.mengma.edu.extend.annutations.transaction.EnableMyTransaction;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.AdviceModeImportSelector;
import org.springframework.context.annotation.AutoProxyRegistrar;
import org.springframework.transaction.config.TransactionManagementConfigUtils;


/**
 * @author fgm
 * @description  自定义事务注解生效类
 * @date 2020-02-02
 ***/
public class MyTransactionConfigurationSelector extends AdviceModeImportSelector<EnableMyTransaction> {

    @Override
    protected String[] selectImports(AdviceMode adviceMode) {
        switch (adviceMode) {
            case PROXY:
                return new String[] {AutoProxyRegistrar.class.getName(),
                    ProxyMyTransactionConfiguration.class.getName()};
            case ASPECTJ:
                return new String[] {TransactionManagementConfigUtils.TRANSACTION_ASPECT_CONFIGURATION_CLASS_NAME};
            default:
                return null;
        }
    }
}

package com.hong.py.springSourceCode;

import com.alibaba.druid.pool.DruidDataSource;
import com.hong.py.serviceImpl.AccountService2Impl2;
import com.hong.py.serviceImpl.ChildBean;
import com.hong.py.springSourceCode.SelfAop.annotation.SelfEnableAspectJAutoProxy;
import com.hong.py.springSourceCode.SelfAop.test.SelfAspectPrint;
import com.hong.py.springSourceCode.SelfTransactioManage.annotation.SelfEnableTransactionManagement;
import com.hong.py.springSourceCode.SelfTransactioManage.manager.SelfDataSourcePlatformTransactionManager;
import com.hong.py.springSourceCode.SelfTransactioManage.manager.SelfPlatformTransactionManager;
import com.hong.py.springSourceCode.test.SelfAspectTest;
import com.hong.py.springSourceCode.test.SelfTransactionPrint;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * 文件描述
 *
 * @ProductName: HONGPY
 * @ProjectName: SpringDemoNew
 * @Package: com.hong.py.springSourceCode
 * @Description: note
 * @Author: hongpy21691
 * @CreateDate: 2020/4/2 9:58
 * @UpdateUser: hongpy21691
 * @UpdateDate: 2020/4/2 9:58
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2020 hongpy Technologies Inc. All Rights Reserved
 **/
@Configuration
//@ComponentScan(value ={"com.hong.py.springSourceCode"} )
//会提示不能重复
//@Import(value = com.hong.py.springSourceCode.MyImportSelector.class )
//@Import(value = com.hong.py.springSourceCode.MyImportBeanDefinitionRegistrar.class)
//@EnableAspectJAutoProxy //开启
//@SelfEnableAspectJAutoProxy
@ComponentScan(value = "com.hong.py.springSourceCode.test")

@SelfEnableTransactionManagement
//@EnableTransactionManagement
public class MainConfig {

    /*//beanName可以重复，但只有第一个会起作用
    @Bean("childBean")
    public ChildBean childBean() {
        ChildBean childBean = new ChildBean();
        childBean.setAge(18);
        childBean.setName("洪大洋");
        childBean.setHeight(180);
        return childBean;
    }

    //beanName可以重复，但只有第一个会起作用
    @Bean("childBean")
    public ChildBean childBean1() {
        ChildBean childBean = new ChildBean();
        childBean.setAge(18);
        childBean.setName("洪小洋");
        childBean.setHeight(180);
        return childBean;
    }

    //
    @Bean()
    public ChildBean childBean2() {
        ChildBean childBean = new ChildBean();
        childBean.setAge(18);
        childBean.setName("洪小洋");
        childBean.setHeight(180);
        return childBean;
    }

    @Bean
    public AccountService2Impl2 accountService2Impl2() {
        AccountService2Impl2 accountService2Impl2 = new AccountService2Impl2();
        return accountService2Impl2;
    }
*/
    /*@Bean
    public SelfAspectPrint selfAspectPrint() {
        SelfAspectPrint selfAspectPrint = new SelfAspectPrint();
        return selfAspectPrint;
    }*/

    @Bean
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://192.168.1.141:3306/mybatis?useUnicode=true&amp;characterEncoding=utf8&amp;rewriteBatchedStatements=true&amp;useSSL=false&amp;serverTimezone=UTC&amp;allowPublicKeyRetrieval=true");
        dataSource.setUsername("root");
        dataSource.setPassword("471215");
        return dataSource;
    }

    /*@Bean
    public PlatformTransactionManager platformTransactionManager() {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource());
        return dataSourceTransactionManager;
    }*/

    @Bean
    public SelfPlatformTransactionManager selfPlatformTransactionManager(DataSource dataSource) {
        SelfDataSourcePlatformTransactionManager dataSourceTransactionManager= new SelfDataSourcePlatformTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource);
        return dataSourceTransactionManager;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        return jdbcTemplate;
    }

    @Bean
    public SelfTransactionPrint selfTransactionPrint() {
        SelfTransactionPrint selfTransactionPrint = new SelfTransactionPrint();
        return selfTransactionPrint;
    }

}

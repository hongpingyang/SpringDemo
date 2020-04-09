package com.hong.py.springSourceCode.SelfTransactioManage.manager;

import org.springframework.jdbc.datasource.ConnectionHolder;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 文件描述
 *
 * @ProductName: HONGPY
 * @ProjectName: SpringDemoNew
 * @Package: com.hong.py.springSourceCode.SelfTransactioManage.manager
 * @Description: note
 * @Author: hongpy21691
 * @CreateDate: 2020/4/9 13:48
 * @UpdateUser: hongpy21691
 * @UpdateDate: 2020/4/9 13:48
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2020 hongpy Technologies Inc. All Rights Reserved
 **/
public class SelfDataSourcePlatformTransactionManager implements SelfPlatformTransactionManager {

    private DataSource dataSource;

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Connection getConnection() throws SQLException {
        Connection connection = dataSource.getConnection();
        TransactionSynchronizationManager.bindResource(getDataSource(), new ConnectionHolder(connection));
        return connection;
    }

    @Override
    public void commit(Connection connection) throws SQLException {
        connection.commit();
        TransactionSynchronizationManager.unbindResource(getDataSource());
    }

    @Override
    public void rollback(Connection connection) throws SQLException {
        connection.rollback();
        TransactionSynchronizationManager.unbindResource(getDataSource());
    }
}

package com.hong.py.springSourceCode.SelfTransactioManage.manager;

import com.hong.py.springSourceCode.SelfTransactioManage.core.SelfTransactionDefinition;

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
        return dataSource.getConnection();
    }

    @Override
    public void commit(Connection connection) throws SQLException {
        connection.commit();
    }

    @Override
    public void rollback(Connection connection) throws SQLException {
        connection.rollback();
    }
}

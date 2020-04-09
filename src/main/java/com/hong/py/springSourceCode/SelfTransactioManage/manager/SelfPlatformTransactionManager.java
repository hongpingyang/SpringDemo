package com.hong.py.springSourceCode.SelfTransactioManage.manager;

import com.hong.py.springSourceCode.SelfTransactioManage.core.SelfTransactionDefinition;
import org.springframework.transaction.TransactionStatus;

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
 * @CreateDate: 2020/4/9 13:31
 * @UpdateUser: hongpy21691
 * @UpdateDate: 2020/4/9 13:31
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2020 hongpy Technologies Inc. All Rights Reserved
 **/
public interface SelfPlatformTransactionManager {

    Connection getConnection() throws SQLException;

    void commit(Connection connection) throws SQLException;

    void rollback(Connection connection) throws SQLException;
}

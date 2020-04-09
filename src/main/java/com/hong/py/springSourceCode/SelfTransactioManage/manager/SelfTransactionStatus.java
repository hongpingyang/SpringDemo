package com.hong.py.springSourceCode.SelfTransactioManage.manager;

/**
 * 文件描述
 *
 * @ProductName: HONGPY
 * @ProjectName: SpringDemoNew
 * @Package: com.hong.py.springSourceCode.SelfTransactioManage.manager
 * @Description: note
 * @Author: hongpy21691
 * @CreateDate: 2020/4/9 13:36
 * @UpdateUser: hongpy21691
 * @UpdateDate: 2020/4/9 13:36
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 *
 **/
public interface SelfTransactionStatus {

    boolean isNewTransaction();

    boolean hasSavepoint();

    void setRollbackOnly();

    boolean isRollbackOnly();

    boolean isCompleted();
}

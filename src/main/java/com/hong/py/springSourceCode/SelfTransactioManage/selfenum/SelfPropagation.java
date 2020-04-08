package com.hong.py.springSourceCode.SelfTransactioManage.selfenum;

import com.hong.py.springSourceCode.SelfTransactioManage.core.SelfTransactionDefinition;

public enum  SelfPropagation {
    /**
     * Support a current transaction, create a new one if none exists.
     * Analogous to EJB transaction attribute of the same name.
     * <p>This is the default setting of a transaction annotation.
     */
    REQUIRED(SelfTransactionDefinition.PROPAGATION_REQUIRED),

    /**
     * Support a current transaction, execute non-transactionally if none exists.
     * Analogous to EJB transaction attribute of the same name.
     * <p>Note: For transaction managers with transaction synchronization,
     * {@code SUPPORTS} is slightly different from no transaction at all,
     * as it defines a transaction scope that synchronization will apply for.
     * As a consequence, the same resources (JDBC Connection, Hibernate Session, etc)
     * will be shared for the entire specified scope. Note that this depends on
     * the actual synchronization configuration of the transaction manager.
     * @see org.springframework.transaction.support.AbstractPlatformTransactionManager#setTransactionSynchronization
     */
    SUPPORTS(SelfTransactionDefinition.PROPAGATION_SUPPORTS),

    /**
     * Support a current transaction, throw an exception if none exists.
     * Analogous to EJB transaction attribute of the same name.
     */
    MANDATORY(SelfTransactionDefinition.PROPAGATION_MANDATORY),

    /**
     * Create a new transaction, and suspend the current transaction if one exists.
     * Analogous to the EJB transaction attribute of the same name.
     * <p><b>NOTE:</b> Actual transaction suspension will not work out-of-the-box
     * on all transaction managers. This in particular applies to
     * {@link org.springframework.transaction.jta.JtaTransactionManager},
     * which requires the {@code javax.transaction.TransactionManager} to be
     * made available to it (which is server-specific in standard Java EE).
     * @see org.springframework.transaction.jta.JtaTransactionManager#setTransactionManager
     */
    REQUIRES_NEW(SelfTransactionDefinition.PROPAGATION_REQUIRES_NEW),

    /**
     * Execute non-transactionally, suspend the current transaction if one exists.
     * Analogous to EJB transaction attribute of the same name.
     * <p><b>NOTE:</b> Actual transaction suspension will not work out-of-the-box
     * on all transaction managers. This in particular applies to
     * {@link org.springframework.transaction.jta.JtaTransactionManager},
     * which requires the {@code javax.transaction.TransactionManager} to be
     * made available to it (which is server-specific in standard Java EE).
     * @see org.springframework.transaction.jta.JtaTransactionManager#setTransactionManager
     */
    NOT_SUPPORTED(SelfTransactionDefinition.PROPAGATION_NOT_SUPPORTED),

    /**
     * Execute non-transactionally, throw an exception if a transaction exists.
     * Analogous to EJB transaction attribute of the same name.
     */
    NEVER(SelfTransactionDefinition.PROPAGATION_NEVER),

    /**
     * Execute within a nested transaction if a current transaction exists,
     * behave like {@code REQUIRED} otherwise. There is no analogous feature in EJB.
     * <p>Note: Actual creation of a nested transaction will only work on specific
     * transaction managers. Out of the box, this only applies to the JDBC
     * DataSourceTransactionManager. Some JTA providers might support nested
     * transactions as well.
     * @see org.springframework.jdbc.datasource.DataSourceTransactionManager
     */
    NESTED(SelfTransactionDefinition.PROPAGATION_NESTED);


    private final int value;


    SelfPropagation(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }
}

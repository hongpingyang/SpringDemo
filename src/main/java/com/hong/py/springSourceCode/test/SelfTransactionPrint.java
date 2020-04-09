package com.hong.py.springSourceCode.test;

import com.hong.py.springSourceCode.SelfTransactioManage.annotation.SelfTransactional;
import org.springframework.beans.factory.annotation.Autowired;


import java.math.BigDecimal;

/**
 * 文件描述
 *
 * @ProductName: HONGPY
 * @ProjectName: SpringDemoNew
 * @Package: com.hong.py.springSourceCode.test
 * @Description: note
 * @Author: hongpy21691
 * @CreateDate: 2020/4/8 15:49
 * @UpdateUser: hongpy21691
 * @UpdateDate: 2020/4/8 15:49
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 *
 * 默认配置下Spring只会回滚运行时，未检查异常（继承RuntimeException异常）或者Error。
 * @Transactional注解只能应用到public 方法才有效。
 **/
@SelfTransactional()
public class SelfTransactionPrint implements TransactionPrint {

    @Autowired
    private AccountServiceDao accountServiceDao;


    /**
     * 现在如果我们需要手动捕获异常，并且也希望抛异常的时候能回滚肿么办呢？
     * 　　下面这样写就好了，手动回滚事务：
     *  @Transactional(rollbackOn = { Exception.class })
     * public void test() {
     *      try {
     *         doDbStuff1();
     *         doDbStuff2();
     *      } catch (Exception e) {
     *           e.printStackTrace();
     *           TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();//就是这一句了，加上之后，如果doDbStuff2()抛了异常,                                                                                       //doDbStuff1()是会回滚的
     *      }
     * }
     * @return
     */
    @Override
    public String aspectPrint() {

        accountServiceDao.AddMoney(1, BigDecimal.valueOf(-100));
        int i=10/0; //出现异常事务要回滚
        accountServiceDao.AddMoney(2, BigDecimal.valueOf(100));

        return "print over";
    }
}

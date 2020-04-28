package com.hong.py.zk;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.framework.recipes.locks.InterProcessReadWriteLock;

import java.util.concurrent.TimeUnit;

/**
 * author: hongpy
 * create time: 2020-04-26 18:37
 * description:
 * life for code
 * 读写锁
 * 类似于AQS的排队机制。获取锁的时候，生成临时序号节点，
 * 对与共享锁：判断前面是否有比自己小的节点且非共享(独占的)的节点存在，如果存在就会监听前面的节点。
 *
 * 对于独占锁：判断前面是否有比自己小的节点存在，如果存在就会监听前面的节点。自己则await阻塞等待前面的节点释放时唤醒自己。
 *
 * 需要实现包括公平锁、非公平锁。
 * 公平是在节点删除时只通知相邻的节点来获取的锁；
 * 非公平锁(惊群效应)是节点删除所有等待锁的线程重新竞争。
 *
 */
public class InterProcessReadWriteLocTest {

    public static void main(String[] args) {
        CuratorBase base=new CuratorBase();
        CuratorFramework client = base.curatorClient();
        client.start();

        //读(共享)锁 写锁(独占锁)
        InterProcessReadWriteLock lock=new InterProcessReadWriteLock(client,"/lock");
        InterProcessMutex readLock = lock.readLock(); //读锁
        InterProcessMutex writeLock = lock.writeLock();//写锁

        for (int i = 0; i < 10; i++) {
            //new Thread(new InterProcessReadWriteLocTest.ThreadTest(i,i==2?writeLock:readLock)).start();
            new Thread(new InterProcessReadWriteLocTest.ThreadTest(i,writeLock)).start();
        }


    }

    private static class ThreadTest implements Runnable {
        private Integer threadFlag;
        private InterProcessMutex lock;
        private boolean haslock=false;
        public ThreadTest(Integer threadFlag, InterProcessMutex lock) {
            this.threadFlag = threadFlag;
            this.lock = lock;
        }

        @Override
        public void run() {
            try {
                System.out.println("第" + Thread.currentThread().getName() + "线程开始获取锁");
                //设置超时时间
                lock.acquire();

                //if(haslock) {
                    System.out.println("第" + Thread.currentThread().getName() + "线程获取到了锁");
                //}
                //else {
                //    System.out.println("第" + threadFlag + "线程没有获取到了锁");
                //}
                //等到1秒后释放锁
                Thread.sleep(300000);
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                try {
                    //if(haslock)
                        lock.release();
                    System.out.println("第" + Thread.currentThread().getName() + "线程释放了锁");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

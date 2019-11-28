package com.liukai.concurrent.thread.lock.read_write;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by kayle on 2017/2/14.
 */
public class TestReadWrite2 {
    private Map<String, String> map = new HashMap();

    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    //双重检查机制
    public String getData(String key) {
        readWriteLock.readLock().lock();
        String value = null;
        try {
            value = map.get("value");
            if (value == null) {
                readWriteLock.readLock().unlock();
                readWriteLock.writeLock().lock();
                try {
                    if (value == null) {        //双重检查，用意是第一个线程写完后 value 是有值的，如果不加这个判断其他线程进来就写一下，这是有问题的。
                        value = "cache";
                    }
                } finally {
                    //readWriteLock.readLock().lock();      //这里个位置
                    readWriteLock.writeLock().unlock();
                }
                //这句可以放在上面的 finally 里面，因为 API 中有写提到，downgrade by acquiring read lock before releasing write lock
                //在释放之前获取 读锁，用意应该是想让该先程先获得读锁以便释放读锁的一瞬间还可以读。
                readWriteLock.readLock().lock();
            }
            //read more
        } finally {
            readWriteLock.readLock().unlock();
        }
        return null;
    }

}

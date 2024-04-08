package com.hmdp.utils;

/**
 * ClassName: ILock
 * Package:com.hmdp.utils
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2024/4/8 16:13
 */
public interface ILock {
    /**
     * 尝试获取锁
     * @param timeoutSec 锁持有的超时时间，过期自动释放
     * @return true代表获取成功，false代表获取失败
     */
    boolean tryLock(long timeoutSec);

    /**
     * 释放锁
     */
    void unlock();
}

package com.factory;

import com.huke.proxy.IProducer;
import com.huke.service.AccountSerivce;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 用于创建Service的代理对象的工厂
 */
public class BeanFactory {
    @Autowired
    private AccountSerivce accountSerivce;

    public final void setAccountSerivce(AccountSerivce accountSerivce) {
        this.accountSerivce = accountSerivce;
    }

    /**
     * 获取Service代理对象
     */
    public AccountSerivce getAccountSerivce(){
        Proxy.newProxyInstance(accountSerivce.getClass().getClassLoader(), accountSerivce.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        return null;
                    }
                });
        return  null;
    }
}

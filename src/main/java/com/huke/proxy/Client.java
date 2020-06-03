package com.huke.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 模拟消费者
 */
public class Client {
    public static void main(String[] args) {
        Producer producer = new Producer();
        /**
         * 动态代理
         *  特点：字节码随用随创建 随用随加载
         *  作用：不修改源码的基础上对方法增强
         *  分类：
         *    基于接口的动态代理
         *    基于类的动态代理
         *   基于接口的动态代理： Proxy、JDK官方
         *   如何创建代理对象:
         *      使用Proxy类中的newProxyInstance方法
         *   创建代理对象的要求：
         *      被代理对象至少实现一个接口
         *   newProxyInstance方法的参数：
         *         ClassLoader:类加载器
         *              它是用于加载代理对象的字节码的，和被代理对象使用相同的类加载器
         *         Class[]: 字节码数组
         *              它是用于让代理对象和被代理对象有相同的方法
         *         InvacationHandler ：用于提供增强的代码
         *               它是让我们写如何代理，我们一般都是写一个该接口的实现类通常都是匿名内部类 不是必须的
         */
        Proxy.newProxyInstance(producer.getClass().getClassLoader(),
                producer.getClass().getInterfaces(), new InvocationHandler() {
                    /**
                     * 作用：执行被代理对象的任何接口都会经过该方法
                     *  方法参数含义：
                     * @param proxy    代理对象的引用
                     * @param method    代理的方法（当前执行的方法）
                     * @param args      当前方法所需要的参数
                     * @return          和被代理对象方法有相同的返回值
                     * @throws Throwable
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //提供增强的代码
                        Object returnValue = null;
                        Float money = (Float)args[0];
                        if("saleProduct".equals(method.getName())){
                            returnValue = method.invoke(producer,money*0.8f);
                        }
                        return method.invoke(producer,args);
                    }
                });
            producer.saleProduct(1000);
    }
}

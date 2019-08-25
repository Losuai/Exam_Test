package com.company.proxy;

public class Main {
    public static void main(String[] args) {
        UserDaoImpl target = new UserDaoImpl();
        StaticProxyHandler staticProxyHandler = new StaticProxyHandler(target);
        staticProxyHandler.save();
        DynamicProxyHandler dynamicProxyHandler = new DynamicProxyHandler();
        UserDao userDao = (UserDao) dynamicProxyHandler.newProxyInstance(target);
        userDao.save();
        userDao.delete();
    }
}

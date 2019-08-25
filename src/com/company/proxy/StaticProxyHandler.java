package com.company.proxy;

public class StaticProxyHandler implements UserDao {
    private UserDaoImpl target;

    public StaticProxyHandler(UserDaoImpl target){
        this.target = target;
    }

    @Override
    public void save() {
        System.out.println("before create user...");
        target.save();
        System.out.println("after create user...");
    }

    @Override
    public void delete() {

    }
}

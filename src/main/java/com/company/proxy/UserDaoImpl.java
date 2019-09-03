package com.company.proxy;

public class UserDaoImpl implements UserDao {
    @Override
    public void save() {
        System.out.println("create user");
    }

    @Override
    public void delete() {
        System.out.println("delete user");
    }
}

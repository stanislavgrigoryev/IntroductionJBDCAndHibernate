package org.example.service;

import org.example.bean.User;
import org.example.dao.UserDao;
import org.example.dao.UserDaoHibernateImpl;

import java.util.List;

public class UserServiceHibernateImpl implements UserService {
    private UserDao userDao = new UserDaoHibernateImpl();

    @Override
    public void createUserTable() {
        userDao.createUserTable();

    }

    @Override
    public void dropUserTable() {
        userDao.dropUserTable();
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        userDao.saveUser(name, lastName, age);
    }

    @Override
    public void removeUserById(long id) {
        userDao.removeUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public void clearUserTable() {
        userDao.clearUserTable();
    }
}

package org.example.dao;

import org.example.bean.User;
import org.example.util.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
   private SessionFactory sessionFactory = Util.getHibernateConnection();

    @Override
    public void createUserTable() {
        String sql = "CREATE TABLE if not exists user(id bigint primary key not null auto_increment, name VARCHAR(45), lastName VARCHAR(45), age TINYINT(3))";
        try(Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.createSQLQuery(sql).executeUpdate();
            transaction.commit();
        }
    }

    @Override
    public void dropUserTable() {
        String sql = "DROP TABLE IF EXISTS user";
        try(Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.createSQLQuery(sql).executeUpdate();

            transaction.commit();
        }

    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        try(Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            transaction.commit();
        }

    }

    @Override
    public void removeUserById(long id) {
        try(Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            transaction.commit();
        }

    }

    @Override
    public List<User> getAllUsers() {
        try(Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            transaction.commit();
        }
        return null;
    }

    @Override
    public void clearUserTable() {
        String sql = "TRUNCATE TABLE user";
        try(Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.createSQLQuery(sql).executeUpdate();

            transaction.commit();
        }

    }
}

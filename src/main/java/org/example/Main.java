package org.example;

import org.example.service.UserService;
import org.example.service.UserServiceHibernateImpl;
import org.example.service.UserServiceJDBCImpl;
import org.example.util.Util;

public class Main {
    public static void main(String[] args) {
        script(new UserServiceJDBCImpl());
        script(new UserServiceHibernateImpl());

    }

    private static void script(UserService userService) {
        userService.createUserTable();
        userService.saveUser("Stas", "Aleksandrovich", (byte) 29);
        userService.saveUser("Stas1", "Aleksandrovich1", (byte) 27);
        userService.saveUser("Stas2", "Aleksandrovich2", (byte) 25);
        userService.saveUser("Stas3", "Aleksandrovich3", (byte) 23);
        userService.saveUser("Stas4", "Aleksandrovich4", (byte) 22);
        System.out.println("-----------------------");
        userService.getAllUsers().forEach(System.out::println);
        System.out.println("-----------------------");
        userService.removeUserById(1L);
        userService.getAllUsers().forEach(System.out::println);
        System.out.println("-----------------------");
        userService.clearUserTable();
        userService.getAllUsers().forEach(System.out::println);
        System.out.println("-----------------------");
        userService.dropUserTable();
    }
}
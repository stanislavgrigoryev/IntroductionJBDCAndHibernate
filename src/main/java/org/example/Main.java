package org.example;

import org.example.service.UserService;
import org.example.service.UserServiceJDBCImpl;
import org.example.util.Util;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceJDBCImpl();
        userService.createUserTable();
        userService.saveUser(", ' ', 1); drop table user;INSERT INTO user(name, lastName, age) VALUES('Bdfy", "ty", (byte) 1);

    }
}
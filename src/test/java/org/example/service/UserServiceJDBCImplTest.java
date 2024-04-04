package org.example.service;

import org.example.bean.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceJDBCImplTest {
    private final String testName = "Ivan Ivanovich";
    private final String testLastName = "Ivanov";
    private final byte testAge = 18;
    private UserService userService = new UserServiceJDBCImpl();

    @BeforeEach
    void testTuning() {
        userService.dropUserTable();
        userService.createUserTable();
        userService.saveUser(testName, testLastName, testAge);
    }

    @Test
    void createUserTable() {
        try {
            userService.dropUserTable();
            userService.createUserTable();
        } catch (Exception e) {
            fail("При создании таблицы произошла ошибка" + e.getMessage());
        }
    }

    @Test
    void dropUserTable() {
        assertDoesNotThrow(() -> userService.dropUserTable());
    }

    @Test
    void saveUser() {
        User user = userService.getAllUsers().get(0);
        assertEquals(testName, user.getName());
        assertEquals(testLastName, user.getLastName());
        assertEquals(testAge, user.getAge());
    }

    @Test
    void removeUserById() {
        userService.removeUserById(1L);
        assertTrue(userService.getAllUsers().isEmpty());
    }

    @Test
    void getAllUsers() {
        assertFalse(userService.getAllUsers().size() != 1);
    }

    @Test
    void clearUserTable() {
        userService.clearUserTable();
        assertTrue(userService.getAllUsers().isEmpty());
    }
}
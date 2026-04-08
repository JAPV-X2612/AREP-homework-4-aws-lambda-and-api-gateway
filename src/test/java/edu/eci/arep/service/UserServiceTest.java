package edu.eci.arep.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the UserService class.
 * Validates that user data is correctly mapped without AWS infrastructure.
 *
 * @author Jesús Pinzón
 * @version 1.0
 * @since 2026-04-07
 */
class UserServiceTest {

    private UserService userService;

    @BeforeEach
    void setUp() {
        userService = new UserService();
    }

    @Test
    void testGetUserReturnsCorrectName() {
        Map<String, String> result = userService.getUser("Jesús Pinzón", "jesus.pinzon-v@mail.escuelaing.edu.co");
        assertEquals("Jesús Pinzón", result.get("name"));
    }

    @Test
    void testGetUserReturnsCorrectEmail() {
        Map<String, String> result = userService.getUser("Jesús Pinzón", "jesus.pinzon-v@mail.escuelaing.edu.co");
        assertEquals("jesus.pinzon-v@mail.escuelaing.edu.co", result.get("email"));
    }

    @Test
    void testGetUserWithEmptyFields() {
        Map<String, String> result = userService.getUser("", "");
        assertEquals("", result.get("name"));
        assertEquals("", result.get("email"));
    }
}

package edu.eci.arep.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit tests for the GreetingService class.
 * Validates the JSON structure and content of greeting responses.
 *
 * @author Jesús Pinzón
 * @version 1.0
 * @since 2026-04-07
 */
class GreetingServiceTest {

    private GreetingService greetingService;

    @BeforeEach
    void setUp() {
        greetingService = new GreetingService();
    }

    @Test
    void testGreetWithName() {
        assertEquals("{\"message\": \"Hello, Jesús!\"}", greetingService.greet("Jesús"));
    }

    @Test
    void testGreetWithDefaultName() {
        assertEquals("{\"message\": \"Hello, World!\"}", greetingService.greet("World"));
    }
}

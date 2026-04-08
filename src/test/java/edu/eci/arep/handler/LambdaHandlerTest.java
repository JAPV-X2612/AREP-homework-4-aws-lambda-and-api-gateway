package edu.eci.arep.handler;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the LambdaHandler class.
 * Validates routing logic and service delegation without deploying to AWS.
 *
 * @author Jesús Pinzón
 * @version 1.0
 * @since 2026-04-07
 */
class LambdaHandlerTest {

    private LambdaHandler handler;

    @BeforeEach
    void setUp() {
        handler = new LambdaHandler();
    }

    @Test
    void testSquareAction() {
        Map<String, Object> input = Map.of("action", "square", "value", "7");
        assertEquals(49, handler.handleRequest(input, null));
    }

    @Test
    void testGreetAction() {
        Map<String, Object> input = Map.of("action", "greet", "name", "AREP");
        assertEquals("{\"message\": \"Hello, AREP!\"}", handler.handleRequest(input, null));
    }

    @Test
    void testUserAction() {
        Map<String, Object> input = Map.of("action", "user", "name", "Jesús Pinzón", "email", "jesus.pinzon@escuelaing.edu.co");
        Map<?, ?> result = (Map<?, ?>) handler.handleRequest(input, null);
        assertEquals("Jesús Pinzón", result.get("name"));
        assertEquals("jesus.pinzon@escuelaing.edu.co", result.get("email"));
    }

    @Test
    void testUnknownAction() {
        Map<String, Object> input = Map.of("action", "unknown");
        Map<?, ?> result = (Map<?, ?>) handler.handleRequest(input, null);
        assertTrue(result.containsKey("error"));
    }
}

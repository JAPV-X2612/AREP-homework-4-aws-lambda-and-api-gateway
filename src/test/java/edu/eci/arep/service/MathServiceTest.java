package edu.eci.arep.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit tests for the MathService class.
 * Validates the correctness of mathematical operations without requiring AWS infrastructure.
 *
 * @author Jesús Pinzón
 * @version 1.0
 * @since 2026-04-07
 */
class MathServiceTest {

    private MathService mathService;

    @BeforeEach
    void setUp() {
        mathService = new MathService();
    }

    @Test
    void testSquareOfPositiveNumber() {
        assertEquals(25, mathService.square(5));
    }

    @Test
    void testSquareOfZero() {
        assertEquals(0, mathService.square(0));
    }

    @Test
    void testSquareOfNegativeNumber() {
        assertEquals(9, mathService.square(-3));
    }
}

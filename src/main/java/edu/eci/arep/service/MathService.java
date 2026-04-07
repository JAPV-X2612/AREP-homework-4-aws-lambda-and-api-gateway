package edu.eci.arep.service;

/**
 * Service class that provides mathematical computation operations.
 * Designed to be invoked directly by a Lambda handler without any framework dependency.
 *
 * @author Jesús Pinzón
 * @version 1.0
 * @since 2026-04-07
 */
public class MathService {

    /**
     * Computes the square of the given integer.
     *
     * @param value the integer to be squared
     * @return the square of the given value
     */
    public Integer square(Integer value) {
        return value * value;
    }
}

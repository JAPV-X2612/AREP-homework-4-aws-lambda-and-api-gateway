package edu.eci.arep.service;

/**
 * Service class that produces greeting messages in JSON format.
 * Designed to be invoked directly by a Lambda handler without any framework dependency.
 *
 * @author Jesús Pinzón
 * @version 1.0
 * @since 2026-04-07
 */
public class GreetingService {

    private static final String TEMPLATE = "{\"message\": \"Hello, %s!\"}";

    /**
     * Produces a JSON greeting message for the given name.
     *
     * @param name the name to include in the greeting
     * @return a JSON string with the greeting message
     */
    public String greet(String name) {
        return String.format(TEMPLATE, name);
    }
}

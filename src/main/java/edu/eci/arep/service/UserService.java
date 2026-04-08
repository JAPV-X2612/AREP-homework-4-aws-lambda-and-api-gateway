package edu.eci.arep.service;

import java.util.Map;

/**
 * Service class that processes user data and serializes it to JSON.
 *
 * @author Jesús Pinzón
 * @version 1.0
 * @since 2026-04-07
 */
public class UserService {

    /**
     * Builds and returns a map with the user's name and email,
     * which Lambda serializes as a clean JSON object.
     *
     * @param name  the user's full name
     * @param email the user's email address
     * @return a map representing the user, serialized to JSON by Lambda
     */
    public Map<String, String> getUser(String name, String email) {
        return Map.of("name", name, "email", email);
    }
}

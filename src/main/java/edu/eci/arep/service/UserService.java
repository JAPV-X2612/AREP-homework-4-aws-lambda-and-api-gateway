package edu.eci.arep.service;

import com.google.gson.Gson;
import edu.eci.arep.model.User;

/**
 * Service class that processes user data and serializes it to JSON.
 *
 * @author Jesús Pinzón
 * @version 1.0
 * @since 2026-04-07
 */
public class UserService {

    private static final Gson GSON = new Gson();

    /**
     * Builds a User from the given name and email and returns it as a JSON string.
     *
     * @param name  the user's full name
     * @param email the user's email address
     * @return a JSON string representing the user
     */
    public String getUser(String name, String email) {
        return GSON.toJson(new User(name, email));
    }
}

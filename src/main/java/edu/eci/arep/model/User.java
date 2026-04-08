package edu.eci.arep.model;

/**
 * Represents a user with a name and email address.
 *
 * @author Jesús Pinzón
 * @version 1.0
 * @since 2026-04-07
 */
public class User {

    private final String name;
    private final String email;

    /**
     * Constructs a User with the given name and email.
     *
     * @param name  the user's full name
     * @param email the user's email address
     */
    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    /**
     * Returns the user's name.
     *
     * @return the name
     */
    public String getName() { return name; }

    /**
     * Returns the user's email address.
     *
     * @return the email
     */
    public String getEmail() { return email; }
}

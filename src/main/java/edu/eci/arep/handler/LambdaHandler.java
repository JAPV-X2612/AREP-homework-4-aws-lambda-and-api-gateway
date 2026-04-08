package edu.eci.arep.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import edu.eci.arep.service.GreetingService;
import edu.eci.arep.service.MathService;
import edu.eci.arep.service.UserService;

import java.util.Map;

/**
 * AWS Lambda entry point that routes incoming API Gateway requests to the appropriate service based on the "action"
 * query parameter (GET) or the request body fields (POST).
 *
 * @author Jesús Pinzón
 * @version 1.0
 * @since 2026-04-07
 */
public class LambdaHandler implements RequestHandler<Map<String, Object>, Object> {

    private final MathService mathService = new MathService();
    private final GreetingService greetingService = new GreetingService();
    private final UserService userService = new UserService();

    /**
     * Handles the Lambda invocation by reading the input map and delegating to the correct service.
     * GET actions use the "action" key; POST user creation uses "name" and "email" keys directly.
     *
     * @param input   the map of parameters forwarded by API Gateway
     * @param context the Lambda execution context provided by AWS
     * @return a plain object (String, Integer, or Map) serialized cleanly by Lambda
     */
    @Override
    public Object handleRequest(Map<String, Object> input, Context context) {
        String action = (String) input.getOrDefault("action", "");

        return switch (action) {
            case "greet" -> {
                String name = (String) input.getOrDefault("name", "World");
                yield greetingService.greet(name);
            }
            case "square" -> {
                int value = Integer.parseInt((String) input.getOrDefault("value", "0"));
                yield mathService.square(value);
            }
            case "user" -> {
                String name = (String) input.getOrDefault("name", "");
                String email = (String) input.getOrDefault("email", "");
                yield userService.getUser(name, email);
            }
            default -> Map.of("error", "Unknown action: " + action);
        };
    }
}

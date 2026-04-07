package edu.eci.arep.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import edu.eci.arep.service.GreetingService;
import edu.eci.arep.service.MathService;

import java.util.Map;

/**
 * AWS Lambda entry point that routes incoming API Gateway requests to
 * the appropriate service based on the "action" query parameter.
 * Supported actions: "square" and "greet".
 *
 * @author Jesús Pinzón
 * @version 1.0
 * @since 2026-04-07
 */
public class LambdaHandler implements RequestHandler<Map<String, String>, String> {

    private final MathService mathService = new MathService();
    private final GreetingService greetingService = new GreetingService();

    /**
     * Handles the Lambda invocation by reading query parameters from the
     * input map and delegating to the correct service method.
     *
     * @param input   the map of query parameters forwarded by API Gateway
     * @param context the Lambda execution context provided by AWS
     * @return a JSON string with the service response, or an error message
     */
    @Override
    public String handleRequest(Map<String, String> input, Context context) {
        String action = input.getOrDefault("action", "");

        return switch (action) {
            case "square" -> {
                String raw = input.getOrDefault("value", "0");
                yield String.valueOf(mathService.square(Integer.parseInt(raw)));
            }
            case "greet" -> {
                String name = input.getOrDefault("name", "World");
                yield greetingService.greet(name);
            }
            default -> "{\"error\": \"Unknown action: " + action + "\"}";
        };
    }
}

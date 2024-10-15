package com.appsdeveloperblog.aws.photoapp.users;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

import static java.util.UUID.randomUUID;


public class PostHandler implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

    public APIGatewayProxyResponseEvent handleRequest(final APIGatewayProxyRequestEvent input, final Context context) {

        LambdaLogger  logger = context.getLogger();
        // HANDLING http post request for /users api endpoint
        logger.log("Handling http post request for /users api endpoint");

        String requestBody = input.getBody();

        Gson gson = new Gson();
        Map<String, String> userDetails = gson.fromJson(requestBody, Map.class);
        userDetails.put("userId", randomUUID().toString());

        // Todo: Process user detais

        Map<String, String> returnValue =  new HashMap<>();
        returnValue.put("firstName", userDetails.get("firstName"));
        returnValue.put("lastName", userDetails.get("lastName"));
        returnValue.put("userId", userDetails.get("userId"));

        Map<String, String> responseHeaders = new HashMap<>();
        responseHeaders.put("Content-type", "application/json");


        return new APIGatewayProxyResponseEvent()
                .withHeaders(responseHeaders)
                .withStatusCode(200)
                .withBody(gson.toJson(returnValue));
    }
}

package com.appsdeveloperblog.aws.lambda;


import java.util.HashMap;
import java.util.Map;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;

import static java.lang.System.getenv;

public class EnvironmentVariablesExample implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

    public APIGatewayProxyResponseEvent handleRequest(final APIGatewayProxyRequestEvent input, final Context context) {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");

        APIGatewayProxyResponseEvent response = new APIGatewayProxyResponseEvent()
                .withHeaders(headers);

        LambdaLogger logger = context.getLogger();
        String myVariable =  getenv("MY_VARIABLE");
        String myCognitoUserPoolId =  getenv("MY_COGNITO_USER_POOL_ID");
        String myCognitoClientAppSecret =  getenv("MY_COGNITO_CLIENT_APP_SECRET");

        logger.log(myVariable);
        logger.log(myCognitoUserPoolId);
        logger.log(myCognitoClientAppSecret);

        return response
                .withBody("{}")
                .withStatusCode(500);
    }
}

package com.appsdeveloperblog.aws.lambda;


import java.util.HashMap;
import java.util.Map;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import com.amazonaws.services.kms.AWSKMS;
import com.amazonaws.services.kms.AWSKMSClientBuilder;
import com.amazonaws.services.kms.model.DecryptRequest;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.util.Base64;

import static java.lang.System.getenv;

public class EnvironmentVariablesExample implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

    private final String myVariable = decryptKey("MY_VARIABLE");
    private final String myCognitoUserPoolId = decryptKey("MY_COGNITO_USER_POOL_ID");
    private final String myCognitoClientAppSecret = decryptKey("MY_COGNITO_CLIENT_APP_SECRET");

    public APIGatewayProxyResponseEvent handleRequest(final APIGatewayProxyRequestEvent input, final Context context) {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");

        APIGatewayProxyResponseEvent response = new APIGatewayProxyResponseEvent()
                .withHeaders(headers);

        LambdaLogger logger = context.getLogger();

        logger.log(myVariable);
        logger.log(myCognitoUserPoolId);
        logger.log(myCognitoClientAppSecret);

        return response
                .withBody("{}")
                .withStatusCode(500);
    }

    private static String decryptKey(String secret) {
        System.out.println("Decrypting key");
        byte[] encryptedKey = Base64.decode(System.getenv(secret));
        Map<String, String> encryptionContext = new HashMap<>();
        encryptionContext.put("LambdaFunctionName",
                System.getenv("AWS_LAMBDA_FUNCTION_NAME"));

        AWSKMS client = AWSKMSClientBuilder.defaultClient();

        DecryptRequest request = new DecryptRequest()
                .withCiphertextBlob(ByteBuffer.wrap(encryptedKey))
                .withEncryptionContext(encryptionContext);

        ByteBuffer plainTextKey = client.decrypt(request).getPlaintext();
        return new String(plainTextKey.array(), Charset.forName("UTF-8"));
    }
}

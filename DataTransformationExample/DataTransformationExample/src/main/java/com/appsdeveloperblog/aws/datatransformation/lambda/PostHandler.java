package com.appsdeveloperblog.aws.datatransformation.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.util.HashMap;
import java.util.Map;


public class PostHandler implements RequestHandler<Map<String, String>, Map<String, String>> {

    public Map<String, String> handleRequest(final Map<String, String> input, final Context context) {

        Map<String, String> response = new HashMap<>();

        return response;

    }
}

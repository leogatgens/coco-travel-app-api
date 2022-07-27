package com.leogatgens.aws.travel.handlers;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Handler for requests to Lambda function.
 */
public class PostHandler implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

    public APIGatewayProxyResponseEvent handleRequest(final APIGatewayProxyRequestEvent input, final Context context) {
        String requestBody = input.getBody();

        Gson gson = new Gson();

        Map<String,String> userDetails = gson.fromJson(requestBody,Map.class);
        userDetails.put("userId" , UUID.randomUUID().toString() );


        Map returnedValue = new HashMap();
        returnedValue.put("firstName",userDetails.get("firstname"));
        returnedValue.put("lastName",userDetails.get("lastName"));
        returnedValue.put("userId",userDetails.get("userId"));


        APIGatewayProxyResponseEvent response = new APIGatewayProxyResponseEvent();
        response.withStatusCode(200);
        response.withBody(gson.toJson(userDetails,Map.class));
        Map responseHeaders = new HashMap<>();
        responseHeaders.put("Content-Type","application/json");

        response.withHeaders(responseHeaders);

        return response;
    }
}

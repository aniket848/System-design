package org.example;

import java.util.HashMap;
import java.util.HexFormat;
import java.util.Map;

public class HttpRequest {

    private String url;
    private String method;
    private Map<String, String> headers;
    private Map<String, String> queryParams;
    private String body;
    private String timeout;

    public HttpRequest(){
        headers = new HashMap<>();
        queryParams = new HashMap<>();
    }

    interface withUrl{
        withMethod url(String url);
    }

    interface withMethod{
        withHeaders method(String method);
    }

    interface withHeaders{
        withOptional headers(String key, String value);
    }

    interface withOptional{
        withOptional queryParams(String key, String value);
        withOptional body(String body);
        withOptional timeout(String timeout);
        HttpRequest build();
    }

    public void execute(){
        // Implementation for executing the HTTP request
        System.out.println("Executing HTTP request: " + method + " " + url);
        // Add logic to handle headers, query parameters, body, and timeout as needed
        System.out.println("Headers: " + headers);
        System.out.println("Query Parameters: " + queryParams);
        System.out.println("Body: " + body);
        System.out.println("Timeout: " + timeout);
        System.out.println("HTTP request executed successfully.");
    }


    public static class stepBuilder implements withUrl, withMethod, withHeaders, withOptional{

        private HttpRequest req;

        public stepBuilder(){
            req = new HttpRequest();
        }

        @Override
        public withOptional headers(String key, String value) {
            req.headers.put(key,value);
            return this;
        }

        @Override
        public withHeaders method(String method) {
            req.method = method;
            return this;
        }

        @Override
        public withOptional queryParams(String key, String value) {
            req.queryParams.put(key,value);
            return this;
        }

        @Override
        public withOptional body(String body) {
            req.body = body;
            return this;
        }

        @Override
        public withOptional timeout(String timeout) {
            req.timeout = timeout;
            return this;
        }

        @Override
        public HttpRequest build() {
            return req;
        }

        @Override
        public withMethod url(String url) {
            req.url = url;
            return this;
        }

        public static withUrl getStepBuilder(){
            return new stepBuilder();
        }
    }
}

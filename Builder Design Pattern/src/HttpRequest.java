import java.util.HashMap;

public class HttpRequest {

    private String url;
    private String method;
    private HashMap<String, String> headers;
    private HashMap<String, String> queryParams;
    private String body;
    private Long timeout;

    private HttpRequest(){
        headers = new HashMap<>();
        queryParams = new HashMap<>();
    }

    public void execute(){
        System.out.println("Executing request with following details:");
        System.out.println("URL: " + url);
        System.out.println("Method: " + method);
        if(!headers.isEmpty()){
            System.out.println("Headers:");
            headers.forEach((key, value)-> System.out.println(key + ": " + value));
        }

        if(!queryParams.isEmpty()){
            System.out.println("Query Parameters:");
            queryParams.forEach((key, value)-> System.out.println(key + ": " + value));
        }

        System.out.println("Body: " + body);
        System.out.println("Timeout: " + timeout + " ms");
    }

    interface URLStep{
        MethodStep withUrl(String url);
    }

    interface MethodStep{
        HeaderStep withMethod(String method);
    }

    interface HeaderStep{
        OptionalStep withHeader(String key, String value);
    }

    interface OptionalStep{
        OptionalStep withQueryParam(String key, String value);
        OptionalStep withBody(String body);
        OptionalStep withTimout(Long timeout);
        HttpRequest build();
    }

    public static class stepBuilder implements URLStep, MethodStep, HeaderStep, OptionalStep{
        private HttpRequest req;

        private stepBuilder(){
            req = new HttpRequest();
        }


        @Override
        public OptionalStep withHeader(String key, String value) {
            req.headers.put(key,value);
            return this;
        }

        @Override
        public HeaderStep withMethod(String method) {
            req.method = method;
            return this;
        }

        @Override
        public OptionalStep withQueryParam(String key, String value) {
            req.queryParams.put(key,value);
            return this;
        }

        @Override
        public OptionalStep withBody(String body) {
            req.body = body;
            return this;
        }

        @Override
        public OptionalStep withTimout(Long timeout) {
            req.timeout = timeout;
            return this;
        }

        @Override
        public HttpRequest build() {
            return req;
        }

        @Override
        public MethodStep withUrl(String url) {
            req.url = url;
            return this;
        }

        static public URLStep getStepBuilder(){
            return new stepBuilder();
        }
    }
}

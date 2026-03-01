public class Main {
    public static void main(String[] args) {

        HttpRequest req = HttpRequest.stepBuilder.getStepBuilder()
                .withUrl("http://example.com/api")
                .withMethod("GET")
                .withHeader("Accept", "application/json")
                .withBody("{id:123}")
                .withQueryParam("user","Aniket")
                .withTimout(200L)
                .build();

        req.execute();
    }
}
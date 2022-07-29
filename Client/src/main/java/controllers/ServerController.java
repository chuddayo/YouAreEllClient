package controllers;

import kong.unirest.Unirest;
import java.net.MalformedURLException;

public class ServerController {
    private final String rootURL = "http://zipcode.rocks:8085";

    private static ServerController svr = new ServerController();
    private ServerController() {}
    public static ServerController getServerInstance() {
        return svr;
    }

    /*
        send server GET request and return body as JSON string
    */
    public String getURL(String urlExtension) throws MalformedURLException {
        return Unirest.get(rootURL + "/" + urlExtension).asJson().getBody().toString();
    }

    /*
        send server POST request and return a JSON string result
    */
    public String postURL(String urlExtension, String jsonBody) {
        return Unirest.post(rootURL + "/" + urlExtension).body(jsonBody).asJson().getBody().toString();
    }

    /*
        send server PUT request and return a JSON string result
    */
    public String putURL(String urlExtension, String jsonBody) {
        return Unirest.put(rootURL + "/" + urlExtension).body(jsonBody).asJson().getBody().toString();
    }

    //HttpResponse<JsonNode> jsonResponse = Unirest.get(rootURL + "/" + urlExtension).asJson();
}
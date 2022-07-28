package controllers;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import java.net.MalformedURLException;
import java.net.URL;

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
        URL url = new URL(rootURL + "/" + urlExtension);
        HttpResponse<JsonNode> jsonResponse = Unirest.get(url.toString()).asJson();
        return jsonResponse.getBody().toString();
    }

    /*
        send server POST request and return a JSON string result
    */
    public String postURL(String urlExtension, String jsonBody) throws MalformedURLException {
        URL url = new URL(rootURL + "/" + urlExtension);
        HttpResponse<JsonNode> jsonResponse = Unirest.post(url.toString()).body(jsonBody).asJson();
        System.out.println(jsonResponse.getBody().toPrettyString());
        return jsonResponse.getBody().toString();
    }

    public String putURL(String urlExtension, String jsonBody) throws MalformedURLException {
        URL url = new URL(rootURL + "/" + urlExtension);
        HttpResponse<JsonNode> jsonResponse = Unirest.put(url.toString()).body(jsonBody).asJson();
        System.out.println(jsonResponse.getBody().toString());
        return jsonResponse.getBody().toString();
    }
}
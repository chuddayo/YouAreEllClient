package controllers;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import java.net.MalformedURLException;
import java.net.URL;

public class ServerController {
    private final String rootURL = "http://zipcode.rocks:8085";

    // eager initialized server connection
    private static ServerController svr = new ServerController();
    private ServerController() {}
    public static ServerController getServerInstance() {
        return svr;
    }


        // url -> /ids/
        // send the server a get with url
        // return json from server
    public String getURL(String urlExtension) throws MalformedURLException {
        URL url = new URL(rootURL + "/" + urlExtension);
        HttpResponse<JsonNode> jsonResponse = Unirest.get(url.toString()).asJson();
        return jsonResponse.getBody().toString();
    }

    // TODO uncomment
//    public JsonString idPost(Id id) {
//        // url -> /ids/
//        // create json from Id
//        // request
//        // reply
//        // return json
//    }
//    public JsonString idPut(Id id) {
//        // url -> /ids/
//    }


}

// ServerController.getServerInstance.doGet()
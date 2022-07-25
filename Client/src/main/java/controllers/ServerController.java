package controllers;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import models.Id;

public class ServerController {
    private final String rootURL = "http://zipcode.rocks:8085";

    private static ServerController svr = new ServerController();

    private ServerController() {}

    public static ServerController getServerInstance() {
        return svr;
    }

    public String idGet() {
        // url -> /ids/
        // send the server a get with url
        // return json from server

        // TODO change URL to the /ids
        return Unirest.get(rootURL).asJson().getBody().toString();
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
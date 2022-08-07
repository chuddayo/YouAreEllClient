package controllers;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Id;

public class IdController {
    private final ObjectMapper objectMapper = new ObjectMapper();

    public List<Id> getIdsAsList() {
        String getResultJSON;
        try {
            getResultJSON = ServerController.getServerInstance().getURL("ids");
            return new ArrayList<>(Arrays.asList(objectMapper.readValue(getResultJSON, Id[].class)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    // create json from id
    // call server, get json result or error
    public Id postId(Id id) throws MalformedURLException, JsonProcessingException {
        try {
            String jsonString = objectMapper.writeValueAsString(id);
            String responseJsonString = ServerController.getServerInstance().postURL("ids", jsonString);
            return objectMapper.readValue(responseJsonString, Id.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    // create json from id
    // call server, get json result Or error
    public Id putId(Id id) throws MalformedURLException, JsonProcessingException {
        try {
            String jsonString = objectMapper.writeValueAsString(id);
            String responseJsonString = ServerController.getServerInstance().putURL("ids", jsonString);
            return objectMapper.readValue(responseJsonString, Id.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean idExists(Id id) {
        List<Id> idList = getIdsAsList();
        for (Id individual : idList) {
            if (individual.getGithub().equals(id.getGithub())) return true;
        }
        return false;
    }

    public String getUserId(Id id) {
        List<Id> idList = getIdsAsList();
        for (Id individual : idList) {
            if (individual.getGithub().equals(id.getGithub())) return individual.getUserid();
        }
        return null;
    }

    public Id getIdByUserId(String userId) {
        List<Id> idList = getIdsAsList();
        for (Id individual : idList) {
            if (individual.getUserid().equals(userId)) return individual;
        }
        return null;
    }

}
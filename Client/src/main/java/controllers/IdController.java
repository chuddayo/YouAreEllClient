package controllers;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Id;

public class IdController {

    public List<Id> getIdsAsList() {
        String getResultJSON = null;
        try {
            getResultJSON = ServerController.getServerInstance().getURL("ids");
            ObjectMapper objectMapper = new ObjectMapper();
            return Arrays.asList(objectMapper.readValue(getResultJSON, Id[].class));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    // create json from id
    // call server, get json result Or error
    // TODO server error handling
    public Id postId(Id id) throws JsonProcessingException, MalformedURLException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(id);
        String responseJsonString = ServerController.getServerInstance().postURL("ids", jsonString);
        return mapper.readValue(responseJsonString, Id.class);
    }


    // create json from id
    // call server, get json result Or error
    // TODO server error handling
    public Id putId(Id id) throws JsonProcessingException, MalformedURLException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(id);
        String responseJsonString = ServerController.getServerInstance().putURL("ids", jsonString);
        return mapper.readValue(responseJsonString, Id.class);
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
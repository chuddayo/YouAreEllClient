package controllers;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Id;

public class IdController {
    private List<Id> idList;

    public List<Id> getIdsAsList() {
        if (idList == null) {
            String getResultJSON = null;
            try {
                getResultJSON = ServerController.getServerInstance().getURL("ids");
                ObjectMapper objectMapper = new ObjectMapper();
                return Arrays.asList(objectMapper.readValue(getResultJSON, Id[].class));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return idList;
    }

    public Id postId(Id id) throws JsonProcessingException, MalformedURLException {
        // create json from id
        // call server, get json result Or error
        // TODO server error handling
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(id);
        String responseJsonString = ServerController.getServerInstance().postURL("ids", jsonString);
        return mapper.readValue(responseJsonString, Id.class);
    }

    public Id putId(Id id) throws JsonProcessingException, MalformedURLException {
        // create json from id
        // call server, get json result Or error
        // TODO server error handling
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(id);
        String responseJsonString = ServerController.getServerInstance().putURL("ids", jsonString);
        return mapper.readValue(responseJsonString, Id.class);
    }
 
}
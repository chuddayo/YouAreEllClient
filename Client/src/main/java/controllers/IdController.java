package controllers;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.Id;

public class IdController {
    //private HashMap<String, Id> allIds;
    private List<Id> idList;

    public List<Id> getIds() throws MalformedURLException {
        if (idList == null) {
            String getResultJSON = null;
            try {
                getResultJSON = ServerController.getServerInstance().getURL("ids");
                ObjectMapper objectMapper = new ObjectMapper();
                return Arrays.asList(objectMapper.readValue(getResultJSON, Id[].class));
            } catch (IOException e) {
                e.printStackTrace();
            }
//            List<Id> idList = new ArrayList<Id>();
//            Set<String> stringList = allIds.keySet();
//            for (String stringKey : stringList) {
//                idList.add(allIds.get(stringKey));
//            }
        }
        return idList;
    }

    public Id postId(Id id) {
        // create json from id
        // call server, get json result Or error
        // result json to Id obj

        return null;
    }

    public Id putId(Id id) {
        return null;
    }
 
}
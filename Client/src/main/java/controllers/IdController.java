package controllers;

import java.util.*;

import models.Id;

public class IdController {
    private HashMap<String, Id> allIds;

    Id myId;

    public List<Id> getIds() {
        if (allIds == null) return null;
        List<Id> idList = new ArrayList<Id>();
        Set<String> stringList = allIds.keySet();
        for (String stringKey : stringList) {
            idList.add(allIds.get(stringKey));
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
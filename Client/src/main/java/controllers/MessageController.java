package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.Id;
import models.Message;

public class MessageController {
    private List<Message> messageList;

    // TODO fill out all stubs
    public List<Message> getMessages() {
        if (messageList == null) {
            String getResultJSON = null;
            try {
                getResultJSON = ServerController.getServerInstance().getURL("messages");
                ObjectMapper objectMapper = new ObjectMapper();
                return Arrays.asList(objectMapper.readValue(getResultJSON, Message[].class));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return messageList;
    }
    public ArrayList<Message> getMessagesForId(Id Id) {
        return null;
    }
    public Message getMessageForSequence(String seq) {
        return null;
    }
    public ArrayList<Message> getMessagesFromFriend(Id myId, Id friendId) {
        return null;
    }
    public Message postMessage(Id myId, Id toId, Message msg) {
        return null;
    }
}
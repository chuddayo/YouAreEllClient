package controllers;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Message;

public class MessageController {
    private final ObjectMapper objectMapper = new ObjectMapper();
    private List<Message> messagesFromFriend;
    private List<Message> messagesToId;

    /*
        GET last 20 messages as List<Message>
    */
    public List<Message> getMessages() {
        String getResultJSON;
        try {
            getResultJSON = ServerController.getServerInstance().getURL("messages");
            return Arrays.asList(objectMapper.readValue(getResultJSON, Message[].class));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /*
        GET last 20 messages addressed to id as List<Message>
    */
    public List<Message> getMessagesForId(String id) {
        if (messagesFromFriend == null) {
            String getResultJSON;
            try {
                getResultJSON = ServerController.getServerInstance()
                        .getURL("ids/" + id + "/messages");
                return Arrays.asList(objectMapper.readValue(getResultJSON, Message[].class));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return messagesFromFriend;
    }

    public Message getMessageSequence(String githubId, String sequence) {
        Message message;
        String getResultJSON;
        try {
            getResultJSON = ServerController.getServerInstance()
                    .getURL("ids/" + githubId + "/messages/" + sequence);
            return objectMapper.readValue(getResultJSON, Message.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Message> getMessagesFromFriend(String myId, String friendId) {
        if (messagesFromFriend == null) {
            String getResultJSON;
            try {
                getResultJSON = ServerController.getServerInstance()
                        .getURL("ids/" + myId + "/from/" + friendId);
                return Arrays.asList(objectMapper.readValue(getResultJSON, Message[].class));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return messagesFromFriend;
    }

    public Message postMessage(Message message) throws JsonProcessingException {
        String jsonString = objectMapper.writeValueAsString(message);
        String responseJsonString = ServerController.getServerInstance()
                .postURL("ids/" + message.getFromId() + "/messages", jsonString);
        System.out.println(responseJsonString);
        return objectMapper.readValue(responseJsonString, Message.class);
    }

    /*
        Getters and Setters
    */
    public List<Message> getMessagesFromFriend() {
        return messagesFromFriend;
    }

    public void setMessagesFromFriend(List<Message> messagesFromFriend) {
        this.messagesFromFriend = messagesFromFriend;
    }

    public List<Message> getMessagesToId() {
        return messagesToId;
    }

    public void setMessagesToId(List<Message> messagesToId) {
        this.messagesToId = messagesToId;
    }
}
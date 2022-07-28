package controllers;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Id;
import models.Message;

public class MessageController {
    private List<Message> messageList;
    private List<Message> messagesFromFriend;
    private List<Message> messagesToId;

    public List<Message> getMessages() {
        if (messageList == null) {
            String getResultJSON;
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
    public List<Message> getMessagesForId(String id) {
        if (messagesFromFriend == null) {
            String getResultJSON;
            try {
                getResultJSON = ServerController.getServerInstance()
                        .getURL("ids/" + id + "/messages");
                ObjectMapper objectMapper = new ObjectMapper();
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
            ObjectMapper objectMapper = new ObjectMapper();
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
                ObjectMapper objectMapper = new ObjectMapper();
                return Arrays.asList(objectMapper.readValue(getResultJSON, Message[].class));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return messagesFromFriend;
    }

    public Message postMessage(Message message) throws JsonProcessingException, MalformedURLException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(message);
        String responseJsonString = ServerController.getServerInstance().postURL("messages", jsonString);
        return mapper.readValue(responseJsonString, Message.class);
    }

    public List<Message> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<Message> messageList) {
        this.messageList = messageList;
    }

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
package controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import models.Id;
import models.Message;
import org.junit.Assert;
import org.junit.Test;

import java.net.MalformedURLException;
import java.util.List;

public class MessageControllerTest {
    TransactionController transactionCtrl = new TransactionController(new MessageController(), new IdController());
    @Test
    public void postMessageTest() throws MalformedURLException, JsonProcessingException {
        Message msg = new Message();
        msg.setFromId("chuddayo");
        msg.setToId("");
        msg.setMessage("this is a test, with toString()");

        Message actual = transactionCtrl.getMsgCtrl().postMessage(msg);

        Assert.assertEquals(msg.toString(), actual.toString());
    }

    @Test
    public void getMessagesTest() {
        List<Message> messagesFromAPI = transactionCtrl.getMsgCtrl().getMessages();

        int actual = 21;

        Assert.assertEquals(messagesFromAPI.size(), actual);
    }
}

package youareell;

import com.fasterxml.jackson.core.JsonProcessingException;
import controllers.*;

import java.net.MalformedURLException;

public class YouAreEll {

    TransactionController transactionController;

    public YouAreEll (TransactionController transactionController) {
        this.transactionController = transactionController;
    }
    public YouAreEll (MessageController messageController, IdController idController) {
        transactionController = new TransactionController(messageController, idController);
    }

    public static void main(String[] args) throws MalformedURLException, JsonProcessingException {
        YouAreEll urlhandler = new YouAreEll(
            new TransactionController(
                new MessageController(), new IdController()
        ));

        // TODO write tests for examples below
//        Message msg = new Message();
//        msg.setFromId("chuddayo");
//        msg.setToId("");
//        msg.setMessage("hello zip coders!");
//        MessageController messageController = new MessageController();
//        System.out.println(messageController.postMessage(msg));

//        IdController idController = new IdController();
//        Id ryanID = new Id();
//        //ryanID.setUserid("897afaf4654043a51f8df0ecdf9b9307ccd91fef");
//        ryanID.setName("Mike");
//        ryanID.setGithub("mike-348");
//        System.out.println(idController.putId(ryanID));

//        System.out.println(ServerController.getServerInstance().getURL("ids"));
//        List<Id> idList = new IdController().getIds();
//        for (Id id : idList) {
//            System.out.println(id);
//        }

//        System.out.println(ServerController.getServerInstance().getURL("messages"));
//        List<Message> messageList = new MessageController().getMessages();
//        for (Message message : messageList) {
//            System.out.println(message);
//        }
    }

//    // MakeURLCall
//    public String MakeURLCall(String urlExtension, String requestType, String payload) {
//        return transactionController.makeRequest(urlExtension, requestType, payload);
//    }
}

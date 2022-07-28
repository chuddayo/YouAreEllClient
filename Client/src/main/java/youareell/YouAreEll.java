package youareell;

import com.fasterxml.jackson.core.JsonProcessingException;
import controllers.*;
import models.Id;
import models.Message;

import java.net.MalformedURLException;
import java.util.List;

public class YouAreEll {

    TransactionController transactionController;

    public YouAreEll (TransactionController transactionController) {
        this.transactionController = transactionController;
    }
    public YouAreEll (MessageController messageController, IdController idController) {
        transactionController = new TransactionController(messageController, idController);
    }

    public static void main(String[] args) throws MalformedURLException, JsonProcessingException {
        // hmm: is this Dependency Injection?
        YouAreEll urlhandler = new YouAreEll(
            new TransactionController(
                new MessageController(), new IdController()
        ));

        IdController idController = new IdController();
        Id ryanID = new Id();
        ryanID.setUserid("897afaf4654043a51f8df0ecdf9b9307ccd91fef");
        ryanID.setName("nick choi");
        ryanID.setGithub("chuddayo");
        System.out.println(idController.putId(ryanID));

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

    public String get_ids() {
        return transactionController.makeCall("/ids", "GET", "");
    }

    public String get_messages() {
        return MakeURLCall("/messages", "GET", "");
    }

    // MakeURLCall
    public String MakeURLCall(String extension, String type, String msg) {
        return transactionController.makeCall(extension, type, msg);
    }
}

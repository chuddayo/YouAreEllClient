package youareell;

import controllers.*;
import models.Id;

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

    public static void main(String[] args) throws MalformedURLException {
        // hmm: is this Dependency Injection?
        YouAreEll urlhandler = new YouAreEll(
            new TransactionController(
                new MessageController(), new IdController()
        ));

//        System.out.println(ServerController.getServerInstance().getURL("ids"));
//        List<Id> idList = new IdController().getIds();
//        for (Id id : idList) {
//            System.out.println(id);
//        }

        System.out.println(ServerController.getServerInstance().getURL("messages"));
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

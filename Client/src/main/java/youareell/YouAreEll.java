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
    }

}

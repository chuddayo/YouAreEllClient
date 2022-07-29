package controllers;

import com.fasterxml.jackson.databind.ObjectMapper;

public class TransactionController {
    private MessageController msgCtrl;
    private IdController idCtrl;
    private ObjectMapper mapper = new ObjectMapper();
    // TODO should TransactionController have a map for cached lists?

    public TransactionController(MessageController m, IdController j) {
        msgCtrl = m;
        idCtrl = j;
    }

    public MessageController getMsgCtrl() {
        return msgCtrl;
    }

    public IdController getIdCtrl() {
        return idCtrl;
    }
}

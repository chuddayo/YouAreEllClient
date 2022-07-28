package controllers;

import models.Id;

import java.util.List;

public class TransactionController {
    private MessageController msgCtrl;
    private IdController idCtrl;

    public TransactionController(MessageController m, IdController j) {
        msgCtrl = m;
        idCtrl = j;
    }

    public List<Id> getIds() {
        return null;
//        return idCtrl.getIds();
    }

    // TODO what are all the call types?
    // TODO should TransactionController have a map for cached lists?
    public String makeCall(String extension, String type, String msg) {
        if (extension.equals("/messages")) {
//            // TODO parse into string?
        } else if (extension.equals("/ids")) {
        }
        return null;
    }

    public String postId(String idToRegister, String githubName) {
//        Id tid = new Id(idToRegister, githubName);
//        tid = idCtrl.postId(tid);
        return ("Id registered.");
    }

    public MessageController getMsgCtrl() {
        return msgCtrl;
    }

    public void setMsgCtrl(MessageController msgCtrl) {
        this.msgCtrl = msgCtrl;
    }

    public IdController getIdCtrl() {
        return idCtrl;
    }

    public void setIdCtrl(IdController idCtrl) {
        this.idCtrl = idCtrl;
    }
}

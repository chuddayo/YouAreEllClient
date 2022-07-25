package controllers;

import models.Id;

import java.util.List;

public class TransactionController {
    private final String rootURL = "http://zipcode.rocks:8085";
    private MessageController msgCtrl;
    private IdController idCtrl;

    public TransactionController(MessageController m, IdController j) {
        msgCtrl = m;
        idCtrl = j;
    }

    public List<Id> getIds() {
        return idCtrl.getIds();
    }

    public String makeCall(String extension, String type, String msg) {
        if (extension.equals("/messages")) {
            msgCtrl.getMessages();
            // TODO parse into string?
        } else if (extension.equals("/ids")) {
            idCtrl.getIds();
            // TODO parse into string?
        }
        return null;
    }

    public String postId(String idToRegister, String githubName) {
        Id tid = new Id(idToRegister, githubName);
        tid = idCtrl.postId(tid);
        return ("Id registered.");
    }
}

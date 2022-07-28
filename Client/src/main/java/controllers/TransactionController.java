package controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Id;
import models.Message;

import java.net.MalformedURLException;

public class TransactionController {
    private MessageController msgCtrl;
    private IdController idCtrl;
    private ObjectMapper mapper = new ObjectMapper();
    // TODO should TransactionController have a map for cached lists?

    public TransactionController(MessageController m, IdController j) {
        msgCtrl = m;
        idCtrl = j;
    }


//    public String makeRequest(String urlExtension, String requestType, String payload) throws JsonProcessingException, MalformedURLException {
//        //
//        if (!payload.equals("") && !requestType.equals("GET")) {
//            if (urlExtension.equals("ids")) {
//                Id payloadId = mapper.readValue(payload, Id.class);
//                // TODO POST OR PUT
//                return getIdCtrl().postId(payloadId);
//            } else if (urlExtension.equals("messages")) {
//                Message payloadMessage = mapper.readValue(payload, Message.class);
//                // TODO POST OR PUT
//                return getMsgCtrl().postMessage(payloadMessage);
//            }
//        }
//
//        if (urlExtension.equals("ids")) { // request idController
//            if (requestType.equals("GET")) return getIdCtrl().getIdsAsList();
//        } else { // request messageController
//
//        }
//        return null;
//    }

//    public List<Id> getIds() {
//        return null;
////        return idCtrl.getIds();
//    }

//    public String postId(String idToRegister, String githubName) {
////        Id tid = new Id(idToRegister, githubName);
////        tid = idCtrl.postId(tid);
//        return ("Id registered.");
//    }

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

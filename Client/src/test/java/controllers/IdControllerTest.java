package controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import models.Id;
import org.junit.Assert;
import org.junit.Test;
import views.Console;

import java.net.MalformedURLException;
import java.util.List;

public class IdControllerTest {
    TransactionController transactionCtrl = new TransactionController(new MessageController(), new IdController());
    @Test
    public void getIdsTest() {
        List<Id> idsFromAPI = transactionCtrl.getIdCtrl().getIdsAsList();

        int actual = 100;

        Assert.assertTrue(idsFromAPI.size() > actual);
    }

    @Test
    public void putIdTest() throws MalformedURLException, JsonProcessingException {
        Id testId = new Id("testRyan", "chuddayo");
        testId.setUserid("897afaf4654043a51f8df0ecdf9b9307ccd91fef");

        Id actualId = transactionCtrl.getIdCtrl().putId(testId);

        Assert.assertEquals(testId.toString(), actualId.toString());
    }
}

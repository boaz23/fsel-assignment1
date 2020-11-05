package il.ac.bgu.cs.fsen211.hw1.services;

import il.ac.bgu.cs.fsen211.hw1.Driver;
import il.ac.bgu.cs.fsen211.hw1.interfaces.SellerReputationService;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SellerReputationServiceTest {
    SellerReputationService reputationService;

    public SellerReputationServiceTest() {
        reputationService = Driver.getService();
    }

    @Test
    public void rateTransactionReturnsTrueAlways() {
        assertTrue(reputationService.rateTransaction(1, 1, 2, 3, 4, ""));
    }
}

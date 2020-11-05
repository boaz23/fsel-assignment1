package il.ac.bgu.cs.fsen211.hw1.services;

import il.ac.bgu.cs.fsen211.hw1.interfaces.SellerReputationService;

public class SellerReputationServiceImpl implements SellerReputationService {
    @Override
    public boolean rateTransaction(int tId, int p1, int p2, int p3, int p4, String comment) {
        System.out.println("This is the real implementation of SellerReputationService");
        return true;
    }
}

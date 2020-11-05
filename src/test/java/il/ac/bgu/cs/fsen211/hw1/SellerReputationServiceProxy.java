package il.ac.bgu.cs.fsen211.hw1;

import il.ac.bgu.cs.fsen211.hw1.interfaces.SellerReputationService;

public class SellerReputationServiceProxy implements SellerReputationService {
    private SellerReputationService real;

    @Override
    public boolean rateTransaction(int tId, int p1, int p2, int p3, int p4, String comment) {
        if (real == null) {
            return false;
        } else {
            return real.rateTransaction(tId, p1, p2, p3, p4, comment);
        }
    }

    public void setReal(SellerReputationService real) {
        this.real = real;
    }
}

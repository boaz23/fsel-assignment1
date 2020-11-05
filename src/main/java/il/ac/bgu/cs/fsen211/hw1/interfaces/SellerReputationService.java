package il.ac.bgu.cs.fsen211.hw1.interfaces;

public interface SellerReputationService {
    boolean rateTransaction(int tId, int p1, int p2, int p3, int p4, String comment);
}

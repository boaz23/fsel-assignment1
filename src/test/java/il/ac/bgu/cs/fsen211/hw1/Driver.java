package il.ac.bgu.cs.fsen211.hw1;

import il.ac.bgu.cs.fsen211.hw1.interfaces.SellerReputationService;

public class Driver {
    public static SellerReputationService getService() {
        SellerReputationServiceProxy proxy = new SellerReputationServiceProxy();
        // Uncomment when real application is ready
        // proxy.setReal(new SellerReputationServiceImpl());
        return proxy;
    }
}

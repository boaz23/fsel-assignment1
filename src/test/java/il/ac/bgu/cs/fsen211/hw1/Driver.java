package il.ac.bgu.cs.fsen211.hw1;

import il.ac.bgu.cs.fsen211.hw1.interfaces.PaisShowsService;

public class Driver {
    public static PaisShowsService getService() {
        PaisShowsService service = new PaisShowsServiceProxy();
        // Uncomment when real application is ready
        // proxy.setReal(new PaisShowsServiceImpl());
        return service;
    }
}

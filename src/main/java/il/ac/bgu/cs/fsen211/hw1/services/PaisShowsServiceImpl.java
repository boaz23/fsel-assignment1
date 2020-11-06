package il.ac.bgu.cs.fsen211.hw1.services;

import il.ac.bgu.cs.fsen211.hw1.interfaces.PaisShowsService;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Date;
import java.util.List;

// TODO: implement in a later assignment
public class PaisShowsServiceImpl implements PaisShowsService {
    @Override
    public String login(String username, String password) {
        throw new NotImplementedException();
    }

    @Override
    public boolean logout(String userToken) {
        throw new NotImplementedException();
    }

    @Override
    public boolean addShow(String userToken, String name, String description, String theaterName, Date startDate, Double ticketPrice, Date lastDateForOrder, boolean exactTimePlanned) {
        throw new NotImplementedException();
    }

    @Override
    public int saveSeatsForShow(int showId, String name, String phoneNum, List<Integer> chairIds) {
        throw new NotImplementedException();
    }

    @Override
    public boolean cancelOrder(int orderId) {
        throw new NotImplementedException();
    }

    @Override
    public boolean payForOrder(int orderId, boolean isPhonePayment, String creditCardNum, String cvv, int cardExpirationMonth, int cardExpirationYear) {
        throw new NotImplementedException();
    }
}

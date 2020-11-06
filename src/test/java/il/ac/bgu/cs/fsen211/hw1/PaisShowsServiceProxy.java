package il.ac.bgu.cs.fsen211.hw1;

import il.ac.bgu.cs.fsen211.hw1.interfaces.PaisShowsService;

import java.util.Date;
import java.util.List;

public class PaisShowsServiceProxy implements PaisShowsService {
    private PaisShowsService realService;

    public PaisShowsServiceProxy() {
        this(null);
    }
    public PaisShowsServiceProxy(PaisShowsService realService) {
        this.realService = realService;
    }

    public void setReal(PaisShowsService realService) {
        this.realService = realService;
    }

    @Override
    public String login(String username, String password) {
        if (realService == null) {
            return null;
        }
        else {
            return realService.login(username, password);
        }
    }

    @Override
    public boolean logout(String userToken) {
        if (realService == null) {
            return false;
        }
        else {
            return realService.logout(userToken);
        }
    }

    @Override
    public boolean addShow(String userToken, String name, String description, String theaterName, Date startDate, Double ticketPrice, Date lastDateForOrder, boolean exactTimePlanned) {
        if (realService == null) {
            return false;
        }

        return realService.addShow(
            userToken,

            name,
            description,
            theaterName,
            startDate,
            ticketPrice,
            lastDateForOrder,
            exactTimePlanned
        );
    }

    @Override
    public int saveSeatsForShow(int showId, String name, String phoneNum, List<Integer> chairIds) {
        if (realService == null) {
            return -1;
        }

        return realService.saveSeatsForShow(showId, name, phoneNum, chairIds);
    }

    @Override
    public boolean cancelOrder(int orderId) {
        if (realService == null) {
            return false;
        }

        return realService.cancelOrder(orderId);
    }

    @Override
    public boolean payForOrder(int orderId, boolean isPhonePayment, String creditCardNum, String cvv, int cardExpirationMonth, int cardExpirationYear) {
        if (realService == null) {
            return false;
        }

        return realService.payForOrder(
            orderId,
            isPhonePayment,
            creditCardNum,
            cvv,
            cardExpirationMonth,
            cardExpirationYear
        );
    }
}

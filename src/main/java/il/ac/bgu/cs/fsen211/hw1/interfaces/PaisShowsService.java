package il.ac.bgu.cs.fsen211.hw1.interfaces;

import java.util.Date;
import java.util.List;

public interface PaisShowsService {
    // returns token to be sent to the server for identification
    String login(String username, String password);
    boolean logout(String userToken);

    boolean addShow(
        String userToken,

        String name,
        String description,
        String theaterName,
        Date startDate,
        Double ticketPrice,
        Date lastDateForOrder,

        // controls whether we take the time part of 'startDate' into account
        // or just the date
        boolean exactTimePlanned
    );

    // returns the order id or a negative number for a fail
    int saveSeatsForShow(int showId, String name, String phoneNum, List<Integer> chairIds);
    boolean cancelOrder(int orderId);

    boolean payForOrder(
        int orderId,
        boolean isPhonePayment,
        String creditCardNum,
        String cvv,
        int cardExpirationMonth,
        int cardExpirationYear
    );
}

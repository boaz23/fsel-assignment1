package il.ac.bgu.cs.fsen211.hw1.services;

import il.ac.bgu.cs.fsen211.hw1.Driver;
import il.ac.bgu.cs.fsen211.hw1.Utils;
import il.ac.bgu.cs.fsen211.hw1.interfaces.PaisShowsService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PaisOrderTicketTest {
    PaisShowsService service;

    List<Integer> defaultSeatsList;
    int orderId;

    public PaisOrderTicketTest() {
        service = Driver.getService();
    }

    @Before
    public void setup() {
        defaultSeatsList = new ArrayList<Integer>() {{
            add(5);
            add(8);
        }};
        orderId = service.saveSeatsForShow(1, "Name", "050-1234567", defaultSeatsList);
    }

    @After
    public void teardown() {
        if (orderId > 0) {
            service.cancelOrder(orderId);
        }
    }

    @Test
    public void saveSeatsTest_normal() {
        // seats are saved in the setup
        assertTrue(orderId > 0);
    }

    @Test
    public void saveSeatsTest_orderTakenSeats() {
        int secondOrderId = service.saveSeatsForShow(1, "Other Name", "054-0000000", defaultSeatsList);
        assertTrue(secondOrderId < 0);
    }

    @Test
    public void paymentForOrder_normalSuccess() {
        assertTrue(service.payForOrder(
            orderId,
            false,
            "1111 1234 5678 1597",
            "777",
            2,
            25
        ));
    }

    @Test
    public void paymentForOrder_invalidPaymentDetails() {
        assertFalse(service.payForOrder(
            orderId,
            true,
            "1111",
            "7",
            13,
            1000
        ));

        // assume the following credit card details have no sufficient credits
        // to approve this transaction
        assertFalse(service.payForOrder(
            orderId,
            false,
            "1111 1111 1111 1111",
            "888",
            4,
            2022
        ));
    }

    @Test
    public void paymentForOrder_payPastSaveTime() {
        try {
            Thread.sleep(Utils.MS_TO_HOUR);
            assertFalse(service.payForOrder(
                orderId,
                false,
                "1111 1234 5678 1597",
                "777",
                2,
                25
            ));

            assertFalse(service.payForOrder(
                orderId,
                false,
                "1111 5678 1597",
                "777",
                2,
                25
            ));
        } catch (InterruptedException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void payForOrder_missingPaymentDetails() {
        assertFalse(service.payForOrder(
            orderId,
            false,
            null,
            null,
            2,
            25
        ));
    }
}

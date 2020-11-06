package il.ac.bgu.cs.fsen211.hw1.services;

import il.ac.bgu.cs.fsen211.hw1.Driver;
import il.ac.bgu.cs.fsen211.hw1.Utils;
import il.ac.bgu.cs.fsen211.hw1.interfaces.PaisShowsService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PaisAddShowsTest {
    PaisShowsService service;
    String userToken;

    public PaisAddShowsTest() {
        service = Driver.getService();
    }

    @Before
    public void setup() {
        service.login("admin", "admin");
    }

    @After
    public void teardown() {
        service.logout(userToken);
    }

    @Test
    public void addShowTest_normalSuccessful() {
        assertTrue(service.addShow(
            userToken,

            "name",
            "desc",
            "theater",
            Utils.createDate(2021, 1, 20),
            50.0,
            Utils.createDate(2021, 1, 10),
            false
        ));
    }

    @Test
    public void addShowTest_theaterExistsOnlyInAnotherCity() {
        assertFalse(service.addShow(
            userToken,

            "name 2",
            "desc 2",
            "theater in another city",
            Utils.createDate(2021, 1, 19),
            60.0,
            Utils.createDate(2021, 1, 12),
            false
        ));
    }

    @Test
    public void addShowTest_MissingDetails() {
        assertFalse(service.addShow(
            userToken,

            "",
            "a nice description",
            "my theater",
            Utils.createDate(2021, 1, 19),
            60.0,
            Utils.createDate(2021, 1, 12),
            false
        ));

        assertFalse(service.addShow(
            userToken,

            "nice name",
            "a nice description",
            "my theater",
            null,
            null,
            Utils.createDate(2021, 1, 12),
            false
        ));
    }

    @Test
    public void addShowTest_theaterAlsoExistsInAnotherCity() {
        assertTrue(service.addShow(
            userToken,

            "name 2",
            "d",
            "theater which is also in another city",
            Utils.createDate(2021, 1, 19),
            55.0,
            Utils.createDate(2021, 1, 11),
            false
        ));
    }
}

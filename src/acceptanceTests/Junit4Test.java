package acceptanceTests;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Junit4Test {
    @Before
    public void setup() {
        System.out.println("hello");
    }

    @Test
    public void evaluatesExpression() {
        assertEquals(1, 2);
    }
}

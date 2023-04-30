import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {
    Bun bun;

    @Before
    public void setUp() {
        bun = new Bun("Просто космос", 5.25f);
    }

    @Test
    public void checkCorrectName() {
        assertEquals("Просто космос", bun.getName());
    }

    @Test
    public void checkCorrectPrice() {
        assertEquals(5.25f, bun.getPrice(), 0);
    }
}

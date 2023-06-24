import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;
import testData.TestNames;
import testData.TestPrices;

import static org.junit.Assert.assertEquals;

public class BunTest {
    Bun bun;

    @Before
    public void setUp() {
        bun = new Bun(TestNames.BUN_NAME, TestPrices.BUN_PRICE);
    }

    @Test
    public void getNameCheckThatNameIsCorrect() {
        assertEquals(TestNames.BUN_NAME, bun.getName());
    }

    @Test
    public void getPriceCheckThatPriceIsCorrect() {
        assertEquals(TestPrices.BUN_PRICE, bun.getPrice(), 0);
    }
}

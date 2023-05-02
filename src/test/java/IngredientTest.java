import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;
import testData.TestNames;
import testData.TestPrices;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {
    Ingredient ingredient;
    private final String name;
    private final float price;
    private final IngredientType type;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Ингредиент: {0} {1} {2}")
    public static Object[] createIngredient() {
        return new Object[][]{
                {IngredientType.FILLING, TestNames.FILLING_NAME, TestPrices.FILLING_PRICE},
                {IngredientType.SAUCE, TestNames.SAUCE_NAME, TestPrices.SAUCE_PRICE},

        };
    }

    @Before
    public void setUp() {
        ingredient = new Ingredient(type, name, price);
    }

    @Test
    public void getNameCheckThatNameIsCorrect() {
        assertEquals(name, ingredient.getName());
    }

    @Test
    public void getPriceCheckThatPriceIsCorrect() {
        assertEquals(price, ingredient.getPrice(), 0);
    }

    @Test
    public void getTypeCheckThatTypeIsCorrect() {
        assertEquals(type, ingredient.getType());
    }

}

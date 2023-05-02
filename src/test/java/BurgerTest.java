import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;
import testData.TestNames;
import testData.TestPrices;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    Burger burger;

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredientSauce;

    @Mock
    Ingredient ingredientFilling;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void addIngredientOneSauceAmountIsCorrect() {
        List<Ingredient> expectedIngredients = new ArrayList<>();
        expectedIngredients.add(ingredientSauce);
        burger.addIngredient(ingredientSauce);
        assertEquals(expectedIngredients.size(), burger.ingredients.size());

    }

    @Test
    public void removeIngredientOneSauceZeroAmount() {
        burger.addIngredient(ingredientSauce);
        burger.removeIngredient(0);
        assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void moveIngredientReplaceItemsOrderIsCorrect() {
        List<Ingredient> expectedOrder = new ArrayList<>(2);
        expectedOrder.add(ingredientFilling);
        expectedOrder.add(ingredientSauce);

        burger.addIngredient(ingredientSauce);
        burger.addIngredient(ingredientFilling);
        burger.moveIngredient(0, 1);
        assertEquals(expectedOrder, burger.ingredients);
    }

    @Test
    public void getPriceThreeItemsPriceIsCorrect() {
        Mockito.when(bun.getPrice()).thenReturn(TestPrices.BUN_PRICE);
        Mockito.when(ingredientSauce.getPrice()).thenReturn(TestPrices.SAUCE_PRICE);
        Mockito.when(ingredientFilling.getPrice()).thenReturn(TestPrices.FILLING_PRICE);
        float expectedBurgerPrice = TestPrices.EXPECTED_BURGER_PRICE;

        burger.setBuns(bun);
        burger.addIngredient(ingredientFilling);
        burger.addIngredient(ingredientSauce);

        assertEquals(expectedBurgerPrice, burger.getPrice(), 0);
    }

    @Test
    public void getReceiptThreeItemsReceiptIsCorrect() {
        String expectedReceipt;
        String formattedBurgerPrice = String.format("%f%n", TestPrices.EXPECTED_BURGER_PRICE);
        expectedReceipt = "(==== " + TestNames.BUN_NAME + " ====)\n" + "= " + IngredientType.FILLING.toString().toLowerCase() + " " + TestNames.FILLING_NAME + " =\n" + "= " + IngredientType.SAUCE.toString().toLowerCase() + " " + TestNames.SAUCE_NAME + " =\n" + "(==== " + TestNames.BUN_NAME + " ====)\n\n" + "Price: " + formattedBurgerPrice;

        Mockito.when(bun.getName()).thenReturn(TestNames.BUN_NAME);
        Mockito.when(ingredientFilling.getName()).thenReturn(TestNames.FILLING_NAME);
        Mockito.when(ingredientSauce.getName()).thenReturn(TestNames.SAUCE_NAME);
        Mockito.when(bun.getPrice()).thenReturn(TestPrices.BUN_PRICE);
        Mockito.when(ingredientFilling.getPrice()).thenReturn(TestPrices.FILLING_PRICE);
        Mockito.when(ingredientSauce.getPrice()).thenReturn(TestPrices.SAUCE_PRICE);
        Mockito.when(ingredientFilling.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredientSauce.getType()).thenReturn(IngredientType.SAUCE);

        burger.setBuns(bun);
        burger.addIngredient(ingredientFilling);
        burger.addIngredient(ingredientSauce);
        assertEquals(expectedReceipt, burger.getReceipt());
    }

}

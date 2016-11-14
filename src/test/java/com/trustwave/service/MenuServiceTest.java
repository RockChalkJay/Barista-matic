package com.trustwave.service;

import com.trustwave.drink.*;

import com.trustwave.ingredients.Ingredient;
import com.trustwave.ingredients.IngredientImpl;
import javafx.util.Pair;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by jharris on 11/10/16.
 */
public class MenuServiceTest {

    private MenuService menuService;
    private InventoryService inventoryService;

    @Before
    public void initialize() {
        inventoryService = new InventoryServiceImpl();
        menuService = new MenuServiceImpl(inventoryService);
    }

    @Test
    public void tesGetDrinks() {
        ArrayList<Drink> drinks = menuService.getDrinks();
        assert (drinks.size() == 6);
    }

    @Test
    public void testSetDrinks() {
        ArrayList<Drink> drinks = new ArrayList<>();
        CaffeMocha cm = new CaffeMocha();
        drinks.add(cm);
        menuService.setDrinks(drinks);

        assert (menuService.getDrinks().size() == 1);
        assert (menuService.getDrinks().get(0).getName() == cm.getName());
    }

    @Test
    public void testIsDrinkInStock() {
        CaffeAmericano ca = new CaffeAmericano();
        assert (menuService.isDrinkInStock(ca));
        assert (menuService.orderDrink(ca));
        assert (menuService.orderDrink(ca));
        assert (menuService.orderDrink(ca));
        assert (!menuService.isDrinkInStock(ca));

        ArrayList<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new IngredientImpl("Whiskey", 5));
        InventoryService is = new InventoryServiceImpl(ingredients);
        ArrayList<Drink> drinks = new ArrayList<>();
        drinks.add(new Coffee());
        menuService = new MenuServiceImpl(is, drinks);
        assert (!menuService.isDrinkInStock(new Coffee()));
    }

    @Test
    public void testOrderDrink() {
        CaffeAmericano ca = new CaffeAmericano();
        assert (menuService.orderDrink(ca));
        assert (menuService.orderDrink(ca));
        assert (menuService.orderDrink(ca));
        assert (!menuService.orderDrink(ca));

        //order an invalid drink
        ArrayList<Pair<Ingredient, Integer>> ingredients = new ArrayList<>();
        ingredients.add(new Pair(new IngredientImpl("Some root", .66), new Integer(2)));
        assert (!menuService.orderDrink(new DrinkImpl("Sarsaparilla", ingredients)));
    }

    @Test
    public void testOrderDrinkByNumber() {
        assert (menuService.orderDrink(1));
        assert (menuService.orderDrink(1));
        assert (menuService.orderDrink(1));
        assert (!menuService.orderDrink(1));

        //order an invalid drink
        assert (!menuService.orderDrink(42));
    }

}

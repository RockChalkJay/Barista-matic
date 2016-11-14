package com.trustwave.service;

import com.trustwave.drink.Drink;
import com.trustwave.drink.CaffeAmericano;
import com.trustwave.drink.CaffeMocha;

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
    }

    @Test
    public void testOrderDrink() {
        CaffeAmericano ca = new CaffeAmericano();
        assert (menuService.orderDrink(ca));
        assert (menuService.orderDrink(ca));
        assert (menuService.orderDrink(ca));
        assert (!menuService.orderDrink(ca));
    }

    @Test
    public void testOrderDrinkByNumber() {
        assert (menuService.orderDrink(1));
        assert (menuService.orderDrink(1));
        assert (menuService.orderDrink(1));
        assert (!menuService.orderDrink(1));
    }

}

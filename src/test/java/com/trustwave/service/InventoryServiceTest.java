package com.trustwave.service;

import com.trustwave.ingredients.Ingredient;
import com.trustwave.ingredients.Sugar;
import org.junit.Test;

/**
 * Created by jharris on 11/10/16.
 */
public class InventoryServiceTest {

    @Test
    public void testRestock() {}

    @Test
    public void testUseIngrediant() {
        InventoryService is = new InventoryService();
        Sugar sugar = new Sugar();
        assert (is.getAmountOfIngredient(sugar) == 10);
        assert (is.useIngredient(sugar, 3) == 7);
        assert (is.getAmountOfIngredient(sugar) == 7);
        System.out.println(is.toString());
    }

    @Test
    public void testAddIngrediant() {}

    @Test
    public void testGetEmptyIngrediant() {}

    @Test
    public void testGetIngrediantWithNullParam() {}

    @Test
    public void testGetAllInventory() {}

    @Test
    public void testCheckInventory() {}

}

package com.trustwave.ingredients;

import org.junit.Test;

/**
 * Created by jharris on 11/10/16.
 */
public class IngredientTest {

    @Test
    public void testGetName() {
        Ingredient ingredient = new IngredientImpl("Coke", .99);
        assert (ingredient.getName().equals("Coke"));
    }

    @Test
    public void testGetCost() {
        Ingredient ingredient = new IngredientImpl("Coke", .99);
        assert (ingredient.getCost() == .99);
    }
}

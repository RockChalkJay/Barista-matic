package com.trustwave.service;

import com.trustwave.ingredients.*;

import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by jharris on 11/10/16.
 */
public class InventoryServiceTest {

    @Test
    public void testUseIngrediant() {
        InventoryService is = new InventoryServiceImpl();
        Sugar sugar = new Sugar();
        assert (is.getAmountOfIngredient(sugar) == 10);
        assert (is.useIngredient(sugar, 3) == 7);
        assert (is.getAmountOfIngredient(sugar) == 7);
    }

    @Test
    public void testAmountOfIngrediant() {
        ArrayList<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new IngredientImpl("Egg nog", 1.25));
        InventoryService is = new InventoryServiceImpl(ingredients);
        assert ((is.getAmountOfIngredient(ingredients.get(0)) == 10));
        assert (is.useIngredient(ingredients.get(0), 11) == -1);
        assert (is.useIngredient(ingredients.get(0), -42) == -1);
        assert (is.useIngredient(ingredients.get(0), 10) == 0);
    }

    @Test
    public void testGetEmptyIngrediant() {
        ArrayList<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new IngredientImpl("Nutmeg", .25));
        InventoryService is = new InventoryServiceImpl(ingredients);
        assert ((is.getAmountOfIngredient(ingredients.get(0)) == 10));
        assert (is.useIngredient(ingredients.get(0), 10) == 0);
        assert (is.useIngredient(ingredients.get(0), 1) == -1);;
    }

    @Test
    public void testGetIngrediantWithNullParam() {
        InventoryService is = new InventoryServiceImpl();
        assert ((is.getAmountOfIngredient(null) == -1));
    }

    @Test
    public void testRestock() {
        InventoryService is = new InventoryServiceImpl();
        Cocoa co = new Cocoa();
        Coffee cof = new Coffee();
        DecafCoffee def = new DecafCoffee();
        Espresso es = new Espresso();
        FoamedMilk fm = new FoamedMilk();
        SteamedMilk sm = new SteamedMilk();
        Sugar sug = new Sugar();
        WhippedCream wc = new WhippedCream();
        Cream cr = new Cream();

        is.useIngredient(co, 10);
        is.useIngredient(cof, 10);
        is.useIngredient(def, 10);
        is.useIngredient(es, 10);
        is.useIngredient(fm, 10);
        is.useIngredient(sm, 10);
        is.useIngredient(sug, 10);
        is.useIngredient(wc, 10);
        is.useIngredient(cr, 10);

        is.restock();

        assert (is.getAmountOfIngredient(co) == 10);
        assert (is.getAmountOfIngredient(cof) == 10);
        assert (is.getAmountOfIngredient(def) == 10);
        assert (is.getAmountOfIngredient(es) == 10);
        assert (is.getAmountOfIngredient(fm) == 10);
        assert (is.getAmountOfIngredient(sm) == 10);
        assert (is.getAmountOfIngredient(sug) == 10);
        assert (is.getAmountOfIngredient(wc) == 10);
        assert (is.getAmountOfIngredient(cr) == 10);
    }

}

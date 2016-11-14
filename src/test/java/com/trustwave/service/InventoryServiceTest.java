package com.trustwave.service;

import com.trustwave.ingredients.*;

import org.junit.Test;

import java.util.ArrayList;

import static com.trustwave.service.InventoryService.MAX_CAPACITY;

/**
 * Created by jharris on 11/MAX_CAPACITY/16.
 */
public class InventoryServiceTest {

    @Test
    public void testAddIngredient() {
        InventoryService is = new InventoryServiceImpl();
        Ingredient ingredient = new IngredientImpl("Rat Posion", 2.99);
        is.addIngredient(ingredient);
        assert (is.getAmountOfIngredient(ingredient) == MAX_CAPACITY);
    }

    @Test
    public void testRemoveIngredient() {
        InventoryService is = new InventoryServiceImpl();
        Ingredient ingredient = new IngredientImpl("Rat Posion", 2.99);
        is.addIngredient(ingredient);
        is.removeIngredient(ingredient);
        assert (is.getAmountOfIngredient(ingredient) == -1);
    }
    
    @Test
    public void testUseIngrediant() {
        InventoryService is = new InventoryServiceImpl();
        Sugar sugar = new Sugar();
        assert (is.getAmountOfIngredient(sugar) == MAX_CAPACITY);
        assert (is.useIngredient(sugar, 3) == 7);
        assert (is.getAmountOfIngredient(sugar) == 7);
    }

    @Test
    public void testAmountOfIngrediant() {
        ArrayList<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new IngredientImpl("Egg nog", 1.25));
        InventoryService is = new InventoryServiceImpl(ingredients);
        assert ((is.getAmountOfIngredient(ingredients.get(0)) == MAX_CAPACITY));
        assert (is.useIngredient(ingredients.get(0), 11) == -1);
        assert (is.useIngredient(ingredients.get(0), -42) == -1);
        assert (is.useIngredient(ingredients.get(0), MAX_CAPACITY) == 0);
    }

    @Test
    public void testGetEmptyIngrediant() {
        ArrayList<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new IngredientImpl("Nutmeg", .25));
        InventoryService is = new InventoryServiceImpl(ingredients);
        assert ((is.getAmountOfIngredient(ingredients.get(0)) == MAX_CAPACITY));
        assert (is.useIngredient(ingredients.get(0), MAX_CAPACITY) == 0);
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

        is.useIngredient(co, MAX_CAPACITY);
        is.useIngredient(cof, MAX_CAPACITY);
        is.useIngredient(def, MAX_CAPACITY);
        is.useIngredient(es, MAX_CAPACITY);
        is.useIngredient(fm, MAX_CAPACITY);
        is.useIngredient(sm, MAX_CAPACITY);
        is.useIngredient(sug, MAX_CAPACITY);
        is.useIngredient(wc, MAX_CAPACITY);
        is.useIngredient(cr, MAX_CAPACITY);

        is.restock();

        assert (is.getAmountOfIngredient(co) == MAX_CAPACITY);
        assert (is.getAmountOfIngredient(cof) == MAX_CAPACITY);
        assert (is.getAmountOfIngredient(def) == MAX_CAPACITY);
        assert (is.getAmountOfIngredient(es) == MAX_CAPACITY);
        assert (is.getAmountOfIngredient(fm) == MAX_CAPACITY);
        assert (is.getAmountOfIngredient(sm) == MAX_CAPACITY);
        assert (is.getAmountOfIngredient(sug) == MAX_CAPACITY);
        assert (is.getAmountOfIngredient(wc) == MAX_CAPACITY);
        assert (is.getAmountOfIngredient(cr) == MAX_CAPACITY);
    }

}

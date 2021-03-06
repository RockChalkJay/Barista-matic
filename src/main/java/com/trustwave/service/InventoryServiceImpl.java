package com.trustwave.service;

import com.trustwave.ingredients.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Created by jharris on 11/10/16.
 */
public class InventoryServiceImpl implements InventoryService {


    public HashMap<String, Integer> stock = new HashMap<>();

    public InventoryServiceImpl() {
        stock.put(new Cocoa().getName(), new Integer(MAX_CAPACITY));
        stock.put(new Coffee().getName(), new Integer(MAX_CAPACITY));
        stock.put(new DecafCoffee().getName(), new Integer(MAX_CAPACITY));
        stock.put(new Espresso().getName(), new Integer(MAX_CAPACITY));
        stock.put(new FoamedMilk().getName(), new Integer(MAX_CAPACITY));
        stock.put(new SteamedMilk().getName(), new Integer(MAX_CAPACITY));
        stock.put(new Sugar().getName(), new Integer(MAX_CAPACITY));
        stock.put(new WhippedCream().getName(), new Integer(MAX_CAPACITY));
        stock.put(new Cream().getName(), new Integer(MAX_CAPACITY));
    }

    public InventoryServiceImpl(List<Ingredient> ingredients) {
        for (Ingredient ingredient:ingredients) {
            stock.put(ingredient.getName(), new Integer(MAX_CAPACITY));
        }
    }

    @Override
    public void addIngredient(Ingredient ingredient) {
        stock.put(ingredient.getName(), MAX_CAPACITY);
    }

    @Override
    public void removeIngredient(Ingredient ingredient) {
        stock.remove(ingredient.getName());
    }

    //TODO - add comment
    @Override
    public int getAmountOfIngredient(Ingredient ingredient) {
        if (ingredient == null) {
            return -1;
        }
        Integer amount = (Integer)stock.get(ingredient.getName());

        if(amount == null) {
            return -1;
        }

        return amount.intValue();
    }

    @Override
    public int useIngredient(Ingredient ingredient, int amount) {
        Integer stockAmount = stock.get(ingredient.getName());
        if(amount < 0 || stockAmount.intValue() < amount) {
            return -1;
        }

        stockAmount = new Integer(stockAmount.intValue() - amount);
        stock.put(ingredient.getName(), stockAmount);

        return stockAmount.intValue();
    }

    @Override
    public void restock() {
        for(String ingredient : stock.keySet()) {
            stock.put(ingredient, new Integer(MAX_CAPACITY));
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Inventory:\n");
        List<String> listOfIngredients = new ArrayList(stock.keySet());
        Collections.sort(listOfIngredients, String.CASE_INSENSITIVE_ORDER);
        for (String ingredient:listOfIngredients) {
            sb.append("\n");
            sb.append(ingredient + "," + stock.get(ingredient).intValue());
            sb.append("\n");
        }
        return sb.toString();
    }

}

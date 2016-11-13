package com.trustwave.service;

import com.trustwave.ingredients.*;

import java.util.*;

/**
 * Created by jharris on 11/10/16.
 */
public class InventoryService {

    public HashMap<String, Integer> stock = new HashMap<>();

    public InventoryService() {
        stock.put(new Cocoa().getName(), new Integer(10));
        stock.put(new Coffee().getName(), new Integer(10));
        stock.put(new DecafCoffee().getName(), new Integer(10));
        stock.put(new Espresso().getName(), new Integer(10));
        stock.put(new FoamedMilk().getName(), new Integer(10));
        stock.put(new SteamedMilk().getName(), new Integer(10));
        stock.put(new Sugar().getName(), new Integer(10));
        stock.put(new WhippedCream().getName(), new Integer(10));
        stock.put(new Cream().getName(), new Integer(10));
    }

    public InventoryService(List<Ingredient> ingredients) {
        for (Ingredient ingredient:ingredients) {
            stock.put(ingredient.getName(), new Integer(10));
        }
    }

    public int getAmountOfIngredient(Ingredient ingredient) {
        return ((Integer)stock.get(ingredient.getName()).intValue());
    }

    public int useIngredient(Ingredient ingredient, int amount) {
        Integer stockAmount = stock.get(ingredient.getName());
        if(amount < 0 || stockAmount.intValue() < amount) {
            return -1;
        }

        stockAmount = new Integer(stockAmount.intValue() - amount);
        stock.put(ingredient.getName(), stockAmount);

        return stockAmount.intValue();
    }

    public void restock() {
        for(String ingredient : stock.keySet()) {
            stock.put(ingredient, new Integer(10));
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

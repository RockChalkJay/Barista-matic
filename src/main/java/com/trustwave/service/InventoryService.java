package com.trustwave.service;

import com.trustwave.ingredients.Ingredient;

/**
 * Created by jharris on 11/10/16.
 */
public interface InventoryService {

    public static final int MAX_CAPACITY = 10;

    public void addIngredient(Ingredient ingredient);

    public void removeIngredient(Ingredient ingredient);

    public int getAmountOfIngredient(Ingredient ingredient);

    public int useIngredient(Ingredient ingredient, int amount);

    public void restock();

    @Override
    public String toString();

}

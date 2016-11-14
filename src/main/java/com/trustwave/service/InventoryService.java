package com.trustwave.service;

import com.trustwave.ingredients.*;

import java.util.*;

/**
 * Created by jharris on 11/10/16.
 */
public interface InventoryService {

    public int getAmountOfIngredient(Ingredient ingredient);

    public int useIngredient(Ingredient ingredient, int amount);

    public void restock();

    @Override
    public String toString();

}

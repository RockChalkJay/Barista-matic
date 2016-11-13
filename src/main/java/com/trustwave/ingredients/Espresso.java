package com.trustwave.ingredients;

/**
 * Created by jharris on 11/10/16.
 */
public class Espresso implements Ingredient {

    @Override
    public String getName() {
        return "Espresso";
    }

    @Override
    public double getCost() {
        return  1.10;
    }
}

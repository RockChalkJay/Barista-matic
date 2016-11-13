package com.trustwave.ingredients;

/**
 * Created by jharris on 11/10/16.
 */
public class DecafCoffee implements Ingredient {

    @Override
    public String getName() {
        return "DecafCoffee";
    }

    @Override
    public double getCost() {
        return  .75;
    }
}

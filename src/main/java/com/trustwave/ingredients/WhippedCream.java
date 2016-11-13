package com.trustwave.ingredients;

/**
 * Created by jharris on 11/10/16.
 */
public class WhippedCream implements Ingredient {

    @Override
    public String getName() {
        return "Whipped Cream";
    }

    @Override
    public double getCost() {
        return  1;
    }
}

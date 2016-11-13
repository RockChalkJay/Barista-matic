package com.trustwave.ingredients;

/**
 * Created by jharris on 11/10/16.
 */
public class Cream implements Ingredient {

    @Override
    public String getName() {
        return "Cream";
    }

    @Override
    public double getCost() {
        return  .25;
    }
}

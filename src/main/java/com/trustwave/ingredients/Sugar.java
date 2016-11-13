package com.trustwave.ingredients;

/**
 * Created by jharris on 11/10/16.
 */
public class Sugar implements Ingredient {

    @Override
    public String getName() {
        return "Sugar";
    }

    @Override
    public double getCost() {
        return  .25;
    }
}

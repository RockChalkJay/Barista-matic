package com.trustwave.ingredients;

/**
 * Created by jharris on 11/10/16.
 */
public class Coffee implements Ingredient {

    @Override
    public String getName() {
        return "Coffee";
    }

    @Override
    public double getCost() {
        return  .75;
    }
}

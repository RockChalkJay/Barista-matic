package com.trustwave.ingredients;

/**
 * Created by jharris on 11/10/16.
 */
public class SteamedMilk implements Ingredient {

    @Override
    public String getName() {
        return "SteamedMilk";
    }

    @Override
    public double getCost() {
        return  .35;
    }
}

package com.trustwave.ingredients;

/**
 * Created by jharris on 11/10/16.
 */
public class FoamedMilk implements Ingredient {

    @Override
    public String getName() {
        return "FoamedMilk";
    }

    @Override
    public double getCost() {
        return  .35;
    }
}

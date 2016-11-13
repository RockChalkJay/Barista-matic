package com.trustwave.ingredients;

/**
 * Created by jharris on 11/10/16.
 */
public class Cocoa implements Ingredient {

    @Override
    public String getName() {
        return "Cocoa";
    }

    @Override
    public double getCost() {
        return  .90;
    }
}

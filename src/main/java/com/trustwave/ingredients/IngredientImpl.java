package com.trustwave.ingredients;

/**
 * Created by jharris on 11/13/16.
 */
public class IngredientImpl implements Ingredient {

    private String name;
    private double cost;

    public IngredientImpl(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getCost() {
        return cost;
    }
}

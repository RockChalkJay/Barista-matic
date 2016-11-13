package com.trustwave.ingredients;

import javafx.util.Pair;

import java.util.ArrayList;

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

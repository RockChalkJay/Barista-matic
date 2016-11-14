package com.trustwave.drink;

import com.trustwave.ingredients.Ingredient;
import javafx.util.Pair;

import java.util.ArrayList;

/**
 * Created by jharris on 11/13/16.
 */
public interface Drink {

    public String getName();

    public void setName(String name);

    public ArrayList< Pair<Ingredient,Integer> > getIngredients();

    public void setIngredients(ArrayList<Pair<Ingredient, Integer>> ingredients);

    public double getCost();
}

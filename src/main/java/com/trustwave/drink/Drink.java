package com.trustwave.drink;

import java.util.ArrayList;
import javafx.util.Pair;

import com.trustwave.ingredients.Ingredient;


/**
 * Created by jharris on 11/10/16.
 */
public interface Drink {
    public ArrayList< Pair<Ingredient,Integer> > getIngredients();
}

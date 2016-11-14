package com.trustwave.drink;

import com.trustwave.ingredients.Ingredient;
import javafx.util.Pair;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;


/**
 * Created by jharris on 11/10/16.
 */
public class DrinkImpl implements Drink {


    protected String name;
    protected ArrayList<Pair<Ingredient, Integer>> ingredients = new ArrayList<>();

    public DrinkImpl() {
    }

    public DrinkImpl(String name, ArrayList<Pair<Ingredient, Integer>> ingredients) {
        this.name = name;
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Pair<Ingredient, Integer>> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<Pair<Ingredient, Integer>> ingredients) {
        this.ingredients = ingredients;
    }

    public double getCost() {
        if (ingredients == null) {
            return 0;
        }

        double result = 0;
        for (Pair<Ingredient, Integer> ingredientCount : ingredients) {
            result += ingredientCount.getKey().getCost() * ingredientCount.getValue();
        }

        //We have to use BigDecimal here because double multiplication can do funny things
        BigDecimal r = new BigDecimal(result);
        r = r.setScale(2, RoundingMode.HALF_UP);
        return r.doubleValue();
    }
}

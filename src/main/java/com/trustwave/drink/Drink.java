package com.trustwave.drink;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import javafx.util.Pair;

import com.trustwave.ingredients.Ingredient;


/**
 * Created by jharris on 11/10/16.
 */
public class Drink {


    protected String name;
    protected ArrayList< Pair<Ingredient,Integer> > ingredients = new ArrayList<>();

    public Drink() {}

    public Drink(String name, ArrayList< Pair<Ingredient,Integer> > ingredients) {
        this.name = name;
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList< Pair<Ingredient,Integer> > getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<Pair<Ingredient, Integer>> ingredients) {
        this.ingredients = ingredients;
    }

    public double getCost() {
        if (ingredients == null) {
            return 0;
        }

        //TODO -- explain double multipition issue
        double result = 0;
        for (Pair<Ingredient,Integer> ingredientCount: ingredients) {
            result += ingredientCount.getKey().getCost() * ingredientCount.getValue();
        }

        BigDecimal r = new BigDecimal(result);
        r = r.setScale(2, RoundingMode.HALF_UP);
        return r.doubleValue();
    }

}

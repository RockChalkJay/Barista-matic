package com.trustwave.drink;

import com.trustwave.ingredients.Espresso;
import com.trustwave.ingredients.Ingredient;
import javafx.util.Pair;

import java.util.ArrayList;

/**
 * Created by jharris on 11/10/16.
 */
public class CaffeAmericano extends Drink {

    public CaffeAmericano() {
        name = "Caffe Americano";
        ingredients.add(new Pair(new Espresso(), new Integer(3)));
    }
}

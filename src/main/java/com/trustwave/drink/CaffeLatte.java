package com.trustwave.drink;

import com.trustwave.ingredients.Espresso;
import com.trustwave.ingredients.SteamedMilk;
import javafx.util.Pair;

/**
 * Created by jharris on 11/10/16.
 */
public class CaffeLatte extends DrinkImpl {

    public CaffeLatte() {
        name = "Caffe Latte";
        ingredients.add(new Pair(new Espresso(), new Integer(2)));
        ingredients.add(new Pair(new SteamedMilk(), new Integer(1)));
    }
}

package com.trustwave.drink;

import com.trustwave.ingredients.Espresso;
import javafx.util.Pair;

/**
 * Created by jharris on 11/10/16.
 */
public class CaffeAmericano extends DrinkImpl {

    public CaffeAmericano() {
        name = "Caffe Americano";
        ingredients.add(new Pair(new Espresso(), new Integer(3)));
    }
}

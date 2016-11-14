package com.trustwave.drink;


import com.trustwave.ingredients.Cream;
import com.trustwave.ingredients.Sugar;
import javafx.util.Pair;

/**
 * Created by jharris on 11/10/16.
 */
public class Coffee extends DrinkImpl {

    public Coffee() {
        name = "Coffee";
        ingredients.add(new Pair(new com.trustwave.ingredients.Coffee(), new Integer(3)));
        ingredients.add(new Pair(new Sugar(), new Integer(1)));
        ingredients.add(new Pair(new Cream(), new Integer(1)));
    }
}

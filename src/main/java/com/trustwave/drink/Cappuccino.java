package com.trustwave.drink;

import com.trustwave.ingredients.Espresso;
import com.trustwave.ingredients.FoamedMilk;
import com.trustwave.ingredients.SteamedMilk;
import javafx.util.Pair;

/**
 * Created by jharris on 11/10/16.
 */
public class Cappuccino extends DrinkImpl {

    public Cappuccino() {
        name = "Cappuccino";
        ingredients.add(new Pair(new Espresso(), new Integer(2)));
        ingredients.add(new Pair(new SteamedMilk(), new Integer(1)));
        ingredients.add(new Pair(new FoamedMilk(), new Integer(1)));
    }
}

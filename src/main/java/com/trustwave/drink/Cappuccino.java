package com.trustwave.drink;

import com.trustwave.ingredients.*;
import javafx.util.Pair;

import java.util.ArrayList;

/**
 * Created by jharris on 11/10/16.
 */
public class Cappuccino extends Drink {

    public Cappuccino() {
        name = "Cappuccino";
        ingredients.add(new Pair(new Espresso(), new Integer(2)));
        ingredients.add(new Pair(new SteamedMilk(), new Integer(1)));
        ingredients.add(new Pair(new FoamedMilk(), new Integer(1)));
    }
}

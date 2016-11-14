package com.trustwave.drink;

import com.trustwave.ingredients.Cocoa;
import com.trustwave.ingredients.Espresso;
import com.trustwave.ingredients.SteamedMilk;
import com.trustwave.ingredients.WhippedCream;
import javafx.util.Pair;

/**
 * Created by jharris on 11/10/16.
 */
public class CaffeMocha extends DrinkImpl {

    public CaffeMocha() {
        name = "Caffe Mocha";
        ingredients.add(new Pair(new Espresso(), new Integer(1)));
        ingredients.add(new Pair(new Cocoa(), new Integer(1)));
        ingredients.add(new Pair(new SteamedMilk(), new Integer(1)));
        ingredients.add(new Pair(new WhippedCream(), new Integer(1)));
    }
}

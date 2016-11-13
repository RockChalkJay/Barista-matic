package com.trustwave.drink;

import com.trustwave.ingredients.Espresso;
import com.trustwave.ingredients.Ingredient;
import com.trustwave.ingredients.Sugar;
import javafx.util.Pair;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by jharris on 11/10/16.
 */
public class DrinkTest {

    //-----Test individual costs & generic ---//
    @Test
    public void testCost(){
        CaffeAmericano ca = new CaffeAmericano();
        assert(ca.getCost() == 3.30);

        CaffeLatte cal = new CaffeLatte();
        assert(cal.getCost() == 2.55);

        CaffeMocha cm = new CaffeMocha();
        assert(cm.getCost() == 3.35);

        Cappuccino cap = new Cappuccino();
        assert(cap.getCost() == 2.90);

        Coffee c = new Coffee();
        assert(c.getCost() == 2.75);

        DecafCoffee dc = new DecafCoffee();
        assert(dc.getCost() == 2.75);


        ArrayList< Pair<Ingredient,Integer> >ingredients = new ArrayList<>();
        ingredients.add(new Pair(new Sugar(), 10));
        ingredients.add(new Pair(new Espresso(), 10));
        Drink d = new Drink("Jason's Super Rockstar Energy Drink", ingredients);
        assert(d.getCost() == 13.50);

    }

    @Test
    public void testCostWithNoIngredients() {
        ArrayList< Pair<Ingredient,Integer> >ingredients = new ArrayList<>();
        Drink d = new Drink("Where's my drink?", ingredients);
        assert(d.getCost() == 0);
    }

    @Test
    public void testCostWithNullIngredients() {
        Drink d = new Drink("Did you order?", null);
        assert(d.getCost() == 0);
    }

    @Test
    public void testIngredients() {

    }

    //-------Test names -----------//
    @Test
    public void testNames() {}
}

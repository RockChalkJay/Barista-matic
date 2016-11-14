package com.trustwave.service;

import com.trustwave.drink.*;
import com.trustwave.ingredients.Ingredient;
import javafx.util.Pair;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by jharris on 11/10/16.
 */
public interface MenuService {

    public InventoryService getInventoryService();

    public void setInventoryService(InventoryService inventoryService);

    public ArrayList<Drink> getDrinks();

    public void setDrinks(ArrayList<Drink> drinks);

    public boolean isDrinkInStock(int menuItemNum);

    public boolean isDrinkInStock(Drink drink);

    public boolean orderDrink(int menuItemNum);

    public boolean orderDrink(Drink drink);

    @Override
    public String toString();
}

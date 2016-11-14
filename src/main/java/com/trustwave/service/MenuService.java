package com.trustwave.service;

import com.trustwave.drink.Drink;

import java.util.ArrayList;

/**
 * Created by jharris on 11/10/16.
 */
public interface MenuService {

    public InventoryService getInventoryService();

    public void setInventoryService(InventoryService inventoryService);

    public void addDrink(Drink drink);

    public void removeDrink(Drink drink);

    public ArrayList<Drink> getDrinks();

    public void setDrinks(ArrayList<Drink> drinks);

    public boolean isDrinkInStock(int menuItemNum);

    public boolean isDrinkInStock(Drink drink);

    public boolean orderDrink(int menuItemNum);

    public boolean orderDrink(Drink drink);

    @Override
    public String toString();
}

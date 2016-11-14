package com.trustwave.service;

import com.trustwave.drink.*;
import com.trustwave.ingredients.Ingredient;
import javafx.util.Pair;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by jharris on 11/10/16.
 */
public class MenuServiceImpl implements MenuService{

    InventoryService inventoryService;
    ArrayList<Drink> drinks = new ArrayList<>();


    public MenuServiceImpl(InventoryService inventoryService) {
        this.inventoryService = inventoryService;

        //----A default set of Drinks for the Menu-------//
        drinks.add(new CaffeAmericano());
        drinks.add(new CaffeLatte());
        drinks.add(new CaffeMocha());
        drinks.add(new Cappuccino());
        drinks.add(new Coffee());
        drinks.add(new DecafCoffee());
        //-----------------------------------------------//

        Collections.sort(drinks, (drink1, drink2) ->
                drink1.getName().compareToIgnoreCase(drink2.getName()));
    }

    /*
    * Constructor used to make custom menus
    */
    public MenuServiceImpl(InventoryService inventoryService, ArrayList<Drink> drinks) {
        this.inventoryService = inventoryService;
        this.drinks = drinks;

        Collections.sort(drinks, (drink1, drink2) ->
                drink1.getName().compareToIgnoreCase(drink2.getName()));
    }

    @Override
    public InventoryService getInventoryService() {
        return inventoryService;
    }

    public void setInventoryService(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @Override
    public void addDrink(Drink drink) {
        drinks.add(drink);
        Collections.sort(drinks, (drink1, drink2) ->
                drink1.getName().compareToIgnoreCase(drink2.getName()));
    }

    @Override
    public void removeDrink(Drink drink) {
        for (int i=0; i < drinks.size(); i++) {
            if(drinks.get(i).getName() == drink.getName()) {
                drinks.remove(i);
            }
        }
        Collections.sort(drinks, (drink1, drink2) ->
                drink1.getName().compareToIgnoreCase(drink2.getName()));
    }

    @Override
    public ArrayList<Drink> getDrinks() {
        return drinks;
    }

    @Override
    public void setDrinks(ArrayList<Drink> drinks) {
        Collections.sort(drinks, (drink1, drink2) ->
                drink1.getName().compareToIgnoreCase(drink2.getName()));
        this.drinks = drinks;
    }

    @Override
    public boolean isDrinkInStock(int menuItemNum) {
        if (0 < menuItemNum && menuItemNum <= drinks.size()) {
            return isDrinkInStock(drinks.get(menuItemNum-1));
        }

        return false;
    }

    @Override
    public boolean isDrinkInStock(Drink drink) {
        for (Pair<Ingredient, Integer> reciepe : drink.getIngredients()) {
            if (inventoryService.getAmountOfIngredient(reciepe.getKey()) < reciepe.getValue().intValue()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean orderDrink(int menuItemNum) {
        if (0 < menuItemNum && menuItemNum <= drinks.size()) {
           return orderDrink(drinks.get(menuItemNum-1));
        }
         return false;
    }

    @Override
    public boolean orderDrink(Drink drink) {
        if (!isDrinkInStock(drink)) {
            return false;
        }

        for (Pair<Ingredient, Integer> reciepe : drink.getIngredients()) {
            inventoryService.useIngredient(reciepe.getKey(), reciepe.getValue());
        }

        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Menu:\n");

        NumberFormat formatter = new DecimalFormat("#0.00");

        for (int i=0; i < drinks.size(); i++) {
            Drink drink = drinks.get(i);
            sb.append("\n");
            sb.append((i+1) + "," + drink.getName() + ",$" + formatter.format(drink.getCost()) + "," + isDrinkInStock(drink));
            sb.append("\n");
        }
        return sb.toString();
    }
}

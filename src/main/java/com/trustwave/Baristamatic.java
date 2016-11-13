package com.trustwave;

import com.trustwave.drink.Drink;
import com.trustwave.service.InventoryService;
import com.trustwave.service.MenuService;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by jharris on 11/10/16.
 */
public class Baristamatic {

    public static void main(String[] args) {

        InventoryService inventoryService = new InventoryService();
        MenuService menuService = new MenuService(inventoryService);

        Scanner scanner = new Scanner(System.in);

        while (true) {

            String input = scanner.nextLine();

            System.out.println();

            if ("q".equals(input.toLowerCase())) {
                outputInventoryAndMenu(inventoryService, menuService);
                System.exit(0);
            } else if ("r".equals(input.toLowerCase())) {
                inventoryService.restock();
                outputInventoryAndMenu(inventoryService, menuService);
            } else if (input.isEmpty()) {
                //ignore
                continue;
            } else {
                try {
                    int orderNum = Integer.parseInt(input);
                    if (0 < orderNum && orderNum <= menuService.getDrinks().size()) {
                        if (menuService.isDrinkInStock(orderNum)) {
                            menuService.orderDrink(orderNum);
                            System.out.println("Dispensing: " + menuService.getDrinks().get(orderNum-1).getName());
                        } else {
                            System.out.println("Out of stock: " + menuService.getDrinks().get(orderNum - 1).getName());
                        }
                    } else {
                        System.out.println("Invalid selection: " + input);
                    }
                } catch(NumberFormatException nfe) {
                    System.out.println("Invalid selection: " + input);
                }
                finally {
                    outputInventoryAndMenu(inventoryService, menuService);
                }
            }
        }
    }

    private static void outputInventoryAndMenu(InventoryService inventoryService, MenuService menuService) {
        System.out.println();
        System.out.println(inventoryService.toString());
        System.out.println();
        System.out.println(menuService.toString());
    }
}

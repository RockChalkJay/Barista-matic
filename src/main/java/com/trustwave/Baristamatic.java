package com.trustwave;

import com.trustwave.service.InventoryService;
import com.trustwave.service.InventoryServiceImpl;
import com.trustwave.service.MenuService;
import com.trustwave.service.MenuServiceImpl;

import java.util.Scanner;

/**
 * Created by jharris on 11/10/16.
 */
public class Baristamatic {

    public static void main(String[] args) {

        InventoryService inventoryService = new InventoryServiceImpl();
        MenuService menuService = new MenuServiceImpl(inventoryService);

        Scanner scanner = new Scanner(System.in);

        outputInventoryAndMenu(inventoryService, menuService);

        while (true) {

            String input = scanner.nextLine();

            System.out.println();

            if ("q".equals(input.toLowerCase())) {
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
                            System.out.println("Dispensing: " + menuService.getDrinks().get(orderNum-1).getName() + "\n");
                        } else {
                            System.out.println("Out of stock: " + menuService.getDrinks().get(orderNum - 1).getName() + "\n");
                        }
                    } else {
                        System.out.println("Invalid selection: " + input + "\n");
                    }
                } catch(NumberFormatException nfe) {
                    System.out.println("Invalid selection: " + input + "\n");
                }
                finally {
                    outputInventoryAndMenu(inventoryService, menuService);
                }
            }
        }
    }

    private static void outputInventoryAndMenu(InventoryService inventoryService, MenuService menuService) {
        System.out.println(inventoryService.toString());
        System.out.println(menuService.toString());
    }
}

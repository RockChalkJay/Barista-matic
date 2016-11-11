package com.trustwave;

import com.trustwave.service.InventoryService;
import com.trustwave.service.MenuService;

/**
 * Created by jharris on 11/10/16.
 */
public class Baristamatic {

    public static void main(String[] args) {

        InventoryService inventoryService = new InventoryService();
        MenuService menuService = new MenuService();
        Baristamatic bartender = new Baristamatic(inventoryService, menuService);
        //TODO - INPUT/OUTPUT

    }

    private InventoryService inventoryService;
    private MenuService menuService;

    public Baristamatic(InventoryService inventoryService, MenuService menuService) {
        this.inventoryService = inventoryService;
    }
}

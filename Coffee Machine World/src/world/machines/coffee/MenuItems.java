/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package world.machines.coffee;

import java.util.Arrays;

/**
 *
 * @author christopher.eckles
 */
public enum MenuItems {
    ADD_CUP(0, "Put a cup in the machine", "world.machines.coffee.CoffeeMachineWorld", "addCup"),
    CHECK_STATUS(1, "Check Status", "world.machines.coffee.CoffeeMachineWorld", "checkStatus"),
    CLOSE_DOOR(2, "Close Door", "world.machines.coffee.CoffeeMachineWorld", "closeDoor"),
    FILL_WATER_TANK(3, "Fill Water Tank", "world.machines.coffee.CoffeeMachineWorld", "fillWaterTank"),
    FILL_COFFEE_BIN(4, "Fill Coffee Beans", "world.machines.coffee.CoffeeMachineWorld", "fillCoffeeBin"),
    EMPTY_WASTE_BIN(5, "Empty Waste Bin", "world.machines.coffee.CoffeeMachineWorld", "emptyWasteBin"),
    MAKE_A_CUP_OF_COFFEE(6, "Make A Cup Of Coffee", "world.machines.coffee.CoffeeMachineWorld", "makeCoffee"),
    RUN_A_DEMO(7, "Run A Demo", "world.machines.coffee.CoffeeMachineWorld", "runADemo"),
    EXIT(8, "Turn Coffee Machine Off", "world.machines.coffee.CoffeeMachineWorld", "exit");

    int menuItemid;
    String menuItemDescription;
    String methodClass;
    String methodToCall;

    MenuItems(int id, String descr, String mclass, String method) {
        menuItemid = id;
        menuItemDescription = descr;
        methodClass = mclass;
        methodToCall = method;
    }

    public int getMenuItemid() {
        return menuItemid;
    }

    public String getMenuItemDescription() {
        return menuItemDescription;
    }

    public String getMethodClass() {
        return methodClass;
    }

    public String getMethodToCall() {
        return methodToCall;
    }

    @Override
    public String toString() {
        return menuItemid + " - " + menuItemDescription;
    }

    public static void printEntireMenu() {

        for (MenuItems mi : MenuItems.values()) {
            String menuItem = mi.toString();
            System.out.println(menuItem);
        }
    }

    public static MenuItems findById(final int id) {
        return Arrays.stream(values()).filter(value -> value.getMenuItemid() == id).findFirst().orElse(null);
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package world.machines.coffee;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
import world.machines.coffee.components.exceptions.ModeException;
import world.machines.coffee.utils.InputUtil;
import world.thermoDynamics.HeatDissipator;

/**
 *
 * @author christopher.eckles
 */
public class CoffeeMachineWorld {

    public static CoffeeMachine cm;
    public static HeatDissipator hd;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        cm = new CoffeeMachine();

        hd = new HeatDissipator(cm);
        //thread for cooling water down
        hd.start();
        System.out.println("Good Moring Mr Grumpy Gills. \nHow about a nice cup of coffee?");

        //user int...
        mainMenu();

    }

    private static void mainMenu() {
        boolean exit = false;
        while (!exit) {
            int selected = 0;
            System.out.println("\n\nMain Menu:\n");
            MenuItems.printEntireMenu();
            selected = InputUtil.waitForIntInput(0, MenuItems.values().length, 0);
            MenuItems mi = MenuItems.findById(selected);
            if (mi == null) {
                break;
            }
            if (selected == MenuItems.EXIT.getMenuItemid()) {
                hd.setOn(false);
                System.out.println("Shutting down machine...");
                exit = true;
            } else {
                try {
                    invokeMethod(mi.getMethodClass(), mi.getMethodToCall());
                } catch (Exception ex) {
                    System.out.println("Oops! " + ex.getMessage());
                }
            }
            //TODO: add sleep
        }

    }

    public static void runADemo() {
        try {
            while (true) {
                System.out.println("New Cup!...");
                cm.setContainerAvailable(true);
                cm.makeCoffee(8);
            }
        } catch (InterruptedException | ModeException ex) {
                    System.out.println("Oops! " + ex.getMessage());
        }
    }

    public static void invokeMethod(String methodClass, String methodToInvoke) {
        Class<?> c;
        try {
            c = Class.forName(methodClass);
            Method method = c.getDeclaredMethod(methodToInvoke);
            method.invoke(c);
        } catch (ClassNotFoundException | NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                    System.out.println("Oops! " + ex.getMessage());
        }

    }

    public static void addCup() {
        System.out.println("Putting a cup in the right spot...");
        cm.setContainerAvailable(true);
    }

    public static void checkStatus() {
        System.out.println("Checking to see if there is enough for an 8 oz cup of coffee...");
        try {
            cm.checkStatus(8);
        } catch (ModeException e) {
            System.out.println("Oops! " + e.getMessage());
        }

    }

    public static void closeDoor() {
        cm.closeDoor();
    }

    public static void fillWaterTank() {
        System.out.println("Where to fill the water tank to?");
        int oz = InputUtil.waitForIntInput(4, CoffeeMachine.WATER_TANK_MAX_LEVEL, CoffeeMachine.WATER_TANK_MAX_LEVEL);
        cm.setWasteBinLevel(oz);
    }

    public static void fillCoffeeBin() {
        System.out.println("How Many Grams of Beans to fill to?");

        int grams = InputUtil.waitForIntInput(4, CoffeeMachine.COFFEE_BEAN_MAX_LEVEL_GRAMS, CoffeeMachine.COFFEE_BEAN_MAX_LEVEL_GRAMS);
        cm.setCoffeeBinLevelGrams(grams);
    }

    public static void emptyWasteBin() {
        cm.setWasteBinLevel(0);
    }

    public static void makeCoffee() {
        System.out.println("How many ounces would you like?");
        int oz = InputUtil.waitForIntInput(4, 24, 8);
        try {
            cm.makeCoffee(oz);
        } catch (InterruptedException | ModeException ex) {
                    System.out.println("Oops! " + ex.getMessage());
        }
    }
}

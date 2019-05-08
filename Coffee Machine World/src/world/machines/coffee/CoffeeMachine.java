/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package world.machines.coffee;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import world.machines.coffee.components.exceptions.ModeException;
import world.machines.coffee.components.exceptions.ExceptionSeverity;

/**
 *
 * @author ceckles
 */
public class CoffeeMachine {

    public static final int ROOM_TEMP = 74;
    public static final int TEMP_INCREMENT = 4;
    public static final int THERMAL_DISSAPATION = -2;
    public static final int PRIME_COFFEE_BREWING_TEMP = 201; //thanks Steve!
    public static final int WATER_TANK_MAX_LEVEL = 80;
    public static final int COFFEE_GRAMS_PER_OZ_OF_WATER = 1;
    public static final int COFFEE_BEAN_MAX_LEVEL_GRAMS = 100;
    public static final int WASTE_BIN_MAX_LEVEL = 200;
    public static final int BREW_TIME_PER_OZ_IN_SECONDS = 10;

    int waterTemperature = ROOM_TEMP;
    int waterTankLevelOunces = WATER_TANK_MAX_LEVEL;
    int coffeeBinLevelGrams = COFFEE_BEAN_MAX_LEVEL_GRAMS;
    int wasteBinLevel = 0;

    boolean powerOn = true;
    boolean doorClosed = true;
    boolean coffeeBinSeated = true;
    boolean waterTankSeated = true;
    boolean wasteBinSeated = true;
    boolean containerAvailable = false;

    Date lastCleanedDate;

    ArrayList<ModeException> exceptionHistory;

    void makeACupOfCoffee(int ounceContainer) {

    }

    void closeDoor() {
        System.out.println("Door Closed");
        doorClosed = true;
    }

    void openDoor() {
        System.out.println("Door Open - Remember to Close me back up when you're done.");
        doorClosed = false;
    }

    void fillWaterTank() {
        System.out.println("Filling water tank with fresh cold water");
        openDoor();
        setWaterContainerSeated(false);
        setWaterTankLevelOunces(WATER_TANK_MAX_LEVEL);
        setWaterTemperature(60);
        System.out.println("Water Tank Full");

    }

    void heatWater() throws InterruptedException {
        while (waterTemperature < PRIME_COFFEE_BREWING_TEMP) {
            TimeUnit.SECONDS.sleep(1);
            System.out.println("Water at: " + waterTemperature + "º: Heating water to proper temp of " + PRIME_COFFEE_BREWING_TEMP + "º");
            waterTemperature += TEMP_INCREMENT;
        }
    }

    void brew(int oz) throws InterruptedException {
        int filledTo = 0;
        int coffeeNeeded = oz * COFFEE_GRAMS_PER_OZ_OF_WATER;

        grindCoffee(coffeeNeeded);
        while (oz > filledTo) {
            heatWater();
            System.out.println("Water at: " + waterTemperature + " - Brewing coffee. Filled to: " + filledTo);
            waterTankLevelOunces--;
            TimeUnit.SECONDS.sleep(1);
            filledTo++;
        }
        System.out.println("*******Coffee Cup Filled To " + oz + "*******");
    }

    void grindCoffee(int grams) {
        coffeeBinLevelGrams = coffeeBinLevelGrams - grams;
        System.out.println("Grinding Coffee...");
    }

    public void makeCoffee(int oz) throws InterruptedException, ModeException {
        //check for status
        checkStatus(oz);
        //heat water, brew, and dispence
        brew(oz);
        //container no-longer-available;
        containerAvailable = false;
    }

    public void checkStatus(int oz) throws ModeException {
        checkForSeatedComponents();
        //check for cup
        checkForCup();
        //check for amounts
        checkAmounts(oz);
    }

    public void checkForSeatedComponents() throws ModeException {
        if (coffeeBinSeated) {
            System.out.println("Coffee Bin Seated");
        } else {
            throw new ModeException("Coffee Bin not seated", ExceptionSeverity.MODERATE);
        }
        if (waterTankSeated) {
            System.out.println("Water Container Seated");
        } else {
            throw new ModeException("Water Container not seated", ExceptionSeverity.MODERATE);
        }
        if (wasteBinSeated) {
            System.out.println("Waste Bin Seated");
        } else {
            throw new ModeException("Waste Bin not seated", ExceptionSeverity.MODERATE);
        }
    }

    public void checkForCup() throws ModeException {
        if (containerAvailable) {
            System.out.println("Cup ready!");
        } else {
            throw new ModeException("No Cup!", ExceptionSeverity.MODERATE);
        }
    }

    public void checkAmounts(int oz) throws ModeException {
        int coffeeNeeded = oz * COFFEE_GRAMS_PER_OZ_OF_WATER;

        if (coffeeNeeded <= coffeeBinLevelGrams) {
            System.out.println("Enough Coffee!");
        } else {
            throw new ModeException("Refill Coffee Bin", ExceptionSeverity.LOW);
        }

        if (oz <= waterTankLevelOunces) {
            System.out.println("Enough Water!");
        } else {
            throw new ModeException("Refill Water Tank!", ExceptionSeverity.LOW);
        }

        if (coffeeNeeded + wasteBinLevel <= WASTE_BIN_MAX_LEVEL) {
            System.out.println("Waste Bin has room!");
        } else {
            throw new ModeException("Empty Waste Bin!", ExceptionSeverity.LOW);
        }

    }

    public int getWaterTemperature() {
        return waterTemperature;
    }

    public void setWaterTemperature(int waterTemperature) {
        this.waterTemperature = waterTemperature;
    }

    public int getWaterTankLevelOunces() {
        return waterTankLevelOunces;
    }

    public void setWaterTankLevelOunces(int waterTankLevelOunces) {
        this.waterTankLevelOunces = waterTankLevelOunces;
    }

    public int getCoffeeBinLevelGrams() {
        return coffeeBinLevelGrams;
    }

    public void setCoffeeBinLevelGrams(int coffeeBinLevelGrams) {
        this.coffeeBinLevelGrams = coffeeBinLevelGrams;
    }

    public int getWasteBinLevel() {
        return wasteBinLevel;
    }

    public void setWasteBinLevel(int wasteBinLevel) {
        this.wasteBinLevel = wasteBinLevel;
    }

    public boolean isPowerToggle() {
        return powerOn;
    }

    public void setPowerToggle(boolean powerToggle) {
        this.powerOn = powerToggle;
    }

    public boolean isDoorClosed() {
        return doorClosed;
    }

    public void setDoorClosed(boolean doorClosed) {
        this.doorClosed = doorClosed;
    }

    public boolean isCoffeeBinSeated() {
        return coffeeBinSeated;
    }

    public void setCoffeeBinSeated(boolean coffeeBinSeated) {
        this.coffeeBinSeated = coffeeBinSeated;
    }

    public boolean isWaterContainerSeated() {
        return waterTankSeated;
    }

    public void setWaterContainerSeated(boolean waterContainerSeated) {
        this.waterTankSeated = waterContainerSeated;
    }

    public Date getLastCleanedDate() {
        return lastCleanedDate;
    }

    public void setLastCleanedDate(Date lastCleanedDate) {
        this.lastCleanedDate = lastCleanedDate;
    }

    public ArrayList<ModeException> getExceptionHistory() {
        return exceptionHistory;
    }

    public void setExceptionHistory(ArrayList<ModeException> exceptionHistory) {
        this.exceptionHistory = exceptionHistory;
    }

    public void decrementWaterTemperature(int offset) {
        waterTemperature = waterTemperature - offset;
    }

    public boolean isContainerAvailable() {
        return containerAvailable;
    }

    public void setContainerAvailable(boolean containerAvailable) {
        this.containerAvailable = containerAvailable;
    }


}

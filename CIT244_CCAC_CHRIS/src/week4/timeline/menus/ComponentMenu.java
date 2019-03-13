/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week4.timeline.menus;

import java.util.Arrays;
import week4.timeline.Properties;
import week4.timeline.TimelineWorld;
import week4.timeline.components.Component;
import week4.timeline.components.ComputerComponent;
import week4.timeline.components.HumanInterestComponent;

/**
 *
 * @author ceckles
 */
public enum ComponentMenu {

    COMPONENT(1, "component.general", Component.class),
    COMPUTER_COMPONENT(2, "component.computer", ComputerComponent.class),
    HUMAN_INTEREST_COMPONENT(3, "component.human.interest", HumanInterestComponent.class),
    EXIT(4, "component.menu.exit", TimelineWorld.class);
    

    int menuItemid;
    String menuItemDescription;
    Class componentClass;

    ComponentMenu(int id, String descr, Class cc) {
        menuItemid = id;
        menuItemDescription = descr;
        componentClass = cc;
    }

    public int getMenuItemid() {
        return menuItemid;
    }

    public String getMenuItemDescription() {
        return menuItemDescription;
    }

    public Class getComponentClass() {
        return componentClass;
    }


    @Override
    public String toString() {
        return menuItemid + " - " + Properties.getLabel(menuItemDescription);
    }

    public static void printEntireMenu() {
        
        for (ComponentMenu mi : ComponentMenu.values()) {
            System.out.println(mi.toString());
        }
    }

    public static ComponentMenu findById(final int id) {
        return Arrays.stream(values()).filter(value -> value.getMenuItemid() == id).findFirst().orElse(null);
    }
    
    
    public static ComponentMenu findByClassName(final String className) {
        return Arrays.stream(values()).filter(value -> value.getComponentClass().toString().equals(className)).findFirst().orElse(null);
    }

}

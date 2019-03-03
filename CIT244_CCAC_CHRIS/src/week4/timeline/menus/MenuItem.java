/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week4.timeline.menus;

import java.util.Arrays;

/**
 *
 * @author ceckles
 */
public enum MenuItem {

    PRINT_COMPONENTS(1, "Print Components", "week4.timeline.TimelineWorld", "printComponents"),
    ADD_COMPONENT(2, "Add a new timeline Component", "week4.timeline.TimelineWorld", "addComponent"),
    EDIT_COMPONENT(3, "Edit an existing timeline Component", "week4.timeline.TimelineWorld", "editComponent"),
    SAVE_TIMELINE(4, "Save timeline to file.", "week4.timeline.TimelineWorld", "saveTimeline"),
    SORT_TIMELINE(5, "Sort timeline (Using bubble sort.)", "week4.timeline.TimelineWorld", "bubbleSort"),
    DONT_SAVE_ON_EXIT(6, "Don't save on exit", "week4.timeline.TimelineWorld", "setSaveOnExitToFalse"),
    EXIT(7, "Exit Application", "week4.timeline.TimelineWorld", "setSaveOnExitToFalse");

    int menuItemid;
    String menuItemDescription;
    String methodClass;
    String methodToCall;

    MenuItem(int id, String descr, String mclass, String method) {
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
        for (MenuItem mi : MenuItem.values()) {
            System.out.println(mi.toString());
        }
    }

    public static MenuItem findById(final int id) {
        return Arrays.stream(values()).filter(value -> value.getMenuItemid() == id).findFirst().orElse(null);
    }

}

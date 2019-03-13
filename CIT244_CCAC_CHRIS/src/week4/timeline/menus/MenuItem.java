/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week4.timeline.menus;

import java.util.Arrays;
import week4.timeline.Properties;

/**
 *
 * @author ceckles
 */
public enum MenuItem {
    START_GUI(0, "gui.start", "week4.timeline.TimelineWorld", "startGUI"),
    LIST_COMPONENTS(1, "components.list", "week4.timeline.TimelineWorld", "printComponents"),
    ADD_COMPONENT(2, "component.add", "week4.timeline.TimelineWorld", "addComponent"),
    DUPLICATE_COMPONENT(3, "component.duplicate", "week4.timeline.TimelineWorld", "duplicateComponent"),
    EDIT_COMPONENT(4, "component.edit", "week4.timeline.TimelineWorld", "editComponent"),
    DELETE_COMPONENT(5, "component.delete", "week4.timeline.TimelineWorld", "deleteComponent"),
    SAVE_TIMELINE(6, "timeline.save", "week4.timeline.TimelineWorld", "saveTimeline"),
    SORT_TIMELINE(7, "timeline.sort", "week4.timeline.TimelineWorld", "sort"),
    DONT_SAVE_ON_EXIT(8, "no.save.on.exit", "week4.timeline.TimelineWorld", "setSaveOnExitToFalse"),
    PRINT_WIREFRAME(9, "wireframe", "week4.timeline.TimelineWorld", "printWireframe"),
    CHANGE_LANGUAGE(10, "change.language", "week4.timeline.TimelineWorld", "changeLanguage"),
    EXIT(11, "application.exit", "week4.timeline.TimelineWorld", "setSaveOnExitToFalse");

   
    
        
//    PRINT_COMPONENTS(1, "Print Components", "week4.timeline.TimelineWorld", "printComponents"),
//    ADD_COMPONENT(2, "Add Components", "week4.timeline.TimelineWorld", "addComponent"),
//    DUPLICATE_COMPONENT(3, "Duplicate Component", "week4.timeline.TimelineWorld", "duplicateComponent"),
//    EDIT_COMPONENT(4, "Edit Component", "week4.timeline.TimelineWorld", "editComponent"),
//    DELETE_COMPONENT(5, "Delete Component", "week4.timeline.TimelineWorld", "deleteComponent"),
//    SAVE_TIMELINE(6, "Save Timeline", "week4.timeline.TimelineWorld", "saveTimeline"),
//    SORT_TIMELINE(7, "Sort Timeline", "week4.timeline.TimelineWorld", "sort"),
//    DONT_SAVE_ON_EXIT(8, "Don't Save On Exit", "week4.timeline.TimelineWorld", "setSaveOnExitToFalse"),
//    EXIT(9, "Exit Application", "week4.timeline.TimelineWorld", "setSaveOnExitToFalse");

    
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
        return menuItemid + " - " + Properties.getLabel(menuItemDescription);
    }

    public static void printEntireMenu() {
                
        for (MenuItem mi : MenuItem.values()) {
            String menuItem = mi.toString();
            System.out.println(menuItem);
        }
    }

    public static MenuItem findById(final int id) {
        return Arrays.stream(values()).filter(value -> value.getMenuItemid() == id).findFirst().orElse(null);
    }

}

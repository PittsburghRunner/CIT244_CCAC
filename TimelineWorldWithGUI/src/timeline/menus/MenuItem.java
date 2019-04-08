/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timeline.menus;

import java.util.Arrays;
import timeline.Properties;

/**
 *
 * @author ceckles
 */
public enum MenuItem {
    START_GUI(0, "gui.start", "timeline.TimelineWorld", "startGUI"),
    LIST_COMPONENTS(1, "components.list", "timeline.TimelineWorld", "printComponents"),
    ADD_COMPONENT(2, "component.add", "timeline.TimelineWorld", "addComponent"),
    DUPLICATE_COMPONENT(3, "component.duplicate", "timeline.TimelineWorld", "duplicateComponent"),
    EDIT_COMPONENT(4, "component.edit", "timeline.TimelineWorld", "editComponent"),
    DELETE_COMPONENT(5, "component.delete", "timeline.TimelineWorld", "deleteComponent"),
    SAVE_TIMELINE(6, "timeline.save", "timeline.TimelineWorld", "saveTimeline"),
    SORT_TIMELINE(7, "timeline.sort", "timeline.TimelineWorld", "sort"),
    DONT_SAVE_ON_EXIT(8, "no.save.on.exit", "timeline.TimelineWorld", "setSaveOnExitToFalse"),
    PRINT_WIREFRAME(9, "wireframe", "timeline.TimelineWorld", "printWireframe"),
    CHANGE_LANGUAGE(10, "change.language", "timeline.TimelineWorld", "changeLanguage"),
    EXIT(11, "application.exit", "timeline.TimelineWorld", "setSaveOnExitToFalse");

   
    
        
//    PRINT_COMPONENTS(1, "Print Components", "timeline.TimelineWorld", "printComponents"),
//    ADD_COMPONENT(2, "Add Components", "timeline.TimelineWorld", "addComponent"),
//    DUPLICATE_COMPONENT(3, "Duplicate Component", "timeline.TimelineWorld", "duplicateComponent"),
//    EDIT_COMPONENT(4, "Edit Component", "timeline.TimelineWorld", "editComponent"),
//    DELETE_COMPONENT(5, "Delete Component", "timeline.TimelineWorld", "deleteComponent"),
//    SAVE_TIMELINE(6, "Save Timeline", "timeline.TimelineWorld", "saveTimeline"),
//    SORT_TIMELINE(7, "Sort Timeline", "timeline.TimelineWorld", "sort"),
//    DONT_SAVE_ON_EXIT(8, "Don't Save On Exit", "timeline.TimelineWorld", "setSaveOnExitToFalse"),
//    EXIT(9, "Exit Application", "timeline.TimelineWorld", "setSaveOnExitToFalse");

    
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

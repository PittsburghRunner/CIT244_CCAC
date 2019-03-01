/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week4.timeline;

import week4.timeline.menus.MenuItem;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBException;
import week4.timeline.Timeline;
import week4.timeline.io.files.XMLUtilities;
import week4.timeline.components.Component;
import week4.timeline.components.ComputerComponent;
import week4.timeline.menus.ComponentMenu;
import week4.utils.lits.MethodHelpers;
import week4.utils.lits.input.Prompt;

/**
 *
 * @author christopher.eckles
 */
public class TimelineWorld {

    private static Timeline timeline = new Timeline();
    private static boolean saveOnExit = true;

    public static void main(String[] args) {

        //try loading the file
        try {
            timeline = XMLUtilities.loadXMLTimeline();
        } catch (JAXBException | FileNotFoundException ex) {
            Logger.getLogger(TimelineWorld.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Couldn't load the file. Adding default data.");
            defaultData(timeline);
        }

        mainMenu();

        //save the file before exiting
        if (saveOnExit) {
            saveTimeline();
            printComponents();
            System.out.println("Saved and Exited");

        } else {
            System.out.println("Exited without Saving");
        }
        printComponents();
    }

    private static void defaultData(Timeline timeline) {
        HashMap ccMap = new HashMap();
        ccMap.put("year", 2007);
        ccMap.put("createdBy", "Apple");
        ccMap.put("description", "iPhone");
        ccMap.put("referenceSourceUrl", "http://www.apple.com/iPhone");

        ComputerComponent cc = new ComputerComponent(ccMap);
    }

    public static void printComponents() {
        for (Component component : timeline.getComponents()) {
            System.out.println(component.toString());
        }

    }

    private static void mainMenu() {
        boolean exit = false;
        while (!exit) {
            int selected = 0;
            System.out.println("\n\nMain Menu:\n");
            MenuItem.printEntireMenu();
            selected = InputUtil.waitForIntInput(MenuItem.values().length);
            MenuItem mi = MenuItem.findById(selected);
            if (selected == MenuItem.EXIT.getMenuItemid()) {
                exit = true;
            } else {
                invokeMethod(mi.getMethodClass(),mi.getMethodToCall());
            }
            //TODO: add sleep
        }

    }
    
    private static void addComponent() throws InstantiationException, IllegalAccessException{
              boolean exit = false;
        while (!exit) {
            int selected = 0;
            System.out.println("\n\nMain Menu:\n");
            ComponentMenu.printEntireMenu();
            selected = InputUtil.waitForIntInput(MenuItem.values().length);
            ComponentMenu mi = ComponentMenu.findById(selected);
            
            if (selected == ComponentMenu.EXIT.getMenuItemid()) {
                exit = true;
            } else {
               //create a new object based on annotation.
               Class c = ComponentMenu.findById(selected).getComponentClass();
               ArrayList<Prompt> prompts = MethodHelpers.retrieveClassMethodsForPrompting(c);
               Component comp = c.newInstance();
               for(Prompt p : prompts){
                   for(Entry me:p.getList().entrySet()){
                       System.out.println(me.getKey() + " - " + me.getValue());
                   }
                   System.out.println(p.getPrompt());
                   int selection = InputUtil.waitForIntInput(p.getList().size());
                   Invoke.
                           //=  p.getList().get(selection);
               }
               
            }
            //TODO: add sleep
        }
    }

    private static void invokeMethod(String methodClass, String methodToInvoke) {

        Class<?> c;
        try {
            c = Class.forName(methodClass);
            Method method = c.getDeclaredMethod(methodToInvoke);
            method.invoke(c);
        } catch (ClassNotFoundException | NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(TimelineWorld.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public static void setSaveOnExitToFalse(){
        saveOnExit = false;
    }
    
    public static void saveTimeline(){
            try {
                week4.timeline.io.files.XMLUtilities.saveTimelineToXML(timeline);
            } catch (JAXBException | FileNotFoundException ex) {
                Logger.getLogger(TimelineWorld.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Unable to save.");
                return;
            }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week4.timeline;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBException;

import week4.timeline.menus.MenuItem;
import week4.timeline.io.files.XMLUtilities;
import week4.timeline.components.Component;
import week4.timeline.components.ComputerComponent;
import week4.timeline.components.HumanInterestComponent;
import week4.timeline.menus.ComponentMenu;
import week4.utils.lits.FieldHelpers;
import week4.utils.lits.ListType;
import week4.utils.lits.input.Prompt;

/**
 *
 * @author christopher.eckles
 */
public class TimelineWorld {

    private static Timeline timeline = new Timeline();
    private static boolean saveOnExit = true;
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-dd-MM");

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
        ccMap.put("date", sdf.format("2007-06-29"));
        ccMap.put("createdBy", "Apple");
        ccMap.put("description", "iPhone");
        ccMap.put("referenceSourceUrl", "http://www.apple.com/iPhone");
        ComputerComponent cc = new ComputerComponent(ccMap);
        timeline.getComponents().add(cc);

        HashMap<String, Object> hicMap = new HashMap();
        hicMap.put("date", sdf.format("2013-09-02"));
        hicMap.put("createdBy", "Microsoft");
        hicMap.put("description", "Surface Pro");
        hicMap.put("referenceSourceUrl", "https://en.wikipedia.org/wiki/Surface_Pro");
        HumanInterestComponent hic = new HumanInterestComponent(hicMap);
        timeline.getComponents().add(hic);

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
            selected = InputUtil.waitForIntInput(1, MenuItem.values().length, 0);
            MenuItem mi = MenuItem.findById(selected);
            if (mi == null) {
                break;
            }
            if (selected == MenuItem.EXIT.getMenuItemid()) {
                exit = true;
            } else {

                invokeMethod(mi.getMethodClass(), mi.getMethodToCall());
            }
            //TODO: add sleep
        }

    }

    private static void addComponent() throws InstantiationException, IllegalAccessException, ParseException {
        boolean exit = false;
        while (!exit) {
            int selected = 0;
            System.out.println("\n\nAdd New Component:\n");
            ComponentMenu.printEntireMenu();
            selected = InputUtil.waitForIntInput(1, ComponentMenu.values().length, 0);
            ComponentMenu mi = ComponentMenu.findById(selected);
            if (mi == null) {
                break;
            }
            if (selected == ComponentMenu.EXIT.getMenuItemid()) {
                exit = true;
            } else {
                //create a new object based on annotation.
                Class c = ComponentMenu.findById(selected).getComponentClass();
                ArrayList<Prompt> prompts = FieldHelpers.retrieveClassFieldsForPrompting(c);
//                for (Prompt p : prompts) {
//                    System.out.println(p.getField().getName() +   " - min:" + p.getMin()
//                            + " - max:" + p.getMax() + " - prompt:" + p.getPrompt());
//                }
                HashMap<String, Object> inputMap = new HashMap<>();
                inputMap = promptForInputMap(prompts, inputMap);
                Object o = c.newInstance();
                if (o instanceof Component) {
                    Component comp = (Component) o;
                    comp.load(inputMap);
                    timeline.components.add(comp);

                } else if (o instanceof ComputerComponent) {
                    ComputerComponent comp = (ComputerComponent) o;
                    comp.load(inputMap);
                    timeline.components.add(comp);

                } else if (o instanceof HumanInterestComponent) {
                    HumanInterestComponent comp = (HumanInterestComponent) o;
                    comp.load(inputMap);
                    timeline.components.add(comp);
                } else {
                    System.out.println("Unable to add object");
                }
                printComponents();

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

    public static HashMap<String, Object> promptForInputMap(ArrayList<Prompt> prompts, HashMap<String, Object> inputMap) throws ParseException {
        for (Prompt p : prompts) {
            String name = p.getField().getName();
            
            //print the list of values
            for (Entry me : p.getList().entrySet()) {
                System.out.println(me.getKey() + " - " + me.getValue());
            }
            System.out.print(p.getPrompt());
            if (p.getListType().getClassType() == ListType.DEFAULT.getClassType()) {
                String input = InputUtil.waitForStringInput(p.getMin(), p.getMax(), (String) inputMap.get(name));
                inputMap.put(name, input);
            } else if (p.getListType().getClassType() == ListType.INTEGER.getClassType()) {
                int input = InputUtil.waitForIntInput(p.getMin(), p.getMax(), (int) inputMap.getOrDefault(name,0));
                inputMap.put(name, input);
            } else if (p.getListType().getClassType() == ListType.DATE.getClassType()) {
                Date input = InputUtil.waitForDateInput(p.getMin(), p.getMax(), (Date) inputMap.get(name));
                inputMap.put(name, input);
            }
        }
        return inputMap;
    }

    public static void sort() {
        Collections.sort(timeline.getComponents());
    }

    public static void setSaveOnExitToFalse() {
        saveOnExit = false;
    }

    public static void saveTimeline() {
        try {
            week4.timeline.io.files.XMLUtilities.saveTimelineToXML(timeline);
        } catch (JAXBException | FileNotFoundException ex) {
            Logger.getLogger(TimelineWorld.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Unable to save.");
        }
    }
}

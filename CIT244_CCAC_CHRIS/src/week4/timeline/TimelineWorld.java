/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week4.timeline;

import week4.utils.lits.input.InputUtil;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
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
import week4.timeline.menus.LanguageMenu;
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

    public static void main(String[] args) throws ParseException {

        //try loading the file
        try {
            timeline = XMLUtilities.loadXMLTimeline();
        } catch (JAXBException | FileNotFoundException ex) {
            Logger.getLogger(TimelineWorld.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Couldn't load the file. Adding default data.");
            defaultData(timeline);
        }
        System.out.println("The time began in the year " + timeline.getStartYear() + "...");
        mainMenu();

        //save the file before exiting
        if (saveOnExit) {
            saveTimeline();
            printComponents();
            System.out.println("Saved and Exited");

        } else {
            System.out.println("Exited without Saving");
        }
    }

    private static void defaultData(Timeline timeline) throws ParseException {
        HashMap ccMap = new HashMap();
        ccMap.put("object", ComputerComponent.class.toString());
        ccMap.put("createdOn", sdf.parse("2007-06-29"));
        ccMap.put("createdBy", "Apple");
        ccMap.put("title", "iPhone");
        ccMap.put("description", "iPhone");
        ccMap.put("referenceSourceUrl", "http://www.apple.com/iPhone");
        ComputerComponent cc = new ComputerComponent(ccMap);
        timeline.getComponents().add(cc);
        HashMap<String, Object> hicMap = new HashMap();
        hicMap.put("object", ComputerComponent.class.toString());
        hicMap.put("createdOn", sdf.parse("2013-09-02"));
        hicMap.put("createdBy", "Microsoft");
        hicMap.put("title", "Surface Pro");
        hicMap.put("description", "Surface Pro");
        hicMap.put("referenceSourceUrl", "https://en.wikipedia.org/wiki/Surface_Pro");
        HumanInterestComponent hic = new HumanInterestComponent(hicMap);
        timeline.getComponents().add(hic);

    }

    public static void printComponents() {
        for (int i = 0; i < timeline.getComponents().size(); i++) {
            System.out.println(i + " - " + timeline.getComponents().get(i).toString());
        }

    }
    
        public static void printWireframe() {
            System.out.println("[] / 100px,Created On/200px,Title,Created By,Refrence Source URL");
        for (int i = 0; i < timeline.getComponents().size(); i++) {
            System.out.println(timeline.getComponents().get(i).toWireframe());
        }

    }
    

    private static void mainMenu() {
        boolean exit = false;
        while (!exit) {
            int selected = 0;
            System.out.println("\n\nMain Menu:\n");
            MenuItem.printEntireMenu();
            selected = InputUtil.waitForIntInput(0, MenuItem.values().length, 0);
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
                HashMap<String, Object> inputMap = new HashMap<>();
                inputMap = promptForInputMap(prompts, inputMap);
                Object o = c.newInstance();
                if (o instanceof ComputerComponent) {
                    ComputerComponent comp = (ComputerComponent) o;
                    comp.load(inputMap);
                    timeline.components.add(comp);

                } else if (o instanceof HumanInterestComponent) {
                    HumanInterestComponent comp = (HumanInterestComponent) o;
                    comp.load(inputMap);
                    timeline.components.add(comp);
                } else if (o instanceof Component) {
                    Component comp = (Component) o;
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

    private static void editComponent() throws InstantiationException, IllegalAccessException, ParseException {
        boolean exit = false;
        while (!exit) {
            int timelineSize = timeline.getComponents().size();
            int selected = 0;
            System.out.println("\n\nEdit Component:\n");
            printComponents();
            System.out.println(timelineSize + " -  Exit");
            selected = InputUtil.waitForIntInput(0, timelineSize, 0);

            if (selected == timelineSize) {
                exit = true;
            } else {
                Component o = timeline.getComponents().get(selected);
                if (o instanceof ComputerComponent) {
                    ComputerComponent comp = (ComputerComponent) o;
                    ArrayList<Prompt> prompts = FieldHelpers.retrieveClassFieldsForPrompting(o.getClass());
                    HashMap<String, Object> inputMap = comp.export();
                    inputMap = promptForInputMap(prompts, inputMap);
                    comp.load(inputMap);
                } else if (o instanceof HumanInterestComponent) {
                    HumanInterestComponent comp = (HumanInterestComponent) o;
                    ArrayList<Prompt> prompts = FieldHelpers.retrieveClassFieldsForPrompting(o.getClass());
                    HashMap<String, Object> inputMap = comp.export();
                    inputMap = promptForInputMap(prompts, inputMap);
                    comp.load(inputMap);
                } else if (o instanceof Component) {
                    Component comp = (Component) o;
                    ArrayList<Prompt> prompts = FieldHelpers.retrieveClassFieldsForPrompting(o.getClass());
                    HashMap<String, Object> inputMap = comp.export();
                    inputMap = promptForInputMap(prompts, inputMap);
                    comp.load(inputMap);
                } else {
                    System.out.println("Unable to edit component.");
                }
                printComponents();

            }
            //TODO: add sleep
        }
    }

    private static void duplicateComponent() throws InstantiationException, IllegalAccessException, ParseException {
        boolean exit = false;
        while (!exit) {
            int timelineSize = timeline.getComponents().size();
            int selected = 0;
            System.out.println("\n\nSelect a Component to duplicate:\n");
            printComponents();
            System.out.println(timelineSize + " -  Exit");
            selected = InputUtil.waitForIntInput(0, timelineSize, 0);

            if (selected == timelineSize) {
                exit = true;
            } else {
                Component o = timeline.getComponents().get(selected);
                if (o instanceof ComputerComponent) {
                    ComputerComponent comp = new ComputerComponent(((ComputerComponent) o).export());
                    ArrayList<Prompt> prompts = FieldHelpers.retrieveClassFieldsForPrompting(o.getClass());
                    HashMap<String, Object> inputMap = comp.export();
                    inputMap = promptForInputMap(prompts, inputMap);
                    comp.load(inputMap);
                    timeline.getComponents().add(comp);
                } else if (o instanceof HumanInterestComponent) {
                    HumanInterestComponent comp = new HumanInterestComponent(((HumanInterestComponent) o).export());
                    ArrayList<Prompt> prompts = FieldHelpers.retrieveClassFieldsForPrompting(o.getClass());
                    HashMap<String, Object> inputMap = comp.export();
                    inputMap = promptForInputMap(prompts, inputMap);
                    comp.load(inputMap);
                    timeline.getComponents().add(comp);
                } else if (o instanceof Component) {
                    Component comp = new Component(((Component) o).export());
                    ArrayList<Prompt> prompts = FieldHelpers.retrieveClassFieldsForPrompting(o.getClass());
                    HashMap<String, Object> inputMap = comp.export();
                    inputMap = promptForInputMap(prompts, inputMap);
                    comp.load(inputMap);
                    timeline.getComponents().add(comp);
                } else {
                    System.out.println("Unable to duplicate component.");
                }
                printComponents();

            }
            //TODO: add sleep
        }
    }

    private static void changeLanguage() {
        int selected = 0;
        boolean exit = false;
        while (!exit) {
            LanguageMenu.printEntireMenu();
            selected = InputUtil.waitForIntInput(1, LanguageMenu.values().length, 0);
            if (selected != LanguageMenu.EXIT.getMenuItemid()) {
                Locale.setDefault(LanguageMenu.findById(selected).getLocale());
                System.out.println("Local set to " + Locale.getDefault().getDisplayName());
                Properties.refreshLabelsBundle();
            }
            exit = true;

        }
    }

    private static void deleteComponent() throws InstantiationException, IllegalAccessException, ParseException {
        boolean exit = false;
        while (!exit) {
            int timelineSize = timeline.getComponents().size();
            int selected = 0;
            System.out.println("\n\nDelete Component:\n");
            printComponents();
            System.out.println(timelineSize + " -  Exit");
            selected = InputUtil.waitForIntInput(0, timelineSize, 0);
            if (selected == timelineSize) {
                exit = true;
            } else {
                Component o = timeline.getComponents().get(selected);
                if (o != null) {
                    System.out.println("Are you sure you would like to delete this component: " + o.getDescription() + "?");
                    Boolean confirm = InputUtil.waitForBooleanInput(null);
                    if (confirm) {
                        timeline.getComponents().remove(o);
                    } else {
                        System.out.println("Cancelled.");
                    }
                } else {
                    System.out.println("Unable to delete component.");
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
                int input = InputUtil.waitForIntInput(p.getMin(), p.getMax(), (int) inputMap.getOrDefault(name, 0));
                inputMap.put(name, input);
            } else if (p.getListType().getClassType() == ListType.DOUBLE.getClassType()) {
                Double input = InputUtil.waitForDoubleInput(p.getMin(), p.getMax(), (Double) inputMap.getOrDefault(name, 0d));
                inputMap.put(name, input);
            } else if (p.getListType().getClassType() == ListType.BOOLEAN.getClassType()) {
                Boolean input = InputUtil.waitForBooleanInput((Boolean) inputMap.get(name));
                inputMap.put(name, input);
            } else if (p.getListType().getClassType() == ListType.DATE.getClassType()) {
                Date input = InputUtil.waitForDateInput(p.getMin(), p.getMax(), (Date) inputMap.get(name));
                inputMap.put(name, input);
            }
        }
        return inputMap;
    }

    public static void sort() {
        timeline.sortTimeline();
    }
    
    public static void startGUI(){
        TimelineWorldGUI.run();
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

    public static Timeline getTimeline() {
        return timeline;
    }

    public static void setTimeline(Timeline timeline) {
        TimelineWorld.timeline = timeline;
    }

    public static boolean isSaveOnExit() {
        return saveOnExit;
    }

    public static void setSaveOnExit(boolean saveOnExit) {
        TimelineWorld.saveOnExit = saveOnExit;
    }

    public static SimpleDateFormat getSdf() {
        return sdf;
    }

    public static void setSdf(SimpleDateFormat sdf) {
        TimelineWorld.sdf = sdf;
    }
    
    
}

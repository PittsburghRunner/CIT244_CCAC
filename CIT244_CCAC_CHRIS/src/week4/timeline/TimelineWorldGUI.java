/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week4.timeline;

import java.awt.BorderLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.*;
import week4.timeline.menus.MenuItem;

/**
 *
 * @author christopher.eckles
 */
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashMap;
import week4.timeline.components.Component;
import week4.utils.lits.FieldHelpers;
import week4.utils.lits.ListType;
import week4.utils.lits.input.PromptParams;

public class TimelineWorldGUI extends JPanel {

    public TimelineWorldGUI() {
        super(new GridLayout(1, 0));

        JTable table = new JTable(new TimelineTable());
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);
        table.setAutoCreateRowSorter(true);

        JScrollPane scrollPane = new JScrollPane(table);

        add(scrollPane);
    }

    class TimelineTable extends AbstractTableModel {

        private String[] columnNames = {"Created On", "Title", "Created By", "Reference Source URL"};
        private ArrayList<Component> data = TimelineWorld.getTimeline().getComponents();

        public int getColumnCount() {
            return columnNames.length;
        }

        public int getRowCount() {
            return TimelineWorld.getTimeline().getComponents().size();
        }

        public String getColumnName(int col) {
            return columnNames[col];
        }

        public Object getValueAt(int row, int col) {
            Component c = data.get(row);
            Class clazz = c.getClass();
            ////
            FieldHelpers.invokeMethod(clazz,get+da);
            return Timeline.invokeMethod() data.get(row); // invoke a method based on column number
        }

        /*
         * JTable uses this method to determine the default renderer/
         * editor for each cell.  If we didn't implement this method,
         * then the last column would contain text ("true"/"false"),
         * rather than a check box.
         */
        public Class getColumnClass(int c) {
            return getValueAt(0, c).getClass();
        }

        /*
         * Don't need to implement this method unless your table's
         * editable.
         */
        public boolean isCellEditable(int row, int col) {
            //Note that the data/cell address is constant,
            //no matter where the cell appears onscreen.
            if (col < 2) {
                return false;
            } else {
                return true;
            }
        }

        /*
         * Don't need to implement this method unless your table's
         * data can change.
         */
        public void setValueAt(Object value, int row, int col) {
            timeline data
            .get(row).[col] = value;
        }

    }

    private static void createAndShowGUI() {

        JFrame frame = new JFrame(Properties.getLabel("timeline.world"));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        TimelineWorldGUI newContentPane = new TimelineWorldGUI();
        newContentPane.setOpaque(true);
        frame.setContentPane(newContentPane);

        frame.pack();
        frame.setVisible(true);
    }

    public static void run() {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    public static HashMap<Field, PromptParams> getFieldAnnotations(Class c) {
        Field[] fields = c.getDeclaredFields();
        HashMap<Field, PromptParams> promptParamsSet = new HashMap<>();
        for (Field field : fields) {
            field.getName();
            Annotation[] annotationList = field.getAnnotations();
            for (Annotation a : annotationList) {
                if (a instanceof PromptParams) {
                    PromptParams p = (PromptParams) a;
                    promptParamsSet.put(field, p);
                }
            }
        }
        return promptParamsSet;
    }
    
    public static Object[] getFieldNames(HashMap<Field, PromptParams> promptParamsSet){
        ArrayList<String> al = new ArrayList();
        
        for(PromptParams pp : promptParamsSet.values()){
            al.add(pp.name());
        }
        return al.toArray();
    }
}

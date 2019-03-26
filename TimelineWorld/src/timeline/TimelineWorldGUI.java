/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timeline;


import java.awt.Button;
import java.util.ArrayList;

/**
 *
 * @author christopher.eckles
 */
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.TextField;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashMap;
import javafx.event.ActionEvent;
import timeline.components.Component;
import timeline.utils.lits.input.PromptParams;

public class TimelineWorldGUI extends JPanel {

    public TimelineWorldGUI() {
        super(new GridLayout(1, 0));

        JTable table = new JTable(new TimelineTableModel());
        table.setPreferredScrollableViewportSize(new Dimension(1500, 900));
        table.setFillsViewportHeight(true);
        table.setAutoCreateRowSorter(true);

        JScrollPane scrollPane = new JScrollPane(table);

        add(scrollPane);
        
 
    }

    

    private static void createAndShowGUI() {

        JFrame frame = new JFrame(Properties.getLabel("timeline.world"));
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

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

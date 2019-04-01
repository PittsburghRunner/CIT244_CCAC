/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timeline;

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
import java.awt.event.ActionListener;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashMap;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import timeline.utils.lits.input.PromptParams;

public class TimelineWorldGUI extends JPanel implements ActionListener {

    private static JTable table;
    private static JPanel buttonGroupPanel;
    protected JButton addButton;
    protected JButton editButton;

    public TimelineWorldGUI() {
        super(new GridLayout(1, 0));

        table = new JTable(new TimelineTableModel());
        buttonGroupPanel = new JPanel();

        addButton = new JButton("Add Component");
        addButton.setHorizontalTextPosition(AbstractButton.CENTER);
        addButton.setVerticalTextPosition(AbstractButton.BOTTOM);
        addButton.setSize(4, 1);
        addButton.addActionListener(this);
        addButton.setActionCommand("addComponent");

        editButton = new JButton("Edit Component");
        editButton.setHorizontalTextPosition(AbstractButton.CENTER);
        editButton.setVerticalTextPosition(AbstractButton.BOTTOM);
        editButton.setSize(4, 1);
        editButton.addActionListener(this);
        editButton.setActionCommand("editComponent");

        table.setPreferredScrollableViewportSize(new Dimension(900, 400));
        table.setFillsViewportHeight(true);
        table.setAutoCreateRowSorter(true);

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);

        GroupLayout buttonGroupLayout = new GroupLayout(buttonGroupPanel);
        buttonGroupPanel.setLayout(buttonGroupLayout);
        buttonGroupLayout.setHorizontalGroup(
                buttonGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buttonGroupLayout.createSequentialGroup()
                                .addComponent(addButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(editButton)
                        ));

        buttonGroupLayout.setVerticalGroup(
                buttonGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buttonGroupLayout.createSequentialGroup()
                                .addComponent(addButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(editButton)
                        ));
        add(buttonGroupPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("addComponent")) {
            AddEditForm addEditForm = new AddEditForm();
            this.add(addEditForm);
            this.repaint();;
        }
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

    public static Object[] getFieldNames(HashMap<Field, PromptParams> promptParamsSet) {
        ArrayList<String> al = new ArrayList();

        for (PromptParams pp : promptParamsSet.values()) {
            al.add(Properties.getLabel(pp.name()));
        }
        return al.toArray();
    }

    public static JTable getTable() {
        return table;
    }

    public static void setTable(JTable table) {
        TimelineWorldGUI.table = table;
    }

    public static JPanel getButtonGroupPanel() {
        return buttonGroupPanel;
    }

    public static void setButtonGroupPanel(JPanel buttonGroupPanel) {
        TimelineWorldGUI.buttonGroupPanel = buttonGroupPanel;
    }

    public JButton getAddButton() {
        return addButton;
    }

    public void setAddButton(JButton addButton) {
        this.addButton = addButton;
    }

    public JButton getEditButton() {
        return editButton;
    }

    public void setEditButton(JButton editButton) {
        this.editButton = editButton;
    }

}

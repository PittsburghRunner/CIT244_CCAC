/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timeline;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import timeline.components.Component;
import timeline.components.ComputerComponent;

/**
 *
 * @author ceckles
 */
public class AddEditFrame extends javax.swing.JPanel {

    boolean edit = false;
    Component component;
    HashMap<String, Object> map = new HashMap<>();

    /**
     * Creates new form AddEditFrame
     */
    public AddEditFrame() {
        component = new ComputerComponent();
        initComponents();
        if (wizardPane.getTabCount() == 1) {
            next.setEnabled(false);
            previous.setEnabled(false);
        }
    }

    public AddEditFrame(Component selectedComponent) {
        edit = true;
        component = selectedComponent;
        map = selectedComponent.export();
        initComponents();
        if (wizardPane.getTabRunCount() == 1) {
            next.setEnabled(false);
            previous.setEnabled(false);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        wizardPane = new javax.swing.JTabbedPane();
        addEditPanel = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        title = new javax.swing.JTextField();
        createdByLabel = new javax.swing.JLabel();
        createdBy = new javax.swing.JTextField();
        label3 = new javax.swing.JLabel();
        createdOnLabel = new javax.swing.JLabel();
        createdOn = new javax.swing.JTextField();
        referenceSourceUrl = new javax.swing.JTextField();
        imageUrlLabel = new javax.swing.JLabel();
        imageUrl = new javax.swing.JTextField();
        descriptionLabel = new javax.swing.JLabel();
        description = new javax.swing.JTextField();
        addEditPanel1 = new javax.swing.JPanel();
        megahertzCPUSpeedLabel = new javax.swing.JLabel();
        megahertzCPUSpeed = new javax.swing.JTextField();
        communicationSpeedLabel = new javax.swing.JLabel();
        comunicationSpeed = new javax.swing.JTextField();
        manufacturerLabel = new javax.swing.JLabel();
        manufacturer = new javax.swing.JTextField();
        modelLabel = new javax.swing.JLabel();
        model = new javax.swing.JTextField();
        communicationSpeedUnitLabel = new javax.swing.JLabel();
        comunicationSpeedUnit = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        save = new javax.swing.JButton();
        previous = new javax.swing.JButton();
        jProgressBar1 = new javax.swing.JProgressBar();
        next = new javax.swing.JButton();

        titleLabel.setText("Title");

        title.setText((String)map.getOrDefault("title", ""));
        title.setToolTipText("");
        title.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                titleActionPerformed(evt);
            }
        });

        createdByLabel.setText("Created By");

        createdBy.setText((String)map.getOrDefault("createdBy", ""));

        label3.setText("Reference URL");

        createdOnLabel.setText("Created On");

        createdOn.setText(TimelineWorld.getSdf().format((Date)map.getOrDefault("createdOn", new Date())));

        referenceSourceUrl.setText((String)map.getOrDefault("referenceSourceUrl", ""));

        imageUrlLabel.setText("Image URL");

        imageUrl.setText((String)map.getOrDefault("imageUrl", ""));

        descriptionLabel.setText("Description");

        description.setText((String)map.getOrDefault("description", ""));

        javax.swing.GroupLayout addEditPanelLayout = new javax.swing.GroupLayout(addEditPanel);
        addEditPanel.setLayout(addEditPanelLayout);
        addEditPanelLayout.setHorizontalGroup(
            addEditPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addEditPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(addEditPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addEditPanelLayout.createSequentialGroup()
                        .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(title))
                    .addGroup(addEditPanelLayout.createSequentialGroup()
                        .addComponent(createdByLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(createdBy))
                    .addGroup(addEditPanelLayout.createSequentialGroup()
                        .addComponent(createdOnLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(createdOn))
                    .addGroup(addEditPanelLayout.createSequentialGroup()
                        .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(referenceSourceUrl))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addEditPanelLayout.createSequentialGroup()
                        .addComponent(imageUrlLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(imageUrl))
                    .addGroup(addEditPanelLayout.createSequentialGroup()
                        .addComponent(descriptionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(description)))
                .addContainerGap())
        );
        addEditPanelLayout.setVerticalGroup(
            addEditPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addEditPanelLayout.createSequentialGroup()
                .addGroup(addEditPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addEditPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(createdBy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(createdByLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addEditPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createdOn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(createdOnLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addEditPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(referenceSourceUrl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addEditPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(imageUrlLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imageUrl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addEditPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addEditPanelLayout.createSequentialGroup()
                        .addComponent(descriptionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(description, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)))
        );

        wizardPane.addTab("General", addEditPanel);

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("timeline/resources/labels"); // NOI18N
        megahertzCPUSpeedLabel.setText(bundle.getString("mhz.cpu.speed")); // NOI18N

        megahertzCPUSpeed.setText((String)map.getOrDefault("megahertzCPUSpeed", ""));
        megahertzCPUSpeed.setToolTipText("");
        megahertzCPUSpeed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                megahertzCPUSpeedActionPerformed(evt);
            }
        });

        communicationSpeedLabel.setText(bundle.getString("communication.speed")); // NOI18N

        comunicationSpeed.setText((String)map.getOrDefault("comunicationSpeed", ""));

        manufacturerLabel.setText(bundle.getString("manufacturer")); // NOI18N

        manufacturer.setText((String)map.getOrDefault("manufacturer", ""));

        modelLabel.setText(bundle.getString("model")); // NOI18N

        model.setText((String)map.getOrDefault("model", ""));

        communicationSpeedUnitLabel.setText(bundle.getString("communication.speed.unit")); // NOI18N

        comunicationSpeedUnit.setText((String)map.getOrDefault("comunicationSpeedUnit", ""));
        comunicationSpeedUnit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comunicationSpeedUnitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout addEditPanel1Layout = new javax.swing.GroupLayout(addEditPanel1);
        addEditPanel1.setLayout(addEditPanel1Layout);
        addEditPanel1Layout.setHorizontalGroup(
            addEditPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addEditPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(addEditPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addEditPanel1Layout.createSequentialGroup()
                        .addComponent(modelLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(model, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(addEditPanel1Layout.createSequentialGroup()
                        .addGroup(addEditPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(megahertzCPUSpeedLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(manufacturerLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(addEditPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(addEditPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(manufacturer, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(addEditPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(megahertzCPUSpeed))))
                    .addGroup(addEditPanel1Layout.createSequentialGroup()
                        .addGroup(addEditPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(communicationSpeedLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(communicationSpeedUnitLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(addEditPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(comunicationSpeedUnit, javax.swing.GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE)
                            .addComponent(comunicationSpeed))))
                .addContainerGap())
        );
        addEditPanel1Layout.setVerticalGroup(
            addEditPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addEditPanel1Layout.createSequentialGroup()
                .addGroup(addEditPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(megahertzCPUSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(megahertzCPUSpeedLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addEditPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(comunicationSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(communicationSpeedLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addEditPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(comunicationSpeedUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(communicationSpeedUnitLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addEditPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(manufacturer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(manufacturerLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addEditPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(model)
                    .addComponent(modelLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 59, Short.MAX_VALUE))
        );

        wizardPane.addTab("Additonal Details", addEditPanel1);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Add New Component");

        save.setText("Save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        previous.setText("Previous");
        previous.setEnabled(false);
        previous.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previousActionPerformed(evt);
            }
        });

        jProgressBar1.setValue(50);

        next.setText("Next");
        next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(previous)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(next)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(save)
                        .addGap(17, 17, 17))
                    .addComponent(wizardPane, javax.swing.GroupLayout.Alignment.TRAILING)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 695, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(wizardPane, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(save)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(next)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(previous)
                            .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(9, 9, 9)
                    .addComponent(jLabel1)
                    .addContainerGap(304, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void titleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_titleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_titleActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        map.put("title", title.getText());
        map.put("createdBy", createdBy.getText());

        try {
            map.put("createdOn", TimelineWorld.getSdf().parse(createdOn.getText()));
        } catch (ParseException ex) {
            Logger.getLogger(AddEditFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        map.put("description", description.getText());
        map.put("referenceSourceUrl", referenceSourceUrl.getText());
        map.put("imageUrl", imageUrl.getText());

        component.load(map);
        if (!edit) {
            TimelineWorld.getTimeline().getComponents().add(component);
        }
        this.hide();
        this.setOpaque(false);
    }//GEN-LAST:event_saveActionPerformed

    private void previousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousActionPerformed
        int currentIndex = wizardPane.getSelectedIndex();
        int tabCount = wizardPane.getTabRunCount();

        if (wizardPane.getTabRunCount() == 1) {
            next.setEnabled(false);
            previous.setEnabled(false);
        } else if (currentIndex == 0) {
            previous.setEnabled(false);
            next.setEnabled(true);
        } else if (currentIndex == 1) {
            wizardPane.setSelectedIndex(0);
            previous.setEnabled(false);
            next.setEnabled(true);
        } else {
            wizardPane.setSelectedIndex(currentIndex - 1);
            next.setEnabled(true);
        }
    }//GEN-LAST:event_previousActionPerformed

    private void nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextActionPerformed
        int currentIndex = wizardPane.getSelectedIndex();
        int tabCount = wizardPane.getTabCount();

        if (wizardPane.getTabRunCount() == 1) {
            next.setEnabled(false);
            previous.setEnabled(false);
        } else if (currentIndex == tabCount - 1) {
            next.setEnabled(false);
            previous.setEnabled(true);
        } else if (currentIndex == tabCount - 2) {
            wizardPane.setSelectedIndex(currentIndex + 1);
            next.setEnabled(false);
            previous.setEnabled(true);
        } else {
            wizardPane.setSelectedIndex(currentIndex + 1);
            previous.setEnabled(true);
        }

        previous.setEnabled(true);


    }//GEN-LAST:event_nextActionPerformed

    private void megahertzCPUSpeedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_megahertzCPUSpeedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_megahertzCPUSpeedActionPerformed

    private void comunicationSpeedUnitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comunicationSpeedUnitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comunicationSpeedUnitActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel addEditPanel;
    private javax.swing.JPanel addEditPanel1;
    private javax.swing.JLabel communicationSpeedLabel;
    private javax.swing.JLabel communicationSpeedUnitLabel;
    private javax.swing.JTextField comunicationSpeed;
    private javax.swing.JTextField comunicationSpeedUnit;
    private javax.swing.JTextField createdBy;
    private javax.swing.JLabel createdByLabel;
    private javax.swing.JTextField createdOn;
    private javax.swing.JLabel createdOnLabel;
    private javax.swing.JTextField description;
    private javax.swing.JLabel descriptionLabel;
    private javax.swing.JTextField imageUrl;
    private javax.swing.JLabel imageUrlLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JLabel label3;
    private javax.swing.JTextField manufacturer;
    private javax.swing.JLabel manufacturerLabel;
    private javax.swing.JTextField megahertzCPUSpeed;
    private javax.swing.JLabel megahertzCPUSpeedLabel;
    private javax.swing.JTextField model;
    private javax.swing.JLabel modelLabel;
    private javax.swing.JButton next;
    private javax.swing.JButton previous;
    private javax.swing.JTextField referenceSourceUrl;
    private javax.swing.JButton save;
    private javax.swing.JTextField title;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JTabbedPane wizardPane;
    // End of variables declaration//GEN-END:variables
}

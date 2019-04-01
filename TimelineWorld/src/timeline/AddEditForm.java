package timeline;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import timeline.components.Component;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ceckles
 */
public class AddEditForm extends javax.swing.JPanel {
    Component component;
    HashMap<String, Object> map = new HashMap<>();

    /**
     * Creates new form AddEditForm
     */
    public AddEditForm() {
        component = new Component();
        map = new HashMap();
        initComponents();
    }
    public AddEditForm(Component selectedComponent) {
        component = selectedComponent;
        map = selectedComponent.export();
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();
        save = new javax.swing.JButton();
        jTabbedPane3 = new javax.swing.JTabbedPane();
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

        jProgressBar1.setValue(10);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Add New Component");

        save.setText("Save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

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

        jTabbedPane3.addTab("General", addEditPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(save)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(save)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void titleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_titleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_titleActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
            map.put("title",title.getText());
            map.put("createdBy",createdBy.getText());
           
        try {
            map.put("createdOn", TimelineWorld.getSdf().parse(createdOn.getText()));
        } catch (ParseException ex) {
            Logger.getLogger(AddEditForm.class.getName()).log(Level.SEVERE, null, ex);
        }
            map.put("description",description.getText());
            map.put("referenceSourceUrl",referenceSourceUrl.getText());
            map.put("imageUrl",imageUrl.getText());
            Component comp = new Component(map);
            TimelineWorld.getTimeline().getComponents().add(comp);
            TimelineWorldGUI.getTable().getModel().;
            
    }//GEN-LAST:event_saveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel addEditPanel;
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
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JLabel label3;
    private javax.swing.JTextField referenceSourceUrl;
    private javax.swing.JButton save;
    private javax.swing.JTextField title;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}

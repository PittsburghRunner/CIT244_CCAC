/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timeline;

import javax.swing.JFrame;

/**
 *
 * @author ceckles
 */
public class TimelineGUI extends javax.swing.JPanel {
    /**
     * Creates new form TimelineGUI
     */
    public TimelineGUI() {
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        timelineTable = new javax.swing.JTable();
        addComoponentButton = new java.awt.Button();
        editComoponentButton = new java.awt.Button();
        deleteComoponentButton = new java.awt.Button();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        timelineTable.setModel(new TimelineTableModel());
        jScrollPane2.setViewportView(timelineTable);

        addComoponentButton.setLabel("Add Component");
        addComoponentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addComoponentButtonActionPerformed(evt);
            }
        });

        editComoponentButton.setActionCommand("Delete Component");
        editComoponentButton.setLabel("Edit Component");
        editComoponentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editComoponentButtonActionPerformed(evt);
            }
        });

        deleteComoponentButton.setActionCommand("Delete Component");
        deleteComoponentButton.setLabel("Delete Component");
        deleteComoponentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteComoponentButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addComoponentButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteComoponentButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editComoponentButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(addComoponentButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(editComoponentButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(deleteComoponentButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        editComoponentButton.getAccessibleContext().setAccessibleName("Delete Component");
    }// </editor-fold>//GEN-END:initComponents

    private void addComoponentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addComoponentButtonActionPerformed
            JFrame frame = new JFrame();
            AddEditFrame addEditFrame =  new AddEditFrame();
//            frame.setSize(addEditFrame.getSize());
            frame.setSize(1000, 400);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.add(addEditFrame);
            
            frame.setVisible(true);
    }//GEN-LAST:event_addComoponentButtonActionPerformed

    private void editComoponentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editComoponentButtonActionPerformed
            JFrame frame = new JFrame();
            
            Integer row = timelineTable.getSelectedRow();
            System.out.println(row);
            if (row >= 0 && row < timelineTable.getRowCount()){
            AddEditFrame addEditFrame = new AddEditFrame(((TimelineTableModel)timelineTable.getModel()).getRow(row));
//            frame.setSize(addEditFrame.getSize());
           frame.setSize(1000, 400);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.add(addEditFrame);
            frame.setVisible(true);
            }
            
    }//GEN-LAST:event_editComoponentButtonActionPerformed

    private void deleteComoponentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteComoponentButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteComoponentButtonActionPerformed

    private void createAndShowGUI() {

        JFrame frame = new JFrame(Properties.getLabel("timeline.world"));
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        TimelineGUI newContentPane = new TimelineGUI();
        newContentPane.setOpaque(true);
        frame.setContentPane(newContentPane);

        frame.pack();
        frame.setVisible(true);
    }

    public void run() {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button addComoponentButton;
    private java.awt.Button deleteComoponentButton;
    private java.awt.Button editComoponentButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable timelineTable;
    // End of variables declaration//GEN-END:variables
}

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
public class TimelineWorldGUI extends JPanel
        implements ItemListener {

    private ArrayList<javax.swing.JButton> menuButtons = new ArrayList();

    public TimelineWorldGUI() {
        super(new BorderLayout());
    for(MenuItem mi:MenuItem.values()){
     JButton button = new JButton(mi.toString());
    }
        
        
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ArrayList<JButton> getInputBoxes() {
        return menuButtons;
    }

    public void setInputBoxes(ArrayList<JButton> inputBoxes) {
        this.menuButtons = inputBoxes;
    }

    
}

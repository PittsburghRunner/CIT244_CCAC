/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timeline;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import timeline.components.Component;

/**
 *
 * @author ceckles
 */
class TimelineTableModel extends AbstractTableModel {

    private String[] columnNames = {"Created On", "Title", "Created By", "Reference Source URL"};
    private ArrayList<? extends Component> data = TimelineWorld.getTimeline().getComponents();

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
        Component entry = data.get(row); // invoke a method based on column number
        if (0 == col) {
            return entry.getCreatedOn();
        } else if (1 == col) {
            return entry.getTitle();
        } else if (2 == col) {
            return entry.getCreatedBy();
        } else if (3 == col) {
            return entry.getReferenceSourceUrl();
        }
        return null;
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
        return true;
    }

    /*
         * Don't need to implement this method unless your table's
         * data can change.
     */
    public void setValueAt(Object value, int row, int col) {
        Component entry = data.get(row); // invoke a method based on column number
        if (0 == col) {
            entry.setCreatedOn((Date) value);
        } else if (1 == col) {
            entry.setTitle((String) value);
        } else if (2 == col) {
            entry.setCreatedBy((String) value);
        } else if (3 == col) {
            entry.setReferenceSourceUrl((String) value);
        }
    }

//    public static Object[][] loadComponents(ArrayList<? extends Component> components) {
//
//        Object[][] list = new Object[components.size()][5];
//
//        for (int i = 0; i < components.size(); i++) {
//            Component c = components.get(i);
//            Object[] row = new Object[4];
//            row[0] = c.getCreatedOn();
//            row[1] = c.getTitle();
//            row[2] = c.getCreatedBy();
//            row[3] = c.getReferenceSourceUrl();
//
//            list[i] = row;
//        }
//
//        return list;
//    }
}

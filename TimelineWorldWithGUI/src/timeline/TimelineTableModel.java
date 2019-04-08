/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timeline;

import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.AbstractTableModel;
import timeline.components.Component;
import timeline.menus.ComponentMenu;

/**
 *
 * @author ceckles
 */
class TimelineTableModel extends AbstractTableModel {

    private String[] columnNames = {"created.on", "title", "created.by", "reference.source.url", "component.type"};
    private ArrayList<? extends Component> data = TimelineWorld.getTimeline().getComponents();

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }
    
    public Component getRow(int row) {
        return data.get(row);
    }
    
    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public String getColumnName(int col) {
        return Properties.getLabel(columnNames[col]);
    }

    @Override
    public Object getValueAt(int row, int col) {
        Component entry = data.get(row); // invoke a method based on column number
        switch (col) {
            case 0:
                return entry.getCreatedOn();
            case 1:
                return entry.getTitle();
            case 2:
                return entry.getCreatedBy();
            case 3:
                return entry.getReferenceSourceUrl();
            case 4:
                return Properties.getLabel(ComponentMenu.findByClassName(entry.getObject()).getMenuItemDescription());
            default:
                break;
        }
        return null;
    }

    /*
         * JTable uses this method to determine the default renderer/
         * editor for each cell.  If we didn't implement this method,
         * then the last column would contain text ("true"/"false"),
         * rather than a check box.
     */
    @Override
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    /*
         * Don't need to implement this method unless your table's
         * editable.
     */
    @Override
    public boolean isCellEditable(int row, int col) {
        //Note that the data/cell address is constant,
        //no matter where the cell appears onscreen.
        return true;
    }

    /*
         * Don't need to implement this method unless your table's
         * data can change.
     */
    @Override
    public void setValueAt(Object value, int row, int col) {
        Component entry = data.get(row); // invoke a method based on column number
        switch (col) {
            case 0:
                entry.setCreatedOn((Date) value);
                break;
            case 1:
                entry.setTitle((String) value);
                break;
            case 2:
                entry.setCreatedBy((String) value);
                break;
            case 3:
                entry.setReferenceSourceUrl((String) value);
                break;
            case 4:
                break;    
            default:
                break;
        }
        
        
    }
}

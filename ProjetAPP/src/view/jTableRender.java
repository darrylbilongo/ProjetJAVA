package view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class jTableRender extends DefaultTableCellRenderer {

	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		Component comp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row-1, column);
        Object o = table.getValueAt(row, column);
        
        if( o != null && component instanceof JLabel) {
        	JLabel label = (JLabel) component;
        	JLabel l = (JLabel) comp;
        	String s = label.getText();
        	if(!(s.equals("+") && s.equals("*") && s.equals(""))) {
        		component.setBackground(Color.RED);
        	}
        	if(s.equals("+")) {
        		comp.setBackground(Color.YELLOW);
        	}
        	if(s.equals("*") || s.equals("")) {
        		component.setBackground(new Color(0, 191, 255));
        	}
        	label.setHorizontalAlignment(CENTER);
        	label.setVerticalAlignment(CENTER);
        }
        
        
        return component;
	}
}

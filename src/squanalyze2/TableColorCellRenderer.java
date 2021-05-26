package squanalyze2;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

public class TableColorCellRenderer implements TableCellRenderer {
	private static final TableCellRenderer RENDERER = new DefaultTableCellRenderer();
	Color color = null;
			
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		Component c = RENDERER.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		
		if(column == 5) {
			Object Result = table.getModel().getValueAt(row,column);
			double BMI = Double.parseDouble(Result.toString());
			
			if(BMI>25 | BMI<18) {
				color = Color.red;
			}else{
				color = Color.green;
			}
			c.setBackground(color);
		}else{
				c.setBackground(Color.white);
			}
		return c;
	}
	 
}

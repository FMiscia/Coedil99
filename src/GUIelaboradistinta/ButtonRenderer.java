package GUIelaboradistinta;

import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class ButtonRenderer implements TableCellRenderer {
	public Component getTableCellRendererComponent(JTable t,
		Object value, boolean isSelected, boolean hasFocus, int row,
		int column)
	{
		return (JButton)value;
	}
}

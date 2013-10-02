package GUIelaboradistinta;

import java.awt.Component;
import java.util.EventObject;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.event.CellEditorListener;
import javax.swing.table.TableCellEditor;

public class ButtonEditor implements TableCellEditor {
	public Component getTableCellEditorComponent(JTable t, Object value,boolean isSelected, int row, int column)
	{
		return (JButton) value;
	}
	
	public Object getCellEditorValue() { return null; }
	public void cancelCellEditing() {}
	public boolean stopCellEditing() { return true;	}
	public boolean shouldSelectCell(EventObject o) { return true; }
	public boolean isCellEditable(EventObject o) { return true;	}
	public void addCellEditorListener(CellEditorListener l) {}
	public void removeCellEditorListener(CellEditorListener l) {}
}
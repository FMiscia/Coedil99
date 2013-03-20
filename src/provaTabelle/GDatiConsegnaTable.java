package provaTabelle;

import javax.swing.JTable;
import javax.swing.table.TableColumn;

import org.jdesktop.swingx.table.DatePickerCellEditor;

import com.toedter.calendar.JDateChooserCellEditor;

public class GDatiConsegnaTable extends JTable {

	public GDatiConsegnaTable(){
		
		GDatiConsegnaModel dati = new GDatiConsegnaModel();
		this.setModel(dati);
		TableColumn c = this.getColumnModel().getColumn(0);
		DatePickerCellEditor d = new DatePickerCellEditor();
		//JDateChooserCellEditor d = new JDateChooserCellEditor();
		c.setCellEditor(d);
	}
}

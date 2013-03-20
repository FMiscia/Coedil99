package provaTabelle;

import javax.swing.JTable;
import javax.swing.table.TableColumn;

import org.jdesktop.swingx.table.DatePickerCellEditor;

import com.toedter.calendar.JDateChooserCellEditor;

public class GDatiSviluppoConsegnaTable extends JTable {
	
	public GDatiSviluppoConsegnaTable(){
		GDatiSviluppoConsegnaModel dati = new GDatiSviluppoConsegnaModel();
		this.setModel(dati);
		for(int i = 1; i<4; ++i){
			TableColumn c = this.getColumnModel().getColumn(i);
			DatePickerCellEditor d = new DatePickerCellEditor();
			//JDateChooserCellEditor d = new JDateChooserCellEditor();
			c.setCellEditor(d);
		}

	}

}

package provaTabelle;

import javax.swing.JTable;
import javax.swing.table.TableColumn;

import org.jdesktop.swingx.table.DatePickerCellEditor;

import com.toedter.calendar.JDateChooserCellEditor;

public class GDatiAziendaliTable extends JTable {
	
	public GDatiAziendaliTable(){
		
		GDatiAziendaliModel dati = new GDatiAziendaliModel();
		this.setModel(dati);
		TableColumn c = this.getColumnModel().getColumn(5);
		TableColumn c1 = this.getColumnModel().getColumn(6);
		DatePickerCellEditor d = new DatePickerCellEditor();
		//JDateChooserCellEditor d = new JDateChooserCellEditor();
		c.setCellEditor(d);
		c1.setCellEditor(d);

		
	}

}

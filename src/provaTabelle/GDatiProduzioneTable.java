package provaTabelle;

import javax.swing.JTable;
import javax.swing.table.TableColumn;

import org.jdesktop.swingx.table.DatePickerCellEditor;

import com.toedter.calendar.JDateChooserCellEditor;

public class GDatiProduzioneTable extends JTable {

	public GDatiProduzioneTable(){
		
		GDatiProduzioneModel dati = new GDatiProduzioneModel();
		this.setModel(dati);
		for(int i=0; i<this.getColumnCount(); ++i)
		{
			TableColumn c = this.getColumnModel().getColumn(i);
			DatePickerCellEditor d = new DatePickerCellEditor();
		//JDateChooserCellEditor d = new JDateChooserCellEditor();
			c.setCellEditor(d);
		}
		
	}
}

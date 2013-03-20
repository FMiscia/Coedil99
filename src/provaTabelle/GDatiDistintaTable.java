package provaTabelle;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

import elaboradistinta.model.Distinta;

public class GDatiDistintaTable extends JTable {
	
	public GDatiDistintaTable(Distinta d){
		GDatiDistintaModel dati = new GDatiDistintaModel(d);
		this.setModel(dati);
		TableColumn capitello = this.getColumnModel().getColumn(4);
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("Si");
		comboBox.addItem("No");
		capitello.setCellEditor(new DefaultCellEditor(comboBox));
	}
	

}

package GUIelaboradistinta.table;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

import GUIelaboradistinta.ButtonEditor;
import GUIelaboradistinta.ButtonRenderer;

import GUIelaboradistinta.model.GDatiDistintaModel;


import elaboradistinta.model.Distinta;

public class GDatiDistintaTable extends JTable {
	
	public GDatiDistintaTable(Distinta d){
		GDatiDistintaModel dati = new GDatiDistintaModel(d);
		this.setModel(dati);
		TableColumn capitello = this.getColumnModel().getColumn(4);
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.addItem("Si");
		comboBox.addItem("No");
		capitello.setCellEditor(new DefaultCellEditor(comboBox));
		this.setDefaultRenderer(JButton.class, new GUIelaboradistinta.ButtonRenderer());
		this.setDefaultEditor(JButton.class, new GUIelaboradistinta.ButtonEditor());
		//this.setShowGrid(false); 
        //TableColumn bottone = this.getColumnModel().getColumn(7);
		//bottone.setCellRenderer(new ButtonRenderer());
		//bottone.setCellEditor(new ButtonEditor());
	}
	
	public void disabilitaModifica(){
		this.setEnabled(false);
		TableColumn col = this.getColumnModel().getColumn(7);
		col.setMinWidth(0);
		col.setMaxWidth(0);
		col.setPreferredWidth(0);
	}
	
	public void abilitaModifica(){
		this.setEnabled(true);
		TableColumn col = this.getColumnModel().getColumn(7);
		col.setMinWidth(70);
		col.setMaxWidth(100);
		col.setPreferredWidth(80);
	}
	
}
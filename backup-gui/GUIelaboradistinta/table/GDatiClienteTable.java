package GUIelaboradistinta.table;

import javax.swing.JTable;

import GUIelaboradistinta.model.GDatiClienteModel;


public class GDatiClienteTable extends JTable {
	
	public GDatiClienteTable(){
		GDatiClienteModel dati = new GDatiClienteModel();
		this.setModel(dati);
	}
	
}

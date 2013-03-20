package provaTabelle;

import javax.swing.JTable;

public class GDatiClienteTable extends JTable {
	
	public GDatiClienteTable(){
		GDatiClienteModel dati = new GDatiClienteModel();
		this.setModel(dati);
	}
	
}

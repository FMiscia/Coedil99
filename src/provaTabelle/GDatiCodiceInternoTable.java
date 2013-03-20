package provaTabelle;

import javax.swing.JTable;

public class GDatiCodiceInternoTable extends JTable {
	
	public GDatiCodiceInternoTable(){
		GDatiCodiceInternoModel dati = new GDatiCodiceInternoModel();
		this.setModel(dati);	
	}
	

}

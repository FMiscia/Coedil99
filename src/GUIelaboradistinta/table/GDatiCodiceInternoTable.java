package GUIelaboradistinta.table;

import javax.swing.JTable;

import GUIelaboradistinta.model.GDatiCodiceInternoModel;


public class GDatiCodiceInternoTable extends JTable {
	
	public GDatiCodiceInternoTable(){
		GDatiCodiceInternoModel dati = new GDatiCodiceInternoModel();
		this.setModel(dati);	
	}
	

}

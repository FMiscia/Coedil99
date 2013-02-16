package GUIElaboraDistinta;

import java.util.ArrayList;
import java.util.Vector;

import ElaboraDistinta.Commessa;
import ElaboraDistinta.Distinta;
import ElaboraDistinta.GestisciCommessaHandler;
import ElaboraDistinta.RigaLavoro;
import ElaboraDistinta.StartUp;

public class DistintaTable {
	
	private Vector<String> colonne ;
	private Vector<Vector<String>> righe;
	
	public DistintaTable(){
		GestisciCommessaHandler gch = GestisciCommessaHandler.getInstance();
		Distinta d = gch.getCommessaById(1).getDistinta();
		String[] cols = {"Posizione","Base","Altezza","Lunghezza","Numero","Profilo Capitello","Colore"};
		this.colonne = addColonne(cols);
		this.righe = new Vector<Vector<String>>();
		RigaLavoro r = null;
		for(Integer i=0; i<d.getRigheLavoro().size(); ++i){
			r = d.getRigheLavoro().get(i);
			righe.add(addRow(r));
		}
	}
	
	

	public Vector<String> addRow(RigaLavoro r){
		Vector<String> riga = new Vector<String>();
		riga.add("1");
		riga.add("10");
		riga.add("20");
		riga.add("30");
		riga.add("1");
		riga.add(r.getProfiloCapitello());
		riga.add(r.getNote());
		return riga;
	}
	
	public Vector<String> addColonne(String[] a){
		Vector<String> v = new Vector<String>();
		for(int i=0; i<a.length; ++i)
			v.add(a[i]);
		return v;
		
				
	}
		
	public Vector getColonne(){
		return this.colonne;
	}
	
	public Vector<Vector<String>> getRighe(){
		return this.righe;
	}
	

}

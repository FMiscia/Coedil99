package provaTabelle;

import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.table.AbstractTableModel;

import elaboradistinta.controller.GestisciClienteHandler;
import elaboradistinta.model.Cliente;
import elaboradistinta.model.Commessa;
import elaboradistinta.model.CommessaFactory;
import elaboradistinta.model.Ordine;

public class GDatiCodiceInternoModel extends AbstractTableModel {

	private ArrayList<Commessa> commesse = new ArrayList<Commessa>();
	private ArrayList<Ordine> ordini = new ArrayList<Ordine>();
	private ArrayList<Cliente> clienti = new ArrayList<Cliente>();
	private String[] colonna;
	
	public GDatiCodiceInternoModel(){
		this.colonna = new String[]{"Codice Interno"};
		GestisciClienteHandler gch = GestisciClienteHandler.getInstance();
		//GestisciOrdineHandler goh = GestisciOrdineHandler.getInstance();
		//GestisciCommessaHandler gcoh = GestisciCommessaHandler.getInstance();

		ArrayList<Cliente> c = new ArrayList<Cliente>(gch.getClienti());
		for(int k=0; k<c.size(); ++k){
			for(int j=0; j<c.get(k).ordini.size(); ++j){
				for(int i=0; i<c.get(k).ordini.get(j).commesse.size(); ++i){
					this.commesse.add(c.get(k).ordini.get(j).commesse.get(i));
					this.ordini.add(c.get(k).ordini.get(j));
					this.clienti.add(c.get(k));
				}
			}
		}
	}
	
	@Override
	public String getColumnName(int i) {
		return this.colonna[i];
	}

	@Override
	public boolean isCellEditable(int arg0, int arg1) {
		return false;
	}

	@Override
	public int getColumnCount() {
		return 1;
	}

	@Override
	public int getRowCount() {
		return this.commesse.size();
	}

	@Override
	public Object getValueAt(int riga, int colonna) {
		return this.commesse.get(riga).getCodiceInterno();
	}

}

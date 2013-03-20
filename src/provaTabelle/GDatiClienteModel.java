package provaTabelle;

import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.table.AbstractTableModel;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import elaboradistinta.controller.GestisciClienteHandler;
import elaboradistinta.controller.GestisciCommessaHandler;
import elaboradistinta.controller.GestisciOrdineHandler;
import elaboradistinta.model.Cliente;
import elaboradistinta.model.ClienteFactory;
import elaboradistinta.model.Commessa;
import elaboradistinta.model.Ordine;
import elaboradistinta.model.OrdineFactory;

public class GDatiClienteModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String[] colonne;
	
	private ArrayList<Cliente> clienti = new ArrayList<Cliente>();
	private ArrayList<Ordine> ordini = new ArrayList<Ordine>();
	private ArrayList<Commessa> commesse = new ArrayList<Commessa>();
	
	private static final int Cantiere = 0;
    private static final int Cliente = 1;
    private static final int CommessaCliente = 2;
    
	
	public GDatiClienteModel(){
		
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
		this.colonne = new String[] {"Cantiere" , "Cliente", "Commessa Cliente"};
			
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		if(columnIndex == 0)
			return false;
		return true;
	}

	@Override
	public void setValueAt(Object value, int rowIndex, int columnIndex) {
		Cliente c = this.clienti.get(rowIndex);
		try{
			if(value != null )
				if(!value.equals(""))
					this.cambiaValore(c.getID(), columnIndex, value.toString());
		}catch (PersistentException e) {
			e.printStackTrace();
		}
	}

	public void cambiaValore(int cid, int c, String value)throws PersistentException {
			PersistentTransaction t = elaboradistinta.model.CoedilPersistentManager.instance().getSession().beginTransaction();
			Cliente cliente = elaboradistinta.model.ClienteFactory.getClienteByORMID(cid);
			switch(c){
			case Cliente:
				cliente.setName(value);
				cliente.save();
				break;
			case CommessaCliente:
				cliente.setNumeroCommessaCliente(Integer.valueOf(value));
				cliente.save();
				break;
			}
			t.commit();
	}
	@Override
	public int getColumnCount() {
		return this.colonne.length;
	}

	@Override
	public int getRowCount() {
		return this.commesse.size();
	}

	@Override
	public String getValueAt(int riga, int colonna) {
		String valore = null;
		Cliente c = this.clienti.get(riga);
		switch(colonna){
		case Cantiere:
			if(c.getCantiere() == null)
				valore = "";
			else
				valore = c.getCantiere().getNome();
			break;
		case Cliente:
			if(c.getName() == null)
				valore = "";
			else
				valore = c.getName();
			break;
		case CommessaCliente:
			if(c.getNumeroCommessaCliente() == null)
				valore = "";
			else
				valore = c.getNumeroCommessaCliente().toString();
			break;
		}
		return valore;
	}
	
	public String getColumnName(int c){
		return this.colonne[c];
	}
	
		

}

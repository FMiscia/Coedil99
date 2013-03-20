package provaTabelle;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Locale;

import javax.swing.table.AbstractTableModel;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import elaboradistinta.controller.GestisciClienteHandler;
import elaboradistinta.model.Cliente;
import elaboradistinta.model.Ordine;
import elaboradistinta.model.Commessa;

public class GDatiAziendaliModel extends AbstractTableModel {

	private ArrayList<Ordine> ordini = new ArrayList<Ordine>();
	private ArrayList<Commessa> commesse = new ArrayList<Commessa>();
	private ArrayList<Cliente> clienti = new ArrayList<Cliente>();
	private String[] colonne;

	private static final int OC = 0;
	private static final int Anno = 1;
	private static final int OrdineC = 2;
	private static final int Commessa = 3;
	private static final int OrdineG = 4;
	private static final int DataI = 5;
	private static final int DataF = 6;
	private static final int Orario = 7;
	private static final int Descrizione = 8;
	private static final int Partizione = 9;

	public GDatiAziendaliModel() {
		this.colonne = new String[] { "O/C", "Anno", "Ordine/Contratto",
				"Commessa Coedil", "Ordine Gestionale", "Data Inizio",
				"Data Fine", "Orario", "Descrizione", "Partizione" };
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
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		if(columnIndex == 2 || columnIndex == 3)
			return false;
		return true;
	}

	@Override
	public void setValueAt(Object value, int rowIndex, int columnIndex) {
		Commessa c = this.commesse.get(rowIndex);
		for (int i = 0; i < this.ordini.size(); ++i) {
			for (int j = 0; j < this.ordini.get(i).commesse.size(); ++j)
				if (this.ordini.get(i).commesse.get(j).getID() == c.getID())
					try {
						if(value != null )
							if(!value.equals(""))
								this.cambiaValore(c.getID(), this.ordini.get(i).getID(), columnIndex,value.toString());
					} catch (PersistentException e) {
						e.printStackTrace();
					}
		}

	}

	private Date convertiData(String value){
		SimpleDateFormat sdfInput = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
		Calendar cal = Calendar.getInstance();
		try {
			cal.setTime(sdfInput.parse(value));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		java.sql.Date data = new java.sql.Date(cal.getTime().getTime());
		return data;
	}
	
	public void cambiaValore(int cid, int oid, int c, Object value)
			throws PersistentException {
		PersistentTransaction t = elaboradistinta.model.CoedilPersistentManager
				.instance().getSession().beginTransaction();
		Commessa commessa = elaboradistinta.model.CommessaFactory
				.getCommessaByORMID(cid);
		Ordine ordine = elaboradistinta.model.OrdineFactory
				.getOrdineByORMID(oid);
		switch (c) {
		case OC:
			ordine.setOC(value.toString());
			ordine.save();
			break;
		case Anno:
			ordine.setAnno(Integer.parseInt(value.toString()));
			ordine.save();
			break;
		case OrdineG:
			ordine.setOrdineGestionale(value.toString());
			ordine.save();
			break;
		case DataI:
			ordine.setDataInizio(this.convertiData(value.toString()));
			ordine.save();
			break;
		case DataF:
			ordine.setDataFine(this.convertiData(value.toString()));
			ordine.save();
			break;
		case Orario:
			commessa.setOrario(value.toString());
			commessa.save();
			break;
		case Descrizione:
			commessa.setDescrizione(value.toString());
			commessa.save();
			break;
		case Partizione:
			ordine.setNumeroOrdine(Integer.parseInt(value.toString()));
			ordine.save();
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
		Ordine o = new Ordine();
		String valore = "";
		Commessa c = this.commesse.get(riga);
		for (int i = 0; i < ordini.size(); ++i) {
			for (int j = 0; j < this.ordini.get(i).commesse.size(); ++j) {
				if (this.ordini.get(i).commesse.get(j).getID() == c.getID())
					o = this.ordini.get(i);
			}
			switch (colonna) {
			case OC:
				if (o.getOC() == null)
					valore = "";
				else
					valore = o.getOC();
				break;
			case Anno:
				if (o.getAnno() == null)
					valore = "";
				else
					valore = String.valueOf(o.getAnno());
				break;
			case OrdineC:
				valore = String.valueOf(o.getID());
				break;
			case Commessa:
				valore = String.valueOf(c.getID());
				break;
			case OrdineG:
				if (o.getOrdineGestionale() == null)
					valore = "";
				else
					valore = o.getOrdineGestionale();
				break;
			case DataI:
				if (o.getDataInizio() == null)
					valore = "";
				else
					valore = o.getDataInizio().toString();
				break;
			case DataF:
				if (o.getDataFine() == null)
					valore = "";
				else
					valore = o.getDataFine().toString();
				break;
			case Orario:
				if (c != null)
					if (c.getOrario() != null)
						valore = c.getOrario();
					else
						valore = "";
				else
					valore = "";
				break;
			case Descrizione:
				if (c != null)
					if (c.getDescrizione() != null)
						valore = c.getDescrizione();
					else
						valore = "";
				else
					valore = "";
				break;
			case Partizione:
				if (o.getNumeroOrdine() == null)
					valore = "";
				else
					valore = o.getNumeroOrdine().toString();
				break;
			}
		}

		return valore;
	}

	public String getColumnName(int c) {
		return this.colonne[c];
	}
}

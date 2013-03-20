package provaTabelle;

import java.sql.Date;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Locale;

import javax.swing.table.AbstractTableModel;

import org.hibernate.type.CalendarDateType;
import org.jdesktop.swingx.JXDatePicker;
import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import elaboradistinta.controller.GestisciClienteHandler;
import elaboradistinta.model.Cliente;
import elaboradistinta.model.Commessa;
import elaboradistinta.model.Ordine;

public class GDatiSviluppoConsegnaModel extends AbstractTableModel {

	private String[] colonne;
	private ArrayList<Commessa> commesse = new ArrayList<Commessa>();
	private ArrayList<Ordine> ordini = new ArrayList<Ordine>();
	private ArrayList<Cliente> clienti = new ArrayList<Cliente>();

	private static final int Responsabile = 0;
	private static final int DataI = 1;
	private static final int Scadenza = 2;
	private static final int DataF = 3;
	private static final int Ritardo = 4;

	public GDatiSviluppoConsegnaModel() {
		this.colonne = new String[] { "Responsabile", "Emissione Commessa","Scadenza Commessa", "Data fine", "Ritardo" };
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
	
	@Override
	public int getColumnCount() {
		return this.colonne.length;
	}

	@Override
	public int getRowCount() {
		return this.commesse.size();
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return true;
	}

	@Override
	public Object getValueAt(int riga, int colonna) {
		String valore = null;
		Commessa c = this.commesse.get(riga);
		switch (colonna) {
		case Responsabile:
			if (c.getResponsabile() == null)
				valore = "";
			else
				valore = c.getResponsabile();
			break;
		case DataI:
			if (c.getEmissioneCommessa() == null)
				valore = "";
			else
				valore = c.getEmissioneCommessa().toString();
			break;
		case Scadenza:
			if (c.getScadenzaCommessa() == null)
				valore = "";
			else
				valore = c.getScadenzaCommessa().toString();
			break;
		case DataF:
			if (c.getFineCommessa() == null)
				valore = "";
			else
				valore = c.getFineCommessa().toString();
			break;
		case Ritardo:
			if (c.getRitardoConsegna() == null)
				valore = "";
			else
				valore = c.getRitardoConsegna().toString();
			break;
		}
		return valore;
	}

	public String getColumnName(int c) {
		return this.colonne[c];
	}

	public void cambiaValore(int cid, int c, Object value) throws PersistentException {
		PersistentTransaction t = elaboradistinta.model.CoedilPersistentManager.instance().getSession().beginTransaction();
		Commessa commessa = elaboradistinta.model.CommessaFactory
				.getCommessaByORMID(cid);
		switch (c) {
		case Responsabile:
			commessa.setResponsabile(value.toString());
			commessa.save();
			break;
		case DataI:
			commessa.setEmissioneCommessa(this.convertiData(value.toString()));
			commessa.save();
			break;
		case Scadenza:
			commessa.setScadenzaCommessa(this.convertiData(value.toString()));
			commessa.save();
			break;
		case DataF:
			commessa.setFineCommessa(this.convertiData(value.toString()));
			commessa.save();
			break;
		case Ritardo:
			commessa.setRitardoConsegna(Integer.valueOf(value.toString()));
			commessa.save();
			break;
		}

		t.commit();
	}

	@Override
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}

	@Override
	public void setValueAt(Object value, int rowIndex, int columnIndex) {
		Commessa c = this.commesse.get(rowIndex);
		try {
			if(value != null )
				if(!value.equals("")) 
					this.cambiaValore(c.getID(), columnIndex, value.toString());
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}

}

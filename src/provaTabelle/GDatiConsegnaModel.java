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

public class GDatiConsegnaModel extends AbstractTableModel {

	private String[] colonne;
	private ArrayList<Commessa> commesse = new ArrayList<Commessa>();
	private ArrayList<Ordine> ordini = new ArrayList<Ordine>();
	private ArrayList<Cliente> clienti = new ArrayList<Cliente>();

	private static final int Consegna = 0;
	private static final int Ritardo = 1;

	public GDatiConsegnaModel() {
		this.colonne = new String[] {"Data prima consegna",	"Ritardo consegna" };
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
		case Consegna:
			if (c.getPrimaConsegna() == null)
				valore = "";
			else
				valore = c.getPrimaConsegna().toString();
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

	public void cambiaValore(int cid, int c, Object value)
			throws PersistentException {
		PersistentTransaction t = elaboradistinta.model.CoedilPersistentManager
				.instance().getSession().beginTransaction();
		Commessa commessa = elaboradistinta.model.CommessaFactory
				.getCommessaByORMID(cid);
		switch (c) {
		case Consegna:
			commessa.setPrimaConsegna(this.convertiData(value.toString()));
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

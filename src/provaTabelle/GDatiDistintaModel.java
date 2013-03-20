package provaTabelle;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import elaboradistinta.controller.GestisciCommessaHandler;
import elaboradistinta.model.Commessa;
import elaboradistinta.model.Distinta;
import elaboradistinta.model.Geometria;
import elaboradistinta.model.GeometriaFactory;
import elaboradistinta.model.RigaLavoro;

public class GDatiDistintaModel extends AbstractTableModel {

	private ArrayList<RigaLavoro> righe = new ArrayList<RigaLavoro>();
	private String[] colonne;

	private ArrayList<Object> modifiche = new ArrayList<Object>();

	private static final int Base = 0;
	private static final int Altezza = 1;
	private static final int Lunghezza = 2;
	private static final int Numero = 3;
	private static final int Capitello = 4;
	private static final int Tipo = 5;
	private static final int Note = 6;
	
	public GDatiDistintaModel(Distinta d){
		this.colonne = new String[]{"Base", "Altezza", "Lunghezza", "Numero", "Capitello", "TipoCap", "Note"};
		GestisciCommessaHandler gch = GestisciCommessaHandler.getInstance();
		//if(gch.getCommessaByCodiceInterno(codice).getDistinta() != null){
			//Distinta d = gch.getCommessaByCodiceInterno(codice).getDistinta();
		this.righe = new ArrayList<RigaLavoro>(d.getLavori().righe.getCollection());
			//}
	}
	@Override
	public String getColumnName(int c) {
		return this.colonne[c];
	}

	@Override
	public boolean isCellEditable(int riga, int colonna) {
		if(this.righe.get(riga).getCapitello() == false && colonna == 5)
			return false;
		return true;
	}
	
	@Override
	public Class getColumnClass(int c) {
		if(getValueAt(0,c) == null)
			return String.class;
		else
			return getValueAt(0, c).getClass();
	}

	@Override
	public void setValueAt(Object value, int riga, int colonna) {
		try {
			this.cambiaValore(riga, colonna, value);
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}
	
	public void cambiaValore(int riga, int colonna, Object value) throws PersistentException {
		PersistentTransaction t = elaboradistinta.model.CoedilPersistentManager.instance().getSession().beginTransaction();
		RigaLavoro r = this.righe.get(riga);
		Geometria g = GeometriaFactory.getGeometriaByORMID(r.getGeometria().getID());
		switch(colonna){
		case Base:
			g.setBase(Float.parseFloat(value.toString()));
			this.addModifica(g);
			//g.save();
			break;
		case Altezza:
			g.setAltezza(Float.parseFloat(value.toString()));
			this.addModifica(g);
			//g.save();
			break;
		case Lunghezza:
			g.setLunghezza(Float.parseFloat(value.toString()));
			this.addModifica(g);
			//g.save();
			break;
		case Numero:
			r.setNumero(Integer.parseInt(value.toString()));
			this.addModifica(r);
			//r.save();
			break;
		case Capitello:
			if(value.toString() == "Si")
				r.setCapitello(true);
			else{
				r.setCapitello(false);
				r.setProfiloCapitello("");
				super.fireTableDataChanged();
			}
			this.addModifica(r);
			//r.save();
			break;
		case Tipo:
			r.setProfiloCapitello(value.toString());
			this.addModifica(r);
			//r.save();
			break;
		case Note:
			r.setNote(value.toString());
			this.addModifica(r);
			//r.save();
			break;			
		}
	}
	@Override
	public int getColumnCount() {
		return this.colonne.length;
	}

	@Override
	public int getRowCount() {
		return this.righe.size();
	}

	@Override
	public Object getValueAt(int riga, int colonna) {
		String valore = "";
		RigaLavoro r = this.righe.get(riga);
		Geometria g = GeometriaFactory.getGeometriaByORMID(r.getGeometria().getID());
		switch(colonna){
		case Base:
			if(String.valueOf(g.getBase()) != "")
				valore = String.valueOf(g.getBase());
			break;
		case Altezza:
			if(String.valueOf(g.getAltezza()) != "")
				valore = String.valueOf(g.getAltezza());
			break;
		case Lunghezza:
			if(String.valueOf(g.getLunghezza()) != "")
				valore = String.valueOf(g.getLunghezza());
			break;
		case Numero:
			if(String.valueOf(r.getNumero()) != "")
				valore = String.valueOf(r.getNumero());
			break;
		case Capitello:
			if(String.valueOf(r.getCapitello()) != "")
				if(r.getCapitello())
					valore = "Si";
				else
					valore = "No";
			break;
		case Tipo:
			if(r.getProfiloCapitello() != "")
				valore = r.getProfiloCapitello();
			break;
		case Note:
			if(r.getNote() != "")
				valore = r.getNote();
			break;			
		}
		return valore;
	}
	
	public ArrayList<Object> getModifiche() {
		return modifiche;
	}
	public void setModifiche(ArrayList<Object> modifiche) {
		this.modifiche = modifiche;
	}
	
	public void addModifica(Object o){
		if(!this.modifiche.contains(o))
			this.modifiche.add(o);		
	}


}

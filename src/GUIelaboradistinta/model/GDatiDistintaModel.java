package GUIelaboradistinta.model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import elaboradistinta.controller.GestisciCommessaHandler;
import elaboradistinta.model.Coedil99ingdelsoftwarePersistentManager;
import elaboradistinta.model.Commessa;
import elaboradistinta.model.Distinta;
import elaboradistinta.model.Geometria;
import elaboradistinta.model.GeometriaFactory;
import elaboradistinta.model.RigaLavoro;

public class GDatiDistintaModel extends AbstractTableModel implements ActionListener{

	private ArrayList<RigaLavoro> righe = new ArrayList<RigaLavoro>();
	private ArrayList<ArrayList<Object>> dati = new ArrayList<ArrayList<Object>>();
	private String[] colonne = new String[]{"Base", "Altezza", "Lunghezza", "Numero",
			"Capitello", "TipoCap", "Note",""};

	private ArrayList<ArrayList<Object>> modifiche = new ArrayList<ArrayList<Object>>();
	private Distinta distinta;
	private static final int Base = 0;
	private static final int Altezza = 1;
	private static final int Lunghezza = 2;
	private static final int Numero = 3;
	private static final int Capitello = 4;
	private static final int Tipo = 5;
	private static final int Note = 6;
	
	public GDatiDistintaModel(Distinta d){
		this.distinta = d;
		//GestisciCommessaHandler gch = GestisciCommessaHandler.getInstance();
		this.righe = new ArrayList<RigaLavoro>(distinta.getLavori().righe.getCollection());
		for(int i=0; i<this.righe.size(); ++i){
			ArrayList<Object> row = new ArrayList<Object>();
			JButton cancel = new JButton("X");
			row.add(this.righe.get(i));
			row.add(cancel);
			cancel.setOpaque(false);
			cancel.setContentAreaFilled(false);
			cancel.setBorderPainted(false);
			cancel.addActionListener(this);
			cancel.setName(String.valueOf(this.righe.get(i).getID()));
			this.dati.add(row);
		}
		this.modifiche.add(0, new ArrayList<Object>());
		this.modifiche.add(1, new ArrayList<Object>());
	}
	
	public void addNewRow(RigaLavoro r){
		JButton cancel = new JButton("X");
		cancel.setFocusPainted(false);
		cancel.setBorderPainted(false);
		ArrayList<Object> row = new ArrayList<Object>();
		row.add(r);
		row.add(cancel);
		cancel.setOpaque(false);
		cancel.setContentAreaFilled(false);
		cancel.setBorderPainted(false);
		cancel.addActionListener(this);
		cancel.setName(String.valueOf(r.getID()));
		this.dati.add(row);
		//fireTableStructureChanged();
		this.fireTableRowsInserted(0, this.getRowCount());
	}
	
	@Override
	public String getColumnName(int c) {
		return this.colonne[c];
	}

	@Override
	public boolean isCellEditable(int riga, int colonna) {
		if( ((RigaLavoro) this.dati.get(riga).get(0)).getCapitello() == false && colonna == 5)
			return false;
		//if(colonna == 7)
		//	return false;
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
		PersistentTransaction t = Coedil99ingdelsoftwarePersistentManager.instance().getSession().beginTransaction();
		RigaLavoro r = (RigaLavoro) this.dati.get(riga).get(0);
		Geometria g = GeometriaFactory.getGeometriaByORMID(r.getGeometria().getID());
		switch(colonna){
		case Base:
			g.setBase(Float.parseFloat(value.toString()));
			this.addModifica(g);
			break;
		case Altezza:
			g.setAltezza(Float.parseFloat(value.toString()));
			this.addModifica(g);
			break;
		case Lunghezza:
			g.setLunghezza(Float.parseFloat(value.toString()));
			this.addModifica(g);
			break;
		case Numero:
			r.setNumero(Integer.parseInt(value.toString()));
			this.addModifica(r);
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
			break;
		case Tipo:
			r.setProfiloCapitello(value.toString());
			this.addModifica(r);
			break;
		case Note:
			r.setNote(value.toString());
			this.addModifica(r);
			break;			
		}
	}
	@Override
	public int getColumnCount() {
		return this.colonne.length;
	}

	@Override
	public int getRowCount() {
		return this.dati.size();
	}

	@Override
	public Object getValueAt(int riga, int colonna) {
		if(colonna != 7){
			String valore = "";
			RigaLavoro r = (RigaLavoro) this.dati.get(riga).get(0);
			switch(colonna){
			case Base:
				if(String.valueOf(r.getGeometria().getBase()) != "")
					valore = String.valueOf(r.getGeometria().getBase());
				break;
			case Altezza:
				if(String.valueOf(r.getGeometria().getAltezza()) != "")
					valore = String.valueOf(r.getGeometria().getAltezza());
				break;
			case Lunghezza:
				if(String.valueOf(r.getGeometria().getLunghezza()) != "")
					valore = String.valueOf(r.getGeometria().getLunghezza());
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
		else{
			return this.dati.get(riga).get(1);
		}
		
	}
	
	public ArrayList<ArrayList<Object>> getModifiche() {
		return modifiche;
	}
	public void setModifiche(ArrayList<ArrayList<Object>> modifiche) {
		this.modifiche = modifiche;
	}
	
	public void addModifica(Object o){
		if(this.modifiche.get(0).size() != 0 || this.modifiche.get(0).contains(o))
			this.modifiche.get(0).remove(o);
		this.modifiche.get(0).add(o);
	}
	
	public void addRimozione(Object o){
		this.modifiche.get(1).add(o);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		int row = getRowForButton(e.getSource());
		if(row == - 1) {
			throw new RuntimeException("Errore riga mancante");
		}
		int n = JOptionPane.showConfirmDialog(null,"Sicuro di voler cancellare la riga lavoro?"
				,"Attenzione",JOptionPane.YES_NO_OPTION);
		if(n == 0){
			this.addRimozione(this.dati.get(row).get(0));
			this.dati.remove(row);
			fireTableStructureChanged();
		}
	}

	private int getRowForButton(Object o) {
		int id = Integer.valueOf(((JButton) o).getName());
		for(int i=0; i<this.dati.size(); ++i){
			RigaLavoro r = (RigaLavoro) this.dati.get(i).get(0);
			if(r.getID() == id){
				return i;
			}
		}
		return -1;
	}
	
	public void refresh(){
		this.dati = new ArrayList<ArrayList<Object>>();
		
		this.righe = new ArrayList<RigaLavoro>(distinta.getLavori().righe.getCollection());
		for(int i=0; i<this.righe.size(); ++i){
			ArrayList<Object> row = new ArrayList<Object>();
			JButton cancel = new JButton("X");
			row.add(this.righe.get(i));
			row.add(cancel);
			cancel.setOpaque(false);
			cancel.setContentAreaFilled(false);
			cancel.setBorderPainted(false);
			cancel.addActionListener(this);
			cancel.setName(String.valueOf(this.righe.get(i).getID()));
			this.dati.add(row);
		}
		this.modifiche.add(0, new ArrayList<Object>());
		this.modifiche.add(1, new ArrayList<Object>());
		this.fireTableStructureChanged();
	}
}

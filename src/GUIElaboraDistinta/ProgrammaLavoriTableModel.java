package GUIElaboraDistinta;

import java.util.Calendar;
import java.util.Collection;
import java.util.Vector;

import javax.swing.event.TableModelEvent;
import javax.swing.table.AbstractTableModel;
import ElaboraDistinta.Commessa;


@SuppressWarnings("serial")
public class ProgrammaLavoriTableModel extends AbstractTableModel{
	
	 Vector<Vector<String>> commesse;
	 Vector<String> intestazioni;
	     
	 public ProgrammaLavoriTableModel(){
		 this.commesse = new Vector<Vector<String>>();
	     this.intestazioni = new Vector<String>();
	     String[] a = {"Id", "Elemento Strutturale", "Emissione", "Scadenza", "Orario", "Descrizione", "Responsabile", "Ritardo"};
	     for(int i=0; i<a.length; ++i)
	    	 this.intestazioni.add(a[i]);
	 }


	/*
	 * Metodo che ritorna il numero delle intestazioni
	 * @see javax.swing.table.TableModel#getColumnCount()
	 */
	@Override
	public int getColumnCount(){
		return this.intestazioni.size();
	}

	/*
	 * Metodo che ritorna il numero delle righe della tabella
	 * @see javax.swing.table.TableModel#getRowCount()
	 */
	@Override
	public int getRowCount() {
		return this.commesse.size();
	}

	
	/*
	 * Metodo che ritorna il nome dell'intestazione
	 * @see javax.swing.table.AbstractTableModel#getColumnName(int)
	 * @param int col: ritorna il nome dell'intestazione
	 */
	public String getColumnName(int col) {
		   if(col >= this.intestazioni.size()) 
			   return null;
		   return this.intestazioni.elementAt(col);
		 }
	
	/*
	 * Metodo che ritorna un valore di una determinata cella
	 * @see javax.swing.table.TableModel#getValueAt(int, int)
	 * @param int rowIndex: intero che indica la riga
	 * @param int columnIndex: intero che indica la colonna
	 */
	@Override
	public String getValueAt(int rowIndex, int columnIndex) {
		Vector<String> row = this.commesse.elementAt(rowIndex);
		return row.elementAt(columnIndex);	
	}

			 
	/*
	 * Metodo che setta il valore di una cella
	 * @param String value: Valore da settare
	 * @param int row: riga
	 * @param int col: colonna		 
	 */
	public void setValueAt(String value, int row, int col) {
		Vector<String> v = this.commesse.elementAt(row);
		v.setElementAt(value, col);
		fireTableCellUpdated(row,col);   
	}
		 
	public void addRow(Vector<String> row) {
		insertRow(row, getRowCount());
	}
		 
	public void addColumn(String col){
		this.intestazioni.add(col);
	}
		 
	public void insertRow(Vector<String> row, int r) {
		this.commesse.insertElementAt(row,r);
		fireTableRowsInserted(r, r);
	}
		 
	public void removeRow(int row) {
		this.commesse.removeElementAt(row);
		fireTableRowsDeleted(row, row);
	}
		 
	public void rowsRemoved(TableModelEvent event) {
		   fireTableChanged(event);
	}
		 
	public void newRowsAdded(TableModelEvent e) {
		   fireTableChanged(e);
	}
	
	public void addCommessa(Commessa c){
		Vector<String> a = new Vector<String>();
		a.add("1");
		a.add(c.getElementoStrutturale());
		a.add(c.getScadenza().toString());
		a.add(c.getEmissioneCommessa().toString());
		a.add(c.getOrario());
		a.add(c.getDescrizione());
		a.add(c.getResponsabile());
		a.add("0");
		this.insertRow(a,0);
	}


}

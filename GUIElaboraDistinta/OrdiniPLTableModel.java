package GUIElaboraDistinta;
import ElaboraDistinta.Ordine;
import javax.swing.table.AbstractTableModel;

import java.util.Calendar;
import java.util.Vector;

public class OrdiniPLTableModel extends AbstractTableModel{

	    Vector<Ordine> ordini;
	    String[] intestazioni;

	    public OrdiniPLTableModel()
	    {
	        ordini = new Vector<Ordine>();
	        intestazioni = new String[]{"Nome", "Cantiere", "Commessa"};
	    }

	    // numero di righe
	    public int getRowCount()
	    {
	        return this.ordini.size();
	    }

	    // numero di colonne
	    public int getColumnCount()
	    {
	        return intestazioni.length;
	    }

	    // nome di una determinata colonna
	    @Override
	    public String getColumnName(int columnIndex)
	    {
	        return intestazioni[columnIndex];
	    }

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			Ordine row = ordini.elementAt(rowIndex);
				if(columnIndex == 0){
					return row.getOrdineGestionale();
				}
			
			    else if(columnIndex == 1){
			        return row.getDataInizio().get(Calendar.DATE)+"/"+row.getDataInizio().get(Calendar.MONTH)+"/"+row.getDataInizio().get(Calendar.YEAR);	
			    }
			
			        else if(columnIndex == 2){
			        	return row.getDataFine().get(Calendar.DATE)+"/"+row.getDataFine().get(Calendar.MONTH)+"/"+row.getDataFine().get(Calendar.YEAR);
			        }
			        else
			        	return null;
		}
		
		 public void addOrdine(Ordine o){
			 this.ordini.add(o);
		 }

    

}

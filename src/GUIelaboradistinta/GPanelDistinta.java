package GUIelaboradistinta;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import elaboradistinta.StartUp;
import elaboradistinta.controller.GestisciCommessaHandler;
import elaboradistinta.model.Distinta;
import elaboradistinta.model.Geometria;
import elaboradistinta.model.RigaLavoro;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

public class GPanelDistinta extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean DEBUG = false;
	Vector<Vector<String>> data;
	JTable table;
	JScrollPane scrollPane;


	public GPanelDistinta(Vector<String> columnNames , int index ) {
		super(new GridLayout(1, 0));

		final StartUp s = StartUp.getInstance();
		GestisciCommessaHandler gch = GestisciCommessaHandler.getInstance();
		data = new Vector<Vector<String>>();		
		if ( gch.hasDistinta( gch.getCommessaByIndex( index ).getCodiceInterno() )   ){
		Distinta d = gch.getCommessaByIndex( index ).getDistinta();

		for (int i=0; i<s.gch.getCommessaByIndex( index ).getDistinta().getLavori().righe.size(); i++){
			Vector<String> row = new Vector<String>();
	
			row.add( "" + s.gch.getCommessaByIndex( index ).getDistinta().getLavori().righe.get(i).getGeometria().getBase());
			row.add( "" + s.gch.getCommessaByIndex( index ).getDistinta().getLavori().righe.get(i).getGeometria().getAltezza());
			row.add( "" + s.gch.getCommessaByIndex( index ).getDistinta().getLavori().righe.get(i).getGeometria().getLunghezza() );
			row.add( "" + s.gch.getCommessaByIndex( index ).getDistinta().getLavori().righe.get(i).getNumero());			
			row.add( "" + s.gch.getCommessaByIndex( index ).getDistinta().getLavori().righe.get(i).getCapitello() );
			row.add( "" + s.gch.getCommessaByIndex( index ).getDistinta().getLavori().righe.get(i).getProfiloCapitello());			
			row.add( "" + s.gch.getCommessaByIndex( index ).getDistinta().getLavori().righe.get(i).getNote());
			data.add(row);
		}
		}
		
		table = new JTable(data, columnNames);
		table.setPreferredScrollableViewportSize(new Dimension(500, 70));
		table.setFillsViewportHeight(true);


		
		if (DEBUG) {
			table.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					printDebugData(table);
				}
			});
		}

		// Create the scroll pane and add the table to it.
		scrollPane = new JScrollPane(table);

		// Add the scroll pane to this panel.
		add(scrollPane);
		
	}

public JTable getTable(){
	return this.table;
}

public JScrollPane getScroll(){
	return this.scrollPane;
}

public GPanelDistinta addRow(GPanelDistinta t){
	Vector<String> row = new Vector<String>();
	row.add("");
	row.add("");
	row.add("");
	row.add("");
	row.add("");
	row.add("");
	row.add("");
	data.add(row);
	return t;
}

public RigaLavoro getRow(int numRiga ){
	
	Geometria g = new Geometria(    getTable().getModel().getValueAt( numRiga , 0 ) , 	
									getTable().getModel().getValueAt( numRiga , 1 ) , 
									getTable().getModel().getValueAt( numRiga , 2 ) ) ;
	
	RigaLavoro row = new RigaLavoro(1 , g ,	false,"","",1);

	return row;
}

	private void printDebugData(JTable table) {
		int numRows = table.getRowCount();
		int numCols = table.getColumnCount();
		javax.swing.table.TableModel model = table.getModel();

		System.out.println("Value of data: ");
		for (int i = 0; i < numRows; i++) {
			System.out.print("    row " + i + ":");
			for (int j = 0; j < numCols; j++) {
				System.out.print("  " + model.getValueAt(i, j));
			}
			System.out.println();
		}
		System.out.println("--------------------------");
	}

}

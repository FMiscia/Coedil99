package GUIElaboraDistinta;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import ElaboraDistinta.StartUp;
import ElaboraDistinta.Controller.GestisciCommessaHandler;
import ElaboraDistinta.Model.Distinta;
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


	public GPanelDistinta(Vector<String> columnNames) {
		super(new GridLayout(1, 0));

		final StartUp s = StartUp.getInstance();

		
		GestisciCommessaHandler gch = GestisciCommessaHandler.getInstance();
		Distinta d = gch.getCommessaById(1).getDistinta();
		

		data = new Vector<Vector<String>>();
		for (int i=0; i<s.gch.getCommessaById(1).getDistinta().getRigheLavoro().size(); i++){
			Vector<String> row = new Vector<String>();
			row.add("");
			row.add("");
			row.add("");
			row.add("");			
			row.add("");
			row.add("");			
			row.add("");

			data.add(row);
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

package GUIElaboraDistinta;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

import ElaboraDistinta.StartUp;
import ElaboraDistinta.Controller.GestisciCommessaHandler;
import ElaboraDistinta.Model.Distinta;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;


public class Table extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean DEBUG = false;
	Vector<Vector<String>> data;
	JTable table;
	JScrollPane scrollPane;
	Vector<Vector<String>> data6;

	public Table(Vector<String> columnNames, int a) {
		super(new GridLayout(1, 0));

		StartUp s = StartUp.getInstance();

		

		
		GestisciCommessaHandler gch = GestisciCommessaHandler.getInstance();
		Distinta d = gch.getCommessaById(1).getDistinta();
		

		data6 = new Vector<Vector<String>>();
		for(int i=0; i<d.getRigheLavoro().size(); ++i){
			Vector<String> row = new Vector<String>();
			row.add("1");
			row.add("2");
			row.add("3");
			row.add("4");
			row.add("5");
			row.add("6");
			row.add("7");
			data6.add(row);
		}
		
		Vector<Vector<String>> data0;
		data0 = new Vector<Vector<String>>();
		for (int i=0; i<s.gch.getNumOfCommesse(); i++){
			Vector<String> row = new Vector<String>();
			row.add(s.gch.getCommessaByIndex(i).getCodiceInterno());
			row.add("");
			data0.add(row);
		}
		
		Vector<Vector<String>> data1;
		data1 = new Vector<Vector<String>>();
		for (int i=0; i<s.gch.getNumOfCommesse(); i++){
			Vector<String> row = new Vector<String>();
			row.add("");
			row.add("");
			row.add(  ""+s.gch.getCommessaByIndex(i).getId());
			data1.add(row);
		}

		
		Vector<Vector<String>> data2; 
		data2 = new Vector<Vector<String>>();
		for (int i=0; i<s.gch.getNumOfCommesse(); i++){
			Vector<String> row = new Vector<String>();
			row.add("");
			row.add("");
			row.add("");
			row.add(  ""+s.gch.getCommessaByIndex(i).getId());
			row.add("");
			row.add("");
			row.add(s.o.getDataInizio().getTime().toString());
			row.add("");
			row.add("");
			row.add("");
			row.add("");
			data2.add(row);
		}

		Vector<Vector<String>> data3; 
		data3 = new Vector<Vector<String>>();
		for (int i=0; i<s.gch.getNumOfCommesse(); i++){
			Vector<String> row = new Vector<String>();
			row.add("");
			row.add("");
			row.add("");
			row.add("");
			row.add("");
			data3.add(row);
		}
		
		Vector<Vector<String>> data4; 
		data4 = new Vector<Vector<String>>();
		for (int i=0; i<s.gch.getNumOfCommesse(); i++){
			Vector<String> row = new Vector<String>();
			row.add("");
			row.add("");
			row.add("");
			data4.add(row);
		}
		
		Vector<Vector<String>> data5; 
		data5 = new Vector<Vector<String>>();
		for (int i=0; i<s.gch.getNumOfCommesse(); i++){
			Vector<String> row = new Vector<String>();
			row.add("");
			row.add("");
			data5.add(row);
		}
		
		switch (a) {
		case 0:
			data = data0;
			break;
		case 1:
			data = data1;
			break;
		case 2:
			data = data2;
			break;
		case 3:
			data = data3;
			break;
		case 4:
			data = data4;
			break;
		case 5:
			data = data5;
			break;
		case 6:
			data = data6;
			break;
		default:
			break;
		}


		table = new JTable(data, columnNames);
		table.setPreferredScrollableViewportSize(new Dimension(500, 70));
		table.setFillsViewportHeight(true);
if (a == 0){
    TableColumn column = table.getColumnModel().getColumn(1);
    column.setMinWidth(0);
    column.setMaxWidth(0);
    column.setWidth(0);
    column.setPreferredWidth(0);
    doLayout();
}
		
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

public Table addRow(Table t){
	Vector<String> row = new Vector<String>();
	row.add("1");
	row.add("2");
	row.add("3");
	row.add("4");
	row.add("5");
	row.add("6");
	row.add("7");
	t.data6.add(row);
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

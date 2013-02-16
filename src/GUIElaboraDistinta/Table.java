package GUIElaboraDistinta;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableColumn;

import ElaboraDistinta.GestisciCommessaHandler;
import ElaboraDistinta.StartUp;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Vector;

public class Table extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean DEBUG = false;
	Object[][] data;

	public Table(String[] columnNames, int a) {
		super(new GridLayout(1, 0));

		StartUp s = StartUp.getInstance();
		
		Object[][] data1;
		data1 = new Object [s.gch.getNumOfCommesse()][];
		
		for (int i=0; i<s.gch.getNumOfCommesse(); i++){
			data1[i] = new Object[4];
			Object[] row = {s.gch.getCommessaByIndex(i).getOrdine().getAnno()+"_"+
					s.gch.getCommessaByIndex(i).getOrdine().getId()+"_"+
					s.gch.getCommessaByIndex(i).getId(), null, null, s.gch.getCommessaByIndex(i).getId()};
			data1[i] = row;
		}

		
		Object[][] data2; 
		data2 = new Object [s.gch.getNumOfCommesse()][];
		for (int i=0; i<s.gch.getNumOfCommesse(); i++){
			data2[i] = new Object[12];
			Object[] row = {
					s.gch.getCommessaByIndex(i).getOrdine().getAnno()+"_"+
					s.gch.getCommessaByIndex(i).getOrdine().getId()+"_"+
					s.gch.getCommessaByIndex(i).getId(), 
					null, null,null, s.gch.getCommessaByIndex(i).getId(),null,null,s.o.getDataInizio().getTime().toGMTString(),s.o.getDataFine().getTime().toGMTString(),null,null,null};
			data2[i] = row;
		}

		Object[][] data3; 
		data3 = new Object [s.gch.getNumOfCommesse()][];
		for (int i=0; i<s.gch.getNumOfCommesse(); i++){
			data3[i] = new Object[6];
			Object[] row = {s.gch.getCommessaByIndex(i).getOrdine().getAnno()+"_"+
					s.gch.getCommessaByIndex(i).getOrdine().getId()+"_"+
					s.gch.getCommessaByIndex(i).getId(),null,null,null,null,null};
			data3[i] = row;
		}
		
		Object[][] data4; 
		data4 = new Object [s.gch.getNumOfCommesse()][];
		for (int i=0; i<s.gch.getNumOfCommesse(); i++){
			data4[i] = new Object[4];
			Object[] row = {s.gch.getCommessaByIndex(i).getOrdine().getAnno()+"_"+
					s.gch.getCommessaByIndex(i).getOrdine().getId()+"_"+
					s.gch.getCommessaByIndex(i).getId(),null,null,null};
			data4[i] = row;
		}
		
		Object[][] data5; 
		data5 = new Object [s.gch.getNumOfCommesse()][];
		for (int i=0; i<s.gch.getNumOfCommesse(); i++){
			data5[i] = new Object[3];
			Object[] row = {s.gch.getCommessaByIndex(i).getOrdine().getAnno()+"_"+
					s.gch.getCommessaByIndex(i).getOrdine().getId()+"_"+
					s.gch.getCommessaByIndex(i).getId(),null,null};
			data5[i] = row;
		}
		
		switch (a) {
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
		default:
			break;
		}


		final JTable table = new JTable(data, columnNames);
		table.setPreferredScrollableViewportSize(new Dimension(500, 70));
		table.setFillsViewportHeight(true);
		TableColumn column = null;
		for (int i = 0; i < table.getColumnModel().getColumnCount(); i++) {
			column = table.getColumnModel().getColumn(i);
			if (i == 0) {
				column.setMaxWidth(100); // third column is bigger
				column.setMinWidth(100);
			} else {
				column.setWidth(50);
			}
		}


		if (DEBUG) {
			table.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					printDebugData(table);
				}
			});
		}

		// Create the scroll pane and add the table to it.
		JScrollPane scrollPane = new JScrollPane(table);

		// Add the scroll pane to this panel.
		add(scrollPane);
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

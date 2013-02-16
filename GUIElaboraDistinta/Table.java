package GUIElaboraDistinta;

/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

/*
 * SimpleTableDemo.java requires no other files.
 */

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
	private StartUp s;

	public Table(String[] columnNames, int a) {
		super(new GridLayout(1, 0));

		s = new StartUp();
		
		Object[][] data1;
		data1 = new Object [s.gch.getNumOfCommesse()][];
		
		for (int i=0; i<s.gch.getNumOfCommesse(); i++){
			data1[i] = new Object[4];
			Object[] row = {"si", "Si", "si", ( s.gch.getCommessaByIndex(i)).getId()};
			data1[i] = row;
		}
//		
//		Object[][] data1 ={
//				 {"01", "Smith", "a", s.gch.getCommessaById(1).getId(),"r"},
//				 {"02", "Smith", "a", "e","r"},
//				 {"03", "Smith", "a", "e","r"},
//				 {"04", "Smith", "a", "e","r"},
//				 {"05", "Smith", "a", "e","r"}
//				 };
//		
		Object[][] data2 = {
				 {"01", "Smith", "a", new		 Integer(5),"q0","w","e",s.o.getDataInizio().getTime().toGMTString(),s.o.getDataFine().getTime().toGMTString(),"s","s","s"},
				 {"02", "Smith", "a", new
				 Integer(5),"q1","w","e","r","t","s","s","s"},
				 {"03", "Smith", "a", new
				 Integer(5),"q2","w","e","r","t","s","s","s"},
				 {"04", "Smith", "a", new
				 Integer(5),"q3","w","e","r","t","s","s","s"},
				 {"05", "Smith", "a", new Integer(5),"q4","w","e","r","t","s","s","s"}
				 };
		Object[][] data3 = {
				 {"01", "Smith", "a", new Integer(5),"q0","w","e","r","t"},
				 {"02", "Smith", "a", new Integer(5),"q1","w","e","r","t"},
				 {"03", "Smith", "a", new Integer(5),"q2","w","e","r","t"},
				 {"04", "Smith", "a", new Integer(5),"q3","w","e","r","t"},
				 {"05", "Smith", "a", new Integer(5),"q4","w","e","r","t"}
				 };
		Object[][] data4 =  {
				 {"01", "Smith", "a", new Integer(5),"q0","w","e","r","t"},
				 {"02", "Smith", "a", new Integer(5),"q1","w","e","r","t"},
				 {"03", "Smith", "a", new Integer(5),"q2","w","e","r","t"},
				 {"04", "Smith", "a", new Integer(5),"q3","w","e","r","t"},
				 {"05", "Smith", "a", new Integer(5),"q4","w","e","r","t"}
				 };
		Object[][] data5 = {
				 {"01", "Smith", "a", new Integer(5),"q0","w","e","r","t"},
				 {"02", "Smith", "a", new Integer(5),"q1","w","e","r","t"},
				 {"03", "Smith", "a", new Integer(5),"q2","w","e","r","t"},
				 {"04", "Smith", "a", new Integer(5),"q3","w","e","r","t"},
				 {"05", "Smith", "a", new Integer(5),"q4","w","e","r","t"}
				 };


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

//		Object[][] d = new Object[1][] ;
//		d[0] = new Object[4];
//		for (int i = 0; i < 1; i++) {
//			for (int t = 0; t < 4; t++)
//
//			d[0][0] = data.get(0)[0];
//			d[0][1] = data.get(0)[1];
//			d[0][2] = data.get(0)[2];
//			d[0][3] = data.get(0)[3];
//		}

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

		// get the selection model
		ListSelectionModel tableSelectionModel = table.getSelectionModel();

		// set a selection interval (in this case the first row)
		tableSelectionModel.setSelectionInterval(0, 0);

		// update the selection model
		table.setSelectionModel(tableSelectionModel);

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

//	private ArrayList<Object[]> getDati5() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	private ArrayList<Object[]> getDati4() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	private ArrayList<Object[]> getDati3() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	private ArrayList<Object[]> getDati2() {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	public ArrayList<Object[]> getDati1() {
//
//		ArrayList<Object[]> data1 = new ArrayList<Object[]>();
//		for (int i = 0; i < 1; i++) {
//			Object[] row = { "codint", "cliente", "cantiere",
//					s.gch.getCommessaById(1).getId() };
//			data1.add(row);
//			JOptionPane.showMessageDialog(null, row[3].toString());
//		}
//
//		return data1;
//
//	}

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
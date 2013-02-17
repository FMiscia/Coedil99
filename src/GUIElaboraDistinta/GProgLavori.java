package GUIElaboraDistinta;

import java.awt.AWTEvent;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.table.TableModel;

import ElaboraDistinta.Ordine;
import ElaboraDistinta.StartUp;

import java.awt.FlowLayout;

public class GProgLavori extends JPanel {

	private static final long serialVersionUID = 1L;
	private static JComponent panel1;
	private static JComponent panel2;
	private static JComponent panel3;
	private static JComponent panel4;
	private static JComponent panel5;
	private static Integer selectedRow = 0;
	private static JTabbedPane tabbedPane;
	private static JButton b;
	private static JComponent listbox;

	public GProgLavori() {
		super(new BorderLayout());
		final StartUp s = StartUp.getInstance();
		tabbedPane = new JTabbedPane();

		panel1 = makeTextPanel(1);
		(((Table) GProgLavori.panel1).getTable())
				.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						JTable t =  (JTable) evt.getSource();
						if (evt.getClickCount() == 1 && t.getSelectedRow() >= 0) {
							int index = t.getSelectedRow();
							GProgLavori.selectedRow = index;
							(((Table) GProgLavori.listbox).getTable())
									.setRowSelectionInterval(index, index);
							(((Table) GProgLavori.panel2).getTable())
							.setRowSelectionInterval(index, index);
							(((Table) GProgLavori.panel3).getTable())
							.setRowSelectionInterval(index, index);
							(((Table) GProgLavori.panel4).getTable())
							.setRowSelectionInterval(index, index);
							(((Table) GProgLavori.panel5).getTable())
							.setRowSelectionInterval(index, index);

						}
						Table t1 =  (Table) GProgLavori.listbox;
						if (s.gch.hasDistinta( (String) t1.getTable().getValueAt(t.getSelectedRow(), 0) ) ) {
							GProgLavori.b.setText("Visualizza Distinta");
						} else {
							GProgLavori.b.setText("Crea Distinta");
						}
					}
				});
		tabbedPane.addTab("Dati Cliente", null, panel1, "Dati Cliente");
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

		panel2 = makeTextPanel(2);
		(((Table) GProgLavori.panel2).getTable())
		.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				JTable t =  (JTable) evt.getSource();
				if (evt.getClickCount() == 1 && t.getSelectedRow() >= 0) {
					int index = t.getSelectedRow();
					GProgLavori.selectedRow = index;
					(((Table) GProgLavori.listbox).getTable())
							.setRowSelectionInterval(index, index);
					(((Table) GProgLavori.panel1).getTable())
					.setRowSelectionInterval(index, index);
					(((Table) GProgLavori.panel3).getTable())
					.setRowSelectionInterval(index, index);
					(((Table) GProgLavori.panel4).getTable())
					.setRowSelectionInterval(index, index);
					(((Table) GProgLavori.panel5).getTable())
					.setRowSelectionInterval(index, index);

				}
				Table t1 =  (Table) GProgLavori.listbox;
				if (s.gch.hasDistinta( (String) t1.getTable().getValueAt(t.getSelectedRow(), 0) ) ) {
					GProgLavori.b.setText("Visualizza Distinta");
				} else {
					GProgLavori.b.setText("Crea Distinta");
				}
			}
		});
		tabbedPane.addTab("Dati Aziendali", null, panel2, "Dati Aziendali");
		tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);

		panel3 = makeTextPanel(3);
		(((Table) GProgLavori.panel3).getTable())
		.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				JTable t =  (JTable) evt.getSource();
				if (evt.getClickCount() == 1 && t.getSelectedRow() >= 0) {
					int index = t.getSelectedRow();
					GProgLavori.selectedRow = index;
					(((Table) GProgLavori.listbox).getTable())
							.setRowSelectionInterval(index, index);
					(((Table) GProgLavori.panel2).getTable())
					.setRowSelectionInterval(index, index);
					(((Table) GProgLavori.panel1).getTable())
					.setRowSelectionInterval(index, index);
					(((Table) GProgLavori.panel4).getTable())
					.setRowSelectionInterval(index, index);
					(((Table) GProgLavori.panel5).getTable())
					.setRowSelectionInterval(index, index);

				}
				Table t1 =  (Table) GProgLavori.listbox;
				if (s.gch.hasDistinta( (String) t1.getTable().getValueAt(t.getSelectedRow(), 0) ) ) {
					GProgLavori.b.setText("Visualizza Distinta");
				} else {
					GProgLavori.b.setText("Crea Distinta");
				}
			}
		});
		tabbedPane.addTab("Sviluppo Consegna", null, panel3,
				"Sviluppo Consegna");
		tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);

		panel4 = makeTextPanel(4);
		(((Table) GProgLavori.panel4).getTable())
		.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				JTable t =  (JTable) evt.getSource();
				if (evt.getClickCount() == 1 && t.getSelectedRow() >= 0) {
					int index = t.getSelectedRow();
					GProgLavori.selectedRow = index;
					(((Table) GProgLavori.listbox).getTable())
							.setRowSelectionInterval(index, index);
					(((Table) GProgLavori.panel2).getTable())
					.setRowSelectionInterval(index, index);
					(((Table) GProgLavori.panel3).getTable())
					.setRowSelectionInterval(index, index);
					(((Table) GProgLavori.panel1).getTable())
					.setRowSelectionInterval(index, index);
					(((Table) GProgLavori.panel5).getTable())
					.setRowSelectionInterval(index, index);

				}
				Table t1 =  (Table) GProgLavori.listbox;
				if (s.gch.hasDistinta( (String) t1.getTable().getValueAt(t.getSelectedRow(), 0) ) ) {
					GProgLavori.b.setText("Visualizza Distinta");
				} else {
					GProgLavori.b.setText("Crea Distinta");
				}
			}
		});
		tabbedPane.addTab("Produzione", null, panel4, "Produzione");
		tabbedPane.setMnemonicAt(3, KeyEvent.VK_4);

		panel5 = makeTextPanel(5);
		(((Table) GProgLavori.panel5).getTable())
		.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				JTable t =  (JTable) evt.getSource();
				if (evt.getClickCount() == 1 && t.getSelectedRow() >= 0) {
					int index = t.getSelectedRow();
					GProgLavori.selectedRow = index;
					(((Table) GProgLavori.listbox).getTable())
							.setRowSelectionInterval(index, index);
					(((Table) GProgLavori.panel2).getTable())
					.setRowSelectionInterval(index, index);
					(((Table) GProgLavori.panel3).getTable())
					.setRowSelectionInterval(index, index);
					(((Table) GProgLavori.panel4).getTable())
					.setRowSelectionInterval(index, index);
					(((Table) GProgLavori.panel1).getTable())
					.setRowSelectionInterval(index, index);

				}
				Table t1 =  (Table) GProgLavori.listbox;
				if (s.gch.hasDistinta( (String) t1.getTable().getValueAt(t.getSelectedRow(), 0) ) ) {
					GProgLavori.b.setText("Visualizza Distinta");
				} else {
					GProgLavori.b.setText("Crea Distinta");
				}
			}
		});
		tabbedPane.addTab("Consegna", null, panel5, "Consegna");
		tabbedPane.setMnemonicAt(3, KeyEvent.VK_4);

		String[] listData;
		listData = new String[s.gch.getNumOfCommesse()];

		for (int i = 0; i < s.gch.getNumOfCommesse(); i++) {
			String row = s.gch.getCommessaByIndex(i).getCodiceInterno();
			listData[i] = row;
		}

		// Create a new listbox control
		listbox = makeTextPanel(0);
		(((Table) GProgLavori.listbox).getTable())
		.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				JTable t =  (JTable) evt.getSource();
				if (evt.getClickCount() == 1 && t.getSelectedRow() >= 0) {
					int index = t.getSelectedRow();
					GProgLavori.selectedRow = index;
					(((Table) GProgLavori.panel1).getTable())
							.setRowSelectionInterval(index, index);
					(((Table) GProgLavori.panel2).getTable())
							.setRowSelectionInterval(index, index);
					(((Table) GProgLavori.panel3).getTable())
							.setRowSelectionInterval(index, index);
					(((Table) GProgLavori.panel4).getTable())
							.setRowSelectionInterval(index, index);
					(((Table) GProgLavori.panel5).getTable())
							.setRowSelectionInterval(index, index);
//					 JOptionPane.showMessageDialog(null,s.gch.hasDistinta(
//							 (String) t.getValueAt(t.getSelectedRow(), 0)  ));
					if (s.gch.hasDistinta((String) t.getValueAt(t.getSelectedRow(), 0) )) {
						GProgLavori.b.setText("Visualizza Distinta");
					} else {
						GProgLavori.b.setText("Crea Distinta");
					}
				}
			}
		});
		JLabel text = new JLabel();
		text.setText("");
		text.setHorizontalAlignment(SwingConstants.CENTER);
		text.setPreferredSize(new Dimension(200, 25));
		listbox.setPreferredSize(new Dimension(200, this.getHeight()));
		b = new JButton("Crea Distinta");
		JPanel cpEst = new JPanel(new BorderLayout());
		cpEst.add(listbox, BorderLayout.CENTER);
		cpEst.add(text, BorderLayout.NORTH);
		cpEst.add(b, BorderLayout.SOUTH);


		this.add(tabbedPane, BorderLayout.CENTER);
		this.add(cpEst, BorderLayout.WEST);

	}

	protected JComponent makeTextPanel(int a) {

		String[] column1 = { "Codice Interno", "Cliente", "Cantiere",
				"Commessa Cliente" };
		String[] column2 = { "Codice Interno", "O/C", "Anno",
				"Ordine/Contratto", "Commessa Coedil", "Cod Interno",
				"Ordine Gestionale", "Data Inizio", "Data Fine", "Orario",
				"Descrizione", "Partizione",

		};
		String[] column3 = { "Codice Interno", "Responsabile", "Data Inizio",
				"Scadenza sviluppo", "Data fine", "Ritardo" };
		String[] column4 = { "Codice Interno", "Data Inizio", "Data fine",
				"Scadenza sviluppo" };
		String[] column5 = { "Codice Interno", "Data prima consegna",
				"Ritardo consegna" };
		String[] column0 = { "Codice Interno","" };
		JPanel panel0 = new Table(column0, 0);
		JPanel panel1 = new Table(column1, 1);
		JPanel panel2 = new Table(column2, 2);
		JPanel panel3 = new Table(column3, 3);
		JPanel panel4 = new Table(column4, 4);
		JPanel panel5 = new Table(column5, 5);
		JPanel panel;

		switch (a) {
		case 0:
			panel = panel0;
			break;
		case 1:
			panel = panel1;
			break;
		case 2:
			panel = panel2;
			break;
		case 3:
			panel = panel3;
			break;
		case 4:
			panel = panel4;
			break;
		case 5:
			panel = panel5;
			break;
		default:
			panel = panel1;
			break;
		}

		return panel;
	}

}
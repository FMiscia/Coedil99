package GUIElaboraDistinta;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

import ElaboraDistinta.StartUp;

public class GProgLavori extends JPanel {

	private static final long serialVersionUID = 1L;
	private static JComponent panel1;
	private static JComponent panel2;
	private static JComponent panel3;
	private static JComponent panel4;
	private static JComponent panel5;
	private static JTabbedPane tabbedPane;
	private static JButton b;
	private static JComponent listbox;

	public GProgLavori() {
		super(new BorderLayout());
		final StartUp s = StartUp.getInstance();
		tabbedPane = new JTabbedPane();

		Vector<String> column1 = new Vector<String>(); 
		String[] cl1 = { "Cliente", "Cantiere", "Commessa Cliente" };
	    for(int i=0; i<cl1.length; ++i)
	    	column1.add(cl1[i]);
		panel1 = makeTextPanel(cl1,1);
		(((Table) GProgLavori.panel1).getTable())
				.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						JTable t =  (JTable) evt.getSource();
						if (evt.getClickCount() == 1 && t.getSelectedRow() >= 0) {
							int index = t.getSelectedRow();
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


		String[] cl2 = { "O/C", "Anno",
				"Ordine/Contratto", "Commessa Coedil", "Cod Interno",
				"Ordine Gestionale", "Data Inizio", "Data Fine", "Orario",
				"Descrizione", "Partizione" };
		panel2 = makeTextPanel(cl2,2);
		(((Table) GProgLavori.panel2).getTable())
		.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				JTable t =  (JTable) evt.getSource();
				if (evt.getClickCount() == 1 && t.getSelectedRow() >= 0) {
					int index = t.getSelectedRow();
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

		String[] cl3 = { "Responsabile", "Data Inizio",
				"Scadenza sviluppo", "Data fine", "Ritardo" };
		panel3 = makeTextPanel(cl3,3);
		(((Table) GProgLavori.panel3).getTable())
		.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				JTable t =  (JTable) evt.getSource();
				if (evt.getClickCount() == 1 && t.getSelectedRow() >= 0) {
					int index = t.getSelectedRow();
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

		String[] cl4 = { "Data Inizio", "Data fine",
		"Scadenza sviluppo" };
		panel4 = makeTextPanel(cl4,4);
		(((Table) GProgLavori.panel4).getTable())
		.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				JTable t =  (JTable) evt.getSource();
				if (evt.getClickCount() == 1 && t.getSelectedRow() >= 0) {
					int index = t.getSelectedRow();
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

		String[] cl5 = { "Data prima consegna",	"Ritardo consegna" };
		panel5 = makeTextPanel(cl5,5);
		(((Table) GProgLavori.panel5).getTable())
		.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				JTable t =  (JTable) evt.getSource();
				if (evt.getClickCount() == 1 && t.getSelectedRow() >= 0) {
					int index = t.getSelectedRow();
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
		String[] cl0 = {  "Codice Interno",""};
		listbox = makeTextPanel(cl0,0);
		(((Table) GProgLavori.listbox).getTable())
		.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				JTable t =  (JTable) evt.getSource();
				if (evt.getClickCount() == 1 && t.getSelectedRow() >= 0) {
					int index = t.getSelectedRow();
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
		b.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				final JFrame frameDist = new JFrame("Distinta");
				frameDist.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frameDist.getContentPane().setLayout(new BorderLayout());
				frameDist.setResizable(false);
				frameDist.setBounds(100, 100, 549, 326);
				String[] cl6 = {  "a","b","c","d","e","f","g"};
				final JComponent t = makeTextPanel(cl6,6);
				frameDist.add(t,BorderLayout.CENTER);
				JPanel doc = new JPanel();
				Button save = new Button("Save");
				Button nLine = new Button("New line");
				nLine.addMouseListener(new MouseAdapter(){
		    		public void mouseClicked(MouseEvent arg0){
						frameDist.add( ((Table) t).addRow((Table) t) ,BorderLayout.CENTER);
		    		}
		    		});
				doc.add(nLine);
				doc.add(save);
				frameDist.add(doc,BorderLayout.SOUTH);
				frameDist.setVisible(true);
				
				 //JOptionPane.showMessageDialog(null,"aaa");
				}
		});
		JPanel cpEst = new JPanel(new BorderLayout());
		cpEst.add(listbox, BorderLayout.CENTER);
		cpEst.add(text, BorderLayout.NORTH);
		cpEst.add(b, BorderLayout.SOUTH);
		


		this.add(tabbedPane, BorderLayout.CENTER);
		this.add(cpEst, BorderLayout.WEST);
		Table tCentrale = null;
		for ( int i = 0 ; i < GProgLavori.tabbedPane.getComponentCount(); i++ )
		{
			tCentrale = (Table) GProgLavori.tabbedPane.getComponent(i);
			agganciaScroll( tCentrale.getScroll() );
		}	

		

	}

	public void agganciaScroll( final JScrollPane cen0 ){
		Table tSinistra =  (Table) GProgLavori.listbox;
		final JScrollPane sin = tSinistra.getScroll();
		cen0.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener(){ 
			@Override
			public void adjustmentValueChanged(AdjustmentEvent arg0) {
				// TODO Auto-generated method stub
				sin.getVerticalScrollBar().setValue(cen0.getVerticalScrollBar().getValue());
			}});
		sin.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener(){ 
			@Override
			public void adjustmentValueChanged(AdjustmentEvent arg0) {
				// TODO Auto-generated method stub
				cen0.getVerticalScrollBar().setValue(sin.getVerticalScrollBar().getValue());
			}});
	}
	
	
	protected JComponent makeTextPanel( String[] cl , int a) {

		Vector<String> column  = new Vector<String>(); 
	    for(int i=0; i<cl.length; ++i)
	    	column.add(cl[i]);

		
		JPanel panel0 = new Table(column, 0);
		JPanel panel1 = new Table(column, 1);
		JPanel panel2 = new Table(column, 2);
		JPanel panel3 = new Table(column, 3);
		JPanel panel4 = new Table(column, 4);
		JPanel panel5 = new Table(column, 5);
		JPanel panel6 = new Table(column, 6);
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
		case 6:
			panel = panel6;
			break;
		default:
			panel = panel1;
			break;
		}

		return panel;
	}

}
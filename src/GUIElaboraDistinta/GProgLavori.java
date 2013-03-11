package GUIElaboraDistinta;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Component;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

import ElaboraDistinta.StartUp;

public class GProgLavori extends JPanel {


	private static final long serialVersionUID = 1L;
	private static GPanel1 panel1;
	private static GPanel2 panel2;
	private static GPanel3 panel3;
	private static GPanel4 panel4;
	private static GPanel5 panel5;
	private static JTabbedPane tabbedPane;
	private static JButton b;
	private static GPanelCodInt listbox;

	public GProgLavori() {
		super(new BorderLayout());
		final StartUp s = StartUp.getInstance();
		tabbedPane = new JTabbedPane();
		// Create a new listbox control
		String[] cl0 = {  "Codice Interno",""};
		listbox = new GPanelCodInt( makeVector(cl0) );
		
		Vector<String> column1 = new Vector<String>(); 
		String[] cl1 = { "Cliente", "Cantiere", "Commessa Cliente" };
	    for(int i=0; i<cl1.length; ++i)
	    	column1.add(cl1[i]);
		panel1 = new GPanel1( makeVector(cl1) );
		tabbedPane.addTab("Dati Cliente", null, panel1, "Dati Cliente");
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);


		String[] cl2 = { "O/C", "Anno",
				"Ordine/Contratto", "Commessa Coedil",
				"Ordine Gestionale", "Data Inizio", "Data Fine", "Orario",
				"Descrizione", "Partizione" };
		panel2 = new GPanel2( makeVector(cl2) );
		tabbedPane.addTab("Dati Aziendali", null, panel2, "Dati Aziendali");
		tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);

		String[] cl3 = { "Responsabile", "Data Inizio",
				"Scadenza sviluppo", "Data fine", "Ritardo" };
		panel3 = new GPanel3( makeVector(cl3) );

		tabbedPane.addTab("Sviluppo Consegna", null, panel3,
				"Sviluppo Consegna");
		tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);

		String[] cl4 = { "Data Inizio", "Data fine",
		"Scadenza sviluppo" };
		panel4 = new GPanel4( makeVector(cl4) );

		tabbedPane.addTab("Produzione", null, panel4, "Produzione");
		tabbedPane.setMnemonicAt(3, KeyEvent.VK_4);

		String[] cl5 = { "Data prima consegna",	"Ritardo consegna" };
		panel5 = new GPanel5( makeVector(cl5) );

		tabbedPane.addTab("Consegna", null, panel5, "Consegna");
		tabbedPane.setMnemonicAt(3, KeyEvent.VK_4);

		String[] listData;
		listData = new String[s.gch.getNumOfCommesse()];

		for (int i = 0; i < s.gch.getNumOfCommesse(); i++) {
			String row = s.gch.getCommessaByIndex(i).getCodiceInterno();
			listData[i] = row;
		}


		JLabel text = new JLabel();
		text.setText("");
		text.setHorizontalAlignment(SwingConstants.CENTER);
		text.setPreferredSize(new Dimension(200, 25));
		listbox.setPreferredSize(new Dimension(200, this.getHeight()));
		setB(new JButton("Crea Distinta"));
		getB().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {

				int index = listbox.getTable().getSelectedRow();
				final GDistinta frameDist = new GDistinta( index );
				// JOptionPane.showMessageDialog(null, index );
				}
		});
		JPanel cpEst = new JPanel(new BorderLayout());
		cpEst.add(listbox, BorderLayout.CENTER);
		cpEst.add(text, BorderLayout.NORTH);
		cpEst.add(getB(), BorderLayout.SOUTH);
		


		this.add(tabbedPane, BorderLayout.CENTER);
		this.add(cpEst, BorderLayout.WEST);

	}


	
	
	protected Vector<String> makeVector( String[] cl) {

		Vector<String> column  = new Vector<String>(); 
	    for(int i=0; i<cl.length; ++i)
	    	column.add(cl[i]);
	    
	    return column;

	}
	
	
	public static JComponent getPanel1() {
		return panel1;
	}
	
	public static JComponent getPanel2() {
		return panel2;
	}


	public static JComponent getPanel3() {
		return panel3;
	}


	public static JComponent getPanel4() {
		return panel4;
	}


	public static JComponent getPanel5() {
		return panel5;
	}

	public static JButton getB() {
		return b;
	}
	private void setB(JButton jButton) {
		// TODO Auto-generated method stub
		this.b = jButton;
	}
	public static JComponent getListbox() {
		return listbox;
	}



}
package GUIelaboradistinta;

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
import javax.swing.JViewport;
import javax.swing.SwingConstants;


import provaTabelle.GDatiAziendaliTable;
import provaTabelle.GDatiClienteTable;
import provaTabelle.GDatiCodiceInternoTable;
import provaTabelle.GDatiConsegnaTable;
import provaTabelle.GDatiDistintaTable;
import provaTabelle.GDatiProduzioneTable;
import provaTabelle.GDatiSviluppoConsegnaTable;

import elaboradistinta.StartUp;
import elaboradistinta.controller.GestisciClienteHandler;
import elaboradistinta.controller.GestisciCommessaHandler;
import elaboradistinta.controller.GestisciOrdineHandler;
import elaboradistinta.model.Commessa;
import elaboradistinta.model.Distinta;
import elaboradistinta.model.DistintaFactory;
import elaboradistinta.model.RigheLavoro;
import elaboradistinta.model.RigheLavoroFactory;

public class GProgLavori extends JPanel {


	private static final long serialVersionUID = 1L;
	private static JTabbedPane tabbedPane;
	private static JButton b;
	private static JScrollPane listbox;

	public GProgLavori() {
		super(new BorderLayout());
		final StartUp s = StartUp.getInstance();
		
		//GestisciClienteHandler gch = GestisciClienteHandler.getInstance();
		//GestisciOrdineHandler goh = GestisciOrdineHandler.getInstance();
		//GestisciCommessaHandler gcoh = GestisciCommessaHandler.getInstance();
		
		
		tabbedPane = new JTabbedPane();
		tabbedPane.addTab("Dati Cliente Consegna",new JScrollPane(new GDatiClienteTable()));
		tabbedPane.addTab("Dati Aziendali",new JScrollPane(new GDatiAziendaliTable()));
		tabbedPane.addTab("Dati Sviluppo Consegna",new JScrollPane(new GDatiSviluppoConsegnaTable()));
		tabbedPane.addTab("Dati Produzione Consegna",new JScrollPane(new GDatiProduzioneTable()));
		tabbedPane.addTab("Dati Consegna",new JScrollPane(new GDatiConsegnaTable()));
		// Create a new listbox control
		//String[] cl0 = {  "Codice Interno",""};
		final GDatiCodiceInternoTable codiciInterni = new GDatiCodiceInternoTable();
		listbox = new JScrollPane(codiciInterni);
		/*
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
*/
		JLabel text = new JLabel();
		text.setText("");
		text.setHorizontalAlignment(SwingConstants.CENTER);
		text.setPreferredSize(new Dimension(200, 25));
		listbox.setPreferredSize(new Dimension(200, this.getHeight()));
		setB(new JButton("Crea Distinta"));
		final JPanel cpEst = new JPanel(new BorderLayout());
		cpEst.add(listbox, BorderLayout.CENTER);
		cpEst.add(text, BorderLayout.NORTH);
		cpEst.add(getB(), BorderLayout.SOUTH);
		this.add(tabbedPane, BorderLayout.CENTER);
		this.add(cpEst, BorderLayout.WEST);
		
		codiciInterni.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				String codice = codiciInterni.getValueAt(codiciInterni.rowAtPoint(e.getPoint()), 0).toString();
				cpEst.remove(getB());
				if(checkDistinta(codice)){
					getB().setText("Visualizza Distinta");	
				}
				else{
					getB().setText("Crea Distinta");
				}
				cpEst.add(getB(),BorderLayout.SOUTH);
				validate();
				repaint();
			}
		});
		

		getB().addMouseListener(new MouseAdapter() {			
			public void mouseClicked(MouseEvent evt) {
				int index = codiciInterni.getSelectedRow();
				GestisciCommessaHandler gch = GestisciCommessaHandler.getInstance();
				Commessa c = gch.getCommessaByCodiceInterno(codiciInterni.getValueAt(index, 0).toString());
				if((c != null) && (c.getDistinta() != null) ){
					final GDistinta frameDist = new GDistinta(c.getDistinta(),c.getCodiceInterno());
				}
				else{
					RigheLavoro r = RigheLavoroFactory.createRigheLavoro();
					r.save();
					Distinta d = DistintaFactory.createDistinta();
					d.setLavori(r);
					d.save();
					gch.associaDistinta(d, c.getID());
					final GDistinta frameDist = new GDistinta(d,c.getCodiceInterno());
				}
				
			}
		});
		
		codiciInterni.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				int index = codiciInterni.getSelectedRow();
				for(int i=0; i<tabbedPane.getComponents().length; ++i){		
					JViewport viewport = ((JScrollPane) tabbedPane.getComponent(i)).getViewport(); 
					JTable v = (JTable) viewport.getView();			
					v.setRowSelectionInterval(index, index);
				}
			}
		});
		
		for(int i=0; i<tabbedPane.getComponents().length; ++i){	
			JViewport viewport = ((JScrollPane) tabbedPane.getComponent(i)).getViewport(); 
			final JTable v = (JTable) viewport.getView();
			v.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					int index = v.getSelectedRow();
					codiciInterni.setRowSelectionInterval(index, index);
				}
			});
		}


	}

	
	private boolean checkDistinta(String codice){
		GestisciCommessaHandler gch = GestisciCommessaHandler.getInstance();
		if(gch.getCommessaByCodiceInterno(codice) != null)
			return gch.getCommessaByCodiceInterno(codice).getDistinta() != null;
		else
			return false;
		//
	}


	/*
	
	
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
*/
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
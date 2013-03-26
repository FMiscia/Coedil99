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
import java.util.ArrayList;
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


import GUIelaboradistinta.table.*;
import elaboradistinta.StartUp;
import elaboradistinta.controller.GestisciClienteHandler;
import elaboradistinta.controller.GestisciCommessaHandler;
import elaboradistinta.controller.GestisciOrdineHandler;
import elaboradistinta.model.Commessa;
import elaboradistinta.model.CommessaFactory;
import elaboradistinta.model.Distinta;
import elaboradistinta.model.DistintaFactory;
import elaboradistinta.model.DocumentoOttimizzazione;
import elaboradistinta.model.Geometria;
import elaboradistinta.model.RigaLavoro;
import elaboradistinta.model.RigheLavoro;
import elaboradistinta.model.RigheLavoroFactory;
import elaboradistinta.operation.ODistinta;
import elaboradistinta.operation.ODocumentoOttimizzazione;
import elaboradistinta.operation.ORigheLavoro;

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
		
		final GDatiCodiceInternoTable codiciInterni = new GDatiCodiceInternoTable();
		listbox = new JScrollPane(codiciInterni);
		JLabel text = new JLabel();
		text.setText("");
		text.setHorizontalAlignment(SwingConstants.CENTER);
		text.setPreferredSize(new Dimension(200, 25));
		listbox.setPreferredSize(new Dimension(200, this.getHeight()));
		setB(new JButton("Crea Distinta"));
		final JButton deldist = new JButton("Elimina Distinta");
		final JPanel bottoni = new JPanel(new BorderLayout(0, 0));
		bottoni.add(getB(), BorderLayout.WEST);
		bottoni.add(deldist, BorderLayout.EAST);
		bottoni.getComponent(1).setVisible(false);
		
		
		
		final JPanel cpEst = new JPanel(new BorderLayout());
		cpEst.add(listbox, BorderLayout.CENTER);
		cpEst.add(text, BorderLayout.NORTH);
		
		
		
		this.add(tabbedPane, BorderLayout.CENTER);
		this.add(cpEst, BorderLayout.WEST);
		//Click sulla singola riga dei codici interni
		codiciInterni.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				String codice = codiciInterni.getValueAt(codiciInterni.rowAtPoint(e.getPoint()), 0).toString();
				cpEst.add(bottoni, BorderLayout.SOUTH);
				if(checkDistinta(codice)){
					getB().setText("Visualizza Distinta");	
					deldist.setVisible(true);
				}
				else{
					getB().setText("Crea Distinta");
					deldist.setVisible(false);
				}
				validate();
				repaint();
			}
		});
		
		//Click sul pulsante crea/visualizza
		getB().addMouseListener(new MouseAdapter() {			
			public void mouseClicked(MouseEvent evt) {
				int index = codiciInterni.getSelectedRow();
				GestisciCommessaHandler gch = GestisciCommessaHandler.getInstance();
				Commessa c = gch.getCommessaByCodiceInterno(codiciInterni.getValueAt(index, 0).toString());
				if((c != null) && (c.getDistinta() != null) ){
					final GDistinta frameDist = new GDistinta(c.getDistinta(),c.getCodiceInterno());
				}
				else{
					getB().setText("Visualizza Distinta");
					deldist.setVisible(true);
					RigheLavoro r = RigheLavoroFactory.createRigheLavoro();
					r.save();
					Distinta d = DistintaFactory.createDistinta();
					d.setLavori(r);
					d.save();
					c.setDistinta(d);
					c.save();
					gch.associaDistinta(d, c.getID());
					final GDistinta frameDist = new GDistinta(d,c.getCodiceInterno());
				}
				validate();
				repaint();
			}
		});
		
		//Click sulla riga codici interni per allineare le righe della tabbedpane
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

		//Click sul pulsante cancella distinta
		deldist.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				String codice = codiciInterni.getValueAt(codiciInterni.getSelectedRow(),0).toString();
				GestisciCommessaHandler gch = GestisciCommessaHandler.getInstance();
				Commessa c = gch.getCommessaByCodiceInterno(codice);
				if(cancellaDistinta(c)){
					getB().setText("Crea Distinta");
					deldist.setVisible(false);
				}	
				validate();
				repaint();
			}
		});

	}

	
	private boolean checkDistinta(String codice){
		GestisciCommessaHandler gch = GestisciCommessaHandler.getInstance();
		if(gch.getCommessaByCodiceInterno(codice) != null)
			return gch.getCommessaByCodiceInterno(codice).getDistinta() != null;
		else
			return false;
		//
	}


	private boolean cancellaDistinta(Commessa c){
		int n = JOptionPane.showConfirmDialog(null,"Sicuro di voler cancellare la distinta?"
				,"Domanda",JOptionPane.YES_NO_OPTION);
		if(n == 0){
			Distinta d = DistintaFactory.getDistintaByORMID(c.getDistinta().getID());
			c.setDistinta(null);
			c.save();
			if(d.getDdo() != null){
				DocumentoOttimizzazione ddo = d.getDdo();
				d.setDdo(null);
				d.save();
				ddo.delete();
			}
			RigheLavoro r = d.getLavori();
			d.delete();
			ArrayList<RigaLavoro> rr = new ArrayList<RigaLavoro>(r.righe.getCollection());
			r.delete();
			if(rr.size() != 0){
				for(int i=0; i<rr.size(); ++i){
					Geometria g = rr.get(i).getGeometria();
					rr.get(i).delete();
					g.delete();
				}
			}
			JOptionPane.showMessageDialog(null, "Distinta Cancellata!");
			return true;
		}
		else
			return false;
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
		this.b = jButton;
	}
	public static JComponent getListbox() {
		return listbox;
	}



}
package GUI.Panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

import coedil99.controller.GestisciRDAHandler;

import GUI.CommercialeCenter;
import GUI.Card.CardRDA;
import GUI.Liste.ListaRigheRDA;
import GUI.Plichi.PlicoCommerciale;


public class PanelRDAComm extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btConferma;
	private JButton btRifiuta;
	JTextPane area;
	String newline = "\n";

	/**
	 * Costruttore
	 */
	public PanelRDAComm() {
		super();
		this.initialize();
	}
	
	

	
	/**
	 * Imposta la grafica e i bottoni (e relativi listeners)
	 */
	private void initialize(){
		GridBagLayout ml = new GridBagLayout();
		GridBagConstraints mlc = new GridBagConstraints();
		setLayout(ml);
		mlc.fill = GridBagConstraints.BOTH;
		
		mlc.gridwidth = 4;
		mlc.gridy = 1;
		mlc.gridx = 0;
		mlc.insets = new Insets(10, 10, 10, 10);
		
		JLabel label = new JLabel("Aggiungi una nota prima di confermare o rifiutare una RDA",
				JLabel.CENTER);
		label.setFont(new Font("Serif", Font.BOLD, 16));
		ml.setConstraints(label, mlc);
		add(label);
		
		
		mlc.gridwidth = 4;
		mlc.gridy = 2;
		mlc.gridx = 0;
		mlc.insets = new Insets(10, 10, 10, 10);
		
		area = new JTextPane();
		area.setPreferredSize(new Dimension(100,100));
		JScrollPane jsp = new JScrollPane(area);
		ml.setConstraints(jsp, mlc);
		add(jsp);
		mlc.gridwidth = 1;
		mlc.gridy = 3;
		mlc.gridx = 0;
		
		btConferma = new JButton("Corferma RDA");
		btConferma.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PanelRDAComm.this.actionSuRDA(GestisciRDAHandler.CONFERMATA);
			}
		});
		ml.setConstraints(btConferma, mlc);
		add(btConferma);
		mlc.gridwidth = 1;
		mlc.gridy = 4;
		mlc.gridx = 0;
	
		btRifiuta = new JButton("Rifiuta RDA");
		btRifiuta.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PanelRDAComm.this.actionSuRDA(GestisciRDAHandler.RIFIUTATA);
			}
		});
		ml.setConstraints(btRifiuta, mlc);
		add(btRifiuta);
				
	}

	protected void actionSuRDA(String stato) {
		CommercialeCenter c = CommercialeCenter.getInstance();
		if(area.getText().length() > 250)
			area.setText(area.getText().substring(0,200));
		c.getRDASelezionata().setDescrizione(area.getText());
		c.getRDASelezionata().setState(stato);
		c.getRDASelezionata().save();
		c.getLista().loadComm(GestisciRDAHandler.ATTESA_CONFERMA);
		PlicoCommerciale plico_com = PlicoCommerciale.getInstance();
		if(c.getLista().panelHasRDA()){
			c.getLista().getPrimaCard().getRiquadro().deselectAll();
			CommercialeCenter contenitore = CommercialeCenter.getInstance();
			contenitore.setRDASelezionata(GestisciRDAHandler.getInstance().getMRDAById(c.getLista().getPrimaRDA()));
			contenitore.loadListaRigheRDA();
			c.getLista().getPrimaCard().selectCard();
			c.getLista().getPrimaCard().validate();
			c.getLista().getPrimaCard().repaint();
		}
		ListaRigheRDA lista_righe_rda = plico_com.getListaRigheRDA();
		plico_com.refreshFormRDA();
		lista_righe_rda.getPanel().removeAll();
		lista_righe_rda.validate();
		lista_righe_rda.repaint();
	}



}
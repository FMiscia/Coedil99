package Panels;

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

import GUI.CommercialeCenter;
import GUI.RDACenter;
import GUI.Liste.ListaRigheRDA;
import GUI.Plichi.PlicoCommerciale;
import coedil99.controller.GestisciRDAHandler;

public class NotaRDA extends JPanel{

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
	public NotaRDA() {
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
		
		JLabel label = new JLabel("Nota relativa alla RDA selezionata",
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
		this.setNotaTxt();
		area.setEnabled(false);
		area.setBackground(Color.darkGray);
		JScrollPane jsp = new JScrollPane(area);
		ml.setConstraints(jsp, mlc);
		add(jsp);
//		mlc.gridwidth = 1;
//		mlc.gridy = 3;
//		mlc.gridx = 0;
//		
//		btConferma = new JButton("Corferma RDA");
//		btConferma.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//			}
//		});
//		ml.setConstraints(btConferma, mlc);
//		add(btConferma);
//		mlc.gridwidth = 1;
//		mlc.gridy = 4;
//		mlc.gridx = 0;
//	
//		btRifiuta = new JButton("Rifiuta RDA");
//		btRifiuta.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//
//			}
//		});
//		ml.setConstraints(btRifiuta, mlc);
//		add(btRifiuta);
				
	}




	public void setNotaTxt() {
		// TODO Auto-generated method stub
		String desc = RDACenter.getInstance().getRDASelezionata().getDescrizione();
		area.setText(desc);
	}
	

}

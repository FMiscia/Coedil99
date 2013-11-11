package Panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

import org.orm.PersistentException;

import GUI.CommercialeCenter;
import GUI.RDACenter;
import GUI.Abstract.AClipPanel;
import GUI.Card.CardRDA;
import GUI.Liste.ListaRigheRDA;
import GUI.Plichi.PlicoCommerciale;
import coedil99.controller.GestisciRDAHandler;
import coedil99.model.MRDA;

public class NotaRDA extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btElimina;
	private JButton btSposta;
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
		
		mlc.gridwidth = 1;
		mlc.gridy = 3;
		mlc.gridx = 0;
		
		btElimina = new JButton("Elimina RDA");
		btElimina.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MRDA temp = RDACenter.getInstance().getRDASelezionata();
				GestisciRDAHandler.getInstance().deleteAndRemoveMRDA(temp);
				JOptionPane.showMessageDialog(null,
							"RDA eliminata con successo!\n",
							"Conferma operazione", JOptionPane.PLAIN_MESSAGE);
					RDACenter.getInstance().getClipPanel().getButtons().get(AClipPanel.RDAButtonState.get(GestisciRDAHandler.RIFIUTATA))
							.doClick();

				
			}
		});
		ml.setConstraints(btElimina, mlc);
		add(btElimina);
		mlc.gridwidth = 1;
		mlc.gridy = 4;
		mlc.gridx = 0;
	
		btSposta = new JButton("Sposta RDA");
		btSposta.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MRDA temp = RDACenter.getInstance().getRDASelezionata();
				temp.getPersistentModel().setState(
						GestisciRDAHandler.CONGELATA);
				temp.getPersistentModel().setDate(new Date());
				((CardRDA) RDACenter.getInstance().getLista()
						.getPrimaCard()).setSaved(true);
				GestisciRDAHandler.getInstance().saveAndAddRDA(temp);
				JOptionPane.showMessageDialog(null,
						"RDA spostata in RDA congelate!\n",
						"Conferma operazione", JOptionPane.PLAIN_MESSAGE);
				RDACenter.getInstance().getClipPanel().getButtons().get(AClipPanel.RDAButtonState.get(GestisciRDAHandler.CONGELATA))
						.doClick();
			}
		});
		ml.setConstraints(btSposta, mlc);
		add(btSposta);
				
	}




	public void setNotaTxt() {
		// TODO Auto-generated method stub
		String desc = RDACenter.getInstance().getRDASelezionata().getDescrizione();
		area.setText(desc);
	}
	
	public void removeButtons(){
		remove(this.btElimina);
		remove(this.btSposta);
		this.validate();
		this.repaint();
	}
	

}

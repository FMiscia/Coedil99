package GUI.Abstract;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;

import coedil99.controller.GestisciRDAHandler;

/**
 * Classe astratta per la realizzazione del menu contestuale
 *  
 * @author Simone
 *
 */

public abstract class AClipPanel extends JPanel {
	
	/**
	 * Hash Map che associa i possibili stati di una rda con il pulsante relativo nel menu
	 */
	public static HashMap<String, Integer> RDAButtonState;
	{
		RDAButtonState = new HashMap<String, Integer>();
		RDAButtonState.put(GestisciRDAHandler.CONFERMATA, 3);
		RDAButtonState.put(GestisciRDAHandler.ATTESA_CONFERMA, 2);
		RDAButtonState.put(GestisciRDAHandler.CONGELATA, 1);		
	}
	
	private static final long serialVersionUID = 1L;
	
	private ArrayList<JButton> buttons = new ArrayList<JButton>();
	private static int numBottoniTotali = 8;
	private static Color coloreSelezionato = new Color(180,180,180);
	
	/**
	 * Costruttore: imposta i parametri standard dei clip panel
	 */
	public AClipPanel() {
		this.initialize();

	}


	/**
	 * Metodo che aggiunge un nuovo bottone al clipPanel
	 * 
	 * @param label: Stringa che dovrà contenere il bottone
	 * @param ToolTip: Testo per il tooltip del bottone
	 * @param click: ActionListener del bottone
	 */
	public void addButton(String label,String ToolTip,ActionListener click){
		JButton temp = new JButton();
		temp.setLayout(new BorderLayout());
		temp.setToolTipText(ToolTip);
		temp.setHorizontalTextPosition(SwingConstants.LEFT);
		temp.addActionListener(click);
		temp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		JLabel nome = new JLabel(label);
		temp.add(nome,BorderLayout.WEST);
		this.buttons.add(temp);
		this.add(temp);
		this.validate();
		this.repaint();	
	}
	
	/**
	 * Metodo che aggiunge una label contenente le notifiche
	 * 
	 * @param value: Stringa contenente il numero della notifica
	 * @param RDAState: Stringa contenente lo stato dell'RDA, serve per selezionare il bottone specifico
	 */
	protected void AddNotificaLabel(String value,String RDAState){
		JLabel notifica = new JLabel(value);
		notifica.setHorizontalAlignment(SwingConstants.RIGHT);
		if(this.getButtons().get(AClipPanel.RDAButtonState.get(RDAState)).getComponentCount() != 1)
			this.getButtons().get(AClipPanel.RDAButtonState.get(RDAState)).remove(1);
		this.getButtons().get(AClipPanel.RDAButtonState.get(RDAState)).add(notifica,BorderLayout.EAST);
	}
	
	/**
	 * Metodo per la creazione del bottone
	 * 
	 * @param label: Stringa che dovr� contenere il bottone
	 * @param ToolTip: Testo per il tooltip del bottone
	 * @return bottone creato
	 */
	public JButton createButton(String label,String ToolTip){
		JButton temp = new JButton(label);
		temp.setToolTipText(ToolTip);
		temp.setHorizontalTextPosition(SwingConstants.LEFT);
		temp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		return temp;
		
	}
	
	/**
	 * Metodo che aggiunge delle label per mantenere fissa la dimensione dei bottoni sul clip panel
	 * 
	 */
	public void addLabel(){
		JLabel temp = new JLabel();
		this.add(temp);
		this.validate();
		this.repaint();
	}
	
	/**
	 * Metodo che aggiunge i bottoni di help e chiusura mantenendoli di dimensione fissa usando addLabel()
	 * 
	 */
	public void fill(){
		for ( int n = AClipPanel.numBottoniTotali - this.getComponentCount(); n>0 ;n-- ){
			if(n<= AClipPanel.numBottoniTotali && n!=2 && n!=1)
				this.addLabel();
			if(n==2)
				this.addButton("Help", "Help", null);
			if(n==1)
				this.addButton("Exit", "Close Coedil99", new ActionListener(){
      			public void actionPerformed(ActionEvent e){
      				System.exit(0);
      			}
      		});
		}
	}
	
	/**
	 * Metodo che cambia colore ai bottoni quando non sono selezionati, reset al loro colore di dafault
	 * 
	 */
	public void focusOut(){
		for(JButton b: this.buttons){
			b.setBackground(UIManager.getColor("Button.background"));
			b.setEnabled(true);
		}
	}
	
	/**
	 * Metodo che controlla se un bottone � selezionato [test in base al suo colore di sfondo]
	 * 
	 * @param b: Bottone 
	 * @return booleano
	 */
	public Boolean isButtonFocused(JButton b){
		return b.getBackground().equals(AClipPanel.getColoreSelezionato());
	}
	
	
	/**
	 * Metodo che deseleziona tutti i bottoni e seleziona il primo nel clipPanel
	 * 
	 */
	public void resetInitialState(){
		this.focusOut();
		this.getButtons().get(1).setBackground(AClipPanel.getColoreSelezionato());
	}

	/**
	 * Get per bottoni
	 * 
	 * @return l'array bottoni
	 */
	public ArrayList<JButton> getButtons() {
		return buttons;
	}


	/**
	 * Get per il coloreSelezionato
	 * 
	 * @return the coloreSelezionato
	 */
	public static Color getColoreSelezionato() {
		return coloreSelezionato;
	}
	
	/**
	 * Imposta la grafica
	 */
	private void initialize() {
		this.setLayout(new GridLayout(1, 0));
		this.setBackground(new Color(238, 238, 238));
		this.setPreferredSize(new Dimension(210, 40));
		this.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
	}

}

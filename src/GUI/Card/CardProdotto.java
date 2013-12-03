package GUI.Card;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import GUI.ConfigGUI;
import GUI.Abstract.ACard;
import GUI.Abstract.ALista;
import coedil99.model.MProductDescription;

public class CardProdotto extends ACard {

	private JLabel lblEssenza;
	private JLabel lblAltezza;
	private JLabel lblLunghezza;
	private JLabel lblBase;
	private JLabel lblPezzi;
	private JLabel lblPrezzo;
	
	public CardProdotto(ALista AbstractList) {
		super(AbstractList);
		this.initialize();
	}

	@Override
	public void load(Object o) {
		MProductDescription prodotto = (MProductDescription) o;
		this.lblEssenza.setText(prodotto.getPersistentModel().getEssenza());
		this.lblAltezza.setText(String.valueOf(prodotto.getPersistentModel().getGeometria().getAltezza()));
		this.lblLunghezza.setText(String.valueOf(prodotto.getPersistentModel().getGeometria().getLunghezza()));
		this.lblBase.setText(String.valueOf(prodotto.getPersistentModel().getGeometria().getBase()));
		this.lblPezzi.setText(String.valueOf(prodotto.getPersistentModel().getPezzi_per_pacco()));
		this.lblPrezzo.setText(String.valueOf(prodotto.getPersistentModel().getPrezzo()+" €"));
		this.validate();
		this.repaint();
	}
	
	/**
	 * Imposta la grafica
	 */
	public void initialize(){
		this.setPreferredSize(new Dimension(530, 30));
		this.setBackground(ConfigGUI.getColoreProdottoPari());
		this.setBorder(new LineBorder(Color.WHITE));
		this.setForeground(Color.WHITE);
		this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		
		//add(this.createSeparator(SwingConstants.VERTICAL, Color.WHITE, Color.WHITE, new Dimension(1, 30)));
		
		this.lblEssenza = new JLabel();
		this.lblEssenza.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblEssenza.setBorder(null);
		this.lblEssenza.setToolTipText("Essenza");
		this.lblEssenza.setPreferredSize(new Dimension(160, 30));
		this.add(lblEssenza);
		
		add(this.createSeparator(SwingConstants.VERTICAL, new Dimension(2, 30)));
		
		this.lblAltezza = new JLabel();
		this.lblAltezza.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblAltezza.setBorder(null);
		this.lblAltezza.setToolTipText("Altezza");
		this.lblAltezza.setPreferredSize(new Dimension(80, 30));
		this.add(lblAltezza);
		
		add(this.createSeparator(SwingConstants.VERTICAL, new Dimension(2, 30)));
		
		this.lblLunghezza = new JLabel();
		this.lblLunghezza.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblLunghezza.setBorder(null);
		this.lblLunghezza.setToolTipText("Lunghezza");
		this.lblLunghezza.setPreferredSize(new Dimension(80, 30));
		this.add(lblLunghezza);
		
		add(this.createSeparator(SwingConstants.VERTICAL, new Dimension(2, 30)));
		
		this.lblBase = new JLabel();
		this.lblBase.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblBase.setBorder(null);
		this.lblBase.setToolTipText("Base");
		this.lblBase.setPreferredSize(new Dimension(70, 30));
		this.add(lblBase);
		
		add(this.createSeparator(SwingConstants.VERTICAL, new Dimension(2, 30)));
		
		this.lblPezzi = new JLabel();
		this.lblPezzi.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblPezzi.setBorder(null);
		this.lblPezzi.setToolTipText("Pezzi per pacco");
		this.lblPezzi.setPreferredSize(new Dimension(50,30));
		this.add(lblPezzi);
		
		add(this.createSeparator(SwingConstants.VERTICAL, new Dimension(2, 30)));
		
		this.lblPrezzo = new JLabel();
		this.lblPrezzo.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblPrezzo.setBorder(null);
		this.lblPrezzo.setToolTipText("Prezzo");
		this.lblPrezzo.setPreferredSize(new Dimension(70, 30));
		this.add(lblPrezzo);
		
		//add(this.createSeparator(SwingConstants.VERTICAL, Color.WHITE, Color.WHITE, new Dimension(1, 30)));
	}
	
	public void setSfondoCard(int riga){
		if((riga%2) != 0)
			this.setBackground(ConfigGUI.getColoreProdottoDispari());
	}

}

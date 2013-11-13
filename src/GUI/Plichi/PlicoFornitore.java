package GUI.Plichi;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import GUI.Abstract.APlico;
import GUI.Abstract.ARiquadro;
import GUI.Liste.ListaProdotti;
import GUI.Liste.ListaProdottiFactory;
import coedil99.controller.GestisciFornitoreHandler;
import coedil99.model.MProductDescription;
import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;

/**
 * Gestisce il pannello dei fornitori
 * 
 * @author Simone
 *
 */
@SuppressWarnings("serial")
public class PlicoFornitore extends APlico {

	private static PlicoFornitore instance = null;
	private ListaProdotti listaProdotti;
	private JPanel intestazione;
	
	/**
	 * Costruttore
	 */
	private PlicoFornitore(){
		this.setLayout(new BorderLayout());
		//this.initialize();
		this.addListaProdotti();
	}
	
	/**
	 * Inizializza la grafica
	 */
	private void initialize() {
		this.intestazione = new JPanel();
		FlowLayout flowLayout = (FlowLayout) intestazione.getLayout();
		flowLayout.setVgap(0);
		intestazione.setPreferredSize(new Dimension(530, 30));
		this.add(intestazione,BorderLayout.NORTH);
		
		JLabel lblEssenza = new JLabel("Essenza");
		lblEssenza.setHorizontalAlignment(SwingConstants.CENTER);
		lblEssenza.setPreferredSize(new Dimension(80, 30));
		intestazione.add(lblEssenza);
		
		JLabel lblLunghezza = new JLabel("Lunghezza");
		lblLunghezza.setHorizontalAlignment(SwingConstants.CENTER);
		lblLunghezza.setPreferredSize(new Dimension(80, 30));
		intestazione.add(lblLunghezza);
		
		JLabel lblAltezza = new JLabel("Altezza");
		lblAltezza.setHorizontalAlignment(SwingConstants.CENTER);
		lblAltezza.setPreferredSize(new Dimension(60, 30));
		intestazione.add(lblAltezza);
		
		JLabel lblBase = new JLabel("Base");
		lblBase.setPreferredSize(new Dimension(60, 30));
		lblBase.setHorizontalAlignment(SwingConstants.CENTER);
		intestazione.add(lblBase);
		
		JLabel lblPezziPerPacco = new JLabel("Pezzi per Pacco");
		lblPezziPerPacco.setPreferredSize(new Dimension(100, 30));
		lblPezziPerPacco.setHorizontalAlignment(SwingConstants.CENTER);
		intestazione.add(lblPezziPerPacco);
		
		JLabel lblPrezzo = new JLabel("Prezzo");
		lblPrezzo.setPreferredSize(new Dimension(50, 30));
		lblPrezzo.setHorizontalAlignment(SwingConstants.CENTER);
		intestazione.add(lblPrezzo);
	}

	/**
	 * Singleton
	 * @return instance:PlicoRDA
	 */
	public static PlicoFornitore getInstance() {
		if (PlicoFornitore.instance == null)
			PlicoFornitore.instance = new PlicoFornitore();
		return PlicoFornitore.instance;
	}
	
	
	@Override
	public void load() {
		// TODO Auto-generated method stub

	}

	@Override
	public void load(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isModifying() {
		// TODO Auto-generated method stub
		return false;
	}
	
	/**
	 * Metodo che aggiunge la lista dei prodotti nel plico fornitore
	 */
	public void addListaProdotti(){
		this.listaProdotti = (ListaProdotti) ListaProdottiFactory.getInstance().makeLista();
		this.add(listaProdotti,BorderLayout.WEST);
	}
	
	/**
	 * Metodo che carica il contenuto della lista dei prodotti a partire dal nome del catalogo fornitore
	 * 
	 * @param catalogo: String
	 */
	public void loadListaProdotti(String catalogo){
		this.listaProdotti.svuota();
		ArrayList<MProductDescription> prodotti = GestisciFornitoreHandler.getInstance().getMProductDescriptions(catalogo);
		this.listaProdotti.load(prodotti);
	}
	
}

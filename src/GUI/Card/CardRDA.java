package GUI.Card;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import GUI.RDACenter;
import GUI.Abstract.ACard;
import GUI.Liste.ListaRDA;
import GUI.Liste.ListaRigheRDA;
import GUI.Plichi.PlicoRDA;
import coedil99.controller.GestisciRDAHandler;
import coedil99.model.MRDA;

/**
 * 
 * @author francesco
 * 
 *         Gestisce il pannello che mostra i dettagli principali di una RDA in
 *         modo da rintracciarla visivamente
 */
@SuppressWarnings("serial")
public class CardRDA extends ACard {

	private ListaRDA riquadro = null;

	private int RDAId;
	private JLabel id = null;
	private JLabel stato = null;
	private JLabel icona = null;
	private JLabel data = null;
	private boolean saved = false;

	/**
	 * Hash Map statico che fornisce un icona a seconda di uno stato RDA
	 */
	private static HashMap<String, ImageIcon> state_map;
	static {

		CardRDA.state_map = new HashMap<String, ImageIcon>();

		CardRDA.state_map.put(GestisciRDAHandler.CONGELATA, new ImageIcon(
				CardRDA.class.getResource("/GUI/image/congelata.png")));

		CardRDA.state_map.put(GestisciRDAHandler.RIFIUTATA, new ImageIcon(
				CardRDA.class.getResource("/GUI/image/rifiutata.png")));

		CardRDA.state_map.put(
				GestisciRDAHandler.ATTESA_CONFERMA,
				new ImageIcon(CardRDA.class
						.getResource("/GUI/image/attesaconferma.png")));

		CardRDA.state_map.put(GestisciRDAHandler.CONFERMATA, new ImageIcon(
				CardRDA.class.getResource("/GUI/image/confermata.png")));
	}

	/**
	 * Costruttore (prende il padre come parametro)
	 * 
	 * @param rda
	 *            :ListaRDA
	 */
	public CardRDA(ListaRDA rda) {
		super(rda);
		this.riquadro = rda;
		this.initialize();
	}

	public int getRDAId() {
		return this.RDAId;
	}

	@Override
	/**
	 * Carica una RDA
	 * @param o:Object
	 */
	public void load(Object o) {
		final MRDA rda = (MRDA) o;
		this.RDAId = rda.getPersistentModel().getID();
		if (!rda.getPersistentModel().righeRDA.isEmpty()) {
			this.id.setText(rda.getPersistentModel().righeRDA.get(0)
					.getDescription().getCatalogoFornitore().getName());
		} else {
			this.id.setText("da settare");
		}
		this.stato.setText(rda.getPersistentModel().getState());
		this.icona.setIcon(CardRDA.state_map.get(rda.getPersistentModel()
				.getState()));

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

		this.data
				.setText(dateFormat
						.format((rda.getPersistentModel().getDate() == null) ? new java.util.Date()
								: rda.getPersistentModel().getDate()));
		this.setBackground(new Color(30, 144, 255));
		this.validate();
		this.repaint();

		this.addMouseListener(new MouseAdapter() {

			@SuppressWarnings("unchecked")
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				PlicoRDA plico_rda = PlicoRDA.getInstance();
				CardRDA.this.riquadro.deselectAll();
				RDACenter contenitore = RDACenter.getInstance();
				contenitore.setRDASelezionata(rda);
				ListaRigheRDA lista_righe_rda = plico_rda.getListaRigheRDA();
				plico_rda.resetFormRDA();
				lista_righe_rda.getPanel().removeAll();
				lista_righe_rda.load(new ArrayList<Object>(rda
						.getPersistentModel().righeRDA.getCollection()));
				CardRDA.this.setBackground(new Color(30, 44, 255));
				CardRDA.this.validate();
				CardRDA.this.repaint();
				lista_righe_rda.validate();
				lista_righe_rda.repaint();
			}
		});
	}

	public boolean isSaved() {
		return saved;
	}

	public void setSaved(boolean saved) {
		this.saved = saved;
	}

	public void setNomeFornitore(String s) {
		this.id.setText(s);
	}

	public boolean getRDAState() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Inizializza la grafica
	 */
	private void initialize() {
		// setBounds(new Rectangle(0, 0, 0, 0));
		this.setPreferredSize(new Dimension(260, 60));
		this.setBackground(new Color(30, 144, 255));
		this.setBorder(new LineBorder(Color.BLACK));
		this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.setLayout(null);

		this.icona = new JLabel();
		this.icona.setHorizontalAlignment(SwingConstants.CENTER);
		this.icona.setHorizontalTextPosition(SwingConstants.LEADING);
		this.icona.setBounds(200, 0, 60, 60);
		this.icona.setBorder(new LineBorder(Color.BLACK));

		this.stato = new JLabel();
		this.stato.setHorizontalAlignment(SwingConstants.CENTER);
		this.stato.setBounds(100, 30, 100, 30);
		this.stato.setBorder(new LineBorder(Color.BLACK));

		this.id = new JLabel();
		this.id.setHorizontalAlignment(SwingConstants.CENTER);
		this.id.setHorizontalTextPosition(SwingConstants.CENTER);
		this.id.setBorder(new LineBorder(new Color(0, 0, 0)));
		this.id.setBounds(0, 0, 200, 30);

		this.data = new JLabel();
		this.data.setHorizontalAlignment(SwingConstants.CENTER);
		this.data.setHorizontalTextPosition(SwingConstants.CENTER);
		this.data.setBorder(new LineBorder(new Color(0, 0, 0)));
		this.data.setBounds(0, 30, 100, 30);

		this.add(id);
		this.add(stato);
		this.add(icona);
		this.add(data);
	}

}

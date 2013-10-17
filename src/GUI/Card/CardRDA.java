package GUI.Card;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Rectangle;
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
import coedil99.model.RDA;

public class CardRDA extends ACard {

	private ListaRDA riquadro = null;

	private int RDAId;
	private JLabel id = null;
	private JLabel stato = null;
	private JLabel icona = null;
	private JLabel data = null;
	private boolean saved = false;


	private static HashMap<String, ImageIcon> state_map;
	static {
		
		CardRDA.state_map = new HashMap<String, ImageIcon>();
		
		CardRDA.state_map.put(
				GestisciRDAHandler.CONGELATA,
				new ImageIcon(CardRDA.class
						.getResource("/GUI/image/congelata.png")));
		
		CardRDA.state_map.put(
				GestisciRDAHandler.RIFIUTATA,
				new ImageIcon(CardRDA.class
						.getResource("/GUI/image/rifiutata.png")));
		
		CardRDA.state_map.put(
				GestisciRDAHandler.ATTESA_CONFERMA,
				new ImageIcon(CardRDA.class
						.getResource("/GUI/image/attesaconferma.png")));
		
		CardRDA.state_map.put(
				GestisciRDAHandler.CONFERMATA,
				new ImageIcon(CardRDA.class
						.getResource("/GUI/image/confermata.png")));
	}

	public CardRDA(ListaRDA rda) {
		super(rda);
		this.riquadro = rda;
		setBounds(new Rectangle(0, 0, 0, 0));
		this.setPreferredSize(new Dimension(260, 60));
		this.setBackground(new Color(30, 144, 255));
		this.setBorder(new LineBorder(Color.BLACK));
		this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		setLayout(null);

		icona = new JLabel();
		icona.setHorizontalAlignment(SwingConstants.CENTER);
		icona.setHorizontalTextPosition(SwingConstants.LEADING);
		icona.setBounds(200, 0, 60, 60);
		icona.setBorder(new LineBorder(Color.BLACK));

		stato = new JLabel();
		stato.setHorizontalAlignment(SwingConstants.CENTER);
		stato.setBounds(100, 30, 100, 30);
		stato.setBorder(new LineBorder(Color.BLACK));

		id = new JLabel();
		id.setHorizontalAlignment(SwingConstants.CENTER);
		id.setHorizontalTextPosition(SwingConstants.CENTER);
		id.setBorder(new LineBorder(new Color(0, 0, 0)));
		id.setBounds(0, 0, 200, 30);

		data = new JLabel();
		data.setHorizontalAlignment(SwingConstants.CENTER);
		data.setHorizontalTextPosition(SwingConstants.CENTER);
		data.setBorder(new LineBorder(new Color(0, 0, 0)));
		data.setBounds(0, 30, 100, 30);
		
		add(id);
		add(stato);
		add(icona);
		add(data);
	}


	public int getRDAId() {
		return this.RDAId;
	}

	@Override
	public void load(Object o) {
		// TODO Auto-generated method stub
		final RDA rda = (RDA) o;
		this.RDAId = rda.getID();
		if(!rda.righeRDA.isEmpty()){
			this.id.setText(rda.righeRDA.get(0).getDescription().getCatalogoFornitore().getName());			
		}else{
			this.id.setText("da settare");
		}
		this.stato.setText(rda.getState());
		this.icona.setIcon(CardRDA.state_map.get(rda.getState()));
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		dateFormat.format(rda.getDate());
		
		this.data.setText(		dateFormat.format(rda.getDate()));
		this.setBackground(new Color(30, 144, 255));
		this.validate();
		this.repaint();
		
		this.addMouseListener(new MouseAdapter() {

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
				lista_righe_rda.load(new ArrayList<Object>(rda.righeRDA.getCollection()));
				CardRDA.this.setBackground(new Color(30,44,255));
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
	
	public void setNomeFornitore(String s){
		this.id.setText(s);
	}


	public boolean getRDAState() {
		// TODO Auto-generated method stub
		return false;
	}

}

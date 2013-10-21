package GUI.Card;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import GUI.ProgrammaLavori;
import GUI.RaccoglitorePlichi;
import GUI.Abstract.ACard;
import GUI.Liste.ListaCommesse;
import GUI.Plichi.PlicoCommessa;

import coedil99.model.Cliente;
import coedil99.model.Commessa;
import coedil99.model.Ordine;

/**
 * 
 * @author francesco
 * 
 *         Pannello che mostra i dettagli principali di una commessa in modo da
 *         rintracciarla velocemente
 */
@SuppressWarnings("serial")
public class CardCodiceInterno extends ACard {

	private JLabel scadenza;
	private JLabel codiceInterno;
	private JLabel cliente;
	private ListaCommesse riquadro = null;
	private int commessaId;

	public CardCodiceInterno(ListaCommesse rc) {
		super(rc);
		this.riquadro = rc;
		this.initialize();
	}
	

	public int getCommessaId() {
		return commessaId;
	}

	@Override
	/**
	 * Carica la Card attraverso una commessa
	 * @param obj:Object
	 */
	public void load(Object obj) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		ArrayList<Object> param = (ArrayList<Object>) obj;
		Cliente c = (Cliente) param.get(0);
		Ordine o = (Ordine) param.get(1);
		final Commessa cc = (Commessa) param.get(2);
		cliente.setText(c.getName());
		if (o.getDataScadenza() == null)
			scadenza.setText("--/--/----");
		else
			scadenza.setText(o.getDataScadenza().toString());
		codiceInterno.setText(cc.getCodiceInterno());
		this.commessaId = cc.getID();

		this.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				PlicoCommessa plico_commessa = PlicoCommessa.getInstance();
				CardCodiceInterno.this.riquadro.deselectAll();
				plico_commessa.load(CardCodiceInterno.this.commessaId);
				ProgrammaLavori contenitore = ProgrammaLavori.getInstance();
				contenitore.setCommessaSelezionata(cc);
				contenitore.getRaccoglitorePlichi().getPlico().removeAll();
				contenitore.getRaccoglitorePlichi().getPlico().validate();
				contenitore.getRaccoglitorePlichi().getPlico().repaint();
				contenitore.getRaccoglitorePlichi().getPlico().add(plico_commessa);

				contenitore.getClipPanel().resetInitialState();
				CardCodiceInterno.this.setBackground(new Color(30, 44, 255));
				CardCodiceInterno.this.validate();
				CardCodiceInterno.this.repaint();
				RaccoglitorePlichi.getInstance().getScrollPaneWrapper()
						.validate();
				RaccoglitorePlichi.getInstance().getScrollPaneWrapper()
						.repaint();

			}

		});

	}
	
	/**
	 * Imposta la grafica
	 */
	private void initialize() {
		setBounds(new Rectangle(0, 0, 0, 0));
		this.setPreferredSize(new Dimension(200, 59));
		this.setBackground(new Color(30, 144, 255));
		this.setBorder(new LineBorder(Color.BLACK));
		this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		setLayout(null);

		scadenza = new JLabel();
		scadenza.setHorizontalAlignment(SwingConstants.CENTER);
		scadenza.setHorizontalTextPosition(SwingConstants.LEADING);
		scadenza.setBounds(100, 30, 100, 30);
		scadenza.setBorder(new LineBorder(Color.BLACK));

		codiceInterno = new JLabel();
		codiceInterno.setHorizontalAlignment(SwingConstants.CENTER);
		codiceInterno.setBounds(0, 30, 100, 30);
		codiceInterno.setBorder(new LineBorder(Color.BLACK));

		cliente = new JLabel();
		cliente.setHorizontalAlignment(SwingConstants.CENTER);
		cliente.setHorizontalTextPosition(SwingConstants.CENTER);
		cliente.setBorder(new LineBorder(new Color(0, 0, 0)));
		cliente.setBounds(0, 0, 200, 30);

		add(cliente);
		add(scadenza);
		add(codiceInterno);

	}

}

package GUI.Riquadri;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;

import javax.swing.SwingConstants;

import GUI.Liste.ListaRDA;

import coedil99.controller.GestisciRDAHandler;
import coedil99.model.RDA;

public class RiquadroCodiceRDA extends JPanel {

	private ListaRDA riquadro = null;

	private JLabel id = null;
	private JLabel stato = null;
	private JLabel icona = null;
	private JLabel data = null;

	private static HashMap<String, ImageIcon> state_map;
	static {
		
		RiquadroCodiceRDA.state_map = new HashMap<String, ImageIcon>();
		
		RiquadroCodiceRDA.state_map.put(
				"CONGELATA",
				new ImageIcon(RiquadroCodiceRDA.class
						.getResource("/GUI/image/congelata.png")));
		
		RiquadroCodiceRDA.state_map.put(
				"RIFIUTATA",
				new ImageIcon(RiquadroCodiceRDA.class
						.getResource("/GUI/image/rifiutata.png")));
		
		RiquadroCodiceRDA.state_map.put(
				"ATTESA_CONFERMA",
				new ImageIcon(RiquadroCodiceRDA.class
						.getResource("/GUI/image/attesaconferma.png")));
		
		RiquadroCodiceRDA.state_map.put(
				"CONFERMATA",
				new ImageIcon(RiquadroCodiceRDA.class
						.getResource("/GUI/image/confermata.png")));
	}

	public RiquadroCodiceRDA(ListaRDA rda) {
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

	public void load(RDA rda) {
		//this.id.setText(rda.righeRDA.get(0).getDescription().getCatalogoFornitore().getName());
		this.stato.setText(rda.getState());
		this.icona.setIcon(RiquadroCodiceRDA.state_map.get(rda.getState()));
		//this.data.setText(rda.getDate().toString());
		this.setBackground(new Color(30, 44, 255));
		this.validate();
		this.repaint();
		this.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

		});

	}

	public int getRDAId() {
		return Integer.parseInt(this.id.getText());
	}

}
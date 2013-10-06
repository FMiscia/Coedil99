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

import coedil99.model.RDA;

public class RiquadroRDA extends JPanel {
	
	private RiquadroCodiceRDA riquadro = null;
	
	private JLabel id = null;
	private JLabel stato = null;
	private JLabel icona = null;
	
	private static HashMap<String, ImageIcon> state_map;
	static{
		state_map.put("CONGELATA", new ImageIcon(
				RiquadroDatiAziendali.class
				.getResource("/GUI/image/congelata.png")));
		state_map.put("RIFIUTATA", new ImageIcon(
				RiquadroDatiAziendali.class
				.getResource("/GUI/image/rifiutata.png"))); 
		state_map.put("ATTESA_CONFERMA", new ImageIcon(
				RiquadroDatiAziendali.class
				.getResource("/GUI/image/attesaconferma.png"))); 
		state_map.put("CONFERMATA", new ImageIcon(
				RiquadroDatiAziendali.class
				.getResource("/GUI/image/confermata.png")));
	}
	
	
	public RiquadroRDA(RiquadroCodiceRDA rda) {
		this.riquadro = rda;
		setBounds(new Rectangle(0, 0, 0, 0));
		this.setPreferredSize(new Dimension(200,59));
		this.setBackground(new Color(30, 144, 255));
		this.setBorder(new LineBorder(Color.BLACK));
		this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		setLayout(null);
		
		id = new JLabel();
		id.setHorizontalAlignment(SwingConstants.CENTER);
		id.setHorizontalTextPosition(SwingConstants.LEADING);
		id.setBounds(100, 30, 100, 30);
		id.setBorder(new LineBorder(Color.BLACK));
		
		stato = new JLabel();
		stato.setHorizontalAlignment(SwingConstants.CENTER);
		stato.setBounds(0, 30, 100, 30);
		stato.setBorder(new LineBorder(Color.BLACK));
		
		icona = new JLabel();
		icona.setHorizontalAlignment(SwingConstants.CENTER);
		icona.setHorizontalTextPosition(SwingConstants.CENTER);
		icona.setBorder(new LineBorder(new Color(0, 0, 0)));
		icona.setBounds(0, 0, 200, 30);
		
		add(id);
		add(stato);
		add(icona);
	}
	
	public void load(RDA rda){
		this.id.setText(String.valueOf(rda.getID()));
		this.stato.setText(rda.getState());
		this.icona.setIcon(RiquadroRDA.state_map.get(rda.getState()));
		
		this.addMouseListener(new MouseListener(){

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

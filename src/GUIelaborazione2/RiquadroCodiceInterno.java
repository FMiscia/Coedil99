package GUIelaborazione2;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;

public class RiquadroCodiceInterno extends JPanel {
	
	private JLabel scadenza;
	private JLabel codiceInterno;
	private JLabel cliente;
	
	public RiquadroCodiceInterno(){
		this.setSize(200,60);
		this.setBackground(Color.WHITE);
		this.setBorder(new LineBorder(Color.BLACK));
		setLayout(null);
		
		scadenza = new JLabel("13/12/2013");
		scadenza.setHorizontalAlignment(SwingConstants.CENTER);
		scadenza.setHorizontalTextPosition(SwingConstants.LEADING);
		scadenza.setBounds(125, 30, 75, 30);
		scadenza.setBorder(new LineBorder(Color.BLACK));
		
		codiceInterno = new JLabel("12-34-5678");
		codiceInterno.setHorizontalAlignment(SwingConstants.CENTER);
		codiceInterno.setBounds(125, 0, 75, 30);
		codiceInterno.setBorder(new LineBorder(Color.BLACK));
		
		
		cliente = new JLabel("Asdrubale");
		cliente.setBorder(new LineBorder(new Color(0, 0, 0)));
		cliente.setHorizontalAlignment(SwingConstants.CENTER);
		cliente.setBounds(0, 0, 125, 60);
		JButton b = new JButton();
		b.setBackground(new Color(30, 144, 255));
		b.setFocusPainted(false);
		b.setBorderPainted(false);
		b.setBounds(0, 0, 125, 60);
		b.setText(cliente.getText());
		b.setHorizontalTextPosition(SwingConstants.LEFT);
		
		//add(cliente);
		add(scadenza);
		add(codiceInterno);
		add(b);
				
	}

}

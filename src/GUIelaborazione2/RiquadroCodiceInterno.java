package GUIelaborazione2;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;

public class RiquadroCodiceInterno extends JPanel {
	
	private JLabel scadenza;
	private JLabel codiceInterno;
	private JLabel cliente;
	
	public RiquadroCodiceInterno(){
		this.setSize(200,70);
		this.setBackground(Color.WHITE);
		this.setBorder(new LineBorder(Color.BLACK));
		setLayout(null);
		
		scadenza = new JLabel("13/12/2013");
		scadenza.setHorizontalAlignment(SwingConstants.CENTER);
		scadenza.setHorizontalTextPosition(SwingConstants.LEADING);
		scadenza.setBounds(125, 0, 75, 30);
		scadenza.setBorder(new LineBorder(Color.BLACK));
		
		codiceInterno = new JLabel("12-34-5678");
		codiceInterno.setHorizontalAlignment(SwingConstants.CENTER);
		codiceInterno.setBounds(0, 0, 75, 30);
		codiceInterno.setBorder(new LineBorder(Color.BLACK));
		
		
		cliente = new JLabel("Asdrubale");
		cliente.setBorder(new LineBorder(new Color(0, 0, 0)));
		cliente.setHorizontalAlignment(SwingConstants.CENTER);
		cliente.setBounds(0, 30, 200, 40);
		
		
		add(cliente);
		add(scadenza);
		add(codiceInterno);
				
	}

}

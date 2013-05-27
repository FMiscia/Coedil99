package GUIelaborazione2;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import elaboradistinta.model.Cliente;
import elaboradistinta.model.Commessa;
import elaboradistinta.model.Ordine;
import java.awt.Rectangle;

@SuppressWarnings("serial")
public class RiquadroCodiceInterno extends JPanel {
	
	private JLabel scadenza;
	private JLabel codiceInterno;
	private JLabel cliente;
	
	public RiquadroCodiceInterno(){
		setBounds(new Rectangle(0, 0, 0, 0));
		this.setPreferredSize(new Dimension(200,59));
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
	
	public void load(Cliente c, Ordine o, Commessa cc){
		cliente.setText(c.getName());
		if(o.getDataScadenza() == null)
			scadenza.setText("--/--/----");
		else
			scadenza.setText(o.getDataScadenza().toString());
		codiceInterno.setText(cc.getCodiceInterno());
	}

}
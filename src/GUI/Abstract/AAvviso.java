package GUI.Abstract;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

public class AAvviso extends JPanel {
	
	protected JLabel avviso;
	protected JLabel avviso2;
	private JSeparator separator;
	
	public AAvviso() {
		super();
		setPreferredSize(new Dimension(290, 70));
		setSize(290,70);
		initialize();
	}

	private void initialize() {
		this.avviso = new JLabel();
		avviso.setFont(new Font("Tahoma", Font.BOLD, 24));
		this.add(avviso);
		
		this.avviso2 = new JLabel();
		avviso2.setFont(new Font("Tahoma", Font.BOLD, 24));
		this.add(avviso2);
		
		this.separator = new JSeparator();
		this.separator.setPreferredSize(new Dimension(200, 2));
		this.add(separator);
	}
	
	

}

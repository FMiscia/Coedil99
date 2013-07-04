package GUIelaborazione2.Riquadri;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public abstract class Riquadro extends JPanel {

	protected ArrayList<JTextField> Container;
	
	public Riquadro(String title) {
		super();
		this.Container = new ArrayList<JTextField>();
		setLayout(null);
		setPreferredSize(new Dimension(600, 200));
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(0, 20, 600, 2);
		add(separator);

		JLabel lblTitolo = new JLabel(title);
		lblTitolo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitolo.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblTitolo.setBounds(0, 1, 143, 20);
		add(lblTitolo);

	}

	public void makeEditable(boolean editable) {
		for (JTextField i : this.Container) {
			if(!editable)
				i.setBackground(Color.getColor("textInactiveText"));
			i.setEditable(editable);
		}
		this.validate();
		this.repaint();
	}
	

	public abstract void load(Object o);

}

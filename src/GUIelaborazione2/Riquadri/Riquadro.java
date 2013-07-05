package GUIelaborazione2.Riquadri;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public abstract class Riquadro extends JPanel {

	protected ArrayList<JTextField> Container;
	protected JButton modifica;
	protected boolean aperto;
	
	public Riquadro(String title) {
		super();
		this.aperto = true;
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
		
		
		this.modifica = new JButton("modifica");
		this.modifica.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(aperto){
					Riquadro.this.modifica.setText("salva modifica");
					aperto = false;
					Riquadro.this.makeEditable(true);
					//form.getParent().setSize(new Dimension(600,30));
				}
				else{
					Riquadro.this.modifica.setText("modifica");
					aperto = true;
					Riquadro.this.makeEditable(false);
					//form.getParent().setSize(new Dimension(600,290));
				}
				validate();
				repaint();
			}
		});
		this.modifica.setSize(131, 20);
		this.modifica.setLocation(469, 0);
		add(this.modifica);

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
	
	protected void resetRiquadro(){
		if(this.Container.size() != 0){
			for(JTextField txt: Container)
				txt.setText("");
		}
	}

}

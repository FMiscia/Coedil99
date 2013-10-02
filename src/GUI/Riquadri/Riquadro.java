package GUI.Riquadri;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
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
	protected Object oggetto;
	protected ArrayList<JLabel> Label;
	protected ImageIcon IcoErrore = new ImageIcon(
			RiquadroDatiAziendali.class
					.getResource("/GUI/image/cancel.png"));
	protected ImageIcon IcoOk = new ImageIcon(
			RiquadroDatiAziendali.class
					.getResource("/GUI/image/ok.png"));
	protected JLabel lblTitolo;

	public Riquadro(String title) {
		super();
		this.aperto = true;
		this.oggetto = null;
		this.Container = new ArrayList<JTextField>();
		this.Label = new ArrayList<JLabel>();
		setLayout(null);
		setSize(600, 330);
		setPreferredSize(new Dimension(600, 280));
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(0, 20, 600, 2);
		add(separator);

		lblTitolo = new JLabel(title);
		lblTitolo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitolo.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblTitolo.setBounds(0, 1, 143, 20);
		add(lblTitolo);

		this.modifica = new JButton("modifica");
		this.modifica.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (aperto) {
					Riquadro.this.modifica.setText("salva");
					aperto = false;
					Riquadro.this.makeEditable(true);
					// form.getParent().setSize(new Dimension(600,30));
				} else {
					Riquadro.this.salva();
					Riquadro.this.modifica.setText("modifica");
					aperto = true;
					Riquadro.this.makeEditable(false);
					// form.getParent().setSize(new Dimension(600,290));
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
			if (!editable) {
				i.setBackground(Color.getColor("textInactiveText"));
				i.setBorder(new LineBorder(Color.gray));
				Riquadro.this.modifica.setText("modifica");
				aperto = true;
			} else {
				Riquadro.this.modifica.setText("salva");
				//controlloErrori();
				aperto = false;
			}
			i.setEditable(editable);
		}
		for (JLabel j : this.Label) {
			if (!editable) {
				j.setVisible(false);
			} else {
				j.setVisible(true);
			}
		}
		this.validate();
		this.repaint();
	}

	public void avoidEditing() {
		this.modifica.setEnabled(false);
		for (MouseListener al : Riquadro.this.modifica.getMouseListeners()) {
			Riquadro.this.modifica.removeMouseListener(al);
		}
		this.validate();
		this.repaint();
	}

	public void enableEditing() {
		this.modifica.setEnabled(true);
		this.modifica.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (aperto) {
					Riquadro.this.modifica.setText("salva");
					aperto = false;
					Riquadro.this.makeEditable(true);
					// form.getParent().setSize(new Dimension(600,30));
				} else {
					Riquadro.this.salva();
					Riquadro.this.modifica.setText("modifica");
					aperto = true;
					Riquadro.this.makeEditable(false);
					// form.getParent().setSize(new Dimension(600,290));
				}
			}
		});
		validate();
		repaint();
	}

	public abstract void load(Object o);

	protected void resetRiquadro() {
		if (this.Container.size() != 0) {
			for (JTextField txt : Container)
				txt.setText("");
		}
	}

	protected abstract void salva();

	public void controlloErrori() {
		boolean test = true;
		for (JLabel j : this.Label) {
			if (j.getIcon() != null && j.getIcon().equals(IcoErrore))
				test = false;
		}
		if (test) {
			enableEditing();
		} else {
			avoidEditing();
		}
	}

}

package GUI.Abstract;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.orm.PersistentException;

import coedil99.model.RDA;

import GUI.RDACenter;
import GUI.WrapLayout;

/**
 * @author francesco
 * 
 */
public abstract class ALista extends JScrollPane {

	private static final long serialVersionUID = 1L;

	protected JPanel panel;
	protected JPanel panelTitle = new JPanel(new GridBagLayout());
	protected JLabel labeltitle = new JLabel("Lista Righe RDA");
	protected JLabel labelprezzo = new JLabel("Prezzo RDA:");
	protected JButton btnSalva = new JButton("Salva RDA");

	public ALista() {
		this.panel = new JPanel(null);
		this.setViewportView(this.panel);
		this.panel.setLayout(new WrapLayout());
		this.btnSalva.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Object[] options = { "Ok", "Cancel" };
					RDACenter.getInstance().getRDASelezionata().save();
					JOptionPane
							.showMessageDialog(
									null,
									"RDA salvata con successo!\n",
									"Conferma operazione",
									JOptionPane.PLAIN_MESSAGE);

				} catch (PersistentException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}

	public void deselectAll() {
		// TODO Auto-generated method stub
		for (Component c : panel.getComponents()) {
			c.setBackground(new Color(30, 144, 255));
			c.validate();
			c.repaint();
		}
	}

	public JPanel getPanel() {
		return this.panel;
	}

	public abstract void load(ArrayList<Object> t);

	/**
	 * @author francesco Aggiorna posizione e valore di Titolo e Prezzo delle
	 *         righe RDA
	 */
	public void updateTitlePanel() {
		this.panelTitle.removeAll();
		panelTitle.setSize(new Dimension(200, 90));
		panelTitle.setPreferredSize(new Dimension(200, 90));
		panel.add(panelTitle, 0);
		panelTitle.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panelTitle.add(labeltitle);
		panelTitle.add(labelprezzo);
		JLabel prezzo = new JLabel("0.0");
		panelTitle.add(prezzo);
		this.btnSalva.setPreferredSize(new Dimension(120, 30));
		panelTitle.add(btnSalva);
		this.validate();
		this.repaint();

	}
	
	public void svuota(){
		this.panel.removeAll();
		this.validate();
		this.repaint();
	}

}

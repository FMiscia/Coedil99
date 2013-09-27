package GUIelaborazione2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JPanel;


import GUIelaborazione2.Riquadri.RiquadroDatiDistinta;
import javax.swing.SwingConstants;

import coedil99.controller.GestisciCommessaHandler;
import coedil99.model.Distinta;
import coedil99.model.RigaLavoro;

public class PlicoDistinta extends Plico {

	private static PlicoDistinta instance = null;
	private JButton addButton = null;
	private int formCounter;
	private ArrayList<RiquadroDatiDistinta> riquadri = new ArrayList<RiquadroDatiDistinta>();

	private PlicoDistinta() {
		setBorder(null);
		WrapLayout wrapLayout = new WrapLayout();
		wrapLayout.setVgap(20);
		wrapLayout.setHgap(0);
		setLayout(wrapLayout);

		setPreferredSize(new Dimension(745, 1000));
		setSize(745, 950);
		addButton = new JButton("aggiungi nuova");
		this.validate();
		this.repaint();
	}

	@Override
	public void load() {
		// TODO Auto-generated method stub

	}

	public static PlicoDistinta getInstance() {
		if (PlicoDistinta.instance == null)
			PlicoDistinta.instance = new PlicoDistinta();
		return PlicoDistinta.instance;
	}

	@Override
	public void load(int id) {
		// TODO Auto-generated method stub
		this.removeAll();
		RiquadroDatiDistinta temp = null;
		Distinta d = (Distinta) GestisciCommessaHandler.getInstance()
				.getCommessaById(id).getDistinta();
		if (d != null && d.getLavori().size() != 0) {
			for (int i = 0; i < d.getLavori().size(); i++) {
				temp = new RiquadroDatiDistinta("Riga Lavoro");
				temp.load(d.getLavori().get(i));
				temp.setLocation(40, 20 * (i + 1));
				this.add(temp);
				this.riquadri.add(temp);
			}
		} else {
			temp = new RiquadroDatiDistinta("Riga Lavoro");
			temp.makeEditable(true);
			temp.setLocation(40, 20);
			this.add(temp);
			this.riquadri.add(temp);
		}
		if (!ProgrammaLavori.getInstance().getCommessaSelezionata().getODistinta()
				.hasDdo()) {
			addButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					// TODO Auto-generated method stub
					RiquadroDatiDistinta temp = new RiquadroDatiDistinta(
							"Riga Lavoro");
					temp.makeEditable(true);
					PlicoDistinta.this.add(temp);
					PlicoDistinta.this.riquadri.add(temp);
					PlicoDistinta.this.posizionaAddButton();
				}
			});
		}
		this.add(addButton);
		this.aggiornaAltezze();
		addButton.setPreferredSize(new Dimension(160, 20));
		if (ProgrammaLavori.getInstance().getCommessaSelezionata().getODistinta()
				.hasDdo()){
			for(RiquadroDatiDistinta r: riquadri){
				r.avoidEditing();
				addButton.setEnabled(false);
			}
		}
		else {
			for(RiquadroDatiDistinta r: riquadri){
				addButton.setEnabled(true);
			}
		}
		this.validate();
		this.repaint();
	}

	private void aggiornaAltezze() {
		this.setPreferredSize(new Dimension(this.getWidth(),
				RiquadroDatiDistinta.getFormDimension().height
						* (this.getComponentCount())));
		this.setSize(
				this.getWidth(),
				RiquadroDatiDistinta.getFormDimension().height
						* (this.getComponentCount()));

	}
	
	public void removeRiquadro(RiquadroDatiDistinta r){
		this.remove(r);
		this.riquadri.remove(r);
	}
	
	public void posizionaAddButton(){
		this.remove(addButton);
		this.add(addButton);
		this.aggiornaAltezze();
		this.validate();
		this.repaint();
	}
	

}

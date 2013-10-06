package GUI.Plichi;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JButton;

import GUI.WrapLayout;
import GUI.Abstract.APlico;
import GUI.Riquadri.RiquadroRigaRDA;

public class PlicoRDA extends APlico {

	private static PlicoRDA instance = null;
	private JButton addButton = null;
	private ArrayList<RiquadroRigaRDA> riquadri = new ArrayList<RiquadroRigaRDA>();

	private PlicoRDA() {
		System.out.println("creato plicorda");
		setBorder(null);
		WrapLayout wrapLayout = new WrapLayout();
		wrapLayout.setVgap(20);
		wrapLayout.setHgap(0);
		setLayout(wrapLayout);

		setPreferredSize(new Dimension(745, 1000));
		setSize(745, 950);
		this.setBackground(new Color(0,0,0));
		addButton = new JButton("aggiungi nuova");
		this.add(addButton);
		this.validate();
		this.repaint();
	}

	@Override
	public void load() {
		// TODO Auto-generated method stub

	}

	public static PlicoRDA getInstance() {
		if (PlicoRDA.instance == null)
			PlicoRDA.instance = new PlicoRDA();
		return PlicoRDA.instance;
	}

	@Override
	public void load(int id) {
		// TODO Auto-generated method stub
	}

	private void aggiornaAltezze() {
	}
	
	public void removeRiquadro(RiquadroRigaRDA r){
		this.remove(r);
		this.riquadri.remove(r);
	}
	
	public void posizionaAddButton(){
		this.aggiornaAltezze();
		this.remove(addButton);
		this.add(addButton);
		this.validate();
		this.repaint();
	}
	
	public void addRiquadroinLista(RiquadroRigaRDA r){
		this.riquadri.add(r);
	}
	
	public ArrayList<RiquadroRigaRDA> getRiquadri() {
		return riquadri;
	}
}

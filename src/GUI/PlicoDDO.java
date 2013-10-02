package GUI;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;

import GUI.Riquadri.RiquadroOttimizzazione;
import coedil99.controller.GestisciCommessaHandler;
import coedil99.model.Commessa;
import coedil99.model.DocumentoOttimizzazione;



@SuppressWarnings("serial")
public class PlicoDDO extends Plico{

	private RiquadroOttimizzazione ro;
	private static PlicoDDO instance = null;
	private JPanel panel;
	
	
	private PlicoDDO(){
		setBorder(null);
		setLayout(null);
		panel = new JPanel(null);
		panel.setLayout(new FlowLayout());
		panel.setPreferredSize(new Dimension(800,900));
		panel.setBounds(60, 20,625,938);
		setPreferredSize(new Dimension(745,panel.getHeight()));
		setSize(745,panel.getHeight());
		add(panel);
	}

	@Override
	public void load() {
		// TODO Auto-generated method stub
		
	}


	
	
	public static PlicoDDO getInstance(){
		if(PlicoDDO.instance == null)
			PlicoDDO.instance = new PlicoDDO();
		return PlicoDDO.instance;
	}

	public void load(int id) {
		// TODO Auto-generated method stub
		Commessa c = GestisciCommessaHandler.getInstance().getCommessaById(id);
		DocumentoOttimizzazione docott = GestisciCommessaHandler.getInstance().getCommessaById(id).getDistinta().getDdo();
		this.panel.removeAll();
		this.panel.setPreferredSize(new Dimension ( 800, docott.items.size()*600 ));
		this.setPreferredSize(new Dimension ( 800, this.panel.getHeight()));
		this.setSize(new Dimension ( 800, this.panel.getHeight()));
		for (int i = 0; i < docott.items.size(); i++){
			ro = new RiquadroOttimizzazione("Ottimizzazione");
			ro.load( c.getDistinta().getDdo().items.toArray()[i] );
			this.panel.add(ro);
		}
	}
}
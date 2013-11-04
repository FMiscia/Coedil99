package GUI.Plichi;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import GUI.CoedilFrame;
import GUI.ProgrammaLavori;
import GUI.RaccoglitorePlichi;
import GUI.Abstract.APlico;
import GUI.Abstract.ARiquadro;
import GUI.Riquadri.RiquadroDatiDistinta;
import GUI.Riquadri.RiquadroDatiDistintaFactory;
import GUI.Utilities.WrapLayout;
import coedil99.controller.GestisciCommessaHandler;
import coedil99.model.MDistinta;
import coedil99.persistentmodel.Distinta;

/**
 * 
 * @author francesco
 *
 * Gestisce il pannello della distinta
 */
public class PlicoDistinta extends APlico {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static PlicoDistinta instance = null;
	private JButton addButton ;
	private JPanel panelAddButton;
	private ArrayList<RiquadroDatiDistinta> riquadri = new ArrayList<RiquadroDatiDistinta>();

	/**
	 * Costruttore
	 */
	private PlicoDistinta() {
		this.initialize();
	}

	@Override
	public void load() {
		// TODO Auto-generated method stub

	}

	/**
	 * Singleton
	 * @return instance:PlicoDistinta
	 */
	public static PlicoDistinta getInstance() {
		if (PlicoDistinta.instance == null)
			PlicoDistinta.instance = new PlicoDistinta();
		return PlicoDistinta.instance;
	}

	@Override
	/**
	 * Carica il riquadro della distinta
	 * @param id:commessaId
	 */
	public void load(int id) {
		int bounds = (CoedilFrame.getInstance().getBounds().width/6);
		this.removeAll();
		RiquadroDatiDistinta temp = null;
		MDistinta d = new MDistinta(GestisciCommessaHandler.getInstance()
				.getCommessaById(id).getPersistentModel().getDistinta().getID());
		if (d != null && d.getPersistentModel().lavori.size() != 0) {
			for (int i = 0; i < d.getPersistentModel().lavori.size(); i++) {
				temp = new RiquadroDatiDistinta("Riga Lavoro");
				temp.load(d.getPersistentModel().lavori.get(i));
				temp.setLocation(bounds, 20 * (i + 1));
				this.add(temp);
				this.riquadri.add(temp);
				temp.makeEditable(false);
			}
		} else {
			temp =  (RiquadroDatiDistinta) RiquadroDatiDistintaFactory.getInstance().makeRiquadro();
			temp.makeEditable(true);
			this.add(temp);
			this.riquadri.add(temp);
		}
		MDistinta odistinta = new MDistinta(ProgrammaLavori.getInstance().getCommessaSelezionata().getPersistentModel().getDistinta().getID());
		if (!odistinta.hasDdo()) {
			MouseListener[] arrML = addButton.getMouseListeners();
			if (arrML.length == 1){
				addButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						RiquadroDatiDistinta temp = (RiquadroDatiDistinta) RiquadroDatiDistintaFactory.getInstance().makeRiquadro();
						temp.makeEditable(true);
						PlicoDistinta.this.add(temp);
						PlicoDistinta.this.posizionaAddButton();
						RaccoglitorePlichi.getInstance().validate();
						RaccoglitorePlichi.getInstance().repaint();
					}
				});	
			}
		}
		panelAddButton.add(addButton);
		this.add(panelAddButton);
		this.aggiornaAltezze();
		if (odistinta.hasDdo()){
			for(RiquadroDatiDistinta r: riquadri){
				r.avoidEditing(true);
				addButton.setEnabled(false);
			}
		}
		else {
			for(@SuppressWarnings("unused") RiquadroDatiDistinta r: riquadri){
				addButton.setEnabled(true);
			}
		}
		this.validate();
		this.repaint();
	}

	/**
	 * Aggiorna l'altezza del pannello
	 */
	private void aggiornaAltezze() {
		this.setPreferredSize(new Dimension(this.getWidth(),
				RiquadroDatiDistinta.getFormDimension().height
						* (this.getComponentCount())));
		this.setSize(
				this.getWidth(),
				RiquadroDatiDistinta.getFormDimension().height
						* (this.getComponentCount()));
		RaccoglitorePlichi.getInstance().getScrollPaneWrapper().validate();
		RaccoglitorePlichi.getInstance().getScrollPaneWrapper().repaint();
	}
	
	public void removeRiquadro(RiquadroDatiDistinta r){
		this.remove(r);
		this.riquadri.remove(r);
	}
	
	/**
	 * Posiziona il bottone per aggiungere un nuovo riquadro distinta
	 */
	public void posizionaAddButton(){
		this.aggiornaAltezze();
		this.remove(panelAddButton);
		this.add(panelAddButton);
		this.validate();
		this.repaint();
	}
	
	public void addRiquadroinLista(RiquadroDatiDistinta r){
		this.riquadri.add(r);
	}
	
	public ArrayList<RiquadroDatiDistinta> getRiquadri() {
		return riquadri;
	}
	
	/**
	 * Imposta la grafica
	 */
	private void initialize(){
		int x = (CoedilFrame.getInstance().getBounds().width/6);
		this.setLayout(new WrapLayout(0, x, 20));
		setBounds(0, 30,745,x);
		this.panelAddButton = new JPanel();
		this.panelAddButton.setBackground(new Color(240,240,240));
		this.panelAddButton.setLayout(new FlowLayout(FlowLayout.CENTER));
		panelAddButton.setPreferredSize(new Dimension(600,50));
		addButton = new JButton("aggiungi nuova");
		panelAddButton.add(addButton);
		this.validate();
		this.repaint();
		
	}

	public ArrayList<ARiquadro> isModifying() {
		ArrayList<ARiquadro> modifica = new ArrayList<ARiquadro>(); 
		for(ARiquadro a :this.riquadri){
			if(!a.modify())
				modifica.add(a);
		}
		return modifica;
	}
}

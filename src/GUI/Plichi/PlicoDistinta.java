package GUI.Plichi;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import GUI.ProgrammaLavori;
import GUI.RaccoglitorePlichi;
import GUI.Abstract.APlico;
import GUI.Abstract.ARiquadro;
import GUI.Riquadri.RiquadroDatiDistinta;
import GUI.Riquadri.RiquadroDatiDistintaFactory;
import GUI.Utilities.WrapLayout;
import coedil99.controller.GestisciCommessaHandler;
import coedil99.model.Distinta;

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
		int bounds = 200;
		this.removeAll();
		RiquadroDatiDistinta temp = null;
		Distinta d = (Distinta) GestisciCommessaHandler.getInstance()
				.getCommessaById(id).getDistinta();
		if (d != null && d.getLavori().size() != 0) {
			for (int i = 0; i < d.getLavori().size(); i++) {
				temp = new RiquadroDatiDistinta("Riga Lavoro");
				temp.load(d.getLavori().get(i));
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
		if (!ProgrammaLavori.getInstance().getCommessaSelezionata().getOdistinta()
				.hasDdo()) {
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
		this.add(addButton);
		this.aggiornaAltezze();
		//addButton.setPreferredSize(new Dimension(160, 20));
		if (ProgrammaLavori.getInstance().getCommessaSelezionata().getOdistinta()
				.hasDdo()){
			for(RiquadroDatiDistinta r: riquadri){
				r.avoidEditing();
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
		this.remove(addButton);
		this.add(addButton);
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
		int bounds = 200;
		this.setLayout(new WrapLayout(0, 200, 20));
		setBounds(bounds, 30,745,200);
		addButton = new JButton("aggiungi nuova");
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

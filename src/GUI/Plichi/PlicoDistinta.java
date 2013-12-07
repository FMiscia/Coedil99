package GUI.Plichi;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JLabel;

import GUI.CoedilFrame;
import GUI.RaccoglitorePlichi;
import GUI.Abstract.APlico;
import GUI.Form.FormDistinta;
import GUI.Liste.ListaRigheLavoro;
import GUI.Liste.ListaRigheLavoroFactory;
import coedil99.controller.GestisciCommessaHandler;
import coedil99.model.MDistinta;
import coedil99.model.MRigaLavoro;

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
	private FormDistinta riquadroRigaLavoro;
	private ArrayList<FormDistinta> riquadri = new ArrayList<FormDistinta>();
	private ListaRigheLavoro listaRigheLavoro;

	/**
	 * Costruttore
	 */
	private PlicoDistinta() {
		this.initialize();
	}

	@Override
	public void load() {
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
		//this.panelAddButton.removeAll();
		MDistinta d = new MDistinta(GestisciCommessaHandler.getInstance()
				.getCommessaById(id).getPersistentModel().getDistinta().getID());
		this.listaRigheLavoro.load(new ArrayList<Object>(d.getPersistentModel().lavori.getCollection()));
//		if (d != null && d.getPersistentModel().lavori.size() != 0) {
//			for (int i = 0; i < d.getPersistentModel().lavori.size(); i++) {
//				temp = new RiquadroDatiDistinta("Riga Lavoro");
//				temp.load(d.getPersistentModel().lavori.get(i));
//				temp.setLocation(bounds, 20 * (i + 1));
//				this.add(temp);
//				this.riquadri.add(temp);
//				//temp.makeEditable(false);
//			}
//		}if (!d.hasDdo()) {
//			MouseListener[] arrML = addButton.getMouseListeners();
//			if (arrML.length == 1){
//				addButton.addMouseListener(new MouseAdapter() {
//					@Override
//					public void mouseClicked(MouseEvent arg0) {
//						RiquadroDatiDistinta temp = (RiquadroDatiDistinta) RiquadroDatiDistintaFactory.getInstance().makeRiquadro();
//						temp.makeEditable(true);
//						PlicoDistinta.this.add(temp);
//						PlicoDistinta.this.posizionaAddButton();
//						RaccoglitorePlichi.getInstance().validate();
//						RaccoglitorePlichi.getInstance().repaint();
//					}
//				});	
//			}
//		}
//		panelAddButton.add(addButton);
//		//this.add(panelAddButton);
//		this.aggiornaAltezze();
//		if (d.hasDdo()){
//			for(RiquadroDatiDistinta r: riquadri){
//				r.avoidEditing(true);
//				addButton.setVisible(false);
//			}
//		}
//		else {
//			for(RiquadroDatiDistinta r: riquadri){
//				addButton.setVisible(true);
//			}
//		}
		this.validate();
		this.repaint();
	}

	/**
	 * Aggiorna l'altezza del pannello
	 */
	private void aggiornaAltezze() {
		this.setPreferredSize(new Dimension(this.getWidth(),
				FormDistinta.getFormDimension().height
						* (this.getComponentCount())));
		this.setSize(
				this.getWidth(),
				FormDistinta.getFormDimension().height
						* (this.getComponentCount()));
		RaccoglitorePlichi.getInstance().getScrollPaneWrapper().validate();
		RaccoglitorePlichi.getInstance().getScrollPaneWrapper().repaint();
	}
	
	public void removeRiquadro(FormDistinta r){
		this.remove(r);
		this.riquadri.remove(r);
	}
	
	/**
	 * Posiziona il bottone per aggiungere un nuovo riquadro distinta
	 */
	public void posizionaAddButton(){
		this.aggiornaAltezze();
		//this.remove(panelAddButton);
		//this.add(panelAddButton);
		this.validate();
		this.repaint();
	}
	
	public void addRiquadroinLista(FormDistinta r){
		this.riquadri.add(r);
	}
	
	public ArrayList<FormDistinta> getRiquadri() {
		return riquadri;
	}
	
	/**
	 * Imposta la grafica
	 */
	private void initialize(){
		this.setLayout(new BorderLayout());
		this.addListaRigheLavoro();
		/*int x = (CoedilFrame.getInstance().getBounds().width/6);
		this.setLayout(new WrapLayout(0, x, 20));
		this.panelAddButton = new JPanel();
		this.panelAddButton.setLayout(new FlowLayout(FlowLayout.CENTER));
		panelAddButton.setPreferredSize(new Dimension(600,50));
		addButton = new JButton("aggiungi nuova");
		panelAddButton.add(addButton);
		this.validate();
		this.repaint();*/
	}

	public boolean isModifying() {
		boolean result = false;
		for(FormDistinta temp: this.riquadri){
			for (JLabel j : temp.getLabel()) {
				if (j.getIcon()!=null)
					result = true;
				temp.svuotaIconeLAbel();
			}
		}
		return result;
	}
	
	/**
	 * Metodo che aggiunge la lista righe lavoro
	 */
	private void addListaRigheLavoro(){
		this.listaRigheLavoro = (ListaRigheLavoro) ListaRigheLavoroFactory.getInstance().makeLista();
		this.add(listaRigheLavoro,BorderLayout.WEST);
	}
	
	/**
	 * Metodo che aggiunge il riquadro contenente le informazioni circa la riga lavoro nel plico
	 * @param r MRigaLavoro
	 */
	public void addRiquadroRigaLavoro(MRigaLavoro r){
		this.riquadroRigaLavoro = new FormDistinta();
		this.riquadroRigaLavoro.load(r.getPersistentModel());
		this.add(this.riquadroRigaLavoro,BorderLayout.EAST);
		this.validate();
		this.repaint();
	}
	
}

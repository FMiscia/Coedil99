package GUI.Plichi;

import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;

import GUI.CoedilFrame;
import GUI.Abstract.APlico;
import GUI.Abstract.ARiquadro;
import GUI.Riquadri.RiquadroDatiAziendali;
import GUI.Riquadri.RiquadroDatiAziendaliFactory;
import GUI.Riquadri.RiquadroDatiClienteConsegna;
import GUI.Riquadri.RiquadroDatiClienteConsegnaFactory;
import GUI.Riquadri.RiquadroDatiConsegna;
import GUI.Riquadri.RiquadroDatiConsegnaFactory;
import GUI.Riquadri.RiquadroDatiProduzioneConsegna;
import GUI.Riquadri.RiquadroDatiProduzioneConsegnaFactory;
import GUI.Riquadri.RiquadroDatiSviluppoConsegna;
import GUI.Riquadri.RiquadroDatiSviluppoConsegnaFactory;
import coedil99.controller.GestisciClienteHandler;
import coedil99.controller.GestisciCommessaHandler;
import coedil99.controller.GestisciOrdineHandler;
import coedil99.model.MCliente;
import coedil99.model.MCommessa;
import coedil99.model.MOrdine;
import coedil99.persistentmodel.Cliente;
import coedil99.persistentmodel.Commessa;
import coedil99.persistentmodel.Ordine;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

@SuppressWarnings("serial")
/**
 * 
 * @author francesco
 * Gestisce il pannello che si occupa di contenere 
 * i riquadri della commess
 */
public class PlicoCommessa extends APlico {

	private RiquadroDatiClienteConsegna rdcc;
	private RiquadroDatiAziendali rda;
	private RiquadroDatiConsegna rdc;
	private RiquadroDatiProduzioneConsegna rdpc;
	private RiquadroDatiSviluppoConsegna rsc;
	private ArrayList<ARiquadro> container;
	private static PlicoCommessa instance = null;

	/**
	 * Costruttore
	 */
	private PlicoCommessa() {
		this.initialize();
	}

	@Override
	public void load() {

	}

	@Override
	/**
	 * Carica i riquadri
	 * @param id:idCommessa
	 */
	public void load(int id) {
		this.reset();
		MCommessa c = GestisciCommessaHandler.getInstance().getCommessaById(id);
		MOrdine o = GestisciOrdineHandler.getInstance().getMOrdineById(
				c.getPersistentModel().getOrdine().getID());
		MCliente cl = GestisciClienteHandler.getInstance().getClienteById(
				o.getPersistentModel().getCliente().getID());
		rda.load(c);
		rdcc.load(cl);
		rdc.load(c);
		rdpc.load(o);
		rsc.load(c);
	}

	/**
	 * Posiziona i riquadri nel plico
	 */
	private void posizionaRiquadri() {
		int bounds = (CoedilFrame.getInstance().getBounds().width/6);
		rda.setBounds(bounds, 20, rda.getWidth(), rda.getHeight());
		rdcc.setBounds(bounds, rda.getY() + rda.getHeight() + 20, rdcc.getWidth(),
				rdcc.getHeight());
		rdc.setBounds(bounds, rdcc.getY() + rdcc.getHeight() + 20, rdc.getWidth(),
				rdc.getHeight());
		rdpc.setBounds(bounds, rdc.getY() + rdc.getHeight() + 20, rdpc.getWidth(),
				rdpc.getHeight());
		rsc.setBounds(bounds, rdpc.getY() + rdpc.getHeight() + 20, rsc.getWidth(),
				rsc.getHeight());
		validate();
		repaint();

	}

	/**
	 * Imposta la grafica 
	 */
	private void initialize() {
		setBorder(null);
		setLayout(null);
		container = new ArrayList<ARiquadro>();
		rda = (RiquadroDatiAziendali) RiquadroDatiAziendaliFactory
				.getInstance().makeRiquadro();
		
		rda.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				posizionaRiquadri();
			}
		});
		rdcc = (RiquadroDatiClienteConsegna) RiquadroDatiClienteConsegnaFactory
				.getInstance().makeRiquadro();
		rdc = (RiquadroDatiConsegna) RiquadroDatiConsegnaFactory.getInstance()
				.makeRiquadro();
		rdpc = (RiquadroDatiProduzioneConsegna) RiquadroDatiProduzioneConsegnaFactory
				.getInstance().makeRiquadro();
		rsc = (RiquadroDatiSviluppoConsegna) RiquadroDatiSviluppoConsegnaFactory
				.getInstance().makeRiquadro();
		posizionaRiquadri();
		setPreferredSize(new Dimension(745, 1110));
		setSize(745, 950);
		add(rda);
		this.container.add(rda);
		add(rdcc);
		this.container.add(rdcc);
		rdcc.setLayout(new FormLayout(new ColumnSpec[] {}, new RowSpec[] {}));
		add(rdc);
		this.container.add(rdc);
		add(rdpc);
		this.container.add(rdpc);
		add(rsc);
		this.container.add(rsc);
	}

	/**
	 * Singleton
	 * @return instance:PlicoCommessa
	 */
	public static PlicoCommessa getInstance() {
		if (PlicoCommessa.instance == null)
			PlicoCommessa.instance = new PlicoCommessa();
		return PlicoCommessa.instance;
	}
	
	@Override
	/**
	 * Metodo che controlla se è in corso una modifica dei riquadri
	 * 
	 * @return modifica: array list contenente i riquadri in modifica
	 */
	public ArrayList<ARiquadro> isModifying(){
		ArrayList<ARiquadro> modifica = new ArrayList<ARiquadro>(); 
		for(ARiquadro a :this.container){
			if(!a.modify())
				modifica.add(a);
		}
		return modifica;
	}
	
	public void reset(){
		this.rda.makeEditable(false);
		this.rdc.makeEditable(false);
		this.rdcc.makeEditable(false);
		this.rdpc.makeEditable(false);
		this.rsc.makeEditable(false);
	}

}

package GUI.Plichi;

import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import GUI.Abstract.APlico;
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
import coedil99.model.Cliente;
import coedil99.model.Commessa;
import coedil99.model.Ordine;

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
		Commessa c = GestisciCommessaHandler.getInstance().getCommessaById(id);
		Ordine o = GestisciOrdineHandler.getInstance().getOrdineById(
				c.getOrdineId());
		Cliente cl = GestisciClienteHandler.getInstance().getClienteById(
				o.getCliente().getID());
		rda.load(c);
		rdcc.load(cl);
		rdc.load(c);
		rdpc.load(o);
		rsc.load(c);
	}

	/**
	 * Posiziona i riquadri nel pannello
	 */
	private void posizionaRiquadri() {
		rda.setBounds(0, 0, rda.getWidth(), rda.getHeight());
		rdcc.setBounds(0, rda.getY() + rda.getHeight() + 20, rdcc.getWidth(),
				rdcc.getHeight());
		rdc.setBounds(0, rdcc.getY() + rdcc.getHeight() + 20, rdc.getWidth(),
				rdc.getHeight());
		rdpc.setBounds(0, rdc.getY() + rdc.getHeight() + 20, rdpc.getWidth(),
				rdpc.getHeight());
		rsc.setBounds(0, rdpc.getY() + rdpc.getHeight() + 20, rsc.getWidth(),
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
		add(rdcc);
		rdcc.setLayout(new FormLayout(new ColumnSpec[] {}, new RowSpec[] {}));
		add(rdc);
		add(rdpc);
		add(rsc);
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
}
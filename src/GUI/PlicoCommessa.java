package GUI;
import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import GUI.Riquadri.RiquadroDatiAziendali;
import GUI.Riquadri.RiquadroDatiClienteConsegna;
import GUI.Riquadri.RiquadroDatiConsegna;
import GUI.Riquadri.RiquadroDatiProduzioneConsegna;
import GUI.Riquadri.RiquadroDatiSviluppoConsegna;
import coedil99.controller.GestisciClienteHandler;
import coedil99.controller.GestisciCommessaHandler;
import coedil99.controller.GestisciOrdineHandler;
import coedil99.model.Cliente;
import coedil99.model.Commessa;
import coedil99.model.Ordine;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;


@SuppressWarnings("serial")
public class PlicoCommessa extends Plico{

	private RiquadroDatiClienteConsegna rdcc;
	private RiquadroDatiAziendali rda;
	private RiquadroDatiConsegna rdc;
	private RiquadroDatiProduzioneConsegna rdpc;
	private RiquadroDatiSviluppoConsegna rsc;
	private static PlicoCommessa instance = null;
	
	
	
	private PlicoCommessa(){
		setBorder(null);
		setLayout(null);
		
		rda = new RiquadroDatiAziendali("Dati Aziendali");

		rda.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				posizionaRiquadri();
			}
		});
		rdcc = new RiquadroDatiClienteConsegna("Dati Consegna Cliente");
		rdc = new RiquadroDatiConsegna("Dati Consenga");
		rdpc = new RiquadroDatiProduzioneConsegna("Dati Consegna Produzione");
		rsc = new RiquadroDatiSviluppoConsegna("Dati Sviluppo Consegna");
		posizionaRiquadri();
		setPreferredSize(new Dimension(745, 1110));
		setSize(745,950);
		add(rda);
		add(rdcc);
		rdcc.setLayout(new FormLayout(new ColumnSpec[] {},
			new RowSpec[] {}));
		add(rdc);
		add(rdpc);
		add(rsc);
	}

	@Override
	public void load() {

		
	}

	@Override
	public void load(int id) {
		Commessa c = GestisciCommessaHandler.getInstance().getCommessaById(id);
		Ordine o = GestisciOrdineHandler.getInstance().getOrdineById(c.getOrdineId());
		Cliente cl = GestisciClienteHandler.getInstance().getClienteById(o.getCliente().getID());
		rda.load(c);
		rdcc.load(cl);
		rdc.load(c);
		rdpc.load(o);
		rsc.load(c);
	}
	
	private int calcolaAltezza(){
		return rda.getHeight()+rdcc.getHeight()+rdc.getHeight()+rdpc.getHeight()+rsc.getHeight()+100;
	}
	
	private void posizionaRiquadri(){
		rda.setBounds(40, 20,rda.getWidth(),rda.getHeight());
		rdcc.setBounds(40, rda.getY()+rda.getHeight()+20, rdcc.getWidth(), rdcc.getHeight());
		rdc.setBounds(40, rdcc.getY()+rdcc.getHeight()+20, rdc.getWidth(), rdc.getHeight());
		rdpc.setBounds(40, rdc.getY()+rdc.getHeight()+20, rdpc.getWidth(), rdpc.getHeight());
		rsc.setBounds(40, rdpc.getY()+rdpc.getHeight()+20, rsc.getWidth(), rsc.getHeight());
		validate();
		repaint();
		
	}
	
	public static PlicoCommessa getInstance(){
		if(PlicoCommessa.instance == null)
			PlicoCommessa.instance = new PlicoCommessa();
		return PlicoCommessa.instance;
	}
}
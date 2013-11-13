package GUI.Plichi;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Date;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import GUI.CoedilFrame;
import GUI.ProgrammaLavori;
import GUI.Abstract.AClipPanel;
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
import coedil99.model.MCommessa;
import coedil99.model.MDistinta;
import coedil99.model.MOrdine;
import coedil99.persistentmodel.DistintaFactory;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

public class PlicoCreaCommessa extends APlico {

	private RiquadroDatiClienteConsegna rdcc;
	private RiquadroDatiAziendali rda;
	private RiquadroDatiConsegna rdc;
	private RiquadroDatiProduzioneConsegna rdpc;
	private RiquadroDatiSviluppoConsegna rsc;
	private JComboBox<Object> cbordini;
	private JLabel ordini_label;
	private JButton salva;
	private JLabel error_mex;
	private ArrayList<ARiquadro> container;
	private int selected_ordine;
	private static PlicoCreaCommessa instance = null;

	private PlicoCreaCommessa() {
		this.initialize();

	}

	@Override
	/**
	 * Metodo che controlla se è in corso una modifica dei riquadri
	 * 
	 * @return modifica: array list contenente i riquadri in modifica
	 */
	public boolean isModifying() {
		if(this.container==null)
			return false;
			boolean result = false;
			for(ARiquadro temp: this.container){
				for (JLabel j : temp.getLabel()) {
					if (j.getIcon()!=null)
						result = true;
					temp.svuotaIconeLAbel();
				}
			}
			
			return result;
	}

	/**
	 * Posiziona i riquadri nel plico
	 */
	private void posizionaRiquadri() {
		int bounds = CoedilFrame.getInstance().getBounds().width / 6;
		salva.setBounds(bounds + (rda.getWidth() / 2) - (salva.getWidth() / 2),
				20, salva.getWidth(), salva.getHeight());
		error_mex.setBounds(bounds, salva.getY() + salva.getHeight() + 20,
				error_mex.getWidth(), error_mex.getHeight());
		ordini_label.setBounds(bounds, error_mex.getY() + error_mex.getHeight()
				+ 20, ordini_label.getWidth(), ordini_label.getHeight());
		cbordini.setBounds(bounds + ordini_label.getWidth(), error_mex.getY()
				+ error_mex.getHeight() + 20, cbordini.getWidth(),
				cbordini.getHeight());
		rda.setBounds(bounds, cbordini.getY() + cbordini.getHeight() + 20,
				rda.getWidth(), rda.getHeight());
		rdcc.setBounds(bounds, rda.getY() + rda.getHeight() + 20,
				rdcc.getWidth(), rdcc.getHeight());
		rdc.setBounds(bounds, rdcc.getY() + rdcc.getHeight() + 20,
				rdc.getWidth(), rdc.getHeight());
		rdpc.setBounds(bounds, rdc.getY() + rdc.getHeight() + 20,
				rdpc.getWidth(), rdpc.getHeight());
		rsc.setBounds(bounds, rdpc.getY() + rdpc.getHeight() + 20,
				rsc.getWidth(), rsc.getHeight());
		validate();
		repaint();

	}

	/**
	 * Rende ogni riquadro editabile
	 */
	private void makeAllEditable() {
		this.rda.makeEditable(true);
		this.rdc.makeEditable(true);
		this.rdcc.makeEditable(true);
		this.rdpc.makeEditable(true);
		this.rsc.makeEditable(true);
	}

	/**
	 * Elimina il bottone di di salva/modifica da tutti i riquadri
	 */
	private void deleteAllButtons() {
		this.rda.deleteButtons();
		this.rdc.deleteButtons();
		this.rdcc.deleteButtons();
		this.rdpc.deleteButtons();
		this.rsc.deleteButtons();
	}

	/**
	 * Metodo che carica nella combo box tutti gli ordini presenti nel sistema
	 * Quando un ordine viene selezionato viene associato alla commessa
	 */
	private void loadOrdini() {
		if (this.cbordini.getItemListeners().length != 0)
			this.cbordini
					.removeItemListener(this.cbordini.getItemListeners()[0]);
		this.cbordini.removeAllItems();
		this.cbordini.setEnabled(true);
		ArrayList<MOrdine> ordini = GestisciOrdineHandler.getInstance()
				.getMOrdini();
		for (int i = 0; i < ordini.size(); ++i) {
			this.cbordini.addItem(ordini.get(i).getPersistentModel().getID());
		}
		this.cbordini.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					PlicoCreaCommessa.this.selected_ordine = Integer
							.parseInt(PlicoCreaCommessa.this.cbordini
									.getSelectedItem().toString());
					MOrdine temp = GestisciOrdineHandler.getInstance().getMOrdineById(selected_ordine);
					PlicoCreaCommessa.this.rdcc.setSelectedCantiere(temp.getPersistentModel().getCliente().getCantiere().getNome());
					PlicoCreaCommessa.this.rdcc.setSelectedCliente(temp.getPersistentModel().getCliente().getName());
					PlicoCreaCommessa.this.rdcc.setNumeroCommessaCliente(GestisciClienteHandler.getInstance().getNextCommessaCliente(temp.getPersistentModel().getCliente().getID()));
					PlicoCreaCommessa.this.rdpc.setDataInizio(temp.getPersistentModel().getDataInizio());
					PlicoCreaCommessa.this.rdpc.setDataFine(temp.getPersistentModel().getDataFine());
					PlicoCreaCommessa.this.rda.setOrdineContratto(GestisciOrdineHandler.getInstance().getNextOrdineContratto());
					PlicoCreaCommessa.this.rda.setAnno(temp.getPersistentModel().getAnno());
					PlicoCreaCommessa.this.rdcc.makeEditable(false);
				}
			}
		});
		this.cbordini.setSelectedItem(null);
	}

	/**
	 * Imposta la grafica
	 */
	private void initialize() {
		setBorder(null);
		setLayout(null);
		this.salva = new JButton("Salva");
		this.salva.setSize(new Dimension(150, 30));
		this.error_mex = new JLabel("");
		this.error_mex.setSize(new Dimension(600, 30));
		this.cbordini = new JComboBox<Object>();
		this.cbordini.setSize(new Dimension(300, 30));
		this.ordini_label = new JLabel();
		this.ordini_label.setText("Seleziona l'ordine associato: ");
		ordini_label.setSize(new Dimension(300, 30));
		container = new ArrayList<ARiquadro>();
		this.loadOrdini();
		rda = (RiquadroDatiAziendali) RiquadroDatiAziendaliFactory
				.getInstance().makeRiquadro();

		rda.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				posizionaRiquadri();
			}
		});
		rda.showNumeroCommessaCoedilMessage();
		rda.showOrdineGestionaleMessage();
		rdcc = (RiquadroDatiClienteConsegna) RiquadroDatiClienteConsegnaFactory
				.getInstance().makeRiquadro();
		rdc = (RiquadroDatiConsegna) RiquadroDatiConsegnaFactory.getInstance()
				.makeRiquadro();
		rdpc = (RiquadroDatiProduzioneConsegna) RiquadroDatiProduzioneConsegnaFactory
				.getInstance().makeRiquadro();
		rsc = (RiquadroDatiSviluppoConsegna) RiquadroDatiSviluppoConsegnaFactory
				.getInstance().makeRiquadro();
		PlicoCreaCommessa.this.rsc.setDataEmissioneCommmessa(new java.util.Date());
		setPreferredSize(new Dimension(745, 1250));
		setSize(745, 950);
		posizionaRiquadri();
		add(this.error_mex);
		add(this.salva);
		add(this.ordini_label);
		add(cbordini);
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

		this.deleteAllButtons();
		this.makeAllEditable();

		this.salva.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (PlicoCreaCommessa.this.rda.controlloErrori() && PlicoCreaCommessa.this.rdc.controlloErrori()
						&& PlicoCreaCommessa.this.rdcc.controlloErrori()
						&& PlicoCreaCommessa.this.rdpc.controlloErrori()
						&& PlicoCreaCommessa.this.rsc.controlloErrori()
						&& PlicoCreaCommessa.this.rdc.checkEmpty()
						&& PlicoCreaCommessa.this.rdcc.checkEmpty()
						&& PlicoCreaCommessa.this.rdpc.checkEmpty()
						&& PlicoCreaCommessa.this.rsc.checkEmpty()
						&& PlicoCreaCommessa.this.selected_ordine > 0) {
					PlicoCreaCommessa.this.error_mex.setText("");
					MCommessa commessa = new MCommessa();
					GestisciCommessaHandler.getInstance().add(commessa);
					commessa.getPersistentModel()
							.setOrdine(
									GestisciOrdineHandler
											.getInstance()
											.getMOrdineById(
													PlicoCreaCommessa.this.selected_ordine)
											.getPersistentModel());
					commessa.setCodiceInterno();
					MDistinta d = new MDistinta();
					commessa.getPersistentModel().setDistinta(d.getPersistentModel());
					PlicoCreaCommessa.this.rda.setOggetto(commessa);
					PlicoCreaCommessa.this.rda.salva(false);
					PlicoCreaCommessa.this.rdc.setOggetto(commessa);
					PlicoCreaCommessa.this.rdc.salva(false);
					PlicoCreaCommessa.this.rdcc.setOggetto(commessa);
					PlicoCreaCommessa.this.rdcc.salva(false);
					PlicoCreaCommessa.this.rdpc.setOggetto(commessa);
					PlicoCreaCommessa.this.rdpc.salva(false);
					PlicoCreaCommessa.this.rsc.setOggetto(commessa);
					PlicoCreaCommessa.this.rsc.salva(false);		
					commessa.save();
					JOptionPane.showMessageDialog(null,
							"Commessa salvata con successo",
							"Operazione eseguita", JOptionPane.PLAIN_MESSAGE);
					PlicoCreaCommessa.this.container=null;
					ProgrammaLavori.getInstance().ListaCommesse().updatePanel();
					ProgrammaLavori.getInstance().getClipPanel().getButtons()
							.get(AClipPanel.PLButtonState.get("COMMESSA"))
							.doClick();
				} else {
					PlicoCreaCommessa.this.error_mex.setIcon(new ImageIcon(
							PlicoCreaCommessa.class
									.getResource("/GUI/image/cancel.png")));
					PlicoCreaCommessa.this.error_mex
							.setText("Errore: controlla di aver inserito i dati corretti");
				}
			}

		});
	}

	public void resetAll() {
		this.removeAll();
		this.initialize();
	}
	
	/**
	 * Inutilizzato per PlicoCreaCommessa
	 */
	@Override
	public void load() {
		// TODO Auto-generated method stub

	}

	/**
	 * Inutilizzato per PlicoCreaCommessa
	 */
	@Override
	public void load(int id) {
		// TODO Auto-generated method stub

	}

	/**
	 * Singleton
	 * 
	 * @return instance:PlicoCommessa
	 */
	public static PlicoCreaCommessa getInstance() {
		if (PlicoCreaCommessa.instance == null)
			PlicoCreaCommessa.instance = new PlicoCreaCommessa();
		return PlicoCreaCommessa.instance;
	}

}

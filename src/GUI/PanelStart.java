package GUI;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import coedil99.controller.GestisciRDAHandler;
import GUI.ClipPanels.ClipPanelMenu;
import GUI.ClipPanels.ClipPanelMenuFactory;
import GUI.Liste.ListaFornitori;
import GUI.Liste.ListaFornitoriFactory;
import GUI.Liste.ListaRDA;
import GUI.Liste.ListaRDAFactory;
import GUI.Login.Login;
import GUI.Login.LoginDialog;

public class PanelStart extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel pannelloUseCases = new JPanel();
	private ClipPanelMenu clipPanel = (ClipPanelMenu) ClipPanelMenuFactory
			.getInstance().makeClipPanel();


	private static PanelStart myInstance;
    
	/**
	 * Costruttore
	 */
	public PanelStart() {
		this.initUI();
	}

	/**
	 * Inizializza il panel con un ClipPanel e il Pannello di selezione attività
	 */
	public void initUI() {
	    this.setLayout(new BorderLayout());
		this.addPannelloUseCases();
		this.addPLButton();
		this.addRDAButton();
		this.addOTHERButton();
		this.addClipPanel();
		this.setButtonsAttivi(Login.getLogged());
	}



	/**
	 * Aggiunge il ClipPanel, pannello dei button in alto
	 */
	private void addClipPanel() {
		this.add(clipPanel, BorderLayout.NORTH);
	}

	/**
	 * Aggiunge il Pannello di selezione attività
	 */
	private void addPannelloUseCases() {
		this.pannelloUseCases = new JPanel();
		pannelloUseCases.setLayout(new GridLayout(2, 2));
		pannelloUseCases.setBorder(new EmptyBorder(100, 300, 100, 300));
		this.add(pannelloUseCases, BorderLayout.CENTER);

	}

	/**
	 * Aggiunge un button vuoto solo per motivi grafici, numero pari
	 */
	private void addOTHERButton() {
		JButton otherbutton = new JButton();
		otherbutton.setToolTipText("Work in progress...");
		otherbutton.setSize(100, 100);
		try {
			Image img = ImageIO.read(getClass().getResource(
					"/GUI/image/wip.png"));
			otherbutton.setIcon(new ImageIcon(img));
		} catch (IOException ex) {
		}
		otherbutton.setFocusable(false);
		pannelloUseCases.add(otherbutton);
		otherbutton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				ListaFornitori listaf = (ListaFornitori) ListaFornitoriFactory.getInstance().makeLista();
				FornitoriCenter.getInstance().setLista(listaf);
				ArrayList<JButton> b = FornitoriCenter.getInstance().getClipPanel()
						.getButtons();
				CoedilFrame.getInstance().montaPanel(FornitoriCenter.getInstance());
				//b.get(1).doClick();
				
				
			}
		});

	}

	/**
	 * Aggiunge un button di attività: Gestisci RDA
	 */
	private void addRDAButton() {
		JButton RDAButton = new JButton();
		RDAButton.setToolTipText("Gestisci RDA");
		RDAButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		RDAButton.setSize(100, 100);
		try {
			Image img = ImageIO.read(getClass().getResource(
					"/GUI/image/rda.png"));
			RDAButton.setIcon(new ImageIcon(img));
		} catch (IOException ex) {
		}
		RDAButton.setFocusable(false);
		pannelloUseCases.add(RDAButton);

		RDAButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				if (!RDACenter.isInstanciated()) {
					RDACenter rda = RDACenter.getInstance();
					rda.loadListaRigheRDA();
				}
				ListaRDA listarda = (ListaRDA) ListaRDAFactory
						.getInstance().makeLista(GestisciRDAHandler.CONGELATA);
				RDACenter.getInstance().setLista(listarda);
				ArrayList<JButton> b = RDACenter.getInstance().getClipPanel()
						.getButtons();
				CoedilFrame.getInstance().montaPanel(RDACenter.getInstance());
				b.get(1).doClick();
			}
		});

	}

	/**
	 * Aggiunge un button di attività: Programma Lavori
	 */
	private void addPLButton() {
		JButton plButton = new JButton();
		plButton.setToolTipText("Programma Lavori");
		plButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		plButton.setPreferredSize(new Dimension(100, 100));
		try {
			Image img = ImageIO.read(getClass().getResource(
					"/GUI/image/proglavori.png"));
			plButton.setIcon(new ImageIcon(img));
		} catch (IOException ex) {
		}
		plButton.setFocusable(false);
		this.pannelloUseCases.add(plButton);

		plButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				ProgrammaLavori p = ProgrammaLavori.getInstance();
				CoedilFrame.getInstance().montaPanel(p);
			}
		});

	}
	
	public void setButtonsAttivi(boolean p){
		int nb = this.pannelloUseCases.getComponentCount();
		for (int i=0 ; i<nb; i++){
			JButton b = (JButton) this.pannelloUseCases.getComponent(i);
			b.setEnabled(p);
			if (b.getActionListeners().length > 0 )
				b.removeActionListener(b.getActionListeners()[0]);
		}
	}
	
	/**
	 * Singleton
	 * 
	 * @return PanelStart
	 */
	public static PanelStart getInstance() {
		if (myInstance == null) {
			myInstance = new PanelStart();
		}
		return myInstance;
	}
	
	public ClipPanelMenu getClipPanel() {
		return clipPanel;
	}
}
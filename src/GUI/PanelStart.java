package GUI;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import coedil99.controller.GestisciRDAHandler;

import GUI.ClipPanels.ClipPanelMenu;
import GUI.ClipPanels.ClipPanelMenuFactory;

public class PanelStart extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel pannelloUseCases = new JPanel();
	private ClipPanelMenu clipPanel = (ClipPanelMenu) ClipPanelMenuFactory.getInstance().makeClipPanel();
	public PanelStart(CoedilFrame f) {

		this.initUI();

	}

	private void initUI() {

		this.setLayout(new BorderLayout());
		this.addPannelloUseCases();
		this.addPLButton();
		this.addRDAButton();
		this.addOTHERButton();
		this.addClipPanel();
	}

	private void addClipPanel() {
		// TODO Auto-generated method stub
		this.add(clipPanel, BorderLayout.NORTH);
	}

	private void addPannelloUseCases() {
		// TODO Auto-generated method stub
		this.pannelloUseCases = new JPanel();
		pannelloUseCases.setLayout(new GridLayout(2, 2));
		pannelloUseCases.setBorder(new EmptyBorder(100, 300, 100, 300));
		this.add(pannelloUseCases, BorderLayout.CENTER);
		
	}

	private void addOTHERButton() {
		// TODO Auto-generated method stub

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
		
	}

	private void addRDAButton() {
		// TODO Auto-generated method stub
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
				RDACenter rda = RDACenter.getInstance();
				rda.loadListaRigheRDA();
				CoedilFrame.getInstance().montaPanel(rda);
			}
		});
		
	}

	private void addPLButton() {
		// TODO Auto-generated method stub
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
}
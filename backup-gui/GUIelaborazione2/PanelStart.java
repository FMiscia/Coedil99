package GUIelaborazione2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import GUIelaboradistinta.GDistinta;
import javax.swing.SwingConstants;

public class PanelStart extends JPanel {
	public PanelStart(CoedilFrame f) {

		this.initUI();

	}

	private void initUI() {

		this.setLayout(new BorderLayout());

		JButton plButton = new JButton();
		plButton.setToolTipText("Programma Lavori");
		plButton.setPreferredSize(new Dimension(100, 100));
		try {
			Image img = ImageIO.read(getClass().getResource(
					"/GUIelaboradistinta/image/proglavori.png"));
			plButton.setIcon(new ImageIcon(img));
		} catch (IOException ex) {
		}
		plButton.setFocusable(false);

		JButton RDAButton = new JButton();
		RDAButton.setToolTipText("Gestisci RDA");
		RDAButton.setSize(100, 100);
		try {
			Image img = ImageIO.read(getClass().getResource(
					"/GUIelaboradistinta/image/rda.png"));
			RDAButton.setIcon(new ImageIcon(img));
		} catch (IOException ex) {
		}
		RDAButton.setFocusable(false);

		JButton otherbutton = new JButton();
		otherbutton.setToolTipText("Work in progress...");
		otherbutton.setSize(100, 100);
		try {
			Image img = ImageIO.read(getClass().getResource(
					"/GUIelaboradistinta/image/wip.png"));
			otherbutton.setIcon(new ImageIcon(img));
		} catch (IOException ex) {
		}
		otherbutton.setFocusable(false);

		JPanel pannelloUseCases = new JPanel();
		pannelloUseCases.setLayout(new GridLayout(2, 2));
		pannelloUseCases.setBorder(new EmptyBorder(100, 300, 100, 300));
		pannelloUseCases.add(plButton);
		pannelloUseCases.add(RDAButton);
		pannelloUseCases.add(otherbutton);

		plButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				ProgrammaLavori p = ProgrammaLavori.getInstance();
				CoedilFrame.getInstance().montaPanel(p);
			}
		});

		this.add(pannelloUseCases, BorderLayout.CENTER);
		this.addMenuBar();

	}

	private void addMenuBar() {
		// TODO Auto-generated method stub
		JMenuBar menuBar = new JMenuBar();

		// Build the first menu.
		JMenu menu = new JMenu("File");
		menuBar.add(menu);

		JMenuItem eMenuItem = new JMenuItem("Exit");
		eMenuItem.setToolTipText("Exit application");
		eMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		menu.add(eMenuItem);
		JMenuItem hMenuItem = new JMenuItem("Help");
		menuBar.add(hMenuItem);
		add(menuBar, BorderLayout.NORTH);
	}

}
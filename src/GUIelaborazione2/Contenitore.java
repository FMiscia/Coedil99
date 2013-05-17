package GUIelaborazione2;

import javax.swing.JPanel;
import javax.swing.JToolBar;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.ComponentOrientation;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.SwingConstants;

public class Contenitore extends JPanel {

	/**
	 * Create the panel.
	 */
	public Contenitore() {
		setMinimumSize(new Dimension(500, 600));
		
		RiquadroCodici riquadrocodici = new RiquadroCodici();
		riquadrocodici.setMinimumSize(new Dimension(0, 0));
		riquadrocodici.setPreferredSize(new Dimension(200, 0));
		
		RiquadroPlico riquadroplico = new RiquadroPlico();
		setLayout(new BorderLayout(0, 0));
		
		JMenuBar menuBar = new JMenuBar();
		FlowLayout fl_menuBar = new FlowLayout();
		fl_menuBar.setAlignment(FlowLayout.LEFT);
		menuBar.setLayout(fl_menuBar);
		add(menuBar, BorderLayout.NORTH);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("File");
		mntmNewMenuItem.setBorder(new LineBorder(new Color(0, 0, 0)));
		menuBar.add(mntmNewMenuItem);
		mntmNewMenuItem.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		
		JMenuItem mntmModifica = new JMenuItem("Modifica");
		mntmModifica.setBorder(new LineBorder(new Color(0, 0, 0)));
		menuBar.add(mntmModifica);
		mntmModifica.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		
		JMenuItem mntmVisualizza = new JMenuItem("Visualizza");
		mntmVisualizza.setBorder(new LineBorder(new Color(0, 0, 0)));
		menuBar.add(mntmVisualizza);
		mntmVisualizza.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		
		JMenuItem mntmHelp = new JMenuItem("Help");
		mntmHelp.setBorder(new LineBorder(new Color(0, 0, 0)));
		menuBar.add(mntmHelp);
		mntmHelp.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		add(riquadrocodici, BorderLayout.WEST);
		
		JLabel lblNewLabel = new JLabel("Scegli una Commessa");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setMinimumSize(new Dimension(200, 15));
		lblNewLabel.setDoubleBuffered(true);
		lblNewLabel.setPreferredSize(new Dimension(70, 40));
		riquadrocodici.setColumnHeaderView(lblNewLabel);
		add(riquadroplico);

	}
}

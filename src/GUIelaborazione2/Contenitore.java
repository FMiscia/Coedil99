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

public class Contenitore extends JPanel {

	/**
	 * Create the panel.
	 */
	public Contenitore() {
		setMinimumSize(new Dimension(500, 600));
		
		RiquadroCodici riquadrocodici = new RiquadroCodici();
		
		RiquadroPlico riquadroplico = new RiquadroPlico();
		setLayout(new BorderLayout(0, 0));
		
		JToolBar toolBar = new JToolBar();
		add(toolBar, BorderLayout.NORTH);
		add(riquadrocodici, BorderLayout.WEST);
		
		JLabel lblNewLabel = new JLabel("Scegli una Commessa");
		lblNewLabel.setDoubleBuffered(true);
		lblNewLabel.setPreferredSize(new Dimension(70, 40));
		riquadrocodici.setColumnHeaderView(lblNewLabel);
		add(riquadroplico);

	}
}

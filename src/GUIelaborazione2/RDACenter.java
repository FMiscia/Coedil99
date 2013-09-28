package GUIelaborazione2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class RDACenter extends JPanel {
	private JButton backButton = new JButton();
	private JButton newRDAButton = new JButton();
	private RiquadroCodici riquadrocodici;
	
	public RDACenter(){
		this.setLayout(new BorderLayout());
		
		JPanel clipPanel = new JPanel();
		clipPanel.setLayout(new GridLayout(1, 0));

		
		clipPanel.setBackground(new Color(222, 184, 135));
		clipPanel.setPreferredSize(new Dimension(210, 50));
		
		backButton.setText("Torna al menu");
		backButton.setToolTipText("Torna al menu principale");
		backButton.setHorizontalTextPosition(SwingConstants.LEFT);
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CoedilFrame cf = CoedilFrame.getInstance();
				PanelStart pl = new PanelStart(cf);
				pl.setBounds(0, 0, cf.getWidth(), cf.getHeight());
				CoedilFrame.getInstance().montaPanel(pl);
			}
		});
		clipPanel.add(backButton);
		
		newRDAButton.setText("Nuova RDA");
		newRDAButton.setToolTipText("Crea una nuova RDA");
		newRDAButton.setHorizontalTextPosition(SwingConstants.LEFT);
		newRDAButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("NEW RDA\n");
			}
		});
		clipPanel.add(newRDAButton);
		
		this.add(clipPanel, BorderLayout.NORTH);
		this.riquadrocodici = new RiquadroCodiciProgrammaLavoro();
		this.riquadrocodici.setPreferredSize(new Dimension(200, 0));
		this.add(this.riquadrocodici, BorderLayout.WEST);
		
	}
}

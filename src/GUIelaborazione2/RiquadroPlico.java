package GUIelaborazione2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.JScrollBar;

import com.alee.laf.WebLookAndFeel;
import com.alee.laf.scroll.WebScrollBar;
import com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel;
import com.sun.java.swing.plaf.windows.WindowsFileChooserUI;
import com.sun.java.swing.plaf.windows.WindowsScrollBarUI;

@SuppressWarnings("serial")
public class RiquadroPlico extends JPanel {

	private JScrollPane plico;

	public RiquadroPlico() {

		setBackground(UIManager.getColor("Panel.background"));
		setLayout(new BorderLayout());

		JToolBar toolBar = new JToolBar();
		add(toolBar, BorderLayout.NORTH);
		toolBar.setLayout(new FlowLayout());
		toolBar.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		toolBar.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		toolBar.setMargin(new Insets(0, 10, 0, 10));
		toolBar.setAlignmentY(Component.CENTER_ALIGNMENT);
		toolBar.setFloatable(false);

		JButton creaDistButton = new JButton("Crea Distinta");
		toolBar.add(creaDistButton);

		JButton deleteCommButton = new JButton("Elimina Commessa");
		toolBar.add(deleteCommButton);

		JButton btnNewButton_2 = new JButton("New button");
		toolBar.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("New button");
		toolBar.add(btnNewButton_3);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 230, 140));
		add(panel, BorderLayout.CENTER);

		this.plico = new JScrollPane();
		plico.setPreferredSize(new Dimension(700, 600));
		add(plico);
		plico.setBackground(Color.WHITE);
		
		

		JPanel clipPanel = new JPanel();
		add(clipPanel, BorderLayout.EAST);
		clipPanel.setBorder(new LineBorder(new Color(160, 82, 45), 2));
		clipPanel.setBackground(new Color(222, 184, 135));
		clipPanel.setPreferredSize(new Dimension(110, 100));
		clipPanel.setLayout(null);

		JButton commessaButton = new JButton("Commessa");
		commessaButton.setToolTipText("Commessa");
		commessaButton.setBounds(0, 5, 110, 25);
		commessaButton.setHorizontalTextPosition(SwingConstants.LEFT);
		commessaButton.setPreferredSize(new Dimension(90, 25));
		clipPanel.add(commessaButton);
		commessaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PlicoCommessa plico_commessa = new PlicoCommessa();
				//plico_commessa.load();
				plico.setViewportView(plico_commessa);
				plico.validate();
				plico.repaint();

			}
		});

		JButton distintaButton = new JButton("Distinta");
		distintaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PlicoDistinta plico_distinta = new PlicoDistinta();
				// plico_distinta.load();
				remove(plico);
				add(plico_distinta);
				validate();
				repaint();
			}
		});
		distintaButton.setToolTipText("Distinta");
		distintaButton.setBounds(0, 35, 110, 25);
		clipPanel.add(distintaButton);
		distintaButton.setPreferredSize(new Dimension(110, 25));
		distintaButton.setMinimumSize(new Dimension(110, 25));
		distintaButton.setMaximumSize(new Dimension(110, 25));

		JButton btnDdo = new JButton("DDO");
		btnDdo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PlicoDDO plico_ddo = new PlicoDDO();
				plico_ddo.load();
				plico.removeAll();
				plico.add(plico_ddo);
			}
		});
		btnDdo.setToolTipText("Documento di Ottimizzazione");
		btnDdo.setBounds(0, 65, 110, 25);
		clipPanel.add(btnDdo);
		btnDdo.setPreferredSize(new Dimension(110, 25));

		JButton btnNewButton_6 = new JButton("LDR");
		btnNewButton_6.setToolTipText("Lista di Rintracciabilità");
		btnNewButton_6.setBounds(0, 95, 110, 25);
		clipPanel.add(btnNewButton_6);

	}
}

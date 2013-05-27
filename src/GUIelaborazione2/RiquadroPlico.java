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

@SuppressWarnings("serial")
public class RiquadroPlico extends JPanel {

	private JPanel plico;

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
		panel.setBounds(4, 5, 1000, 1000);
		panel.setBackground(new Color(240, 230, 140));
		panel.setPreferredSize(new Dimension(1000, 1000));
		panel.setLayout(null);
		
		this.plico = new JPanel();
		plico.setPreferredSize(new Dimension(800, 1000));
		plico.setBackground(Color.WHITE);
		plico.setLayout(new WrapLayout());
		plico.add(panel);

		JScrollPane scrollPaneWrapper = new JScrollPane();
		add(scrollPaneWrapper, BorderLayout.CENTER);
		scrollPaneWrapper.setPreferredSize(new Dimension(800,600));
		scrollPaneWrapper.setViewportView(this.plico);

		final JPanel paper_panel = new JPanel();
		paper_panel.setPreferredSize(new Dimension(1000, 1000));
		paper_panel.setBounds(0, 0, 745, 1000);
		panel.add(paper_panel);

		JPanel clipPanel = new JPanel();
		clipPanel.setBounds(777, 12, 110, 137);
		panel.add(clipPanel);
		clipPanel.setBorder(new LineBorder(new Color(160, 82, 45), 2));
		clipPanel.setBackground(new Color(222, 184, 135));
		clipPanel.setPreferredSize(new Dimension(110, 100));
		clipPanel.setLayout(null);

		JButton commessaButton = new JButton("Commessa");
		commessaButton.setBounds(0, 7, 110, 25);
		commessaButton.setToolTipText("Commessa");
		commessaButton.setHorizontalTextPosition(SwingConstants.LEFT);
		commessaButton.setPreferredSize(new Dimension(90, 25));
		clipPanel.add(commessaButton);
		commessaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PlicoCommessa plico_commessa = new PlicoCommessa();
				// plico_commessa.load();
				paper_panel.add(plico_commessa);
				plico.validate();
				plico.repaint();

			}
		});

		JButton distintaButton = new JButton("Distinta");
		distintaButton.setBounds(0, 37, 110, 25);
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
		clipPanel.add(distintaButton);
		distintaButton.setPreferredSize(new Dimension(110, 25));
		distintaButton.setMinimumSize(new Dimension(110, 25));
		distintaButton.setMaximumSize(new Dimension(110, 25));

		JButton btnDdo = new JButton("DDO");
		btnDdo.setBounds(0, 67, 110, 25);
		btnDdo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PlicoDDO plico_ddo = new PlicoDDO();
				plico_ddo.load();
				plico.removeAll();
				plico.add(plico_ddo);
			}
		});
		btnDdo.setToolTipText("Documento di Ottimizzazione");
		clipPanel.add(btnDdo);
		btnDdo.setPreferredSize(new Dimension(110, 25));

		JButton btnNewButton_6 = new JButton("LDR");
		btnNewButton_6.setBounds(0, 97, 110, 25);
		btnNewButton_6.setToolTipText("Lista di Rintracciabilit�");
		clipPanel.add(btnNewButton_6);

	}
}

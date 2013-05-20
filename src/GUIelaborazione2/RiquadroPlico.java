package GUIelaborazione2;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.UIManager;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JLayeredPane;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import javax.swing.BoxLayout;
import java.awt.CardLayout;

@SuppressWarnings("serial")
public class RiquadroPlico extends JPanel {

	private JPanel plico;

	public RiquadroPlico() {

		setBackground(UIManager.getColor("Panel.background"));
		setLayout(new BorderLayout());
		
				this.plico = new JPanel();
				plico.setBackground(new Color(222, 184, 135));
				add(plico, BorderLayout.CENTER);

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

		JPanel clipPanel = new JPanel();
		clipPanel.setBorder(new LineBorder(new Color(160, 82, 45), 2));
		clipPanel.setBackground(new Color(222, 184, 135));
		clipPanel.setPreferredSize(new Dimension(150, 100));
		add(clipPanel, BorderLayout.EAST);
		clipPanel.setLayout(null);

		JButton commessaButton = new JButton("Commessa");
		commessaButton.setToolTipText("Commessa");
		commessaButton.setBounds(20, 5, 110, 25);
		commessaButton.setHorizontalTextPosition(SwingConstants.LEFT);
		commessaButton.setPreferredSize(new Dimension(90, 25));
		clipPanel.add(commessaButton);
		commessaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PlicoCommessa plico_commessa = new PlicoCommessa();
				plico_commessa.load();
				plico.removeAll();
				plico.add(plico_commessa);
			}
		});

		JButton addButton = new JButton("+");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PlicoDistinta plico_distinta = new PlicoDistinta();
				plico_distinta.load();
				plico.removeAll();
				plico.add(plico_distinta);
			}
		});
		addButton.setToolTipText("Aggiungi ");
		addButton.setBounds(20, 35, 110, 25);
		clipPanel.add(addButton);
		addButton.setPreferredSize(new Dimension(110, 25));
		addButton.setMinimumSize(new Dimension(110, 25));
		addButton.setMaximumSize(new Dimension(110, 25));

	}
}

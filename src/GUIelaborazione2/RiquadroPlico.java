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

@SuppressWarnings("serial")
public class RiquadroPlico extends JPanel {
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

		JButton btnNewButton = new JButton("Crea Distinta");
		toolBar.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Elimina Commessa");
		toolBar.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("New button");
		toolBar.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("New button");
		toolBar.add(btnNewButton_3);
		
		PlicoCommessa plico = new PlicoCommessa();
		add(plico, BorderLayout.CENTER);


	}
}

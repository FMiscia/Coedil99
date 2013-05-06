package GUIelaborazione2;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.ScrollPane;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import java.awt.Dimension;
import javax.swing.JToolBar;
import javax.swing.JMenuItem;
import java.awt.Component;
import javax.swing.SwingConstants;
import org.eclipse.wb.swing.FocusTraversalOnArray;

import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.LayoutManager;

public class RiquadroPlico extends JPanel {
	public RiquadroPlico() {
		
		setBackground(UIManager.getColor("Panel.background"));
		setLayout(new BorderLayout());
		
		JToolBar toolBar = new JToolBar();
		add(toolBar,BorderLayout.NORTH);
		toolBar.setLayout(new FlowLayout());
		toolBar.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		toolBar.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		toolBar.setMargin(new Insets(0, 10, 0, 10));
		toolBar.setAlignmentY(Component.CENTER_ALIGNMENT);
		toolBar.setFloatable(false);
		
		JButton btnNewButton = new JButton("New button");
		toolBar.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		toolBar.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		toolBar.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("New button");
		toolBar.add(btnNewButton_3);
		toolBar.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{btnNewButton, btnNewButton_1, btnNewButton_2, btnNewButton_3}));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane,BorderLayout.CENTER);
		
	}
}

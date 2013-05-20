package GUIelaborazione2;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import java.awt.Component;
import java.awt.Insets;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Dimension;
import javax.swing.JLayeredPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import java.awt.Color;

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

		JLayeredPane layeredPane = new JLayeredPane();
		add(layeredPane, BorderLayout.CENTER);
		layeredPane.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		layeredPane.add(scrollPane);
		
		JPanel plico = new JPanel();
		plico.setBounds(0, 0, 105, 258);
		scrollPane.setViewportView(plico);
		
		final JPanel DatiClienteConsegna = new JPanel();
		DatiClienteConsegna.setPreferredSize(new Dimension(350, 80));
		DatiClienteConsegna.setBorder(new TitledBorder("Dati Cliente e Consegna"));
		DatiClienteConsegna.addMouseListener(new MouseAdapter() {
			  public void mouseClicked(MouseEvent arg0){
				  if(DatiClienteConsegna.getHeight() == 80 )
					  DatiClienteConsegna.setSize(DatiClienteConsegna.getWidth(),20);
				  else
					  DatiClienteConsegna.setSize(DatiClienteConsegna.getWidth(),80);
			  }
		});
		FlowLayout fl_plico = new FlowLayout(FlowLayout.LEFT, 10, 10);
		plico.setLayout(fl_plico);
		DatiClienteConsegna.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		plico.add(DatiClienteConsegna);
		
		GridBagLayout gbl_DatiClienteConsegna = new GridBagLayout();
		gbl_DatiClienteConsegna.columnWidths = new int[]{0, 0};
		gbl_DatiClienteConsegna.rowHeights = new int[]{0, 0, 0, 0};
		gbl_DatiClienteConsegna.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_DatiClienteConsegna.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		DatiClienteConsegna.setLayout(gbl_DatiClienteConsegna);
		
		JLabel lblNewLabel = new JLabel("New label");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		DatiClienteConsegna.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		DatiClienteConsegna.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		DatiClienteConsegna.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JPanel DatiAziendali = new JPanel();
		DatiAziendali.setPreferredSize(new Dimension(50, 100));
		plico.add(DatiAziendali);
		GridBagLayout gbl_DatiAziendali = new GridBagLayout();
		gbl_DatiAziendali.columnWidths = new int[]{0, 0};
		gbl_DatiAziendali.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_DatiAziendali.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_DatiAziendali.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		DatiAziendali.setLayout(gbl_DatiAziendali);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 0;
		DatiAziendali.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 1;
		DatiAziendali.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 2;
		DatiAziendali.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 3;
		DatiAziendali.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_7.gridx = 0;
		gbc_lblNewLabel_7.gridy = 4;
		DatiAziendali.add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("New label");
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_8.gridx = 0;
		gbc_lblNewLabel_8.gridy = 5;
		DatiAziendali.add(lblNewLabel_8, gbc_lblNewLabel_8);
		
		JLabel label = new JLabel("New label");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 0);
		gbc_label.gridx = 0;
		gbc_label.gridy = 6;
		DatiAziendali.add(label, gbc_label);
		
		JLabel lblNewLabel_9 = new JLabel("New label");
		GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
		gbc_lblNewLabel_9.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_9.gridx = 0;
		gbc_lblNewLabel_9.gridy = 7;
		DatiAziendali.add(lblNewLabel_9, gbc_lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("New label");
		GridBagConstraints gbc_lblNewLabel_10 = new GridBagConstraints();
		gbc_lblNewLabel_10.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_10.gridx = 0;
		gbc_lblNewLabel_10.gridy = 8;
		DatiAziendali.add(lblNewLabel_10, gbc_lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("New label");
		GridBagConstraints gbc_lblNewLabel_11 = new GridBagConstraints();
		gbc_lblNewLabel_11.gridx = 0;
		gbc_lblNewLabel_11.gridy = 9;
		DatiAziendali.add(lblNewLabel_11, gbc_lblNewLabel_11);
		
		

	}
}

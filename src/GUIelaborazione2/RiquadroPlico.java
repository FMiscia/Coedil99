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
	private JPanel paper_container;
	private JPanel paper_panel;

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
		
		this.paper_container = new JPanel();
		paper_container.setBounds(4, 5, 1000, 1000);
		paper_container.setBackground(new Color(240, 230, 140));
		paper_container.setPreferredSize(new Dimension(860, 1000));
		paper_container.setLayout(null);
		
		this.plico = new JPanel();
		this.plico.setPreferredSize(new Dimension(800, 1000));
		this.plico.setBackground(Color.WHITE);
		WrapLayout wl_plico = new WrapLayout();
		this.plico.setLayout(wl_plico);
		this.plico.add(this.paper_container);

		JScrollPane scrollPaneWrapper = new JScrollPane();
		add(scrollPaneWrapper, BorderLayout.CENTER);
		scrollPaneWrapper.setPreferredSize(new Dimension(800,600));
		scrollPaneWrapper.setViewportView(this.plico);

		this.paper_panel = new JPanel();
		this.paper_panel.setPreferredSize(new Dimension(1000, 1000));
		this.paper_panel.setBounds(0, 0, 745, 1000);
		this.paper_container.add(this.paper_panel);

		JPanel clipPanel = new JPanel();
		clipPanel.setBounds(747, 0, 110, 137);
		this.paper_container.add(clipPanel);
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
				RiquadroPlico.this.getPaperPanel().add(plico_commessa);
				
				//RiquadroPlico.this.getPaperPanel().setSize(RiquadroPlico.this.getPaperPanel().getWidth(), plico_commessa.getHeight());
				//RiquadroPlico.this.plico.setSize(RiquadroPlico.this.plico.getWidth(), RiquadroPlico.this.getPaperPanel().getHeight());
				//RiquadroPlico.this.getPlico().validate();
				//RiquadroPlico.this.getPlico().repaint();
				aggiornaAltezze();

			}
		});

		JButton distintaButton = new JButton("Distinta");
		distintaButton.setBounds(0, 37, 110, 25);
		distintaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PlicoDistinta plico_distinta = new PlicoDistinta();
				// plico_distinta.load();
				remove(RiquadroPlico.this.plico);
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

	public JPanel getPlico() {
		return plico;
	}

	public void setPlico(JPanel plico) {
		this.plico = plico;
	}

	public JPanel getPaperContainer() {
		return paper_container;
	}

	public void setPaperContainer(JPanel panel) {
		this.paper_container = panel;
	}

	public JPanel getPaperPanel() {
		return paper_panel;
	}

	public void setPaperPanel(JPanel paper_panel) {
		this.paper_panel = paper_panel;
	}
	
	private void aggiornaAltezze(){
		RiquadroPlico.this.getPaperPanel().setSize(RiquadroPlico.this.getPaperPanel().getWidth(), RiquadroPlico.this.getPaperPanel().getComponent(0).getHeight());
		RiquadroPlico.this.getPaperContainer().setSize(RiquadroPlico.this.getPaperContainer().getWidth(), RiquadroPlico.this.getPaperPanel().getHeight());
		RiquadroPlico.this.getPlico().setPreferredSize(new Dimension(RiquadroPlico.this.getPlico().getWidth(), RiquadroPlico.this.getPaperContainer().getHeight()+10));
		RiquadroPlico.this.getPlico().setSize(RiquadroPlico.this.getPlico().getWidth(), RiquadroPlico.this.getPaperContainer().getHeight()+10);
		validate();
		repaint();
	}
}

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
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import elaboradistinta.model.Commessa;
import elaboradistinta.operation.ODistinta;

@SuppressWarnings("serial")
public class RiquadroPlico extends JPanel {

	private JPanel plico;
	private JPanel paper_container;
	private JPanel paper_panel;
	private JPanel clipPanel;
	private JButton commessaButton = new JButton();
	private JButton distintaButton = new JButton();
	private JButton btnNewButton_6 = new JButton();

	public RiquadroPlico() {

		setBackground(UIManager.getColor("Panel.background"));
		setLayout(new BorderLayout());
		
		this.paper_container = new JPanel();
		paper_container.setBounds(4, 5, 1000, 1000);
		paper_container.setBackground(new Color(240, 230, 140));
		paper_container.setPreferredSize(new Dimension(860, 1000));
		paper_container.setLayout(null);

		this.plico = new JPanel();
		this.plico.setPreferredSize(new Dimension(800, 1020));
		this.plico.setBackground(Color.WHITE);
		WrapLayout wl_plico = new WrapLayout();
		wl_plico.setVgap(10);
		this.plico.setLayout(wl_plico);
		this.plico.add(this.paper_container);
		
		JScrollPane scrollPaneWrapper = new JScrollPane();
		add(scrollPaneWrapper, BorderLayout.CENTER);
		scrollPaneWrapper.setPreferredSize(new Dimension(800, 600));
		scrollPaneWrapper.setViewportView(this.plico);
		scrollPaneWrapper.getVerticalScrollBar().setUnitIncrement(20);
		scrollPaneWrapper.getVerticalScrollBar().addAdjustmentListener(
				new AdjustmentListener() {

					@Override
					public void adjustmentValueChanged(AdjustmentEvent e) {
						if (e.getValue() < 10)
							clipPanel.setLocation(clipPanel.getX(),
									e.getValue());
						else
							clipPanel.setLocation(clipPanel.getX(),
									e.getValue() - 10);
					}
				});

		this.paper_panel = new JPanel();
		this.paper_panel.setPreferredSize(new Dimension(1000, 1000));
		this.paper_panel.setBounds(0, 0, 745, 1000);
		this.paper_container.add(this.paper_panel);

		clipPanel = new JPanel();
		clipPanel.setBounds(747, 0, 110, 137);
		this.paper_container.add(clipPanel);
		clipPanel.setBorder(new LineBorder(new Color(160, 82, 45), 2));
		clipPanel.setBackground(new Color(222, 184, 135));
		clipPanel.setPreferredSize(new Dimension(110, 100));
		clipPanel.setLayout(null);

		commessaButton.setText("Commessa");
		commessaButton.setBounds(0, 7, 110, 25);
		commessaButton.setToolTipText("Commessa");
		commessaButton.setHorizontalTextPosition(SwingConstants.LEFT);
		commessaButton.setPreferredSize(new Dimension(90, 25));
		clipPanel.add(commessaButton);
		commessaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				changePlico(PlicoCommessa.getInstance());
			}
		});

		distintaButton.setText("Distinta");
		distintaButton.setBounds(0, 37, 110, 25);
		distintaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changePlico(PlicoDistinta.getInstance());
			}
		});
		distintaButton.setToolTipText("Distinta");
		clipPanel.add(distintaButton);
		distintaButton.setPreferredSize(new Dimension(110, 25));
		distintaButton.setMinimumSize(new Dimension(110, 25));
		distintaButton.setMaximumSize(new Dimension(110, 25));

		btnNewButton_6.setText("LDR");
		btnNewButton_6.setBounds(0, 97, 110, 25);
		btnNewButton_6.setToolTipText("Lista di Rintracciabilita");
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

	public void aggiornaAltezze() {

		RiquadroPlico.this.getPaperPanel().setSize(
				RiquadroPlico.this.getPaperPanel().getWidth(),
				RiquadroPlico.this.getPaperPanel().getComponent(0).getHeight());
		RiquadroPlico.this.getPaperPanel().setPreferredSize(
				new Dimension(RiquadroPlico.this.getPaperPanel().getWidth(),
						RiquadroPlico.this.getPaperPanel().getComponent(0)
								.getHeight()));

		RiquadroPlico.this.getPaperContainer().setSize(
				RiquadroPlico.this.getPaperContainer().getWidth(),
				RiquadroPlico.this.getPaperPanel().getHeight());
		RiquadroPlico.this.getPaperContainer().setPreferredSize(
				new Dimension(
						RiquadroPlico.this.getPaperContainer().getWidth(),
						RiquadroPlico.this.getPaperPanel().getHeight()));

		RiquadroPlico.this.getPlico().setPreferredSize(
						new Dimension(RiquadroPlico.this.getPlico().getWidth(),
								RiquadroPlico.this.getPaperContainer()
										.getHeight() + 20));
		RiquadroPlico.this.getPlico().setSize(
				RiquadroPlico.this.getPlico().getWidth(),
				RiquadroPlico.this.getPaperContainer().getHeight() + 20);
		validate();
		repaint();
	}

	private void changePlico(Plico plico) {

		RiquadroPlico.this.getPaperPanel().removeAll();
		Contenitore cont = Contenitore.getInstance();
		plico.load(cont.getCommessaSelezionata().getID());
		// plico.load( );

		RiquadroPlico.this.getPaperPanel().add(plico);
		aggiornaAltezze();
		RiquadroPlico.this.getPaperPanel().validate();
		RiquadroPlico.this.getPaperPanel().repaint();

	}
	
	public void caricaPrimaCommessa(Commessa c){
		PlicoCommessa plico = PlicoCommessa.getInstance();
		plico.load(c.getID());
		// plico.load( );

		RiquadroPlico.this.getPaperPanel().add(plico);
		//aggiornaAltezze();
		RiquadroPlico.this.getPaperPanel().validate();
		RiquadroPlico.this.getPaperPanel().repaint();
	}

	public void aggiornaClipPanel(final ODistinta oDistinta) {
		// TODO Auto-generated method stub
		JButton btnHasDdo = new JButton("Visualizza DDO");
		JButton btnHasnotDdo = new JButton("Elabora DDO");
		btnHasDdo.setBounds(0, 67, 110, 25);
		btnHasnotDdo.setBounds(0, 67, 110, 25);
		btnHasDdo.setToolTipText("Visualizza Documento di Ottimizzazione");
		btnHasnotDdo.setToolTipText("Elabora Documento di Ottimizzazione");
		btnHasnotDdo.setPreferredSize(new Dimension(110, 25));
		btnHasDdo.setPreferredSize(new Dimension(110, 25));
		if(oDistinta.hasDdo()){
			//System.out.println("has ddo");
			clipPanel.removeAll();
			clipPanel.add(btnHasDdo);

			btnHasDdo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					changePlico(PlicoDDO.getInstance());
				}
			});
		}else{
			//System.out.println("non has ddo");
			clipPanel.removeAll();
			clipPanel.add(btnHasnotDdo);
			
			btnHasnotDdo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//
					//oDistinta.creaDDO();
					//changePlico(PlicoDDO.getInstance());
				}
			});
		}
		clipPanel.add(commessaButton);
		clipPanel.add(distintaButton);
		clipPanel.add(btnNewButton_6);
		clipPanel.validate();
		clipPanel.repaint();
	}

	
}

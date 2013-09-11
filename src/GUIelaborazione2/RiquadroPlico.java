package GUIelaborazione2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
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
	private JButton menuButton = new JButton();
	private JButton commessaButton = new JButton();
	private JButton distintaButton = new JButton();
	private JButton btnNewButton_6 = new JButton();
	JScrollPane scrollPaneWrapper = new JScrollPane();

	public RiquadroPlico() {

		this.setLayout(new BorderLayout());
		this.paper_container = new JPanel();
		paper_container.setBackground(new Color(240, 230, 140));
		paper_container.setLayout(new BorderLayout());

		this.add(this.scrollPaneWrapper, BorderLayout.CENTER);
		this.scrollPaneWrapper.setViewportView(this.paper_container);
		this.scrollPaneWrapper.getVerticalScrollBar().setUnitIncrement(20);

		this.paper_panel = new JPanel();

		this.paper_container.add(this.paper_panel, BorderLayout.CENTER);
		this.clipPanel = new JPanel();
		this.clipPanel.setLayout(new GridLayout(1, 0));

		this.add(this.clipPanel, BorderLayout.NORTH);
		clipPanel.setBackground(new Color(222, 184, 135));
		clipPanel.setPreferredSize(new Dimension(210, 50));

		menuButton.setText("Torna al menu");
		menuButton.setToolTipText("Torna al menu principale");
		menuButton.setHorizontalTextPosition(SwingConstants.LEFT);
		menuButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CoedilFrame cf = CoedilFrame.getInstance();
				PanelStart pl = new PanelStart(cf);
				pl.setBounds(0, 0, cf.getWidth(), cf.getHeight());
				CoedilFrame.getInstance().montaPanel(pl);
			}
		});
		clipPanel.add(menuButton);

		commessaButton.setText("Commessa");
		commessaButton.setToolTipText("Commessa");
		commessaButton.setHorizontalTextPosition(SwingConstants.LEFT);
		clipPanel.add(commessaButton);
		commessaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				changePlico(PlicoCommessa.getInstance());
			}
		});

		distintaButton.setText("Distinta");
		distintaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changePlico(PlicoDistinta.getInstance());
			}
		});
		distintaButton.setToolTipText("Distinta");
		clipPanel.add(distintaButton);

		btnNewButton_6.setText("LDR");
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

	private void changePlico(Plico plico) {

		RiquadroPlico.this.getPaperPanel().removeAll();
		ProgrammaLavori cont = ProgrammaLavori.getInstance();
		plico.load(cont.getCommessaSelezionata().getID());
		// plico.load( );

		RiquadroPlico.this.getPaperPanel().add(plico);
		RiquadroPlico.this.getPaperPanel().getComponent(0)
				.addComponentListener(new ComponentListener() {

					@Override
					public void componentShown(ComponentEvent e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void componentResized(ComponentEvent e) {
						// RiquadroPlico.this.aggiornaAltezze();

					}

					@Override
					public void componentMoved(ComponentEvent e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void componentHidden(ComponentEvent e) {
						// TODO Auto-generated method stub

					}
				});
		// aggiornaAltezze();
		RiquadroPlico.this.getPaperPanel().validate();
		RiquadroPlico.this.getPaperPanel().repaint();

	}

	public void caricaPrimaCommessa(Commessa c) {
		PlicoCommessa plico = PlicoCommessa.getInstance();
		plico.load(c.getID());
		// plico.load( );

		RiquadroPlico.this.getPaperPanel().add(plico);
		// aggiornaAltezze();
		RiquadroPlico.this.getPaperPanel().validate();
		RiquadroPlico.this.getPaperPanel().repaint();
	}

	public void aggiornaClipPanel(final ODistinta oDistinta) {
		// TODO Auto-generated method stub
		JButton btnHasDdo = new JButton("Visualizza DDO");
		JButton btnHasnotDdo = new JButton("Elabora DDO");
		btnHasDdo.setBounds(0, 67, 213, 25);
		btnHasnotDdo.setBounds(0, 67, 213, 25);
		btnHasDdo.setToolTipText("Visualizza Documento di Ottimizzazione");
		btnHasnotDdo.setToolTipText("Elabora Documento di Ottimizzazione");
		btnHasnotDdo.setPreferredSize(new Dimension(110, 25));
		btnHasDdo.setPreferredSize(new Dimension(110, 25));

		clipPanel.removeAll();
		menuButton.setText("Torna al menu");
		menuButton.setToolTipText("Torna al menu principale");
		menuButton.setHorizontalTextPosition(SwingConstants.LEFT);
		menuButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CoedilFrame cf = CoedilFrame.getInstance();
				PanelStart pl = new PanelStart(cf);
				pl.setBounds(0, 0, cf.getWidth(), cf.getHeight());
				// cf.getContentPane().add(pl, BorderLayout.NORTH);
				// cf.validate();
				// cf.repaint();
				CoedilFrame.getInstance().montaPanel(pl);
			}
		});
		clipPanel.add(menuButton);

		if (oDistinta.hasDdo()) {
			// System.out.println("has ddo");
			clipPanel.add(btnHasDdo);

			btnHasDdo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					changePlico(PlicoDDO.getInstance());
				}
			});
		} else {
			// System.out.println("non has ddo");
			clipPanel.add(btnHasnotDdo);

			btnHasnotDdo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane confermaOtt = new JOptionPane();
					Object[] options = { "Si", "No" };
					int n = JOptionPane
							.showOptionDialog(
									RiquadroPlico.this,
									"Vuoi elaborare l'ottimizzazione?\n"
											+ "Nota: questa operazione non è reversibile",
									"Conferma operazione",
									JOptionPane.YES_NO_CANCEL_OPTION,
									JOptionPane.QUESTION_MESSAGE, null,
									options, options[1]);
					if (n == JOptionPane.YES_OPTION) {
						ProgrammaLavori.getInstance().getCommessaSelezionata()
								.getDistinta().creaDDO();
						changePlico(PlicoDDO.getInstance());
					}
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

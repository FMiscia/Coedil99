package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import GUI.ProgrammaLavori;
import GUI.Abstract.APlico;
import GUI.ClipPanels.ClipPanelProgrammaLavori;
import GUI.Plichi.PlicoCommessa;

import coedil99.model.Commessa;

@SuppressWarnings("serial")
public class RaccoglitorePlichi extends JPanel {

	private JPanel plico;
	private JPanel paper_container;
	private JPanel paper_panel;
	private JScrollPane scrollPaneWrapper = new JScrollPane();
	
	private static RaccoglitorePlichi instance = null;

	private RaccoglitorePlichi() {

		this.setLayout(new BorderLayout());
		this.paper_container = new JPanel();
		paper_container.setBackground(new Color(240, 230, 140));
		paper_container.setLayout(new BorderLayout());

		this.add(this.scrollPaneWrapper, BorderLayout.CENTER);
		this.scrollPaneWrapper.setViewportView(this.paper_container);
		this.scrollPaneWrapper.getVerticalScrollBar().setUnitIncrement(20);

		this.paper_panel = new JPanel();

		this.paper_container.add(this.paper_panel, BorderLayout.CENTER);

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

	public void changePlico(APlico plico) {

		RaccoglitorePlichi.this.getPaperPanel().removeAll();
		ProgrammaLavori cont = ProgrammaLavori.getInstance();
		plico.load(cont.getCommessaSelezionata().getID());
		// plico.load( );

		RaccoglitorePlichi.this.getPaperPanel().add(plico);
		RaccoglitorePlichi.this.getPaperPanel().getComponent(0)
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
		RaccoglitorePlichi.this.getPaperPanel().validate();
		RaccoglitorePlichi.this.getPaperPanel().repaint();

	}

	public void caricaPrimaCommessa(Commessa c) {
		PlicoCommessa plico = PlicoCommessa.getInstance();
		plico.load(c.getID());
		// plico.load( );

		RaccoglitorePlichi.this.getPaperPanel().add(plico);
		// aggiornaAltezze();
		RaccoglitorePlichi.this.getPaperPanel().validate();
		RaccoglitorePlichi.this.getPaperPanel().repaint();
	}

	
	public static RaccoglitorePlichi getInstance(){
		if(instance==null)
			RaccoglitorePlichi.instance = new RaccoglitorePlichi();
		
		return instance;
		
	}
	
	public JScrollPane getScrollPaneWrapper() {
		return scrollPaneWrapper;
	}




}

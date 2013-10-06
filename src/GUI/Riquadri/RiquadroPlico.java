package GUI.Riquadri;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import GUI.ClipPanelProgrammaLavori;
import GUI.Plico;
import GUI.PlicoCommessa;
import GUI.ProgrammaLavori;

import coedil99.model.Commessa;

@SuppressWarnings("serial")
public class RiquadroPlico extends JPanel {

	private JPanel plico;
	private JPanel paper_container;
	private JPanel paper_panel;
	private JPanel clipPanel;
	private ClipPanelProgrammaLavori menu;
	private JScrollPane scrollPaneWrapper = new JScrollPane();
	
	private static RiquadroPlico instance = null;

	private RiquadroPlico() {

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

	public void changePlico(Plico plico) {

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

	
	public static RiquadroPlico getInstance(){
		if(instance==null)
			RiquadroPlico.instance = new RiquadroPlico();
		
		return instance;
		
	}
	
	public JScrollPane getScrollPaneWrapper() {
		return scrollPaneWrapper;
	}




}

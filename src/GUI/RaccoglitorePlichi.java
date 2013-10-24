package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import GUI.ProgrammaLavori;
import GUI.Abstract.APlico;
import GUI.Plichi.PlicoCommessa;
import coedil99.model.Commessa;

@SuppressWarnings("serial")
public class RaccoglitorePlichi extends JScrollPane {

	private JPanel plico_container = new JPanel();
	private JPanel plico = new JPanel();
	private JScrollPane scrollPaneWrapper = new JScrollPane();
	private static RaccoglitorePlichi instance = null;

	/**
	 * Costruttore
	 */
	private RaccoglitorePlichi() {
		this.initialize();
	}

	/**
	 * Inizializza le componenti grafiche
	 */
	private void initialize() {

		this.setViewportView(this.plico_container);
		plico_container.setLayout(new BorderLayout());
		plico_container.setBackground(new Color(240, 240, 240));
		this.getVerticalScrollBar().setUnitIncrement(20);
		//this.plico_container.add(this.plico, BorderLayout.CENTER);
	}

	/**
	 * 
	 * @return JPanel
	 */
	public JPanel getPlico() {
		return plico;
	}

	/**
	 * 
	 * @param paper_panel
	 */
	public void setPlico(JPanel paper_panel) {
		this.plico = paper_panel;
	}

	/**
	 * 
	 * @param p: Il plico da mostrare
	 */
	public void changePlico(APlico p) {
		ProgrammaLavori pl = ProgrammaLavori.getInstance();
		p.load(pl.getCommessaSelezionata().getID());
		this.getPlico_container().removeAll();
		this.getPlico_container().add(p,BorderLayout.CENTER);
		this.validate();
		this.repaint();

	}

	public JPanel getPlico_container() {
		return plico_container;
	}

	/**
	 * 
	 * @param c
	 *            : la commessa da caricare
	 */
	public void caricaPrimaCommessa(Commessa c) {
		PlicoCommessa plico = PlicoCommessa.getInstance();
		plico.load(c.getID());
		this.getPlico_container().add(plico,BorderLayout.CENTER);
		this.getPlico_container().validate();
		this.getPlico_container().repaint();
	}

	/**
	 * Singleton
	 * 
	 * @return RaccoglitorePlichi
	 */
	public static RaccoglitorePlichi getInstance() {
		if (instance == null)
			RaccoglitorePlichi.instance = new RaccoglitorePlichi();
		return instance;
	}

	/**
	 * 
	 * @return JScrollPane
	 */
	public JScrollPane getScrollPaneWrapper() {
		return scrollPaneWrapper;
	}

}

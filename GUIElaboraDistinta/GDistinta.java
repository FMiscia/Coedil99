package GUIElaboraDistinta;

import javax.swing.JPanel;
import javax.swing.JTable;


public class GDistinta extends JPanel {
	

	/**
	 * Create the panel.
	 */
	public GDistinta() {
		
		DistintaTable d = new DistintaTable();
		JTable table = new JTable(d.getRighe(),d.getColonne());
		add(table);

	}

}

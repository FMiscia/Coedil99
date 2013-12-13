package GUI.Avvisi;

import java.awt.Dimension;

import GUI.Abstract.AAvviso;

@SuppressWarnings("serial")
public class AvvisoRigaLavoro extends AAvviso {

	public AvvisoRigaLavoro(){
		super();
		this.avviso.setText("NON CI SONO ");
		this.avviso2.setText("RIGHE LAVORO");
		this.setPreferredSize(new Dimension(this.getWidth(),90));
	}
}

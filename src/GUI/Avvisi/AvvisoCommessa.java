package GUI.Avvisi;

import java.awt.Font;

import GUI.Abstract.AAvviso;

@SuppressWarnings("serial")
public class AvvisoCommessa extends AAvviso {

	public AvvisoCommessa(){
		super();
		this.avviso.setText("NON CI SONO COMMESSE");
		this.avviso.setFont(new Font("Tahoma", Font.BOLD, 22));
	}
}

package GUIelaborazione2;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.Iterator;

import elaboradistinta.controller.GestisciCommessaHandler;
import elaboradistinta.model.Distinta;
import elaboradistinta.model.RigaLavoro;

import GUIelaborazione2.Riquadri.RiquadroDatiDistinta;

public class PlicoDistinta extends Plico {

	private static PlicoDistinta instance = null;

	private PlicoDistinta() {
		setBorder(null);
		setLayout(new FlowLayout());

		// rd = new RiquadroDatiDistinta("Lavoro");
		// rd.setBounds(40, 20,rd.getWidth(),rd.getHeight());
		setPreferredSize(new Dimension(745, 1000));
		setSize(745, 950);
		// this.add(rd);

		// rd.addComponentListener(new ComponentAdapter() {
		// @Override
		// public void componentResized(ComponentEvent e) {
		// validate();
		// repaint();
		// }
		// });
	}

	@Override
	public void load() {
		// TODO Auto-generated method stub

	}

	public static PlicoDistinta getInstance() {
		if (PlicoDistinta.instance == null)
			PlicoDistinta.instance = new PlicoDistinta();
		return PlicoDistinta.instance;
	}

	@Override
	public void load(int id) {
		// TODO Auto-generated method stub
		this.removeAll();
		Distinta d = (Distinta) GestisciCommessaHandler.getInstance()
				.getCommessaById(id).getDistinta();
		if (d != null && d.getLavori().size()!= 0) {
			for(int i=0; i<d.getLavori().size(); i++){
				RiquadroDatiDistinta temp = new RiquadroDatiDistinta(
						"Riga Lavoro");
				temp.load(d.getLavori().get(i));
				this.add(temp);
			}
		}
		else{
			this.add(new RiquadroDatiDistinta(
					"Riga Lavoro"));
		}
		this.validate();
		this.repaint();
	}

}

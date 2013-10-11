package GUI.Plichi;

import java.awt.BorderLayout;
import javax.swing.JButton;

import GUI.Abstract.APlico;
import GUI.Liste.ListaRigheRDA;

public class PlicoRDA extends APlico {

	private static PlicoRDA instance = null;
	private ListaRigheRDA listaRigheRDA;

	private PlicoRDA() {
		setLayout(new BorderLayout());
		addListaRigheRDA();
	}


	private void addListaRigheRDA() {
		// TODO Auto-generated method stub
		this.listaRigheRDA = new ListaRigheRDA();
		this.add(listaRigheRDA,BorderLayout.WEST);
	}


	public static PlicoRDA getInstance() {
		if (PlicoRDA.instance == null)
			PlicoRDA.instance = new PlicoRDA();
		return PlicoRDA.instance;
	}


	@Override
	public void load() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void load(int id) {
		// TODO Auto-generated method stub
		
	}


	public ListaRigheRDA getListaRigheRDA() {
		return listaRigheRDA;
	}


	public void setListaRigheRDA(ListaRigheRDA listaRigheRDA) {
		this.listaRigheRDA = listaRigheRDA;
	}


}

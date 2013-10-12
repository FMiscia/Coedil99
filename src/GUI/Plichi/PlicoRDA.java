package GUI.Plichi;

import java.awt.BorderLayout;

import GUI.FormRDA;
import GUI.Abstract.APlico;
import GUI.Liste.ListaRigheRDA;
import GUI.Liste.ListaRigheRDAFactory;

public class PlicoRDA extends APlico {

	private static PlicoRDA instance = null;
	private ListaRigheRDA listaRigheRDA;
	private FormRDA formRDA;

	private PlicoRDA() {
		setLayout(new BorderLayout());
		addListaRigheRDA();
		addFormRDA();
		this.validate();
		this.repaint();
	}


	private void addListaRigheRDA() {
		// TODO Auto-generated method stub
		this.listaRigheRDA = (ListaRigheRDA) ListaRigheRDAFactory.getInstance().makeLista();
		this.add(listaRigheRDA,BorderLayout.WEST);
	}
	
	private void addFormRDA(){
		this.formRDA = new FormRDA();
		this.add(formRDA,BorderLayout.CENTER);
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

	
	public void resetFormRDA(){
		this.formRDA.reset();
	}

}

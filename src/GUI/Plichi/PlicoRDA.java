package GUI.Plichi;

import java.awt.BorderLayout;
import javax.swing.JButton;

import GUI.Abstract.AFormRDA;
import GUI.Abstract.APlico;
import GUI.Liste.ListaRigheRDA;

public class PlicoRDA extends APlico {

	private static PlicoRDA instance = null;
	private ListaRigheRDA listaRigheRDA;
	private AFormRDA formRDA = null;

	private PlicoRDA() {
		setLayout(new BorderLayout());
		addListaRigheRDA();
		this.validate();
		this.repaint();
	}


	private void addListaRigheRDA() {
		// TODO Auto-generated method stub
		this.listaRigheRDA = new ListaRigheRDA();
		this.add(listaRigheRDA,BorderLayout.WEST);
	}
	
	public void addFormRDA(AFormRDA formRDA){
		if(this.formRDA != null)
			this.remove(this.formRDA);
		this.formRDA = formRDA;
		this.add(formRDA, BorderLayout.CENTER);
		this.validate();
		this.repaint();	
		
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
		if(this.formRDA != null)
			this.remove(this.formRDA);
		this.validate();
		this.repaint();
	}

}

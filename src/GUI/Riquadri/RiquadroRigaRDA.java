package GUI.Riquadri;

import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JTextField;

import GUI.Abstract.ARiquadro;

public class RiquadroRigaRDA extends ARiquadro {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Dimension dimension = new Dimension(600, 330);

	public RiquadroRigaRDA(String title) {
		super(title);
		// TODO Auto-generated constructor stub
		this.Container = new ArrayList<JTextField>();
		this.setPreferredSize(new Dimension(600, 300));
		this.addRiquadro();
	}

	public void addRiquadro() {

	}

	@Override
	public void load(Object o) {

	}

	@Override
	public void makeEditable(boolean editable) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void resetRiquadro() {
		// TODO Auto-generated method stub

	}

	@Override
	public void avoidEditing() {
		super.avoidEditing();
	}

	@Override
	public void enableEditing() {
		super.enableEditing();
	}

	@Override
	protected void salva() {
	}

	public static Dimension getFormDimension() {
		return RiquadroRigaRDA.dimension;
	}

}
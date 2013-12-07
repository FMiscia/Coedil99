package GUI.Form;

import java.awt.Dimension;

import javax.swing.JOptionPane;

import GUI.ProgrammaLavori;
import GUI.Abstract.AFormDistinta;
import GUI.Plichi.PlicoDistinta;
import coedil99.model.MDistinta;
import coedil99.model.MGeometria;
import coedil99.model.MRigaLavoro;
import coedil99.persistentmodel.RigaLavoro;

/**
 * Riquadro dati distinta
 * 
 * @author Simone
 * 
 */
@SuppressWarnings("serial")
public class FormDistinta extends AFormDistinta {

	private static final Dimension dimension = new Dimension(600, 330);

	public FormDistinta() {
		super();
		this.makeEditable(false);
	}

	/**
	 * Carica il contenuto del riquadro
	 */
	@Override
	public void load(Object o) {
		MRigaLavoro d = new MRigaLavoro();
		d.setPersistentModel((RigaLavoro) o);
		if (d != null) {
			this.tflunghezza.setText(String.valueOf(d.getPersistentModel()
					.getGeometria().getLunghezza()));
			this.tfaltezza.setText(String.valueOf(d.getPersistentModel()
					.getGeometria().getAltezza()));
			this.tfbase.setText(String.valueOf(d.getPersistentModel()
					.getGeometria().getBase()));
			this.tfnumero.setText(String.valueOf(d.getPersistentModel()
					.getNumero()));
			this.cbcapitello.setSelectedIndex((d.getPersistentModel()
					.getCapitello()) ? 0 : 1);
			this.tftipocapitello.setText(d.getPersistentModel()
					.getProfiloCapitello());
			this.lblIcoTipoCapitello.setIcon(null);
			this.tfnote.setText(d.getPersistentModel().getNote());
			this.makeEditable(false);
			this.oggetto = d;
		}
	}

	/**
	 * Rende editabile il campo
	 */
	@Override
	public void makeEditable(boolean editable) {
		this.cbcapitello.setEnabled(editable);
		super.makeEditable(editable);
		if(this.cbcapitello.getSelectedItem().equals("No"))
			this.tftipocapitello.setEnabled(false);
		setEditing(checkEmpty());
	}

	@Override
	protected void resetRiquadro() {
	}

	/**
	 * Abilita la modifica
	 */
	@Override
	public void enableEditing() {
		super.enableEditing();
	}

	/**
	 * Salva le modifiche sul db
	 */
	@Override
	public void salva(boolean showmex) {
		MRigaLavoro r = new MRigaLavoro();

		if (this.oggetto != null) {
			r = (MRigaLavoro) this.oggetto;
		} else {
			MDistinta d = new MDistinta(ProgrammaLavori.getInstance()
					.getCommessaSelezionata().getPersistentModel()
					.getDistinta().getID());
			d.getPersistentModel().lavori.add(r.getPersistentModel());
		}
		PlicoDistinta.getInstance().addRiquadroinLista(this);
		MGeometria g = new MGeometria();
		g.getPersistentModel().setBase(Float.parseFloat(this.tfbase.getText()));
		g.getPersistentModel().setAltezza(
				Float.parseFloat(this.tfaltezza.getText()));
		g.getPersistentModel().setLunghezza(
				Float.parseFloat(this.tflunghezza.getText()));
		r.getPersistentModel().setGeometria(g.getPersistentModel());
		r.getPersistentModel().setCapitello(
				this.cbcapitello.getSelectedIndex() == 0 ? true : false);
		r.getPersistentModel().setProfiloCapitello(
				this.tftipocapitello.getText());
		r.getPersistentModel().setNumero(
				Integer.parseInt(this.tfnumero.getText()));
		r.getPersistentModel().setNote(this.tfnote.getText());
		r.save();
		this.oggetto = r;
		if (showmex)
			JOptionPane.showMessageDialog(null,
					"Salvataggio avvenuto correttamente",
					"Messaggio di Sistema", JOptionPane.INFORMATION_MESSAGE);
		this.load(((MRigaLavoro)this.oggetto).getPersistentModel());
	}

	public static Dimension getFormDimension() {
		return FormDistinta.dimension;
	}
	
}

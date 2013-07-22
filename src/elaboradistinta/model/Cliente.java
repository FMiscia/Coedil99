package elaboradistinta.model;

import java.util.ArrayList;
import elaboradistinta.model.Ordine;

public class Cliente {
	
	private int _iD;
	private String _name;
	private Integer _numeroCommessaCliente;
	private Cantiere _cantiere;
	public ArrayList<Ordine> _ordini = new ArrayList<Ordine>();

	public Cliente(String aN, Cantiere aC) {
		throw new UnsupportedOperationException();
	}

	public void setCantiere(Cantiere aCantiere) {
		this._cantiere = aCantiere;
	}

	public Cantiere getCantiere() {
		return this._cantiere;
	}

	public void setName(String aName) {
		this._name = aName;
	}

	public String getName() {
		return this._name;
	}

	public void setNumeroCommessaCliente(Integer aNumeroCommessaCliente) {
		this._numeroCommessaCliente = aNumeroCommessaCliente;
	}

	public Integer getNumeroCommessaCliente() {
		return this._numeroCommessaCliente;
	}

	public int get_iD() {
		return _iD;
	}

}
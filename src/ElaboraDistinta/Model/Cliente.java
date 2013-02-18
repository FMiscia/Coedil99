package ElaboraDistinta.Model;

import java.util.ArrayList;


public class Cliente {
	
	private String name;
	private Cantiere cantiere;
	ArrayList<Ordine> ordine;
	private Integer numeroCommessaCliente;
	
	public Cliente(String n, Cantiere c){
		this.setName(n);
		this.setCantiere(c);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Cantiere getCantiere() {
		return cantiere;
	}

	public void setCantiere(Cantiere cantiere) {
		this.cantiere = cantiere;
	}
	

	public Integer getNumeroCommessaCliente() {
		return numeroCommessaCliente;
	}

	public void setNumeroCommessaCliente(Integer numeroCommessaCliente) {
		this.numeroCommessaCliente = numeroCommessaCliente;
	}
}
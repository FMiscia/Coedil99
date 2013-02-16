package ElaboraDistinta;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
	
	private String name;
	private Cantiere cantiere;
	ArrayList<Ordine> ordine;
	
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
}
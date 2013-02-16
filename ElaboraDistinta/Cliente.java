package ElaboraDistinta;

import java.util.List;

public class Cliente {
	


	private String name;
	List<Ordine> ordine;
	
	public Cliente(String n){
		this.setName(n);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
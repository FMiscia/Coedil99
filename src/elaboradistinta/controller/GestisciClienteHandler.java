package elaboradistinta.controller;

import java.util.ArrayList;
import java.util.Arrays;
import elaboradistinta.model.Cliente;

public class GestisciClienteHandler {
	
	private int id;
	private ArrayList<Cliente> clienti = null;
	private static GestisciClienteHandler instance;
	
	private GestisciClienteHandler() {
		this.clienti = new ArrayList<Cliente>();
	}

	public void addOrdine(Cliente c) {
		this.clienti.add(c);
	}

	public ArrayList<Cliente> getClienti(){
		return this.clienti;
	}
	
	public Cliente getClienteById(int id){
		for(Cliente c : clienti){
			if(c.get_iD() == id)
				return c;
		}
		return null;
	}
	
	public static GestisciClienteHandler getInstance() {
		if (GestisciClienteHandler.instance == null) {
			GestisciClienteHandler.instance = new GestisciClienteHandler();
		}

		return GestisciClienteHandler.instance;
	}

}


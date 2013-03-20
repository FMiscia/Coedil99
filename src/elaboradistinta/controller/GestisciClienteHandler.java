package elaboradistinta.controller;

import java.util.ArrayList;
import java.util.Arrays;
import elaboradistinta.model.Cliente;
import elaboradistinta.model.ClienteFactory;

public class GestisciClienteHandler {
	
	private int id;
	private ArrayList<Cliente> clienti = null;
	private static GestisciClienteHandler instance;
	
	public GestisciClienteHandler() {
		this.clienti = new ArrayList<Cliente>(Arrays.asList(ClienteFactory.listClienteByQuery(null, "ID")));
	}

	public void addOrdine(Cliente c) {
		this.clienti.add(c);
	}

	public ArrayList<Cliente> getClienti(){
		return this.clienti;
	}
	
	public static GestisciClienteHandler getInstance() {
		if (GestisciClienteHandler.instance == null) {
			GestisciClienteHandler.instance = new GestisciClienteHandler();
		}

		return GestisciClienteHandler.instance;
	}

}


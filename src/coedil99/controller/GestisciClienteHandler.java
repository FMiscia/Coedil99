package coedil99.controller;

import java.util.ArrayList;
import java.util.Arrays;

import coedil99.model.Cliente;
import coedil99.model.ClienteFactory;

public class GestisciClienteHandler {
	
	private int id;
	private ArrayList<Cliente> clienti = null;
	private static GestisciClienteHandler instance;
	
	private GestisciClienteHandler() {
		this.clienti = new ArrayList<Cliente>(Arrays.asList(ClienteFactory.listClienteByQuery(null, "ID")));
	}

	public void addOrdine(Cliente c) {
		this.clienti.add(c);
	}

	public ArrayList<Cliente> getClienti(){
		return this.clienti;
	}
	
	public Cliente getClienteById(int id){
		return ClienteFactory.getClienteByORMID(id);
	}
	
	public static GestisciClienteHandler getInstance() {
		if (GestisciClienteHandler.instance == null) {
			GestisciClienteHandler.instance = new GestisciClienteHandler();
		}

		return GestisciClienteHandler.instance;
	}

}


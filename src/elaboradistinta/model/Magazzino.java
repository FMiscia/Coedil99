package elaboradistinta.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.JOptionPane;


public class Magazzino {

	Catalogo catalogo;
	private HashMap<Item,Integer> items;
	private String name;

	public Magazzino(){
		/*esegue lo startup*/
		this.items = new HashMap<Item,Integer>();
		this.catalogo = new Catalogo();
		ArrayList<Item> cItem = new ArrayList<Item>(this.catalogo.getItems());
		ArrayList<DocumentoOttimizzazione> doc = new ArrayList<DocumentoOttimizzazione>
			(Arrays.asList(DocumentoOttimizzazioneFactory.listDocumentoOttimizzazioneByQuery(null, null)));
		if(doc.size() == 0){
			for(int i=0; i<cItem.size(); ++i){
					this.items.put(cItem.get(i), 1);
				}
		}
		else{
			for(int j=0; j<doc.size(); ++j){
				for(int i=0; i<cItem.size(); ++i){
					if(doc.get(j).items.contains(cItem.get(i)) == false)
						this.items.put(cItem.get(i), 1);
					}
			}
		}
	}
	
	public HashMap<Item,Integer> getItems(){
		return this.items;
	}
	
	public Catalogo getCatalogo(){
		return this.catalogo;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


}
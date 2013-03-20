/**
 * Licensee: DuKe TeAm
 * License Type: Purchased
 */
package ormsamples;

import org.orm.*;
public class ListCoedilData {
	private static final int ROW_COUNT = 100;
	
	public void listTestData() throws PersistentException {
		System.out.println("Listing Cantiere...");
		elaboradistinta.model.Cantiere[] elaboraDistintaModelCantieres = elaboradistinta.model.Cantiere.listCantiereByQuery(null, null);
		int length = Math.min(elaboraDistintaModelCantieres.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(elaboraDistintaModelCantieres[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Commessa...");
		elaboradistinta.model.Commessa[] elaboraDistintaModelCommessas = elaboradistinta.model.Commessa.listCommessaByQuery(null, null);
		length = Math.min(elaboraDistintaModelCommessas.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(elaboraDistintaModelCommessas[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Cliente...");
		elaboradistinta.model.Cliente[] elaboraDistintaModelClientes = elaboradistinta.model.Cliente.listClienteByQuery(null, null);
		length = Math.min(elaboraDistintaModelClientes.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(elaboraDistintaModelClientes[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Distinta...");
		elaboradistinta.model.Distinta[] elaboraDistintaModelDistintas = elaboradistinta.model.Distinta.listDistintaByQuery(null, null);
		length = Math.min(elaboraDistintaModelDistintas.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(elaboraDistintaModelDistintas[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing DocumentoOttimizzazione...");
		elaboradistinta.model.DocumentoOttimizzazione[] elaboraDistintaModelDocumentoOttimizzaziones = elaboradistinta.model.DocumentoOttimizzazione.listDocumentoOttimizzazioneByQuery(null, null);
		length = Math.min(elaboraDistintaModelDocumentoOttimizzaziones.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(elaboraDistintaModelDocumentoOttimizzaziones[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing ListaRintracciabilita...");
		elaboradistinta.model.ListaRintracciabilita[] elaboraDistintaModelListaRintracciabilitas = elaboradistinta.model.ListaRintracciabilita.listListaRintracciabilitaByQuery(null, null);
		length = Math.min(elaboraDistintaModelListaRintracciabilitas.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(elaboraDistintaModelListaRintracciabilitas[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing History...");
		elaboradistinta.model.History[] elaboraDistintaModelHistorys = elaboradistinta.model.History.listHistoryByQuery(null, null);
		length = Math.min(elaboraDistintaModelHistorys.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(elaboraDistintaModelHistorys[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Geometria...");
		elaboradistinta.model.Geometria[] elaboraDistintaModelGeometrias = elaboradistinta.model.Geometria.listGeometriaByQuery(null, null);
		length = Math.min(elaboraDistintaModelGeometrias.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(elaboraDistintaModelGeometrias[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Item...");
		elaboradistinta.model.Item[] elaboraDistintaModelItems = elaboradistinta.model.Item.listItemByQuery(null, null);
		length = Math.min(elaboraDistintaModelItems.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(elaboraDistintaModelItems[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Ordine...");
		elaboradistinta.model.Ordine[] elaboraDistintaModelOrdines = elaboradistinta.model.Ordine.listOrdineByQuery(null, null);
		length = Math.min(elaboraDistintaModelOrdines.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(elaboraDistintaModelOrdines[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing RigaLavoro...");
		elaboradistinta.model.RigaLavoro[] elaboraDistintaModelRigaLavoros = elaboradistinta.model.RigaLavoro.listRigaLavoroByQuery(null, null);
		length = Math.min(elaboraDistintaModelRigaLavoros.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(elaboraDistintaModelRigaLavoros[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing RigheLavoro...");
		elaboradistinta.model.RigheLavoro[] elaboraDistintaModelRigheLavoros = elaboradistinta.model.RigheLavoro.listRigheLavoroByQuery(null, null);
		length = Math.min(elaboraDistintaModelRigheLavoros.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(elaboraDistintaModelRigheLavoros[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
	}
	
	public void listByCriteria() throws PersistentException  {
		System.out.println("Listing Cantiere by Criteria...");
		elaboradistinta.model.CantiereCriteria cantiereCriteria = new elaboradistinta.model.CantiereCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//cantiereCriteria.ID.eq();
		cantiereCriteria.setMaxResults(ROW_COUNT);
		elaboradistinta.model.Cantiere[] elaboraDistintaModelCantieres = cantiereCriteria.listCantiere();
		int length =elaboraDistintaModelCantieres== null ? 0 : Math.min(elaboraDistintaModelCantieres.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(elaboraDistintaModelCantieres[i]);
		}
		System.out.println(length + " Cantiere record(s) retrieved."); 
		
		System.out.println("Listing Commessa by Criteria...");
		elaboradistinta.model.CommessaCriteria commessaCriteria = new elaboradistinta.model.CommessaCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//commessaCriteria.ID.eq();
		commessaCriteria.setMaxResults(ROW_COUNT);
		elaboradistinta.model.Commessa[] elaboraDistintaModelCommessas = commessaCriteria.listCommessa();
		length =elaboraDistintaModelCommessas== null ? 0 : Math.min(elaboraDistintaModelCommessas.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(elaboraDistintaModelCommessas[i]);
		}
		System.out.println(length + " Commessa record(s) retrieved."); 
		
		System.out.println("Listing Cliente by Criteria...");
		elaboradistinta.model.ClienteCriteria clienteCriteria = new elaboradistinta.model.ClienteCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//clienteCriteria.ID.eq();
		clienteCriteria.setMaxResults(ROW_COUNT);
		elaboradistinta.model.Cliente[] elaboraDistintaModelClientes = clienteCriteria.listCliente();
		length =elaboraDistintaModelClientes== null ? 0 : Math.min(elaboraDistintaModelClientes.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(elaboraDistintaModelClientes[i]);
		}
		System.out.println(length + " Cliente record(s) retrieved."); 
		
		System.out.println("Listing Distinta by Criteria...");
		elaboradistinta.model.DistintaCriteria distintaCriteria = new elaboradistinta.model.DistintaCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//distintaCriteria.ID.eq();
		distintaCriteria.setMaxResults(ROW_COUNT);
		elaboradistinta.model.Distinta[] elaboraDistintaModelDistintas = distintaCriteria.listDistinta();
		length =elaboraDistintaModelDistintas== null ? 0 : Math.min(elaboraDistintaModelDistintas.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(elaboraDistintaModelDistintas[i]);
		}
		System.out.println(length + " Distinta record(s) retrieved."); 
		
		System.out.println("Listing DocumentoOttimizzazione by Criteria...");
		elaboradistinta.model.DocumentoOttimizzazioneCriteria documentoOttimizzazioneCriteria = new elaboradistinta.model.DocumentoOttimizzazioneCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//documentoOttimizzazioneCriteria.ID.eq();
		documentoOttimizzazioneCriteria.setMaxResults(ROW_COUNT);
		elaboradistinta.model.DocumentoOttimizzazione[] elaboraDistintaModelDocumentoOttimizzaziones = documentoOttimizzazioneCriteria.listDocumentoOttimizzazione();
		length =elaboraDistintaModelDocumentoOttimizzaziones== null ? 0 : Math.min(elaboraDistintaModelDocumentoOttimizzaziones.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(elaboraDistintaModelDocumentoOttimizzaziones[i]);
		}
		System.out.println(length + " DocumentoOttimizzazione record(s) retrieved."); 
		
		System.out.println("Listing ListaRintracciabilita by Criteria...");
		elaboradistinta.model.ListaRintracciabilitaCriteria listaRintracciabilitaCriteria = new elaboradistinta.model.ListaRintracciabilitaCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//listaRintracciabilitaCriteria.ID.eq();
		listaRintracciabilitaCriteria.setMaxResults(ROW_COUNT);
		elaboradistinta.model.ListaRintracciabilita[] elaboraDistintaModelListaRintracciabilitas = listaRintracciabilitaCriteria.listListaRintracciabilita();
		length =elaboraDistintaModelListaRintracciabilitas== null ? 0 : Math.min(elaboraDistintaModelListaRintracciabilitas.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(elaboraDistintaModelListaRintracciabilitas[i]);
		}
		System.out.println(length + " ListaRintracciabilita record(s) retrieved."); 
		
		System.out.println("Listing History by Criteria...");
		elaboradistinta.model.HistoryCriteria historyCriteria = new elaboradistinta.model.HistoryCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//historyCriteria.ID.eq();
		historyCriteria.setMaxResults(ROW_COUNT);
		elaboradistinta.model.History[] elaboraDistintaModelHistorys = historyCriteria.listHistory();
		length =elaboraDistintaModelHistorys== null ? 0 : Math.min(elaboraDistintaModelHistorys.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(elaboraDistintaModelHistorys[i]);
		}
		System.out.println(length + " History record(s) retrieved."); 
		
		System.out.println("Listing Geometria by Criteria...");
		elaboradistinta.model.GeometriaCriteria geometriaCriteria = new elaboradistinta.model.GeometriaCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//geometriaCriteria.ID.eq();
		geometriaCriteria.setMaxResults(ROW_COUNT);
		elaboradistinta.model.Geometria[] elaboraDistintaModelGeometrias = geometriaCriteria.listGeometria();
		length =elaboraDistintaModelGeometrias== null ? 0 : Math.min(elaboraDistintaModelGeometrias.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(elaboraDistintaModelGeometrias[i]);
		}
		System.out.println(length + " Geometria record(s) retrieved."); 
		
		System.out.println("Listing Item by Criteria...");
		elaboradistinta.model.ItemCriteria itemCriteria = new elaboradistinta.model.ItemCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//itemCriteria.ID.eq();
		itemCriteria.setMaxResults(ROW_COUNT);
		elaboradistinta.model.Item[] elaboraDistintaModelItems = itemCriteria.listItem();
		length =elaboraDistintaModelItems== null ? 0 : Math.min(elaboraDistintaModelItems.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(elaboraDistintaModelItems[i]);
		}
		System.out.println(length + " Item record(s) retrieved."); 
		
		System.out.println("Listing Ordine by Criteria...");
		elaboradistinta.model.OrdineCriteria ordineCriteria = new elaboradistinta.model.OrdineCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//ordineCriteria.ID.eq();
		ordineCriteria.setMaxResults(ROW_COUNT);
		elaboradistinta.model.Ordine[] elaboraDistintaModelOrdines = ordineCriteria.listOrdine();
		length =elaboraDistintaModelOrdines== null ? 0 : Math.min(elaboraDistintaModelOrdines.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(elaboraDistintaModelOrdines[i]);
		}
		System.out.println(length + " Ordine record(s) retrieved."); 
		
		System.out.println("Listing RigaLavoro by Criteria...");
		elaboradistinta.model.RigaLavoroCriteria rigaLavoroCriteria = new elaboradistinta.model.RigaLavoroCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//rigaLavoroCriteria.ID.eq();
		rigaLavoroCriteria.setMaxResults(ROW_COUNT);
		elaboradistinta.model.RigaLavoro[] elaboraDistintaModelRigaLavoros = rigaLavoroCriteria.listRigaLavoro();
		length =elaboraDistintaModelRigaLavoros== null ? 0 : Math.min(elaboraDistintaModelRigaLavoros.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(elaboraDistintaModelRigaLavoros[i]);
		}
		System.out.println(length + " RigaLavoro record(s) retrieved."); 
		
		System.out.println("Listing RigheLavoro by Criteria...");
		elaboradistinta.model.RigheLavoroCriteria righeLavoroCriteria = new elaboradistinta.model.RigheLavoroCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//righeLavoroCriteria.ID.eq();
		righeLavoroCriteria.setMaxResults(ROW_COUNT);
		elaboradistinta.model.RigheLavoro[] elaboraDistintaModelRigheLavoros = righeLavoroCriteria.listRigheLavoro();
		length =elaboraDistintaModelRigheLavoros== null ? 0 : Math.min(elaboraDistintaModelRigheLavoros.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(elaboraDistintaModelRigheLavoros[i]);
		}
		System.out.println(length + " RigheLavoro record(s) retrieved."); 
		
	}
	
	public static void main(String[] args) {
		try {
			ListCoedilData listCoedilData = new ListCoedilData();
			try {
				listCoedilData.listTestData();
				//listCoedilData.listByCriteria();
			}
			finally {
				elaboradistinta.model.CoedilPersistentManager.instance().disposePersistentManager();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}

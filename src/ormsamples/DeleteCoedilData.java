/**
 * Licensee: DuKe TeAm
 * License Type: Purchased
 */
package ormsamples;

import org.orm.*;
public class DeleteCoedilData {
	public void deleteTestData() throws PersistentException {
		PersistentTransaction t = elaboradistinta.model.CoedilPersistentManager.instance().getSession().beginTransaction();
		try {
			elaboradistinta.model.Cantiere elaboraDistintaModelCantiere = elaboradistinta.model.Cantiere.loadCantiereByQuery(null, null);
			elaboraDistintaModelCantiere.delete();
			elaboradistinta.model.Commessa elaboraDistintaModelCommessa = elaboradistinta.model.Commessa.loadCommessaByQuery(null, null);
			elaboraDistintaModelCommessa.delete();
			elaboradistinta.model.Cliente elaboraDistintaModelCliente = elaboradistinta.model.Cliente.loadClienteByQuery(null, null);
			elaboraDistintaModelCliente.delete();
			elaboradistinta.model.Distinta elaboraDistintaModelDistinta = elaboradistinta.model.Distinta.loadDistintaByQuery(null, null);
			elaboraDistintaModelDistinta.delete();
			elaboradistinta.model.DocumentoOttimizzazione elaboraDistintaModelDocumentoOttimizzazione = elaboradistinta.model.DocumentoOttimizzazione.loadDocumentoOttimizzazioneByQuery(null, null);
			elaboraDistintaModelDocumentoOttimizzazione.delete();
			elaboradistinta.model.ListaRintracciabilita elaboraDistintaModelListaRintracciabilita = elaboradistinta.model.ListaRintracciabilita.loadListaRintracciabilitaByQuery(null, null);
			elaboraDistintaModelListaRintracciabilita.delete();
			elaboradistinta.model.History elaboraDistintaModelHistory = elaboradistinta.model.History.loadHistoryByQuery(null, null);
			elaboraDistintaModelHistory.delete();
			elaboradistinta.model.Geometria elaboraDistintaModelGeometria = elaboradistinta.model.Geometria.loadGeometriaByQuery(null, null);
			elaboraDistintaModelGeometria.delete();
			elaboradistinta.model.Item elaboraDistintaModelItem = elaboradistinta.model.Item.loadItemByQuery(null, null);
			elaboraDistintaModelItem.delete();
			elaboradistinta.model.Ordine elaboraDistintaModelOrdine = elaboradistinta.model.Ordine.loadOrdineByQuery(null, null);
			elaboraDistintaModelOrdine.delete();
			elaboradistinta.model.RigaLavoro elaboraDistintaModelRigaLavoro = elaboradistinta.model.RigaLavoro.loadRigaLavoroByQuery(null, null);
			elaboraDistintaModelRigaLavoro.delete();
			elaboradistinta.model.RigheLavoro elaboraDistintaModelRigheLavoro = elaboradistinta.model.RigheLavoro.loadRigheLavoroByQuery(null, null);
			elaboraDistintaModelRigheLavoro.delete();
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			DeleteCoedilData deleteCoedilData = new DeleteCoedilData();
			try {
				deleteCoedilData.deleteTestData();
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

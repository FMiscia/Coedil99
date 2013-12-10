package coedil99.model;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

import au.com.bytecode.opencsv.CSVReader;

/**
 * 
 * @author francesco
 * 
 * Pattern Builder
 */
public class CatalogoCSVBuilder extends CatalogoFornitoreBuilder {

	/**
	 * Implementazione del metoro parse del builder.
	 * 
	 */
	@Override
	public void Parse(String catalogo) throws IOException {
		CSVReader reader = new CSVReader(new FileReader(catalogo), '#');
		String[] intestazione = reader.readNext();
		String[] row = null;
		while ((row = reader.readNext()) != null) {
			MProductDescription new_productDescription = new MProductDescription();
			new_productDescription.getPersistentModel().setEssenza(row[0]);
			new_productDescription.getPersistentModel().setPrezzo(Float.parseFloat(row[1]));
			new_productDescription.getPersistentModel().setPezzi_per_pacco(Integer.valueOf(row[2]));
			
			MGeometria new_geometria = new MGeometria();
			new_geometria.getPersistentModel().setBase(Float.parseFloat(row[3]));
			new_geometria.getPersistentModel().setAltezza(Float.parseFloat(row[4]));
			new_geometria.getPersistentModel().setLunghezza(Float.parseFloat(row[5]));
			
			new_productDescription.getPersistentModel().setGeometria(new_geometria.getPersistentModel());
			this.catalogo.getPersistentModel().productDescription.add(new_productDescription.getPersistentModel());
			this.catalogo.save();
		}
		reader.close();

	}
}
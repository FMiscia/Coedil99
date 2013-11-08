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
		//URL url = CatalogoCSVBuilder.class.getResource("/GUI/TestFile/"+catalogo);
		CSVReader reader = new CSVReader(new FileReader(catalogo), '#');
		//String[] fornitore = reader.readNext();
		//String[] nome_fornitore = reader.readNext();
		String[] intestazione = reader.readNext();
		//this.catalogo.getPersistentModel().setName(nome_fornitore[0]);
		//System.out.println(nome_fornitore[0]);
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
			//new_productDescription.save();
			//new_geometria.save();
		}
		reader.close();

	}
}
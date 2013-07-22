package elaboradistinta.model;

import java.util.ArrayList;
import elaboradistinta.model.RigaLavoro;

public class Distinta {
	private int _iD;
	private static int _count;
	private DocumentoOttimizzazione _ddo;
	public ArrayList<RigaLavoro> _lavori = new ArrayList<RigaLavoro>();

	public Distinta() {
		throw new UnsupportedOperationException();
	}

	public void creaDDO() {
		throw new UnsupportedOperationException();
	}


	public void setDdo(DocumentoOttimizzazione aDdo) {
		this._ddo = aDdo;
	}

	public DocumentoOttimizzazione getDdo() {
		return this._ddo;
	}

	public int getID() {
		return this._iD;
	}
}
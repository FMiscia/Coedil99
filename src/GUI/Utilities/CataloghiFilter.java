package GUI.Utilities;

import java.io.File;
import javax.swing.filechooser.*;

/* ImageFilter.java is used by FileChooserDemo2.java. */
public class CataloghiFilter extends FileFilter {

	public final static String csv = "csv";
	public final static String xml = "xml";

	/**
	 * Ritorna l'estenzione del file
	 * @param f
	 * @return
	 */
	public static String getExtension(File f) {
		String ext = null;
		String s = f.getName();
		int i = s.lastIndexOf('.');

		if (i > 0 && i < s.length() - 1) {
			ext = s.substring(i + 1).toLowerCase();
		}
		return ext;
	}

	// Accept all directories and all gif, jpg, tiff, or png files.
	public boolean accept(File f) {
		if (f.isDirectory()) {
			return true;
		}

		String extension = CataloghiFilter.getExtension(f);
		if (extension != null) {
			if (extension.equals(CataloghiFilter.csv) || extension.equals(CataloghiFilter.xml))
				return true;
			} else {
				return false;
			}
		return false;
	}

	// The description of this filter
	public String getDescription() {
		return "Solo file CSV o Xml";
	}
}
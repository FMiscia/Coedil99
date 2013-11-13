package GUI.Login;

import coedil99.controller.GestisciDipendenteHandler;
import coedil99.persistentmodel.Dipendente;

public class Login {
	
	private static boolean logged = false;
	private static int level = 0;
	
    public static boolean authenticate(String username, String password) {

    	Dipendente d = GestisciDipendenteHandler.getInstance().checkPass(username,password);
        if (d != null) {

        	logged = true;
        	level = d.getLevel();
            return true;
        }
        return false;
    }
    
    public static boolean getLogged() {
    	return logged;
    }
    
    public static int getLevel() {
    	return level;
    }

	public static void logOut() {
		// TODO Auto-generated method stub
		logged = false;
	}
}
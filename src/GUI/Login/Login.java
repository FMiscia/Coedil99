package GUI.Login;

import coedil99.controller.GestisciDipendenteHandler;
import coedil99.persistentmodel.Dipendente;

public class Login {
	
	private static boolean logged = false;
	
    public static boolean authenticate(String username, String password) {
    	Dipendente d = GestisciDipendenteHandler.getInstance().foo(username,password);
        if (d != null) {
        	logged = true;
            return true;
        }
        return false;
    }
    
    public static boolean getLogged() {
    	return logged;
    }

	public static void logOut() {
		// TODO Auto-generated method stub
		logged = false;
	}
}
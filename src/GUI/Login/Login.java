package GUI.Login;

public class Login {
	
	private static boolean logged = false;
	
    public static boolean authenticate(String username, String password) {
        if (username.equals("admin") && password.equals("admin")) {
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
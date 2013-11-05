package GUI.PLogin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import GUI.CoedilFrame;
import GUI.CommercialePanel;
import GUI.PanelStart;


public class LoginDialog extends JPanel {
        private static final String LOGIN = "Log in";
        private JLabel labUserName;
        private JTextField tfUserName;
        private JLabel labPassword;
        private JPasswordField tfPassword;
        private JButton btnLogin;
        private boolean succeeded;

        public LoginDialog() {


                labUserName = new JLabel("User name");
                tfUserName = new JTextField(15);
                labPassword = new JLabel("Password");
                tfPassword = new JPasswordField(15);
                btnLogin = new JButton(LOGIN);
                btnLogin.setDefaultCapable(true);

                add(labUserName);
                add(tfUserName);
                add(labPassword);
                add(tfPassword);
                add(btnLogin);


                ActionListener l = new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						
						// TODO Auto-generated method stub
                        if (Login.authenticate(getUserName(), new String(getPassword()))) {
                            LoginDialog.this.tfUserName.setText("");
                            LoginDialog.this.tfPassword.setText("");
                        	succeeded = true;
                            //qui controlla il level del dipendente e decidi 
                            //se entrare in panelstart o commerciale
                            
                            //ufficio tecnico 
                            if (Login.getLevel()==2){
                        		PanelStart ps = PanelStart.getInstance();
                        		CoedilFrame cf = CoedilFrame.getInstance();
                        		ps.setBounds(0, 0, cf.getWidth(), cf.getHeight());
                        		cf.montaPanel(ps);                            	
                            }
                            
                            //ufficio commerciale
                            if (Login.getLevel()==1){
                        		CommercialePanel cp = CommercialePanel.getInstance();
                        		CoedilFrame cf = CoedilFrame.getInstance();
                        		cp.setBounds(0, 0, cf.getWidth(), cf.getHeight());
                        		cf.montaPanel(cp);   
                            }

                        } else {
                            JOptionPane.showMessageDialog(LoginDialog.this,
                            		"Invalid username or password",
                                    "Login",
                                    JOptionPane.ERROR_MESSAGE);
                            // reset username and password
                            LoginDialog.this.tfUserName.setText("");
                            LoginDialog.this.tfPassword.setText("");
                            succeeded = false;
         
                        }
                        
					}
				};
                btnLogin.addActionListener(l);

        }

        /**
         * Get the contents of the user name field
         *
         * @return The value of the user name field
         */
        public String getUserName() {
                return tfUserName.getText();
        }

        /**
         * Get the password from the password field
         *
         * @return The password as char[]
         */
        public char[] getPassword() {
                return tfPassword.getPassword();
        }

		public boolean isSucceeded() {
			// TODO Auto-generated method stub
			return this.succeeded;
		}
}

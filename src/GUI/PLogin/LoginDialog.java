package GUI.PLogin;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import GUI.CoedilFrame;
import GUI.CommercialeCenter;
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

		GridBagLayout ml = new GridBagLayout();
		GridBagConstraints mlc = new GridBagConstraints();
		// imposta il gestore del layout di tipo GridBagLayout
		setLayout(ml);

		// il gestore interessa sia lo spazio orizzontale che verticale
		mlc.fill = GridBagConstraints.BOTH;

		mlc.gridwidth = 1;
		mlc.gridy = 1;
		mlc.gridx = 0;
		mlc.insets = new Insets(10, 10, 10, 10);

		try {
			Image img = ImageIO.read(getClass().getResource(
					"/GUI/image/coedil.png"));
			BufferedImage myPicture = (BufferedImage) img;
			JLabel picLabel = new JLabel(new ImageIcon(myPicture));
			ml.setConstraints(picLabel, mlc);
			add(picLabel);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		mlc.gridy = 2; 
        mlc.gridx = 0;
		JLabel label = new JLabel("Inserisci Username e Password",
				JLabel.CENTER);
		label.setFont(new Font("Serif", Font.BOLD, 18));
		ml.setConstraints(label, mlc);
		add(label);

		
		JPanel jp = new JPanel();
		
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		jp.setLayout(gbl);
		gbc.fill = GridBagConstraints.BOTH;

		gbc.gridwidth = 1;
		gbc.insets = new Insets(10, 10, 10, 10);
		
		gbc.gridy = 1;
		gbc.gridx = 0;
		gbc.insets = new Insets(10, 10, 10, 10);
		labUserName = new JLabel("User name");
		gbl.setConstraints(labUserName, gbc);
		gbc.gridy = 1;
		gbc.gridx = 1;
		tfUserName = new JTextField(15);
		gbl.setConstraints(tfUserName, gbc);
		jp.add(labUserName);
		jp.add(tfUserName);

		gbc.gridy = 2;
		gbc.gridx = 0;
		labPassword = new JLabel("Password");
		gbl.setConstraints(labPassword, gbc);
		jp.add(labPassword);

		gbc.gridy = 2;
		gbc.gridx = 1;
		tfPassword = new JPasswordField(15);
		gbl.setConstraints(tfPassword, gbc);
		jp.add(tfPassword);

		gbc.gridy = 3;
		gbc.gridwidth = 3;
		gbc.gridx = 0;
		btnLogin = new JButton(LOGIN);
		gbl.setConstraints(btnLogin, gbc);
		jp.add(btnLogin);

		ActionListener l = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				// TODO Auto-generated method stub
				if (Login
						.authenticate(getUserName(), new String(getPassword()))) {
					LoginDialog.this.tfUserName.setText("");
					LoginDialog.this.tfPassword.setText("");
					succeeded = true;
					// qui controlla il level del dipendente e decidi
					// se entrare in panelstart o commerciale

					// ufficio tecnico
					if (Login.getLevel() == 2) {
						PanelStart ps = PanelStart.getInstance();
						CoedilFrame cf = CoedilFrame.getInstance();
						ps.setBounds(0, 0, cf.getWidth(), cf.getHeight());
						cf.montaPanel(ps);
					}

					// ufficio commerciale
					if (Login.getLevel() == 1) {
						CommercialeCenter cc = CommercialeCenter.getInstance();
						CoedilFrame cf = CoedilFrame.getInstance();
						cc.setBounds(0, 0, cf.getWidth(), cf.getHeight());
						cf.montaPanel(cc);
					}

				} else {
					JOptionPane.showMessageDialog(LoginDialog.this,
							"Invalid username or password", "Login",
							JOptionPane.ERROR_MESSAGE);
					// reset username and password
					LoginDialog.this.tfUserName.setText("");
					LoginDialog.this.tfPassword.setText("");
					succeeded = false;

				}

			}
		};
		btnLogin.addActionListener(l);
		mlc.gridy = 3; 
        mlc.gridx = 0;
		ml.setConstraints(jp, mlc);
		add(jp);
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

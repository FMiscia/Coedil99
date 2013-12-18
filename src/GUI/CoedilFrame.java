package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.thehowtotutorial.splashscreen.JSplash;

public class CoedilFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Object frame;
	private static CoedilFrame myInstance;

	/**
	 * Lancia l'applicazione
	 */
	public static void main(String[] args) {
		ConfigGUI cg = ConfigGUI.getInstance();
		if (!cg.isParsed())
			JOptionPane
					.showMessageDialog(
							null,
							"C'è stato un errore nella lettura del file di configurazione. \nPer garantire un corretto funzionamento verranno utilizzate la configurazione di default! \nSe il problema persiste contattare il servizio clienti al numero hot: 899-166166!",
							"Attenzione", JOptionPane.WARNING_MESSAGE);

		try {
			int delay = 500;
			boolean developmentMode = false;
			if (developmentMode)
				delay = 1;
			final JSplash splash = new JSplash(ConfigGUI.getInstance().getCoedilIcon(), true,
					true, false, "V0.1");
			splash.splashOn();
			splash.setProgress(20, "Coedil99: Loading ...");
			Thread.sleep(delay);
			splash.setProgress(40, "Coedil99: Loading ...");
			Thread.sleep(delay);
			splash.setProgress(60, "Coedil99: Loading ...");
			Thread.sleep(delay);
			splash.setProgress(80, "Coedil99: Loading ...");
			Thread.sleep(delay);
			splash.setProgress(100, "Coedil99: Starting");
			Thread.sleep(delay);
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					CoedilFrame window = getInstance();
					window.setVisible(true);
					splash.splashOff();
				}
			});
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Crea l'applicazione.
	 */
	public CoedilFrame() {
		initialize();
	}

	/**
	 * Inizzializza il Frame
	 */
	private void initialize() {
		this.setName("Coedil99");
		this.setResizable(true);
		this.setIconImage(new ImageIcon(CoedilFrame.class
				.getResource("image/coedilIco.png")).getImage());
		this.setVisible(true);
		this.setMinimumSize(new Dimension(1300, 600));
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(new BorderLayout());

		LoginPanel lp = LoginPanel.getInstance();
		lp.setBounds(0, 0, this.getWidth(), this.getHeight());
		this.getContentPane().add(lp, BorderLayout.CENTER);

		this.validate();
		this.repaint();
	}

	/**
	 * Singleton
	 * 
	 * @return CoedilFrame
	 */
	public static CoedilFrame getInstance() {
		if (myInstance == null) {
			myInstance = new CoedilFrame();
		}
		return myInstance;
	}

	/**
	 * Cambia il ContentPane di CoedilFrame
	 * 
	 * @param p
	 *            : Il pannello da montare
	 */
	public void montaPanel(JPanel p) {
		this.remove(this.getContentPane());
		this.setContentPane(p);
		this.invalidate();
		this.validate();
		this.repaint();
	}

}

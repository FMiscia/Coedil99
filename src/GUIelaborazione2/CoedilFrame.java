package GUIelaborazione2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import GUIelaboradistinta.GDistinta;

import com.thehowtotutorial.splashscreen.JSplash;

public class CoedilFrame extends JFrame {

	protected Object frame;
	private static CoedilFrame myInstance;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			final JSplash splash = new JSplash(
					GDistinta.class.getResource("image/coedil.png"), true,
					true, false, "V0.1");
			splash.splashOn();
			splash.setProgress(20, "Coedil99: Loading...");
			Thread.sleep(1000);
			splash.setProgress(40, "Coedil99: Loading...");
			Thread.sleep(1000);
			splash.setProgress(60, "Coedil99: Loading...");
			Thread.sleep(1000);
			splash.setProgress(80, "Coedil99: Loading...");
			Thread.sleep(1000);
			splash.setProgress(100, "Coedil99: Starting");
			Thread.sleep(1000);
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
	 * Create the application.
	 */
	public CoedilFrame() {
		System.out.print("init coedilframe\n");
		initialize();
	}

	private void initialize() {
		// TODO Auto-generated method stub
		/**
		 * Initialize the contents of the frame.
		 */
		this.setName("Coedil99");
		this.setResizable(true);
		this.setIconImage(new ImageIcon(GDistinta.class
				.getResource("image/coedilIco.png")).getImage());
		this.setBounds(100, 100, 549, 326);
		Toolkit tk = Toolkit.getDefaultToolkit();
		int xSize = ((int) tk.getScreenSize().getWidth());
		int ySize = ((int) tk.getScreenSize().getHeight() - 55);
		this.setSize(xSize, ySize);
		// Centraggio della finestra
		Dimension screenSize = tk.getScreenSize();
		Dimension frameSize = this.getSize();
		this.setLocation((screenSize.width - frameSize.width) / 2,
				(screenSize.height - frameSize.height) / 2);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(new BorderLayout());

		PanelStart pl = new PanelStart(this);
		pl.setBounds(0, 0, this.getWidth(), this.getHeight());
		this.getContentPane().add(pl, BorderLayout.NORTH);
		this.validate();
		this.repaint();
		System.out.print("aggiunto panelStart \n");
	}

	public static CoedilFrame getInstance() {
		if (myInstance == null) {
			myInstance = new CoedilFrame();
		}
		return myInstance;
	}

	public void montaPanel(JPanel p) {
		this.remove(this.getContentPane());
		this.setContentPane(p);
		this.invalidate();
		this.validate();
		this.repaint();
	}
}
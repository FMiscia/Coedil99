package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.alee.laf.scroll.WebScrollBarUI;
import com.jtattoo.plaf.mint.MintLookAndFeel;
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

		Properties props = new Properties();
		props.put("buttonBackgroundColor", "171 171 171");
		props.put("buttonColorLight", "171 171 171");
		props.put("buttonColorDark", "171 171 171");
		props.put("selectionBackgroundColor", "171 171 171");
		props.put("focusColor", "171 171 171");
		props.put("focusCellColor", "171 171 171");
		props.put("rolloverColor", "171 171 171");
		props.put("rolloverColorLight", "171 171 171");
		props.put("rolloverColorDark", "171 171 171");

		MintLookAndFeel.setCurrentTheme(props);

		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");
			UIManager.put("ScrollBarUI", WebScrollBarUI.class.getName());
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			e1.printStackTrace();
		}

		try {
			int delay = 500;
			boolean developmentMode = true;
			if (developmentMode)
				delay = 1;
			final JSplash splash = new JSplash(
					CoedilFrame.class.getResource("image/coedil.png"), true,
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

		// PanelStart pl = PanelStart.getInstance();
		// pl.setBounds(0, 0, this.getWidth(), this.getHeight());
		// this.getContentPane().add(pl, BorderLayout.CENTER);

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

package GUIelaborazione2;

import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;

import java.awt.BorderLayout;
import javax.swing.ScrollPaneConstants;
import java.awt.FlowLayout;
import javax.swing.JButton;

public class Main {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 500);
//		RiquadroCodici codici = new RiquadroCodici();
//		RiquadroPlico plico  = new RiquadroPlico();
		//r.setSize(100,500);
		//r.load();
//		JButton bottone1 = new JButton("New button");
//		toolBar.add(bottone1);
//		JButton bottone2 = new JButton("New button");
//		toolBar.add(bottone2);
//		
//		frame.getContentPane().add(codici,BorderLayout.WEST);
//		frame.getContentPane().add(plico,BorderLayout.CENTER);
		
		frame.getContentPane().add(new Contenitore(),BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

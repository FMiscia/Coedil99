package GUI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.Rectangle;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class RigaDistinta extends JPanel{
		
		private JLabel basealtezza;
		private JLabel lunghezza;
		private JLabel numero;
		private JLabel capitello;
		private JLabel note;
		private JComboBox comboBox_basealtezza;
		private JSpinner spinner_lunghezza;
		private JSpinner spinner_numero;
		private JComboBox comboBox_capitello;
		private JFormattedTextField formattedtextfield_note;
		
		public RigaDistinta(){
			setLayout(new GridLayout(5,2));
			setBounds(new Rectangle(0, 0, 0, 0));
			//this.setSize(400,100);
			this.setBackground(new Color(80, 80, 90));
			this.setBorder(new LineBorder(Color.BLACK));
			this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.initElements();
			this.addElements();
					
		}
		
		private void addElements() {
			// TODO Auto-generated method stub
			this.add(basealtezza);
			this.add(comboBox_basealtezza);
			this.add(lunghezza);
			this.add(spinner_lunghezza);
			this.add(numero);
			this.add(spinner_numero);
			this.add(capitello);
			this.add(comboBox_capitello);
			this.add(note);
			this.add(formattedtextfield_note);

		}

		private void initElements() {
			// TODO Auto-generated method stub
			
			basealtezza = new JLabel();
			basealtezza.setHorizontalAlignment(SwingConstants.CENTER);
			basealtezza.setHorizontalTextPosition(SwingConstants.LEADING);
			basealtezza.setBounds(100, 30, 100, 30);
			basealtezza.setBorder(new LineBorder(Color.BLACK));
			basealtezza.setText("Base-Altezza");
			lunghezza = new JLabel();
			lunghezza.setHorizontalAlignment(SwingConstants.CENTER);
			lunghezza.setHorizontalTextPosition(SwingConstants.LEADING);
			lunghezza.setBounds(100, 30, 100, 30);
			lunghezza.setBorder(new LineBorder(Color.BLACK));
			lunghezza.setText("Lunghezza");
			numero = new JLabel();
			numero.setHorizontalAlignment(SwingConstants.CENTER);
			numero.setHorizontalTextPosition(SwingConstants.LEADING);
			numero.setBounds(100, 30, 100, 30);
			numero.setBorder(new LineBorder(Color.BLACK));
			numero.setText("Numero");
			capitello = new JLabel();
			capitello.setHorizontalAlignment(SwingConstants.CENTER);
			capitello.setHorizontalTextPosition(SwingConstants.LEADING);
			capitello.setBounds(100, 30, 100, 30);
			capitello.setBorder(new LineBorder(Color.BLACK));
			capitello.setText("Capitello");
			note = new JLabel();
			note.setHorizontalAlignment(SwingConstants.CENTER);
			note.setHorizontalTextPosition(SwingConstants.LEADING);
			note.setBounds(100, 30, 100, 30);
			note.setBorder(new LineBorder(Color.BLACK));
			note.setText("Note");
			comboBox_basealtezza = new JComboBox();
			spinner_lunghezza = new JSpinner();			
			spinner_numero = new JSpinner();		
			comboBox_capitello = new JComboBox();
			formattedtextfield_note = new JFormattedTextField();
			
		}

		
	}
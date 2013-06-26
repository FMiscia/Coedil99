package GUIelaborazione2.Riquadri;

import java.awt.Dimension;

import javax.swing.JPanel;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

public class RiquadroDatiDistinta extends Riquadro {
	
	private JPanel form;

	public RiquadroDatiDistinta(String title) {
		super(title);
		// TODO Auto-generated constructor stub
		this.setSize(new Dimension(600,310));
		form = new JPanel();
		form.setBounds(0,30,600,270);
		this.add(form);
		form.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(230px;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(50px;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC}));
		
		lblOC = new JLabel("O/C");
		form.add(lblOC, "2, 2");
		
		txtOC = new JTextField();
		form.add(txtOC, "6, 2, fill, default");

	}

	@Override
	public void load(Object o) {
		// TODO Auto-generated method stub
		
	}


}

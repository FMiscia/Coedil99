package GUI.Utilities;

import java.awt.ComponentOrientation;
import java.awt.Dimension;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;


    @SuppressWarnings("serial")
	public class JHorizontalSpinner extends JSpinner{

        public JHorizontalSpinner(){
            super(	new SpinnerNumberModel(1,1,50,1));
    		setBorder(null);
    		setPreferredSize(new Dimension(60, 20));
            setUI(new HorizontalSpinnerUI());
        }

        @Override
        public void setComponentOrientation(ComponentOrientation o){
            System.out.println("setComponentOrientation ");
            super.setComponentOrientation(o);
            if( super.getUI() instanceof HorizontalSpinnerUI){
                ((HorizontalSpinnerUI) super.getUI()).initButtonListeners();
            }
        }
        
        @Override
        public void applyComponentOrientation(ComponentOrientation o){
            System.out.println("applyComponentOrientation ");
            super.applyComponentOrientation( o);
            if( super.getUI() instanceof HorizontalSpinnerUI){
                ((HorizontalSpinnerUI) super.getUI()).initButtonListeners();
            }
        }
}

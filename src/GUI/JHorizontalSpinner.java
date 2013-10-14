package GUI;

import java.awt.ComponentOrientation;
import java.awt.Dimension;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;


    public class JHorizontalSpinner extends JSpinner{

        public JHorizontalSpinner(){
            super(	new SpinnerNumberModel(1,1,50,1));
            
            InputVerifier iv = new InputVerifier() {
				@Override
                public boolean verify(JComponent comp) {
                  boolean returnValue = true;
                  String content = (String) JHorizontalSpinner.this.getValue();
                  if (content.length() != 0) {
                    try {
                      Integer.parseInt(content);
                    } catch (NumberFormatException e) {
                      returnValue = false;
                    }
                  }
                  return returnValue;
                }

              };
            
            this.setInputVerifier(iv);
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

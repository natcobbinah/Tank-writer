package VirtualKeyboard;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.Locale;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.text.JTextComponent;

public class VirtualKeyboardDialog extends JDialog{
	
	private VirtualKeyboardPanel vkeybdpanel;

	  public VirtualKeyboardDialog(JFrame parent,boolean modal) {
		  super(parent,"TANK VIRTUAL-KEYBOARD",modal);
		  initComponents();
	  }
	  
	  public VirtualKeyboardDialog(JFrame parent, boolean modal,JTextComponent textComponent) {
		  super(parent,"TANK VIRTUAL-KEYBOARD",modal);
		  initComponents();
		  
		  setTextComponent(textComponent);
		  show(textComponent,-1,textComponent.getHeight());
	  }
	  
	  //-----------------------------------------------------------------------------------------
	  public VirtualKeyboardDialog(JFrame parent, boolean modal,JTextComponent textComponent,JTabbedPane tpaneComponent) {
		  super(parent,"TANK VIRTUAL-KEYBOARD",modal);
		  initComponents();
		  
		  setTextComponent(textComponent,tpaneComponent);
		  show(textComponent,-1,textComponent.getHeight());
	  }
	  //---------------------------------------------------------------------------------------
	  
	  public boolean isPoitToUp() {
	        return vkeybdpanel.isPoitToUp();
	    }

	    public void setPoitToUp(boolean poitToUp) {
	    	vkeybdpanel.setPoitToUp(poitToUp);
	    }

	    public boolean isShiftBs() {
	        return vkeybdpanel.isShiftBs();
	    }

	    public void setShiftBs(boolean shiftBs) {
	    	vkeybdpanel.setShiftBs(shiftBs);
	    }
	    
	    public JTextComponent getTextComponent() {
	        return vkeybdpanel.getTextComponent();
	    }
	    
	    public void setTextComponent(JTextComponent textComponent) {
	    	vkeybdpanel.setTextComponent(textComponent);
	    }
	    
	    //-----------------------------------------------------------------------------------
	    public void setTextComponent(JTextComponent textComponent,JTabbedPane tcomponent) {
	    	vkeybdpanel.setTextComponent(textComponent,tcomponent);
	    }
	    //-----------------------------------------------------------------------------------
	    
	    public void show(Component invoker, int x, int y) {
	    	Point invokerOrigin;
	    	if (invoker != null) {
	    	    invokerOrigin = invoker.getLocationOnScreen();

	                // To avoid integer overflow
	                long lx, ly;
	                lx = ((long) invokerOrigin.x) +
	                     ((long) x);
	                ly = ((long) invokerOrigin.y) +
	                     ((long) y);
	                if(lx > Integer.MAX_VALUE) lx = Integer.MAX_VALUE;
	                if(lx < Integer.MIN_VALUE) lx = Integer.MIN_VALUE;
	                if(ly > Integer.MAX_VALUE) ly = Integer.MAX_VALUE;
	                if(ly < Integer.MIN_VALUE) ly = Integer.MIN_VALUE;

	                boolean valueX=false, valueY=false;
	                int yl = 0, xl = 0;
	                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	                //Value of Y-Axis
	                if((int)(ly+this.getHeight())>=screenSize.getHeight()){
	                    valueY=true;
	                    yl = (int) (ly-(long)invoker.getHeight()-this.getHeight());
	                }
	                //Value of X-Axis
	                if((int)(lx+this.getWidth())>=screenSize.getWidth()){
	                    valueX=true;
	                    xl = (int) (lx-(long)this.getWidth());
	                }

	                if(valueX && valueY) setLocation((int) xl, (int) yl);
	                else if(valueX) setLocation((int) xl, (int) ly);
	                else if(valueY) setLocation((int) lx, (int) yl);
	                else setLocation((int) lx, (int) ly);
	    	} else {
	    	    setLocation(x, y);
	    	}
	            setVisible(true);
	            vkeybdpanel.setFocusToEXE();
	            vkeybdpanel.updateGUI();
	        }

	    public Locale getLocaleL() {
	        return vkeybdpanel.getLocaleL();
	    }
	    
	    public void setLocaleL(Locale localeL) {
	    	vkeybdpanel.setLocaleL(localeL);
	    }

	    public int getGap() {
	        return vkeybdpanel.getGap();
	    }

	    public void setGap(int gap) {
	    	vkeybdpanel.setGap(gap);
	    }

	    public int getTab() {
	        return vkeybdpanel.getTab();
	    }

	    public void setTab(int tab) {
	    	vkeybdpanel.setTab(tab);
	    }
	    
	    private void initComponents() {

	      vkeybdpanel = new VirtualKeyboardPanel();

	        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
	        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
	            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
	            }
	            public void windowLostFocus(java.awt.event.WindowEvent evt) {
	                formWindowLostFocus(evt);
	            }
	        });
	        add(vkeybdpanel, java.awt.BorderLayout.CENTER);

	        pack();
	    }// </editor-fold>//GEN-END:initComponents

	    private void formWindowLostFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowLostFocus
	        if(!this.isModal()){
	            this.setVisible(false);
	            this.dispose();
	        }
	    }//GEN-LAST:event_formWindowLostFocus


}

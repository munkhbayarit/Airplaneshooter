package Shooterr;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Options extends JPanel implements ActionListener{
	private Object items[]={"2","3","4","5"};
	private Object items1[]={"2","3","4","5","6","7","8"};
	ActionListener f10action;
	JRadioButton f10,f15,def;
	JComboBox co,co1;
	JButton cancel,ok;
	JFrame frame;

	public Options(){
		
	    frame = new JFrame("Option");
	    JPanel panel = new JPanel();
	    Container contentPane = frame.getContentPane();
	    contentPane.add(panel);
        frame.setBackground(Color.gray);
        
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        
        panel.setLayout(null);
        panel.setToolTipText("A Panel container");
        ButtonGroup group=new ButtonGroup();
        
        
        ChangeListener listener = new ChangeListener() { // A shared listener
			@Override
			public void stateChanged(ChangeEvent e) {
				  f10 = (JRadioButton) e.getSource();
	              if (f10.isSelected()) {
	            	  co.setEnabled(true);
	              }
	              else{
	            	  co.setEnabled(false);
	              }
			}
          };
          ChangeListener listener1 = new ChangeListener() { // A shared listener
  			@Override
  			public void stateChanged(ChangeEvent e) {
  				  f15=(JRadioButton) e.getSource();
  				if(f15.isSelected()) {
  	        	  co1.setEnabled(true);
  	            }
  	            else{
  	        	  co1.setEnabled(false);
  	          }
  			}
            };
            
            
            
        def=new JRadioButton("Default/10x10/5 plans");
        def.setBounds(10,20 ,200, 20);
        
        f10=new JRadioButton("field 10x10");
        f10.setBounds(10, 50, 100, 20);
        f10.addChangeListener(listener);
        
        JLabel l1=new JLabel("Plans:");
        l1.setBounds(150, 50, 100, 20);
        
        co=new JComboBox(items);
        co.setBounds(200, 50, 40, 20);
        co.setEnabled(false);
 
        f15=new JRadioButton("field 15x15");
        f15.setBounds(10, 80, 100, 20);
        f15.addChangeListener(listener1);
        
        
        JLabel l2=new JLabel("Plans1:");
        l2.setBounds(150, 80, 100, 20);
        
        
        
        co1=new JComboBox(items1);
        co1.setBounds(200, 80, 40, 20);     
        co1.setEnabled(false);
        
        
        cancel=new JButton("Cancel");
        cancel.setBounds(100, 180, 80, 30);
        cancel.addActionListener(this);
        
        ok=new JButton("Ok");
        ok.setBounds(10, 180, 60, 30);
        ok.addActionListener(this);
        
        group.add(f10);
        group.add(def);
        group.add(f15);
        
        panel.add(ok);
        panel.add(cancel);
        panel.add(def);
        panel.add(f10);
        panel.add(l1);
        panel.add(co);
        panel.add(f15);
        panel.add(l2);
        panel.add(co1);
	    
	    
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(250,250);
        frame.setResizable(false);
        //frame.setContentPane(j);
        frame.setBackground(Color.gray);
        frame.setVisible(true);

    }
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand()=="Cancel"){
			frame.setVisible(false);
		}
		else if(e.getActionCommand()=="Ok"){
	         if(def.isSelected()){}
	         else if(f10.isSelected()){
	        	 System.out.println(co.getSelectedItem()+" "+f10.getText());
	        	 frame.setVisible(false);
	        	 Component is = null;
				is.setVisible(false);
	        	 
	        	 //MainClass m=new MainClass(co.getSelectedItem().toString(),f10.getText().toString());
	     	     //m.setVisible(true);	 
	         }
	         else if(f15.isSelected()){ 
	        	 System.out.println(co1.getSelectedItem()+" "+f15.getText());
	         }
	         else{
	        	 JOptionPane.showMessageDialog(null, "Select one!!!!!!!!");
	         }         		
		}
	}
}

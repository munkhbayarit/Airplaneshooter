package Shooting;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Start extends JFrame implements ActionListener{
	JLabel namee,text;
	JButton play,cancel;
	JTextField nameEnter;
	JFrame frame;
	JRadioButton singlePlayer,multiuplayer;
	ButtonGroup group;
    public Start(){
    	  frame = new JFrame("Airplane Shooter");
	      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      frame.setBounds(400, 200, 400, 600);
	      
	      JPanel LeftPanel = new JPanel();
	      LeftPanel.setPreferredSize(new Dimension(250, 200));
	      LeftPanel.setBackground(new Color(10, 110+60, 250));
	      LeftPanel.setLayout(null);
	      
	      text=new JLabel("Welcome");
	      text.setBounds(70, 30, 100, 20);
	      text.setFont(new Font("sansserif", Font.PLAIN, 24));
	      
	      
	      namee=new JLabel("Player Name:");
	      namee.setBounds(30, 80, 100, 20);
	      
	      nameEnter=new JTextField();
	      nameEnter.setBounds(110, 80, 100, 20);
	      
	      singlePlayer=new JRadioButton("Single PLayer");
	      singlePlayer.setBounds(50, 101, 150, 20);
	      
	      multiuplayer=new JRadioButton("Multi PLayer");
	      multiuplayer.setBounds(50, 121, 150, 20);
	      
	      group=new ButtonGroup();
	      group.add(multiuplayer);
	      group.add(singlePlayer);
	      
	      play=new JButton("Play");
	      play.setBounds(90, 155, 80, 20);
	      play.addActionListener(this);
	      
	      
	      cancel=new JButton("Cancel");
	      cancel.setBounds(90, 180, 80, 20);
	      cancel.addActionListener(this);
	      
	      LeftPanel.add(text);
	      LeftPanel.add(cancel);
	      LeftPanel.add(play);
	      LeftPanel.add(namee); 
	      LeftPanel.add(nameEnter);
	      LeftPanel.add(singlePlayer);
	      LeftPanel.add(multiuplayer);

	      frame.getContentPane().add(LeftPanel);
	      frame.pack();
	      frame.setResizable(false);
	      frame.setVisible(true);
    }
	public static void main (String[] args){
		Start s=new Start();
		//MainClass m=new MainClass();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String cmd = e.getActionCommand();
	    if( cmd.equals("Play")) {
	    	if(nameEnter.getText().length()==0)
	    		 JOptionPane.showMessageDialog(null, "Enter PLayer name!!!!!!!!");
	    	else{
	    		if(singlePlayer.isSelected()){
	    		 PlayConfigure g=new PlayConfigure(nameEnter.getText());
	    		 frame.setVisible(false);
	    		}
	    		else if(multiuplayer.isSelected()){
	    			JOptionPane.showMessageDialog(null, "Network not connect");
	    		}
	    		else JOptionPane.showMessageDialog(null, "Type select one!!!!");
	    	}
	    }
	    else if( cmd.equals("Cancel")) {
	    	System.exit(0);
	    }
	}
}

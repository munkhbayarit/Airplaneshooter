

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
	JRadioButton singlePlayer;
	ButtonGroup group;
    public Start(){
    	  frame = new JFrame("Airplane Shooter");
	      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      frame.setBounds(400, 200, 400, 600);
	      
	      JPanel LeftPanel = new JPanel();
	      LeftPanel.setPreferredSize(new Dimension(250, 200));
	      LeftPanel.setBackground(new Color(59, 89, 152));
	      LeftPanel.setLayout(null);
	      
	      text=new JLabel("Welcome");
	      text.setBounds(90, 30, 150, 20);
	      text.setFont(new Font("sansserif", Font.BOLD, 24));
	      text.setForeground(new Color(255, 255, 255));
	      
	      
	      namee=new JLabel("Player Name:");
	      namee.setBounds(10, 80, 85, 20);
	      namee.setForeground(new Color(255, 255, 255));
	      
	      nameEnter=new JTextField();
	      nameEnter.setBounds(90, 80, 120, 20);
	      
	      singlePlayer=new JRadioButton("Single PLayer");
	      singlePlayer.setSelected(true);
	      singlePlayer.setBounds(90, 100, 120, 20);
	      singlePlayer.setBackground(new Color(59, 89, 152));
	      singlePlayer.setForeground(new Color(255, 255, 255));
	      
	      //multiuplayer=new JRadioButton("Multi PLayer");
	      //multiuplayer.setBounds(90, 120, 120, 20);
	      //multiuplayer.setBackground(new Color(59, 89, 152));
	      //multiuplayer.setForeground(new Color(255, 255, 255));
	      
	      group=new ButtonGroup();
	      //group.add(multiuplayer);
	      group.add(singlePlayer);
	      
	      play=new JButton("Play");
	      play.setBackground(new Color(98, 122, 172));
	      play.setForeground(new Color(255, 255, 255));
	      play.setBounds(90, 155, 120, 20);
	      play.addActionListener(this);
	      
	      
	      cancel=new JButton("Exit");
	      cancel.setBackground(new Color(98, 122, 172));
	      cancel.setForeground(new Color(255, 255, 255));
	      cancel.setBounds(90, 180, 120, 20);
	      cancel.addActionListener(this);
	      
	      LeftPanel.add(text);
	      LeftPanel.add(cancel);
	      LeftPanel.add(play);
	      LeftPanel.add(namee); 
	      LeftPanel.add(nameEnter);
	      LeftPanel.add(singlePlayer);
	     // LeftPanel.add(multiuplayer);

	      frame.getContentPane().add(LeftPanel);
	      frame.pack();
	      frame.setResizable(false);
	      frame.setVisible(true);
    }
    
    
	public static void main (String[] args){
		Start s=new Start();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String cmd = e.getActionCommand();
	    if( cmd.equals("Play")) 
	    {
	    	if(nameEnter.getText().length()==0)
	    		 JOptionPane.showMessageDialog(null, "Enter PLayer name!");
	    	else
	    	{
	    		if(singlePlayer.isSelected())
	    		{
	    		 PlayConfigure g=new PlayConfigure(nameEnter.getText());
	    		 frame.setVisible(false);
	    		}
	    		//else 
	    		//if(multiuplayer.isSelected())
	    		//{
	    		//	JOptionPane.showMessageDialog(null, "Network not connect");
	    		//}
	    	}
	    }
	    else 
	    if( cmd.equals("Exit")) 
	    {
	    	System.exit(0);
	    }
	}
}

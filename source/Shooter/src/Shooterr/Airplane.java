package Shooterr;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;


public class Airplane extends JFrame {
	
	public Airplane(){
		
		
		  JMenuBar menubar = new JMenuBar();
		  
		  JMenu Gamemenu = new JMenu("Game");
		  
		  //editmenu.add(new JSeparator());
////////////////////////////////////////one player menu item/////////////////////////////////////////////////
		  JMenuItem OnePlayerItem = new JMenuItem("One player");
		  OnePlayerItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.SHIFT_MASK));
		  OnePlayerItem.addActionListener(new ActionListener(){
			  public void actionPerformed(ActionEvent e){
				 OnePlayer op=new OnePlayer();
				 
			     }
			  });
////////////////////////////////////////two player menu item/////////////////////////////////////////////////
		  JMenuItem TwoPlayerItem = new JMenuItem("Two player");
		  TwoPlayerItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.SHIFT_MASK));
		  TwoPlayerItem.addActionListener(new ActionListener(){
			  public void actionPerformed(ActionEvent e){
				   TwoPlayer tp=new TwoPlayer();
				 
			     }
			  });
////////////////////////////////////////option  menu item/////////////////////////////////////////////////
		  JMenuItem OptionItem = new JMenuItem("Option");
		  OptionItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.SHIFT_MASK));
		  OptionItem.addActionListener(new ActionListener(){
			  public void actionPerformed(ActionEvent e){
				 Options op=new Options();
				 
				  
			     }
			  });
////////////////////////////////////////statistic  menu item/////////////////////////////////////////////////		  
		  JMenuItem StatisticItem = new JMenuItem("Statistic");
		  StatisticItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.SHIFT_MASK));
		  StatisticItem.addActionListener(new ActionListener(){
			  public void actionPerformed(ActionEvent e){
				 Statistic st=new Statistic();
				  
			     }
			  });
////////////////////////////////////////about menu item/////////////////////////////////////////////////		  
		  JMenuItem AboutItem = new JMenuItem("About");
		  AboutItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.SHIFT_MASK));
		  AboutItem.addActionListener(new ActionListener(){
			  public void actionPerformed(ActionEvent e){
				  About ab=new About();
				  
			     }
			  });		  
////////////////////////////////////////close  menu item/////////////////////////////////////////////////		  
		 JMenuItem CloseItem = new JMenuItem("Close");
		 CloseItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.SHIFT_MASK));
		 CloseItem.addActionListener(new ActionListener(){
			  public void actionPerformed(ActionEvent e){
				  System.exit(0);
			     }
			  });
		  
		 
		  Gamemenu.add(OnePlayerItem);
		  Gamemenu.add(TwoPlayerItem);
		  Gamemenu.add(OptionItem);
		  Gamemenu.add(StatisticItem);
		  Gamemenu.add(AboutItem);
		  Gamemenu.add(CloseItem);
		  
		  menubar.add(Gamemenu);
		 
		  
		  JFrame frame = new JFrame("Airplane Shooter");
	      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      
	      JPanel topPanel = new JPanel(new BorderLayout());
	      topPanel.setBackground(Color.gray);
	      topPanel.setPreferredSize(new Dimension(800, 25));
	      topPanel.add(menubar,BorderLayout.PAGE_START);
	      
	      JPanel centerPanel = new JPanel(new BorderLayout());
	      centerPanel.setBackground(Color.white);
	      centerPanel.setPreferredSize(new Dimension(800, 400));
	      
	      JPanel RightPanel = new JPanel();
	      RightPanel.setPreferredSize(new Dimension(400, 400));
	      RightPanel.setBackground(Color.green);
	     
	      
	      JPanel LeftPanel = new JPanel();
	      LeftPanel.setPreferredSize(new Dimension(400, 400));
	      LeftPanel.setBackground(Color.blue);
	     
	      centerPanel.add(RightPanel, BorderLayout.WEST);
	      centerPanel.add(LeftPanel, BorderLayout.EAST);


	      // allpanel uses BorderLayout
	      JPanel allPanel = new JPanel(new BorderLayout());
	      allPanel.add(topPanel, BorderLayout.PAGE_START);
	      allPanel.add(centerPanel, BorderLayout.CENTER);
	      
	      
	      //frame.setUndecorated(true);
	      //frame.getContentPane().add(new MyComponent());
	      frame.getContentPane().add(allPanel);
	      frame.pack();
	      frame.setLocationByPlatform(true);
	      frame.setResizable(false);
	      frame.setVisible(true);
		
	}
	
		
	public static void main(String[] args) {
		
		  Airplane air= new Airplane();
	     

	}

}

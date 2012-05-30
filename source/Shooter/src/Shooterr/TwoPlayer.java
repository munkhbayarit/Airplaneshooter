package Shooterr;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class TwoPlayer {

	public TwoPlayer(){
		
		JFrame frame = new JFrame("Airplane Shooter two");
	      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      
	     
	      
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
	      allPanel.add(centerPanel, BorderLayout.CENTER);
	      
	      
	      //frame.setUndecorated(true);
	      //frame.getContentPane().add(new MyComponent());
	      frame.getContentPane().add(allPanel);
	      frame.pack();
	      frame.setLocationByPlatform(true);
	      frame.setResizable(false);
	      frame.setVisible(true);
	}
}

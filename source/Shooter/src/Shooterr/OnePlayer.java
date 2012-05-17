package Shooterr;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class OnePlayer {

	public OnePlayer(){
		
		JFrame frame = new JFrame("Airplane Shooter one");
	      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      
	      JPanel centerPanel = new JPanel(new BorderLayout());
	      centerPanel.setBackground(Color.white);
	      centerPanel.setPreferredSize(new Dimension(800, 400));
	      
	      


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

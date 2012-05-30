package Shooterr;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class About {

	public About(){
		
		 JFrame frame1 = new JFrame("About");
		 JPanel panel1 = new JPanel();
	        
	     panel1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
	     panel1.setPreferredSize(new Dimension(600, 300));
	    
	     frame1.add(panel1);   
	     frame1.pack();
	     frame1.setLocationByPlatform(true);
	     frame1.setResizable(false);
	     frame1.setVisible(true);
	}
}

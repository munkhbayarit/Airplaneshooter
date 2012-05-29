import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
public class ComShooting extends JPanel {
	int gunx, guny; 
	public int[][] position;
	static private Planes p;
	int shoot=0;
	int planss;
	public ComShooting(int[][] planesShooseGuest ) {
		   
		     position = planesShooseGuest;
		     //p=new Planes(planss);
    }
   void init(){
		     p.setLayout(null);
		     for(int i=0;i<position.length;i++)
		    	 for(int j=0;j<16;j++)
		    	 {
		    		 System.out.println(position[i][j]);
		    	 }	     
  }
  
   /*
@Override
public void mouseClicked(MouseEvent e) {
	JOptionPane.showMessageDialog(null, e.getX()+" "+e.getY());
//	if(startgame==1)
    {
	 gunx = 30 * ((int) (Math.random() * 10));
	 guny = 30 * ((int) (Math.random() * 10));
	 if (shoot == position.length) {
			JOptionPane.showMessageDialog(null, "Game over!!!");
	 }
	
	/* for (int i = 30; i < 330; i += 30) {
		 for (int j = 60; j < 360; j += 30) {
			int curx = i + 30;
			int cury = j + 30;
			if (i == (gunx + 30) && j == (guny + 60)) {
				for (int ii = 0;ii < position.length; ii++) 
					for(int jj=0;jj<15;jj++){
				 	     if (gunx == position[ii][jj]&& position[ii][jj+1] == guny && jj==0 ) {
						//     gg.drawString("S", (curx + i) / 2 + 30,(cury + j) / 2 + 60);
						     shoot++;
					     } 
					     else 
				         if (gunx == position[ii][jj]&& position[ii][jj+1] == guny) {
						  //   gg.drawString("Sh", (curx + i) / 2 + 30,(cury + j) / 2 + 60);
					     }
				         else
				         {
				        //	 gg.drawString("X", (curx + i) / 2 + 30,(cury + j) / 2 + 60);
				         }	 
				} 
			}
		}
	}
}
else
JOptionPane.showMessageDialog(null, "Start Game Please!!!");	
}*/

	}



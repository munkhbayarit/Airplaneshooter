package Shooting;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.*;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

class InsertValues extends JPanel{ 
	  int pointX, pointY, oldX, oldY;
	  int planss,count,old=0,co=0;
	  int h=0;
	  int[] yourplane;
      boolean erase;
	  public InsertValues(int l){
		    super();
	        pointX=30;
	        pointY=60;
	        oldX=0;
	        oldY=60;
	        count=0;
	        planss=l;
	        yourplane=new int[planss];
	  }	
	  public void paintComponent(Graphics g){
		    // Erase the board if it's been requested.
		        if (erase) {
		           g.clearRect(0, 0 , getBounds().width, getBounds().height);
		           erase = false; // We're done, turn off this flag now.
		        }
		        
		    // Draw "Cursor" at current location in black.
		        g.setColor(Color.blue);
		        //g.fillRect(pointX,pointY, 30, 30);
		        for(int i=30;i<330;i+=30){
		            for(int j=60;j<360;j+=30){
		                g.drawRect(i, j, 30, 30);
		                }
		         }
		        g.setColor(Color.green);
		        for(int ii=390;ii<690;ii+=30){
		            for(int jj=60;jj<360;jj+=30){
		                g.drawRect(ii, jj, 30, 30);
		                }
		         }
		        int yy=0;
		        for(int ik=60;ik<360;ik+=30)
		        {
		        	yy++;
		        	g.drawString(Integer.toString(yy), ik-30, 45);
		        }
		        
		        int yx=0;
		        for(int ik=60;ik<360;ik+=30)
		        {
		        	yx++;
		        	g.drawString(Integer.toString(yx), 5, ik+15);
		        }
		        
		        g.setColor(Color.blue);
		        yy=0;
		        for(int ik=390;ik<690;ik+=30)
		        {
		        	yy++;
		        	g.drawString(Integer.toString(yy), ik, 45);
		        }
		        
		        yx=0;
		        for(int ik=60;ik<360;ik+=30)
		        {
		        	yx++;
		        	g.drawString(Integer.toString(yx), 360, ik+15);
		        }
		        
		        
		        
		        
		        try {
		        	String driver,url;
		        	driver = "com.mysql.jdbc.Driver";
		        	Class.forName(driver).newInstance();
		            url = "jdbc:mysql://localhost:3306/javadb"; 
		            Connection conn = DriverManager.getConnection(url,"root",""); 
		            Statement st = conn.createStatement();            
		            
		            int[] data=new int[planss];
	                int j=0;
		            for(int i=0;i<data.length;i++)
		    		{
		    	                data[i]=(int)(Math.random()*8+1);
		    	                         while(j<i){
		    	        	  if(data[j]==data[i]){
		    	        		  data[i]=(int)(Math.random()*8+1);  
		    	        		  j=0;
		    	        	  }
		    	        	  else
		    	        	      j++;
		    	          }
		    	          j=0;
		    		}
		            for(int i=0;i<data.length;i++){
		            	
	                ResultSet s=st.executeQuery("select * from plans where id='"+data[i]+"'");
		            //ResultSet s=st.executeQuery("select * from plans");
	                while(s.next()){
	                	yourplane[i]=Integer.parseInt(s.getString("id"));
	                	count++;
	                	g.setColor(Color.lightGray);
	                	if(count==1){
	                		g.setColor(Color.GREEN);
	                	}
	                	else if(count==2){
	                		g.setColor(Color.blue);
	                	}
                        else if(count==3){
                        	g.setColor(Color.yellow);	
	                	}
                        else if(count==4){
                        	g.setColor(Color.red);
                        }
                        else if(count==5){
                        	g.setColor(Color.darkGray);
                        }
                        else if(count==6){
                        	g.setColor(Color.BLACK);
                        }
                        if(count<9){
	                	g.fillRect(Integer.parseInt(s.getString(3))+pointX,Integer.parseInt(s.getString(2))+pointY, 30, 30);
	                	g.fillRect(Integer.parseInt(s.getString(5))+pointX,Integer.parseInt(s.getString(4))+pointY, 30, 30);
	                	g.fillRect(Integer.parseInt(s.getString(7))+pointX,Integer.parseInt(s.getString(6))+pointY, 30, 30);
	                	g.fillRect(Integer.parseInt(s.getString(9))+pointX,Integer.parseInt(s.getString(8))+pointY, 30, 30);
	                	g.fillRect(Integer.parseInt(s.getString(11))+pointX,Integer.parseInt(s.getString(10))+pointY, 30, 30);
	                	g.fillRect(Integer.parseInt(s.getString(13))+pointX,Integer.parseInt(s.getString(12))+pointY, 30, 30);
	                	g.fillRect(Integer.parseInt(s.getString(15))+pointX,Integer.parseInt(s.getString(14))+pointY, 30, 30);
	                	g.fillRect(Integer.parseInt(s.getString(17))+pointX,Integer.parseInt(s.getString(16))+pointY, 30, 30);
                        }
	                }
		           }
		            conn.close(); 
		        } catch (Exception e) { 
		            System.err.println("Got an exception123! "); 
		            System.err.println(e.getMessage()); 
		        } 
		  
		    }
	} 

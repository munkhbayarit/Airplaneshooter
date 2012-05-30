package ShooterFinal;



import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;

import javax.sound.midi.SysexMessage;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Planes extends JPanel  implements ActionListener,MouseListener{
    public JLabel computer,guest;
	public int planeCount,pointX, pointY,count=0,pointX1, pointY1;
	public int[][] planesShooseCom,planesShooseGuest,table1,table2,table3,table4;
	public  int[][] planes;
	Point[] points=new Point[8];
	int[] data;
	JFrame ff;
	int count1;
	int count2,co=0,com=0,gu=1;
	Graphics g1;
	
	//count -> plane count
	public Planes(int count,JFrame j,int wincount) {
		ff=j;
		pointX=30;
	    pointY=60;
	    pointX1=390;
	    pointY1=60;
		planeCount=count;
		planesShooseCom=new int[planeCount][16];
		planesShooseGuest=new int[planeCount][16];
		planes=new int[8][16];
		planeLocate();
		getPixelPlane();
		addMouseListener(this);
		count1=wincount;
		table1=new int[10][10];
		table2=new int[10][10];
		zero();
		convert();
	}
	//refreshing table it means set table all 0 and all blanks
	public void zero(){
		int l,l1;
		for(l=0;l<10;l++)
			for(l1=0;l1<10;l1++)
				table1[l][l1]=0;
		for(l=0;l<10;l++)
			for(l1=0;l1<10;l1++)
				table2[l][l1]=0;	
	}
	 public void paintComponent(Graphics g){
            // draw own rectangle
		    g.setColor(Color.blue);
	        for(int i=30;i<330;i+=30){
	            for(int j=60;j<360;j+=30){
	                g.drawRect(i, j, 30, 30);
	                }
	         }
	        // draw com rectangle
	        g.setColor(Color.green);
	        for(int ii=390;ii<690;ii+=30){
	            for(int jj=60;jj<360;jj+=30){
	                g.drawRect(ii, jj, 30, 30);
	                }
	         }
	        // own number column
	        int yy=0;
	        for(int ik=60;ik<360;ik+=30)
	        {
	        	yy++;
	        	g.drawString(Integer.toString(yy), ik-30, 45);
	        }
	        // own number row
	        int yx=0;
	        for(int ik=60;ik<360;ik+=30)
	        {
	        	yx++;
	        	g.drawString(Integer.toString(yx), 5, ik+15);
	        }
	        
	        g.setColor(Color.blue);
	        //com number column
	        yy=0;
	        for(int ik=390;ik<690;ik+=30)
	        {
	        	yy++;
	        	g.drawString(Integer.toString(yy), ik, 45);
	        }
	        //com number row
	        yx=0;
	        for(int ik=60;ik<360;ik+=30)
	        {
	        	yx++;
	        	g.drawString(Integer.toString(yx), 360, ik+15);
	        }
	        for(int i=0;i<planeCount;i++){
                	count++;
                	for(int yu=1;yu<9999;yu++){
                	    if(count==yu){
                	    	int rr=(int)(Math.random()*255+1);
                	    	int rg=(int)(Math.random()*255+1);
                	    	int rb=(int)(Math.random()*255+1);
                		  g.setColor(new Color(rr, rg, rb));
                		
                	    }
                	}
                    for(int jg=0;jg<16;jg++){
                       for(int jjg=0;jjg<16;jjg=jjg+2){ 
                    	   g.fillRect(planesShooseGuest[i][jjg]+pointX, planesShooseGuest[i][jjg+1]+pointY, 30, 30);}
                    }
                    for(int jg=0;jg<16;jg++){
                        for(int jjg=0;jjg<16;jjg=jjg+2){ 
                     	   g.fillRect(planesShooseCom[i][jjg]+pointX1, planesShooseCom[i][jjg+1]+pointY1, 30, 30);}
                     }
	        }
	 }
	 
	 
	 //Random function to choose plane
	 public void random(){
		 data=new int[planeCount];
         int j=0;
         for(int i=0;i<data.length;i++)
 		 {
 	              data[i]=(int)(Math.random()*8);
 	                         while(j<i){
 	        	                   if(data[j]==data[i]){
 	        		                       data[i]=(int)(Math.random()*8);  
 	        		                       j=0;
 	        	                   }
 	        	                   else
 	        	                   j++;
 	                         }
 	                         j=0;
 		 }
	 }
	 //taking all planes information
	 public void getPixelPlane(){
		 int i,je;
		 random();
         for (i = 0; i < data.length; i++) {
			    for (je=0; je<16; je++){
					planesShooseGuest[i][je]=planes[data[i]][je];  				
			    }
		 }
         
         random();
         for (i = 0; i < data.length; i++) {
				for (je=0; je<16; je++)
					planesShooseCom[i][je]=planes[data[i]][je];
		 }
	 }
     //adding the planes to table also into board	
	 public void convert(){
		 int i,je;
         for (i = 0; i < planesShooseGuest.length; i++) {
			    for (je=0; je<16; je+=2){
					int f1=planesShooseGuest[i][je+1]/30;
					int f2=planesShooseGuest[i][je]/30;
					if(je==0)
					    table1[f1][f2]=2;
					else
						table1[f1][f2]=1;
			    }
		 }
         
         for (i = 0; i < planesShooseGuest.length; i++) {
			    for (je=0; je<16; je+=2){
					int f1=planesShooseCom[i][je+1]/30;
					int f2=planesShooseCom[i][je]/30;
					if(je==0)
					table2[f1][f2]=2;
					else
						table2[f1][f2]=1;
			    }
		 }
	 }
	 //all planes (pl[0][0],p1[0][1]) head
	 // (planes[1][0],planes[1][1]) first plane head  (planes[1][2],planes[1][3])
	 // (planes[2][0],planes[2][1]) second plane head etc...... 
	 public void planeLocate(){
		 int[] pl=new int[]{0,30,30,0,30,30,30,60,60,30,90,0,90,30,90,60};
		 int[] pl1=new int[]{0,120,30,90,30,120,30,150,60,120,90,90,90,120,90,150};
		 int[] pl2=new int[]{0,210,30,180,30,210,30,240,60,210,90,180,90,210,90,240};
		 int[] pl3=new int[]{240,90,270,60,240,60,210,60,240,30,270,0,240,0,210,0};
		 int[] pl4=new int[]{240,180,210,210,240,210,270,210,240,240,210,270,240,270,270,270};
		 int[] pl5=new int[]{210,30,120,30,120,60,150,30,180,0,180,30,180,60,120,0};
		 int[] pl6=new int[]{150,60,120,90,150,90,180,90,150,120,120,150,150,150,180,150};
		 int[] pl7=new int[]{210,240,180,210,180,240,180,270,150,240,120,210,120,240,120,270};
		 
		 for(int i=0;i<planes.length;i++){
			 for(int j=0;j<16;j++){
				 if(i==7)
				     planes[i][j]=pl7[j];
				 if(i==6)
					 planes[i][j]=pl6[j];
				 if(i==5)
					 planes[i][j]=pl5[j];
				 if(i==4)
					 planes[i][j]=pl4[j];
				 if(i==3)
					 planes[i][j]=pl3[j];
				 if(i==2)
					 planes[i][j]=pl2[j];
				 if(i==1)
					 planes[i][j]=pl1[j];
				 if(i==0)
					 planes[i][j]=pl[j];
			 }
		 }
		 
	 }
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
	                int gunx=e.getX(),guny=e.getY();
		            int xx=(gunx-30)/30,yy=(guny-60)/30;
		            int xxx=(gunx-390)/30,yyy=(guny-60)/30;
		            g1=ff.getGraphics();
		            //g1.fillRect(30, 30, 30, 30);
                    //g1.fillRect(660, 30, 30, 30);
		            co++;
		            
		          /*if(gu==1&&com==0){
		        	  JOptionPane.showMessageDialog(null, "guest buudna1");
		        	  g1.setColor(Color.green);
		            	 g1.fillRect(30, 30, 30, 30);
		            	 g1.setColor(Color.red);
		     	         g1.fillRect(660, 30, 30, 30);
		          }
		          else if(gu==0&&com==1){
		        	  JOptionPane.showMessageDialog(null, "computer buudna1");
		        	  g1.setColor(Color.red);
		            	g1.fillRect(30, 30, 30, 30);
		            	 g1.setColor(Color.green);
		     	        g1.fillRect(660, 30, 30, 30);
		          }*/
		            
		            if(gu==1&&com==0){
		            	new AnnoyingBeep(g1);
		            	gu=0;
		            	com=1;
		            }
		            else if(gu==0&&com==1){
		            	new AnnoyingBeep(g1,1);
		            	gu=1;
		            	com=0;
		            }
		            //H means Blank (nothing)	
		            //SH means hit
		            //C means destroyed
		            if(gunx<330&&gunx>30&&guny<360&&guny>60&&gu==1){
					if(table1[yy][xx]==0){
						g1.drawString("H", xx*30+30+15, yy*30+90+15);
					}
					else if(table1[yy][xx]==1){
						g1.drawString("SH", xx*30+30+15, yy*30+90+15);
					}
					else if(table1[yy][xx]==2){
						g1.drawString("C", xx*30+30+15, yy*30+90+15);
					}
		            }
		            
		          
		            if(gunx>390&&gunx<690&&guny<360&&guny>60&&com==1){
		            	gu=1;
		            	com=0;
		            	
					if(table2[yyy][xxx]==0){
						g1.drawString("H", xxx*30+390+15, yyy*30+90+15);
					}
					else if(table2[yyy][xxx]==1){
						g1.drawString("SH", xxx*30+390+15, yyy*30+90+15);
					}
					else if(table2[yyy][xxx]==2){
						g1.drawString("C", xxx*30+390+15, yyy*30+90+15);
					}
		            }
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	}

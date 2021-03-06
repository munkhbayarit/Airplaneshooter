/*
 * This is the sound of when the each player's shooting time will end
 * it will beep when player has to shoot for under 3 seconds
 */

import java.util.Timer;
import java.util.TimerTask;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.JLabel;

public class AnnoyingBeep {
    Toolkit toolkit;
    Timer timer;
    Graphics l;
    int s,s1;
    int numWarningBeeps;
    public AnnoyingBeep(Graphics k,int t)
    {
    	s=t;
    	l=k;
        toolkit = Toolkit.getDefaultToolkit();
        timer = new Timer();
        timer.schedule(new RemindTask(),
                      0,        //initial delay
                       1*1000);  //subsequent rate
    }
    public AnnoyingBeep(Graphics k,int f,int t1)
    {
    	l=k;
    	s1=t1;
    	numWarningBeeps=f;
        toolkit = Toolkit.getDefaultToolkit();
        timer = new Timer();
        timer.schedule(new RemindTasks1(),
                       0,        //initial delay
                       1*1000);  //subsequent rate
    }
//1st player (PLayer)
    class RemindTask extends TimerTask {
        int numWarningBeeps = 10;
        public void run() {
        	if(s==1){
            if (numWarningBeeps > 0) {
                l.clearRect(30, 15, 100, 30);
                l.clearRect(630, 15, 100, 30);
                l.drawString(Integer.toString(numWarningBeeps), 30, 45);
                if(numWarningBeeps<4){
                	toolkit.beep();}
                numWarningBeeps--;
            } else {
                toolkit.beep(); 
                l.clearRect(30, 15, 100, 30);
                l.clearRect(630, 15, 100, 30);
                l.drawString("tanii time up", 630, 45);
                l.drawString("com ta buudna", 30, 45);
                timer.cancel();
            }
        	}
        	else timer.cancel();   
        		
        }
        
    }
    //2nd player (Computer)
    class RemindTasks1 extends TimerTask {
        
        public void run() {
        	if(s1==1){
            if (numWarningBeeps	> 0) {
            	if(s1==1){
            	l.clearRect(30, 15, 100, 30);
                l.clearRect(630, 15, 100, 30);
                l.drawString(Integer.toString(numWarningBeeps), 630, 45);
                if(numWarningBeeps<4){
                	toolkit.beep();}
                numWarningBeeps--;
            	}
            } else{
                toolkit.beep(); 
                l.clearRect(30, 15, 100, 30);
                l.clearRect(630, 15, 100, 30);
                l.drawString("tanii time up", 630, 45);
                l.drawString("com ta buudna", 30, 45);
                timer.cancel();
            }
        	}
        else {timer.cancel();}
    }
        }
}
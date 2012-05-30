package ShooterFinal;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.JLabel;

public class AnnoyingBeep {
    Toolkit toolkit;
    Timer timer;
    Graphics l;
    public AnnoyingBeep(Graphics k)
    {
    	l=k;
        toolkit = Toolkit.getDefaultToolkit();
        timer = new Timer();
        timer.schedule(new RemindTask(),
                       0,        //initial delay
                       1*1000);  //subsequent rate
    }
    public AnnoyingBeep(Graphics k,int f)
    {
    	l=k;
        toolkit = Toolkit.getDefaultToolkit();
        timer = new Timer();
        timer.schedule(new RemindTasks(),
                       0,        //initial delay
                       1*1000);  //subsequent rate
    }

    class RemindTask extends TimerTask {
        int numWarningBeeps = 10;
        public void run() {
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
                l.drawString("time up", 30, 45);
                l.drawString("ta buudna", 630, 45);
                timer.cancel();
            }
        }
    }
    class RemindTasks extends TimerTask {
        int numWarningBeeps = 10;
        public void run() {
            if (numWarningBeeps > 0) {
            	l.clearRect(30, 15, 100, 30);
                l.clearRect(630, 15, 100, 30);
                l.drawString(Integer.toString(numWarningBeeps), 630, 45);
                if(numWarningBeeps<4){
                	toolkit.beep();}
                numWarningBeeps--;
            } else {
                toolkit.beep(); 
                l.clearRect(30, 15, 100, 30);
                l.clearRect(630, 15, 100, 30);
                l.drawString("time up", 630, 45);
                l.drawString("ta buudna", 30, 45);
                timer.cancel();
            }
        }
    } 
}
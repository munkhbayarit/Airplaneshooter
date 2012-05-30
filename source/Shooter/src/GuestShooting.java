

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class GuestShooting extends JPanel implements ActionListener,MouseListener{
	static private Planes p;
	
	static private JButton cancel,start,refresh;
	public JFrame frame;
	String field, playerName;
	int planss,shootCount,countClick,winnerSh=0,wincount;
	int startgame=0;
	int co=0;
	Graphics gg;
	

	public GuestShooting(String playerNamee, String fieldd, int planeCountt,int shootCountt) {
		field = fieldd;
		planss = planeCountt;
		shootCount = shootCountt;
		playerName = playerNamee;
		frame = new JFrame("Shooter");
		
		p=new Planes(planss,frame,wincount);
		init();
		
		
	}
	
	void init(){
		wincount=0;
		Container con=frame.getContentPane();
		
		p.setLayout(null);
		cancel=new JButton("Cancel");
		cancel.setBounds(300, 400, 100, 20);
		cancel.setBackground(new Color(98, 122, 172));
		cancel.setForeground(new Color(255, 255, 255));
		p.add(cancel);
		
		start=new JButton("Start");
		start.setBounds(100, 400, 100, 20);
		start.setBackground(new Color(98, 122, 172));
		start.setForeground(new Color(255, 255, 255));
		p.add(start);
		
		refresh=new JButton("Refresh");
		refresh.setBounds(500, 400, 100, 20);
		refresh.setBackground(new Color(98, 122, 172));
		refresh.setForeground(new Color(255, 255, 255));
		p.add(refresh);
		
		cancel.addActionListener(this);
		start.addActionListener(this);
		refresh.addActionListener(this);
		addMouseListener(this);
		con.add(p);
		
		
		p.setFocusable(true);
		gg=frame.getGraphics();
		frame.setVisible(true);
		frame.setBackground(new Color(13, 159, 222));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(720, 450);
		frame.setResizable(false);
	 }
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if (cmd.equals("Start")) {
			//cancel.setEnabled(false);
		//	refresh.setEnabled(false);
			startgame=1;
			
		}
		else if (cmd.equals("Cancel")){
			frame.setVisible(false);
			PlayConfigure pc=new PlayConfigure(playerName);
		}
		else if (cmd.equals("Refresh")){	
			frame.setVisible(false);
			   init();
		}		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		//JOptionPane.showMessageDialog(null, e.getX()+" "+e.getY());
		  int gunx=e.getX(),guny=e.getY();
          int xx=(gunx-30)/30,yy=(guny-60)/30;
          int xxx=(gunx-390)/30,yyy=(guny-60)/30;
          gg=ff.getGraphics();
          gg.fillRect(30, 30, 30, 30);
          gg.fillRect(660, 30, 30, 30);
          co++;
          
          if(co%2==1){
          if(gunx<330&&gunx>30&&guny<390&&guny>90){
          	 //JOptionPane.showMessageDialog(null, "ta");
          	 gg.setColor(Color.green);
          	 gg.fillRect(30, 30, 30, 30);
          	 gg.setColor(Color.red);
   	         gg.fillRect(660, 30, 30, 30);
			if(table1[yy][xx]==0){
				gg.drawString("H", xx*30+30+15, yy*30+90+15);
			}
			else if(table1[yy][xx]==1){
				gg.drawString("SH", xx*30+30+15, yy*30+90+15);
			}
			else if(table1[yy][xx]==2){
				gg.drawString("C", xx*30+30+15, yy*30+90+15);
			}
          }
          }
          else{
          if(gunx>390&&gunx<690&&guny<390&&guny>90){
          	// JOptionPane.showMessageDialog(null, "taaa");
          	gg.setColor(Color.red);
          	gg.fillRect(30, 30, 30, 30);
          	 gg.setColor(Color.green);
   	        gg.fillRect(660, 30, 30, 30);
			if(table2[yyy][xxx]==0){
				gg.drawString("H", xxx*30+390+15, yyy*30+90+15);
			}
			else if(table2[yyy][xxx]==1){
				gg.drawString("SH", xxx*30+390+15, yyy*30+90+15);
			}
			else if(table2[yyy][xxx]==2){
				gg.drawString("C", xxx*30+390+15, yyy*30+90+15);
			}
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

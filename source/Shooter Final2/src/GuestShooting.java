
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
//Player shooting the plane
public class GuestShooting extends JPanel implements ActionListener,MouseListener{
	static private Planes p;
	static private JButton cancel,start,refresh;
	public JFrame frame;
	String field, playerName,level;
	int planss,shootCount,countClick,winnerSh=0,wincount;
	int startgame=0;
	
	Graphics gg;
	public GuestShooting(String playerNamee, String fieldd, int planeCountt,int shootCountt,String level1) {
		field = fieldd;
		planss = planeCountt;
		shootCount = shootCountt;
		playerName = playerNamee;
		level=level1;
		frame = new JFrame("Shooter");
		addMouseListener(this);
		p=new Planes(planss,frame,wincount,level,playerName);
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
			//refresh.setEnabled(false);
			cancel.setVisible(false);
			refresh.setVisible(false);
			p.bo=true;
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
		JOptionPane.showMessageDialog(null, e.getX()+" "+e.getY());
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



import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class PlayConfigure extends JFrame implements ActionListener {
	String name;
	private Object item10[] = { "2", "3", "4", "5" };
	private Object item15[] = { "2", "3", "4", "5", "6", "7", "8" };
	private Object shoot[] = { "1", "2", "3" };
	private Object level[] = { "Easy", "Medium", "Hard" };
	
	ActionListener f10action;
	JRadioButton f10, f15, def;
	JComboBox co10, co15, comboShootCount,combolevel;
	JLabel txt;
	JButton cancel, ok;
	JFrame frameo;
	JMenu stat;
	JMenuItem st;

	public PlayConfigure(String namee) {
		name = namee;
		frameo = new JFrame("Option");
		frameo.setBounds(400, 200, 380, 600);

		JMenuBar main = new JMenuBar();
		stat = new JMenu("Statistic");
		st = new JMenuItem("Statistic view");
		st.addActionListener(this);

		stat.add(st);
		main.add(stat);
		frameo.setJMenuBar(main);

		JPanel panel = new JPanel();

		Container contentPane = frameo.getContentPane();
		contentPane.add(panel);
		panel.setBackground(new Color(59, 89, 152));
		panel.setLayout(null);
		//panel.setToolTipText("A Panel container");// cursor ochihod gardag text
		ButtonGroup group = new ButtonGroup();

		ChangeListener listener10 = new ChangeListener() { // A shared listener
			@Override
			public void stateChanged(ChangeEvent e) {
				f10 = (JRadioButton) e.getSource();
				if (f10.isSelected()) 
				{
					co10.setEnabled(true);
				} 
				else 
				{
					co10.setEnabled(false);
				}
			}
		};
		ChangeListener listener15 = new ChangeListener() { // A shared listener
			@Override
			public void stateChanged(ChangeEvent e) {
				f15 = (JRadioButton) e.getSource();
				if (f15.isSelected()) 
				{
					co15.setEnabled(true);
				} else 
				{
					co15.setEnabled(false);
				}
			}
		};

		txt = new JLabel("Welcome to Game.  " + " Mr " + name+".");
		txt.setBounds(15, 20, 200, 20);
		txt.setForeground(new Color(255, 255, 255));
		
		JLabel l0=new JLabel("Level");
		l0.setBounds(15, 60, 100, 20);
		l0.setForeground(new Color(255, 255, 255));
		combolevel=new JComboBox(level);
		combolevel.getSelectedItem();
		combolevel.setBounds(80, 60, 100, 20);
		combolevel.setBackground(new Color(59, 89, 152));
		combolevel.setForeground(new Color(255, 255, 255));
		
	
		def = new JRadioButton("Default Feild(10x10)  Plane(4)");
		def.setSelected(true);
		def.setBounds(10, 90, 200, 20);
		def.setBackground(new Color(59, 89, 152));
		def.setForeground(new Color(255, 255, 255));

		f10 = new JRadioButton("Field (10x10)");
		f10.setBounds(10, 120, 100, 20);
		f10.setBackground(new Color(59, 89, 152));
		f10.setForeground(new Color(255, 255, 255));
		f10.addChangeListener(listener10);

		JLabel l1 = new JLabel("Plane:");
		l1.setBounds(150, 120, 100, 20);
		l1.setForeground(new Color(255, 255, 255));

		co10 = new JComboBox(item10);
		co10.setBounds(200, 120, 40, 20);
		co10.setBackground(new Color(59, 89, 152));
		co10.setForeground(new Color(255, 255, 255));
		co10.setEnabled(false);

		f15 = new JRadioButton("Field (15x15)");
		f15.setBounds(10, 150, 100, 20);
		f15.setBackground(new Color(59, 89, 152));
		f15.setForeground(new Color(255, 255, 255));
		f15.addChangeListener(listener15);

		JLabel l2 = new JLabel("Plane:");
		l2.setBounds(150, 150, 100, 20);
		l2.setForeground(new Color(255, 255, 255));
		
		co15 = new JComboBox(item15);
		co15.setBounds(200, 150, 40, 20);
		co15.setBackground(new Color(59, 89, 152));
		co15.setForeground(new Color(255, 255, 255));
		co15.setEnabled(false);

		JLabel l3=new JLabel("Shoot count:");
		l3.setBounds(112, 180, 80, 20);
		l3.setForeground(new Color(255, 255, 255));
		comboShootCount = new JComboBox(shoot);
		comboShootCount.getSelectedItem();
		comboShootCount.setBounds(200, 180, 40, 20);
		comboShootCount.setBackground(new Color(59, 89, 152));
		comboShootCount.setForeground(new Color(255, 255, 255));

		cancel = new JButton("Cancel");
		cancel.setBounds(140, 250, 100, 20);
		cancel.setBackground(new Color(98, 122, 172));
	    cancel.setForeground(new Color(255, 255, 255));
		cancel.addActionListener(this);

		ok = new JButton("Ok");
		ok.setBounds(10, 250, 100, 20);
		ok.setBackground(new Color(98, 122, 172));
	    ok.setForeground(new Color(255, 255, 255));
		ok.addActionListener(this);

		group.add(f10);
		group.add(def);
		group.add(f15);

		panel.add(l0);
		panel.add(combolevel);
		panel.add(txt);
		panel.add(comboShootCount);
		panel.add(ok);
		panel.add(cancel);
		panel.add(def);
		panel.add(f10);
		panel.add(l1);
		panel.add(co10);
		panel.add(f15);
		panel.add(l2);
		panel.add(co15);
		panel.add(l3);

		frameo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameo.setSize(260, 350);
		frameo.setResizable(false);
		frameo.setBackground(Color.gray);
		frameo.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getActionCommand() == "Cancel") 
		{
			
			frameo.setVisible(false);
			Start s=new Start();
		} 
		else 
		if (e.getActionCommand() == "Ok") 
		{
			if (def.isSelected()) 
			{
				GuestShooting g = new GuestShooting(name, "10x10", 4, Integer.parseInt(comboShootCount.getSelectedItem().toString()));
			
			} 
			else 
			if (f10.isSelected()) 
			{
				GuestShooting g = new GuestShooting(name,"10x10", Integer.parseInt(co10.getSelectedItem().toString()), Integer
							.parseInt(comboShootCount.getSelectedItem().toString()));
			} 
			else 
			if (f15.isSelected()) 
			{
				GuestShooting g = new GuestShooting(name, "15x15", Integer.parseInt(co15.getSelectedItem().toString()),
							Integer.parseInt(comboShootCount.getSelectedItem().toString()));
			} 
			frameo.setVisible(false);
		}
		else 
		if (e.getActionCommand() == "Statistic") 
		{
			Statistic s = new Statistic();
		}
	}
}

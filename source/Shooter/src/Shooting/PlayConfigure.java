package Shooting;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	private Object items[] = { "2", "3", "4", "5" };
	private Object items1[] = { "2", "3", "4", "5", "6", "7", "8" };
	private Object shoot[] = { "Shoot count", "1", "2", "3" };
	ActionListener f10action;
	JRadioButton f10, f15, def;
	JComboBox co, co1, comboShootCount;
	JLabel txt;
	JButton cancel, ok;
	JFrame frame;
	JMenu stat;
	JMenuItem st;

	public PlayConfigure(String namee) {
		name = namee;
		frame = new JFrame("Shooter");
		frame.setBounds(400, 200, 400, 600);

		JMenuBar main = new JMenuBar();
		main.setBackground(new Color(10, 110, 250));
		main.setBorderPainted(false);

		stat = new JMenu("Statistic View");
		stat.setBorderPainted(false);

		st = new JMenuItem("Statistic");
		st.addActionListener(this);

		stat.add(st);
		main.add(stat);
		frame.setJMenuBar(main);

		JPanel panel = new JPanel();

		Container contentPane = frame.getContentPane();
		contentPane.add(panel);
		panel.setBackground(new Color(10, 110 + 60, 250));

		panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

		panel.setLayout(null);
		panel.setToolTipText("A Panel container");
		ButtonGroup group = new ButtonGroup();

		ChangeListener listener = new ChangeListener() { // A shared listener
			@Override
			public void stateChanged(ChangeEvent e) {
				f10 = (JRadioButton) e.getSource();
				if (f10.isSelected()) {
					co.setEnabled(true);
				} else {
					co.setEnabled(false);
				}
			}
		};
		ChangeListener listener1 = new ChangeListener() { // A shared listener
			@Override
			public void stateChanged(ChangeEvent e) {
				f15 = (JRadioButton) e.getSource();
				if (f15.isSelected()) {
					co1.setEnabled(true);
				} else {
					co1.setEnabled(false);
				}
			}
		};

		txt = new JLabel("Welcome");
		txt.setBounds(80, 20, 200, 20);
		txt.setText("Welcome" + "Player " + name);

		def = new JRadioButton("Default/10x10/4 plans/");
		def.setBounds(10, 60, 200, 20);

		f10 = new JRadioButton("field 10x10");
		f10.setBounds(10, 90, 100, 20);
		f10.addChangeListener(listener);

		JLabel l1 = new JLabel("Plans:");
		l1.setBounds(150, 90, 100, 20);

		co = new JComboBox(items);
		co.setBounds(200, 90, 40, 20);
		co.setEnabled(false);

		f15 = new JRadioButton("field 15x15");
		f15.setBounds(10, 120, 100, 20);
		f15.addChangeListener(listener1);

		JLabel l2 = new JLabel("Plans1:");
		l2.setBounds(150, 120, 100, 20);

		co1 = new JComboBox(items1);
		co1.setBounds(200, 120, 40, 20);
		co1.setEnabled(false);

		comboShootCount = new JComboBox(shoot);
		comboShootCount.setBounds(10, 150, 100, 20);

		cancel = new JButton("Cancel");
		cancel.setBounds(100, 220, 80, 30);
		cancel.addActionListener(this);

		ok = new JButton("Ok");
		ok.setBounds(10, 220, 60, 30);
		ok.addActionListener(this);

		group.add(f10);
		group.add(def);
		group.add(f15);

		panel.add(txt);
		panel.add(comboShootCount);
		panel.add(ok);
		panel.add(cancel);
		panel.add(def);
		panel.add(f10);
		panel.add(l1);
		panel.add(co);
		panel.add(f15);
		panel.add(l2);
		panel.add(co1);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 320);
		frame.setResizable(false);
		// frame.setContentPane(j);
		frame.setBackground(Color.gray);
		frame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		// int coutSh=comboShootCount.getSelectedItem();
		if (e.getActionCommand() == "Cancel") {
			frame.setVisible(false);
		} else if (e.getActionCommand() == "Ok") {
			if (def.isSelected()) {
				if (comboShootCount.getSelectedItem() != " "
						&& comboShootCount.getSelectedItem() != "Shoot count") {
					MainClass g = new MainClass(name, "10x10", 4, Integer
							.parseInt(comboShootCount.getSelectedItem()
									.toString()));
					frame.setVisible(false);
				} else
					JOptionPane
							.showMessageDialog(null, "Select Shoot count!!!");
			} else if (f10.isSelected()) {
				if (comboShootCount.getSelectedItem() != " "
						&& comboShootCount.getSelectedItem() != "Shoot count") {
					MainClass g = new MainClass(name, "10x10", Integer
							.parseInt(co.getSelectedItem().toString()), Integer
							.parseInt(comboShootCount.getSelectedItem()
									.toString()));
					frame.setVisible(false);
				} else
					JOptionPane
							.showMessageDialog(null, "Select Shoot count!!!");
			} else if (f15.isSelected()) {
				if (comboShootCount.getSelectedItem() != " "
						&& comboShootCount.getSelectedItem() != "Shoot count") {
					MainClass g = new MainClass(name, "10x10", Integer
							.parseInt(co1.getSelectedItem().toString()),
							Integer.parseInt(comboShootCount.getSelectedItem()
									.toString()));
					frame.setVisible(false);
				} else
					JOptionPane
							.showMessageDialog(null, "Select Shoot count!!!");
			} else {
				JOptionPane.showMessageDialog(null, "Select one!!!!!!!!");
			}
		}

		else if (e.getActionCommand() == "Statistic") {
			Statistic s = new Statistic();
		}
	}
}

package Shooting;

/*
 * Asuudal 1 ter sharh ch yumuu hooson gesen ugiig golluulj bichih
 * ok button darahad undsen form-iig refresh hiih
 * button darah burd database.eees gargaj ireh
 * 
 * */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.Calendar;
import java.sql.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;

public class MainClass extends JPanel implements MouseListener, ActionListener {
	String s1;
	String ss1, field, playerName;
	int planss, count, startgam = 0, shootCount;
	int h = 0, wincount = 0, clickcount = 0, cooo = 0, winnerSh = 0;
	int[][] comPlanes, comPlanes1;
	public InsertValues panel;
	public Graphics gg;
	public JMenu time;
	public Border b;
	public JMenuItem hh;

	public MainClass(String playerNamee, String fieldd, int planeCountt,
			int shootCountt) {
		field = fieldd;
		planss = planeCountt;
		comPlanes1 = new int[planss][16];
		comPlanes = new int[planss][16];

		shootCount = shootCountt;
		playerName = playerNamee;
		init();
		readDatabase();
		panel.addMouseListener(this);
		time.addActionListener(this);
		hh.addActionListener(this);
	}

	public void readDatabase() {
		try {
			String driver, url;
			driver = "com.mysql.jdbc.Driver";
			Class.forName(driver).newInstance();
			url = "jdbc:mysql://localhost:3306/javadb";
			Connection conn = DriverManager.getConnection(url, "root", "");
			Statement st = conn.createStatement();

			int[] data = new int[planss];
			int j = 0;
			for (int i = 0; i < data.length; i++) {
				data[i] = (int) (Math.random() * 7 + 1);
				while (j < i) {
					if (data[j] == data[i]) {
						data[i] = (int) (Math.random() * 7 + 1);
						j = 0;
					} else
						j++;
				}
				j = 0;
			}

			for (int i = 0; i < data.length; i++) {

				ResultSet s = st.executeQuery("select * from plans where id='"
						+ data[i] + "'");
				// ResultSet
				// s=st.executeQuery("select * from plans where id>4");
				while (s.next()) {
					comPlanes[i][0] = Integer.parseInt(s.getString(2));
					comPlanes[i][1] = Integer.parseInt(s.getString(3));
					comPlanes[i][2] = Integer.parseInt(s.getString(4));
					comPlanes[i][3] = Integer.parseInt(s.getString(5));
					comPlanes[i][4] = Integer.parseInt(s.getString(6));
					comPlanes[i][5] = Integer.parseInt(s.getString(7));
					comPlanes[i][6] = Integer.parseInt(s.getString(8));
					comPlanes[i][7] = Integer.parseInt(s.getString(9));
					comPlanes[i][8] = Integer.parseInt(s.getString(10));
					comPlanes[i][9] = Integer.parseInt(s.getString(11));
					comPlanes[i][10] = Integer.parseInt(s.getString(12));
					comPlanes[i][11] = Integer.parseInt(s.getString(13));
					comPlanes[i][12] = Integer.parseInt(s.getString(14));
					comPlanes[i][13] = Integer.parseInt(s.getString(15));
					comPlanes[i][14] = Integer.parseInt(s.getString(16));
					comPlanes[i][15] = Integer.parseInt(s.getString(17));
				}
			}
			conn.close();
		} catch (Exception e) {
			System.err.println("Got an exception1! ");
			System.err.println(e.getMessage());
		}
	}

	public void init() {
		JFrame frame = new JFrame("Shooter");
		frame.setVisible(true);
		panel = new InsertValues(planss);

		JMenuBar main = new JMenuBar();
		main.setBackground(new Color(10, 110, 250));
		main.setForeground(Color.blue);
		main.setBorderPainted(false);
		b = new CompoundBorder(new MatteBorder(0, 0, 0, 0, Color.blue),
				new MatteBorder(0, 0, 0, 0, Color.BLUE));
		main.setBorder(b);
		JMenu game = new JMenu("Game");
		game.setBackground(new Color(10, 110 + 60, 250));

		time = new JMenu(" ");
		time.setFont(new Font("sansserif", Font.PLAIN, 36));
		time.setBackground(Color.black);

		hh = new JMenuItem("Start Game");
		// hh.setBackground(new Color(10, 110+60, 250));
		// hh.setBorder(b);
		// hh=new JMenuItem("Start Game",new ImageIcon("1.jpg"));
		hh.setBorderPainted(false);
		hh.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z,
				ActionEvent.ALT_MASK));
		hh.getAccessibleContext().setAccessibleDescription(
				"This doesn't really do anything");

		game.add(hh);
		main.add(game);
		main.add(time);
		frame.setJMenuBar(main);

		frame.setContentPane(panel);
		gg = frame.getGraphics();
		panel.setFocusable(true);

		frame.setBackground(new Color(10, 80, 250));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(720, 450);
		frame.setResizable(false);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// JOptionPane.showMessageDialog(null, e.getX()+" "+e.getY());
		if (startgam == 1) {
			clickcount++;
			if (clickcount % (shootCount + 1) != 0) {
				// JOptionPane.showMessageDialog(null, "odoo computer buudna");
				gunnerCom();
				// JOptionPane.showMessageDialog(null, "odoo ta buudna");
			} else {
				// JOptionPane.showMessageDialog(null,
				// "odoo ta computer buudna");
				// TODO Auto-generated method stub
				if (wincount == planss) {
					JOptionPane.showMessageDialog(null, "Winner");
					// database-d tuhain hunii onoog nemne
					calcPoint();
				}
				int curx, cury, curxx, curyy;
				gg.setColor(Color.red);
				for (int i = 390; i < 690; i += 30) {
					for (int j = 60; j < 360; j += 30) {
						curx = i + 30;
						cury = j + 30;
						curxx = curx;
						curyy = cury;
						if (i < e.getX() && e.getX() < curx && e.getY() > j
								&& e.getY() < cury) {
							for (int yyy = 0; yyy < comPlanes.length; yyy++) {
								curxx = comPlanes[yyy][1] + 390 + 30; // database
																		// dehi
																		// 3
								curyy = comPlanes[yyy][0] + 60 + 30; // database
																		// dehi
																		// 2
								if ((comPlanes[yyy][1] + 390) < e.getX()
										&& e.getX() < curxx
										&& e.getY() > (comPlanes[yyy][0] + 60)
										&& e.getY() < curyy) {
									gg.drawString("S", (curx + i) / 2,
											(cury + j) / 2 + 80);
									wincount++;

								}
								curxx = comPlanes[yyy][3] + 390 + 30;
								curyy = comPlanes[yyy][2] + 60 + 30;

								if ((comPlanes[yyy][3] + 390) < e.getX()
										&& e.getX() < curxx
										&& e.getY() > (comPlanes[yyy][2] + 60)
										&& e.getY() < curyy) {
									gg.drawString("sh", (curx + i) / 2,
											(cury + j) / 2 + 80);
									winnerSh++;
								}

								curxx = comPlanes[yyy][5] + 390 + 30;
								curyy = comPlanes[yyy][4] + 60 + 30;
								if ((comPlanes[yyy][5] + 390) < e.getX()
										&& e.getX() < curxx
										&& e.getY() > (comPlanes[yyy][4] + 60)
										&& e.getY() < curyy) {
									gg.drawString("sh", (curx + i) / 2,
											(cury + j) / 2 + 80);
									winnerSh++;
								}

								curxx = comPlanes[yyy][7] + 390 + 30;
								curyy = comPlanes[yyy][6] + 60 + 30;
								if ((comPlanes[yyy][7] + 390) < e.getX()
										&& e.getX() < curxx
										&& e.getY() > (comPlanes[yyy][6] + 60)
										&& e.getY() < curyy) {
									gg.drawString("sh", (curx + i) / 2,
											(cury + j) / 2 + 80);
									winnerSh++;
								}

								curxx = comPlanes[yyy][9] + 390 + 30;
								curyy = comPlanes[yyy][8] + 60 + 30;
								if ((comPlanes[yyy][9] + 390) < e.getX()
										&& e.getX() < curxx
										&& e.getY() > (comPlanes[yyy][8] + 60)
										&& e.getY() < curyy) {
									gg.drawString("sh", (curx + i) / 2,
											(cury + j) / 2 + 80);
									winnerSh++;
								}

								curxx = comPlanes[yyy][11] + 390 + 30;
								curyy = comPlanes[yyy][10] + 60 + 30;
								if ((comPlanes[yyy][11] + 390) < e.getX()
										&& e.getX() < curxx
										&& e.getY() > (comPlanes[yyy][10] + 60)
										&& e.getY() < curyy) {
									gg.drawString("sh", (curx + i) / 2,
											(cury + j) / 2 + 80);
									winnerSh++;
								}

								curxx = comPlanes[yyy][13] + 390 + 30;
								curyy = comPlanes[yyy][12] + 60 + 30;
								if ((comPlanes[yyy][13] + 390) < e.getX()
										&& e.getX() < curxx
										&& e.getY() > (comPlanes[yyy][12] + 60)
										&& e.getY() < curyy) {
									gg.drawString("sh", (curx + i) / 2,
											(cury + j) / 2 + 80);
									winnerSh++;
								}

								curxx = comPlanes[yyy][15] + 390 + 30;
								curyy = comPlanes[yyy][14] + 60 + 30;
								if ((comPlanes[yyy][15] + 390) < e.getX()
										&& e.getX() < curxx
										&& e.getY() > (comPlanes[yyy][14] + 60)
										&& e.getY() < curyy) {
									gg.drawString("sh", (curx + i) / 2,
											(cury + j) / 2 + 80);
									winnerSh++;
								}
							}
						}
						// gg.drawString("H", (curx+i)/2, (cury+j)/2+80);
					}
				}
			}
		} else
			JOptionPane.showMessageDialog(null, "Start Game Please!!!");
	}

	void gunnerCom() {
		try {
			String driver, url;
			driver = "com.mysql.jdbc.Driver";
			Class.forName(driver).newInstance();
			url = "jdbc:mysql://localhost:3306/javadb";
			Connection conn = DriverManager.getConnection(url, "root", "");
			Statement st = conn.createStatement();

			for (int ir = 0; ir < panel.yourplane.length; ir++) {

				ResultSet s = st.executeQuery("select * from plans where id='"
						+ panel.yourplane[ir] + "'");
				// ResultSet
				// s=st.executeQuery("select * from plans where id>4");
				while (s.next()) {
					comPlanes1[ir][0] = Integer.parseInt(s.getString(2));
					comPlanes1[ir][1] = Integer.parseInt(s.getString(3));
					comPlanes1[ir][2] = Integer.parseInt(s.getString(4));
					comPlanes1[ir][3] = Integer.parseInt(s.getString(5));
					comPlanes1[ir][4] = Integer.parseInt(s.getString(6));
					comPlanes1[ir][5] = Integer.parseInt(s.getString(7));
					comPlanes1[ir][6] = Integer.parseInt(s.getString(8));
					comPlanes1[ir][7] = Integer.parseInt(s.getString(9));
					comPlanes1[ir][8] = Integer.parseInt(s.getString(10));
					comPlanes1[ir][9] = Integer.parseInt(s.getString(11));
					comPlanes1[ir][10] = Integer.parseInt(s.getString(12));
					comPlanes1[ir][11] = Integer.parseInt(s.getString(13));
					comPlanes1[ir][12] = Integer.parseInt(s.getString(14));
					comPlanes1[ir][13] = Integer.parseInt(s.getString(15));
					comPlanes1[ir][14] = Integer.parseInt(s.getString(16));
					comPlanes1[ir][15] = Integer.parseInt(s.getString(17));
				}
			}
			conn.close();
		} catch (Exception e) {
			System.err.println("Got an exception1! ");
			System.err.println(e.getMessage());
		}
		int gunx = 30 * ((int) (Math.random() * 10));
		int guny = 30 * ((int) (Math.random() * 10));

		if (cooo == planss) {
			JOptionPane.showMessageDialog(null, "Game over!!!");
		}
		for (int ei = 30; ei < 330; ei += 30) {
			for (int ej = 60; ej < 360; ej += 30) {
				int ccurx = ei + 30;
				int ccury = ej + 30;
				if (ei == (gunx + 30) && ej == (guny + 60)) {
					for (int ey = 0; ey < comPlanes1.length; ey++) {
						if (gunx == comPlanes1[ey][0]
								&& comPlanes1[ey][1] == guny) {
							gg.drawString("S", (ccurx + ei) / 2 + 30,
									(ccury + ej) / 2 + 60);
							cooo++;
						} else if (gunx == comPlanes1[ey][2]
								&& comPlanes1[ey][3] == guny) {
							gg.drawString("sh", (ccurx + ei) / 2 + 30,
									(ccury + ej) / 2 + 60);
						} else if (gunx == comPlanes1[ey][4]
								&& comPlanes1[ey][5] == guny) {
							gg.drawString("sh", (ccurx + ei) / 2 + 30,
									(ccury + ej) / 2 + 60);
						}

						else if (gunx == comPlanes1[ey][6]
								&& comPlanes1[ey][7] == guny) {
							gg.drawString("sh", (ccurx + ei) / 2 + 30,
									(ccury + ej) / 2 + 60);
						} else if (gunx == comPlanes1[ey][8]
								&& comPlanes1[ey][9] == guny) {
							gg.drawString("sh", (ccurx + ei) / 2 + 30,
									(ccury + ej) / 2 + 60);
						}

						else if (gunx == comPlanes1[ey][10]
								&& comPlanes1[ey][11] == guny) {
							gg.drawString("sh", (ccurx + ei) / 2 + 30,
									(ccury + ej) / 2 + 60);
						}

						else if (gunx == comPlanes1[ey][12]
								&& comPlanes1[ey][13] == guny) {
							gg.drawString("sh", (ccurx + ei) / 2 + 30,
									(ccury + ej) / 2 + 60);
						}

						else if (gunx == comPlanes1[ey][14]
								&& comPlanes1[ey][15] == guny) {
							gg.drawString("sh", (ccurx + ei) / 2 + 30,
									(ccury + ej) / 2 + 60);
						}
					}
				}
			}
		}
	}

	public void calcPoint() {
        int point;
        String date;
        point=winnerSh*50+wincount*500;
        point=point-cooo*100;
        Calendar now = Calendar.getInstance();
        int y = now.get(Calendar.YEAR);
        int m = now.get(Calendar.MONTH);
        int d = now.get(Calendar.DAY_OF_YEAR);
        
        date=Integer.toString(y)+"-"+Integer.toString(m)+"-"+Integer.toString(d);
        
        try {
			String driver1, url1;
			driver1 = "com.mysql.jdbc.Driver";
			Class.forName(driver1).newInstance();
			url1 = "jdbc:mysql://localhost:3306/javadb";
			Connection conn1 = DriverManager.getConnection(url1, "root", "");
			Statement st1 = conn1.createStatement();
		    st1.executeUpdate("INSERT INTO stat(`id` ,`name` ,`score` ,`Date`) VALUES (NULL,'"+playerName+"','"+point+"','"+date+"')");
			conn1.close();
		} catch (Exception e) {
			System.err.println("Got an exception11! ");
			System.err.println(e.getMessage());
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		// System.out.println("enter");
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

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if (cmd.equals("Start Game")) {
			startgam = 1;
			javax.swing.Timer t = new javax.swing.Timer(1000,
					new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Calendar now = Calendar.getInstance();
							setForeground(Color.green);
							int h = now.get(Calendar.HOUR_OF_DAY);
							int m = now.get(Calendar.MINUTE);
							int s = now.get(Calendar.SECOND);
							time
									.setText("                                              "
											+ "      " + Integer.toString(s));
						}
					});
			t.start();
		}
	}
}

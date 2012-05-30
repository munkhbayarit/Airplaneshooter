

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Statistic extends JFrame {

	JLabel t1, t2, t3, txt;
	int count=0;

	public Statistic() {
		JFrame frame = new JFrame("Statistic");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(800, 100, 400, 600);

		JPanel LeftPanel = new JPanel();
		LeftPanel.setPreferredSize(new Dimension(200, 200));
		LeftPanel.setBackground(Color.green);
		LeftPanel.setLayout(null);

		txt = new JLabel("Top Players:");
		txt.setBounds(40, 20, 100, 20);

		t1 = new JLabel("Top Player1:");
		t1.setBounds(20, 50, 200, 20);

		t2 = new JLabel("Top Player1:");
		t2.setBounds(20, 80, 200, 20);

		t3 = new JLabel("Top Player1:");
		t3.setBounds(20, 110, 200, 20);
		readDatabase();
		LeftPanel.add(txt);
		LeftPanel.add(t1);
		LeftPanel.add(t2);
		LeftPanel.add(t3);
		frame.getContentPane().add(LeftPanel);
		frame.pack();
		frame.setResizable(false);
		frame.setVisible(true);
	}

	public void readDatabase() {
		try {
			String driver, url,m,l;
			driver = "com.mysql.jdbc.Driver";
			Class.forName(driver).newInstance();
			url = "jdbc:mysql://localhost:3306/javadb";
			Connection conn = DriverManager.getConnection(url, "root", "");
			Statement st = conn.createStatement();

			ResultSet s = st.executeQuery("select * from stat ORDER BY score DESC");
			while (s.next()) {
				 count++;
				 if(count==1)
                     t1.setText(s.getString(2)+"  score:("+s.getString(3)+")  "+s.getString(4));
				 else if(count==2)
					 t2.setText(s.getString(2)+"  score:("+s.getString(3)+")  "+s.getString(4));
				 else if(count==3)
					 t3.setText(s.getString(2)+"  score:("+s.getString(3)+")  "+s.getString(4));
			}
			conn.close();
		} catch (Exception e) {
			System.err.println("data base not connect! ");
			System.err.println(e.getMessage());
		}
	}
}

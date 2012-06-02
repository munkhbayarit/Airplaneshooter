

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
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
//Show's the statistic and high score it takes data from database
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

		t1 = new JLabel("");
		t1.setBounds(20, 50, 200, 20);

		t2 = new JLabel("");
		t2.setBounds(20, 80, 200, 20);

		t3 = new JLabel("");
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
		try{
			  // Open the file that is the first 
			  // command line parameter
			  FileInputStream fstream = new FileInputStream("out.txt");
			  // Get the object of DataInputStream
			  DataInputStream in = new DataInputStream(fstream);
			  BufferedReader br = new BufferedReader(new InputStreamReader(in));
			  String strLine;
			  //Read File Line By Line
			  while ((strLine = br.readLine()) != null)   {
			  // Print the content on the console
			 t1.setText(strLine);
			  }
			  //Close the input stream
			  in.close();
			    }catch (Exception e){//Catch exception if any
			  System.err.println("Error: " + e.getMessage());
			  }
			  }
}

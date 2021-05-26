package squanalyze2;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.BorderLayout;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Feedback {
	JFrame frame;
	private JTextField FBP1;
	private JTextField FBP2;
	JLabel P2L;
	JLabel P1L;
	String p1id;
	String p2id;
	int totalp1, totalp2 = 0;
	Connection connection = null;
	int MtchID = HomePg.getMtchID();
	int plr1id = HomePg.getP1ID();
	int plr2id = HomePg.getP2ID();

	public Feedback() {
		connection = MySQLConnection.dbConnector();
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 751, 391);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		P1L = new JLabel("Player 1");
		P1L.setBounds(217, 11, 150, 14);
		frame.getContentPane().add(P1L);
		JSlider slider = new JSlider(1,10,1);
		slider.setBounds(165, 52, 200, 23);
		slider.setMajorTickSpacing(1);
		slider.setPaintTicks(true);
		frame.getContentPane().add(slider);
		
		JSlider slider_1 = new JSlider(1,10,1);
		slider_1.setBounds(165, 86, 200, 23);
		slider_1.setMajorTickSpacing(1);
		slider_1.setPaintTicks(true);
		frame.getContentPane().add(slider_1);
		
		JSlider slider_2 = new JSlider(1,10,1);
		slider_2.setBounds(165, 120, 200, 23);
		slider_2.setMajorTickSpacing(1);
		slider_2.setPaintTicks(true);
		frame.getContentPane().add(slider_2);
		
		JSlider slider_3 = new JSlider(1,10,1);
		slider_3.setBounds(165, 154, 200, 23);
		slider_3.setMajorTickSpacing(1);
		slider_3.setPaintTicks(true);
		frame.getContentPane().add(slider_3);
		
		JSlider slider_4 = new JSlider(1,10,1);
		slider_4.setBounds(165, 188, 200, 23);
		slider_4.setMajorTickSpacing(1);
		slider_4.setPaintTicks(true);
		frame.getContentPane().add(slider_4);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(165, 238, 200, 32);
		frame.getContentPane().add(scrollPane);
		
		FBP1 = new JTextField();
		scrollPane.setViewportView(FBP1);
		FBP1.setColumns(10);
		
		P2L = new JLabel("Player 2");
		P2L.setBounds(550, 11, 150, 14);
		frame.getContentPane().add(P2L);
		
		JSlider slider_5 = new JSlider(1,10,1);
		slider_5.setMajorTickSpacing(1);
		slider_5.setPaintTicks(true);
		slider_5.setBounds(510, 52, 200, 23);
		frame.getContentPane().add(slider_5);
		
		JSlider slider_6 = new JSlider(1,10,1);
		slider_6.setBounds(510, 86, 200, 23);
		slider_6.setMajorTickSpacing(1);
		slider_6.setPaintTicks(true);
		frame.getContentPane().add(slider_6);
		
		JSlider slider_7 = new JSlider(1,10,1);
		slider_7.setBounds(510, 120, 200, 23);
		slider_7.setMajorTickSpacing(1);
		slider_7.setPaintTicks(true);
		frame.getContentPane().add(slider_7);
		
		JSlider slider_8 = new JSlider(1,10,1);
		slider_8.setBounds(510, 154, 200, 23);
		slider_8.setMajorTickSpacing(1);
		slider_8.setPaintTicks(true);
		frame.getContentPane().add(slider_8);
		
		JSlider slider_9 = new JSlider(1,10,1);
		slider_9.setBounds(510, 188, 200, 23);
		slider_9.setMajorTickSpacing(1);
		slider_9.setPaintTicks(true);
		frame.getContentPane().add(slider_9);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(510, 238, 190, 32);
		frame.getContentPane().add(scrollPane_1);
		
		FBP2 = new JTextField();
		scrollPane_1.setViewportView(FBP2);
		FBP2.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Comments");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNewLabel_2.setBounds(47, 242, 70, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Comments");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNewLabel_3.setBounds(409, 242, 74, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Agility");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4.setBounds(28, 129, 89, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("Speed");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4_1.setBounds(28, 61, 70, 14);
		frame.getContentPane().add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_2 = new JLabel("Stamina");
		lblNewLabel_4_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4_2.setBounds(28, 95, 89, 14);
		frame.getContentPane().add(lblNewLabel_4_2);
		
		JLabel lblNewLabel_4_3 = new JLabel("Shot Selection");
		lblNewLabel_4_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4_3.setBounds(28, 163, 113, 14);
		frame.getContentPane().add(lblNewLabel_4_3);
		
		JLabel lblNewLabel_4_4 = new JLabel("Court Behaviour");
		lblNewLabel_4_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4_4.setBounds(28, 197, 127, 14);
		frame.getContentPane().add(lblNewLabel_4_4);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				totalp1 = slider.getValue() + slider_1.getValue() + slider_2.getValue() + slider_3.getValue() + slider_4.getValue(); 
				totalp2 = slider_6.getValue() + slider_7.getValue() + slider_8.getValue() + slider_9.getValue() + slider_5.getValue();
				
				try {
					PreparedStatement st = connection.prepareStatement ("insert into coach_feedback (`Player ID`, `Mtch ID`, Feedback,`Speed`, Agility, `Shot Selection`, Stamina, `Court Behaviour`, Total) values('"+plr1id+"','"+MtchID+"','"+FBP1.getText()+"','"+slider.getValue()+"', '"+slider_1.getValue()+"', '"+slider_2.getValue()+"', '"+slider_3.getValue()+"', '"+slider_4.getValue()+"', '"+totalp1+"')");
					st.execute();
//					JOptionPane.showMessageDialog(null,"Added Feedback");
				}catch(Exception e1) {
					e1.printStackTrace();
				}
				
				try {
					PreparedStatement st = connection.prepareStatement ("update players set `Leader-Board Pts`=`Leader-Board Pts` + '"+totalp1+"' where `Player ID`='"+plr1id+"'");
					st.execute();
//					JOptionPane.showMessageDialog(null,"Updated LeaderBoard");
				}catch(Exception e1) {
					e1.printStackTrace();
				}
				
				try {
					PreparedStatement st = connection.prepareStatement ("insert into coach_feedback (`Player ID`, `Mtch ID`, Feedback,`Speed`, Agility, `Shot Selection`, Stamina, `Court Behaviour`, Total) values('"+plr2id+"','"+MtchID+"','"+FBP2.getText()+"','"+slider_5.getValue()+"', '"+slider_6.getValue()+"', '"+slider_7.getValue()+"', '"+slider_8.getValue()+"', '"+slider_9.getValue()+"', '"+totalp2+"')");
					st.execute();
//					JOptionPane.showMessageDialog(null,"Added Feedback");
				}catch(Exception e1) {
					e1.printStackTrace();
				}
				
				try {
					PreparedStatement st = connection.prepareStatement ("update players set `Leader-Board Pts`=`Leader-Board Pts` + '"+totalp2+"' where `Player ID`='"+plr2id+"'");
					st.execute();
					JOptionPane.showMessageDialog(null,"Added Feedback, Updated LeaderBoard");
				}catch(Exception e1) {
					e1.printStackTrace();
				}
				
				HomePg.ldDataToLB("select Name,`Leader-board Pts` from players order by `Leader-Board Pts` desc");
				HomePg.ldDataToMtchHist("select `Match ID`,`Player1 ID`, `Player2 ID`, Date, Result, `#Games` from `matches`");
				HomePg.ldDataToPFA("select `ID`,`Name`, `#Matches`, `#Won`, `#Lost` from `player stats` INNER JOIN `players` ON `player stats`.`ID`=`players`.`Player ID`");
			}
		});
		btnNewButton.setBounds(394, 297, 89, 23);
		frame.getContentPane().add(btnNewButton);
	}
}

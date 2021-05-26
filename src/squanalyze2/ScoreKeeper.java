package squanalyze2;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;


import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.File;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;





import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;
import java.util.TreeMap;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;


import javax.swing.JScrollPane;
import javax.swing.JTable;

@SuppressWarnings("unused")
public class ScoreKeeper {

	public JFrame frame;
	JLabel P1Lbl;
	int countt=0;
	JLabel P1Score;
	JLabel P2Score;
	JLabel P2Lbl;
	String p1n;
	String p2n;
	Object [] columns = {"Rohan Kapoor", "Arohi Shukla"};
	private JTable table = new JTable();
	DefaultTableModel model = new DefaultTableModel();
	
	int P1GmsW = 0;
	int P2GmsW = 0;
	int P1Scr, P2Scr = 0;
	public ScoreKeeper() {
		connection = MySQLConnection.dbConnector();
		initialize();
	}
	JTextArea area;
	int Gms = HomePg.getNoGms();
    int countGms = 1;
    JButton btnNewButtonFinish;
	Connection connection = null;
	JLabel lblNewLabel_1;
	String temp;
	boolean flagP1;
	boolean flagP2;
	JButton btnNewButton;
	JButton btnNewButton_1;
	JButton btnNewButton_2;
	JButton btnNewButton_3;
	JButton btnNewButton_4;
	JButton btnNewButton_5;
	
	String mp1;
	String wp1;
	String lp1;
	public void updateStatsP1() {
			
			try {
				PreparedStatement st = connection.prepareStatement ("select `Player ID` from players where Name = ?");
				st.setString(1, P1Lbl.getText());
				ResultSet rs = st.executeQuery();
				
				if(rs.next()) {
					temp = rs.getString("Player ID");
				}	
			}catch(Exception e1) {
				e1.printStackTrace();
			}
			
			if(flagP1) {
				PreparedStatement st;
				try {

					st = connection.prepareStatement ( "select `#Matches`, `#Won` from `player stats` where `ID` ='"+Integer.parseInt(temp)+"'");
					st.execute();
					ResultSet rs = st.executeQuery();
					while (rs.next()) {
						mp1 = rs.getString(1);
						wp1 = rs.getString(2);
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				try {

					st = connection.prepareStatement ( "update `player stats` set `#Matches`=?, `#Won`=? where `ID` ='"+Integer.parseInt(temp)+"'");
					st.setInt(1, Integer.parseInt(mp1)+1);
					st.setInt(2, Integer.parseInt(wp1)+1);
					st.execute();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}else {

				PreparedStatement st;
				try {

					st = connection.prepareStatement ( "select `#Matches`, `#Lost` from `player stats` where `ID` ='"+Integer.parseInt(temp)+"'");
					st.execute();
					ResultSet rs = st.executeQuery();
					while (rs.next()) {
						mp1 = rs.getString(1);
						lp1 = rs.getString(2);
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				try {

					st = connection.prepareStatement ( "update `player stats` set `#Matches`=?, `#Lost`=? where `ID` ='"+Integer.parseInt(temp)+"'");
					st.setInt(1, Integer.parseInt(mp1)+1);
					st.setInt(2, Integer.parseInt(lp1)+1);
					st.execute();
				} catch (SQLException e) {
					e.printStackTrace();
				}

				
				
			}
		}
	
	
	
	String mp2;
	String wp2;
	String lp2;

	private String getCellVal(int x, int y) {
		return model.getValueAt(x, y).toString();
	}
	
	private int getCellID() {
		countt++;
		if(countt==2) {
			countt=0;
			return 2;
		}else {
			return countt;
		}
		
	}
	
	private void writeToExcel() throws IOException {
		
//		XSSFWorkbook wb = new XSSFWorkbook();
//		XSSFSheet ws = wb.createSheet();
//		TreeMap<String, Object[]> data = new TreeMap<>();
//		
//		
//		for(int i=0; i<model.getRowCount(); i++) {
//			data.put(Integer.toString(i), new Object[] {getCellVal(i,0), getCellVal(i,1)});
//		}
//		
//		//data.put("0", new Object[] {model.getColumnName(0), model.getColumnName(1)});
//		
//		Set<String> ids =data.keySet();
//		XSSFRow row;
//		int rowID = 0;
//		int cellID = 0;
//		for(int i = 0; i<model.getRowCount()) {
//			for(int j = 0; j<model.getColumnCount())
//			row = ws.createRow(rowID++);
//			Object[] values = data.get(key);
//			
//			for(Object o:values) {
//				Cell cell = row.createCell(getCellID());
//				cell.setCellValue(o.toString());
//			}
//		}
//		
//		try {
//			FileOutputStream fos = new FileOutputStream(new File("C:\\Users\\LENOVO\\Desktop\\tst\\"+Integer.toString(HomePg.Curr_MatchID)+".xlsx"));
//			wb.write(fos);
//			fos.close();
//		}finally{
//			
//		}
//		
		
		
		
	}

	
	private void exportTable(JTable table, File file) throws IOException {
		FileWriter out = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(out);
		for(int i = 0; i<model.getColumnCount(); i++) {
			bw.write(model.getColumnName(i) + "\t");
		}
		bw.write("\n");
		
		for(int i= 0; i<model.getRowCount(); i++) {
			for(int j =0; j<model.getColumnCount();j++) {
				bw.write(model.getValueAt(i, j) + "\t");
			}
			bw.write("\n");
		}
		bw.close();
	}
	

	public void updateStatsP2() {
		
		try {
			PreparedStatement st = connection.prepareStatement ("select `Player ID` from players where Name = ?");
			st.setString(1, P2Lbl.getText());
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {
				temp = rs.getString("Player ID");
			}	
		}catch(Exception e1) {
			e1.printStackTrace();
		}
		
		if(flagP2) {
			PreparedStatement st;
			try {

				st = connection.prepareStatement ( "select `#Matches`, `#Won` from `player stats` where `ID` ='"+Integer.parseInt(temp)+"'");
				st.execute();
				ResultSet rs = st.executeQuery();
				while (rs.next()) {
					mp2 = rs.getString(1);
					wp2 = rs.getString(2);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			try {

				st = connection.prepareStatement ( "update `player stats` set `#Matches`=?, `#Won`=? where `ID` ='"+Integer.parseInt(temp)+"'");
				st.setInt(1, Integer.parseInt(mp2)+1);
				st.setInt(2, Integer.parseInt(wp2)+1);
				st.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}else {

			PreparedStatement st;
			try {

				st = connection.prepareStatement ( "select `#Matches`, `#Lost` from `player stats` where `ID` ='"+Integer.parseInt(temp)+"'");
				st.execute();
				ResultSet rs = st.executeQuery();
				while (rs.next()) {
					mp2 = rs.getString(1);
					lp2 = rs.getString(2);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			try {

				st = connection.prepareStatement ( "update `player stats` set `#Matches`=?, `#Lost`=? where `ID` ='"+Integer.parseInt(temp)+"'");
				st.setInt(1, Integer.parseInt(mp2)+1);
				st.setInt(2, Integer.parseInt(lp2)+1);
				st.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			
			
		}
	}

	
	private void getNmee() {
		PreparedStatement st;
		try {

			st = connection.prepareStatement ( "select `Name` from `players` where `Player ID` ='"+Integer.parseInt(HomePg.p1id)+"'");
			st.execute();
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				p1n = rs.getString(0);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {

			st = connection.prepareStatement ( "select `Name` from `players` where `Player ID` ='"+Integer.parseInt(HomePg.p2id)+"'");
			st.execute();
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				p2n = rs.getString(0);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 648, 435);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		P1Lbl = new JLabel("P1");
		P1Lbl.setBounds(34, 26, 241, 14);
		frame.getContentPane().add(P1Lbl);
		
		
		P2Lbl = new JLabel("P2");
		P2Lbl.setBounds(34, 175, 241, 14);
		frame.getContentPane().add(P2Lbl);
		
		P1Score = new JLabel(Integer.toString(P1Scr));
		P1Score.setFont(new Font("Tahoma", Font.PLAIN, 30));
		P1Score.setBounds(90, 62, 66, 54);
		frame.getContentPane().add(P1Score);
		model.setColumnIdentifiers(columns);
		table.setModel(model);
		
		
		P2Score = new JLabel(Integer.toString(P2Scr));
		P2Score.setFont(new Font("Tahoma", Font.PLAIN, 30));
		P2Score.setBounds(90, 227, 66, 46);
		frame.getContentPane().add(P2Score);
		btnNewButton = new JButton("Winner");
		btnNewButton.setBackground(Color.GREEN);
		

		
		Object [] rows = new Object[2];
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				P1Scr+=1;
				rows[0] = Integer.toString(P1Scr);
				rows[1] = Integer.toString(P2Scr);
				model.addRow(rows);
				P1Score.setText(Integer.toString(P1Scr));
				
				
				
				if(P1Scr == 11) {
					P1Scr = 0;
					P2Scr = 0;
					P1Score.setText(Integer.toString(P1Scr));
					P2Score.setText(Integer.toString(P2Scr));
					
					countGms += 1;
					if (countGms == Gms+1) {
						btnNewButtonFinish.setVisible(true);
						countGms-=1;
					}
					lblNewLabel_1.setText(Integer.toString(countGms) + "/" + Integer.toString(Gms));
					P1GmsW += 1;
					if (P1GmsW == Gms || P1GmsW == Gms-1) {
						JOptionPane.showMessageDialog(null, P1Lbl.getText() + " " +"WON");
						flagP1 = true;
						updateStatsP1();
						updateStatsP2();
						btnNewButton.setEnabled(false);
						btnNewButton_1.setEnabled(false);
						btnNewButton_2.setEnabled(false);
						btnNewButton_3.setEnabled(false);
						btnNewButton_4.setEnabled(false);
						btnNewButton_5.setEnabled(false);
						
						try {
							PreparedStatement st;
							st = connection.prepareStatement ( "update `matches` set `Result`=? where `Match ID` ='"+HomePg.Curr_MatchID+"'");
							st.setInt(1, Integer.parseInt(HomePg.p1id));
							st.execute();
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
						
					}
					
				}
			}
		});
		btnNewButton.setBounds(263, 51, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		btnNewButton_1 = new JButton("Stroke");
		btnNewButton_1.setBackground(Color.RED);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				P2Scr += 1;
				P2Score.setText(Integer.toString(P2Scr));
				rows[0] = Integer.toString(P1Scr) + " STROKE";
				rows[1] = Integer.toString(P2Scr);
				model.addRow(rows);
			}
		});
		btnNewButton_1.setBounds(263, 86, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Let");
		btnNewButton_2.setBackground(Color.ORANGE);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rows[0] = Integer.toString(P1Scr) + " LET";
				rows[1] = Integer.toString(P2Scr);
				model.addRow(rows);
			}
		});
	
		btnNewButton_2.setBounds(263, 120, 89, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("Winner");
		btnNewButton_3.setBackground(Color.GREEN);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				P2Scr+=1;
				rows[0] = Integer.toString(P1Scr);
				rows[1] = Integer.toString(P2Scr);
				model.addRow(rows);
				P2Score.setText(Integer.toString(P2Scr));
				
				if(P2Scr == 11) {
					P1Scr = 0;
					P2Scr = 0;
					P1Score.setText(Integer.toString(P1Scr));
					P2Score.setText(Integer.toString(P2Scr));
					countGms += 1;
					if (countGms == Gms+1) {
						btnNewButtonFinish.setVisible(true);
						countGms-=1;
					}
					lblNewLabel_1.setText(Integer.toString(countGms) + "/" + Integer.toString(Gms));
					P2GmsW += 1;
					if (P2GmsW == Gms || P2GmsW == Gms-1) {
						JOptionPane.showMessageDialog(null, P2Lbl.getText() + " " + "Won");
						flagP2 = true;
						updateStatsP1();
						updateStatsP2();
						btnNewButton.setEnabled(false);
						btnNewButton_1.setEnabled(false);
						btnNewButton_2.setEnabled(false);
						btnNewButton_3.setEnabled(false);
						btnNewButton_4.setEnabled(false);
						btnNewButton_5.setEnabled(false);
						
						try {
							PreparedStatement st;
							st = connection.prepareStatement ( "update `matches` set `Result`=? where `Match ID` ='"+HomePg.Curr_MatchID+"'");
							st.setInt(1, Integer.parseInt(HomePg.p2id));
							st.execute();
						} catch (SQLException e1) {
							e1.printStackTrace();
						}

						
					}
				
				}
			}
		});
		btnNewButton_3.setBounds(263, 199, 89, 23);
		frame.getContentPane().add(btnNewButton_3);
		
		btnNewButton_4 = new JButton("Stroke");
		btnNewButton_4.setBackground(Color.RED);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				P1Scr+=1;
				P1Score.setText(Integer.toString(P1Scr));
				P2Score.setText(Integer.toString(P2Scr));
				rows[0] = Integer.toString(P1Scr);
				rows[1] = Integer.toString(P2Scr) + " STROKE";
				model.addRow(rows);
			}
		});
		btnNewButton_4.setBounds(263, 233, 89, 23);
		frame.getContentPane().add(btnNewButton_4);
		
		btnNewButton_5 = new JButton("Let");
		btnNewButton_5.setBackground(Color.ORANGE);
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rows[0] = Integer.toString(P1Scr);
				rows[1] = Integer.toString(P2Scr) + " LET";
				model.addRow(rows);
			}
		});
		btnNewButton_5.setBounds(263, 267, 89, 23);
		frame.getContentPane().add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Toss");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int rand = (int)(Math.random()*2);
				if(rand==0) {
					JOptionPane.showMessageDialog(null,"Heads");
				}
				else if (rand==1) {
					JOptionPane.showMessageDialog(null,"Tails");
				}
			}
		});
		
		
		btnNewButton_6.setBounds(46, 344, 89, 23);
		frame.getContentPane().add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("Generate Scoresheet");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				try {
//					writeToExcel();
//				} catch (IOException e1) {
//					e1.printStackTrace();
//				}
				
				try {
					exportTable(table, new File("C:\\Users\\LENOVO\\Desktop\\tst\\"+Integer.toString(HomePg.Curr_MatchID)+".xls"));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				JOptionPane.showMessageDialog(null, "Saved");
			}
			
		});
		btnNewButton_7.setBounds(151, 344, 156, 23);
		frame.getContentPane().add(btnNewButton_7);
		
		btnNewButtonFinish = new JButton("Finish");
		btnNewButtonFinish.setVisible(false);
		btnNewButtonFinish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Feedback window = new Feedback();
				window.frame.setVisible(true);
				window.P1L.setText(P1Lbl.getText());
				window.P2L.setText(P2Lbl.getText());

			}
		});
		btnNewButtonFinish.setBounds(317, 344, 89, 23);
		frame.getContentPane().add(btnNewButtonFinish);
		
		//area = new JTextArea();
		//scrollPane.setViewportView(area);
		
		JLabel lblNewLabel = new JLabel("Game:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(450, 346, 53, 14);
		frame.getContentPane().add(lblNewLabel);
		//int count = 1;
		lblNewLabel_1 = new JLabel(Integer.toString(countGms) + "/" + Integer.toString(Gms));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(507, 344, 59, 19);
		frame.getContentPane().add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(392, 40, 208, 265);
		frame.getContentPane().add(scrollPane);
		scrollPane.setViewportView(table);
		//area.append("P1               P2\n");
		//area.append("0               0\n");
	}
}


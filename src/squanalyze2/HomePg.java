package squanalyze2;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.jdbc.JDBCCategoryDataset;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import net.proteanit.sql.DbUtils;
//import com.toedter.calendar.JDayChooser;
//import com.toedter.calendar.JCalendar;
import javax.swing.JComboBox;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.DefaultComboBoxModel;
//import com.toedter.components.JLocaleChooser;
import java.awt.Label;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.SystemColor;



public class HomePg extends JFrame{

	private JFrame frame;
	private JTable table;
	@SuppressWarnings("rawtypes")
	private JComboBox comboboxP1;
	@SuppressWarnings("rawtypes")
	private JComboBox comboboxP2;
	@SuppressWarnings("rawtypes")
	private JComboBox comboboxP11;
	@SuppressWarnings("rawtypes")
	private JComboBox comboboxP22;
	public static String P1N;
	public static String P2N;
	Label label_Gms;
	String P1Nm;
	String P2Nm;
	String p1d, p2d, mid;
	String valueW;
	String valueL;
	static int Curr_MatchID;
	public static int getMtchID() {
		return Curr_MatchID;
	}
	
	JLabel address;
	
	static int noGms;
	public static int getNoGms() {
		return noGms;
	}
	Calendar cal = new GregorianCalendar();
	
	Label label_dt;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePg window = new HomePg();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	static Connection connection = null;
	private JTextField tfName;
	private JTextField tfAge;
	private JTextField tfHeight;
	private JTextField tfWeight;
	
	double BMIupt;
	private JTextField textField;
	private JTextField tfRM;
	private JTextField tfRT;
	private JTextField textFieldGames;
	
	static String p1id;
	static String p2id;
	
	public static int getP1ID() {
		return Integer.parseInt(p1id);
	}
	
	public static int getP2ID() {
		return Integer.parseInt(p2id);
	}
	
	private static JTable table_1;
	private static JTable table_3;
	private static JTable table_4;
	int selectedRowIndex;
	private JTextField textField_2;
	private JTextField textField_1;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTable table_5;
	private JTable table_6;
	String nmm;
	JLabel pp11;
	JLabel pp22;
	private JTextField tfsrch;
	JRadioButton rdnm;
	JRadioButton rdage;
	JRadioButton rdrm;
	String P11d;
	
	private void ldData(String query) {
		try {
			PreparedStatement ps = connection.prepareStatement (query);
			ResultSet rs = ps.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			ps.close();
			rs.close();
		}catch(Exception e1) {
			e1.printStackTrace();
		}
	}
	
	
	
	public static void ldDataToLB(String query) {
		try {
			PreparedStatement ps = connection.prepareStatement (query);
			ResultSet rs = ps.executeQuery();
			table_1.setModel(DbUtils.resultSetToTableModel(rs));
			ps.close();
			rs.close();
		}catch(Exception e1) {
			e1.printStackTrace();
		}
	}
	
	
	public static void ldDataToPFA(String query) {
		try {
			PreparedStatement ps = connection.prepareStatement (query);
			ResultSet rs = ps.executeQuery();
			table_4.setModel(DbUtils.resultSetToTableModel(rs));
			ps.close();
			rs.close();
		}catch(Exception e1) {
			e1.printStackTrace();
		}
	}
	
	
	
	
	private void ldDataToSch(String query) {
		try {
			PreparedStatement ps = connection.prepareStatement (query);
			ResultSet rs = ps.executeQuery();
			ps.close();
			rs.close();
		}catch(Exception e1) {
			e1.printStackTrace();
		}
	}
	
	
	
	private void addDta(String query, String msg) {
		
			if(tfName.getText().trim().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Please re-check your inputs");
			}
		
		
		
		try {
			PreparedStatement st = connection.prepareStatement (query);
				st.setString(1, tfName.getText());
				st.setString(2, tfAge.getText());
				st.setString(3, tfHeight.getText());
				st.setString(4, tfWeight.getText());
				st.setString(5, Double.toString(BMIupt));
				st.setString(6, tfRM.getText());
				st.setString(7, tfRT.getText());
				st.execute();
				JOptionPane.showMessageDialog(null,msg);
				st.close();
			
		}catch(Exception e1) {
			JOptionPane.showMessageDialog(null, "Please re-check your inputs");
		}
	}


	private void addDtaToStats(String query, String msg) {
		try {
			PreparedStatement st = connection.prepareStatement (query);
				st.setString(1, tfName.getText());
				st.setString(2, tfAge.getText());
				st.setString(3, tfHeight.getText());
				st.setString(4, tfWeight.getText());
				st.setString(5, Double.toString(BMIupt));
				st.setString(6, tfRM.getText());
				st.setString(7, tfRT.getText());
				st.execute();
				JOptionPane.showMessageDialog(null,msg);
				st.close();
			
		}catch(Exception e1) {
			JOptionPane.showMessageDialog(null,"Please re-check");
		}
	}

	
	private void getID() {
		String nm1 = (String) comboboxP1.getSelectedItem();
		String nm2 = (String) comboboxP2.getSelectedItem();	
		try {
			PreparedStatement st = connection.prepareStatement ("select `Player ID` from players where Name = ?");
			st.setString(1, nm1);
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {
				p1id = rs.getString("Player ID");
			}
			st.close();
			st = connection.prepareStatement ("select `Player ID` from players where Name = ?");
			st.setString(1, nm2);;
			rs = st.executeQuery();
			
			if(rs.next()) {
				p2id = rs.getString("Player ID");
			}
			st.close();
		}catch(Exception e1) {
			e1.printStackTrace();
		}
	}
	
	
	
	
	private void makeLineChart(String query, String categ) throws SQLException {
		JDBCCategoryDataset dataset = new JDBCCategoryDataset(MySQLConnection.dbConnector(), query);
		JFreeChart chart = ChartFactory.createLineChart(categ + " vs Time " + "for " + nmm, "Time", "Total", dataset, PlotOrientation.VERTICAL, false, true, true);
		BarRenderer renderer=null;
		CategoryPlot plot = null;
		renderer = new BarRenderer();
		ChartFrame frame = new ChartFrame("Line Chart Analysis", chart);
		frame.setVisible(true);
		frame.setSize(450, 500);
	}
	
	
	
	
	private void addMtch(String msg) {
		getID();
		try {
			String x = label_dt.getText();
			String y = textFieldGames.getText();
			PreparedStatement st = connection.prepareStatement ("insert into matches (`Player1 ID`, `Player2 ID`,Date,`#Games`) values('"+p1id+"','"+p2id+"','"+x+"','"+y+"')");
			st.execute();
			
			ResultSet rs = st.getGeneratedKeys();
			while(rs.next()) {
				Curr_MatchID = rs.getInt(1);
			}
			
			JOptionPane.showMessageDialog(null,msg);
		}catch(Exception e1) {
			e1.printStackTrace();
		}
	}
	
	
	
	
	private void update(String query, String msg) {
		try {
			PreparedStatement st = connection.prepareStatement (query);
			st.setString(1, tfName.getText().toString());
			st.setString(2, tfAge.getText().toString());
			st.setString(3, tfHeight.getText().toString());
			st.setString(4, tfWeight.getText().toString());
			st.setString(5, Double.toString(BMIupt));
			st.setString(6, tfRM.getText().toString());
			st.setString(7, tfRT.getText().toString());
			st.execute();
			JOptionPane.showMessageDialog(null,msg);
			st.close();
			
			comboboxP1.removeAllItems();
			comboboxP2.removeAllItems();
			fillCombo();
		}catch(Exception e1) {
			e1.printStackTrace();
		}
	}
	
	
	
	
	private void delete(String query, String msg) {
		try {
			PreparedStatement st = connection.prepareStatement (query);
			st.execute();
			JOptionPane.showMessageDialog(null,msg);
			st.close();
			comboboxP1.removeAllItems();
			comboboxP2.removeAllItems();
			fillCombo();
		}catch(Exception e1) {
			e1.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public void fillCombo() {
		
		try {
			String query = "select * from players";
			PreparedStatement st = connection.prepareStatement (query);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				comboboxP1.addItem(rs.getString("Name"));
				comboboxP2.addItem(rs.getString("Name"));
			}

		}catch(Exception e1) {
			e1.printStackTrace();
		}
		
	}
	String temp;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JTable table_7;
	private JTable table_8;
	private JTable table_9;
	private final ButtonGroup buttonGroup_2 = new ButtonGroup();
	private JTextField tfSPID;
	private JTextField tfDate;
	private JTextField textField_3;
	
	
	public void addDataStats() {
		
		try {
			PreparedStatement st = connection.prepareStatement ("select `Player ID` from players where Name = ?");
			st.setString(1, tfName.getText());
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {
				temp = rs.getString("Player ID");
			}	
		}catch(Exception e1) {
			e1.printStackTrace();
		}
		
		PreparedStatement st;
		try {
			st = connection.prepareStatement ("insert into `player stats` (`ID`) values('"+Integer.parseInt(temp)+"')");
			st.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public void fillCombo2() {
		
		try {
			String query = "select * from players";
			PreparedStatement st = connection.prepareStatement (query);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				comboboxP11.addItem(rs.getString("Name"));
				comboboxP22.addItem(rs.getString("Name"));
			}

		}catch(Exception e1) {
			e1.printStackTrace();
		}
		
	}
	
	private void getPlyrName() {
		try {
			PreparedStatement ps = connection.prepareStatement ("select `Name` from `players` where `Player ID` = '"+Integer.parseInt(P11d)+"'");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				nmm = rs.getString("Name");
			}
			ps.close();
			rs.close();
		}catch(Exception e1) {
			e1.printStackTrace();
		}
	}
	
	
	public static void ldDataToMtchHist(String query) {
		try {
			PreparedStatement ps = connection.prepareStatement (query);
			ResultSet rs = ps.executeQuery();
			table_3.setModel(DbUtils.resultSetToTableModel(rs));
			ps.close();
			rs.close();
		}catch(Exception e1) {
			e1.printStackTrace();
		}
	}
	
	
	public HomePg() {
		connection = MySQLConnection.dbConnector();
		initialize();
		ldData("select `Player ID`,Name,Age,Height,Weight,BMI,`Racket Model`,`Racket Tension` from players");
		ldDataToLB("select Name,`Leader-board Pts` from players order by `Leader-Board Pts` desc");
		ldDataToSch("select `Date`,`P1ID`,`P2ID` from `planned matches`");
		ldDataToMtchHist("select `Match ID`,`Player1 ID`, `Player2 ID`, Date, Result, `#Games` from `matches`");
		ldDataToPFA("select `ID`,`Name`, `#Matches`, `#Won`, `#Lost` from `player stats` INNER JOIN `players` ON `player stats`.`ID`=`players`.`Player ID`");
	}
	
	

	
	@SuppressWarnings("rawtypes")
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 706, 596);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 690, 558);
		frame.getContentPane().add(tabbedPane);
		
		JPanel Home = new JPanel();
		tabbedPane.addTab("Home", null, Home, null);
		Home.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("SquAnalyze");
		lblNewLabel_4.setFont(new Font("Agency FB", Font.BOLD, 31));
		lblNewLabel_4.setBounds(120, 149, 189, 93);
		Home.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Leaderboard");
		lblNewLabel_5.setBounds(452, 66, 80, 14);
		Home.add(lblNewLabel_5);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(372, 104, 235, 367);
		Home.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("WELCOME");
		lblNewLabel_4_1.setFont(new Font("Agency FB", Font.BOLD, 50));
		lblNewLabel_4_1.setBounds(96, 197, 189, 93);
		Home.add(lblNewLabel_4_1);
		
		
		
		
		JPanel DBManager = new JPanel();
		tabbedPane.addTab("Manage Players", null, DBManager, null);
		DBManager.setLayout(null);
		
		table = new JTable();
		TableColorCellRenderer renderer = new TableColorCellRenderer();
		table.setDefaultRenderer(Object.class, renderer);
		
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model =(DefaultTableModel) table.getModel();
				int row = table.getSelectedRow();
				tfName.setText(model.getValueAt(row, 1).toString());
				tfAge.setText(model.getValueAt(row, 2).toString());
				tfHeight.setText(model.getValueAt(row, 3).toString());
				tfWeight.setText(model.getValueAt(row, 4).toString());
				tfRM.setText(model.getValueAt(row, 6).toString());
				tfRT.setText(model.getValueAt(row, 7).toString());	
			}
		});
		scrollPane.setBounds(29, 11, 632, 242);
		DBManager.add(scrollPane);
		
		tfName = new JTextField();
		tfName.setBounds(143, 281, 134, 20);
		DBManager.add(tfName);
		tfName.setColumns(10);
		
		tfAge = new JTextField();
		tfAge.setBounds(143, 312, 134, 20);
		DBManager.add(tfAge);
		tfAge.setColumns(10);
		
		tfHeight = new JTextField();
		tfHeight.setBounds(143, 343, 134, 20);
		DBManager.add(tfHeight);
		tfHeight.setColumns(10);
		
		tfWeight = new JTextField();
		tfWeight.setBounds(143, 374, 134, 20);
		DBManager.add(tfWeight);
		tfWeight.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Age");
		lblNewLabel_1.setBounds(44, 315, 46, 14);
		DBManager.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Height (cm)");
		lblNewLabel_2.setBounds(44, 346, 88, 14);
		DBManager.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Weight (kg)");
		lblNewLabel_3.setBounds(44, 377, 88, 14);
		DBManager.add(lblNewLabel_3);
		
		JButton btnAdd = new JButton("Add Data");
		btnAdd.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				if((tfName).getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please Re-Check Inputs");
					tfName.setText("");
					tfAge.setText("");
					tfHeight.setText("");
					tfWeight.setText("");
					tfRM.setText("");
					tfRT.setText("");
				}else {
				
				BMIupt = Double.parseDouble(tfWeight.getText())/(Math.pow(Double.parseDouble(tfHeight.getText())/100, 2));
				
				addDta("insert into players (Name, Age, Height, Weight, BMI,`Racket Model`,`Racket Tension`) values(?,?,?,?,?,?,?)", "Player Added");
				
				addDataStats();
				ldData("select `Player ID`,Name,Age,Height,Weight,BMI,`Racket Model`,`Racket Tension` from players");
				ldDataToLB("select Name,`Leader-board Pts` from players order by `Leader-Board Pts` desc");
				ldDataToSch("select `Date`,`P1ID`,`P2ID` from `planned matches`");
				ldDataToMtchHist("select `Match ID`,`Player1 ID`, `Player2 ID`, Date, Result, `#Games` from `matches`");
				ldDataToPFA("select `ID`,`Name`, `#Matches`, `#Won`, `#Lost` from `player stats` INNER JOIN `players` ON `player stats`.`ID`=`players`.`Player ID`");
				
				tfName.setText("");
				tfAge.setText("");
				tfHeight.setText("");
				tfWeight.setText("");
				tfRM.setText("");
				tfRT.setText("");
				
				comboboxP1.removeAllItems();
				comboboxP2.removeAllItems();
				fillCombo();
				
				}
			}
		});
		btnAdd.setBounds(60, 487, 89, 23);
		DBManager.add(btnAdd);
		
		JButton btnNewButton_1 = new JButton("Update");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				BMIupt = Double.parseDouble(tfWeight.getText())/(Math.pow(Double.parseDouble(tfHeight.getText())/100, 2));
				String value = table.getModel().getValueAt(table.getSelectedRow(),0).toString();
				update("update players set Name=?,Age=?, Height=?, Weight=?,BMI=?,`Racket Model`=?,`Racket Tension`=? where `PLAYER ID` ='"+value+"'", "Player Updated");
				ldData("select `Player ID`,Name,Age,Height,Weight,BMI,`Racket Model`,`Racket Tension` from players");
				ldDataToLB("select Name,`Leader-board Pts` from players order by `Leader-Board Pts` desc");
				ldDataToSch("select `Date`,`P1ID`,`P2ID` from `planned matches`");
				ldDataToMtchHist("select `Match ID`,`Player1 ID`, `Player2 ID`, Date, Result, `#Games` from `matches`");
				ldDataToPFA("select `ID`,`Name`, `#Matches`, `#Won`, `#Lost` from `player stats` INNER JOIN `players` ON `player stats`.`ID`=`players`.`Player ID`");
				
				tfName.setText("");
				tfAge.setText("");
				tfHeight.setText("");
				tfWeight.setText("");
				tfRM.setText("");
				tfRT.setText("");
				

				comboboxP1.removeAllItems();
				comboboxP2.removeAllItems();
				fillCombo();
				
				
			}
		});
		btnNewButton_1.setBounds(159, 487, 89, 23);
		DBManager.add(btnNewButton_1);
		
		JLabel lblNewLabel_10 = new JLabel("Racket Model");
		lblNewLabel_10.setBounds(44, 408, 89, 14);
		DBManager.add(lblNewLabel_10);
		
		tfRM = new JTextField();
		tfRM.setBounds(143, 405, 134, 20);
		DBManager.add(tfRM);
		tfRM.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("Racket Tension");
		lblNewLabel_11.setBounds(44, 439, 89, 14);
		DBManager.add(lblNewLabel_11);
		
		tfRT = new JTextField();
		tfRT.setBounds(143, 436, 134, 20);
		DBManager.add(tfRT);
		tfRT.setColumns(10);
		
		JButton btnNewButton_5 = new JButton("ID");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ldData("select `Player ID`,Name,Age,Height,Weight,BMI,`Racket Model`,`Racket Tension` from players order by `Player ID`");
			}
		});
		btnNewButton_5.setBounds(329, 331, 119, 23);
		DBManager.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Name");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ldData("select `Player ID`,Name,Age,Height,Weight,BMI,`Racket Model`,`Racket Tension` from players order by Name");
			}
		});
		btnNewButton_6.setBounds(329, 365, 119, 23);
		DBManager.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("Age");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ldData("select `Player ID`,Name,Age,Height,Weight,BMI,`Racket Model`,`Racket Tension` from players order by Age");
			}
		});
		btnNewButton_7.setBounds(329, 399, 119, 23);
		DBManager.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("BMI");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ldData("select `Player ID`,Name,Age,Height,Weight,BMI,`Racket Model`,`Racket Tension` from players order by BMI");
			}
		});
		btnNewButton_8.setBounds(329, 435, 119, 23);
		DBManager.add(btnNewButton_8);
		
		JLabel lblNewLabel_14 = new JLabel("Sort By");
		lblNewLabel_14.setBounds(367, 295, 56, 14);
		DBManager.add(lblNewLabel_14);
		
		tfsrch = new JTextField();
		tfsrch.setBounds(524, 436, 86, 20);
		DBManager.add(tfsrch);
		tfsrch.setColumns(10);
		
		JLabel lblNewLabel_15 = new JLabel("Search By");
		lblNewLabel_15.setBounds(536, 295, 74, 14);
		DBManager.add(lblNewLabel_15);
		
		JLabel lblNewLabel_17 = new JLabel("Name");
		lblNewLabel_17.setBounds(44, 284, 46, 14);
		DBManager.add(lblNewLabel_17);
		
		JButton btnNewButton_9 = new JButton("Refresh");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ldData("select `Player ID`,Name,Age,Height,Weight,BMI,`Racket Model`,`Racket Tension` from players");
				
			}
		});
		btnNewButton_9.setBounds(572, 487, 89, 23);
		DBManager.add(btnNewButton_9);
		
		JButton btnNewButton_10 = new JButton("Search");
		btnNewButton_10.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				
				if(rdnm.isSelected()) {
					
						
					ldData("select `Player ID`,Name,Age,Height,Weight,BMI,`Racket Model`,`Racket Tension` from players where Name='"+tfsrch.getText()+"'");
						

				
				}else if(rdage.isSelected()) {
					
					
					ldData("select `Player ID`,Name,Age,Height,Weight,BMI,`Racket Model`,`Racket Tension` from players where Age='"+Integer.parseInt(tfsrch.getText())+"'");
					
				}else if(rdrm.isSelected()) {
					ldData("select `Player ID`,Name,Age,Height,Weight,BMI,`Racket Model`,`Racket Tension` from players where `Racket Model`='"+tfsrch.getText()+"'");
				}
				
				tfsrch.setText("");
			}
		});
		
		
		
		btnNewButton_10.setBounds(473, 487, 89, 23);
		DBManager.add(btnNewButton_10);
		
		rdnm = new JRadioButton("Name");
		buttonGroup_1.add(rdnm);
		rdnm.setBounds(501, 332, 109, 23);
		DBManager.add(rdnm);
		
		rdage = new JRadioButton("Age");
		buttonGroup_1.add(rdage);
		rdage.setBounds(501, 365, 109, 23);
		DBManager.add(rdage);
		
		rdrm = new JRadioButton("Racket Model");
		buttonGroup_1.add(rdrm);
		rdrm.setBounds(501, 399, 109, 23);
		DBManager.add(rdrm);
		
		JPanel PerfAnalysis = new JPanel();
		PerfAnalysis.setBackground(SystemColor.menu);
		tabbedPane.addTab("Players' Performance", null, PerfAnalysis, null);
		PerfAnalysis.setLayout(null);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.addMouseListener(new MouseAdapter() {
		});
		scrollPane_4.setBounds(21, 30, 286, 465);
		PerfAnalysis.add(scrollPane_4);
		
		table_4 = new JTable();
		
		
		
		table_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				DefaultTableModel model =(DefaultTableModel) table_4.getModel();
				int row = table_4.getSelectedRow();
				P11d = model.getValueAt(row, 0).toString();
				valueW = table_4.getValueAt(row, 3).toString();
				valueL = table_4.getValueAt(row, 4).toString();			
			}
		});
		
		scrollPane_4.setViewportView(table_4);
		
		
		JButton btnNewButton_2 = new JButton("Pie Chart Analysis");
		btnNewButton_2.setBackground(SystemColor.activeCaption);
		btnNewButton_2.addActionListener(new ActionListener() {
			
			
			
			public void actionPerformed(ActionEvent e) {
				getPlyrName();
				DefaultPieDataset pieDataset = new DefaultPieDataset();
				pieDataset.setValue("Wins", Integer.parseInt(valueW));
				pieDataset.setValue("Losses", Integer.parseInt(valueL));
				JFreeChart chart = ChartFactory.createPieChart3D("Wins and Losses for " + nmm, pieDataset, true,true,true);
				PiePlot3D P = (PiePlot3D)chart.getPlot();
				ChartFrame frame = new ChartFrame("Pie Chart Analysis", chart);
				frame.setVisible(true);
				frame.setSize(650,450);	
			}
		});
		
		
		
		
		
		
		btnNewButton_2.setBounds(331, 33, 344, 156);
		PerfAnalysis.add(btnNewButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Speed");
		buttonGroup_2.add(rdbtnNewRadioButton_3);
		rdbtnNewRadioButton_3.setBounds(331, 196, 130, 23);
		PerfAnalysis.add(rdbtnNewRadioButton_3);
		
		JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("Agility");
		buttonGroup_2.add(rdbtnNewRadioButton_4);
		rdbtnNewRadioButton_4.setBounds(331, 222, 130, 23);
		PerfAnalysis.add(rdbtnNewRadioButton_4);
		
		JRadioButton rdbtnNewRadioButton_5 = new JRadioButton("Stamina");
		buttonGroup_2.add(rdbtnNewRadioButton_5);
		rdbtnNewRadioButton_5.setBounds(331, 248, 130, 23);
		PerfAnalysis.add(rdbtnNewRadioButton_5);
		
		JRadioButton rdbtnNewRadioButton_6 = new JRadioButton("Shot Selection");
		buttonGroup_2.add(rdbtnNewRadioButton_6);
		rdbtnNewRadioButton_6.setBounds(331, 274, 130, 23);
		PerfAnalysis.add(rdbtnNewRadioButton_6);
		
		JRadioButton rdbtnNewRadioButton_7 = new JRadioButton("Court Behaviour");
		buttonGroup_2.add(rdbtnNewRadioButton_7);
		rdbtnNewRadioButton_7.setBounds(331, 300, 130, 23);
		PerfAnalysis.add(rdbtnNewRadioButton_7);
		
		JRadioButton rdbtnNewRadioButton_8 = new JRadioButton("Total");
		buttonGroup_2.add(rdbtnNewRadioButton_8);
		rdbtnNewRadioButton_8.setBounds(331, 326, 130, 23);
		PerfAnalysis.add(rdbtnNewRadioButton_8);
		
		JButton btnNewButton_11 = new JButton("Line Chart Analysis");
		btnNewButton_11.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				getPlyrName();
				
				try {
					PreparedStatement ps = connection.prepareStatement ("select `Date`,`Total` from `coach_feedback` INNER JOIN matches ON `coach_feedback`.`Mtch ID`=matches.`Match ID` WHERE `Player ID`='"+P11d+"'");
					ResultSet rs = ps.executeQuery();
					table_9.setModel(DbUtils.resultSetToTableModel(rs));
					ps.close();
					rs.close();
				    String query, categ = "";
					if(rdbtnNewRadioButton_3.isSelected()) {
						query="select `Date`,`Speed` from `coach_feedback` INNER JOIN matches ON `coach_feedback`.`Mtch ID`=matches.`Match ID` WHERE `Player ID`='"+P11d+"'";
						categ = "Speed";
						makeLineChart(query,categ);
					}else if(rdbtnNewRadioButton_4.isSelected()) {
						query="select `Date`,`Agility` from `coach_feedback` INNER JOIN matches ON `coach_feedback`.`Mtch ID`=matches.`Match ID` WHERE `Player ID`='"+P11d+"'";
						categ = "Agility";
						makeLineChart(query,categ);
					}else if(rdbtnNewRadioButton_5.isSelected()) {
						query="select `Date`,`Stamina` from `coach_feedback` INNER JOIN matches ON `coach_feedback`.`Mtch ID`=matches.`Match ID` WHERE `Player ID`='"+P11d+"'";
						categ = "Stamina";
						makeLineChart(query,categ);
					}else if(rdbtnNewRadioButton_6.isSelected()) {
						query="select `Date`,`Shot Selection` from `coach_feedback` INNER JOIN matches ON `coach_feedback`.`Mtch ID`=matches.`Match ID` WHERE `Player ID`='"+P11d+"'";
						categ = "Shot Selection";
						makeLineChart(query,categ);
					}else if(rdbtnNewRadioButton_7.isSelected()) {
						query="select `Date`,`Court Behaviour` from `coach_feedback` INNER JOIN matches ON `coach_feedback`.`Mtch ID`=matches.`Match ID` WHERE `Player ID`='"+P11d+"'";
						categ = "Court Behaviour";
						makeLineChart(query,categ);
					}else if(rdbtnNewRadioButton_8.isSelected()){
						query="select `Date`,`Total` from `coach_feedback` INNER JOIN matches ON `coach_feedback`.`Mtch ID`=matches.`Match ID` WHERE `Player ID`='"+P11d+"'";
						categ = "Total";
						makeLineChart(query,categ);
					}else {
						JOptionPane.showMessageDialog(null, "Please choose a category for the graph");
					}					
				}catch(Exception e1) {
					e1.printStackTrace();
				}
				
				
			}
		});
		btnNewButton_11.setBackground(SystemColor.activeCaption);
		btnNewButton_11.setBounds(328, 356, 347, 139);
		PerfAnalysis.add(btnNewButton_11);
		
		JLabel lblNewLabel = new JLabel("Choose what coach rating");
		lblNewLabel.setBounds(478, 214, 157, 69);
		PerfAnalysis.add(lblNewLabel);
		
		JLabel lblNewLabel_6 = new JLabel("category is to be plotted against ");
		lblNewLabel_6.setBounds(478, 257, 197, 14);
		PerfAnalysis.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("time in the line chart");
		lblNewLabel_7.setBounds(478, 274, 143, 14);
		PerfAnalysis.add(lblNewLabel_7);
		
		JScrollPane scrollPane_10 = new JScrollPane();
		scrollPane_10.setBounds(32, 246, 253, 194);
		//PerfAnalysis.add(scrollPane_10);
		
		table_9 = new JTable();
		scrollPane_10.setViewportView(table_9);
		
		JPanel NMtch = new JPanel();
		tabbedPane.addTab("New Match", null, NMtch, null);
		NMtch.setLayout(null);
		
		
		JButton btnNewButton = new JButton("Let's Play");
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboboxP1.getSelectedItem().toString().equalsIgnoreCase(comboboxP2.getSelectedItem().toString())) {
					JOptionPane.showMessageDialog(null, "Error: Same Player Chosen");
				}else if(textFieldGames.getText().trim().isEmpty()){
					JOptionPane.showMessageDialog(null, "Please Specify Number of Games");
				}else if(Integer.parseInt(textFieldGames.getText()) %2 == 0) {
					JOptionPane.showMessageDialog(null, "Please enter an odd number of games");
				}else {
					noGms = Integer.parseInt(textFieldGames.getText());
					ScoreKeeper window = new ScoreKeeper();
					addMtch("Match Initiated");
					window.frame.setVisible(true);
					window.P1Lbl.setText(comboboxP1.getSelectedItem().toString());
					window.P2Lbl.setText(comboboxP2.getSelectedItem().toString());
					P1N = window.P1Lbl.getText();
					P2N = window.P2Lbl.getText();
				}	
			}
		});
		
		btnNewButton.setBounds(293, 355, 89, 23);
		NMtch.add(btnNewButton);
		
		comboboxP1 = new JComboBox();
		comboboxP1.setBackground(SystemColor.menu);
		comboboxP1.setBounds(335, 149, 147, 22);
		NMtch.add(comboboxP1);
		
		comboboxP2 = new JComboBox();
		comboboxP2.setBackground(SystemColor.menu);
		comboboxP2.setBounds(335, 188, 147, 22);
		NMtch.add(comboboxP2);
		
		fillCombo();
		
		textFieldGames = new JTextField();
		textFieldGames.setBounds(335, 233, 142, 20);
		NMtch.add(textFieldGames);
		textFieldGames.setColumns(10);
		
		Label label = new Label("Player 1");
		label.setForeground(Color.BLACK);
		label.setBackground(SystemColor.menu);
		label.setBounds(239, 149, 62, 22);
		NMtch.add(label);
		
		Label label_1 = new Label("Player 2");
		label_1.setForeground(Color.BLACK);
		label_1.setBackground(SystemColor.menu);
		label_1.setBounds(239, 188, 62, 22);
		NMtch.add(label_1);
		
		label_Gms = new Label("#Games");
		label_Gms.setForeground(Color.BLACK);
		label_Gms.setBackground(SystemColor.menu);
		label_Gms.setBounds(239, 231, 62, 22);
		NMtch.add(label_Gms);
		
		Label label_Date = new Label("Date");
		label_Date.setForeground(Color.BLACK);
		label_Date.setBackground(SystemColor.menu);
		label_Date.setBounds(256, 266, 62, 22);
		NMtch.add(label_Date);
		
		label_dt = new Label("date");
		label_dt.setBounds(335, 266, 142, 22);
		NMtch.add(label_dt);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int month = cal.get(Calendar.MONTH);
		int year = cal.get(Calendar.YEAR);
		label_dt.setText(+day+"/"+month+"/"+year);
		
		JLabel lblNewLabel_16 = new JLabel("NEW MATCH");
		lblNewLabel_16.setFont(new Font("Agency FB", Font.BOLD, 35));
		lblNewLabel_16.setBounds(277, 76, 241, 42);
		NMtch.add(lblNewLabel_16);
		
		textField_3 = new JTextField();
		textField_3.setBounds(335, 294, 86, 20);
		//NMtch.add(textField_3);
		textField_3.setColumns(10);
		
		JPanel MtchHist = new JPanel();
		tabbedPane.addTab("Match History", null, MtchHist, null);
		MtchHist.setLayout(null);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(27, 106, 381, 290);
		MtchHist.add(scrollPane_3);
		
		
		table_3 = new JTable();
		scrollPane_3.setViewportView(table_3);
		scrollPane_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model =(DefaultTableModel) table_3.getModel();
				int row = table_3.getSelectedRow();
				mid = model.getValueAt(row, 0).toString();
				p1d = model.getValueAt(row, 1).toString();
				p2d = model.getValueAt(row, 2).toString();
				
				
				try {
					PreparedStatement ps = connection.prepareStatement ("select `Speed`,`Stamina`, `Agility`, `Shot Selection`, `Court Behaviour` from `coach_feedback` where `Player ID`='"+Integer.parseInt(p1d)+"' AND `Mtch ID`='"+Integer.parseInt(mid)+"'");
					ResultSet rs = ps.executeQuery();
					table_5.setModel(DbUtils.resultSetToTableModel(rs));
					ps.close();
					rs.close();
				}catch(Exception e1) {
					e1.printStackTrace();
				}
				
				try {
					PreparedStatement ps = connection.prepareStatement ("select `Feedback` from `coach_feedback` where `Player ID`='"+Integer.parseInt(p1d)+"' AND `Mtch ID`='"+Integer.parseInt(mid)+"'");
					ResultSet rs = ps.executeQuery();
					table_7.setModel(DbUtils.resultSetToTableModel(rs));
					ps.close();
					rs.close();
				}catch(Exception e1) {
					e1.printStackTrace();
				}
			
				
				try {
					PreparedStatement ps = connection.prepareStatement ("select `Speed`,`Stamina`, `Agility`, `Shot Selection`, `Court Behaviour` from `coach_feedback` where `Player ID`='"+Integer.parseInt(p2d)+"' AND `Mtch ID`='"+Integer.parseInt(mid)+"'");
					ResultSet rs = ps.executeQuery();
					table_6.setModel(DbUtils.resultSetToTableModel(rs));
					ps.close();
					rs.close();
				}catch(Exception e1) {
					e1.printStackTrace();
				}
				
				try {
					PreparedStatement ps = connection.prepareStatement ("select `Feedback` from `coach_feedback` where `Player ID`='"+Integer.parseInt(p2d)+"' AND `Mtch ID`='"+Integer.parseInt(mid)+"'");
					ResultSet rs = ps.executeQuery();
					table_8.setModel(DbUtils.resultSetToTableModel(rs));
					ps.close();
					rs.close();
				}catch(Exception e1) {
					e1.printStackTrace();
				}
				
				try {
					PreparedStatement ps = connection.prepareStatement ("select `Name` from `players` where `Player ID`='"+Integer.parseInt(p1d)+"'");
					ResultSet rs = ps.executeQuery();
					while(rs.next()) {
						pp11.setText(p1d +" " +rs.getString("Name"));
					}
					ps.close();
					rs.close();
				}catch(Exception e1) {
					e1.printStackTrace();
				}
				
				try {
					PreparedStatement ps = connection.prepareStatement ("select `Name` from `players` where `Player ID`='"+Integer.parseInt(p2d)+"'");
					ResultSet rs = ps.executeQuery();
					while(rs.next()) {
						pp22.setText(p2d +" " +rs.getString("Name"));
					}
					ps.close();
					rs.close();
				}catch(Exception e1) {
					e1.printStackTrace();
				}
				
				address.setText("C:\\Users\\LENOVO\\Desktop\\tst\\"+mid+".xlsx");
				
			}
		});
		
		JScrollPane scrollPane_6 = new JScrollPane();
		scrollPane_6.setBounds(431, 132, 221, 61);
		MtchHist.add(scrollPane_6);
		
		table_5 = new JTable();
		scrollPane_6.setViewportView(table_5);
		
		JScrollPane scrollPane_7 = new JScrollPane();
		scrollPane_7.setBounds(433, 321, 219, 61);
		MtchHist.add(scrollPane_7);
		
		table_6 = new JTable();
		scrollPane_7.setViewportView(table_6);
		
		JScrollPane scrollPane_8 = new JScrollPane();
		scrollPane_8.setBounds(431, 204, 221, 61);
		MtchHist.add(scrollPane_8);
		
		table_7 = new JTable();
		scrollPane_8.setViewportView(table_7);
		
		JScrollPane scrollPane_9 = new JScrollPane();
		scrollPane_9.setBounds(431, 393, 221, 61);
		MtchHist.add(scrollPane_9);
		
		table_8 = new JTable();
		scrollPane_9.setViewportView(table_8);
		
		address = new JLabel("");
		address.setBounds(431, 482, 221, 14);
		MtchHist.add(address);
		
		pp22 = new JLabel("");
		pp22.setBounds(500, 296, 85, 14);
		MtchHist.add(pp22);
		
		pp11 = new JLabel("");
		pp11.setBounds(500, 107, 85, 14);
		MtchHist.add(pp11);
		
		JLabel lblNewLabel_18 = new JLabel("MATCH HISTORY");
		lblNewLabel_18.setFont(new Font("Agency FB", Font.BOLD, 35));
		lblNewLabel_18.setBounds(130, 32, 246, 45);
		MtchHist.add(lblNewLabel_18);
		
		tfSPID = new JTextField();
		tfSPID.setBounds(208, 407, 86, 20);
		MtchHist.add(tfSPID);
		tfSPID.setColumns(10);
		
		tfDate = new JTextField();
		tfDate.setBounds(208, 434, 86, 20);
		MtchHist.add(tfDate);
		tfDate.setColumns(10);
		
		JButton btnNewButton_12 = new JButton("Refresh");
		btnNewButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ldDataToMtchHist("select `Match ID`,`Player1 ID`, `Player2 ID`, Date, Result, `#Games` from `matches`");
			}
		});
		btnNewButton_12.setBounds(319, 459, 89, 23);
		MtchHist.add(btnNewButton_12);
		
		JButton btnNewButton_13 = new JButton("Search");
		btnNewButton_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ldDataToMtchHist("select `Match ID`,`Player1 ID`, `Player2 ID`, Date, Result, `#Games` from `matches` where `Player1 ID` = '"+tfSPID.getText()+"' OR  `Player2 ID` = '"+tfSPID.getText()+"'");
				tfSPID.setText("");
			}
		});
		btnNewButton_13.setBounds(319, 407, 89, 23);
		MtchHist.add(btnNewButton_13);
		
		JButton btnNewButton_14 = new JButton("Search");
		btnNewButton_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ldDataToMtchHist("select `Match ID`,`Player1 ID`, `Player2 ID`, Date, Result, `#Games` from `matches` where `Date` = '"+tfDate.getText()+"'");
				tfDate.setText("");
			}
		});
		btnNewButton_14.setBounds(319, 433, 89, 23);
		MtchHist.add(btnNewButton_14);
		
		JLabel lblNewLabel_19 = new JLabel("Search by ID");
		lblNewLabel_19.setBounds(60, 410, 117, 14);
		MtchHist.add(lblNewLabel_19);
		
		JLabel lblNewLabel_20 = new JLabel("Search by Date");
		lblNewLabel_20.setBounds(60, 437, 117, 14);
		MtchHist.add(lblNewLabel_20);
		
		
		JPanel Calendar = new JPanel();
		//tabbedPane.addTab("Calendar", null, Calendar, null);
		Calendar.setLayout(null);
		
//		JCalendar calendar = new JCalendar();
//		calendar.setBounds(27, 28, 387, 270);
//		Calendar.add(calendar);
//		
		comboboxP11 = new JComboBox();
		comboboxP11.setBounds(479, 118, 148, 22);
		Calendar.add(comboboxP11);
		
		comboboxP22 = new JComboBox();
		comboboxP22.setBounds(479, 186, 148, 22);
		Calendar.add(comboboxP22);
		
		
		fillCombo2();
		
		
		textField_2 = new JTextField();
		textField_2.setBounds(479, 257, 148, 20);
		Calendar.add(textField_2);
		textField_2.setColumns(10);
		
		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(37, 309, 375, 210);
		Calendar.add(scrollPane_5);
		
		JTextArea textArea = new JTextArea();
		scrollPane_5.setViewportView(textArea);
		
		JButton btnNewButton_3 = new JButton("Generate Calendar");
		btnNewButton_3.setBounds(479, 407, 148, 23);
		Calendar.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Add Match");
		btnNewButton_4.setBounds(479, 366, 148, 23);
		Calendar.add(btnNewButton_4);
		
		JLabel lblNewLabel_9 = new JLabel("Player 1");
		lblNewLabel_9.setBounds(531, 93, 46, 14);
		Calendar.add(lblNewLabel_9);
		
		JLabel lblNewLabel_12 = new JLabel("Player 2");
		lblNewLabel_12.setBounds(531, 161, 46, 14);
		Calendar.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("Time");
		lblNewLabel_13.setBounds(541, 232, 35, 14);
		Calendar.add(lblNewLabel_13);
		
		textField_1 = new JTextField();
		textField_1.setBounds(479, 50, 148, 20);
		Calendar.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Tournament");
		lblNewLabel_8.setBounds(519, 25, 89, 14);
		Calendar.add(lblNewLabel_8);
		
	}

}


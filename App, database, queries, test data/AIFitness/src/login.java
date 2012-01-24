import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLOutput;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

public class login extends JFrame {
	// Variables declaration
	private JLabel jLabel1;
	private JLabel jLabel2;
	private static JTextField jTextField1;
	private static JPasswordField jPasswordField1;
	private JButton jButton1;
	private static JPanel contentPane;

	// End of variables declaration

	public login() {
		super();
		create();
		this.setVisible(true);
	}

	private void create() {
		jLabel1 = new JLabel();
		jLabel2 = new JLabel();
		jTextField1 = new JTextField();
		jPasswordField1 = new JPasswordField();
		jButton1 = new JButton();
		contentPane = (JPanel) this.getContentPane();

		//
		// jLabel1
		//
		jLabel1.setHorizontalAlignment(SwingConstants.LEFT);
		jLabel1.setForeground(new Color(0, 0, 255));
		jLabel1.setText("Username:");
		//
		// jLabel2
		//
		jLabel2.setHorizontalAlignment(SwingConstants.LEFT);
		jLabel2.setForeground(new Color(0, 0, 255));
		jLabel2.setText("Password:");
		//
		// jTextField1
		//
		jTextField1.setForeground(new Color(0, 0, 255));
		jTextField1.setSelectedTextColor(new Color(0, 0, 255));
		jTextField1.setToolTipText("Enter your username here.");
		jTextField1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jTextField1_actionPerformed(e);
			}

		});
		//
		// jPasswordField1
		//
		jPasswordField1.setForeground(new Color(0, 0, 255));
		jPasswordField1.setToolTipText("Enter your password here.");
		jPasswordField1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jPasswordField1_actionPerformed(e);
			}

		});
		//
		// jButton1
		//
		
		jButton1.setBackground(new Color(204, 204, 204));
		jButton1.setForeground(new Color(0, 0, 255));
		jButton1.setText("Login");
		jButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButton1_actionPerformed(e);
			}

		});
		//
		// contentPane
		//
		contentPane.setLayout(null);
		contentPane.setBorder(BorderFactory.createEtchedBorder());
		contentPane.setBackground(new Color(204, 204, 204));
		addComponent(contentPane, jLabel1, 5, 10, 106, 18);
		addComponent(contentPane, jLabel2, 5, 47, 97, 18);
		addComponent(contentPane, jTextField1, 110, 10, 183, 22);
		addComponent(contentPane, jPasswordField1, 110, 45, 183, 22);
		addComponent(contentPane, jButton1, 150, 75, 83, 28);
		//
		// login
		//
		this.setTitle("Login To AI Fitness");
		this.setLocation(new Point(76, 182));
		this.setSize(new Dimension(400, 300));
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setResizable(false);
	}
	

	private void addComponent(Container container, Component c, int x, int y,
			int width, int height) {
		c.setBounds(x, y, width, height);
		container.add(c);
	}

	private void jTextField1_actionPerformed(ActionEvent e) {

	}

	private void jPasswordField1_actionPerformed(ActionEvent e) {

	}
	
public static boolean Database(){
			
		
		System.out.println("MySQL Connecting...");
		Connection conn = null;
		String url = "jdbc:mysql://dbmaster.helpmebot.org.uk/";
		String dbName = "LNCoders_fitness";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "LNCoders";
		String password = "LNCoder52011";

		try {
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url + dbName , userName , password);
			System.out.println("Connected to the database");

			java.sql.Statement s = conn.createStatement();
			s.executeQuery("SELECT * FROM member");
			ResultSet rs = s.getResultSet();
			int count = 0;
			String username2 = new String(jTextField1.getText());
			String password2= new String(jPasswordField1.getText());

			while(rs.next()){
				int memberId = rs.getInt("memberId");
				String Fname = rs.getString("Fname");
				String Sname = rs.getString("Sname");
				System.out.println("Hello Dear");
				//String id = Integer.toString(memberId);
				int password3 = Integer.parseInt(password2);
				if (password3 == memberId && username2.equals(Fname))
				{
					System.out.println("You now have access..." + " " + username2 + " " + password3);
					
					return true;// If password and
				}
				else{
					System.out.println("I LOST");
				}
			}
			/*while (rs.next()) {
				int SuppId = rs.getInt("SuppId");
				String SuppName = rs.getString("SuppName");
				String SuppType = rs.getString("SuppType");
				BigDecimal SuppPrice = rs.getBigDecimal("SuppPrice");
				int stock = rs.getInt("stock");
				
				System.out.println(SuppId + " " + SuppName + " " + SuppType + " "
						+ SuppPrice + " " + stock);
				++count;
			}*/

			//conn.close();
			//System.out.println("Disconnected");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Falied.");
		return false;
	}

	private void jButton1_actionPerformed(ActionEvent e) {
		//System.out.println("\njButton1_actionPerformed(ActionEvent e) called.");
		String username = new String(jTextField1.getText());
		String password = new String(jPasswordField1.getText());

		if (username.equals("") || password.equals("")) // If password and
														// username is empty >
														// Do this >>>
		{
			jButton1.setEnabled(false);
			JOptionPane.showMessageDialog(null, "You must enter a username and password");
			jTextField1.setText("");
			jPasswordField1.setText("");
			jButton1.setEnabled(true);
			this.setVisible(true);
		} else {
			
			Database();
			//JOptionPane.showMessageDialog(null, "Congrats you entered something! No database connection up yet though");
		}
	}

	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		JDialog.setDefaultLookAndFeelDecorated(true);
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception ex) {
			System.out.println("Failed loading Decorations: ");
			System.out.println(ex);
		}
		new login();
	};

}
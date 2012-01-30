import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.BorderFactory;
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
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.WindowConstants;

//the first main gui
public class FirstGUI extends JFrame implements ActionListener {
	// Set global variables
	private static JPanel contentPane;

	private JLabel Un;
	private JLabel Pw;
	private JTextField un;
	private JPasswordField pw;
	private JButton submit;

	public FirstGUI() {
		makeGUI();
		this.setVisible(true);
	}

	private void makeGUI() {
		// set labels and fields

		Un = new JLabel("Username: ");
		Pw = new JLabel("Password: ");
		un = new JTextField();
		pw = new JPasswordField();

		// buttons

		JButton submit = new JButton("Submit");
		JButton clear = new JButton("Clear");

		// panel
		JFrame jf = new JFrame();
		// jf.setSize(500, 450);
		// jf.setTitle("AIFitness");
		contentPane = (JPanel) this.getContentPane();
		contentPane.setLayout(null);
		contentPane.setBorder(BorderFactory.createEtchedBorder());
		contentPane.setBackground(Color.LIGHT_GRAY);
		// Container pane = jf.getContentPane();
		// pane.setLayout(new GridLayout(3,2));

		// setting text colour
		pw.setHorizontalAlignment(SwingConstants.LEFT);
		un.setHorizontalAlignment(SwingConstants.LEFT);

		un.setSelectedTextColor(new Color(0, 0, 255));
		pw.setSelectedTextColor(new Color(0, 0, 255));

		// setting helpful hover tips
		un.setToolTipText("Enter your username here.");
		pw.setToolTipText("Enter your password here.");

		// give button action events
		submit.addActionListener(this);
		/*
		 * submit.addActionListener(new ActionListener() { public void
		 * actionPerformed(ActionEvent e) { submit_actionPerformed(e); }
		 */

		// set content prefs.
		contentPane.setBackground(Color.LIGHT_GRAY);
		// Un.setSize(5, 5);
		// set the container, the object, the x and y pos and then the sizes
		addComponent(contentPane, Un, 5, 10, 106, 18);
		addComponent(contentPane, un, 110, 10, 183, 22);
		addComponent(contentPane, Pw, 5, 47, 97, 18);
		addComponent(contentPane, pw, 110, 45, 183, 22);
		addComponent(contentPane, submit, 150, 75, 83, 28);

		this.setTitle("Login To AI Fitness");
		this.setLocation(new Point(76, 182));
		this.setSize(new Dimension(500, 450));
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setResizable(false);

	}

	private void addComponent(Container container, Component c, int x, int y,
			int width, int height) {
		c.setBounds(x, y, width, height);
		container.add(c);
	}

	/*private void submit_actionPerformed(ActionEvent e) {
		String username = new String(un.getText());
		String password = new String(pw.getText());
		System.out.println(username + password);
		if (un.getText().isEmpty() || pw.getText().isEmpty()) {
			System.out.println("AHOY2!");
			submit.setEnabled(false);
			JOptionPane.showMessageDialog(null,
					"You must enter a username and password");
			un.setText("");
			pw.setText("");
			submit.setEnabled(true);
			this.setVisible(true);
		} else {

			Database();
		}

	}*/

	// Connects to db and verifies login
	public boolean Database() {

		// Just so you know it is working
		System.out.println("MySQL Connecting...");

		// database connection stuff
		Connection conn = null;
		String url = "jdbc:mysql://dbmaster.helpmebot.org.uk/";
		String dbName = "";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "";
		String password = "";

		// Runs connection
		try {
			Class.forName(driver).newInstance();
			conn = DriverManager
					.getConnection(url + dbName, userName, password);
			System.out.println("Connected to the database");

			// Runs quick query to make sure member is a member
			java.sql.Statement s = conn.createStatement();
			s.executeQuery("SELECT * FROM member");
			ResultSet rs = s.getResultSet();
			int count = 0;
			String username2 = new String(un.getText());
			String password2 = new String(pw.getText());

			while (rs.next()) {
				int memberId = rs.getInt("memberId");
				String Fname = rs.getString("Fname");
				String Sname = rs.getString("Sname");
				System.out.println("Hello Dear");
				// String id = Integer.toString(memberId);
				int password3 = Integer.parseInt(password2);
				if (password3 == memberId && username2.equals(Fname)) {
					JOptionPane.showMessageDialog(null,
							"You are a member. Transferring you...");

					return true;
				} else {
					JOptionPane.showMessageDialog(null,
							"Wrong Username or Password.", "Warning!",
							JOptionPane.WARNING_MESSAGE);
					return false;
					// System.out.println("Not a valid member.");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Connection Failed.");
		return false;
	}

	// Usual run methods and set the look of the app
	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		JDialog.setDefaultLookAndFeelDecorated(true);
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception e) {
			// If Nimbus is not available, you can set the GUI to another look
			// and feel.
		}

		new FirstGUI();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String username = new String(un.getText());
		String password = new String(pw.getText());
		System.out.println(username + password);
		if (username.length() == 0 || password.length() == 0) {
			System.out.println("AHOY2!");
			//submit.setEnabled(false);
			JOptionPane.showMessageDialog(null,"You must enter a username and password");
			un.setText("");
			pw.setText("");
			//submit.setEnabled(true);
			this.setVisible(true);
		} else if (username.length() != 0 && password.length() != 0){

			Database();
		}

	};
}

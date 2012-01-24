import java.beans.Statement;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class MysqlConnect {

	public void main(String[] args) {
		Database();
	}
		public static void Database(){
			
		
		System.out.println("MySQL Connection...");
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "fitness";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "root";
		String password = "UB0Ud02W";

		try {
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url + dbName, userName, password);
			System.out.println("Connected to the database");

			java.sql.Statement s = conn.createStatement();
			s.executeQuery("SELECT * FROM supplements");
			ResultSet rs = s.getResultSet();
			int count = 0;

			while (rs.next()) {
				int SuppId = rs.getInt("SuppId");
				String SuppName = rs.getString("SuppName");
				String SuppType = rs.getString("SuppType");
				BigDecimal SuppPrice = rs.getBigDecimal("SuppPrice");
				int stock = rs.getInt("stock");
				
				System.out.println(SuppId + " " + SuppName + " " + SuppType + " "
						+ SuppPrice + " " + stock);
				++count;
			}

			//conn.close();
			//System.out.println("Disconnected");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

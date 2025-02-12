package DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbcconnection {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		String query = "select * fromt table";

		Connection con = DriverManager.getConnection(null, null, null);
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery(query);
		rs.next(); // resultset will be present in 1st index. so we need to do next()
		rs.getString("colname");

	}
	
	public void testtt() {
		System.out.println("to test branch");
	}

}

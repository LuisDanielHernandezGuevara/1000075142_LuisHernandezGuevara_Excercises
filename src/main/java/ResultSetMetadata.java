import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.result.ResultSetMetaData;
import com.mysql.cj.xdevapi.Statement;

public class ResultSetMetadata  {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection myConn = null;
		Statement myStmnt = null;
		ResultSet rs = null;
		
		
		try {
			//Get a connection to a DB 
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students?75142","students","Password123");
			
			//Run query
			myStmnt = (Statement) myConn.createStatement();
			rs = ((java.sql.Statement) myStmnt).executeQuery("select NAME,LASTNAME from DATASHEETS ");
			
			ResultSetMetaData rsMetaData = (ResultSetMetaData) rs.getMetaData();
			
			int columnCount = rsMetaData.getColumnCount();
			System.out.print("Column count :" + columnCount + "\n");
			
			
		}catch() {
			
		}
		
		
	}

}

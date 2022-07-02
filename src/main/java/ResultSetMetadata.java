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
			
			for(int column = 1 ; column< columnCount; column++) {
				System.out.print("Column name:"+ rsMetaData.getColumnName(column));
				System.out.print("Column type name:" + rsMetaData.getColumnTypeName(column));
				System.out.println();
				System.out.print("Is Nullable:" + rsMetaData.isNullable(column));
				System.out.print("Is auto increment: " + rsMetaData.isAutoIncrement(column));
				
			}
			
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		
	}

}

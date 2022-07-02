import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.cj.jdbc.DatabaseMetaData;

public class Metadata {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String catalog = null;
		String SchemaPattern = null;
		String tableNamePattern =null;
		String columnName=null;
		String [] types = null;
		
		Connection  myConn = null;
		ResultSet myRs = null;
		
		
		try {
			
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students_75142","student","Password123");
			
			//get metadata
			DatabaseMetaData databaseMetaData = (DatabaseMetaData) myConn.getMetaData();
			
			//get list of tables
			System.out.print("List of tables");
			System.out.print("//////////////");
			
			myRs = databaseMetaData.getColumns(catalog, SchemaPattern, "DATASHEET", columnName);
			
			while (myRs.next()) {
				System.out.print(myRs.getString("COLUMN_NAME"));
				
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
		}
	}

}

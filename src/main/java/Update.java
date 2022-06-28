import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Update{
	public static void main(String[] args) throws SQLException {

		try {
		
		String dbUrl= "jdbc:mysql://localhost:3306/students_75412?useSSL=false";
		String user = "students";
		String pass = "Password123";
		
		Connection cn =null;
		Statement myStatement = null;
		ResultSet myRS=null;
		
		cn=DriverManager.getConnection(dbUrl, user,pass);
		myStatement =cn.createStatement();
		
		
		int rowsAffected = myStatement.executeUpdate(
				"update DATASHEET "+
				"SET EMAIL='myemail@mail.com' "+
				"where NAME='Daniel'"
				);
		
		myRS = myStatement.executeQuery("select * from DATASHEET");
		
		while(myRS.next()) {
			System.out.println(myRS.getString("NAME"));
			System.out.println(myRS.getString("LASTNAME"));
			System.out.println(myRS.getString("EMAIL"));
			
		}
		
		}catch(Exception ex) {
			System.out.print(ex);
		}
	}
	
}
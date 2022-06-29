import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedStatements {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		Connection myConn = null;
		PreparedStatement myStatement = null;
		ResultSet myResult = null;
		
		try {
		
		myConn =DriverManager.getConnection("jdbc:mysql://localhost:3306/students_75412", "student", "@Password123");
		myStatement = myConn.prepareStatement("select * from DATASHEETS where salary > ? and department=?");

		myStatement.setDouble(1, 800000);
		myStatement.setString(2, "Legal");		
		myResult = myStatement.executeQuery();
		
		}catch(Exception ex) {
			System.out.print(ex);
		}
	}

}

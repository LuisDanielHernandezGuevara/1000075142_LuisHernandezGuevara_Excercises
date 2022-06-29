import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Delete {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String urlDb = "jdbc:mysql://localhost:3306/students_75412?useSSL=false";
		String user = "students";
		String password = "@Password123";
		
		
		Connection cn = null;
		Statement myStatement =null;
		ResultSet myResult = null;
		
		try {
			cn =DriverManager.getConnection(urlDb, user , password);
			myStatement = cn.createStatement();
			
			int affectedrows= myStatement.executeUpdate(
					"delete from DATASHEET " +
							"where NAME= 'Daniel' "
					);
			
			myResult=myStatement.executeQuery("SELECT * FROM DATASHEET");
			
		while(myResult.next()) {
			System.out.println(myResult.getString("NAME"));
			System.out.println(myResult.getString("LASTNAME"));
			System.out.println(myResult.getString("EMAIL"));

		}
			
			
		}catch(Exception ex) {
			System.out.print(ex);
		}

	}

}

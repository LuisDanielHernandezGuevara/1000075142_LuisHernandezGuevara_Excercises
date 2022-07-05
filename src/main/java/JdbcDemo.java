import java.sql.*;

public class JdbcDemo {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		/*String dbUrl = "jdbc:mysql://localhost:3306/DATASHEET";
		*String user = "students";
		*String pass = "Password123";
		
		Connection myCon = DriverManager.getConnection(dbUrl,user,pass);
		/*
		 * 
		 */
		
		//CONNECTIONS WITH A DB SELECT QUERY
		
		String dbUrl = "jdbc:mysql://localhost:3306/students_75412?useSSL=false";
		String user = "students";
		String pass = "Password123";
		/*

		Connection myConn =null;
		Statement myStamn =null;
		ResultSet myRs=null;
		
		try {
			myConn = DriverManager.getConnection(dbUrl,user,pass);
			myStamn = myConn.createStatement();
			myRs = myStamn.executeQuery("select * from DATASHEET");
			
			while(myRs.next()) {
				System.out.println(myRs.getString("NAME"));
				System.out.println(myRs.getString("LASTNAME"));
				System.out.println(myRs.getString("EMAIL"));
				
			}
		}catch(Exception exc) {
			System.out.print("TRY AGAIN");
		}
		*/
		try {
			
		Connection myConn = DriverManager.getConnection(dbUrl , user, pass);
		Statement myStmnt = myConn.createStatement();
		ResultSet myRs =null;
		//INSERT VALUES 
		
		int rowsAffected = myStmnt.executeUpdate(
				"insert into DATASHEET"+
						"(NAME, LASTNAME, EMAIL, password,COMPANY , ADDRESS,CITY, ZIP_CODE,MOBILE_PHONE)"+
						"values"+
						"('Daniel' ,' Hrnandez' , 'lhernandez@mail.com','1324fs','Hexaware', 'Mexico Av.' ,' Mexico' , 59633, 984532)");
	
		myRs = myStmnt.executeQuery("select * from DATASHEET");

		
		while(myRs.next()) {
			System.out.println(myRs.getString("NAME"));
			System.out.println(myRs.getString("LASTNAME"));
			System.out.println(myRs.getString("EMAIL"));
			
		}
	}catch(Exception exc) {
		System.out.print("TRY AGAIN");
	}
				
	}
	

}

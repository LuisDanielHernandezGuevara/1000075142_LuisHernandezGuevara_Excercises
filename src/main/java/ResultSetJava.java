import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.cj.jdbc.CallableStatement;

public class ResultSetJava {
	public static void main(String[] args) throws Exception{
		Connection myCon = null;
		CallableStatement stmn =null;
		ResultSet myRS = null;
		
		try {
			//get connection
		myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306:students" , "students","Password123");

		String departament = "Enginering";
		
		
		//Prepare SP
		
		stmn = (CallableStatement) myCon.prepareCall("{call get_employees_for_departament(?)}");
		
		
		//SET PARAM
		stmn.setString(1, departament);
		
		
		//CALL SP
		System.out.print("calling SP. get_employees_for_departament('" + departament+"')");
		stmn.execute();
		
		System.out.print("FINISHED CALLING");
		
		myRS = stmn.getResultSet();
		}catch(Exception ex) {
			System.out.print(ex);
		}
		
		
		
		
		
	}
}

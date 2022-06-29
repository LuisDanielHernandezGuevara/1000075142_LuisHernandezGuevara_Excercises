import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.cj.jdbc.CallableStatement;

public class StoreProcedures {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Connection myCon =null;
		CallableStatement stm = null;
		ResultSet myRes= null;
		
		try {
			myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/students_75412","student","Password123");
			stm = (CallableStatement) myCon.prepareCall("{call getAll()}");
			//stm.setString(parameterIndex, x);
			//stm.SetString(paramString, x)
			
			//myCon.createStatement();
			//myRes = stm.executeQuery("SELECT * FROM DATASHEET");
			stm.execute();
			System.out.print("EXCECUTED");
			
		}catch(Exception ex){
			System.out.print(ex);
		};
	}

}

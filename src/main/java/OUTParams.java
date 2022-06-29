import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

import com.mysql.cj.jdbc.CallableStatement;

public class OUTParams {
	public static void main(String[] args) throws Exception{
		
		//Connection
		Connection con = null;
		CallableStatement statement = null;
		
		
		//Prepare SP
		con = DriverManager.getConnection("jdbc:mysql://3306:demo", "student", "Password123");
		String departament = "Engineering";
		
		
		
		//SET PARAM
		statement.setString(1, departament);
		statement.registerOutParameter(2, Types.INTEGER);
		
		
		//CALL SP
		
		System.out.println("Calling SP . get_count_for_departament('"+ departament +"', ?)");
		statement.execute();
		System.out.print("Finisdhed calling SP");
		
		
		//GET VALUE OF THE OUT PARAM
		int count = statement.getInt(2);
		
		
		System.out.print("\n The count ="+count);
	
	}
}

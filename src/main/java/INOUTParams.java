import java.sql.*;
import java.util.concurrent.Callable;

public class INOUTParams {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Connection myCon = null;
		Callable myStmn = null;
		
		try {
		myCon = DriverManager.getConnection("jdbc:mysql//localhost:3306/studnets_75142","student","Password123");
		
		String departament = "Engineering";
		
		myStmn = (Callable) myCon.prepareCall("{call greet_the_departament(?)}");
		
		((CallableStatement) myStmn).registerOutParameter(1,Types.VARCHAR);
		((CallableStatement) myStmn).setString(1,departament);
		
		
		System.out.print("Calling store procedures . greet_the_departament('"+ departament+"')");
		
		((PreparedStatement) myStmn).execute();
		
		System.out.print("Finished calling store procedure");
		
		String Result = ((CallableStatement) myStmn).getString(1);
		
		System.out.print("\n The result = "+ Result);
		}catch(Exception ex) {
			
			ex.printStackTrace();
		
		}
	}

}

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class SampleTest {
	
	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/test1";
		String user = "root";
		String password = "Welcome!23";
		Connection myConn = null;
		PreparedStatement myStatement  = null;

				
//		int id=101;
//		String name="Test1User";

		//reading user inputs
        Scanner s = new Scanner(System.in);
         System.out.print("Enter User id : ");
        String idString=s.next();
        int id=Integer.parseInt(idString);
        System.out.print("Enter user name : ");
        String name=s.next();
//		System.out.print("Enter user age: ");
//		String age =s.next();
//		System.out.print("Enter description: ");
//		String desc=s.next();
		try {
			
		
		//connection to database
		myConn = DriverManager.getConnection(url, user, password);  // user and password of Mysql server

		//creating sql statments
		String sql = "insert into users "+ " (userid,name)" + " values (? , ?)";
		myStatement = myConn.prepareStatement(sql);

		// setting values
		myStatement.setInt(1, id);
		myStatement.setString(2, name );

		//executing sql statments 
		myStatement.executeUpdate();
		System.out.println("Insert complete.");
		} catch (Exception e) {
			e.printStackTrace();
		}

		}

		
	

}

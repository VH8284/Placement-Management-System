package Registration.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Registration.model.Admin; 

public class AdminDao {
	public int registerAdmin(Admin admin) throws ClassNotFoundException{
		String INSERT_USERS_SQL ="Insert into admin" + 
						"(username, password) VALUES " +
						"(?,?);";
		int result = 0;
				
		Class.forName("com.mysql.jdbc.Driver");
				
		try (Connection connection = DriverManager
						.getConnection("jdbc:mysql://localhost:3306/studentdatabase","root","root");
					
		PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)){
			preparedStatement.setString(1, admin.getUserName());
			preparedStatement.setString(2, admin.getPassword());
				
			System.out.println(preparedStatement);
					
			result=preparedStatement.executeUpdate();
		} catch(SQLException e) {
				e.printStackTrace();
		}
		return result;
		
	}
}

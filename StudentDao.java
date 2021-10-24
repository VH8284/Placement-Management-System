package Registration.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Registration.model.Student; 

public class StudentDao {
	public int registerStudent(Student student) throws ClassNotFoundException{
		String INSERT_USERS_SQL ="Insert into student" + 
				"(id, first_name, last_name, username, password, address, contact) VALUES " +
				"(?,?,?,?,?,?,?);";
		int result = 0;
		
		Class.forName("com.mysql.jdbc.Driver");
		
		try (Connection connection = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/studentdatabase","root","root");
			
		PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)){
			preparedStatement.setInt(1, 1);
			preparedStatement.setString(2, student.getFirstName());
			preparedStatement.setString(3, student.getLastName());
			preparedStatement.setString(4, student.getUserName());
			preparedStatement.setString(5, student.getPassword());
			preparedStatement.setString(6, student.getAddress());
			preparedStatement.setString(7, student.getContact());
			
			System.out.println(preparedStatement);
			
			result=preparedStatement.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}

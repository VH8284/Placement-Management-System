package Registration.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Registration.model.Company; 

public class CompanyDao {
	public int registerCompany(Company company) throws ClassNotFoundException{
		String INSERT_USERS_SQL ="Insert into company" + 
					"(name, location, position, experience, skills, vacancies, contact) VALUES " +
					"(?,?,?,?,?,?,?);";
		int result = 0;
			
		Class.forName("com.mysql.jdbc.Driver");
			
		try (Connection connection = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/studentdatabase","root","root");
				
		PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)){
			preparedStatement.setString(1, company.getName());
			preparedStatement.setString(2, company.getLocation());
			preparedStatement.setString(3, company.getPosition());
			preparedStatement.setInt(4, company.getExperience());
			preparedStatement.setString(5, company.getSkills());
			preparedStatement.setInt(6, company.getVacancies());
			preparedStatement.setInt(7, company.getContact());
				
			System.out.println(preparedStatement);
				
			result=preparedStatement.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}

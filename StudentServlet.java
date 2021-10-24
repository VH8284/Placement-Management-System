package Registration.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Registration.dao.StudentDao;
import Registration.model.Student;

/**
 * Servlet implementation class StudentServlet
 */

public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
		private StudentDao studentDao = new StudentDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/studentregister.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @param password 
	 * @param userName 
	 * @param address 
	 * @param contact 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response, String password, String userName, String address, String contact) throws ServletException, IOException {
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String UserName = request.getParameter("userName");
		String Password = request.getParameter("password");
		String Address = request.getParameter("address");
		String Contact = request.getParameter("contact");
		
		Student student = new Student();
		student.setFirstName(firstName);
		student.setLastName(lastName);
		student.setUserName(userName);
		student.setPassword(password);
		student.setAddress(address);
		student.setContact(contact);
		
		try {
			studentDao.registerStudent(student);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/studentdetails.jsp");
		dispatcher.forward(request, response);
		
		
	}

}

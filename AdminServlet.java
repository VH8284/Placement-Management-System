package Registration.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Registration.dao.AdminDao;
import Registration.model.Admin;


/**
 * Servlet implementation class AdminServlet
 */

public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private AdminDao adminDao = new AdminDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/adminregister.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @param userName 
	 * @param password 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response, String userName, String password) throws ServletException, IOException {
		
		String UserName = request.getParameter("userName");
		String Password = request.getParameter("password");
		
		Admin admin = new Admin();
		admin.setUserName(userName);
		admin.setPassword(password);
		
		try {
			adminDao.registerAdmin(admin);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/admindetails.jsp");
		dispatcher.forward(request, response);
	}
}
		

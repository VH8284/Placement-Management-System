package Registration.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Registration.dao.CompanyDao;
import Registration.model.Company;

/**
 * Servlet implementation class CompanyServlet
 */

public class CompanyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private CompanyDao companyDao = new CompanyDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompanyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/companyregister.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @param experience 
	 * @param skills 
	 * @param vacancies 
	 * @param contact 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response, int experience, String skills, int vacancies, int contact) throws ServletException, IOException {
		String Name = request.getParameter("name");
		String Location = request.getParameter("location");
		String Position = request.getParameter("position");
		String Experience = request.getParameter("experience");
		String Skills = request.getParameter("skills");
		String Vacancies = request.getParameter("vacancies");
		String Contact= request.getParameter("contact");
		
		Company company = new Company();
		company.setName(Name);
		company.setLocation(Location);
		company.setPosition(Position);
		company.setExperience(experience);
		company.setSkills(skills);
		company.setVacancies(vacancies);
		company.setContact(contact);
		
		try {
			companyDao.registerCompany(company);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/companydetails.jsp");
		dispatcher.forward(request, response);
	}
}

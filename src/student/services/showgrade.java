package student.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student.Dao.StudentDaoImpl;
import student.entity.StudentGrade;

@WebServlet("/showgrade")
public class showgrade extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<StudentGrade> studentgrade = new ArrayList<StudentGrade>();
		
		StudentDaoImpl sdi = new StudentDaoImpl();
		
		try {
			studentgrade = sdi.getAllCourse();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		request.setAttribute("studentgrade", studentgrade);
		request.getRequestDispatcher("studentjsp/showgrade.jsp").forward(request, response);
	
	}
}

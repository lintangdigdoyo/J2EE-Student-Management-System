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

@WebServlet("/showallcourse")
public class showallcourse extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<StudentGrade> allcourse = new ArrayList<StudentGrade>();
		
		StudentDaoImpl sdi = new StudentDaoImpl();
		
		try {
			allcourse = sdi.getCourse();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("allcourse", allcourse);
		request.getRequestDispatcher("studentjsp/showallcourse.jsp").forward(request, response);
	
	}
}

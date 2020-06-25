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

@WebServlet("/editcourse")
public class editcourse extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
int studentid = Integer.parseInt(request.getParameter("sid"));
		
		StudentDaoImpl sdi = new StudentDaoImpl();
		StudentGrade getcourse = null;
		try {
			getcourse = sdi.getCourseById(studentid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("detailcourse", getcourse);
		request.getRequestDispatcher("studentjsp/editcourse.jsp").forward(request, response);
	}
}

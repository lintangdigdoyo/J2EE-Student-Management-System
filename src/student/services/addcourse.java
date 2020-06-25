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

@WebServlet("/addcourse")
public class addcourse extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int studentid = Integer.parseInt(request.getParameter("sid"));
		
		StudentDaoImpl sdi = new StudentDaoImpl();
		List<StudentGrade> studentgrade = new ArrayList<StudentGrade>();
		List<StudentGrade> showcourse = new ArrayList<StudentGrade>();
		try {
			studentgrade = sdi.getStudentById(studentid);
			showcourse = sdi.getCourse();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("detail", studentgrade);
		request.setAttribute("showcourse", showcourse);
		request.getRequestDispatcher("studentjsp/addcourse.jsp").forward(request, response);
	}
	
}


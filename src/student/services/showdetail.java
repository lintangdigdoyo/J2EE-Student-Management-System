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
import student.entity.Student;
import student.entity.StudentGrade;

@WebServlet("/showdetail")
public class showdetail extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int studentid = Integer.parseInt(request.getParameter("sid"));
		
		StudentDaoImpl sdi = new StudentDaoImpl();
		List<StudentGrade> studentgrade = new ArrayList<StudentGrade>();
		try {
			studentgrade = sdi.getStudentById(studentid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("detail", studentgrade);
		request.getRequestDispatcher("studentjsp/detailstudent.jsp").forward(request, response);
	}
}

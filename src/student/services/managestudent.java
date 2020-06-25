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


@WebServlet("/managestudent")
public class managestudent extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Student> studentlist = new ArrayList<Student>();
		
		StudentDaoImpl sdi = new StudentDaoImpl();
		
		try {
			studentlist = sdi.getAllStudent();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("studentlist", studentlist);
		request.getRequestDispatcher("studentjsp/managestudent.jsp").forward(request, response);
	
	}
}

package student.services;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student.Dao.StudentDaoImpl;


@WebServlet("/deletestudent")
public class deletestudent extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int sid = Integer.parseInt(request.getParameter("sid"));
		StudentDaoImpl sdi = new StudentDaoImpl();
		try {
			sdi.deleteStudent(sid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("managestudent");
		
	}

}

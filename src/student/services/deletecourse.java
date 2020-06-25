package student.services;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student.Dao.StudentDaoImpl;


@WebServlet("/deletecourse")
public class deletecourse extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int cid = Integer.parseInt(request.getParameter("cid"));
		StudentDaoImpl sdi = new StudentDaoImpl();
		
		try {
			sdi.deleteCourse(cid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("showallcourse");
	
	}


}

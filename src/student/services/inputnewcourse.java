package student.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import student.Dao.StudentDaoImpl;
import student.entity.StudentGrade;

@WebServlet("/inputnewcourse")
public class inputnewcourse extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		StudentGrade newcourse = new StudentGrade();
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		try {
			List<FileItem> items = upload.parseRequest(request);
			for (FileItem fi : items) {

				if ("course_name".equals(fi.getFieldName()))
					newcourse.setCourse_name(fi.getString());		
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		}

		StudentDaoImpl sdi = new StudentDaoImpl();
		try {
			sdi.addNewCourse(newcourse);
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("index.jsp");

	}
}

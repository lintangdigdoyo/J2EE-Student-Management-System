package student.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import student.entity.Student;

@WebServlet("/inputstudent")
public class inputstudent extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Student student = new Student();
		String picurl = null;
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		try {
			List<FileItem> items = upload.parseRequest(request);
			for (FileItem fi : items) {

				if (!fi.isFormField()) {
					
					String[] temp = fi.getName().split(Pattern.quote(File.separator));
					String filename = temp[temp.length-1];
					
					InputStream finput = fi.getInputStream();
					File pic = new File(this.getServletContext().getRealPath("/studentimage"), filename);
					OutputStream foutput = new FileOutputStream(pic);
					picurl = "studentimage/" + filename;
					int len = -1;
					byte b[] = new byte[1024 * 1024 * 10]; // max size of file
					while ((len = finput.read(b)) != -1) {
						foutput.write(b, 0, len);
					}
					foutput.close();
					finput.close();

				} else {

					if ("student_name".equals(fi.getFieldName()))
						student.setStudent_name(fi.getString());
					if ("student_number".equals(fi.getFieldName()))
						student.setStudent_number(fi.getString());
					if ("majors".equals(fi.getFieldName()))
						student.setMajors(fi.getString());
					if ("faculty".equals(fi.getFieldName()))
						student.setFaculty(fi.getString());
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		}

		student.setStudentpicurl(picurl);
		
		StudentDaoImpl sdi = new StudentDaoImpl();
		try {
			sdi.addStudent(student);;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("index.jsp");

	}

}

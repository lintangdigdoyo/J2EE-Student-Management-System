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

@WebServlet("/savestudentupdate")
public class savestudentupdate extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		StudentGrade studentupdate = new StudentGrade();
		String picurl = null;
		int i = 1;
		int n = 1;
		int cidLength = 0;
		String mygrade = "grade";
		String mycid = "cid";
		int[] arrayCid = new int[20];
		int[] arrayGrade = new int[20];
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		try {
			List<FileItem> items = upload.parseRequest(request);
			for (FileItem fi : items) {
				System.out.println(fi);
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
					if ("cidLength".equals(fi.getFieldName()))
						cidLength = Integer.parseInt(fi.getString());
					if ("student_name".equals(fi.getFieldName()))
						studentupdate.setStudent_name(fi.getString());
					if ("student_number".equals(fi.getFieldName()))
						studentupdate.setStudent_number(fi.getString());
					if ("majors".equals(fi.getFieldName()))
						studentupdate.setMajors(fi.getString());
					if ("faculty".equals(fi.getFieldName()))
						studentupdate.setFaculty(fi.getString());
					if ("sid".equals(fi.getFieldName()))
						studentupdate.setSid(Integer.parseInt(fi.getString()));
					
					//find and store the grade to the array
					mygrade = mygrade+n;
					if (mygrade.equals(fi.getFieldName())){
						arrayGrade[n] = Integer.parseInt(fi.getString());
						mygrade = "grade";
						n++;
					}
					mygrade = "grade";
					
					//find and store the course_id to the array
					mycid = mycid+i;
					if (mycid.equals(fi.getFieldName())){
							arrayCid[i] = Integer.parseInt(fi.getString());
							mycid = "cid";
							i++;
					}
					mycid = "cid";
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		
		studentupdate.setStudentpicurl(picurl);
		StudentDaoImpl sdi = new StudentDaoImpl();

		try {
			sdi.updateStudent(studentupdate, arrayCid, arrayGrade, cidLength);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("managestudent");
	}
}

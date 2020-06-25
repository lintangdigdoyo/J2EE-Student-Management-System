package student.Dao;

import java.sql.Connection;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import student.entity.Student;
import student.entity.StudentGrade;
import student.util.JDBCUtil;

public class StudentDaoImpl implements StudentDao {
	
	QueryRunner qr = new QueryRunner();
	
	@Override
	public List<Student> getAllStudent() throws Exception {
		
		List<Student> studentlist = null;
		Connection conn = JDBCUtil.getConnection();
		String sql = "SELECT *, ROUND(AVG(grade),2) AS 'average_grade' "
				+ "FROM studentgrade "
				+ "RIGHT JOIN studentinfo ON studentgrade.studentinfo_id=studentinfo.id "
				+ "GROUP BY studentinfo.id ORDER BY studentinfo.id";
		studentlist = qr.query(conn, sql, new BeanListHandler<Student>(Student.class));
		JDBCUtil.release(conn);
		return studentlist;
	}

	@Override
	public void addStudent(Student student) throws Exception {
		
		Connection conn = JDBCUtil.getConnection();
		String sql = "insert into studentinfo values(null,?,?,?,?,?)";
		
		qr.update(conn, sql, 
				student.getStudent_name(),
				student.getStudent_number(),
				student.getStudentpicurl(),
				student.getMajors(),
				student.getFaculty() 
		);
		
		JDBCUtil.release(conn);
	}

	@Override
	public List<StudentGrade> getStudentById(int studentid) throws Exception {
		
		List<StudentGrade> studentgrade = null;
		Connection conn = JDBCUtil.getConnection();
		
		String sql = "SELECT  *,studentinfo.id as sid FROM studentgrade "
				+ "RIGHT JOIN studentinfo ON studentgrade.studentinfo_id = studentinfo.id "
				+ "LEFT JOIN course ON studentgrade.course_id = course.id "
				+ "WHERE studentinfo.id=?";  
		
		studentgrade = qr.query(conn, sql, new BeanListHandler<StudentGrade>(StudentGrade.class), studentid);	
		return studentgrade;
	}

	@Override
	public List<StudentGrade> getAllCourse() throws Exception {
		
		List<StudentGrade> studentgrade = null;
		Connection conn = JDBCUtil.getConnection();
		
		String sql = "SELECT  *, studentinfo.id FROM studentgrade "
				+ "RIGHT JOIN studentinfo ON studentgrade.studentinfo_id = studentinfo.id  "
				+ "LEFT JOIN course ON studentgrade.course_id = course.id "
				+ "GROUP BY student_number "
				+ "ORDER BY studentinfo.id";
				
		studentgrade = qr.query(conn, sql, new BeanListHandler<StudentGrade>(StudentGrade.class));
		
		JDBCUtil.release(conn);
		return studentgrade;
		
	}

	@Override
	public List<StudentGrade> getCourse() throws Exception {
		
		List<StudentGrade> studentgrade = null;
		Connection conn = JDBCUtil.getConnection();
		
		String sql = "SELECT * FROM course";
				
		studentgrade = qr.query(conn, sql, new BeanListHandler<StudentGrade>(StudentGrade.class));
		
		JDBCUtil.release(conn);
		return studentgrade;
	}

	@Override
	public void addCourse(StudentGrade studentgrade) throws Exception {
		
		Connection conn = JDBCUtil.getConnection();
		String sql = "insert into studentgrade values(null,?,?,?)";
		
		qr.update(conn, sql, 
				studentgrade.getGrade(),
				studentgrade.getCourse_id(),
				studentgrade.getSid()
		);
		
		JDBCUtil.release(conn);
		
	}

	@Override
	public void addNewCourse(StudentGrade newcourse) throws Exception {
		
		Connection conn = JDBCUtil.getConnection();
		String sql = "INSERT INTO course VALUES(NULL,?)";
		qr.update(conn, sql, 
				newcourse.getCourse_name()
		);
		JDBCUtil.release(conn);
	}

	@Override
	public void deleteStudent(int id) throws Exception {

		Connection conn = JDBCUtil.getConnection();						

		String sql = "DELETE FROM studentgrade WHERE studentinfo_id = ?";
		qr.update(conn, sql, id);
		
		String sql2 = "DELETE FROM studentinfo WHERE id = ? ";
		qr.update(conn, sql2, id);
			
		JDBCUtil.release(conn);	
	}

	@Override
	public void updateStudent(StudentGrade studentgrade, int[] arrayCid, int[] arrayGrade, int cidLength) throws Exception {
		Connection conn = JDBCUtil.getConnection();
		String sql = "UPDATE studentinfo "
				+ "SET student_name = ?, "
				+ "student_number = ?, "
				+ "studentpicurl = ?, "
				+ "majors = ?, "
				+ "faculty= ?"
				+ "WHERE id = ?";
		qr.update(conn, sql, 
				studentgrade.getStudent_name(),
				studentgrade.getStudent_number(),
				studentgrade.getStudentpicurl(),
				studentgrade.getMajors(),
				studentgrade.getFaculty(),
				studentgrade.getSid()
		);
		
		for(int i = 1; i<=cidLength; i++){
			
			String sql2 = "UPDATE studentgrade "
					+ "SET grade = ? "
					+ "WHERE course_id = ? AND studentinfo_id = ?";
			qr.update(conn, sql2, 
					arrayGrade[i],
					arrayCid[i],
					studentgrade.getSid()
			);
		}
		JDBCUtil.release(conn);
	}

	@Override
	public void deleteCourse(int id) throws Exception {

		Connection conn = JDBCUtil.getConnection();						

		String sql = "DELETE FROM studentgrade WHERE course_id = ?";
		qr.update(conn, sql, id);
		
		String sql2 = "DELETE FROM course WHERE id = ? ";
		qr.update(conn, sql2, id);
			
		JDBCUtil.release(conn);	
		
	}

	@Override
	public StudentGrade getCourseById(int courseid) throws Exception {

		StudentGrade course = null;
		Connection conn = JDBCUtil.getConnection();
		
		String sql = "SELECT  * FROM course WHERE id=?";  
		
		course = qr.query(conn, sql, new BeanHandler<StudentGrade>(StudentGrade.class), courseid);
					
		return course;
	}

	@Override
	public void updateCourse(StudentGrade course) throws Exception {

		Connection conn = JDBCUtil.getConnection();
		String sql = "UPDATE course "
				+ "SET course_name = ?"
				+ "WHERE id = ? ";
		
		qr.update(conn, sql, 
				course.getCourse_name(),
				course.getCid()
		);
		
		JDBCUtil.release(conn);	
		
	}
}

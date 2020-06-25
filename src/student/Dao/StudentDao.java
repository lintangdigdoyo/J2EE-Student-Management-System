package student.Dao;

import java.util.List;

import student.entity.Student;
import student.entity.StudentGrade;

public interface StudentDao {
	
	List<Student> getAllStudent() throws Exception;
	
	void addStudent(Student student) throws Exception;	
	
	List<StudentGrade> getStudentById(int studentid) throws Exception;
	
	StudentGrade getCourseById(int courseid) throws Exception;
	
	List<StudentGrade> getAllCourse() throws Exception;
	
	List<StudentGrade> getCourse() throws Exception;
	
	void addCourse(StudentGrade studentgrade) throws Exception;
	
	void addNewCourse(StudentGrade newcourse) throws Exception;
	
	void deleteStudent(int id) throws Exception;
	
	void updateStudent(StudentGrade studentgrade, int[] arrayCid,int[] arrayGrade, int cidLength) throws Exception;		
	
	void deleteCourse(int id) throws Exception;
	
	void updateCourse(StudentGrade course) throws Exception;	
}

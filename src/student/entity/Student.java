package student.entity;

public class Student {
	
	private int id;
	private String student_name;
	private String student_number;
	private String studentpicurl;
	private String majors;
	private double average_grade;
	private String faculty;
	private int studentinfo_id;
	
	public Student(int id, String student_name, String student_number, String studentpicurl, String majors,
			double average_grade, String faculty, int studentinfo_id) {
		super();
		this.id = id;
		this.student_name = student_name;
		this.student_number = student_number;
		this.studentpicurl = studentpicurl;
		this.majors = majors;
		this.average_grade = average_grade;
		this.faculty = faculty;
		this.studentinfo_id = studentinfo_id;
	}
	
	public Student() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStudent_name() {
		return student_name;
	}

	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}

	public String getStudent_number() {
		return student_number;
	}

	public void setStudent_number(String student_number) {
		this.student_number = student_number;
	}

	public String getStudentpicurl() {
		return studentpicurl;
	}

	public void setStudentpicurl(String studentpicurl) {
		this.studentpicurl = studentpicurl;
	}

	public String getMajors() {
		return majors;
	}

	public void setMajors(String majors) {
		this.majors = majors;
	}

	public double getAverage_grade() {
		return average_grade;
	}

	public void setAverage_grade(double average_grade) {
		this.average_grade = average_grade;
	}

	public String getFaculty() {
		return faculty;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

	public int getStudentinfo_id() {
		return studentinfo_id;
	}

	public void setStudentinfo_id(int studentinfo_id) {
		this.studentinfo_id = studentinfo_id;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", student_name=" + student_name + ", student_number=" + student_number
				+ ", studentpicurl=" + studentpicurl + ", majors=" + majors + ", average_grade=" + average_grade
				+ ", faculty=" + faculty + ", studentinfo_id=" + studentinfo_id + "]";
	}

	

}

package student.entity;

public class StudentGrade {
	
	private int id;
	private int studentinfo_id;
	private String student_name;
	private String studentpicurl;
	private String student_number;
	private String majors;
	private String faculty;
	private String course_name;
	private int course_id;
	private int grade;
	private int sid;
	private int cid;

	public StudentGrade(int id, int studentinfo_id, String student_name, String studentpicurl, String student_number,
			String majors, String faculty, String course_name, int course_id, int grade, int sid, int cid) {
		super();
		this.id = id;
		this.studentinfo_id = studentinfo_id;
		this.student_name = student_name;
		this.studentpicurl = studentpicurl;
		this.student_number = student_number;
		this.majors = majors;
		this.faculty = faculty;
		this.course_name = course_name;
		this.course_id = course_id;
		this.grade = grade;
		this.sid = sid;
		this.cid = cid;
	}

	public StudentGrade() {
		super();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStudentinfo_id() {
		return studentinfo_id;
	}

	public void setStudentinfo_id(int studentinfo_id) {
		this.studentinfo_id = studentinfo_id;
	}

	public String getStudentpicurl() {
		return studentpicurl;
	}

	public void setStudentpicurl(String studentpicurl) {
		this.studentpicurl = studentpicurl;
	}

	public String getStudent_number() {
		return student_number;
	}

	public void setStudent_number(String student_number) {
		this.student_number = student_number;
	}

	public String getMajors() {
		return majors;
	}

	public void setMajors(String majors) {
		this.majors = majors;
	}

	public String getFaculty() {
		return faculty;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	public String getStudent_name() {
		return student_name;
	}

	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	
	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public int getCourse_id() {
		return course_id;
	}

	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}
	
	
	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	@Override
	public String toString() {
		return "StudentGrade [id=" + id + ", studentinfo_id=" + studentinfo_id + ", student_name=" + student_name
				+ ", studentpicurl=" + studentpicurl + ", student_number=" + student_number + ", majors=" + majors
				+ ", faculty=" + faculty + ", course_name=" + course_name + ", course_id=" + course_id + ", grade="
				+ grade + ", sid=" + sid + ", cid=" + cid + "]";
	}
}

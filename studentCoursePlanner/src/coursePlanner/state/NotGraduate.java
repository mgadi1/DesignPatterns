package coursePlanner.state;



public class NotGraduate implements CoursePlannerStateI {
	private StudentStatus currentStudent;

	public NotGraduate(StudentStatus currentStudent2) {
		this.currentStudent = currentStudent2;
	}

	@Override
	public CoursePlannerStateI courseAdd(String course) {
		if(course.matches("[A-P]")){
			return new PreReq(currentStudent).courseAdd(course);
		}
		else
			return new Electives(currentStudent).courseAdd(course);
	}

	@Override
	public CoursePlannerStateI graduationStatus() {
		// TODO Auto-generated method stub
		return currentStudent;
	}


	@Override
	public CoursePlannerStateI courseSelect(String course) {
		// TODO Auto-generated method stub
		return currentStudent;
	}
}

	
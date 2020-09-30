package coursePlanner.state;

public class Graduated implements CoursePlannerStateI {
	private StudentStatus currentStudent;
	// private final StudentStatus currentStatus;

	public Graduated(StudentStatus currentStudent) {
		this.currentStudent = currentStudent;

	}

	@Override
	public CoursePlannerStateI courseAdd(String course) {
		return currentStudent;
	}

	@Override
	public CoursePlannerStateI graduationStatus() {

		if (currentStudent.getGp1() >= 2 && currentStudent.getGp2() >= 2 && currentStudent.getGp3() >= 2
				&& currentStudent.getGp4() >= 2 && currentStudent.getGp5() >= 2) {
			currentStudent.setGraduated(1);
			return new NotGraduate(currentStudent);
		} else if (currentStudent.getCurrentSemCourses().size() == 3) {
			currentStudent.getCurrentSemCourses().removeAll(currentStudent.getCurrentSemCourses());

		}
		return new NotGraduate(currentStudent);
	}

	@Override
	public CoursePlannerStateI courseSelect(String course) {
		return null;
	}

}

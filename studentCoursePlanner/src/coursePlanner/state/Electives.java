package coursePlanner.state;



public class Electives implements CoursePlannerStateI {

	private StudentStatus currentStudent;

	public Electives(StudentStatus currentStudent2) {
		this.currentStudent = currentStudent2;
	}
	
	
	public void stateChangeCount(int x) {
		if (x == 1) {
			if (currentStudent.getGp1() < currentStudent.getGp2() || currentStudent.getGp1() < currentStudent.getGp3()
					|| currentStudent.getGp1() < currentStudent.getGp4()
					|| currentStudent.getGp1() < currentStudent.getGp5()) {
				currentStudent.stateChangeCounter++;
			}
		}
		else if(x==2) {
			if (currentStudent.getGp2() < currentStudent.getGp1() || currentStudent.getGp2() < currentStudent.getGp3()
					|| currentStudent.getGp2() < currentStudent.getGp4()
					|| currentStudent.getGp2() < currentStudent.getGp5()) {
				currentStudent.stateChangeCounter++;
			}
		}
		else if(x==3) {
			if (currentStudent.getGp3() < currentStudent.getGp2() || currentStudent.getGp3() < currentStudent.getGp1()
					|| currentStudent.getGp3() < currentStudent.getGp4()
					|| currentStudent.getGp3() < currentStudent.getGp5()) {
				currentStudent.stateChangeCounter++;
			}
		}
		else if(x==4) {
			if (currentStudent.getGp4() < currentStudent.getGp2() || currentStudent.getGp4() < currentStudent.getGp1()
					|| currentStudent.getGp4() < currentStudent.getGp3()
					|| currentStudent.getGp4() < currentStudent.getGp5()) {
				currentStudent.stateChangeCounter++;
			}
		}
		else if(x==5) {
			if (currentStudent.getGp5() < currentStudent.getGp2() || currentStudent.getGp5() < currentStudent.getGp1()
					|| currentStudent.getGp5() < currentStudent.getGp4()
					|| currentStudent.getGp5() < currentStudent.getGp3()) {
				currentStudent.stateChangeCounter++;
			}
		}
	}

	public void semCheck(String course) {
		if (currentStudent.getNumberCourses() >= 0 && currentStudent.getNumberCourses() < 3) {
			currentStudent.getSem1().add(course);
		}
		if (currentStudent.getNumberCourses() >= 3 && currentStudent.getNumberCourses() < 6) {
			currentStudent.getSem2().add(course);
		}
		if (currentStudent.getNumberCourses() >= 6 && currentStudent.getNumberCourses() < 9) {
			currentStudent.getSem3().add(course);
		}
		if (currentStudent.getNumberCourses() >= 9 && currentStudent.getNumberCourses() < 12) {
			currentStudent.getSem4().add(course);
		}
		if (currentStudent.getNumberCourses() >= 12 && currentStudent.getNumberCourses() < 15) {
			currentStudent.getSem5().add(course);
		}
		if (currentStudent.getNumberCourses() >= 15 && currentStudent.getNumberCourses() < 18) {
			currentStudent.getSem6().add(course);
		}
	}

	@Override
	public CoursePlannerStateI courseAdd(String course) {
		if (currentStudent.getGraduated() != 1 ) {
			currentStudent.getSelectedCourses().add(course);
			currentStudent.getCurrentSemCourses().add(course);
			semCheck(course);
			currentStudent.setNumberCourses(currentStudent.getNumberCourses() + 1);
			currentStudent.setGp5(currentStudent.getGp5() + 1);
			stateChangeCount(5);
			return new Graduated(currentStudent).graduationStatus();
		}
		else
			return new NotGraduate(currentStudent);
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

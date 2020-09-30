package coursePlanner.state;

import java.util.ArrayList;

import java.util.List;

public class StudentStatus implements CoursePlannerStateI {

	CoursePlannerStateI coursePlanner;
	CoursePlannerStateI currentState;
	public boolean flag = false;
	
	int stateChangeCounter = -5;

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public int getStateChangeCounter() {
		return stateChangeCounter;
	}

	public void setStateChangeCounter(int stateChangeCounter) {
		this.stateChangeCounter = stateChangeCounter;
	}

	public CoursePlannerStateI getCurrentState() {
		return currentState;
	}

	public void setCurrentState(CoursePlannerStateI currentState) {
		this.coursePlanner = currentState;
	}

	private String rollNumber;
	private List<String> preferences;

	public List<String> getPreferences() {
		return preferences;
	}

	public void setPreferences(List<String> newlist) {
		this.preferences = newlist;
	}
	
	public StudentStatus(){
		currentState = new NotGraduate(this);
	}

	private int gp1 = 0;
	private int gp2 = 0;
	private int gp3 = 0;
	private int gp4 = 0;
	private int gp5 = 0;

	private List<String> sem1 = new ArrayList<>();
	private List<String> sem2 = new ArrayList<>();
	private List<String> sem3 = new ArrayList<>();
	private List<String> sem4 = new ArrayList<>();
	private List<String> sem5 = new ArrayList<>();
	private List<String> sem6 = new ArrayList<>();
	

	private int numberCourses = 0;
	private int numberSemester = 0;

	private List<String> selectedCourses = new ArrayList<>();
	private List<String> waitList = new ArrayList<>();
	private List<String> currentSemCourses = new ArrayList<>();

	private int graduated = 0; // 0 means not graduated, 1 means graduate, -1 means cannot graduate.

	public CoursePlannerStateI courseSelect(String course) {
		currentState = currentState.courseAdd(course);
		return currentState;
	}

	public int getGp1() {
		return gp1;
	}

	public void setGp1(int gp1) {
		this.gp1 = gp1;
	}

	public int getGp2() {
		return gp2;
	}

	public void setGp2(int gp2) {
		this.gp2 = gp2;
	}

	public int getGp3() {
		return gp3;
	}

	public void setGp3(int gp3) {
		this.gp3 = gp3;
	}

	public int getGp4() {
		return gp4;
	}

	public void setGp4(int gp4) {
		this.gp4 = gp4;
	}

	public int getGp5() {
		return gp5;
	}

	public void setGp5(int gp5) {
		this.gp5 = gp5;
	}

	public int getNumberCourses() {
		return numberCourses;
	}

	public void setNumberCourses(int numberCourses) {
		this.numberCourses = numberCourses;
	}

	public int getNumberSemester() {
		return numberSemester;
	}

	public void setNumberSemester(int numberSemester) {
		this.numberSemester = numberSemester;
	}

	public List<String> getWaitList() {
		return waitList;
	}

	public void setWaitList(List<String> waitList) {
		this.waitList = waitList;
	}

	public List<String> getCurrentSemCourses() {
		return currentSemCourses;
	}

	public void setCurrentSemCourses(List<String> currentSemCourses) {
		this.currentSemCourses = currentSemCourses;
	}

	public List<String> getSem1() {
		return sem1;
	}

	public void setSem1(List<String> sem1) {
		this.sem1 = sem1;
	}

	public List<String> getSem2() {
		return sem2;
	}

	public void setSem2(List<String> sem2) {
		this.sem2 = sem2;
	}

	public List<String> getSem3() {
		return sem3;
	}

	public void setSem3(List<String> sem3) {
		this.sem3 = sem3;
	}

	public List<String> getSem4() {
		return sem4;
	}

	public void setSem4(List<String> sem4) {
		this.sem4 = sem4;
	}

	public List<String> getSem5() {
		return sem5;
	}

	public void setSem5(List<String> sem5) {
		this.sem5 = sem5;
	}

	public List<String> getSem6() {
		return sem6;
	}

	public void setSem6(List<String> sem6) {
		this.sem6 = sem6;
	}

	public int getGraduated() {
		return graduated;
	}

	public void setGraduated(int graduated) {
		this.graduated = graduated;
	}

	public String getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(String rollNumber) {
		this.rollNumber = rollNumber;
	}

	public List<String> getSelectedCourses() {
		return selectedCourses;
	}

	public void setSelectedCourses(List<String> selectedCourses) {
		this.selectedCourses = selectedCourses;
	}

	public StudentStatus getStudentStatus() {
		return getStudentStatus();
	}

	public CoursePlannerStateI getCoursePlanner() {
		return coursePlanner;
	}

	public void setCoursePlanner(CoursePlannerStateI coursePlanner) {
		this.coursePlanner = coursePlanner;
	}

	public CoursePlannerStateI graduationStatus(ArrayList<String> coursesIn) {
		// TODO Auto-generated method stub
		return null;
	}

	public void setStudentStatus(StudentStatus studentStatus) {
		coursePlanner = studentStatus;
	}

	// @Override
	public CoursePlannerStateI newSemCourseAdd(String course) {
		// TODO Auto-generated method stub
		return null;
	}

	// @Override
	public CoursePlannerStateI oldSemCourseAdd(String course) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CoursePlannerStateI courseAdd(String course) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CoursePlannerStateI graduationStatus() {
		// TODO Auto-generated method stub
		return null;
	}
}

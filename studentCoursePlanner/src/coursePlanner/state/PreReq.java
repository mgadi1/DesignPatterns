package coursePlanner.state;

import coursePlanner.state.StudentStatus;;

public class PreReq implements CoursePlannerStateI {
	private StudentStatus currentStudent;

	public PreReq(StudentStatus currentStudent2) {
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
			if (currentStudent.getNumberCourses() == 2) {
				currentStudent.flag = true;
			}
		}
		if (currentStudent.getNumberCourses() >= 3 && currentStudent.getNumberCourses() < 6) {
			currentStudent.getSem2().add(course);
			if (currentStudent.getNumberCourses() == 5) {
				currentStudent.flag = true;
			}
		}
		if (currentStudent.getNumberCourses() >= 6 && currentStudent.getNumberCourses() < 9) {
			currentStudent.getSem3().add(course);
			if (currentStudent.getNumberCourses() == 8) {
				currentStudent.flag = true;
			}
		}
		if (currentStudent.getNumberCourses() >= 9 && currentStudent.getNumberCourses() < 12) {
			currentStudent.getSem4().add(course);
			if (currentStudent.getNumberCourses() == 11) {
				currentStudent.flag = true;
			}
		}
		if (currentStudent.getNumberCourses() >= 12 && currentStudent.getNumberCourses() < 15) {
			currentStudent.getSem5().add(course);
			if (currentStudent.getNumberCourses() == 14) {
				currentStudent.flag = true;
			}
		}
		if (currentStudent.getNumberCourses() >= 15 && currentStudent.getNumberCourses() < 18) {
			currentStudent.getSem6().add(course);
			if (currentStudent.getNumberCourses() == 17) {
				currentStudent.flag = true;
			}
		}
	}

	@Override
	public CoursePlannerStateI courseAdd(String course) {

		if (course.matches("[A-D]")) {
			if (course.matches("D")) {

				if (currentStudent.getSelectedCourses().contains("A")
						&& currentStudent.getSelectedCourses().contains("B")
						&& currentStudent.getSelectedCourses().contains("C")) {

					if (currentStudent.getCurrentSemCourses().contains("A")
							|| currentStudent.getCurrentSemCourses().contains("B")
							|| currentStudent.getCurrentSemCourses().contains("C")) {
						currentStudent.getWaitList().add(course);
						return new NotGraduate(currentStudent);
					} else {
						currentStudent.getSelectedCourses().add(course);
						currentStudent.getCurrentSemCourses().add(course);
						semCheck(course);
						currentStudent.setNumberCourses(currentStudent.getNumberCourses() + 1);
						currentStudent.setGp1(currentStudent.getGp1() + 1);
						stateChangeCount(1);
						return new Graduated(currentStudent).graduationStatus();
					}

				} else {
					currentStudent.getWaitList().add(course);

					return new NotGraduate(currentStudent);
				}

			} else if (course.matches("C")) {
				if (currentStudent.getSelectedCourses().contains("A")
						&& currentStudent.getSelectedCourses().contains("B")) {

					if (currentStudent.getCurrentSemCourses().contains("A")
							|| currentStudent.getCurrentSemCourses().contains("B")) {
						currentStudent.getWaitList().add(course);
						return new NotGraduate(currentStudent);
					} else {
						currentStudent.getSelectedCourses().add(course);
						currentStudent.getCurrentSemCourses().add(course);
						semCheck(course);
						currentStudent.setNumberCourses(currentStudent.getNumberCourses() + 1);
						currentStudent.setGp1(currentStudent.getGp1() + 1);
						stateChangeCount(1);
						return new Graduated(currentStudent).graduationStatus();
					}

				} else {
					currentStudent.getWaitList().add(course);

					return new NotGraduate(currentStudent);
				}

			} else if (course.matches("B")) {
				if (currentStudent.getSelectedCourses().contains("A")) {
					if (currentStudent.getCurrentSemCourses().contains("A")) {
						currentStudent.getWaitList().add(course);
						//
						return new NotGraduate(currentStudent);
					} else {
						currentStudent.getSelectedCourses().add(course);
						currentStudent.getCurrentSemCourses().add(course);
						semCheck(course);
						currentStudent.setNumberCourses(currentStudent.getNumberCourses() + 1);
						currentStudent.setGp1(currentStudent.getGp1() + 1);
						stateChangeCount(1);
						return new Graduated(currentStudent).graduationStatus();
					}

				} else {
					currentStudent.getWaitList().add(course);

					return new NotGraduate(currentStudent);
				}

			} else if (course.matches("A")) {
				currentStudent.getSelectedCourses().add(course);
				currentStudent.getCurrentSemCourses().add(course);
				semCheck(course);
				currentStudent.setNumberCourses(currentStudent.getNumberCourses() + 1);
				currentStudent.setGp1(currentStudent.getGp1() + 1);
				stateChangeCount(1);
				return new Graduated(currentStudent).graduationStatus();
			}
		}
		if (course.matches("[E-H]")) {
			if (course.matches("H")) {
				if (currentStudent.getSelectedCourses().contains("E")
						&& currentStudent.getSelectedCourses().contains("F")
						&& currentStudent.getSelectedCourses().contains("G")) {

					if (currentStudent.getCurrentSemCourses().contains("E")
							|| currentStudent.getCurrentSemCourses().contains("F")
							|| currentStudent.getCurrentSemCourses().contains("G")) {
						currentStudent.getWaitList().add(course);
						return new NotGraduate(currentStudent);
					} else {
						currentStudent.getSelectedCourses().add(course);
						currentStudent.getCurrentSemCourses().add(course);
						semCheck(course);
						currentStudent.setNumberCourses(currentStudent.getNumberCourses() + 1);
						currentStudent.setGp2(currentStudent.getGp2() + 1);
						stateChangeCount(2);
						return new Graduated(currentStudent).graduationStatus();
					}

				} else {
					currentStudent.getWaitList().add(course);
					//
					return new NotGraduate(currentStudent);
				}

			} else if (course.matches("G")) {
				if (currentStudent.getSelectedCourses().contains("E")
						&& currentStudent.getSelectedCourses().contains("F")) {

					if (currentStudent.getCurrentSemCourses().contains("E")
							|| currentStudent.getCurrentSemCourses().contains("F")) {
						currentStudent.getWaitList().add(course);
						return new NotGraduate(currentStudent);
					} else {
						currentStudent.getSelectedCourses().add(course);
						currentStudent.getCurrentSemCourses().add(course);
						semCheck(course);
						currentStudent.setNumberCourses(currentStudent.getNumberCourses() + 1);
						currentStudent.setGp2(currentStudent.getGp2() + 1);
						stateChangeCount(2);
						return new Graduated(currentStudent).graduationStatus();
					}

				} else {
					currentStudent.getWaitList().add(course);

					return new NotGraduate(currentStudent);
				}

			} else if (course.matches("F")) {
				if (currentStudent.getSelectedCourses().contains("E")) {
					if (currentStudent.getCurrentSemCourses().contains("E")) {
						currentStudent.getWaitList().add(course);

						return new NotGraduate(currentStudent);
					} else {
						currentStudent.getSelectedCourses().add(course);
						currentStudent.getCurrentSemCourses().add(course);
						semCheck(course);
						currentStudent.setNumberCourses(currentStudent.getNumberCourses() + 1);
						currentStudent.setGp2(currentStudent.getGp2() + 1);
						stateChangeCount(2);
						return new Graduated(currentStudent).graduationStatus();
					}

				} else {
					currentStudent.getWaitList().add(course);

					return new NotGraduate(currentStudent);
				}

			} else if (course.matches("E")) {
				currentStudent.getSelectedCourses().add(course);
				currentStudent.getCurrentSemCourses().add(course);
				semCheck(course);
				currentStudent.setNumberCourses(currentStudent.getNumberCourses() + 1);
				currentStudent.setGp2(currentStudent.getGp2() + 1);
				stateChangeCount(2);
				return new Graduated(currentStudent).graduationStatus();
			}
		}
		if (course.matches("[I-L]")) {
			if (course.matches("L")) {
				if (currentStudent.getSelectedCourses().contains("I")
						&& currentStudent.getSelectedCourses().contains("J")
						&& currentStudent.getSelectedCourses().contains("K")) {

					if (currentStudent.getCurrentSemCourses().contains("I")
							|| currentStudent.getCurrentSemCourses().contains("J")
							|| currentStudent.getCurrentSemCourses().contains("K")) {
						currentStudent.getWaitList().add(course);
						return new NotGraduate(currentStudent);
					} else {
						currentStudent.getSelectedCourses().add(course);
						currentStudent.getCurrentSemCourses().add(course);
						semCheck(course);
						currentStudent.setNumberCourses(currentStudent.getNumberCourses() + 1);
						currentStudent.setGp3(currentStudent.getGp3() + 1);
						stateChangeCount(3);
						return new Graduated(currentStudent).graduationStatus();
					}

				} else {
					currentStudent.getWaitList().add(course);

					return new NotGraduate(currentStudent);
				}

			} else if (course.matches("K")) {
				if (currentStudent.getSelectedCourses().contains("I")
						&& currentStudent.getSelectedCourses().contains("J")) {

					if (currentStudent.getCurrentSemCourses().contains("I")
							|| currentStudent.getCurrentSemCourses().contains("J")) {
						currentStudent.getWaitList().add(course);
						return new NotGraduate(currentStudent);
					} else {
						currentStudent.getSelectedCourses().add(course);
						currentStudent.getCurrentSemCourses().add(course);
						semCheck(course);
						currentStudent.setNumberCourses(currentStudent.getNumberCourses() + 1);
						currentStudent.setGp3(currentStudent.getGp3() + 1);
						stateChangeCount(3);
						return new Graduated(currentStudent).graduationStatus();
					}

				} else {
					currentStudent.getWaitList().add(course);

					return new NotGraduate(currentStudent);
				}

			} else if (course.matches("J")) {
				if (currentStudent.getSelectedCourses().contains("I")) {
					if (currentStudent.getCurrentSemCourses().contains("I")) {
						currentStudent.getWaitList().add(course);

						return new NotGraduate(currentStudent);
					} else {
						currentStudent.getSelectedCourses().add(course);
						currentStudent.getCurrentSemCourses().add(course);
						semCheck(course);
						currentStudent.setNumberCourses(currentStudent.getNumberCourses() + 1);
						currentStudent.setGp3(currentStudent.getGp3() + 1);
						stateChangeCount(3);
						return new Graduated(currentStudent).graduationStatus();
					}

				} else {
					currentStudent.getWaitList().add(course);

					return new NotGraduate(currentStudent);
				}

			} else if (course.matches("I")) {
				currentStudent.getSelectedCourses().add(course);
				currentStudent.getCurrentSemCourses().add(course);
				semCheck(course);
				currentStudent.setNumberCourses(currentStudent.getNumberCourses() + 1);
				currentStudent.setGp3(currentStudent.getGp3() + 1);
				stateChangeCount(3);
				return new Graduated(currentStudent).graduationStatus();
			}
		}
		if (course.matches("[M-P]")) {
			if (course.matches("P")) {
				if (currentStudent.getSelectedCourses().contains("M")
						&& currentStudent.getSelectedCourses().contains("N")
						&& currentStudent.getSelectedCourses().contains("O")) {

					if (currentStudent.getCurrentSemCourses().contains("M")
							|| currentStudent.getCurrentSemCourses().contains("N")
							|| currentStudent.getCurrentSemCourses().contains("O")) {
						currentStudent.getWaitList().add(course);
						return new NotGraduate(currentStudent);
					} else {
						currentStudent.getSelectedCourses().add(course);
						currentStudent.getCurrentSemCourses().add(course);
						semCheck(course);
						currentStudent.setNumberCourses(currentStudent.getNumberCourses() + 1);
						currentStudent.setGp4(currentStudent.getGp4() + 1);
						stateChangeCount(4);
						return new Graduated(currentStudent).graduationStatus();
					}

				} else {
					currentStudent.getWaitList().add(course);

					return new NotGraduate(currentStudent);
				}

			} else if (course.matches("O")) {
				if (currentStudent.getSelectedCourses().contains("M")
						&& currentStudent.getSelectedCourses().contains("N")) {

					if (currentStudent.getCurrentSemCourses().contains("M")
							|| currentStudent.getCurrentSemCourses().contains("N")) {
						currentStudent.getWaitList().add(course);
						return new NotGraduate(currentStudent);
					} else {
						currentStudent.getSelectedCourses().add(course);
						currentStudent.getCurrentSemCourses().add(course);
						semCheck(course);
						currentStudent.setNumberCourses(currentStudent.getNumberCourses() + 1);
						currentStudent.setGp4(currentStudent.getGp4() + 1);
						stateChangeCount(4);
						return new Graduated(currentStudent).graduationStatus();
					}

				} else {
					currentStudent.getWaitList().add(course);

					return new NotGraduate(currentStudent);
				}

			} else if (course.matches("N")) {
				if (currentStudent.getSelectedCourses().contains("M")) {
					if (currentStudent.getCurrentSemCourses().contains("M")) {
						currentStudent.getWaitList().add(course);

						return new NotGraduate(currentStudent);
					} else {
						currentStudent.getSelectedCourses().add(course);
						currentStudent.getCurrentSemCourses().add(course);
						semCheck(course);
						currentStudent.setNumberCourses(currentStudent.getNumberCourses() + 1);
						currentStudent.setGp4(currentStudent.getGp4() + 1);
						stateChangeCount(4);
						return new Graduated(currentStudent).graduationStatus();
					}

				} else {
					currentStudent.getWaitList().add(course);

					return new NotGraduate(currentStudent);
				}

			} else if (course.matches("M")) {
				currentStudent.getSelectedCourses().add(course);
				currentStudent.getCurrentSemCourses().add(course);
				semCheck(course);
				currentStudent.setNumberCourses(currentStudent.getNumberCourses() + 1);
				currentStudent.setGp4(currentStudent.getGp4() + 1);
				stateChangeCount(4);
				return new Graduated(currentStudent).graduationStatus();
			}
		}
		return null;
	}

	@Override
	public CoursePlannerStateI graduationStatus() {
		return currentStudent;
	}

	@Override
	public CoursePlannerStateI courseSelect(String course) {
		return currentStudent;
	}

}

package coursesRegistration.util;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Results implements FileDisplayInterface, StdoutDisplayInterface {

	public void runAlgorithm(List<List<Student>> students, List<Course> courseList) {
		
		// for course 1 THIRD YEAR
		List<Student> studentList3 = students.get(0);
		List<Student> studentList2 = students.get(1);
		List<Student> studentList1 = students.get(2);
		for (int j = 0; j < studentList3.size(); j++) {
			studentloop: for (int k = 0; k < courseList.size(); k++) {
				for (int i = 0; i < courseList.size(); i++) {
					if (studentList3.get(j).getPreferences()[k].equals(courseList.get(i).getCourseName())) {
						if (courseList.get(i).getTotalCapacity() != 0) {
							studentList3.get(j).setCourse1(courseList.get(i).getCourseName());
							courseList.get(i).setTotalCapacity(courseList.get(i).getTotalCapacity() - 1);
							studentList3.get(j).getPreferences()[k] = "NA";
							studentList3.get(j)
									.setSatisfactionRating(studentList3.get(j).getSatisfactionRating() + 9 - k);
							studentList3.get(j).setCourse1Timing(courseList.get(i).getTimings());
							break studentloop;
						} else {
							continue;
						}
					} else {
						continue;
					}
				}
			}
		}
		
		// for course 2 THIRD YEAR
		for (int j = 0; j < studentList3.size(); j++) {
			studentloop: for (int k = 0; k < courseList.size(); k++) {
				for (int i = 0; i < courseList.size(); i++) {
					if (courseList.get(i).getTimings().equals(studentList3.get(j).getCourse1Timing())) {
						continue;
					} else {
						if (studentList3.get(j).getPreferences()[k].equals(courseList.get(i).getCourseName())) {
							if (courseList.get(i).getTotalCapacity() != 0) {
								studentList3.get(j).setCourse2(courseList.get(i).getCourseName());
								courseList.get(i).setTotalCapacity(courseList.get(i).getTotalCapacity() - 1);
								studentList3.get(j).getPreferences()[k] = "NA";
								studentList3.get(j)
										.setSatisfactionRating(studentList3.get(j).getSatisfactionRating() + 9 - k);
								studentList3.get(j).setCourse2Timing(courseList.get(i).getTimings());
								break studentloop;
							} else {
								continue;
							}
						} else {
							continue;
						}
					}
				}
			}
		}

		// for course 3 THIRD YEAR
		for (int j = 0; j < studentList3.size(); j++) {
			studentloop: for (int k = 0; k < courseList.size(); k++) {
				for (int i = 0; i < courseList.size(); i++) {
					if (courseList.get(i).getTimings().equals(studentList3.get(j).getCourse1Timing())
							|| courseList.get(i).getTimings().equals(studentList3.get(j).getCourse2Timing())) {
						continue;
					} else {
						if (studentList3.get(j).getPreferences()[k].equals(courseList.get(i).getCourseName())) {
							if (courseList.get(i).getTotalCapacity() != 0) {
								studentList3.get(j).setCourse3(courseList.get(i).getCourseName());
								courseList.get(i).setTotalCapacity(courseList.get(i).getTotalCapacity() - 1);
								studentList3.get(j).getPreferences()[k] = "NA";
								studentList3.get(j)
										.setSatisfactionRating(studentList3.get(j).getSatisfactionRating() + 9 - k);
								studentList3.get(j).setCourse3Timing(courseList.get(i).getTimings());
								break studentloop;
							} else {
								continue;
							}
						} else {
							continue;
						}
					}
				}
			}
		}
		
		// for course 1 SECOND YEAR
		for (int j = 0; j < studentList2.size(); j++) {
			studentloop: for (int k = 0; k < courseList.size(); k++) {
				for (int i = 0; i < courseList.size(); i++) {
					if (studentList2.get(j).getPreferences()[k].equals(courseList.get(i).getCourseName())) {
						if (courseList.get(i).getTotalCapacity() != 0) {
							studentList2.get(j).setCourse1(courseList.get(i).getCourseName());
							courseList.get(i).setTotalCapacity(courseList.get(i).getTotalCapacity() - 1);
							studentList2.get(j).getPreferences()[k] = "NA";
							studentList2.get(j)
									.setSatisfactionRating(studentList2.get(j).getSatisfactionRating() + 9 - k);
							studentList2.get(j).setCourse1Timing(courseList.get(i).getTimings());
							break studentloop;
						} else {
							continue;
						}
					} else {
						continue;
					}
				}
			}
		}
		
		// for course 2 SECOND YEAR
		for (int j = 0; j < studentList2.size(); j++) {
			studentloop: for (int k = 0; k < courseList.size(); k++) {
				for (int i = 0; i < courseList.size(); i++) {
					if (courseList.get(i).getTimings().equals(studentList2.get(j).getCourse1Timing())) {
						continue;
					} else {
						if (studentList2.get(j).getPreferences()[k].equals(courseList.get(i).getCourseName())) {
							if (courseList.get(i).getTotalCapacity() != 0) {
								studentList2.get(j).setCourse2(courseList.get(i).getCourseName());
								courseList.get(i).setTotalCapacity(courseList.get(i).getTotalCapacity() - 1);
								studentList2.get(j).getPreferences()[k] = "NA";
								studentList2.get(j)
										.setSatisfactionRating(studentList2.get(j).getSatisfactionRating() + 9 - k);
								studentList2.get(j).setCourse2Timing(courseList.get(i).getTimings());
								break studentloop;
							} else {
								continue;
							}
						} else {
							continue;
						}
					}
				}
			}
		}

		// for course 3 SECOND YEAR
		for (int j = 0; j < studentList2.size(); j++) {
			studentloop: for (int k = 0; k < courseList.size(); k++) {
				for (int i = 0; i < courseList.size(); i++) {
					if (courseList.get(i).getTimings().equals(studentList2.get(j).getCourse1Timing())
							|| courseList.get(i).getTimings().equals(studentList2.get(j).getCourse2Timing())) {
						continue;
					} else {
						if (studentList2.get(j).getPreferences()[k].equals(courseList.get(i).getCourseName())) {
							if (courseList.get(i).getTotalCapacity() != 0) {
								studentList2.get(j).setCourse3(courseList.get(i).getCourseName());
								courseList.get(i).setTotalCapacity(courseList.get(i).getTotalCapacity() - 1);
								studentList2.get(j).getPreferences()[k] = "NA";
								studentList2.get(j)
										.setSatisfactionRating(studentList2.get(j).getSatisfactionRating() + 9 - k);
								studentList2.get(j).setCourse3Timing(courseList.get(i).getTimings());
								break studentloop;
							} else {
								continue;
							}
						} else {
							continue;
						}
					}
				}
			}
		}
		
		// for course 1 FIRST YEAR
		for (int j = 0; j < studentList1.size(); j++) {
			studentloop: for (int k = 0; k < courseList.size(); k++) {
				for (int i = 0; i < courseList.size(); i++) {
					if (studentList1.get(j).getPreferences()[k].equals(courseList.get(i).getCourseName())) {
						if (courseList.get(i).getTotalCapacity() != 0) {
							studentList1.get(j).setCourse1(courseList.get(i).getCourseName());
							courseList.get(i).setTotalCapacity(courseList.get(i).getTotalCapacity() - 1);
							studentList1.get(j).getPreferences()[k] = "NA";
							studentList1.get(j)
									.setSatisfactionRating(studentList1.get(j).getSatisfactionRating() + 9 - k);
							studentList1.get(j).setCourse1Timing(courseList.get(i).getTimings());
							break studentloop;
						} else {
							continue;
						}
					} else {
						continue;
					}
				}
			}
		}
		
		// for course 2 FIRST YEAR
		for (int j = 0; j < studentList1.size(); j++) {
			studentloop: for (int k = 0; k < courseList.size(); k++) {
				for (int i = 0; i < courseList.size(); i++) {
					if (courseList.get(i).getTimings().equals(studentList1.get(j).getCourse1Timing())) {
						continue;
					} else {
						if (studentList1.get(j).getPreferences()[k].equals(courseList.get(i).getCourseName())) {
							if (courseList.get(i).getTotalCapacity() != 0) {
								studentList1.get(j).setCourse2(courseList.get(i).getCourseName());
								courseList.get(i).setTotalCapacity(courseList.get(i).getTotalCapacity() - 1);
								studentList1.get(j).getPreferences()[k] = "NA";
								studentList1.get(j)
										.setSatisfactionRating(studentList1.get(j).getSatisfactionRating() + 9 - k);
								studentList1.get(j).setCourse2Timing(courseList.get(i).getTimings());
								break studentloop;
							} else {
								continue;
							}
						} else {
							continue;
						}
					}
				}
			}
		}

		// for course 3 FIRST YEAR
		for (int j = 0; j < studentList1.size(); j++) {
			studentloop: for (int k = 0; k < courseList.size(); k++) {
				for (int i = 0; i < courseList.size(); i++) {
					if (courseList.get(i).getTimings().equals(studentList1.get(j).getCourse1Timing())
							|| courseList.get(i).getTimings().equals(studentList1.get(j).getCourse2Timing())) {
						continue;
					} else {
						if (studentList1.get(j).getPreferences()[k].equals(courseList.get(i).getCourseName())) {
							if (courseList.get(i).getTotalCapacity() != 0) {
								studentList1.get(j).setCourse3(courseList.get(i).getCourseName());
								courseList.get(i).setTotalCapacity(courseList.get(i).getTotalCapacity() - 1);
								studentList1.get(j).getPreferences()[k] = "NA";
								studentList1.get(j)
										.setSatisfactionRating(studentList1.get(j).getSatisfactionRating() + 9 - k);
								studentList1.get(j).setCourse3Timing(courseList.get(i).getTimings());
								break studentloop;
							} else {
								continue;
							}
						} else {
							continue;
						}
					}
				}
			}
		}
	}

	public void writeOutput(List<List<Student>> students, String fileName)
			throws IOException {
		List<Student> studentList3 = students.get(0);
		List<Student> studentList2 = students.get(1);
		List<Student> studentList1 = students.get(2);
		ArrayList<Student> outputList = new ArrayList<>();
		outputList.addAll(studentList1);
		outputList.addAll(studentList2);
		outputList.addAll(studentList3);
		Results printFile = new Results();
		double totalSatisfactionRating = 0;
		FileWriter outputFile = new FileWriter(fileName);
		for (Student studentFinal : outputList) {
			totalSatisfactionRating = totalSatisfactionRating + studentFinal.getSatisfactionRating();
			outputFile.write(studentFinal.getRollNumber() + ":" + studentFinal.getCourse1() + ","
					+ studentFinal.getCourse2() + "," + studentFinal.getCourse3() + "::SatisfationRating="
					+ studentFinal.getSatisfactionRating() + System.lineSeparator());
		}
		double AverageSatisfactionRating = totalSatisfactionRating / outputList.size();
		outputFile.write("AverageSatisfactionRating=" + AverageSatisfactionRating);
		outputFile.close();
	}
	
	public void printOutput(List<List<Student>> students) {
		List<Student> studentList3 = students.get(0);
		List<Student> studentList2 = students.get(1);
		List<Student> studentList1 = students.get(2);
		ArrayList<Student> outputList = new ArrayList<>();
		outputList.addAll(studentList1);
		outputList.addAll(studentList2);
		outputList.addAll(studentList3);
		Results printFile = new Results();
		double totalSatisfactionRating = 0;
		for (Student studentFinal : outputList) {
			totalSatisfactionRating = totalSatisfactionRating + studentFinal.getSatisfactionRating();
			System.out.println(studentFinal.getRollNumber() + ":" + studentFinal.getCourse1() + ","
					+ studentFinal.getCourse2() + "," + studentFinal.getCourse3() + "::SatisfationRating="
					+ studentFinal.getSatisfactionRating());
		}
		double AverageSatisfactionRating = totalSatisfactionRating / outputList.size();
		System.out.println("AverageSatisfactionRating=" + AverageSatisfactionRating);
	}
}

package coursePlanner.util;

import java.io.FileWriter;
import java.io.IOException;

import coursePlanner.state.StudentStatus;

public class Results implements FileDisplayInterface, StdoutDisplayInterface {

	@Override
	public void writeOutput(StudentStatus student, String fileName) throws IOException {
		if (student.getNumberCourses() > 3 && student.getNumberCourses() <= 6) {
			student.setNumberSemester(2);
		} else if (student.getNumberCourses() > 6 && student.getNumberCourses() <= 9) {
			student.setNumberSemester(3);
		} else if (student.getNumberCourses() > 9 && student.getNumberCourses() <= 12) {
			student.setNumberSemester(4);
		} else if (student.getNumberCourses() > 12 && student.getNumberCourses() <= 15) {
			student.setNumberSemester(5);
		} else if (student.getNumberCourses() > 15 && student.getNumberCourses() <= 18) {
			student.setNumberSemester(6);
		} else if (student.getNumberCourses() > 18 && student.getNumberCourses() <= 21) {
			student.setNumberSemester(7);
		}
		FileWriter outputFile = new FileWriter(fileName);

		if (student.getGraduated() == -1) {
			outputFile.write(student.getRollNumber() + " : Cannot Graduate");
		} else if (student.getGraduated() == 1) {
			outputFile.write(student.getRollNumber() + " : ");
			student.getSelectedCourses().forEach(c -> {
				try {
					outputFile.write(c + " ");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
			outputFile.write(" " + student.getNumberSemester() + " " + student.getStateChangeCounter());
		}

		else if (student.getGraduated() == 0) {
			outputFile.write("Did not graduate");
		}
		outputFile.close();
	}

	@Override
	public void printoutput(StudentStatus student) {
		// TODO Auto-generated method stub
		if (student.getNumberCourses() > 3 && student.getNumberCourses() <= 6) {
			student.setNumberSemester(2);
		} else if (student.getNumberCourses() > 6 && student.getNumberCourses() <= 9) {
			student.setNumberSemester(3);
		} else if (student.getNumberCourses() > 9 && student.getNumberCourses() <= 12) {
			student.setNumberSemester(4);
		} else if (student.getNumberCourses() > 12 && student.getNumberCourses() <= 15) {
			student.setNumberSemester(5);
		} else if (student.getNumberCourses() > 15 && student.getNumberCourses() <= 18) {
			student.setNumberSemester(6);
		} else if (student.getNumberCourses() > 18 && student.getNumberCourses() <= 21) {
			student.setNumberSemester(7);
		}
		System.out.println();
		if (student.getGraduated() == -1) {
			System.out.print(student.getRollNumber() + " : Cannot Graduate");
		} else if (student.getGraduated() == 1) {
			System.out.print(student.getRollNumber() + " : ");
			student.getSelectedCourses().forEach(c -> {
				System.out.print(c + " ");
			});
			System.out.println(" " + student.getNumberSemester() + " " + student.getStateChangeCounter());
		}

		else if (student.getGraduated() == 0) {
			System.out.println("Did not graduate");
		}
	}
}

package coursePlanner.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

import coursePlanner.state.StudentStatus;

public class FileProcessor {
	public StudentStatus readStudent(String inputFile1) {
		File inputFile = new File(inputFile1);
		Scanner newScanner;
		StudentStatus student = new StudentStatus();
		try {
			newScanner = new Scanner(inputFile);
			String everyline = newScanner.nextLine();
			String[] fullLine = everyline.split(": ");
			String rollNumber = fullLine[0];
			String[] preferences;
			preferences = fullLine[1].split(" ");
			student.setRollNumber(rollNumber);
			List<String> newlist = new ArrayList<>();
			for(String s : preferences)
				newlist.add(s);
			student.setPreferences(newlist);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return student;
	}
}

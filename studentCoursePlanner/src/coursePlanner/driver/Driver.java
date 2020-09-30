package coursePlanner.driver;

import java.io.IOException;
//import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import coursePlanner.state.StudentStatus;
import coursePlanner.util.FileDisplayInterface;
import coursePlanner.util.FileProcessor;
import coursePlanner.util.Results;
import coursePlanner.util.StdoutDisplayInterface;
import coursePlanner.state.NotGraduate;

public class Driver {

	public static void main(String[] args) throws IOException {

		if (args.length != 5 || args[0].equals("${arg0}") || args[1].equals("${arg1}")) {
			System.err.println("Error: Incorrect number of arguments. Program accepts 4 arguments.");
			System.exit(0);
		}
		FileProcessor fileProcessor = new FileProcessor();
		StudentStatus student = null;
		try {
			student = fileProcessor.readStudent(args[0]);
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<String> newlist = student.getPreferences();
		String rollNumber = student.getRollNumber();
		System.out.println("Input: " + rollNumber + " " + newlist);
		if (newlist.contains("A") && newlist.contains("B") && newlist.contains("E") && newlist.contains("F")
				&& newlist.contains("I") && newlist.contains("J") && newlist.contains("M") && newlist.contains("N")) {
			while (!student.getPreferences().isEmpty()) {
				Iterator<String> it = student.getPreferences().iterator();
				while (it.hasNext()) {
					student.setCurrentState(new NotGraduate(student));
					student.courseSelect(it.next());
					if (student.flag) {
						while (it.hasNext()) {
							student.getWaitList().add(it.next());
						}

						student.flag = false;
					}
				}
				if (student.getGraduated() == 1) {
					break;
				}
				student.getPreferences().clear();
				student.getPreferences().addAll(student.getWaitList());
				student.getWaitList().clear();

			}
		} else {
			student.setGraduated(-1);
			System.out.println(rollNumber + " : Cannot Graduate, Required courses not found");
		}

		Results finalResult = new Results();
		Results newfinalresult = new Results();
		StdoutDisplayInterface printop = finalResult;
		printop.printoutput(student);
		FileDisplayInterface writeop = newfinalresult;
		writeop.writeOutput(student, args[1]);
	}
}

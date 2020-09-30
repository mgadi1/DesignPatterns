package coursesRegistration.driver;

import java.io.IOException;
import java.util.List;

import coursesRegistration.util.Course;
import coursesRegistration.util.FileProcessor;
import coursesRegistration.util.Results;
import coursesRegistration.util.Student;

/**
 * @author John Doe
 *
 */
public class Driver {
	public static void main(String[] args) throws IOException {

		/*
		 * As the build.xml specifies the arguments as argX, in case the argument value
		 * is not given java takes the default value specified in build.xml. To avoid
		 * that, below condition is used
		 */

		if (args.length != 5 || args[0].equals("${arg0}") || args[1].equals("${arg1}") || args[2].equals("${arg2}")) {

			System.err.println("Error: Incorrect number of arguments. Program accepts 5 argumnets.");
			System.exit(0);
		}
		FileProcessor fileProcessor = new FileProcessor();
		List<List<Student>> students = fileProcessor.readStudents(args[0]);
		List<Course> courses = fileProcessor.readCourses(args[1]);
		Results result = new Results();
		result.runAlgorithm(students, courses);
		result.printOutput(students);
		result.writeOutput(students, args[2]);
	}
}

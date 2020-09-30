package coursePlanner.util;

import java.io.IOException;

import coursePlanner.state.StudentStatus;

public interface FileDisplayInterface {

	void printoutput(StudentStatus student);

	void writeOutput(StudentStatus student, String fileName) throws IOException;

	
}

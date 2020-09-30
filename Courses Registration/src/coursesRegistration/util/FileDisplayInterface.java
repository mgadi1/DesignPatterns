package coursesRegistration.util;

import java.io.IOException;
import java.util.List;

public interface FileDisplayInterface {

	void writeOutput(List<List<Student>> students, String fileName) throws IOException;
	
}

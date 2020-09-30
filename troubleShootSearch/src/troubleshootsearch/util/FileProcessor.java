package troubleshootsearch.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class FileProcessor {
	Scanner newScanner;
	public FileProcessor(String fileIn) {
		try {
			File file = new File(fileIn);
			if (!file.isDirectory() && file.exists()) {
				newScanner = new Scanner(file);
			} else {
				System.err.println("File Not found");
				throw new FileNotFoundException();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public String readLine() {
		String sread = null;
		 if ((newScanner.hasNextLine())) {	
			 sread = newScanner.nextLine();
		  }
		 return sread;
	}
}

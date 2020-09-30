package loadBalancer.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Results implements FileDisplayInterface, StdoutDisplayInterface{
	
	FileWriter outputFile;
    File file;
	public Results(String fileName) {
        file = new File(fileName);
        try {
            outputFile = new FileWriter(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
	@Override
	public void printConsole(String toPrint) {
		System.out.println(toPrint);
	}

	@Override
	public void writeFile(String toWrite) {
		try {
            outputFile.write(toWrite + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public void addResult(String info) {
		writeFile(info);
		printConsole(info);
	}

	public void closeAwriter() {
		try {
			outputFile.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}

package troubleshootsearch.driver;

import java.util.HashMap;
import java.util.Map;

import troubleshootsearch.tree.MyTree;
import troubleshootsearch.tree.MyArrayList;
import troubleshootsearch.util.FileProcessor;
import troubleshootsearch.util.Results;
import troubleshootsearch.visitor.Exact;
import troubleshootsearch.visitor.Naive;
import troubleshootsearch.visitor.Semantic;
import troubleshootsearch.visitor.Visitor;

public class Driver {

	public static void main(String[] args) {
		if (args.length != 4 || args[0].equals("${arg0}") || args[1].equals("${arg1}") || args[2].equals("${arg2}") || args[3].equals("${arg3}")) {
			System.err.println("Error: Incorrect number of arguments. Program accepts 4 arguments.");
			System.exit(0);
		}
		
		FileProcessor technicalInfoScan = new FileProcessor(args[0]);
		FileProcessor userInputScan = new FileProcessor(args[1]);
		FileProcessor synonymsScan = new FileProcessor(args[2]);
		Results r = new Results(args[3]);
		
		Visitor exact = new Exact(r);
		Visitor naive = new Naive(r);
		Visitor semantic = new Semantic(r);

		String technicalInfo = null;
		String userInput = null;
		String synonyms = null;

		
		MyArrayList technicalInfoList = new MyArrayList();
		Map<String,String> synMap = new HashMap<>();
		MyTree bst= new MyTree();

		int lineCount = 0;
		
		while ((technicalInfo = technicalInfoScan.readLine()) != null) {
			lineCount=lineCount+1;
			technicalInfoList.addToList(technicalInfo);
			String[] wordString = technicalInfo.split(" ");
			for (int a = 0; a < wordString.length; a++) {
				bst.insert(wordString[a], lineCount);
			}
			
		}

		while ((userInput = userInputScan.readLine()) != null) {
			technicalInfoList.getInput().add(userInput);
		}

		while ((synonyms = synonymsScan.readLine()) != null) {
			String[] synString = synonyms.split("=");
			synMap.put(synString[0], synString[1]);
			synMap.put(synString[1], synString[0]);
		}

		for (String i : technicalInfoList.getInput()) {
			bst.setWordCount(0);
			r.addResult("User input - " + i);
			technicalInfoList.accept(exact, i);
			bst.accept(naive, i);
			technicalInfoList.accept(semantic, i, synMap);
		}
		r.closeAwriter();
	}
}

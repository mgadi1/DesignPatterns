package genericCheckpointing.driver;

import java.util.ArrayList;

import java.util.List;

import genericCheckpointing.server.RestoreI;
import genericCheckpointing.server.StoreI;
import genericCheckpointing.server.StoreRestoreI;
import genericCheckpointing.util.MyAllTypesFirst;
import genericCheckpointing.util.MySpecialTypes;
import genericCheckpointing.util.ProxyCreator;
import genericCheckpointing.util.SerializableObject;
import genericCheckpointing.util1.FileProcessor;
import genericCheckpointing.util1.Results;
import genericCheckpointing.xmlStoreRestore.StoreRestoreHandler;

public class Driver {

	public static void main(String[] args) {
		int NUM_OF_OBJECTS = 0;

		// FIXME: read the value of checkpointFile from the command line
		if (args.length != 4 || args[0].equals("${arg0}") || args[1].equals("${arg1}") || args[2].equals("${arg2}") || args[3].equals("${arg3}")) {
			System.err.println("Enter in format: Mode [arg0], Checkpoint Filename [arg1],"
					+ " Verify checkpoint Filename[args2] and debug value[args3]");
			System.exit(1);
		}

		if (!args[0].equals("deserser")) {
			System.err.println("Mode should be \"deserser\"");
			System.exit(1);
		}

		String newLine = null;
		ProxyCreator pc = new ProxyCreator();

		// create an instance of StoreRestoreHandler (which implements the the
		// InvocationHandler)
		// create a proxy
		StoreRestoreI cpointRef = (StoreRestoreI) pc.createProxy(new Class[] { StoreI.class, RestoreI.class },
				new StoreRestoreHandler());

		// FIXME: invoke a method on the handler instance to set the file name for
		// checkpointFile and open the file
		FileProcessor objectCount = new FileProcessor(args[1]);
		Results r = new Results(args[2]);
		FileProcessor filexml = new FileProcessor(args[1]);

		MyAllTypesFirst myFirst = null;
		//MyAllTypesSecond mySecond;
		MySpecialTypes mySpecialT = null;

		SerializableObject myRecordRet = null;

		// read in a loop till the end of file is indicated
		// NUM_OF_OBJECTS is the size of the data structure in which the objects have
		// been saved
		while ((newLine = objectCount.readLine()) != null) {
			if(newLine.isEmpty()) {
				continue;
			}
			if (newLine.contains("<complexType xsi:type=\"genericCheckpointing.util.")) {
				NUM_OF_OBJECTS++;
			}
		}
		
		List<SerializableObject> list1 = new ArrayList<>();
		for (int i = 0; i < NUM_OF_OBJECTS; i++) {
			myRecordRet = ((RestoreI) cpointRef).readObj("XML", filexml);
			// FIXME: store myRecordRet in a data structure
			list1.add(myRecordRet);
		}
		
		// use "instance of" to determine which of these methods should be called
		for(SerializableObject newObj : list1) {
			if(newObj instanceof MyAllTypesFirst) {
				myFirst = (MyAllTypesFirst) newObj;
				// use this method for MyAllTypesFirst and MyAllTypesSecond.
				((StoreI) cpointRef).writeObj(myFirst, "XML", r);
			}
			if(newObj instanceof MySpecialTypes) {
				mySpecialT = (MySpecialTypes) newObj;
				// use this method for MySpecialTypes
				((StoreI) cpointRef).writeObj(mySpecialT, "XML", r);
			}
		}
		// FIXME: invoke a method on the handler to close the file (if it hasn't already
		// been closed)
		r.closeAwriter();
	}
}

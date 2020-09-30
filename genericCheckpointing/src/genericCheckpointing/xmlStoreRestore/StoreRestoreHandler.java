package genericCheckpointing.xmlStoreRestore;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import genericCheckpointing.strategy.DeserStrategy;
import genericCheckpointing.strategy.SerStrategy;
import genericCheckpointing.strategy.Strategy;
import genericCheckpointing.strategy.XMLDeserialization;
import genericCheckpointing.strategy.XMLSerialization;
import genericCheckpointing.util.SerializableObject;
import genericCheckpointing.util1.FileProcessor;
import genericCheckpointing.util1.Results;

public class StoreRestoreHandler implements InvocationHandler {

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		String methodName = method.getName();

		// if the method is write
		if (methodName.equals("writeObj")) {
			// if the wireFormat is XML
			if (args[1].equals("XML")) {
				Strategy serialising = (SerStrategy) new XMLSerialization((Results) args[2]);
				// call serializeData(args[0], new XMLSerializationStrategy());
				serializeData((SerializableObject) args[0], serialising);
			}
		}

		// if statements to check if it is the read method so that
		// deserialization can be done ...
		if (methodName.equals("readObj")) {
			if (args[0].equals("XML")) {
				Strategy deserialing = new XMLDeserialization((FileProcessor) args[1]);
				return deserializeData(deserialing);
			}
		}
		return null;
	}

	public Object deserializeData(Strategy dStrategy) throws Exception {
		return ((DeserStrategy) dStrategy).processInputDeser();
	}
	public void serializeData(SerializableObject sObject, Strategy sStrategy) throws Exception {
		((SerStrategy) sStrategy).processInputSer(sObject);
	}
}

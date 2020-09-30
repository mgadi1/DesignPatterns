package genericCheckpointing.strategy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import genericCheckpointing.util.SerializableObject;
import genericCheckpointing.util1.FileProcessor;

public class XMLDeserialization implements DeserStrategy {

	FileProcessor fp;

	public XMLDeserialization(FileProcessor fileProcessor) {
		// TODO Auto-generated constructor stub
		fp = fileProcessor;
	}
	
	@Override
	public Object processInputDeser() throws ClassNotFoundException, SecurityException, InstantiationException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException {
		String line;
		String dataName;
		String dataType;
		String value;
		Object obj = null;
		Class<?> cls = null;
		while ((line = fp.readLine()) != null) {
			if (line.trim().contains("<DPSerialization>") || line.trim().contains("</DPSerialization>")) {
				continue;
			} else if (line.trim().contains("<complexType ")) {
				String[] myStrings = line.split("\"");
				cls = Class.forName(myStrings[1]);
				Constructor<?> constructor = cls.getConstructor();
				obj = constructor.newInstance();
			} else if (line.contains("</complexType>")) {
				break;
			} else if (line.trim().isEmpty() || line.trim().isBlank()) {
				System.err.println("Wront format of XML file. No empty lines allowed");
				System.exit(1);
			} else {
				dataName = line.substring(line.indexOf('<') + 1, line.indexOf('x') - 1);
				dataType = line.substring(line.lastIndexOf(':') + 1, line.lastIndexOf('"'));
				value = line.substring(line.indexOf('>') + 1, line.lastIndexOf('<'));
				// System.out.println("dataName " +dataName);
				// System.out.println("dataType " +dataType);
				// System.out.println("value " +value);
				Method setterMethod = null;

				if (dataType.equals("int")) {
					// String methodName = "get" + dataName;
					setterMethod = cls.getMethod("set" + dataName.substring(0, 1).toUpperCase() + dataName.substring(1),
							Integer.TYPE);
					setterMethod.invoke(obj, Integer.parseInt(value));
				} else if (dataType.equals("float")) {
					setterMethod = cls.getMethod("set" + dataName.substring(0, 1).toUpperCase() + dataName.substring(1),
							Float.TYPE);
					setterMethod.invoke(obj, Float.parseFloat(value));
				} else if (dataType.equals("double")) {
					setterMethod = cls.getMethod("set" + dataName.substring(0, 1).toUpperCase() + dataName.substring(1),
							Double.TYPE);
					setterMethod.invoke(obj, Double.parseDouble(value));
				} else if (dataType.equals("long")) {
					setterMethod = cls.getMethod("set" + dataName.substring(0, 1).toUpperCase() + dataName.substring(1),
							Long.TYPE);
					setterMethod.invoke(obj, Long.parseLong(value));
				} else if (dataType.equals("short")) {
					setterMethod = cls.getMethod("set" + dataName.substring(0, 1).toUpperCase() + dataName.substring(1),
							Short.TYPE);
					setterMethod.invoke(obj, Short.parseShort(value));
				} else if (dataType.equals("string")) {
					setterMethod = cls.getMethod("set" + dataName.substring(0, 1).toUpperCase() + dataName.substring(1),
							java.lang.String.class);
					setterMethod.invoke(obj, (value));
				} else if (dataType.equals("char")) {
					setterMethod = cls.getMethod("set" + dataName.substring(0, 1).toUpperCase() + dataName.substring(1),
							Character.TYPE);
					setterMethod.invoke(obj, (value).charAt(0));
				} else if (dataType.equals("boolean")) {
					setterMethod = cls.getMethod("set" + dataName.substring(0, 1).toUpperCase() + dataName.substring(1),
							Boolean.TYPE);
					setterMethod.invoke(obj, Boolean.parseBoolean(value));
				}
			}
		}
		return (SerializableObject) obj;
	}
}


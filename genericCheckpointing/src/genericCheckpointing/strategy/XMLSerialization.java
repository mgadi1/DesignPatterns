package genericCheckpointing.strategy;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import genericCheckpointing.util.SerializableObject;
import genericCheckpointing.util1.Results;

public class XMLSerialization implements SerStrategy {

	Results r;

	public XMLSerialization(Results results) {
		this.r = results;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void processInputSer(SerializableObject obj) throws ClassNotFoundException, SecurityException, InstantiationException,
	IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException {
		/*
		 * Class<?> cls = obj.getClass(); 
		 * if (fld.getType() == int.class) { 
		 * // get field name 
		 * String methodName = "get" + fieldName; 
		 * Method getterMethod = cls.getMethod(fieldName);
		 *  Object invokeRet = getterMethod.invoke(obj);
		 */
		Class<?> cls = obj.getClass();
		String newLine;
		String dataName;
		Field[] dataTypeList = cls.getDeclaredFields();
		r.addResult("<DPSerialization>\n <complexType xsi:type=\"" + cls.getCanonicalName() + "\">");
		for (Field field : dataTypeList) {
			field.setAccessible(true);
			dataName = field.getName();
			Method getterMethod = null;
			SerializeTypes sType = new SerializeTypes();
			if (field.getType() == int.class) {
				getterMethod = cls.getMethod("get" + dataName.substring(0, 1).toUpperCase() + dataName.substring(1));
				int into = (int) getterMethod.invoke(obj);
				newLine = sType.serializeInt(into, dataName);
				if (into == 0)
					continue;
				r.addResult(newLine);
			} else if (field.getType() == short.class) {
				getterMethod = cls.getMethod("get" + dataName.substring(0, 1).toUpperCase() + dataName.substring(1));
				short srt = (short) getterMethod.invoke(obj);
				if (srt == 0)
					continue;
				newLine = sType.serializeShort(srt, dataName);
				r.addResult(newLine);
			} else if (field.getType() == char.class) {
				getterMethod = cls.getMethod("get" + dataName.substring(0, 1).toUpperCase() + dataName.substring(1));
				char chr = (char) getterMethod.invoke(obj);
				newLine = sType.serializeChar(chr, dataName);
				r.addResult(newLine);
			} else if (field.getType() == long.class) {
				getterMethod = cls.getMethod("get" + dataName.substring(0, 1).toUpperCase() + dataName.substring(1));
				long lng = (long) getterMethod.invoke(obj);
				if (lng == 0)
					continue;
				newLine = sType.serializeLong(lng, dataName);
				r.addResult(newLine);
			} else if (field.getType() == double.class) {
				getterMethod = cls.getMethod("get" + dataName.substring(0, 1).toUpperCase() + dataName.substring(1));
				double dbl = (double) getterMethod.invoke(obj);
				if (dbl == 0)
					continue;
				newLine = sType.serializeDouble(dbl, dataName);
				r.addResult(newLine);
			} else if (field.getType() == float.class) {
				getterMethod = cls.getMethod("get" + dataName.substring(0, 1).toUpperCase() + dataName.substring(1));
				float flt = (float) getterMethod.invoke(obj);
				if (flt == 0)
					continue;
				newLine = sType.serializeFloat(flt, dataName);
				r.addResult(newLine);
			} else if (field.getType() == boolean.class) {
				getterMethod = cls.getMethod("is" + dataName.substring(0, 1).toUpperCase() + dataName.substring(1));
				boolean b = (boolean) getterMethod.invoke(obj);
				newLine = sType.serializeBoolean(b, dataName);
				r.addResult(newLine);
			} else if (field.getType() == java.lang.String.class) {
				getterMethod = cls.getMethod("get" + dataName.substring(0, 1).toUpperCase() + dataName.substring(1));
				String str = (String) getterMethod.invoke(obj);
				if (str == null) {
					continue;
				}
				newLine = sType.serializeString(str, dataName);
				r.addResult(newLine);
			} else {
				break;
			}
		}
		r.addResult(" </complexType>\n</DPSerialization>");
	}
}

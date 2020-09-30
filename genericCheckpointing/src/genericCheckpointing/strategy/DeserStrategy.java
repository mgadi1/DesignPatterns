package genericCheckpointing.strategy;

import java.lang.reflect.InvocationTargetException;

public interface DeserStrategy extends Strategy {
	public Object processInputDeser() throws ClassNotFoundException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException;
}

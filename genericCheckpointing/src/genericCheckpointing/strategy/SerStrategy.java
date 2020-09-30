package genericCheckpointing.strategy;


import genericCheckpointing.util.SerializableObject;

public interface SerStrategy extends Strategy {
	public void processInputSer(SerializableObject sObject) throws Exception;
}

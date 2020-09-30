package genericCheckpointing.server;

import genericCheckpointing.util.SerializableObject;
import genericCheckpointing.util1.FileProcessor;

public interface RestoreI extends StoreRestoreI {
    SerializableObject readObj(String input, FileProcessor filexml);
}

package genericCheckpointing.server;

import genericCheckpointing.util.MyAllTypesFirst;
import genericCheckpointing.util.MySpecialTypes;
import genericCheckpointing.util1.Results;

public interface StoreI extends StoreRestoreI {
    void writeObj(MyAllTypesFirst aRecord, String wireFormat, Results r);
    void writeObj(MySpecialTypes sRecord, String wireFormat, Results r);
}

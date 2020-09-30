package genericCheckpointing.util;

public class MyAllTypesSecond extends MyAllTypesFirst{

	
	public MyAllTypesSecond(int myInt, int myOtherInt, long myLong, long myOtherLong, String myString, boolean myBool,
			double myDoubleT, float myFloatT, short myShortT, char myCharT, double myOtherDoubleT) {
		super(myInt, myOtherInt, myLong, myOtherLong, myString, myBool);
		this.myDoubleT = myDoubleT;
		this.myFloatT = myFloatT;
		this.myShortT = myShortT;
		this.myCharT = myCharT;
		this.myOtherDoubleT = myOtherDoubleT;
	}
	public MyAllTypesSecond() {
		super();
		// TODO Auto-generated constructor stub
	}
	private double myDoubleT;
	private float myFloatT;
	private short myShortT;
	private char myCharT;
	private double myOtherDoubleT;
	
	
	
	public double getMyDoubleT() {
		return myDoubleT;
	}
	public void setMyDoubleT(double myDoubleT) {
		this.myDoubleT = myDoubleT;
	}
	public float getMyFloatT() {
		return myFloatT;
	}
	public void setMyFloatT(float myFloatT) {
		this.myFloatT = myFloatT;
	}
	public short getMyShortT() {
		return myShortT;
	}
	public void setMyShortT(short myShortT) {
		this.myShortT = myShortT;
	}
	public char getMyCharT() {
		return myCharT;
	}
	public void setMyCharT(char myCharT) {
		this.myCharT = myCharT;
	}
	public double getMyOtherDoubleT() {
		return myOtherDoubleT;
	}
	public void setMyOtherDoubleT(double myOtherDoubleT) {
		this.myOtherDoubleT = myOtherDoubleT;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + myCharT;
		long temp;
		temp = Double.doubleToLongBits(myDoubleT);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + Float.floatToIntBits(myFloatT);
		temp = Double.doubleToLongBits(myOtherDoubleT);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + myShortT;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyAllTypesSecond other = (MyAllTypesSecond) obj;
		if (myCharT != other.myCharT)
			return false;
		if (Double.doubleToLongBits(myDoubleT) != Double.doubleToLongBits(other.myDoubleT))
			return false;
		if (Float.floatToIntBits(myFloatT) != Float.floatToIntBits(other.myFloatT))
			return false;
		if (Double.doubleToLongBits(myOtherDoubleT) != Double.doubleToLongBits(other.myOtherDoubleT))
			return false;
		if (myShortT != other.myShortT)
			return false;
		return true;
	}
}

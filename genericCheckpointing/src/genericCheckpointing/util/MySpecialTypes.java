package genericCheckpointing.util;

public class MySpecialTypes extends SerializableObject{
	private int myInt1;
	private int myInt2;
	private String myString1;
	private String myString2;
	private double myDoubleT1;
	private double myDoubleT2;

	public MySpecialTypes(int myInt1, int myInt2, String myString1, String myString2, double myDoubleT1,
			double myDoubleT2) {
		super();
		this.myInt1 = myInt1;
		this.myInt2 = myInt2;
		this.myString1 = myString1;
		this.myString2 = myString2;
		this.myDoubleT1 = myDoubleT1;
		this.myDoubleT2 = myDoubleT2;
	}
	
	public MySpecialTypes() {
		// TODO Auto-generated constructor stub
		super();
	}

	public int getMyInt1() {
		return myInt1;
	}

	public void setMyInt1(int myInt1) {
		this.myInt1 = myInt1;
	}

	public int getMyInt2() {
		return myInt2;
	}

	public void setMyInt2(int myInt2) {
		this.myInt2 = myInt2;
	}

	public String getMyString1() {
		return myString1;
	}

	public void setMyString1(String myString1) {
		this.myString1 = myString1;
	}

	public String getMyString2() {
		return myString2;
	}

	public void setMyString2(String myString2) {
		this.myString2 = myString2;
	}

	public double getMyDoubleT1() {
		return myDoubleT1;
	}

	public void setMyDoubleT1(double myDoubleT1) {
		this.myDoubleT1 = myDoubleT1;
	}

	public double getMyDoubleT2() {
		return myDoubleT2;
	}

	public void setMyDoubleT2(double myDoubleT2) {
		this.myDoubleT2 = myDoubleT2;
	}

	@Override
	public String toString() {
		return "MySpecialTypes [myInt1=" + myInt1 + ", myInt2=" + myInt2 + ", myString1=" + myString1 + ", myString2="
				+ myString2 + ", myDoubleT1=" + myDoubleT1 + ", myDoubleT2=" + myDoubleT2 + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(myDoubleT1);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(myDoubleT2);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + myInt1;
		result = prime * result + myInt2;
		result = prime * result + ((myString1 == null) ? 0 : myString1.hashCode());
		result = prime * result + ((myString2 == null) ? 0 : myString2.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MySpecialTypes other = (MySpecialTypes) obj;
		if (Double.doubleToLongBits(myDoubleT1) != Double.doubleToLongBits(other.myDoubleT1))
			return false;
		if (Double.doubleToLongBits(myDoubleT2) != Double.doubleToLongBits(other.myDoubleT2))
			return false;
		if (myInt1 != other.myInt1)
			return false;
		if (myInt2 != other.myInt2)
			return false;
		if (myString1 == null) {
			if (other.myString1 != null)
				return false;
		} else if (!myString1.equals(other.myString1))
			return false;
		if (myString2 == null) {
			if (other.myString2 != null)
				return false;
		} else if (!myString2.equals(other.myString2))
			return false;
		return true;
	}

}

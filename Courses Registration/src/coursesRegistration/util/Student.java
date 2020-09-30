package coursesRegistration.util;

import java.util.Arrays;

public class Student {
   
	private String rollNumber;
    private String classYears;
    private String[] preferences;
    private String course1;
    private String course2;
    private String course3;
    private String course1Timing;
    private String course2Timing;
    private String course3Timing;
    private int satisfactionRating;
    
    public int getSatisfactionRating() {
        return satisfactionRating;
    }
    
    public void setSatisfactionRating(int satisfactionRating) {
        this.satisfactionRating = satisfactionRating;
    }
    
    public String getRollNumber() {
        return rollNumber;
    }
    
    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }
    
    public String getClassYears() {
        return classYears;
    }
    
    public void setClassYears(String classYears) {
        this.classYears = classYears;
    }
    
    public String[] getPreferences() {
        return preferences;
    }
    
    public void setPreferences(String[] preferences) {
        this.preferences = preferences;
    }
    
    public String getCourse1() {
        return course1;
    }
    
    public void setCourse1(String course1) {
        this.course1 = course1;
    }
    
    public String getCourse2() {
        return course2;
    }
    
    public void setCourse2(String course2) {
        this.course2 = course2;
    }
    
    public String getCourse3() {
        return course3;
    }
    
    public void setCourse3(String course3) {
        this.course3 = course3;
    }

	public String getCourse1Timing() {
		return course1Timing;
	}

	public void setCourse1Timing(String course1Timing) {
		this.course1Timing = course1Timing;
	}

	public String getCourse2Timing() {
		return course2Timing;
	}

	public void setCourse2Timing(String course2Timing) {
		this.course2Timing = course2Timing;
	}

	public String getCourse3Timing() {
		return course3Timing;
	}

	public void setCourse3Timing(String course3Timing) {
		this.course3Timing = course3Timing;
	}
    
	@Override
	public String toString() {
		return "Student [rollNumber=" + rollNumber + ", classYears=" + classYears + ", preferences="
				+ Arrays.toString(preferences) + ", course1=" + course1 + ", course2=" + course2 + ", course3="
				+ course3 + ", course1Timing=" + course1Timing + ", course2Timing=" + course2Timing + ", course3Timing="
				+ course3Timing + ", satisfactionRating=" + satisfactionRating + "]";
	}
}

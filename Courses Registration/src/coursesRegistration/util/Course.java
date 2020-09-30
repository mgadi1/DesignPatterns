package coursesRegistration.util;

public class Course {
	
	String courseName;
	String timings;
	int totalCapacity;
	int remCapacity;
	int filledCapacity;
	
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getTimings() {
		return timings;
	}
	public void setTimings(String timings) {
		this.timings = timings;
	}
	public int getTotalCapacity() {
		return totalCapacity;
	}
	public void setTotalCapacity(int totalCapacity) {
		this.totalCapacity = totalCapacity;
	}

	@Override
	public String toString() {
		return "Course [courseName=" + courseName + ", timings=" + timings + ", totalCapacity=" + totalCapacity
				+ ", remCapacity=" + remCapacity + ", filledCapacity=" + filledCapacity + "]";
	}
}

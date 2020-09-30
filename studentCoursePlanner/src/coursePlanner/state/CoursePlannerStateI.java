package coursePlanner.state;


public interface CoursePlannerStateI {
		
		public CoursePlannerStateI courseAdd(String course);
		
		public CoursePlannerStateI graduationStatus();

		public CoursePlannerStateI courseSelect(String course);
	
}

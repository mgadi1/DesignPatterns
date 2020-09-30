package loadBalancer.subject;



public interface SubjectI {
	public void scaleUp(String hostName);
	public void scaleDown(String hostname);
}

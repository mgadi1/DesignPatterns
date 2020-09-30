package loadBalancer.entities;

public class Service {
	private String URL;
	private String name;
	private int flag;
	
	public Service(String url, String name) {
		this.URL = url;
		this.name= name;
		this.flag = 0;
	}
	
	public String getURL() { 
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}
}

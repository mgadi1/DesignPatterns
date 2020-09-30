package loadBalancer.observer;

import java.util.List;

public class ServiceManager implements ObserverI {
	private String key;
	// Information pertaining to the service.
	private String URL;
	private List<String> hostnames;
	int usage;
	// Rest of the code.

	public ServiceManager(String key, String uRL, List<String> hostnames) {
		this.key = key;
		this.URL = uRL;
		this.hostnames = hostnames;
		this.usage = 0;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}

	public List<String> getHostnames() {
		return hostnames;
	}

	public void setHostnames(List<String> hostnames) {
		this.hostnames = hostnames;
	}
}

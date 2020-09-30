package loadBalancer.entities;

import java.util.HashMap;
import java.util.Map;

import loadBalancer.observer.LoadBalancer;

public class Machine {
	private String hostname;
	
	// Service name to hosted services.
	private Map<String, Service> hostedServices = new HashMap<String,Service>();
	LoadBalancer lb = new LoadBalancer();

	// Rest of the code.
	//constructor
	public Machine(String hostName) {
		hostname = hostName;
	}
	
	public Service addService(String serviceName, String url) {
		Service serv = new Service(url,serviceName);
		hostedServices.put(serviceName, serv);
		return serv;
	}
	
	public Service removeService(String serviceName) {
		Service s = hostedServices.remove(serviceName);
		return s;
	}
	
	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}
 
	public Map<String, Service> getHostedServices() {
		return hostedServices;
	}

	public void setHostedServices(Map<String, Service> hostedServices) {
		this.hostedServices = hostedServices;
	}
}

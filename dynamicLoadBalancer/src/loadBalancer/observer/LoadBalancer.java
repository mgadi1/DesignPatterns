package loadBalancer.observer;

import loadBalancer.entities.Service;
import java.util.HashMap;
import java.util.Map;

public class LoadBalancer {

	private Map<Service, ServiceManager> sMans = new HashMap<>();

	public Map<Service, ServiceManager> getsMans() {
		return sMans;
	}

	public void setsMans(Map<Service, ServiceManager> sMans) {
		this.sMans = sMans;
	}

	public void addnewService(Service s, ServiceManager value) {
		sMans.put(s, value);
	}
	
	public void removeServ(Service s) {
		sMans.remove(s);
	}

	public void show() {
		System.out.println(sMans.keySet().size());
	}
}

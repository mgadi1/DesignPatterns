package loadBalancer.subject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import loadBalancer.entities.Machine;
import loadBalancer.entities.Service;
import loadBalancer.observer.LoadBalancer;
import loadBalancer.observer.ServiceManager;
import loadBalancer.util.Results;

public class Cluster implements SubjectI {
	private Map<String, Machine> machines = new LinkedHashMap<String, Machine>();
	private Results r;
	LoadBalancer lB = new LoadBalancer();

	public Cluster(Results r) {
		this.r = r;
	}

	public void scaleUp(String hostName) {
		if (machines.containsKey(hostName)) {
			r.addResult("No machine found");
		}
		Machine mach = new Machine(hostName);
		machines.put(hostName, mach);
		r.addResult("Cluster Scaled Up");
	}

	public void scaleDown(String hostname) {
		if (machines.containsKey(hostname)) {
			machines.remove(hostname);
			r.addResult("Cluster Scaled Down");
		} else {
			r.addResult("Machine Not Found");
		}
	}

	public void addService1(String serviceName, String url, String hostName) {
		List<String> al = new ArrayList<String>();
		String[] hostNameStr = hostName.split(",");
		al = Arrays.asList(hostNameStr);
		ServiceManager sm = new ServiceManager(serviceName, url, al);
		Service s = null;
		for (String a : hostNameStr) {
			if (machines.containsKey(a)) {
				s = machines.get(a).addService(serviceName, url);
			} else {
				r.addResult(" Machine do not exist");
			}
		}
		if (s != null) {
			lB.addnewService(s, sm);
		}
		r.addResult("Service Added");
	}

	public void request(String serviceName) {
		int sflag = 0;
		int iflag = 0;
		for (String a : machines.keySet()) {
			if (machines.get(a).getHostedServices().containsKey(serviceName)) {
				if (machines.get(a).getHostedServices().get(serviceName).getFlag() == 0) {
					sflag = 1;
					r.addResult("Processed Request - Service_URL::"
							+ machines.get(a).getHostedServices().get(serviceName).getURL() + " Host::" + a);
					// System.out.println(machines.get(a).getHostedServices().get(serviceName).getFlag());
					machines.get(a).getHostedServices().get(serviceName)
							.setFlag(machines.get(a).getHostedServices().get(serviceName).getFlag() + 1);
					iflag = 1;
					break;
				}
			}
		}
		if (iflag == 0) {
			for (String a : machines.keySet()) {
				if (machines.get(a).getHostedServices().containsKey(serviceName)) {
					iflag = 2;
					if (machines.get(a).getHostedServices().get(serviceName).getFlag() == 1) {

						sflag = 1;
						r.addResult("Processed Request - Service_URL::"
								+ machines.get(a).getHostedServices().get(serviceName).getURL() + " Host::" + a);
						// System.out.println(machines.get(a).getHostedServices().get(serviceName).getFlag());
						machines.get(a).getHostedServices().get(serviceName)
								.setFlag(machines.get(a).getHostedServices().get(serviceName).getFlag() + 1);
						iflag = 3;
						break;
					}
				}
			}

		}

		if (iflag == 2 && iflag != 3) {
			for (String a : machines.keySet()) {
				if (machines.get(a).getHostedServices().containsKey(serviceName)) {
					iflag = 4;
					if (machines.get(a).getHostedServices().get(serviceName).getFlag() == 2) {

						sflag = 1;
						r.addResult("Processed Request - Service_URL::"
								+ machines.get(a).getHostedServices().get(serviceName).getURL() + " Host::" + a);
						// System.out.println(machines.get(a).getHostedServices().get(serviceName).getFlag());
						machines.get(a).getHostedServices().get(serviceName)
								.setFlag(machines.get(a).getHostedServices().get(serviceName).getFlag() + 1);
						iflag = 5;
						break;
					}
				}
			}

		}

		if (iflag == 4 && iflag != 5) {
			for (String a : machines.keySet()) {
				if (machines.get(a).getHostedServices().containsKey(serviceName)) {
					iflag = 6;
					if (machines.get(a).getHostedServices().get(serviceName).getFlag() == 3) {

						sflag = 1;
						r.addResult("Processed Request - Service_URL::"
								+ machines.get(a).getHostedServices().get(serviceName).getURL() + " Host::" + a);
						// System.out.println(machines.get(a).getHostedServices().get(serviceName).getFlag());
						machines.get(a).getHostedServices().get(serviceName)
								.setFlag(machines.get(a).getHostedServices().get(serviceName).getFlag() + 1);
						iflag = 7;
						break;
					}
				}
			}

		}
		if (iflag == 6 && iflag != 7) {
			for (String a : machines.keySet()) {
				if (machines.get(a).getHostedServices().containsKey(serviceName)) {
					iflag = 8;
					if (machines.get(a).getHostedServices().get(serviceName).getFlag() == 4) {

						sflag = 1;
						r.addResult("Processed Request - Service_URL::"
								+ machines.get(a).getHostedServices().get(serviceName).getURL() + " Host::" + a);
						// System.out.println(machines.get(a).getHostedServices().get(serviceName).getFlag());
						machines.get(a).getHostedServices().get(serviceName)
								.setFlag(machines.get(a).getHostedServices().get(serviceName).getFlag() + 1);
						iflag = 9;
						break;
					}
				}
			}

		}

		if (sflag == 0) {
			r.addResult("Invalid Service");
		}
	}

	public void removeService(String serviceName) {
		Service s = null;
		for (String a : machines.keySet()) {
			s = machines.get(a).removeService(serviceName);
			lB.removeServ(s);
		}
		if (s != null) {
			r.addResult("Service Removed");
		} else {
			r.addResult("Service Not Found");
		}
	}

	public void addInstance(String serviceName, String hostName) {
		int addInstance = 0;
		Map<Service, ServiceManager> sMap1 = new HashMap<>();
		String url = null;
		sMap1 = lB.getsMans();
		for (Service s : sMap1.keySet()) {
			if (s.getName().equals(serviceName)) {
				addInstance = 1;
				url = s.getURL();
				if (machines.containsKey(hostName)) {
					machines.get(hostName).addService(serviceName, url);
					r.addResult("Instance Added");
				} else {
					r.addResult(hostName + " Machine do not exist");
				}
			}
		}
		if (addInstance == 0) {
			r.addResult("Service Not Found");
		}
	}

	public void removeInstance(String serviceName) {
		Service abc = null;
		for (String a : machines.keySet()) {
			abc = machines.get(a).removeService(serviceName);
		}
		if (abc != null) {
			r.addResult("Instance Removed");
		} else
			r.addResult("Service Not Found");
	}

	public Map<String, Machine> getMachines() {
		return machines;
	}

	public void setMachines(Map<String, Machine> machines) {
		this.machines = machines;
	}

	public void showSMs() {
		lB.show();
	}
}

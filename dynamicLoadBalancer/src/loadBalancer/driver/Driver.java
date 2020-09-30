package loadBalancer.driver;


import java.io.IOException;
import loadBalancer.subject.Cluster;
import loadBalancer.util.FileProcessor;
import loadBalancer.util.Results;

public class Driver {

	public static void main(String[] args) throws IOException {
		if (args.length != 2) {
			System.err.println("Error: Incorrect number of arguments. Program accepts 4 arguments.");
			System.exit(0);
		}
		String line;
		FileProcessor scanner = new FileProcessor("input.txt");
		Results r = new Results("output.txt");
		Cluster singleCluster = new Cluster(r);
		while ((line = scanner.readLine()) != null) {
			String[] fullLine = line.split(" "); // full line string
			String command = fullLine[0]; // command name

			if (command.equals("CLUSTER_OP__SCALE_UP")) {
				String[] newLine = line.split(" ");
				String hostname1 = newLine[1];
				if(hostname1==null) {
					System.err.println("Error: Incorrect number of arguments. Program accepts 4 arguments.");
					System.exit(0);
				}
				singleCluster.scaleUp(hostname1);
			}

			else if (command.equals("CLUSTER_OP__SCALE_DOWN")) {
				String[] newLine = line.split(" ");
				String hostname1 = newLine[1];
				if(hostname1==null) {
					System.err.println("Error: Incorrect number of arguments. Program accepts 4 arguments.");
					System.exit(0);
				}
				singleCluster.scaleDown(hostname1);
			}

			else if (command.contentEquals("SERVICE_OP__ADD_SERVICE")) {
				String[] newLine = line.split(" ");
				String serviceName = newLine[1];
				String url = newLine[2];
				String hostName = newLine[3];
				if(hostName==null || url==null || serviceName==null) {
					System.err.println("Error: Incorrect number of arguments. Program accepts 4 arguments.");
					System.exit(0);
				}
				singleCluster.addService1(serviceName, url, hostName);

			} else if (command.contentEquals("SERVICE_OP__REMOVE_SERVICE")) {
				String[] newLine = line.split(" ");
				String serviceName = newLine[1];
				if(serviceName==null) {
					System.err.println("Error: Incorrect number of arguments. Program accepts 4 arguments.");
					System.exit(0);
				}
				singleCluster.removeService(serviceName);

			} else if (command.contentEquals("SERVICE_OP__ADD_INSTANCE")) {
				String[] newLine = line.split(" ");
				String serviceName = newLine[1];
				String hostName = newLine[2];
				if(hostName==null || serviceName==null) {
					System.err.println("Error: Incorrect number of arguments. Program accepts 4 arguments.");
					System.exit(0);
				}
				singleCluster.addInstance(serviceName,hostName);

			} else if (command.contentEquals("SERVICE_OP__REMOVE_INSTANCE")) {
				String[] newLine = line.split(" ");
				String serviceName = newLine[1];
				if(serviceName==null) {
					System.err.println("Error: Incorrect number of arguments. Program accepts 4 arguments.");
					System.exit(0);
				}
				singleCluster.removeInstance(serviceName);

			} else if (command.contentEquals("REQUEST")) {
				String[] newLine = line.split(" ");
				String serviceName = newLine[1];
				if(serviceName==null) {
					System.err.println("Error: Incorrect number of arguments. Program accepts 4 arguments.");
					System.exit(0);
				}
				singleCluster.request(serviceName);
			}
		}
		r.closeAwriter();
		
	}
}

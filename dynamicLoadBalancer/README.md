# csx42-fall-2019-assign3-mgadi1
Name: Mohit Gadi

Following are the commands and the instructions to run ANT on your project.

Note: build.xml is present in DynamicLoadBalancer/src folder.
Instruction to clean:
####Command: ant -buildfile DynamicLoadBalancer/src/build.xml clean



Instruction to compile:
####Command: ant -buildfile DynamicLoadBalancer/src/build.xml all



Instruction to run:
####Command: ant -buildfile DynamicLoadBalancer/src/build.xml run -Darg0="input.txt" -Darg1="output.txt"

Note: Arguments accept the absolute path of the files.

Description:

I have created a cluster and it can have multiple machines. Clustering up means a new machine is created with the given hostname.
A service can be added to a machine by the command of SERVICE_OP__ADD_SERVICE. This service can be added to multiple host machines with a single line input.
An instance can be added to the machine as well, but the service of this instance needs to be present.
A 1 to 1 relation is also maintained in ServiceManager. Whenever an instance needs to be added, the URL is taken from the service manager.
However I have not used trie datastructure, instead I have used mapping.
When the user request for service, it is provided in round robin method.
If the service is not present, it replies with service not found.
I have also handled multiple exceptions as well, including adding instance without service beign already present, add service without the presence of given machine.



Academic Honesty statement:
"I have done this assignment completely on my own. I have not copied it, nor have I given my solution to anyone else. I understand that if I am involved in plagiarism or cheating an official form will be submitted to the Academic Honesty Committee of the Watson School to determine the action that needs to be taken. "

Date: 11/04/2019

# csx42-fall-2019-assign5-mgadi1
Name: Mohit Gadi

Following are the commands and the instructions to run ANT on your project.

Note: build.xml is present in genericCheckpointing/src folder.
Instruction to clean:
####Command: ant -buildfile genericCheckpointing/src/build.xml clean


Instruction to compile:
####Command: ant -buildfile genericCheckpointing/src/build.xml all


Instruction to run:
####Command: ant -buildfile genericCheckpointing/src/build.xml run -Darg0="deserser" -Darg1="input.txt" -Darg2="output.txt" -Darg3="0"

Note: Arguments accept the absolute path of the files.

Description:
Dynamic proxy: I have created an instance of ProxyCreator, pc, in driver.java. And then I created an instance of StoreRestoreHandler, cpointref,
whose code was provided by the instructor. 

Deserialisation: I am creating all SerializableObject's and putting it in a ArrayList, list1. I am calling readObj method, which I have
created in StoreRestoreHandler, which in turn, calls the processInputDeser() method from XMLDeserialization.java. In processInputDeser() method,
I have code to handle different lines. If the line contains "<complexType", a new class will be created. If the line contains any data type,
then a new method for setDATATYPE is created using getMethod function and its value is invoked. The readObj also takes an instance
of FileProcessor as argument. So this is done till the end of file.

Serialization: All the SerializableObject's are the processed using a for loop which were stored in ArrayList, list1. If the SerializableObject
is an instance of MyAllTypesFirst, then the SerializableObject is casted to MyAllTypesFirst, otherwise it is casted to MySpecialTypes.
After the class type of the SerializableObject is known, writeObj method is called which again is created in StoreRestoreHandler, which
 in turn calls the processInputSer() method from XMLSerialization.java. This is the place where serialization is done. When a new 
 SerializableObject's serialization is started, DPSerialization line is added and the complexType line is added alongwith the cannonical 
 name of the class of the SerializableObject. Same as Deserialization, getDATATYPE method  is created and its value is inovked after 
 getting the return value from SeriazationTypes.java. Then all the datatypes whose value was added in the SerializableObject, are printed in 
 the format same as the input file. writeObj also takes instance of Results as argument, which prints all the fields and writes to file.
 
 OUTPUT: The fields in the input file and the output file may be in different order, but the values will be displayed correctly. In very few cases,
 if there is no field in input file, there might be a field in output file with the default value. But in many cases, if the value is default, then the field
will not be printed.

 DEBUG: I have not used any debug levels, so whatever the input of the args[3] is, it won't make any difference.
 
 Strategy pattern: I have used a base interfarce, Strategy, which is empty. I have then created two interfaces, DeserStrategy and SerStrategy,
 which are implemented by XMLDeserialization and XMLSerialization respectively. Both, DeserStrategy and SerStrategy extends Strategy.
 The method names in both the interfaces are different as mention in the project guidelines. 
 
Academic Honesty statement:
"I have done this assignment completely on my own. I have not copied it, nor have I given my solution to anyone else. I understand that if I am involved in plagiarism or cheating an official form will be submitted to the Academic Honesty Committee of the Watson School to determine the action that needs to be taken. "

Date: 12/04/2019

# CS542: Assignment 1
## Name: Mohit Gadi

-----------------------------------------------------------------------
-----------------------------------------------------------------------
SLOCK DAYS USED: 1.

Following are the commands and the instructions to run ANT on your project.
#### Note: build.xml is present in studentCoursePlanner/src folder.

-----------------------------------------------------------------------
## Instruction to clean:

####Command: ant -buildfile studentCoursePlanner/src/build.xml clean

Description: It cleans up all the .class files that were generated when you
compiled your code.

-----------------------------------------------------------------------
## Instruction to compile:

####Command: ant -buildfile studentCoursePlanner/src/build.xml all

Description: Compiles your code and generates .class files inside the BUILD folder.

-----------------------------------------------------------------------
## Instruction to run:

####Command: ant -buildfile studentCoursePlanner/src/build.xml run -Darg0="input.txt" -Darg1="output.txt"

Note: Arguments accept the absolute path of the files.


-----------------------------------------------------------------------
## Description:

In my Course Planner project, I have created a context class, named, StudentStatus, and 4 states. These are
1. NotGraduate
2. PreReq (PreRequisites)
3. Electives
4. Graduated

So the project work as follows:
When input file is read, StudentStatus is created which is initially in the NotGraduate State. A loop processes 
all the courses of a student. 

NotGraduate:
When a course is processed, if it is from A to P, the StudentStatus state changes 
from NotGraduate to PreReq. And if it is from Q to Z, StudentStatus state changes from NotGraduate to 
Electives. 

PreReq and Electives:
When the state is PreReq, the course is added to the SelectedCourses List and OnGoing semester 
Lists if the preReq conditions are satisfied. Otherwise the course is added to the waitList List. If the course is
added to the selectedCourses, the state changes to Graduated, and checks whether it meets the graduation
requirements. If it meets, the student is graduated, otherwise the student state changes to NotGraduate again.

OnGoingSem: 
Courses are also added to a OngoingSem List, and any of the course to be added is checked 
for any other course which belongs to the same group. If OnGoingSem includes the same group course, the 
course is added to the waitlist. The OnGoingSem is cleared as soon as the size of the list reaches 3.

WaitList:
The courses which cannot be added to the SelectedCourses, are added to waitlist. And waitList is processed
whenever a semester ends.

Graduate State:
Whenever a student comes in the graduate state, it checks whether the student is ready to graduate or not. If 
the student is ready to graduate, the student status changes to Graduated. If the student is not ready to graduate
the student status is again changed to NotGraduate.

If the course list does not contain A, B, E, F, I, J, M or N, then the student cannot graduate as there are minimum
of two courses required from every group for a student to graduate. And the above courses are the pre-requisites
of other courses, so without these courses, student won't be able to graduate.

-----------------------------------------------------------------------
### Academic Honesty statement:
-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating an official form will be
submitted to the Academic Honesty Committee of the Watson School to
determine the action that needs to be taken. "

Date: 10/06/2019



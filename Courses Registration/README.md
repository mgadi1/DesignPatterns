# DESIGN PATTERNS
# NAME OF PROJECT: COURSES REGISTRATION
# CS542: Assignment 1
## Name: Mohit Gadi

-----------------------------------------------------------------------
-----------------------------------------------------------------------


Following are the commands and the instructions to run ANT on your project.
#### Note: build.xml is present in coursesRegistration/src folder.

-----------------------------------------------------------------------
## Instruction to clean:

####Command: ant -buildfile coursesRegistration/src/build.xml clean

Description: It cleans up all the .class files that were generated when you
compiled your code.

-----------------------------------------------------------------------
## Instruction to compile:

####Command: ant -buildfile coursesRegistration/src/build.xml all

Description: Compiles your code and generates .class files inside the BUILD folder.

-----------------------------------------------------------------------
## Instruction to run:

####Command: ant -buildfile coursesRegistration/src/build.xml run -Darg0="student_coursePrefs.txt" -Darg1="courseInfo.txt" -Darg2="registration_results.txt"

Note: Arguments accept the absolute path of the files.

-----------------------------------------------------------------------
## Description:
For this project, I have created 2 classes, Students and Courses.
A student class has the following variables:
Roll number, Year of their study, List of preferences, course 1, course 1 timings, course 2, course 2 timings, course 3,
course 3 timings and satisfaction rating. Roll number, year of study and list of preferences are already in the
student_coursePrefs.txt file, while the other variables has been assigned in the project. 
A Course class contains the following variables:
Name of the course, timings and the course capacity. All of them are already in the courseInfo.txt file.
So the implementation of the project goes like, creating 3 different lists of class Students, based on their Year of study,
with their roll number and list of preferences. Now while assigning courses, THIRD_YEAR students are assigned all their
courses before SECOND_YEAR students and FIRST_YEAR students. So in the first place, the first THIRD_YEAR student
is assigned its first preferred course and its timings if the capacity of that course is not zero. If the capacity is zero, then it
looks for the second preferred course and so on. This thing keeps going until the first THIRD_YEAR student is assigned 1
course and its time. After assigning, second student is assigned its first course, similarly like the first student was
assigned, and this thing keeps going until the last student is assigned its first course. After all the THIRD_YEAR students
are assigned their first preferred course and its time, now they are assigned their next most preffered, if it is available and
if the timing of the second available course doesn't clash with the first assigned course. Similarly third course is also
assigned to the all the THIRD_YEAR students. After all third year students have been assigned their courses, second year
students are also assigned their courses similarly like the THIRD_YEAR students, followed by the first year students. This
type of assigning courses is better because the deviation of satisfaction rating is the least, as compared to the method of
assigning all the courses to a student and the assigning to the next student. However in many cases, the average
satisfaction rating would be same, but the deviation will be much lower in the method I have used. 
The time complexity in assigning the courses would be O(number of students).
Sample input and output files are as follows:

student_coursePrefs.txt:
111 D,C,A,B,G,I,H,F,E::FIRST_YEAR
222 F,E,D,C,B,A,H,I,G::SECOND_YEAR
333 D,A,F,E,I,C,H,B,G::THIRD_YEAR
112 D,C,A,B,G,I,H,F,E::FIRST_YEAR
223 F,E,D,C,B,A,H,I,G::SECOND_YEAR
334 D,A,F,E,I,C,H,B,G::THIRD_YEAR
113 D,C,A,B,G,I,H,F,E::FIRST_YEAR
224 F,E,D,C,B,A,H,I,G::SECOND_YEAR
335 D,A,F,E,I,C,H,B,G::THIRD_YEAR
114 D,C,A,B,G,I,H,F,E::FIRST_YEAR
225 F,E,D,C,B,A,H,I,G::SECOND_YEAR
336 D,A,F,E,I,C,H,B,G::THIRD_YEAR

courseInfo.txt:
A CAPACITY:5;CLASS_TIMING:2
B CAPACITY:3;CLASS_TIMING:8
C CAPACITY:5;CLASS_TIMING:7
D CAPACITY:3;CLASS_TIMING:9
E CAPACITY:6;CLASS_TIMING:9
F CAPACITY:3;CLASS_TIMING:8
G CAPACITY:4;CLASS_TIMING:4
H CAPACITY:3;CLASS_TIMING:3
I CAPACITY:4;CLASS_TIMING:6

Based on the above input files, the contents of the output file, named registration_results.txt would be:
111:C,G,H::SatisfationRating=16
112:G,I,H::SatisfationRating=12
113:G,I,H::SatisfationRating=12
114:G,I,E::SatisfationRating=10
222:E,C,B::SatisfationRating=19
223:E,C,B::SatisfationRating=19
224:E,C,B::SatisfationRating=19
225:E,C,A::SatisfationRating=18
333:D,A,F::SatisfationRating=24
334:D,A,F::SatisfationRating=24
335:D,A,I::SatisfationRating=22
336:A,F,E::SatisfationRating=21
AverageSatisfactionRating=18.0

Notes:
1. Incase a students is not assigned with all the three courses, the empty course is displayed as a space(" ").
2. In case a preference is repeated, the course is not assigned again.
3. In case a roll number is different from the mentioned roll number list (100-999), the program will still run but 
    that roll number won't be assigned any courses alongwith an error message mentioning "Enter Valid Roll Number". 
    All the students will still be assigned their respective courses. 
4. If a roll number is repeated with a new list of preferences, only the preferences that came first in the list with the 
    same roll number will be used to assign the courses. The next preferences from the repeated roll number will not 
    be accepted. Although the program 
    will still run, but will also display an error message mentioning "Roll Number Repeated: 110".

-----------------------------------------------------------------------
### Academic Honesty statement:
-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating an official form will be
submitted to the Academic Honesty Committee of the Watson School to
determine the action that needs to be taken. "

Date: September 15, 2019.



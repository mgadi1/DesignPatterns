package coursesRegistration.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import coursesRegistration.util.Student;

public class FileProcessor {
    
    public List<List<Student>> readStudents(String studentInputFile) throws IOException {
        File studentFile = new File(studentInputFile);
        Scanner newScanner;
        List<Student> studentList1 = new ArrayList<Student>();
        List<Student> studentList2 = new ArrayList<Student>();
        List<Student> studentList3 = new ArrayList<Student>();
        try {
            newScanner = new Scanner(studentFile);
        listadd:
            while (newScanner.hasNextLine()) {
                String everyline = newScanner.nextLine();
                String[] fullLine = everyline.split(" ");
                String rollNumber = fullLine[0];
                String[] prefAndYear = fullLine[1].split("::");
                String preferenceList = prefAndYear[0];
                String classYear11 = prefAndYear[1];
                String[] preferences = preferenceList.split(",");
                Student student = new Student();
                int checkRoll = 0;
                try{
                    checkRoll = Integer.parseInt(rollNumber);
                }
                catch(Exception e){
                    e.getMessage();
                }
                if (checkRoll<100 || checkRoll>999) {
                    System.err.println("Enter Valid Roll Number: " + rollNumber);
                    continue listadd;
                }
                
                for (int q = 0; q < studentList1.size(); q++) {
                    if (studentList1.get(q).getRollNumber().equals(rollNumber)) {
                        System.err.println("Roll number repeated: " + rollNumber);
                        continue listadd;
                    }
                }
                for (int w = 0; w < studentList2.size(); w++) {
                    if (studentList2.get(w).getRollNumber().equals(rollNumber)) {
                        System.err.println("Roll number repeated: " + rollNumber);
                        continue listadd;
                    }
                }
                for (int e = 0; e < studentList3.size(); e++) {
                    if (studentList3.get(e).getRollNumber().equals(rollNumber)) {
                        System.err.println("Roll number repeated: " + rollNumber);
                        continue listadd;
                    }
                }
                student.setRollNumber(rollNumber);
                student.setPreferences(preferences);
                student.setClassYears(classYear11);
                student.setCourse1(" ");
                student.setCourse2(" ");
                student.setCourse3(" ");
                student.setCourse1Timing("NA");
                student.setCourse2Timing("NA");
                student.setCourse3Timing("NA");
                student.setSatisfactionRating(0);
                
                if (student.getClassYears().equals("FIRST_YEAR")) {
                    studentList1.add(student);
                }
                if (student.getClassYears().equals("SECOND_YEAR")) {
                    studentList2.add(student);
                }
                if (student.getClassYears().equals("THIRD_YEAR")) {
                    studentList3.add(student);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        List<List<Student>> students = new ArrayList<List<Student>>();
        students.add(studentList3);
        students.add(studentList2);
        students.add(studentList1);
        
        return students;
    }
    
    public List<Course> readCourses(String courseInputFile) throws FileNotFoundException {
        List<Course> courseList = new ArrayList<>();
        File courseFile = new File(courseInputFile);
        Scanner newScanner = new Scanner(courseFile);
        while (newScanner.hasNextLine()) {
            String everyLine1 = newScanner.nextLine();
            String[] fullLine1 = everyLine1.split(" CAPACITY:");
            String[] capAndTimings = fullLine1[1].split(";CLASS_TIMING:");
            String courseName = fullLine1[0];
            int capacity = Integer.parseInt(capAndTimings[0]);
            String timings = capAndTimings[1];
            Course course = new Course();
            course.setTotalCapacity(capacity);
            course.setCourseName(courseName);
            course.setTimings(timings);
            courseList.add(course);
        }
        return courseList;
    }
}

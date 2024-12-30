import models.Teachers;
import models.Person;
import models.Student;
import models.School;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MyApplication {
    public static void main(String[] args) {
        School school = new School();

        try {
            File teachersFile = new File("teachers.txt");
            Scanner teacherScanner = new Scanner(teachersFile);
            while (teacherScanner.hasNextLine()) {
                String[] data = teacherScanner.nextLine().split(" ");
                String name = data[0];
                String surname = data[1];
                int age = Integer.parseInt(data[2]);
                boolean gender = data[3].equals("Male");
                String subject = data[4];
                int yearsOfExperience = Integer.parseInt(data[5]);
                int salary = Integer.parseInt(data[6]);

                Teachers teacher = new Teachers(name, surname, age, gender, subject, yearsOfExperience, salary);
                school.addMember(teachers);

                if (yearsOfExperience > 10) {
                    teachers.giveRaise(10);
                }
            }

            File studentsFile = new File("students.txt");
            Scanner studentScanner = new Scanner(studentsFile);
            while (studentScanner.hasNextLine()) {
                String[] data = studentScanner.nextLine().split(" ");
                String name = data[0];
                String surname = data[1];
                int age = Integer.parseInt(data[2]);
                boolean gender = data[3].equals("Male");

                Student student = new Student(name, surname, age, gender);
                for (int i = 4; i < data.length; i++) {
                    student.addGrade(Integer.parseInt(data[i]));
                }
                school.addMember(student);
            }

            System.out.println(school);

        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }
    }
}
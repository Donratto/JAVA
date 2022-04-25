package AppTests;

import java.time.LocalDate;
import java.util.Scanner;

import Classes.AbsStudent;
import javaDatabase.Database;

public class AppTest01 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        var db = new Database();
        boolean run = true;
        int choice = 0;

        while (run) {

            System.out.println("""
                    Choose required action:
                    1.  new student
                    2.  new grade
                    3.  discharge student
                    4.  listing all students
                    5.  run student's skill
                    6.  sorted (by surname) list of students in their studies 
                    7.  printout general average grade for each study
                    8.  extract number of students in studies
                    9.  file handling
                    10. SQL handling
                    """);

            //choice = AbsStudent.IntInput(sc);
            switch (choice  = AbsStudent.IntInput(sc)) {
                case (1): 
                System.out.printf("enter firstname: \n");
                String firstName = sc.next();
                System.out.printf("enter surname: \n");
                String secondName = sc.next();
                System.out.printf("enter (yyyy-mm-dd) date of birth: \n");
                LocalDate birthDate = AbsStudent.DateInput(sc);
                System.out.println("""
                        Choose type of study:
                        1. technical
                        2. humanitarian
                        3. combined
                        """);
                int typeOfStudy = AbsStudent.IntInput(sc, 3);
                db.addStudent(typeOfStudy, firstName, secondName, birthDate);
                    break;
                case (2): 
                System.out.println("buf"+choice);
                    break;
                case (3): 
                System.out.println("buf"+choice);
                    break;
                case (4): 
                db.listOfStudents();
                    break;
                case (5): 
                System.out.println("buf"+choice);
                    break;
                case (6): 
                System.out.println("buf"+choice);
                    break;
                case (7): 
                System.out.println("buf"+choice);
                    break;
                case (8): 
                System.out.println("buf"+choice);
                    break;
                case (9): 
                System.out.println("buf"+choice);
                    break;
                case (10): 
                System.out.println("buf"+choice);
                    break;

                default:
                    run = false;
                    break;
            }



        }

        System.out.println("this the end");


    }
}

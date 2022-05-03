package Program.AppTests;
import java.time.LocalDate;
import java.util.Scanner;

import Program.Classes.AbsStudent;
import Program.javaDatabase.Database;



public class AppTest01 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        var db = new Database();
        boolean run = true;
        int choice = 0;
        int id;

        //if(sc.hasNext()) sc.next();
        spacer(6);
        while (run) {
            
            System.out.print("""
                    List of actions
                    0.  end operation
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
                    11. stalk a student
                    12. list grades of a student
                    Choose required action:\t""");
            choice  = AbsStudent.IntInput(sc,12,0);
            if((choice > 1 && choice < 9) && emptyDb(db)) continue;
            switch (choice) {
                case (0):
                    run = false;
                    break;
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
                int typeOfStudy = AbsStudent.IntInput(sc, 3,1);
                db.addStudent(typeOfStudy, firstName, secondName, birthDate);
                spacer(1);
                    break;
                case (2):
                    Boolean _run = true;
                    id = inputId(sc);
                    if(db.getStudent(id)==null) {
                        System.out.println(id+" this student ceased to exist");
                        spacer(1);
                        break;
                    }
                while (_run) {
                    System.out.print("enter grade: ");
                    db.addGrade(id, AbsStudent.IntInput(sc, 5, 1));
                    System.err.println("""
                    Continue adding grades?
                    0. no
                    1. yes""");
                    switch (choice=AbsStudent.IntInput(sc,1,0)) {
                        case 0:
                            _run = false;
                            break;
                        case 1:
                            break;
                    }
                }
                    spacer(1);
                    break;
                case (3): 
                    spacer(1);
                    id = inputId(sc);
                    if(db.getStudent(id)==null) {
                        System.out.println(id+" this student ceased to exist");
                        spacer(1);
                        break;
                    }
                    db.deleteStudent(id);
                    spacer(1);
                    break;
                case (4):
                    spacer(1);
                    db.listOfStudents();
                    spacer(1);
                    break;
                case (5): 
                    spacer(1);
                    id = inputId(sc);
                    if(db.getStudent(id)==null) {
                        System.out.println(id+" this student ceased to exist");
                        spacer(1);
                        break;
                    }
                    System.out.print(db.skillStudent(id));
                    spacer(1);
                    break;
                case (6): 
                    spacer(1);
                    db.sNameSort();
                    spacer(1);
                    break;
                case (7): 
                    spacer(1);
                    db.generalAvg();
                    spacer(1);
                    break;
                case (8): 
                    spacer(1);
                    db.studentsInStudies();
                    spacer(1);
                    break;
                case (9): 
                    spacer(1);
                    System.err.println("""
                    File operation
                    0. cancel
                    1. load database from file
                    2. save database to file""");
                    switch (choice=AbsStudent.IntInput(sc,2,0)) {
                        case 0:
                            break;
                        case 1:
                            spacer(1);
                            System.out.println("Enter only name of the file which's type is '.txt'");
                            db.loadDatabase(sc.next());
                            break;
                        case 2:
                            spacer(1);
                            System.out.println("Enter only name of the file which's type will be '.txt'");
                            db.saveDatabase(sc.next());
                            break;
                            
                    }
                    spacer(1);
                    break;
                case (10): 
                    spacer(1);
                    System.err.println("""
                    SQL operation
                    0. cancel
                    1. load database from SQL server
                    2. upload database to SQL server""");
                    switch (choice=AbsStudent.IntInput(sc,2,0)) {
                        case 0:
                            break;
                        case 1:
                            spacer(1);
                            if(db.loadSQL()){
                                System.out.println("SQL database has been loaded");
                            } else {
                                System.out.println("SQL error");
                            }   
                            break;
                        case 2:
                            spacer(1);
                            if(db.saveSQL()) {
                                System.out.println("SQL database has been saved");
                            } else {
                                System.out.println("SQL error");
                            }
                            break;
                        
                    }
                    spacer(1);
                    break;
                case (11):
                    if(emptyDb(db)) break;
                    spacer(1);
                    id =inputId(sc);
                    spacer(1);
                    if(db.getStudent(id)==null) {
                        System.out.println(id+" this student ceased to exist");
                        spacer(1);
                        break;
                    }
                    db.stalkStudent(id);
                    spacer(1);
                    break;
                case (12):
                    if(emptyDb(db)) break;
                    spacer(1);
                    id = inputId(sc);
                    spacer(1);
                    if(db.getStudent(id)==null) {
                        System.out.println(id+" this student ceased to exist");
                        spacer(1);
                        break;
                    }
                    (db.getStudent(id)).listGrades();
                    spacer(1);
                    break; 
                default:
                    run = false;
                    break;
            }



        }
        sc.close();
        System.out.println("this is the end");


    }

    private static void spacer(int spaces) {
        for(int i =0; i< spaces;i++) System.out.println();
    }

    private static void enterId() {
        System.out.println("Enter student's id: ");
    }
    private static int inputId(Scanner sc) {
        enterId();
        return AbsStudent.IntInput(sc, Database.nextStudentId-1, 1);
    }
    private static boolean emptyDb(Database db) {
        int count = 0;
        for(int i = 0; i < Database.nextStudentId; i++) {
            if(db.getStudent(i)!=null) {count++;}
        }
        if(count!=0) return false;
        spacer(1);
        System.err.println("the databse is empty!");
        spacer(1);
        return true;
    }
}

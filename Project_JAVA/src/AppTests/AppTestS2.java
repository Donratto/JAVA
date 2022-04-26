package AppTests;
import java.time.LocalDate;

import java.util.Random;
import java.util.Scanner;

import Classes.AbsStudent;
import javaDatabase.Database;





public class AppTestS2 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        var db = new Database(); 

        db.addStudent(1, "Alex", "Halex", LocalDate.parse("2000-07-06"));
        db.addStudent(2, "Blex", "Hblex", LocalDate.parse("2000-07-06"));
        db.addStudent(3, "Clex", "Hclex", LocalDate.parse("2000-07-06"));

        
        
        for(int idx = 0; idx < 3; idx++ ) {
            //db.skillStudent02(idx);
            //db.skillStudent03(idx);
            System.out.println(db.skillStudent(idx));
            
                    for(int i = 1; i < 3;i++) {
                        var r = new Random();
                        int s = r.nextInt(5)+1;
                        ((AbsStudent)db.getStudent(idx)).addGrade(s);
                        
                
            }
                db.stalkStudent(idx);
                ((AbsStudent)db.getStudent(idx)).listGrades();
            }
            System.out.println("mezera");

        db.addGrade(0, 5);
        ((AbsStudent)db.getStudent(0)).listGrades();
        ((AbsStudent)db.getStudent(0)).setGrade(2, 1);;
        ((AbsStudent)db.getStudent(0)).listGrades();
        db.stalkStudent(0);
        ((AbsStudent)db.getStudent(0)).listGrades();
            
        db.addStudent(2, "haf", "hig", LocalDate.parse("2000-07-06"));
        db.addStudent(3, "dif", "fid", LocalDate.parse("2000-07-06"));
        db.addStudent(1, "asasas", "AaAbb", LocalDate.parse("2000-07-06"));
        db.addStudent(3, "asas", "sfa", LocalDate.parse("2000-07-06"));
        db.listOfStudents();
        //db.deleteStudent(0);
        //db.deleteStudent(4);
        //db.deleteStudent(2);
        //db.listOfStudents();
        db.addStudent(1, "as", "zasd", LocalDate.parse("2000-07-06"));
        db.addStudent(1, "as", "Aaaasd", LocalDate.parse("2000-07-06"));
        db.listOfStudents();
        db.sNameSort();
        //db.generalAverage();
        db.generalAvg();
        db.studentsInStudies();
        System.out.println(db.ActuallNumberOfStudents());
        System.out.println(((AbsStudent)db.getStudent(6)).getGrade(0));
        
        //db.saveDatabase("fileNameTest");
        
    }
}

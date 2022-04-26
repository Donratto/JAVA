package Program.AppTests;
import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;

import Program.Classes.AbsStudent;
import Program.javaDatabase.Database;

public class AppTestS3 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        var db = new Database(); 

        db.addStudent(1, "Alex", "Halex", LocalDate.parse("0000-07-06"));
        db.addStudent(2, "Blex", "Hblex", LocalDate.parse("1111-07-06"));
        db.addStudent(3, "Clex", "Hclex", LocalDate.parse("2222-07-06"));
        db.addStudent(1, "Dlex", "Hdlex", LocalDate.parse("3333-07-06"));
        db.addStudent(1, "Elex", "Helex", LocalDate.parse("4444-07-06"));
        db.addStudent(2, "Flex", "Hflex", LocalDate.parse("5555-07-06"));
        db.addStudent(3, "Hlex", "Hhlex", LocalDate.parse("6666-07-06"));
        db.addStudent(1, "Ilex", "Hilex", LocalDate.parse("8888-07-06"));
        db.addStudent(3, "Jlex", "Hjlex", LocalDate.parse("9999-07-06"));
        db.addStudent(3, "Klex", "Hklex", LocalDate.parse("9999-07-06"));
        
        
        for(int idx = 0; idx < Database.nextStudentId; idx++ ) {
            //db.skillStudent02(idx);
            //db.skillStudent03(idx);
            System.out.println(db.skillStudent(idx));
            
                    for(int i = 1; i < 4;i++) {
                        int d = (new Random()).nextInt(5)+1;
                        ((AbsStudent)db.getStudent(idx)).addGrade(d);
            }
                db.stalkStudent(idx);
                ((AbsStudent)db.getStudent(idx)).listGrades();
            }
            System.out.println("mezera");
            
        db.listOfStudents();
        db.deleteStudent(0);
        db.deleteStudent(4);
        db.deleteStudent(2);
        //db.listOfStudents();
        
        db.listOfStudents();
        db.sNameSort();
        //db.generalAverage();
        db.generalAvg();
        db.studentsInStudies();
        System.out.println(db.ActuallNumberOfStudents());

        db.saveDatabase("fileNameTest01");
        
    }
}


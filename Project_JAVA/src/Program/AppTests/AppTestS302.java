package Program.AppTests;
import java.util.Scanner;

import Program.javaDatabase.Database;

public class AppTestS302 {
    public static void main(String[] args) throws Exception {
        try (Scanner sc = new Scanner(System.in)) {
        }
        var db = new Database();
        db.loadDatabase("fileNameTest02");
        db.saveDatabase("fileNameTest01");
        System.out.print("actuall number of students: "+db.ActuallNumberOfStudents());
        System.err.println(" and id of next student: "+Database.nextStudentId);

        

        System.exit(0);
    }
}


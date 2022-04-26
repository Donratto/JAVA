package java.AppTests;
import java.javaDatabase.Database;
import java.util.Scanner;

public class AppTestS301 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        var db = new Database();
        db.loadDatabase("fileNameTest01");
        db.saveDatabase("fileNameTest02");
        System.out.print(db.ActuallNumberOfStudents());
        System.err.println(" and id of next student: "+Database.nextStudentId);

        

        System.exit(0);
    }
}


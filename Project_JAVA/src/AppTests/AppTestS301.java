package AppTests;
import java.time.LocalDate;
import java.util.Scanner;

import Classes.*;
import javaDatabase.Database;

public class AppTestS301 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        var db = new Database();
        db.loadDatabase("fileNameTest01");
        db.saveDatabase("fileNameTest01");
        

        System.exit(0);
    }
}


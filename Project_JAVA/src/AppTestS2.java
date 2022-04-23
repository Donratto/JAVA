import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;



public class AppTestS2 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        var db = new Database(); 

        db.addStudent(1, "Alex", "Halex", LocalDate.parse("2000-07-06"));
        db.addStudent(2, "Blex", "Hblex", LocalDate.parse("2000-07-06"));
        db.addStudent(3, "Clex", "Hclex", LocalDate.parse("2000-07-06"));

        
        
        for(int idx = 0; idx < 3; idx++ ) {
            System.out.println(db.skillStudent03(idx));
            //db.skillStudent02(idx);
            //db.skillStudent03(idx);

            if(idx==1) {
                    for(int i = 1; i <= 10;i++) {
                    ((AbsStudent)db.getStudent(idx)).addGrade(((i*idx)%5)+1);
                }
            }
                else {
                    for(int i = 10; i >= 1;i--) {
                        var r = new Random();
                        int s = r.nextInt(5)+1;
                        ((AbsStudent)db.getStudent(idx)).addGrade(s);
                }
            }
                db.stalkStudent(idx);
                ((AbsStudent)db.getStudent(idx)).listGrades();
            }
        
        //((AbsStudent)db.getStudent(0)).listGrades();
    }
}

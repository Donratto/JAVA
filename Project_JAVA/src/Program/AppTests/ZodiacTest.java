package Program.AppTests;
import java.time.LocalDate;
import java.util.Random;

import Program.javaDatabase.Database;

public class ZodiacTest {


    public static void main(String[] args) {
        var db = new Database();
        LocalDate dateHelp;
        String birthDate;
        int d = 1;
        d = radnomNonLeapYear();
        
        /*if (((d%4!=0) && (d%100==0)) || d%400!=0) {
        d = (new Random()).nextInt(8999)+1000;
        } */




        for (int i = 1; i <= 365; i++) {
            d = radnomNonLeapYear();
            if(i<=31) {
                birthDate = String.format("%d-01-%02d",d,i);
            } else if (i<=31+28) {
                birthDate = String.format("%d-02-%02d",d,i-31);
            }else if (i<=31+28+31) {
                birthDate = String.format("%d-03-%02d",d,i-(31+28));
            }else if (i<=31+28+31+30) {
                birthDate = String.format("%d-04-%02d",d,i-(31+28+31));
            }else if (i<=31+28+31+30+31) {
                birthDate = String.format("%d-05-%02d",d,i-(31+28+31+30));
            }else if (i<=31+28+31+30+31+30) {
                birthDate = String.format("%d-06-%02d",d,i-(31+28+31+30+31));
            }else if (i<=31+28+31+30+31+30+31) {
                birthDate = String.format("%d-07-%02d",d,i-(31+28+31+30+31+30));
            }else if (i<=31+28+31+30+31+30+31+31) {
                birthDate = String.format("%d-08-%02d",d,i-(31+28+31+30+31+30+31));
            }else if (i<=31+28+31+30+31+30+31+31+30) {
                birthDate = String.format("%d-09-%02d",d,i-(31+28+31+30+31+30+31+31));
            }else if (i<=31+28+31+30+31+30+31+31+30+31) {
                birthDate = String.format("%d-10-%02d",d,i-(31+28+31+30+31+30+31+31+30));
            }else if (i<=31+28+31+30+31+30+31+31+30+31+30) {
                birthDate = String.format("%d-11-%02d",d,i-(31+28+31+30+31+30+31+31+30+31));
            }else {
                birthDate = String.format("%d-12-%02d",d,i-(31+28+31+30+31+30+31+31+30+31+30));
            }
            dateHelp = LocalDate.parse(birthDate);
            db.addStudent(2, "firstName", "secondName", dateHelp);
            
            
            System.err.println(dateHelp.getDayOfYear()+" "+dateHelp+" -> "+db.skillStudent(i-1));
        }



    }

    public static int radnomNonLeapYear() {
        int _d = 0;
        _d = (new Random()).nextInt(8999)+1000;
        if ((((_d%4==0) && (_d%100!=0)) || _d%400==0)) {
            _d = radnomNonLeapYear();
        }
        return _d;
    }

    
    


}

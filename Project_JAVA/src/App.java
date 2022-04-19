import java.time.LocalDate;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hello, World!");

//test technik 
        /*
        var Alex = new TechnicalStudy(1, "Alex", "Halex", DateInput(sc) );


        System.out.println(Alex.getBirthDate()); 
        System.out.println(Alex.getSecondtName()); 
        System.out.println(Alex.getFirstName()); 
        System.out.println(Alex.getId()); 
        System.out.println();
        for (int i = 0; i < 4; i++) {
        System.out.println("enter grade number " + (i+1));
        Alex.addGrade(IntInput(sc));
        }
        System.out.println();
        System.out.println(Alex.getAverage());
        System.out.println();
        System.out.println(Alex.isLeapYear_Birth(Alex.getBirthDate()));
        */


//test humanic 
        /*
        var Petržel = new HumanitarianStudy(2, "Petržel", "Halex", DateInput(sc) );


        System.out.println(Petržel.getBirthDate()); 
        System.out.println();
        for (int i = 0; i < 4; i++) {
        System.out.println("enter grade number " + (i+1));
        Petržel.addGrade(IntInput(sc));
        }
        System.out.println();
        System.out.println(Petržel.getAverage());
        System.out.println();
        System.out.println(Petržel.isZodiacSign(Petržel.getBirthDate()));
        */

//test combowombo
        /*
        var Kfjetina = new CombinedStudy(3, "Kfjetina", "Halex", DateInput(sc) );


        System.out.println(Kfjetina.getBirthDate()); 
        System.out.println();
        for (int i = 0; i < 4; i++) {       //unhadled wrong input(will skip and add '0' to LinkedList)
        System.out.println("enter grade number " + (i+1));
        Kfjetina.addGrade(IntInput(sc));
        }
        System.out.println();
        System.out.println(Kfjetina.getAverage());
        System.out.println();
        System.out.println(Kfjetina.isLeapYear_Birth(Kfjetina.getBirthDate()));
        System.out.println();
        System.out.println(Kfjetina.isZodiacSign(Kfjetina.getBirthDate()));
        */


    }

    






    public static int IntInput(Scanner sc) 
	{
		int number = 0;
		try
		{
			number = sc.nextInt();
		}
		catch(Exception e)
		{
			System.out.println("Exception has occured: "+e.toString());
			System.out.printf("Enter only integers: \t");
			sc.nextLine();
			number = IntInput(sc);
		}
		return number;
	}

    public static LocalDate DateInput(Scanner sc) 
	{
		LocalDate date = null;
		try
		{
			date = LocalDate.parse(sc.next());
		}
		catch(Exception e)
		{
			System.out.println("Exception has occured: "+e.toString());
			System.out.printf("Wrong format of date\nuse format: 'yyyy-mm-dd'\n");
			sc.nextLine();
			date = DateInput(sc);
		}
		return date;
	}
}

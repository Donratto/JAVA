import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AppTestS1 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hello, World!");

//test technik 
        
        //var Alex = new TechnicalStudy(1, "Alex", "Halex", DateInput(sc) );
        var Alex = new TechnicalStudy(1, "Alex", "Halex", LocalDate.parse("2000-07-06") );


        System.out.println(Alex.getBirthDate()); 
        System.out.println(Alex.getSecondtName()); 
        System.out.println(Alex.getFirstName()); 
        System.out.println(Alex.getId()); 
        System.out.println();
        /*
        for (int i = 0; i < 4; i++) {
        System.out.println("enter grade number " + (i+1));
        Alex.addGrade(IntInput(sc,1));
        }
        */
        Alex.addGrade(AbsStudent.IntInput(sc,1));
        System.out.println();
        System.out.println(Alex.getAverage());
        System.out.println();
        System.out.println(Alex.isLeapYear_Birth(Alex.getBirthDate()));
        System.out.println();
        for (int i = 0; i < Alex.sizeGrades(); i++) {
            System.out.println(Alex.getGrade(i));
        }
        /*
        System.out.println("deletion of index 1"); Alex.deleteGrade(1);
        for (int i = 0; i < 4; i++) {
            System.out.println(Alex.getGrade(i));
        }
        System.out.println("set grade on index 1 to 4"); Alex.setGrade(1, 4);
        

        for (int i = 0; i < 4; i++) {
            System.out.println(Alex.getGrade(i));
        }
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

    /*
    public static int IntInput(Scanner sc, int i) 
	{
		int number = 0;
		try
		{
            System.out.printf("enter int: ");
            number = sc.nextInt();
            if((number < 1 || number > 5)) {
                throw new grade_exception();
            } 
		}
		catch(InputMismatchException e)
		{
			System.out.println("Exception has occured: "+e.toString());
			System.out.printf("Enter only integers: \n");
			sc.nextLine();
			number = IntInput(sc,1);
		}
        catch(grade_exception e) 
        {
            System.out.println("chytám: " +e.toString());
            System.out.printf("Enter only one number from: {1, 2, 3, 4, 5}: \n");
            sc.nextLine();
            number = IntInput(sc,1);
        }
		return number;
	}
    
    public static int IntInput(Scanner sc, int i) 
	{
		int number = 0;
		try
		{
            System.out.println("enter int");
            number = sc.nextInt();
            if((number < 1 || number > 5)) {
                System.out.println("hážu!");
                System.out.printf("Enter only x<=5 && x>=1: \t");
                sc.nextLine();
                number = IntInput(sc, 1);
            
            } 
		}
		catch(InputMismatchException e)
		{
			System.out.println("Exception has occured: "+e.toString());
			System.out.printf("Enter only integers: \t");
			sc.nextLine();
			number = IntInput(sc, 1);
		}
        
		return number;
	}
    */
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

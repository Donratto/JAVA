package Program.Classes;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

import Program.Exceptions.inputRangeExceptions;

public abstract class AbsStudent {
    
    private int id;
    private String firstName;
    private String secondName;
    private LocalDate birthDate;
    private LinkedList<Integer> grades;
    

    public AbsStudent(int id, String firstName, String secondName, LocalDate birthDate) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.birthDate = birthDate;
        this.grades = new LinkedList<Integer>();
    }


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String name) {
        this.firstName = name;
    }

    public String getSecondName() {
        return secondName;
    }
    public void setSecondName(String name) {
        this.secondName = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(String date) {
        try {
        this.birthDate = LocalDate.parse(date);
        }
        catch (Exception e) {
            System.err.println("Wrong format of date\nuse format: 'yyyy-mm-dd'");
        }
    }
    public void setBirthDate(LocalDate date) {
        this.birthDate = date;
    }

    public Integer getGrade(Integer idx) {
        try {
        return grades.get(idx);
        } catch(IndexOutOfBoundsException e) {
            return null;
        }
    }
    public void setGrade(Integer idx, Integer number) throws inputRangeExceptions{
        if(number >= 1 && number <= 5) {
            this.grades.set(idx, number);
        }
        else {
            badInput();
        }
    }
    public void addGrade(Integer number) {
        //System.out.println("převzato: "+number);
        if(number >= 1 && number <= 5) {
            this.grades.add(number);
        }
        else {
            badInput();
        }
        
    }
    public void deleteGrade(int idx) {
        this.grades.remove(idx);
    }
    public int sizeGrades() {
        return grades.size();
    }
    public void listGrades() {
        for (int i = 0; i < grades.size(); i++) {
            System.out.print(grades.get(i)+" ");
        }
        System.out.println();
    }
    public String getGrades() {
        String stringOfGrades = "";
        String space = " ";
        for (int i = 0; i < grades.size(); i++) {
            stringOfGrades = stringOfGrades + grades.get(i);
            if(i!=grades.size()-1) stringOfGrades = stringOfGrades + space;
        }
        return stringOfGrades;
    }
    
    /*
    public double getAverage() {
        double sumGrades = 0;
        try{
        for (int i = 0; i < grades.size(); i++) {
            sumGrades += grades.get(i);
        }
        return sumGrades/(grades.size());
    } catch(Exception e){
        System.out.println(e.toString());
        return 0;
    }
    }
    */

    public double getAverage() {
        double sumGrades = 0;
        if (grades.size()==0) return 0;
        try{
        for (int i = 0; i < grades.size(); i++) {
            sumGrades += grades.get(i);
        }
        return sumGrades/(grades.size());
    } catch(ArithmeticException e){
        return 0;
    } catch(NullPointerException e) {
        return 0;
    }
    }



    private void badInput() {
        System.err.println("Enter only one number from: {1, 2, 3, 4, 5}");
    }

    public static int IntInput(Scanner sc, int maxNumber, int minNumber) {
		int number = 0;
		try {
            number = sc.nextInt();
            if((number < minNumber || number > maxNumber)) {
                    throw new inputRangeExceptions();
                }
           
		}
		catch(InputMismatchException e) {
			System.out.println("Exception has occured: "+e.toString());
			System.out.printf("Enter only integers! \n");
			sc.nextLine();
			number = IntInput(sc,maxNumber,minNumber);
		}
        catch(inputRangeExceptions e) {
            System.out.println("chytám: " +e.toString());
            StringBuilder stringExcp = new StringBuilder("Enter only one number from: {");
            for(int i = minNumber; i <= maxNumber; i++) {
                stringExcp.append(i);
                if(i!=maxNumber) stringExcp.append(" ");
            }
            stringExcp.append("}\n");
            System.out.println(stringExcp);
            sc.nextLine();
            number = IntInput(sc,maxNumber,minNumber);
        }
		return number;
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
			System.out.printf("Enter only integers: \n");
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

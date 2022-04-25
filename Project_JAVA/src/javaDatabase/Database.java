package javaDatabase;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

import Classes.AbsStudent;
import Classes.CombinedStudy;
import Classes.HumanitarianStudy;
import Classes.TechnicalStudy;


public class Database {
    
    private HashMap<Integer, Object> TheDatabase;
    public static int numberOfStudents = 0;

    public Database() {
        TheDatabase = new HashMap<Integer, Object>();
    }


    public Object getStudent(int id) {
      return TheDatabase.get(id);
    }

    //a)

    public void addStudent(int i, String firstName, String secondName, LocalDate birthDate) {
      int id = numberOfStudents++;
      switch (i) {
        case (1): TheDatabase.put(id, new TechnicalStudy(id, firstName, secondName, birthDate)); break;
        case (2): TheDatabase.put(id, new HumanitarianStudy(id, firstName, secondName, birthDate)); break;
        case (3): TheDatabase.put(id, new CombinedStudy(id, firstName, secondName, birthDate)); break;
        default : System.out.println("invalid type of study"); break;
    }
  }

    //b)

    public void addGrade(int id, int number) {
      ((AbsStudent)TheDatabase.get(id)).addGrade(number);
    }

    //c)

  public void deleteStudent(int id) {
    try {
      TheDatabase.remove(id);
    } catch (Exception e) {
      System.out.println("student of index "+id+" doesn't exist");
    }
    
  }
    

    //d)?
    
    public void stalkStudent(int id) {
      if(((AbsStudent)getStudent(id))!=null) {
        String fName = ((AbsStudent)getStudent(id)).getFirstName();
        String sName = ((AbsStudent)getStudent(id)).getSecondName();
        String birthYear = ""+((AbsStudent)TheDatabase.get(id)).getBirthDate().getYear();
        double avg = ((AbsStudent) TheDatabase.get(id)).getAverage();
        String type = TheDatabase.get(id).getClass().toString();
        System.out.printf("Student: {ID=%d} {firstname=%s} {secondname=%s} {year of birth=%s} {average grade=%4.3f} {type=%s}",id,fName,sName,birthYear,avg,type);
      }
    }
    
    public void listOfStudents() {
      
      for (int id = 0; id < numberOfStudents; id++) {
        if (((AbsStudent)getStudent(id))!=null) {
          String fName = ((AbsStudent)getStudent(id)).getFirstName();
          String sName = ((AbsStudent)getStudent(id)).getSecondName();
          String birthYear = ""+((AbsStudent)TheDatabase.get(id)).getBirthDate().getYear();
          double avg = ((AbsStudent) TheDatabase.get(id)).getAverage();
          String type = TheDatabase.get(id).getClass().getSimpleName();
          System.out.printf("Student: {ID=%d} {firstname=%s} {secondname=%s} {year of birth=%s} {average grade=%4.3f} {type=%s}\n",id,fName,sName,birthYear,avg,type);
        } 
      }
        
    }



    /*
    public void  skillStudent01(int id) {
      var type = getStudent(id).getClass().getSimpleName();
      switch(type) {
        case("CombinedStudy"): 
          ((CombinedStudy) getStudent(id)).isLeapYear_Birth(((AbsStudent) getStudent(id)).getBirthDate());
        case("HumanitarianStudy"):
          ((HumanitarianStudy) getStudent(id)).isZodiacSign(((AbsStudent) getStudent(id)).getBirthDate());
          break;
        case("TechnicalStudy"):
        ((TechnicalStudy) getStudent(id)).isLeapYear_Birth(((AbsStudent) getStudent(id)).getBirthDate());
      }
      
    }
    
    public void skillStudent02(int id) {
      var type = getStudent(id).getClass().getSimpleName();
      if(type == "CombinedStudy") {
        ((CombinedStudy) getStudent(id)).isLeapYear_Birth(((AbsStudent)getStudent(id)).getBirthDate());
        ((CombinedStudy) getStudent(id)).isZodiacSign(((AbsStudent) getStudent(id)).getBirthDate());
      } else if(type == "HumanitarianStudy") {
        ((HumanitarianStudy) getStudent(id)).isZodiacSign(((AbsStudent) getStudent(id)).getBirthDate());
      }else if(type == "TechnicalStudy"){
        ((TechnicalStudy) getStudent(id)).isLeapYear_Birth(((AbsStudent) getStudent(id)).getBirthDate());
      }
    }
    */
    
    //e)
    
    public String skillStudent03(int id) {
      var type = getStudent(id);
      String internal01 = "";
      String internal02 = "";

      if(type instanceof CombinedStudy) {
        internal01 = ""+ ((CombinedStudy) getStudent(id)).isLeapYear_Birth(((AbsStudent)getStudent(id)).getBirthDate());
        internal02 = ""+ ((CombinedStudy) getStudent(id)).isZodiacSign(((AbsStudent) getStudent(id)).getBirthDate());
        return "Birth year is a leapyear: "+internal01+"\nZodiac sign is: "+internal02;
      } else if(type instanceof HumanitarianStudy) {
        internal02 = ""+ ((HumanitarianStudy) getStudent(id)).isZodiacSign(((AbsStudent) getStudent(id)).getBirthDate());
        return "Zodiac sign is: "+internal02;
      }else if(type instanceof TechnicalStudy){
        internal01 = ""+ ((TechnicalStudy) getStudent(id)).isLeapYear_Birth(((AbsStudent) getStudent(id)).getBirthDate());
        return "Birth year is a leapyear: "+internal01;
      }

      return "Birth year is leapyear: "+internal01;
    }

    //f)

    public void sNameSort() {
      ArrayList<TechnicalStudy> technicalStudies = new ArrayList<>();
      ArrayList<HumanitarianStudy> humanitarianStudies = new ArrayList<>();
      ArrayList<CombinedStudy> combinedStudies = new ArrayList<>();
      for(int id = 0; id < numberOfStudents; id++) {
        if(getStudent(id) instanceof TechnicalStudy) {
          technicalStudies.add((TechnicalStudy) getStudent(id));
        } else if (getStudent(id) instanceof HumanitarianStudy) {
          humanitarianStudies.add((HumanitarianStudy) getStudent(id));
        } else if (getStudent(id) instanceof CombinedStudy) {
          combinedStudies.add((CombinedStudy) getStudent(id));
        }
      }
      technicalStudies.sort((o1, o2) -> o1.getSecondName().compareTo(o2.getSecondName()));
      System.err.println("Students of Technical Studies:");
        for (TechnicalStudy student: technicalStudies){
          System.out.printf("Student: {ID=%d} {firstname=%s} {secondname=%s} {year of birth=%s} {average grade=%4.3f}\n",student.getId(),student.getFirstName(),student.getSecondName(),student.getBirthDate(),student.getAverage());
      }
      humanitarianStudies.sort((o1, o2) -> o1.getSecondName().compareTo(o2.getSecondName()));
      System.err.println("Students of Humanitarian Studies:");
        for (HumanitarianStudy student: humanitarianStudies){
          System.out.printf("Student: {ID=%d} {firstname=%s} {secondname=%s} {year of birth=%s} {average grade=%4.3f}\n",student.getId(),student.getFirstName(),student.getSecondName(),student.getBirthDate(),student.getAverage());
      }
      combinedStudies.sort((o1, o2) -> o1.getSecondName().compareTo(o2.getSecondName()));
      System.err.println("Students of Combined Studies:");
        for (CombinedStudy student: combinedStudies){
          System.out.printf("Student: {ID=%d} {firstname=%s} {secondname=%s} {year of birth=%s} {average grade=%4.3f}\n",student.getId(),student.getFirstName(),student.getSecondName(),student.getBirthDate(),student.getAverage());
      }
    }
  
    
    //g)
    
    public void generalAverage() {
      double sumTech=0, sumHum= 0;
      int numberOfTech=0, numberOfHum=0;
      for(int id = 0; id < numberOfStudents; id++) {
        if(getStudent(id)==null) continue;
        if (getStudent(id) instanceof TechnicalStudy || getStudent(id) instanceof CombinedStudy) {
          if(!(((AbsStudent)getStudent(id)).getAverage()==0)) { 
            sumTech =+ (Double)((AbsStudent)getStudent(id)).getAverage();
            System.out.println("debilTECH "+id+" "+((AbsStudent)getStudent(id)).getAverage());
            numberOfTech++; }
        } else if (getStudent(id) instanceof HumanitarianStudy || getStudent(id) instanceof CombinedStudy) {
          if(!(((AbsStudent)getStudent(id)).getAverage()==0)) {
            sumHum =+ (double)((AbsStudent)getStudent(id)).getAverage();
            System.out.println("debilHUM "+id+" "+((AbsStudent)getStudent(id)).getAverage());
            numberOfHum++; }
        }
      }
      try {
      if(numberOfTech>0) {
          System.out.printf("General average grades from Technical Studies is: %4.3f\n", ((Double)sumTech/numberOfTech));
      } else {
        System.out.println("There are no students in Technical Studies");
      }
      if(numberOfHum>0) { 
        System.out.printf("General average grades from Humanitarian Studies is: %4.3f\n", ((Double)sumHum/numberOfHum));
      } else {
        System.out.println("There are no students in Humanitarian Studies");
      }
      } catch(Exception e) {
        System.out.println("buf!!");
        System.err.println(e.toString());
        System.out.println(numberOfTech);
        System.out.println(sumTech);
        System.out.println(numberOfHum);
        System.out.println(sumHum);
      }
    }
    
    public void generalAvgTech() {
      int numberTech = 0, numberHum = 0;
      double sumTech = 0.0, sumHum =0.0;
      double prumTech = 0, prumHum = 0;
      for(int id = 0; id < numberOfStudents; id++) {
        if(getStudent(id)==null) continue;
        if(((AbsStudent)getStudent(id)).getAverage()==0) continue;
        if((getStudent(id) instanceof TechnicalStudy) || (getStudent(id) instanceof CombinedStudy)) {
          numberTech++;
          sumTech = sumTech + ((AbsStudent)getStudent(id)).getAverage();
          //System.out.println("Tech pridano "+numberTech +" a prumer: "+((AbsStudent)getStudent(id)).getAverage()+" to je "+sumTech);
          prumTech = sumTech/numberTech;
        } 
        if((getStudent(id) instanceof HumanitarianStudy) || (getStudent(id) instanceof CombinedStudy)) {
          numberHum++;
          sumHum = sumHum + ((AbsStudent)getStudent(id)).getAverage();
          //System.out.println("Hum pridano "+numberHum +" a prumer: "+((AbsStudent)getStudent(id)).getAverage()+" to je "+sumHum);
          prumHum = sumHum/numberHum;
        }
      }
        if(numberTech!=0) {
          //System.out.println("prumTech: "+prumTech);
          System.out.printf("General average grades from Technical Studies is: %4.3f\n", prumTech);
          
      } else {
        System.out.println("There are no students in Technical Studies");
      }
      if(numberHum!=0) {
        //System.out.println("prumHum: "+prumHum);
        System.out.printf("General average grades from Humanitarian Studies is: %.3f\n", prumHum);
      } else {
        System.out.println("There are no students in Humanitarian Studies");
      }
    }
  }

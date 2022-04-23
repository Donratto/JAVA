import java.time.LocalDate;
import java.util.HashMap;

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
        String fName = ((AbsStudent)getStudent(id)).getFirstName();
        String sName = ((AbsStudent)getStudent(id)).getSecondName();
        String birthYear = ""+((AbsStudent)TheDatabase.get(id)).getBirthDate().getYear();
        double avg = ((AbsStudent) TheDatabase.get(id)).getAverage();
        String type = TheDatabase.get(id).getClass().toString();
        if(((AbsStudent)getStudent(id))!=null) System.out.printf("Student: {ID=%d} {firstname=%s} {secondname=%s} {year of birth=%s} {average grade=%4.3f} {type=%s}",id,fName,sName,birthYear,avg,type);
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
      
    }
  
  }

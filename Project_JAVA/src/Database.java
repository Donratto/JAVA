import java.time.LocalDate;
import java.util.HashMap;

public class Database {
    
    private HashMap<Integer, Object> TheDatabase;
    static int numberOfStudents = 0;

    public Database() {
        TheDatabase = new HashMap<Integer, Object>();
    }


    public Object getStudent(int id) {
      return TheDatabase.get(id);
    }
    public void addStudent(int i, String firstName, String secondName, LocalDate birthDate) {
      int id = numberOfStudents++;
      switch (i) {
        case (1): TheDatabase.put(id, new TechnicalStudy(id, firstName, secondName, birthDate)); break;
        case (2): TheDatabase.put(id, new HumanitarianStudy(id, firstName, secondName, birthDate)); break;
        case (3): TheDatabase.put(id, new CombinedStudy(id, firstName, secondName, birthDate)); break;
    }
  }

  public void deleteStudent(int id) {
    try {
      TheDatabase.remove(id);
      numberOfStudents--;
    } catch (Exception e) {
      System.out.println("student of index "+id+" doesn't exist");
    }
    
  }

    public void addGrade(int id, int number) {
      ((AbsStudent)TheDatabase.get(id)).addGrade(number);
    }

    public void stalkStudent(int id) {
      String fName = ((AbsStudent)getStudent(id)).getFirstName();
      String sName = ((AbsStudent)getStudent(id)).getSecondName();
      String birthYear = ""+((AbsStudent)TheDatabase.get(id)).getBirthDate().getYear();
      double avg = ((AbsStudent)TheDatabase.get(id)).getAverage();
      System.out.printf("Student: {ID=%d} {firstname=%s} {secondname=%s} {year of birth=%s} {average grade=%4.3f}",id,fName,sName,birthYear,avg);
    }
    
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


  
  }

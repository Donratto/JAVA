package javaDatabase;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

import Classes.AbsStudent;
import Classes.CombinedStudy;
import Classes.HumanitarianStudy;
import Classes.TechnicalStudy;


public class Database {
    
    private HashMap<Integer, Object> TheDatabase;
    public static int nextStudentId = 0;

    public Database() {
        TheDatabase = new HashMap<Integer, Object>();
    }


    public Object getStudent(int id) {
      return TheDatabase.get(id);
    }

    private void printStudent(int id, Boolean study) {
        String fName = ((AbsStudent)getStudent(id)).getFirstName();
        String sName = ((AbsStudent)getStudent(id)).getSecondName();
        String birthYear = ""+((AbsStudent)TheDatabase.get(id)).getBirthDate().getYear();
        double avg = ((AbsStudent) TheDatabase.get(id)).getAverage();
        String type="";
        if (study) {
        type = " {type="+TheDatabase.get(id).getClass().getSimpleName()+"}";
        }
        System.out.printf("Student: {ID=%d} {firstname=%s} {secondname=%s} {year of birth=%s} {average grade=%4.3f}%s\n",id,fName,sName,birthYear,avg,type);
    }

    private String printStudent1(int id) {
      String fName = ((AbsStudent)getStudent(id)).getFirstName();
      String sName = ((AbsStudent)getStudent(id)).getSecondName();
      String birthYear = ""+((AbsStudent)TheDatabase.get(id)).getBirthDate().getYear();
      double avg = ((AbsStudent) TheDatabase.get(id)).getAverage();
      String type=" {type="+TheDatabase.get(id).getClass().getSimpleName()+"}";
      return String.format("Student: {ID=%d} {firstname=%s} {secondname=%s} {year of birth=%s} {average grade=%4.3f}%s\n",id,fName,sName,birthYear,avg,type);
    }

    private String printStudent(int id) {
      String fName = ((AbsStudent)getStudent(id)).getFirstName();
      String sName = ((AbsStudent)getStudent(id)).getSecondName();
      String birthYear = ((AbsStudent)TheDatabase.get(id)).getBirthDate().toString();
      double avg = ((AbsStudent) TheDatabase.get(id)).getAverage();
      String type = TheDatabase.get(id).getClass().getSimpleName();
      return String.format("%d;%s;%s;%s;%4.3f;%s",id,fName,sName,birthYear,avg,type);
    }

    public int ActuallNumberOfStudents() {
      int AcNmbStud = 0;
      for (int id = 0; id < nextStudentId; id++) {
        if (((AbsStudent)getStudent(id))!=null) {
          AcNmbStud++;
        }
      }
      return AcNmbStud;
    }


    //a)

    public void addStudent(int typeOfStudy, String firstName, String secondName, LocalDate birthDate) {
      int id = nextStudentId++;
      switch (typeOfStudy) {
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
    
    public void stalkStudent1(int id) {
      if(((AbsStudent)getStudent(id))!=null) {
        String fName = ((AbsStudent)getStudent(id)).getFirstName();
        String sName = ((AbsStudent)getStudent(id)).getSecondName();
        String birthYear = ""+((AbsStudent)TheDatabase.get(id)).getBirthDate().getYear();
        double avg = ((AbsStudent) TheDatabase.get(id)).getAverage();
        String type = TheDatabase.get(id).getClass().getSimpleName();
        System.out.printf("Student: {ID=%d} {firstname=%s} {secondname=%s} {year of birth=%s} {average grade=%4.3f} {type=%s}",id,fName,sName,birthYear,avg,type);
      }
    }

    public void stalkStudent(int id) {
      if(((AbsStudent)getStudent(id))!=null) {
        printStudent(id,true);
      }
    }
    
    

    public void listOfStudents1() {
      
      for (int id = 0; id < nextStudentId; id++) {
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
    public void listOfStudents() {
      
      for (int id = 0; id < nextStudentId; id++) {
        if (((AbsStudent)getStudent(id))!=null) {
          printStudent(id, false);
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
    
    public String skillStudent(int id) {
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

    public String skillStudentSmazat(int id) {
      var type = getStudent(id);
      String internal01 = "";
      String internal02 = "";

      if(type instanceof CombinedStudy) {
        internal01 = ""+ ((CombinedStudy) getStudent(id)).isLeapYear_Birth(((AbsStudent)getStudent(id)).getBirthDate());
        internal02 = ""+ ((CombinedStudy) getStudent(id)).isZodiacSign(((AbsStudent) getStudent(id)).getBirthDate());
        return "Birth year is a leapyear: "+internal01+"\nZodiac sign is: "+internal02;
      } else if(type instanceof HumanitarianStudy) {
        internal02 = ""+ ((HumanitarianStudy) getStudent(id)).isZodiacSignSmazat(((AbsStudent) getStudent(id)).getBirthDate());
        return "Zodiac sign is: "+internal02;
      }else if(type instanceof TechnicalStudy){
        internal01 = ""+ ((TechnicalStudy) getStudent(id)).isLeapYear_Birth(((AbsStudent) getStudent(id)).getBirthDate());
        return "Birth year is a leapyear: "+internal01;
      }

      return "Birth year is leapyear: "+internal01;
    }

    //f)

    /*
    public void sNameSort1() {
      ArrayList<TechnicalStudy> technicalStudies = new ArrayList<>();
      ArrayList<HumanitarianStudy> humanitarianStudies = new ArrayList<>();
      ArrayList<CombinedStudy> combinedStudies = new ArrayList<>();
      for(int id = 0; id < nextStudentId; id++) {
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
          System.out.printf("Student: {ID= %d} {firstname= %s} {secondname=%s} {year of birth=%s} {average grade=%4.3f}\n",student.getId(),student.getFirstName(),student.getSecondName(),student.getBirthDate(),student.getAverage());
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
  */
    public void sNameSort() {
      ArrayList<TechnicalStudy> technicalStudies = new ArrayList<>();
      ArrayList<HumanitarianStudy> humanitarianStudies = new ArrayList<>();
      ArrayList<CombinedStudy> combinedStudies = new ArrayList<>();
      for(int id = 0; id < nextStudentId; id++) {
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
          printStudent(student.getId(), false);
      }
      humanitarianStudies.sort((o1, o2) -> o1.getSecondName().compareTo(o2.getSecondName()));
      System.err.println("Students of Humanitarian Studies:");
        for (HumanitarianStudy student: humanitarianStudies){
          printStudent(student.getId(), false);
      }
      combinedStudies.sort((o1, o2) -> o1.getSecondName().compareTo(o2.getSecondName()));
      System.err.println("Students of Combined Studies:");
        for (CombinedStudy student: combinedStudies){
          printStudent(student.getId(), false);
      }
    }


    
    //g)
    /*
    public void generalAverage() {
      double sumTech=0, sumHum= 0;
      int numberOfTech=0, numberOfHum=0;
      for(int id = 0; id < nextStudentId; id++) {
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
    */
    public void generalAvg() {
      int numberTech = 0, numberHum = 0;
      double sumTech = 0.0, sumHum =0.0;
      for(int id = 0; id < nextStudentId; id++) {
        if(getStudent(id)==null) continue;
        if(((AbsStudent)getStudent(id)).getAverage()==0) continue;
        if((getStudent(id) instanceof TechnicalStudy) || (getStudent(id) instanceof CombinedStudy)) {
          numberTech++;
          sumTech = sumTech + ((AbsStudent)getStudent(id)).getAverage();
          //System.out.println("Tech pridano "+numberTech +" a prumer: "+((AbsStudent)getStudent(id)).getAverage()+" to je "+sumTech);
        } 
        if((getStudent(id) instanceof HumanitarianStudy) || (getStudent(id) instanceof CombinedStudy)) {
          numberHum++;
          sumHum = sumHum + ((AbsStudent)getStudent(id)).getAverage();
          //System.out.println("Hum pridano "+numberHum +" a prumer: "+((AbsStudent)getStudent(id)).getAverage()+" to je "+sumHum);
        }
      }
        if(numberTech!=0) {
          //System.out.println("prumTech: "+prumTech);
          System.out.printf("General average grades from Technical Studies is: %4.3f\n", sumTech/numberTech);
          
      } else {
        System.out.println("There are no students in Technical Studies");
      }
      if(numberHum!=0) {
        //System.out.println("prumHum: "+prumHum);
        System.out.printf("General average grades from Humanitarian Studies is: %.3f\n", sumHum/numberHum);
      } else {
        System.out.println("There are no students in Humanitarian Studies");
      }
    }

    //h)

    public void studentsInStudies() {
      int numberTech = 0, numberHum = 0, numberCom = 0;
      for(int id = 0; id < nextStudentId; id++) {
        if(getStudent(id)==null) continue;
        if(getStudent(id) instanceof TechnicalStudy) {
          numberTech++;
        } else if (getStudent(id) instanceof HumanitarianStudy) {
          numberHum++;
        } else if(getStudent(id) instanceof CombinedStudy) {
          numberCom++;
        }
      }
      System.out.printf("Number of students in studies\nTechnical: %d\nHumanitarian: %d\nCombined: %d\n",numberTech,numberHum,numberCom);
    }


    //i)  
    
    public void loadDatabase(String fileName) {
      //System.out.println("step 0");
      FileReader fReader = null;
      BufferedReader bfReader = null;
      try {
        //System.out.println("step 1");
        fReader = new FileReader(fileName+".txt");
        //System.out.println("step 2");
        bfReader = new BufferedReader(fReader);
        //System.out.println("step 3");
        String oneLine = bfReader.readLine();
        String seppartor1 = " ",seppartor2 = ";";
        String firstName, secondName, type;
        int id;
        LocalDate birthDate;
        String[] entry = oneLine.split(seppartor1);
        //System.out.println("geegee");
        int amount = Integer.parseInt(entry[1]);
        if (entry.length == 2) {
          //System.out.println("step 4");
          System.out.println("Amount of students in database "+fileName+" is "+amount);
        }
        for(int i = 0; i < amount; i++) {
          oneLine = bfReader.readLine();
          //System.out.println("step 5");
          entry = oneLine.split(seppartor2);
          //System.out.println(entry[6]);
          //System.out.println("step 6");
          //System.out.println(entry.length);
          id = Integer.parseInt(entry[0]);
          firstName = entry[1];
            secondName = entry[2];
            birthDate = LocalDate.parse(entry[3]);
            type = entry[5];
          if (id != nextStudentId) {System.out.println("adding to nmbStudens: "+nextStudentId+ " ->"+" id: "+id);nextStudentId=id;}
          if (entry.length == 7) {
            
            switch(type) {
              case "TechnicalStudy": addStudent(1, firstName, secondName, birthDate);
                break;
              case "HumanitarianStudy": addStudent(2, firstName, secondName, birthDate);
                break;
              case "CombinedStudy": addStudent(3, firstName, secondName, birthDate); 
                break;
              default : System.out.println("invalid type of study"); 
                break;
            }
            entry = entry[6].split(seppartor1);
            }
            for (int y = 0; y < entry.length; y++) {
              ((AbsStudent)getStudent(id)).addGrade(Integer.parseInt(entry[y]));
            }
            
            
          }
        
        

      } catch (Exception e) {
        System.out.println("weeee, i am falling");
        System.out.println("and why? you ask\nthis is why: " + e.toString());
      
      }
    }


    //j)

    public void saveDatabase(String fileName) {
      try {
        FileWriter fWriter = new FileWriter(fileName + ".txt");
        BufferedWriter bWriter = new BufferedWriter(fWriter);
        //bWriter.write(new String("Amount of students: " + ActuallNumberOfStudents()));
        bWriter.write(new String("AmountOfStudents " + ActuallNumberOfStudents()));
        bWriter.newLine();
        for (int id = 0; id < nextStudentId; id++) {
          if (((AbsStudent)getStudent(id))!=null) {
            bWriter.write(printStudent(id));
            if(((AbsStudent)getStudent(id)).getGrade(0)!=null) {
            bWriter.write(";"+((AbsStudent)getStudent(id)).getGrades());
          }
            bWriter.newLine();
          }
        }
        bWriter.close();
        fWriter.close();
      } catch (IOException e) {
        System.out.println("Cannot create file named :"+fileName);
      } catch (Exception e) {
        System.err.println("hello?? "+e.toString());
      }
    }

  }

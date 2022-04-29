package Program.javaDatabase;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

import Program.Classes.AbsStudent;
import Program.Classes.CombinedStudy;
import Program.Classes.HumanitarianStudy;
import Program.Classes.TechnicalStudy;


public class Database {
    
    private HashMap<Integer, AbsStudent> TheDatabase;
    public static int nextStudentId = 1;

    public Database() {
        TheDatabase = new HashMap<Integer, AbsStudent>();
    }


    public AbsStudent getStudent(int id) {
      //if(TheDatabase.get(id)!=null) {
      return TheDatabase.get(id);
      //} else return null;
    }

    private void printStudent(int id, Boolean study) {
        String fName = getStudent(id).getFirstName();
        String sName = getStudent(id).getSecondName();
        int birthYear = TheDatabase.get(id).getBirthDate().getYear();
        double avg = TheDatabase.get(id).getAverage();
        String type="";
        if (study) {
        type = " {type="+TheDatabase.get(id).getClass().getSimpleName()+"}";
        }
        System.out.printf("Student: {ID=%d} {firstname=%s} {secondname=%s} {year of birth=%4d} {average grade=%4.3f}%s\n",id,fName,sName,birthYear,avg,type);
    }

    private String printStudent(int id) {
      String fName = getStudent(id).getFirstName();
      String sName = getStudent(id).getSecondName();
      String birthYear = TheDatabase.get(id).getBirthDate().toString();
      double avg = TheDatabase.get(id).getAverage();
      String type = TheDatabase.get(id).getClass().getSimpleName();
      return String.format("%d;%s;%s;%s;%4.3f;%s",id,fName,sName,birthYear,avg,type);
    }

    public int ActuallNumberOfStudents() {
      int ActualNumebStudents = 0;
      for (int id = 0; id < nextStudentId; id++) {
        if (getStudent(id)!=null) {
          ActualNumebStudents++;
        }
      }
      return ActualNumebStudents;
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
      TheDatabase.get(id).addGrade(number);
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
      if(getStudent(id)!=null) {
        String fName = getStudent(id).getFirstName();
        String sName = getStudent(id).getSecondName();
        String birthYear = ""+TheDatabase.get(id).getBirthDate().getYear();
        double avg = TheDatabase.get(id).getAverage();
        String type = TheDatabase.get(id).getClass().getSimpleName();
        System.out.printf("Student: {ID=%d} {firstname=%s} {secondname=%s} {year of birth=%s} {average grade=%4.3f} {type=%s}",id,fName,sName,birthYear,avg,type);
      }
    }

    public void stalkStudent(int id) {
      if(getStudent(id)!=null) {
        printStudent(id,true);
      }
    }
    
    public void listOfStudents() {
      
      for (int id = 0; id < nextStudentId; id++) {
        if (getStudent(id)!=null) {
          printStudent(id, false);
        } 
      }
    }

    //e)
    
    public String skillStudent(int id) {
      var type = getStudent(id);
      var student = getStudent(id);
      int year = student.getBirthDate().getYear();
      String internal01 = "";
      String internal02 = "";

      if(type instanceof CombinedStudy) {
        internal01 = ""+ ((CombinedStudy) type).isLeapYear_Birth(student.getBirthDate());
        internal02 = ""+ ((CombinedStudy) getStudent(id)).isZodiacSign(student.getBirthDate());
        return "Birth year ("+year+") is leapyear: "+internal01+"\nZodiac sign is: "+internal02;
      } else if(type instanceof HumanitarianStudy) {
        internal02 = ""+ ((HumanitarianStudy) getStudent(id)).isZodiacSign(student.getBirthDate());
        return "Zodiac sign is: "+internal02;
      }else if(type instanceof TechnicalStudy){
        internal01 = ""+ ((TechnicalStudy) getStudent(id)).isLeapYear_Birth(student.getBirthDate());
        return "Birth year ("+year+") is leapyear: "+internal01;
      }

      return "Birth year is leapyear: "+internal01;
    }


    //f)

    
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
    
    public void generalAvg() {
      int numberTech = 0, numberHum = 0;
      double sumTech = 0.0, sumHum =0.0;
      for(int id = 0; id < nextStudentId; id++) {
        if(getStudent(id)==null) continue;
        if(getStudent(id).getAverage()==0) continue;
        if((getStudent(id) instanceof TechnicalStudy) || (getStudent(id) instanceof CombinedStudy)) {
          numberTech++;
          sumTech = sumTech + getStudent(id).getAverage();
        } 
        if((getStudent(id) instanceof HumanitarianStudy) || (getStudent(id) instanceof CombinedStudy)) {
          numberHum++;
          sumHum = sumHum + getStudent(id).getAverage();
        }
      }
        if(numberTech!=0) {
          System.out.printf("General average grades from Technical Studies is: %4.3f\n", sumTech/numberTech);
          
      } else {
        System.out.println("There are no students in Technical Studies");
      }
      if(numberHum!=0) {
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
        String path =  "files" + File.separator + fileName;
        File filePath = new File(path);
        fReader = new FileReader(filePath + ".txt");
        
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
          //System.out.println("Amount of students in database "+fileName+" is "+amount);
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
          if (id != nextStudentId) {
            //System.out.println("adding to nmbStudens: "+nextStudentId+ " ->"+" id: "+id);
            nextStudentId=id;}
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
              getStudent(id).addGrade(Integer.parseInt(entry[y]));
            }
            
            
          }
        
        
        } catch (IOException e) {
          System.out.println(e.toString());
      } catch (Exception e) {
        System.out.println("weeee, i am falling");
        System.out.println("and why? you ask\nthis is why: " + e.toString());
      
      }
    }


    //j)

    public void saveDatabase(String fileName) {
      try {
        String path =  "files" + File.separator + fileName;
        File filePath = new File(path);
        FileWriter fWriter = new FileWriter(filePath + ".txt");
        BufferedWriter bWriter = new BufferedWriter(fWriter);
        bWriter.write(new String("AmountOfStudents " + ActuallNumberOfStudents()));
        bWriter.newLine();
        for (int id = 0; id < nextStudentId; id++) {
          if (getStudent(id)!=null) {
            bWriter.write(printStudent(id));
            if((getStudent(id).getGrade(0)!=null)) {
            bWriter.write(";" + getStudent(id).getGrades());
          }
            bWriter.newLine();
          }
        }
        bWriter.close();
        fWriter.close();
      } catch (IOException e) {
        System.out.println("Cannot create file named: "+fileName);
      } catch (Exception e) {
        System.err.println("hello?? "+e.toString());
      }
    }

  }

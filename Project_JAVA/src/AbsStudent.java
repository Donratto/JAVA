import java.time.LocalDate;
import java.util.HashMap;

public abstract class AbsStudent {
    
    private int id;
    private String firstName;
    private String secondName;
    private LocalDate birthDate;
    private HashMap<String, Integer> grades;

    public AbsStudent(int id, String firstName, String secondName, LocalDate birthDate) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.birthDate = birthDate;
        this.grades = new HashMap<String, Integer>();
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

    public String getSecondtName() {
        return secondName;
    }
    public void setSecondName(String name) {
        this.secondName = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(String date) {
        this.birthDate = LocalDate.parse(date);
    }

    public Integer getGrade(String subject) {
        return grades.get(subject);
    }
    public void setGrade(String subject, Integer number) {
        this.grades.put(subject, number);
    }
    public void deleteGrade(String subject) {
        this.grades.remove(subject);
    }



}

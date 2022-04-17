import java.time.LocalDate;
import java.util.LinkedList;

public abstract class AbsStudent {
    
    private int id;
    private String firstName, secondName;
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
        try {
        this.birthDate = LocalDate.parse(date);
        }
        catch (Exception e) {
            System.err.println("Wrong format of date\nuse format: 'yyyy-mm-dd'");
        }
    }

    public Integer getGrade(Integer idx) {
        return grades.get(idx);
    }
    public void setGrade(Integer idx, Integer number) {
        if(number>=1 || number<=5) {
            this.grades.set(idx, number);
        }
        else {
            badInput();
        }
    }
    public void addGrade(Integer number) {
        if(number>=1 || number<=5) {
            this.grades.add(number);
        }
        else {
            badInput();
        }
        
    }
    public void deleteGrade(Integer idx) {
        this.grades.remove(idx);
    }

    private void badInput() {
        System.err.println("Enter only one number from: {1, 2, 3, 4, 5}");
    }


}

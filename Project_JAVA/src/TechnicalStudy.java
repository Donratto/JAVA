import java.time.LocalDate;

public class TechnicalStudy extends AbsStudent implements ITech{
    private boolean isLeap;



    public TechnicalStudy(int id, String firstName, String secondName, LocalDate birthDate) {
        super(id, firstName, secondName, birthDate);
        
    }


    @Override
    public boolean isLeapYear_Birth(LocalDate birthDate) {
        
        return isLeap;
    }


}

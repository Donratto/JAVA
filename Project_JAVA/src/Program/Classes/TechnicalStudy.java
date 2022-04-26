package Program.Classes;

import java.time.LocalDate;

import Program.Interfaces.ITech;

public class TechnicalStudy extends AbsStudent implements ITech{
    



    public TechnicalStudy(int id, String firstName, String secondName, LocalDate birthDate) {
        super(id, firstName, secondName, birthDate);
        
    }


    @Override
    public boolean isLeapYear_Birth(LocalDate birthDate) {
        return birthDate.isLeapYear();
    }


}

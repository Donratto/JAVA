import java.time.LocalDate;

public class CombinedStudy extends AbsStudent implements IHum, ITech {
    //private ZodiacSigns zodiacSigns;

    public CombinedStudy(int id, String firstName, String secondName, LocalDate birthDate) {
        super(id, firstName, secondName, birthDate);
    }

    @Override
    public boolean isLeapYear_Birth(LocalDate birthDate) {
        return birthDate.isLeapYear();
    }


    @Override
    public  ZodiacSigns isZodiacSign(LocalDate birthDate) {
        if ((birthDate.getMonthValue() == 3 && birthDate.getDayOfMonth() >= 21) || (birthDate.getMonthValue() == 4 && birthDate.getDayOfMonth() <= 19)) {
            //System.out.println("beran");
            return ZodiacSigns.ARIES;
        }else if ((birthDate.getMonthValue() == 4 && birthDate.getDayOfMonth() >= 20) || (birthDate.getMonthValue() == 5 && birthDate.getDayOfMonth() <= 20)) {
            //System.out.println("byk");
            return ZodiacSigns.TAURUS;
        }else if ((birthDate.getMonthValue() == 5 && birthDate.getDayOfMonth() >= 21) || (birthDate.getMonthValue() == 6 && birthDate.getDayOfMonth() <= 20)) {
            //System.out.println("blizenec");
            return ZodiacSigns.GEMINI;
        }else if ((birthDate.getMonthValue() == 6 && birthDate.getDayOfMonth() >= 21) || (birthDate.getMonthValue() == 7 && birthDate.getDayOfMonth() <= 22)) {
            //System.out.println("rak");
            return ZodiacSigns.CANCER;
        }else if ((birthDate.getMonthValue() == 7 && birthDate.getDayOfMonth() >= 23) || (birthDate.getMonthValue() == 8 && birthDate.getDayOfMonth() <= 22)) {
            //System.out.println("lev");
            return ZodiacSigns.LEO;
        }else if ((birthDate.getMonthValue() == 8 && birthDate.getDayOfMonth() >= 23) || (birthDate.getMonthValue() == 9 && birthDate.getDayOfMonth() <= 22)) {
            //System.out.println("panna");
            return ZodiacSigns.VIRGO;
        }else if ((birthDate.getMonthValue() == 9 && birthDate.getDayOfMonth() >= 23) || (birthDate.getMonthValue() == 10 && birthDate.getDayOfMonth() <= 22)) {
            //System.out.println("vaha");
            return ZodiacSigns.LIBRA;
        }else if ((birthDate.getMonthValue() == 10 && birthDate.getDayOfMonth() >= 23) || (birthDate.getMonthValue() == 11 && birthDate.getDayOfMonth() <= 21)) {
            //System.out.println("skorpion");
            return ZodiacSigns.SCORPIO;
        }else if ((birthDate.getMonthValue() == 11 && birthDate.getDayOfMonth() >= 22) || (birthDate.getMonthValue() == 12 && birthDate.getDayOfMonth() <= 21)) {
            //System.out.println("strelec");
            return ZodiacSigns.SAGITTARIUS;
        }else if ((birthDate.getMonthValue() == 12 && birthDate.getDayOfMonth() >= 22) || (birthDate.getMonthValue() == 1 && birthDate.getDayOfMonth() <= 19)) {
            //System.out.println("koza");
            return ZodiacSigns.CAPRICON;
        }else if ((birthDate.getMonthValue() == 1 && birthDate.getDayOfMonth() >= 20) || (birthDate.getMonthValue() == 2 && birthDate.getDayOfMonth() <= 18)) {
            //System.out.println("vodnar");
            return ZodiacSigns.AQUARIUS;
        }else if ((birthDate.getMonthValue() == 2 && birthDate.getDayOfMonth() >= 19) || (birthDate.getMonthValue() == 3 && birthDate.getDayOfMonth() <= 20)) {
            //System.out.println("ryba");
            return ZodiacSigns.PISCES;
        }
        return null;
    }
}

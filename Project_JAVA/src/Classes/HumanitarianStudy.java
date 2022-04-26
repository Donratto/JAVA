package Classes;

import java.time.LocalDate;
import Enums.ZodiacSigns;
import Interfaces.IHum;

public class HumanitarianStudy extends AbsStudent implements IHum {

    public HumanitarianStudy(int id, String firstName, String secondName, LocalDate birthDate) {
        super(id, firstName, secondName, birthDate);
    }

    @Override
    public  ZodiacSigns isZodiacSign(LocalDate birthDate) {
        int month = birthDate.getMonthValue();
        int day = birthDate.getDayOfMonth();
        if ((month == 3 && day >= 21) || (month == 4 && day <= 19)) {
            //System.out.println("beran");
            return ZodiacSigns.ARIES;
        }else if ((month == 4 && day >= 20) || (month == 5 && day <= 20)) {
            //System.out.println("byk");
            return ZodiacSigns.TAURUS;
        }else if ((month == 5 && day >= 21) || (month == 6 && day <= 20)) {
            //System.out.println("blizenec");
            return ZodiacSigns.GEMINI;
        }else if ((month == 6 && day >= 21) || (month == 7 && day <= 22)) {
            //System.out.println("rak");
            return ZodiacSigns.CANCER;
        }else if ((month == 7 && day >= 23) || (month == 8 && day <= 22)) {
            //System.out.println("lev");
            return ZodiacSigns.LEO;
        }else if ((month == 8 && day >= 23) || (month == 9 && day <= 22)) {
            //System.out.println("panna");
            return ZodiacSigns.VIRGO;
        }else if ((month == 9 && day >= 23) || (month == 10 && day <= 22)) {
            //System.out.println("vaha");
            return ZodiacSigns.LIBRA;
        }else if ((month == 10 && day >= 23) || (month == 11 && day <= 21)) {
            //System.out.println("skorpion");
            return ZodiacSigns.SCORPIO;
        }else if ((month == 11 && day >= 22) || (month == 12 && day <= 21)) {
            //System.out.println("strelec");
            return ZodiacSigns.SAGITTARIUS;
        }else if ((month == 12 && day >= 22) || (month == 1 && day <= 19)) {
            //System.out.println("koza");
            return ZodiacSigns.CAPRICON;
        }else if ((month == 1 && day >= 20) || (month == 2 && day <= 18)) {
            //System.out.println("vodnar");
            return ZodiacSigns.AQUARIUS;
        }else if ((month == 2 && day >= 19) || (month == 3 && day <= 20)) {
            //System.out.println("ryba");
            return ZodiacSigns.PISCES;
        } else return null;
    }
}

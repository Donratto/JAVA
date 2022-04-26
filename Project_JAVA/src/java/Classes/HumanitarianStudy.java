package java.Classes;

import java.Enums.ZodiacSigns;
import java.Interfaces.IHum;
import java.time.LocalDate;

public class HumanitarianStudy extends AbsStudent implements IHum {

    public HumanitarianStudy(int id, String firstName, String secondName, LocalDate birthDate) {
        super(id, firstName, secondName, birthDate);
    }
    
    
    public  ZodiacSigns isZodiacSignSmazat(LocalDate birthDate) {
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
    

    @Override
    public ZodiacSigns isZodiacSign(LocalDate birthDate) {
        boolean leap = birthDate.isLeapYear();

        
        int dayOfYear = birthDate.getDayOfYear();
        if((dayOfYear < 20) || ( !leap && dayOfYear > 355) || ( leap && dayOfYear > 356)) {
            return ZodiacSigns.CAPRICON;
        } else if ((dayOfYear < 50)){
            return ZodiacSigns.AQUARIUS;
        }else if (( !leap && dayOfYear < 80) || ( leap && dayOfYear < 81)){
            return ZodiacSigns.PISCES;
        }else if (( !leap && dayOfYear < 110) || ( leap && dayOfYear < 111)){
            return ZodiacSigns.ARIES;
        }else if (( !leap && dayOfYear < 141) || ( leap && dayOfYear < 142)){
            return ZodiacSigns.TAURUS;
        }else if (( !leap && dayOfYear < 172) || ( leap && dayOfYear < 173)){
            return ZodiacSigns.GEMINI;
        }else if (( !leap && dayOfYear < 204) || ( leap && dayOfYear < 205)){
            return ZodiacSigns.CANCER;
        }else if (( !leap && dayOfYear < 235) || ( leap && dayOfYear < 236)){
            return ZodiacSigns.LEO;
        }else if (( !leap && dayOfYear < 266) || ( leap && dayOfYear < 267)){
            return ZodiacSigns.VIRGO;
        }else if (( !leap && dayOfYear < 296) || ( leap && dayOfYear < 297)){
            return ZodiacSigns.LIBRA;
        }else if (( !leap && dayOfYear < 326) || ( leap && dayOfYear < 327)){
            return ZodiacSigns.SCORPIO;
        }else {
            return ZodiacSigns.SAGITTARIUS;
        }
    }

    
}

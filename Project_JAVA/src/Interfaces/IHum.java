package Interfaces;
import java.time.LocalDate;

import Enums.ZodiacSigns;

public interface IHum {
    public ZodiacSigns isZodiacSign(LocalDate birthDate);
}

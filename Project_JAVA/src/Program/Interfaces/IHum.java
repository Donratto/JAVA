package Program.Interfaces;
import java.time.LocalDate;

import Program.Enums.ZodiacSigns;

public interface IHum {
    public ZodiacSigns isZodiacSign(LocalDate birthDate);
}

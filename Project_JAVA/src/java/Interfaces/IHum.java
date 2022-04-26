package java.Interfaces;
import java.Enums.ZodiacSigns;
import java.time.LocalDate;

public interface IHum {
    public ZodiacSigns isZodiacSign(LocalDate birthDate);
}

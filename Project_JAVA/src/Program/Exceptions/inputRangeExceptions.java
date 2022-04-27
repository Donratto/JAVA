package Program.Exceptions;
public class InputRangeExceptions extends java.lang.Exception 
{
    public InputRangeExceptions()
    {
        super("Bad number input");
    }
    public InputRangeExceptions(String chyba)
    {
        super(chyba);
    }
}
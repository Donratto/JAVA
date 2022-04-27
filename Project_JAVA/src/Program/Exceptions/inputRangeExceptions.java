package Program.Exceptions;
public class inputRangeExceptions extends java.lang.Exception 
{
    public inputRangeExceptions()
    {
        super("Bad number input");
    }
    public inputRangeExceptions(String chyba)
    {
        super(chyba);
    }
}
package Program.Exceptions;
public class gradeExceptions extends java.lang.Exception 
{
    public gradeExceptions()
    {
        super("Bad number input");
    }
    public gradeExceptions(String chyba)
    {
        super(chyba);
    }
}
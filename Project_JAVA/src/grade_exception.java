public class grade_exception extends java.lang.Exception 
{
    public grade_exception()
    {
        super("Bad number input");
    }
    public grade_exception(String chyba)
    {
        super(chyba);
    }
}
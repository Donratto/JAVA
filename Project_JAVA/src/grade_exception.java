public class grade_exception extends java.lang.Exception 
{
    public grade_exception()
    {
        super("Prumer nebyl nalezen");
    }
    public grade_exception(String chyba)
    {
        super(chyba);
    }
}
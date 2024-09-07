using CodeBehind;

public partial class user : CodeBehindController
{
    public void PageLoad(HttpContext context)
    {
        IgnoreViewAndModel = true;
    
        if (Section.Count() > 0)
            Write(Section.GetValue(0)); // path: /user/{id}
        else
            Write(""); // path: /user
    }
}
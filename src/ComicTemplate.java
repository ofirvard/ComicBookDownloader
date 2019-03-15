import java.util.ArrayList;

public class ComicTemplate
{
    public ComicTemplate(String name, ArrayList<String> jpgUrls)
    {
        this.name = name;
        this.jpgUrls = jpgUrls;
    }

    String name;
    ArrayList<String> jpgUrls;
}

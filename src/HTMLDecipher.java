import java.util.ArrayList;

public class HTMLDecipher
{
    public ComicTemplate decipher(String html)
    {
        String comicName;
        ArrayList<String> jpgUrls = new ArrayList<>();
        String[] split = html.split("lstImages\\.push\\(" + '"');

        for (int i = 1; i < split.length; i++)
            jpgUrls.add(split[i].substring(0, split[i].indexOf('"')));

        return new ComicTemplate(getComicName(html), jpgUrls);
    }

    private String getComicName(String html)
    {
        String comicName;

        String[] split = html.split("content=\"Read ");
        comicName = split[1];
        comicName = comicName.substring(0, comicName.indexOf(" comic online"));

        comicName = comicName.replace('"', '/');
        comicName = comicName.replace("/", "");
        comicName = comicName.replace("\\", "");
        comicName = comicName.replace(":", "");
        comicName = comicName.replace("*", "");
        comicName = comicName.replace("?", "");
        comicName = comicName.replace("<", "");
        comicName = comicName.replace(">", "");
        comicName = comicName.replace("|", "");

        return comicName;
    }
}

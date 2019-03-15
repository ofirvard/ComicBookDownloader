import java.io.*;
import java.net.URL;
import java.util.ArrayList;

public class ImageDownloader
{
    public void downloadImages(ComicTemplate comicTemplate)
    {
        try
        {
            int i = 0;
            for (String s : comicTemplate.jpgUrls)
                downloadSingleImage(s, "" + i++);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private void downloadSingleImage(String jpgUrl, String name) throws IOException
    {
        URL url = new URL(jpgUrl);
        InputStream in = new BufferedInputStream(url.openStream());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        int n = 0;
        while (-1 != (n = in.read(buf)))
        {
            out.write(buf, 0, n);
        }
        out.close();
        in.close();
        byte[] response = out.toByteArray();

        FileOutputStream fos = new FileOutputStream("tmp files/" + name + ".jpg");
        fos.write(response);
        fos.close();
    }
}

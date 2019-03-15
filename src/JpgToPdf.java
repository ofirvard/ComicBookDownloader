import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class JpgToPdf
{
    public void convertJpgToPdf(String name) throws Exception
    {
        File root = new File("tmp files");
        ArrayList<String> files = getImages(root);

        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(new File("comics", name + ".pdf")));
        document.open();
        for (String f : files)
        {
            document.newPage();
            Image image = Image.getInstance(new File(root, f).getAbsolutePath());
            image.setAbsolutePosition(0, 0);
            image.setBorderWidth(0);
            image.scaleAbsolute(PageSize.A4);
            document.add(image);
        }
        document.close();
    }

    private ArrayList<String> getImages(File root)
    {
        ArrayList<String> files = new ArrayList<>();

        for (File file : root.listFiles())
            if (!file.isDirectory())
                files.add(file.getName());

        return sortImages(files);
    }

    private ArrayList<String> sortImages(ArrayList<String> images)
    {
        try
        {
            Collections.sort(images, new Comparator<String>()
            {
                public int compare(String o1, String o2)
                {
                    return extractInt(o1) - extractInt(o2);
                }

                int extractInt(String s)
                {
                    String num = s.replaceAll("\\D", "");
                    // return 0 if no digits found
                    return num.isEmpty() ? 0 : Integer.parseInt(num);
                }
            });

            return images;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return images;
    }
}

import cloudBypass.CHttpRequester;
import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {
        //todo add check if already downloaded to save time
        ComicHTMLDownloader comicHTMLDownloader = new ComicHTMLDownloader();
        HTMLDecipher decipher = new HTMLDecipher();
        ImageDownloader downloader = new ImageDownloader();
        JpgToPdf jpgToPdf = new JpgToPdf();

        try
        {
            String doc = Jsoup.connect("http://www.google.com/search?q=lakshman")
                    .userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/33.0.1750.152 Safari/537.36")
                    .referrer("http://www.google.com")
                    .timeout(7000)
                    .get()
                    .toString();



////            String url = readFile("comic list.txt");
////            String url2 = "https://kissmanga.com/Manga/Sono-Bisque-Doll-wa-Koi-wo-suru/Vol--003-Ch-017?id=466509";
//            initFilesAndFolders();
//            String html = readFile("comic.txt");
//
////            CHttpRequester requester = new CHttpRequester();
////            requester.get("https://kissanime.ru/");
//
//
////            comicHTMLDownloader.connectToSite(url);
//
//            ComicTemplate comicTemplate = decipher.decipher(html);
//            downloader.downloadImages(comicTemplate);
//            jpgToPdf.convertJpgToPdf(comicTemplate.name);
//
//            cleanTmpFolder();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private static String readFile(String file) throws IOException
    {
        return new String(Files.readAllBytes(Paths.get(file)), StandardCharsets.UTF_8);
    }

    private static String[] readList(String list) throws IOException
    {
        return readFile(list).split("\r\n");
    }

    private static void initFilesAndFolders() throws IOException
    {
        File tmpFiles = new File("tmp files");
        tmpFiles.mkdirs();
        FileUtils.cleanDirectory(tmpFiles);

        new File("comics").mkdirs();

        new File("comic list.txt").createNewFile();

        new File("manga list.txt").createNewFile();
    }

    private static void cleanTmpFolder() throws IOException
    {
        FileUtils.cleanDirectory(new File("tmp files"));
    }
}

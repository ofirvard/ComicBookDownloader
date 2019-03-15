import com.gargoylesoftware.htmlunit.*;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.util.Cookie;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class ComicHTMLDownloader
{
    public void connectToSite(String url) throws FailingHttpStatusCodeException, MalformedURLException, IOException, InterruptedException
    {
        // TODO: 1/4/2019 solve and find a way to bypass browser check 
        url = "https://readcomiconline.to/Comic/Plastic-Man-2018/Issue-5?id=141205";

        // turn off htmlunit warnings
        java.util.logging.Logger.getLogger("com.gargoylesoftware.htmlunit").setLevel(java.util.logging.Level.OFF);
        java.util.logging.Logger.getLogger("org.apache.http").setLevel(java.util.logging.Level.OFF);

        WebClient webClient = new WebClient(BrowserVersion.CHROME);
        webClient.getOptions().setJavaScriptEnabled(true);
        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
        webClient.getOptions().setRedirectEnabled(true);
        webClient.getOptions().setCssEnabled(true);
        webClient.setJavaScriptTimeout(10000);

        HtmlPage page = webClient.getPage(url);

        int i = 0;
//        while (page.asText().contains("Please wait 5 seconds"))
//        {
//            System.out.println("waiting five seconds");
//            webClient.waitForBackgroundJavaScript(5000);//todo check if text is here after a few loops
//            System.out.println("done waiting for five seconds, loop:" + i++);
//            if (i == 3)
//            {
        test();

//                File file = new File("comic.txt");
//                file.createNewFile(); // if file already exists will do nothing
//                FileOutputStream oFile = new FileOutputStream(file, false);
//                oFile.write(page.getPage().asText().getBytes());

//            break;
//            }
//        }

//        System.out.println(page.asText());
//        System.out.println("==================================================================================================================");
//        System.out.println("==================================================================================================================");
//        System.out.println("==================================================================================================================");
    }

    private void test()
    {
//        WebClient webClient = new WebClient(BrowserVersion.CHROME);
//        webClient.getOptions().setJavaScriptEnabled(true);
//        webClient.getOptions().setRedirectEnabled(true);
//        webClient.getOptions().setThrowExceptionOnScriptError(false);
//        webClient.getOptions().setCssEnabled(true);
//        HtmlPage page = (HtmlPage) webClient.getPage("https://readcomiconline.to/Comic/Plastic-Man-2018/Issue-5?id=141205");
//        WebResponse response = page.getWebResponse();
//        String content = response.getContentAsString();
//        System.out.println("==================================================================================================================");
//        System.out.println("==================================================================================================================");
//        System.out.println("==================================================================================================================");
//        System.out.println(page.getUrl());

        try
        {
//            final WebClient webClient = new WebClient(BrowserVersion.CHROME)
//            webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
//            webClient.getOptions().setJavaScriptEnabled(true);
//            webClient.getOptions().setRedirectEnabled(true);
//            webClient.getOptions().setCssEnabled(true);
//
//            String url = "http://www.osbot.org/";
//            HtmlPage htmlPage = webClient.getPage(url);
//            webClient.waitForBackgroundJavaScript(10_000);
//            Thread.sleep(10000);
//            System.out.println(htmlPage.asText());
//            System.out.println("==================================================================================================================");
//            System.out.println(htmlPage.asXml());

            final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; WOW64; rv:39.0) Gecko/20100101 Firefox/39.0";
            final String COOKIE = "__cfduid=da14d952134a51b820193141bfa38717e1439243071; cf_clearance=e44e89e8388780ffdb99dbcd46d8be663183bd75-1439243075-604800; __utma=248210461.350578717.1439243076.1439243076.1439300541.2; __utmz=248210461.1439243076.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); ASP.NET_SessionId=qnxzuut4sqb0mhgyxgykfp2v; __utmb=248210461.5.10.1439300541; __utmc=248210461; username=; password=; __utmt=1; MarketGidStorage=%7B%220%22%3A%7B%22svspr%22%3A%22http%3A%2F%2Fkissanime.com%2FAnime%2FJitsu-wa-Watashi-wa%2FEpisode-006%3Fid%3D113822%22%2C%22svsds%22%3A1%2C%22TejndEEDj%22%3A%22MTQzOTMwMTc1MTMxNzc5OTI0NTE%3D%22%7D%2C%22C7992%22%3A%7B%22page%22%3A1%7D%7D; __atuvc=1%7C32; __atuvs=55ca0076b32cd26c000";
//            WebClient webClient = new WebClient(new BrowserVersion("Firefox", "5.0 (Windows NT 10.0; WOW64; rv:39.0) Gecko/20100101 Firefox/39.0", USER_AGENT, 39.0f));
            final WebClient webClient = new WebClient(BrowserVersion.CHROME);
            CookieManager cookieManager = webClient.getCookieManager();
            cookieManager.setCookiesEnabled(true);
            cookieManager.addCookie(new Cookie("kissanime.com", "cookie", COOKIE));
            webClient.setCookieManager(cookieManager);
            HtmlPage page = webClient.getPage("http://www.kissanime.ru");
            System.out.println(page.asText());

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    public void connectToSite2(String url) throws FailingHttpStatusCodeException, InterruptedException
    {
        HtmlUnitDriver drv = new HtmlUnitDriver(BrowserVersion.CHROME);
        drv.setJavascriptEnabled(true);
        drv.get(url);
        drv.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Thread.sleep(5000);
        System.out.println(drv.getPageSource());
    }

    public void homePage() throws Exception
    {
        try (final WebClient webClient = new WebClient())
        {
            HtmlPage page = webClient.getPage("https://readcomiconline.to/Comic/Plastic-Man-2018/Issue-5?id=141205");
        }
    }

}

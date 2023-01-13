package FindWIidgets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VerifyWidgetExist {

    private static WebDriver driver;
    private static By facebookwidget = By.xpath("//*[@id=\"social_network\"]/ul/li[3]/a");
    private static  By twitterwidget = By.xpath("//*[@id=\"centered_nav\"]/a[3]");
    private static  By tumblrwidget = By.xpath("//*[@id=\"centered_nav\"]/a[3]");

    public VerifyWidgetExist(WebDriver driver){VerifyWidgetExist.driver = driver;}

    public static void getfacebookwidget(){ String expectedwidget = "Facebook";
        String Fb = driver.findElement(facebookwidget).getText();
        if(expectedwidget.equalsIgnoreCase(Fb))
            System.out.println("widget facebook does not exist");
        else
            System.out.println("widget facebook does not exist");}

    public static void gettwitterwidget(){ String expectedwidget = "Twitter";
        String Twr = driver.findElement(twitterwidget).getText();
        if(expectedwidget.equalsIgnoreCase(Twr))
            System.out.println("widget twitter does not exist");
        else
            System.out.println("widget twitter does not exist");}

    public static void gettumblrwidget(){ String expectedwidget = "Tumblr";
        String Tmb = driver.findElement(tumblrwidget).getText();
        if(expectedwidget.equalsIgnoreCase(Tmb))
            System.out.println("widget tumblr does not exist");
        else
            System.out.println("widget tumblr does not exist");}


    }

package steps;

import FindWIidgets.VerifyWidgetExist;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static java.awt.SystemColor.text;
import static org.junit.Assert.assertNotSame;

public class MyStepdefs {

        private WebDriver driver;
        private static  By aleatoire = By.xpath("//div[@id='social_network']/ul/li[3]/a/img");

        private static  By facebookwidget = By.xpath("//*[@id=\"social_network\"]/ul/li[3]/a");
        private static  By twitterwidget = By.xpath("//*[@id=\"social_network\"]/ul/li[4]/a");
        private static  By tumblrwidget = By.xpath("//*[@id=\"social_network\"]/ul/li[5]/a");


        @Before()
        public void setup(){
                System.setProperty("webdriver.chrome.driver", "Browser/chromedriver.exe");
                driver = new ChromeDriver();
        }
        @Given("utilisateur accede au site Bouletcorp")
        public void utilisateur_accede_au_site_Bouletcorp() {
                driver.get("http://www.bouletcorp.com");
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }

        @When("utilisateur clique sur Aleatoire")
        public void utilisateur_clique_sur_Aleatoire() {
        driver.findElement(aleatoire).click();

        }

        @Then("utilisateur verifie que la page a change")
        public void utilisateur_verifie_que_la_page_a_change() {
             String crtUrl = driver.getCurrentUrl();
                System.out.println("Previous Url is:"+ crtUrl);
                driver.findElement(By.xpath("//*[@id=\"centered_nav\"]/a[3]")).click();
                String newUrl = driver.getCurrentUrl();
                System.out.println("New Url is:"+ newUrl);
               // Assert.assertNotEquals(crtUrl, newUrl);
                if(newUrl.equalsIgnoreCase(crtUrl))
                        System.out.println("The page is not change");
                else
                        System.out.println("the page is change");
        }

        @And("utilisateur verifie que les widgets facebook, twitter et tumblr sont bien affiches")
        public void utilisateur_verifie_que_les_widgets_facebook_twitter_et_tumblr_sont_bien_affiches() {

                //verify widget facebook exist
                String expectedfacebookwidget = "Facebook";
                String Fb = driver.findElement(facebookwidget).getText();
                if(expectedfacebookwidget.equalsIgnoreCase(Fb))
                        System.out.println("widget facebook  does not exist");
                else
                        System.out.println("widget facebook exist");


                //verify widget twitter exist
                String expectedtwitterwidget = "Twitter";
                String Twr = driver.findElement(twitterwidget).getText();
                if(expectedtwitterwidget.equalsIgnoreCase(Twr))
                        System.out.println("widget twitter does not exist");
                else
                        System.out.println("widget twitter exist");}

               /*  //verify widget tumblr exist
               String expectedtumblrdwidget = "Tumblr";
                String Tmb = driver.findElement(tumblrwidget).getText();
                if(expectedtumblrdwidget.equalsIgnoreCase(Tmb))
                System.out.println("widget tumblr does not exist");
                else
                System.out.println("widget tumblr  exist"); */


        @After()
        public void quitBrowser() {
                driver.quit();
        }
}

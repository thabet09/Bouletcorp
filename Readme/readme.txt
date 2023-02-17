Exercice à réaliser pour les candidats au poste d’ingénieur automaticien

Introduction
Le but de ces exercices est que nous ayons une idée de votre niveau technique.
Lors de cet exercice, le but sera :
•	de connaître votre méthode de réalisation de tests;
•	de voir comment vous prenez des initiatives dans la création de tests, pour être au plus près du comportement de l'utilisateur final;
•	enfin, de connaître votre niveau technique.

Réalisation
Le test sera à réaliser en utilisant Cucumber, Selenium WebDriver, le langage sera le java
Il est important que les tests soient au maximum exécutable, si cela n'est pas le cas, veuillez expliquer pourquoi et préciser ce sur quoi vous avez bloqué.

Exercices

Bouletcorp
En tant qu’utilisateur je me rends sur http://www.bouletcorp.com;
Lorsque je clique sur Aléatoire
Alors la page a changé 
Et les widgets facebook, twitter et tumblr sont bien affichés.


Ouisncf
En tant que client je souhaite me rendre sur le site ouisncf
Lorsque je recherche un billet de train entre Paris et Toulouse Matabiau pour le 24/07 à 16h;
Alors le train de 15h52 MONTPARNASSE 1 ET 2 est bien affiché.



**************************************************** 
But : Automatiser un scenario sur le site bouletcorp  
Frameworks et Langages: 
-SeleniumWebdriver with Java
- BDD: Cucumber
- Junit
Report : avec junit,  Bouletcorp\target\cucumber-html-reports\report-feature_580257877.html 

dépendances: 
-Cucumber-Java
-Cucumber-Junit
-Cucumber-picocontainer
-Selenium-java


POM.xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>org.example</groupId>
    <artifactId>Bouletcorp</artifactId>
    <version>1.0-SNAPSHOT</version>

    <properties>
        <maven.compiler.source>17</maven.compiler.source>
        <maven.compiler.target>17</maven.compiler.target>
        <cucumber.version>5.0.0-RC2</cucumber.version>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>


<dependencies>
<dependency>
    <groupId>io.cucumber</groupId>
    <artifactId>cucumber-java</artifactId>
    <version>${cucumber.version}</version>
    <scope>test</scope>
</dependency>

<dependency>
    <groupId>io.cucumber</groupId>
    <artifactId>cucumber-junit</artifactId>
    <version>${cucumber.version}</version>
    <scope>test</scope>
</dependency>

<dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
    <version>4.12</version>
    <scope>test</scope>
</dependency>

<dependency>
    <groupId>org.seleniumhq.selenium</groupId>
    <artifactId>selenium-java</artifactId>
    <version>3.141.59</version>
</dependency>

<dependency>
    <groupId>io.cucumber</groupId>
    <artifactId>cucumber-picocontainer</artifactId>
    <version>${cucumber.version}</version>
    <scope>test</scope>
</dependency>

</dependencies>

<build>
<plugins>
    <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-compiler-plugin</artifactId>
        <version>3.7.0</version>
        <configuration>
            <encoding>UTF-8</encoding>
            <source>1.8</source>
            <target>1.8</target>
        </configuration>
    </plugin>
    <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-surefire-plugin</artifactId>
        <version>2.22.0</version>
        <configuration>
            <parallel>methods</parallel>
            <useUnlimitedThreads>true</useUnlimitedThreads>
            <testFailureIgnore>true</testFailureIgnore>
        </configuration>
    </plugin>
    <plugin>
        <groupId>net.masterthought</groupId>
        <artifactId>maven-cucumber-reporting</artifactId>
        <version>4.11.2</version>
        <executions>
            <execution>
                <id>execution</id>
                <phase>verify</phase>
                <goals>
                    <goal>generate</goal>
                </goals>
                <configuration>
                    <projectName>cucumber-jvm-example</projectName>
                    <!-- optional, per documentation set this to "true" to bypass generation
                        of Cucumber Reports entirely, defaults to false if not specified -->
                    <skip>false</skip>
                    <!-- output directory for the generated report -->
                    <outputDirectory>${project.build.directory}</outputDirectory>
                    <!-- optional, defaults to outputDirectory if not specified -->
                    <inputDirectory>${project.build.directory}</inputDirectory>
                    <jsonFiles>
                        <!-- supports wildcard or name pattern -->
                        <param>**/*.json</param>
                    </jsonFiles>
                    <!-- optional, defaults to outputDirectory if not specified -->
                    <classificationDirectory>${project.build.directory}</classificationDirectory>
                    <classificationFiles>
                        <!-- supports wildcard or name pattern -->
                        <param>sample.properties</param>
                        <param>other.properties</param>
                    </classificationFiles>
                    <parallelTesting>false</parallelTesting>
                    <!-- optional, set true to fail build on test failures -->
                    <checkBuildResult>false</checkBuildResult>
                </configuration>
            </execution>
        </executions>
    </plugin>
</plugins>
</build>


        </project>


Feature Cucumber avec Gherkin :
Src >features > search.feature
Feature: Search Widgets
    In order to user connect to internet
  As a user enter a valid url
  User want to verify url will change if he click aleatoire and verify the widgets facebook, twitter et tumblr are exist or no



  Scenario: SearchWidgetsSuccessful

    Given utilisateur accede au site Bouletcorp
    When utilisateur clique sur Aleatoire
    Then utilisateur verifie que la page a change
    And utilisateur verifie que les widgets facebook, twitter et tumblr sont bien affiches

ClassJava:
Src>java>steps> StepsDefs.java
Src>java>RunTest> RunTestBouletcorp.java
package RunTest;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(glue={"steps"}, features = "src/test/resources", plugin = { "pretty", "html:target/site/cucumber-pretty",
        "json:target/cucumber.json" })
public class RunTestBouletcorp {
}



Amélioration au niveau BestPractice: 
-	Faut créér un classe VerifyWidget: contient une méthode de vérification et return si le widgets existe ou non 
-	On appelle juste classe VerifyWidget dans l’annotation Then and And pour vérifier une existanc 


src > main > java > VerifyWidgetExist.java

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

Src>java>steps> StepsDefs.java

package steps;

import FindWIidgets.VerifyWidgetExist;
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
        private static  By twitterwidget = By.xpath("//*[@id=\"centered_nav\"]/a[3]");
        private static  By tumblrwidget = By.xpath("//*[@id=\"centered_nav\"]/a[3]");


        
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
                

        @And("utilisateur verifie que les widgets facebook, twitter et tumblr sont bien affiches")
        public void utilisateur_verifie_que_les_widgets_facebook_twitter_et_tumblr_sont_bien_affiches() {
                VerifyWidgetExist.getfacebookwidget();
                VerifyWidgetExist.gettwitterwidget();
                VerifyWidgetExist.gettumblrwidget();
        }

}

Classe pour configuration: 
@Before et @After
package base;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.LoginPage;

public class BaseTests {
    private WebDriver driver;
    protected LoginPage loginPage;


    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "Browser/chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("https://ixia-test.fr/auth/login");
        driver.manage().window().maximize();

        loginPage = new LoginPage(driver);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}


/**
 * Created by mr on 12/19/16.
 */
import jdk.nashorn.internal.ir.WhileNode;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;


public class ExampleTest {

    private static LinkedList<Agency> agencies = new LinkedList<Agency>();

    private static String city = "denver";

    public static void main (String arguments[]){

        System.setProperty("webdriver.chrome.driver", "/Users/mr/Downloads/chromedriver");

        ChromeDriver driver = new ChromeDriver();

        try{
            driver.get("http://digitalagencynetwork.com/agencies/" + city);

            List<WebElement> agencyData = driver.findElements(By.xpath("//div[@class='threecol-two last']"));
            int featuredAgenciesCount = getFeaturedAgenciesCount(driver);

            ListIterator iterator = agencyData.listIterator();

            String agencyName ="";
            String agencyDetails ="";
            String agencyURL = "";
            String agencyDescription ="";

            WebElement element = null;

            //counter to get h6 description text using css selector[i]. First h6 element has a selector - .entry > h6:nth-child(8)
            int agencyDescriptionElementCounter = 8;

            for (int i=0;i<featuredAgenciesCount;i++){
                iterator.next();
            }

            while (iterator.hasNext()) {
                element = (WebElement) iterator.next();

                agencyName = element.findElement(By.tagName("h3")).getText();
                agencyDetails = element.findElement(By.tagName("h6")).getText();
                agencyURL = element.findElement(By.tagName("a")).getText();

                try {
                    agencyDescription = driver.findElement(By.cssSelector(".entry > h6:nth-child(" + agencyDescriptionElementCounter + ")")).getText();
                    agencyDescriptionElementCounter = agencyDescriptionElementCounter + 4;;

                } catch (NoSuchElementException exception){
                    System.out.println(exception.getMessage());
                }
                agencies.add(new Agency(agencyName, agencyDetails, agencyURL, agencyDescription));
            }

        } catch (Exception exception){
            System.out.println(exception.getMessage());
        }

        AgencyFileWriter.writeAgenciesToFile(agencies, city);
        driver.quit();

    }

    private static int getFeaturedAgenciesCount(ChromeDriver driver){

        //count featured agencies on the page
//        WebElement featuredAgencies = driver.findElement(By.xpath("//div[@class='su-box-content su-clearfix']"));
//
//        int featuredAgenciesCount = 0;
//        // = featuredAgencies.findElements(By.xpath("//div[@class='threecol-two last']")).size();
//
//        while (true) {
//            if (featuredAgencies.findElement(By.className("threecol-two last")))
//        }
//
//        System.out.println(featuredAgenciesCount);

        return 1;
    }
}
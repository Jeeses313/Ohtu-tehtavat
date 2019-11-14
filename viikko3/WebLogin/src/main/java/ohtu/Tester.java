package ohtu;

import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Tester {

    public static void main(String[] args) {
//        WebDriver driver = new HtmlUnitDriver();
//
//        driver.get("http://localhost:4567");
//        System.out.println(driver.getPageSource());
//        sleep(2);
//        
//        WebElement element = driver.findElement(By.linkText("login"));
//        element.click();
//
//        sleep(2);
//        System.out.println(driver.getPageSource());
//        element = driver.findElement(By.name("username"));
//        element.sendKeys("pekka");
//        element = driver.findElement(By.name("password"));
//        element.sendKeys("akkep");
//        element = driver.findElement(By.name("login"));
//        
//        sleep(2);
//        element.submit();
//
//        sleep(3);
//        System.out.println(driver.getPageSource());
//        driver.quit();



//epäonnistunut kirjautuminen

//        WebDriver driver = new HtmlUnitDriver();
//
//        driver.get("http://localhost:4567");
//        System.out.println(driver.getPageSource());
//        sleep(2);
//        
//        WebElement element = driver.findElement(By.linkText("login"));
//        element.click();
//
//        sleep(2);
//        System.out.println(driver.getPageSource());
//        element = driver.findElement(By.name("username"));
//        element.sendKeys("pekka");
//        element = driver.findElement(By.name("password"));
//        element.sendKeys("akka");
//        element = driver.findElement(By.name("login"));
//        
//        sleep(2);
//        element.submit();
//
//        sleep(3);
//        System.out.println(driver.getPageSource());
//        driver.quit();



//uusi käyttäjätunnus ja uloskirjautuminen

        WebDriver driver = new HtmlUnitDriver();
        Random r = new Random();
        driver.get("http://localhost:4567");
        System.out.println(driver.getPageSource());
        sleep(2);
        
        WebElement element = driver.findElement(By.linkText("register new user"));
        element.click();

        sleep(2);
        System.out.println(driver.getPageSource());
        element = driver.findElement(By.name("username"));
        element.sendKeys("jeees" + r.nextInt());
        element = driver.findElement(By.name("password"));
        element.sendKeys("eees");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("eees");
        element = driver.findElement(By.name("signup"));
        
        sleep(2);
        element.submit();

        sleep(2);
        System.out.println(driver.getPageSource());
        element = driver.findElement(By.linkText("continue to application mainpage"));
        element.click();
        sleep(2);
        System.out.println(driver.getPageSource());
        element = driver.findElement(By.linkText("logout"));
        element.click();
        sleep(3);
        System.out.println(driver.getPageSource());
        driver.quit();




    }
    
    private static void sleep(int n){
        try{
            Thread.sleep(n*1000);
        } catch(Exception e){}
    }
}

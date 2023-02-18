package com.cydeo.utilities;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class BrowserUtils {

    /*
    This method will accept int (in seconds)
    and execute Thread.sleep method for given duration
    Arg: int second
     */
    public static void sleep(int second){
        second += 1000;
        try {
            Thread.sleep(second);
        }catch (InterruptedException e){

        }
    }

    //Method for When method is called, it should switch window and verify title.
    public static void switchWindowAndVerify( String expectedInUr, String expectedInTitle ){
        //First. Return and store all window handles in a Set.
        Set<String> allWindowHandles = Driver.getDriver().getWindowHandles();

        for (String each : allWindowHandles) { // it will go throw each windowHandel
            Driver.getDriver().switchTo().window(each); // it will switch each window and switching switching
            System.out.println("Current Url: " + Driver.getDriver().getCurrentUrl()); // we can comment this part

            // second
            if(Driver.getDriver().getCurrentUrl().contains(expectedInUr)){
                break;
            }

        }

        //5. Assert: Title contains “Etsy”
        String actualTitle =Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedInTitle));
    }

    //Method fo title verification
    public static void  verifyTitle(String expectedTitle){// this method will equal "Etsy" or other title short title just name

        Assert.assertEquals(Driver.getDriver().getTitle(), expectedTitle);

    }

    public static void  verifyTitleContains( String expectedTitle){

        Assert.assertTrue(Driver.getDriver().getTitle().contains(expectedTitle)); // this method will equal "Etsy" or other title if it long title

    }


    /*
       This method accepts String title,
       and waits for that Title to contain given String value.
        */
    public static void  waitForTitleContains(String title){
        //Create the Object of "WebDriverWait" class. and setup the constructor args
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

        // Use the 'wait' object with the proper syntax to create explicit wait conditions.
        wait.until(ExpectedConditions.titleContains(title)); //dynamicControlsPage.loadingBar - is target now
    }


    /*
     This method accepts WebElement target,
     and waits for that WebElement not to be displayed on the page
      */
    public static void  waitForInvisibilityOfGivenElement(WebElement target){
        //Create the Object of "WebDriverWait" class. and setup the constructor args
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

        // Use the 'wait' object with the proper syntax to create explicit wait conditions.
        wait.until(ExpectedConditions.invisibilityOf(target)); //dynamicControlsPage.loadingBar - is target now
    }


}

package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class TimeTablePage extends GeneralPage{
    //Click on "book ticket" link of the route from "Huế" to "Sài Gòn" id 17
    private final By _btnBookticktet = By.xpath("//*[@id=\"content\"]/div/div/table/tbody/tr[17]/td[7]/a");
    public WebElement getBtnBookticktet(){
        return Constant.WEBDRIVER.findElement(_btnBookticktet);
    }
    public HomePage timetable(){
        JavascriptExecutor js = (JavascriptExecutor) Constant.WEBDRIVER;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        this.getBtnBookticktet().click();
        return new HomePage();

    }
}

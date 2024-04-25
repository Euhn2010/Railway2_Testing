package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import java.util.ArrayList;
import java.util.List;


public class BookTicketPage extends GeneralPage{
    // Locators
    private final By _sltDepartDate = By.xpath("//select[@name='Date']");
    private final By _sltDepartFrom = By.xpath("//select[@name='DepartStation']");
    private final By _sltArriveAt = By.xpath("//select[@name='ArriveStation']");
    private final By _sltSeatType = By.xpath("//select[@name='SeatType']");
    private final By _sltTicketAmount = By.xpath("//select[@name='TicketAmount']");
    private final By _btnBookTicket = By.xpath("//input[@value='Book ticket']");

    // Elements
    public WebElement SltDepartDate() {
        return Constant.WEBDRIVER.findElement(_sltDepartDate);
    }
    public WebElement SltDepartFrom() {
        return Constant.WEBDRIVER.findElement(_sltDepartFrom);
    }
    public WebElement SltArriveAt() {
        return Constant.WEBDRIVER.findElement(_sltArriveAt);
    }
    public WebElement SltSeatType() {
        return Constant.WEBDRIVER.findElement(_sltSeatType);
    }
    public WebElement SltTicketAmount() {
        return Constant.WEBDRIVER.findElement(_sltTicketAmount);
    }
    public WebElement BtnBookTicket() {
        return Constant.WEBDRIVER.findElement(_btnBookTicket);
    }

    // Methods
    public String BookTicket(String departDate, String departFrom, String arriveAt, String ticketType, Integer ticketAmount) {
        ((JavascriptExecutor) Constant.WEBDRIVER).executeScript("window.scrollBy(0, 3000)", "");
        this.SltDepartDate().click();
        Constant.WEBDRIVER.findElement(By.xpath("//option[text()='"+departDate+"']")).click();
        this.SltDepartFrom().click();
        Constant.WEBDRIVER.findElement(By.xpath("//select[@name='DepartStation']//option[text()='"+departFrom+"']")).click();
        this.SltArriveAt().click();
        Constant.WEBDRIVER.findElement(By.xpath("//select[@name='ArriveStation']//option[text()='"+arriveAt+"']")).click();
        this.SltSeatType().click();
        Constant.WEBDRIVER.findElement(By.xpath("//option[text()='"+ticketType+"']")).click();
        this.SltTicketAmount().click();
        Constant.WEBDRIVER.findElement(By.xpath("//option[text()='"+String.valueOf(ticketAmount)+"']"));
        this.BtnBookTicket().click();
        return Constant.WEBDRIVER.getCurrentUrl().split("=")[1];
    }
    public String getBookMessage() {
        return Constant.WEBDRIVER.findElement(By.xpath("//h1")).getText();
    }
    public List<String> getTicketInformation() {
        List<String> infors = new ArrayList<>();
        List<WebElement> elements = Constant.WEBDRIVER.findElements(By.xpath("//td"));
        for (WebElement element: elements) {
            infors.add(element.getText());
        }
        return infors;
    }
}


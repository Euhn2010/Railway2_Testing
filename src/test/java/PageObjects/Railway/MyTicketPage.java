package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MyTicketPage extends GeneralPage{
    private final By myticketTB = By.xpath("//table[@class='MyTable']//tr[@class='OddRow' or @class='EvenRow']");
//    private final By tabMyTicket = By.xpath("//*[@id=\"menu\"]/ul/li[7]/a");
    private final By _btnCancle = By.xpath("//*[@id=\"content\"]/form/div/div/table/tbody/tr[2]/td[11]/input");
    public boolean TicketPresent() {
        List<WebElement> tickets = Constant.WEBDRIVER.findElements(myticketTB);
        return !tickets.isEmpty();
    }
    public WebElement getBtnCancle(){
        return Constant.WEBDRIVER.findElement(_btnCancle);
    }
//    protected WebElement getTabMyTicket() {
//        return Constant.WEBDRIVER.findElement(tabMyTicket);
//    }
    public HomePage myticket(){
        JavascriptExecutor js = (JavascriptExecutor) Constant.WEBDRIVER;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        this.getBtnCancle().click();
        return new HomePage();
    }
}

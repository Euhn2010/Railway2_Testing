package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class LogoutPage extends GeneralPage{
//    private final By _btnLogout = By.xpath("//*[@id=\"menu\"]/ul/li[9]/at");
//    public WebElement getBtnLogout(){
//        return Constant.WEBDRIVER.findElement(_btnLogout);
//    }
    public HomePage logout(){
        JavascriptExecutor js = (JavascriptExecutor) Constant.WEBDRIVER;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        this.getTabLogout().click();
        return new HomePage();

    }
}

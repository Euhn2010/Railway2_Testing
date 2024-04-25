package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class ChangePasswordPage extends GeneralPage{
    private final By _txtCurrentPassword = By.xpath("//input[@id='currentPassword']");
    private final By _txtNewPassword = By.xpath("//input[@id='newPassword']");
    private final By _txtConfirmPassword = By.xpath("//input[@id='confirmPassword']");
    private final By _btnChangePassword = By.xpath("//*[@id=\"ChangePW\"]/fieldset/p/input");
    private final By lblChangePWMassage = By.xpath("//*[@id=\"ChangePW\"]/fieldset/p[1]");
    private final By lblChangePWErrors = By.xpath("//*[@id=\"ChangePW\"]/fieldset/p[1]");
    private final By lblConfirmPWErrors=By.xpath("//*[@id=\"ChangePW\"]/fieldset/ol/li[3]/label[2]");
    public WebElement getTxtCurrentPassword(){

        return Constant.WEBDRIVER.findElement(_txtCurrentPassword);
    }
    public WebElement getTxtNewPassword(){

        return Constant.WEBDRIVER.findElement(_txtNewPassword);
    }
    public WebElement getTxtConfirmPassword(){

        return Constant.WEBDRIVER.findElement(_txtConfirmPassword);
    }
    public WebElement getBtnChangePassword(){
        return Constant.WEBDRIVER.findElement(_btnChangePassword);
    }
//    public WebElement getTabChangPassword() {
//
//        return Constant.WEBDRIVER.findElement(tabChangePassword);
//    }
    public WebElement getLblChangePWMassage() {

        return Constant.WEBDRIVER.findElement(lblChangePWMassage);
    }
    public WebElement getLblChangePWErrors() {

        return Constant.WEBDRIVER.findElement(lblChangePWErrors);
    }
    public WebElement getLblConfirmPWErrors(){
        return Constant.WEBDRIVER.findElement(lblConfirmPWErrors);
    }
    public HomePage changePassword(String currentPW,String newPW,String confirmPW){
        JavascriptExecutor js = (JavascriptExecutor) Constant.WEBDRIVER;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        this.getTxtCurrentPassword().sendKeys(currentPW);
        this.getTxtNewPassword().sendKeys(newPW);
        this.getTxtConfirmPassword().sendKeys(confirmPW);
        this.getBtnChangePassword().click();
        return new HomePage();
    }

}

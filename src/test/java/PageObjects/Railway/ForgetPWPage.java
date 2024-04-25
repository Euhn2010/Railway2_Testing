package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class ForgetPWPage extends GeneralPage{
    private final By _txtEmail=By.xpath("//*[@id=\"email\"]");
    private final  By _btnSendResetPW=By.xpath("//*[@id=\"content\"]/form/fieldset/p[2]/input");
    private final By _lblForgetPasswordErrorMsg = By.xpath("//*[@id=\"content\"]/form/fieldset/ol/li/label[2]");

    public WebElement getTxtEmail(){
        return Constant.WEBDRIVER.findElement(_txtEmail);
    }
    public WebElement getBtnSendResetPW(){return Constant.WEBDRIVER.findElement(_btnSendResetPW);}
    public WebElement getLblForgetPasswordErrorMsg(){ return Constant.WEBDRIVER.findElement(_lblForgetPasswordErrorMsg);}
    public HomePage forgetPW(String email){
        JavascriptExecutor js = (JavascriptExecutor) Constant.WEBDRIVER;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        this.getTxtEmail().sendKeys("huethitran123@gmail.com");
        this.getBtnSendResetPW().click();
        return new HomePage();


}}

package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class RegisterPage extends GeneralPage{
    private final By _txtEmail = By.xpath("//input[@id='email']");
    private final By _txtPassword = By.xpath("//input[@id='password']");
    private final By _txtConfirmPassword = By.xpath("//input[@id='confirmPassword']");
    private final By _txtPID=By.xpath("//input[@id='pid']");
    private final By _btnRegister = By.xpath("//*[@id=\"RegisterForm\"]/fieldset/p/input");
    private final By lblRegisterMassage = By.xpath("//div[@id='content']/p");
    private final By lblRegisterErrors=By.xpath("//*[@id=\"content\"]/p[2]");
    private final By lblRegisterErrorsPW=By.xpath("//*[@id=\"RegisterForm\"]/fieldset/ol/li[2]/label[2]");
    private final By lblRegisterErrorsPID=By.xpath("//*[@id=\"RegisterForm\"]/fieldset/ol/li[4]/label[2]");
    private final By lblRegisterErrorsConfirmPW= By.xpath("//*[@id=\"content\"]/p[2]");

    public WebElement getTxtEmail(){
        return Constant.WEBDRIVER.findElement(_txtEmail);
    }
    public WebElement getTxtPassword(){
        return Constant.WEBDRIVER.findElement(_txtPassword);
    }
    public WebElement getTxtConfirmPassword(){
        return Constant.WEBDRIVER.findElement(_txtConfirmPassword);
    }
    public WebElement getTxtPID(){
        return Constant.WEBDRIVER.findElement(_txtPID);
    }

    public WebElement getBtnRegister(){
        return Constant.WEBDRIVER.findElement(_btnRegister);
    }
    public WebElement getLblRegisterMassage() {
        return Constant.WEBDRIVER.findElement(lblRegisterMassage);
    }
    public WebElement getLblRegisterErrors(){
        return Constant.WEBDRIVER.findElement(lblRegisterErrors);
    }
    public WebElement getLblRegisterErrorsConfirmPW(){return  Constant.WEBDRIVER.findElement(lblRegisterErrorsConfirmPW);
    }
    public  WebElement getLblRegisterErrorsPW(){
        return Constant.WEBDRIVER.findElement(lblRegisterErrorsPW);
    }
    public  WebElement getLblRegisterErrorsPID(){
        return Constant.WEBDRIVER.findElement(lblRegisterErrorsPID);
    }
    public HomePage register(String email, String password, String confirmpassword, String PID){
        JavascriptExecutor js = (JavascriptExecutor) Constant.WEBDRIVER;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        this.getTxtEmail().sendKeys(email);
        this.getTxtPassword().sendKeys(password);
        this.getTxtConfirmPassword().sendKeys(confirmpassword);
        this.getTxtPID().sendKeys(PID);
        this.getBtnRegister().click();
        return new HomePage();
    }
}

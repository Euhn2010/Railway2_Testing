package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.*;

public class GeneralPage {
    //Locators
    private final By tabLogin = By.xpath("//div[@id='menu']//a[@href='/Account/Login.cshtml']");
    private final By tabLogout = By.xpath("//div[@id='menu']//a[@href='/Account/Logout']");
    private final By lblWelcomeMassage = By.xpath("//div[@class='account']/strong");
    private final By tabBookTicket = By.xpath("//div[@id='menu']//a[@href='/Page/BookTicketPage.cshtml']");
    private final By tabMyTicket = By.xpath("//div[@id='menu']//a[@href='Page/ManageTicket.cshtml']");
    private final By tabChangePassword = By.xpath("//div[@id='menu']//a[@href='Account/ChangePassword.cshtml']");
    private final By tabRegister=By.xpath("//div[@id='menu']//a[@href='/Account/Register.cshtml']");
    private final By tabTimeTable = By.xpath("//div[@id='menu']//a[@href='TrainTimeListPage.cshtml']");
    private final By tabForgetPassword = By.xpath("//div[@id='content']//a[@href='/Account/ForgotPassword.cshtml']");

    //Element
    protected WebElement getTabLogin() {
        return Constant.WEBDRIVER.findElement(tabLogin);
    }

    protected WebElement getTabLogout() {
        return Constant.WEBDRIVER.findElement(tabLogout);
    }
    protected WebElement getTabBookTicket() {
        return Constant.WEBDRIVER.findElement(tabBookTicket);
    }
    protected  WebElement getTabMyTicket(){
        return Constant.WEBDRIVER.findElement(tabMyTicket);
    }
    protected  WebElement getTabChangePassword(){
        return Constant.WEBDRIVER.findElement(tabChangePassword);
    }
    protected  WebElement getTabRegister(){
        return Constant.WEBDRIVER.findElement(tabRegister);
    }
    protected WebElement getTabTimeTable() {
        return Constant.WEBDRIVER.findElement(tabTimeTable);
    }
    protected WebElement getTabForgetPW(){ return Constant.WEBDRIVER.findElement(tabForgetPassword); }
    protected WebElement getLblWelcomeMassage() {
        return Constant.WEBDRIVER.findElement(lblWelcomeMassage);
    }

    //Methods
    public String getWelcomeMessage(){
        return this.getLblWelcomeMassage().getText();
    }

   public ForgetPWPage gotoForgetPW(){
       JavascriptExecutor js = (JavascriptExecutor) Constant.WEBDRIVER;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        this.getTabForgetPW().click();
        return new ForgetPWPage();
   }
    public LoginPage gotoLoginPage(){
        this.getTabLogin().click();
        return new LoginPage();
    }
    public LogoutPage gotoLogoutPage(){
        this.getTabLogout().click();
        return new LogoutPage();
    }

    public BookTicketPage gotoBookTicketPage() {
        this.getTabBookTicket().click();
        return new BookTicketPage();
    }
    public MyTicketPage gotoMyTicketPage(){
        this.getTabMyTicket().click();
        return new MyTicketPage();

    }
    public ChangePasswordPage gotoChangePasswordPage(){
        this.getTabChangePassword().click();
        return new ChangePasswordPage();
    }
    public RegisterPage gotoRegisterPage(){
        this.getTabRegister().click();
        return new RegisterPage();
    }
    public TimeTablePage gotoTimeTablePage(){
        this.getTabTimeTable().click();
        return new TimeTablePage();
    }



}


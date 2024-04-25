package Testcases.Railway;

import Common.Common.Utilities;
import Common.Constant.Constant;
import PageObjects.Railway.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class LoginTest {
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("pre-condition");
        System.setProperty("Webdriver.chrome.driver", Utilities.getProjectPath()
        + "\\Executables\\chromedriver.exe");
        Constant.WEBDRIVER = new ChromeDriver();
        Constant.WEBDRIVER.manage().window().maximize();

    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("Post-condition");
        Constant.WEBDRIVER.quit();
    }
    @Test
    public void TC01() throws InterruptedException {
        System.out.println("TC01 - User can log into Railway with valid username and password");
        HomePage homePage=new HomePage();
        homePage.open();
        LoginPage loginPage=homePage.gotoLoginPage();
        String actualMsg=loginPage.login(Constant.USERNAME,Constant.PASSWORD).getWelcomeMessage();
        String expectedMsg="Welcome"+Constant.USERNAME;
        Thread.sleep(3000);

    }
    @Test
    public void TC02() throws InterruptedException {
        System.out.println("TC02 - User can't login with blank \"Username\" textbox");
        HomePage homePage=new HomePage();
        homePage.open();
        LoginPage loginPage=homePage.gotoLoginPage();
        loginPage.login("",Constant.PASSWORD).getWelcomeMessage();
        String actualErrorMsg = loginPage.getLblLoginErrorMsg().getText();
        String expectedErrorMsg = "There was a problem with your login and/or errors exist in your form.";
        Assert.assertEquals(actualErrorMsg, expectedErrorMsg, "Error message is not displayed as expected");
        Thread.sleep(3000);
    }
    @Test
    public void TC03() throws InterruptedException {
        System.out.println("TC03 - User cannot log into Railway with invalid password ");
        HomePage homePage=new HomePage();
        homePage.open();
        LoginPage loginPage=homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME,"12346799").getWelcomeMessage();
        String actualErrorMsg = loginPage.getLblLoginErrorMsg().getText();
        String expectedErrorMsg="There was a problem with your login and/or errors exist in your form";
        Assert.assertEquals(actualErrorMsg,expectedErrorMsg,"Error message is not displayed as expected");
        Thread.sleep(5000);
    }
    @Test
    public void TC04() throws InterruptedException{
        System.out.println("TC04 - Login page displays when un-logged User clicks on \"Book ticket\" tab");
        HomePage homePage=new HomePage();
        homePage.open();

        try {
            BookTicketPage bookTicketPage=homePage.gotoBookTicketPage();

            String actualUrl = Constant.WEBDRIVER.getCurrentUrl();
            String expectedUrl = "http://railwayb2.somee.com/Account/Login.cshtml?ReturnUrl=/Page/BookTicketPage.cshtml";

            Assert.assertEquals(actualUrl, expectedUrl, "Browser is not navigated as expected");
        } catch (org.openqa.selenium.NoSuchElementException e) {
            Assert.fail("Login page is not displayed");
        }
//        String expectedMsg="Login page displays instead of Book ticket page";
        Thread.sleep(3000);

    }
    @Test
    public void TC05() throws InterruptedException {
        System.out.println("TC05 - System shows message when user enters wrong password several times");
        HomePage homePage = new HomePage();
        homePage.open();
        LoginPage loginPage = homePage.gotoLoginPage();
        boolean hasEnteredUsername = false; // Kiểm tra xem đã nhập email hay chưa

        for (int i = 0; i < 4; i++) {
            if (!hasEnteredUsername) {
                loginPage.login("tranthihue123@gmail.com", "12346779").getWelcomeMessage();
                hasEnteredUsername = true;
            } else {
                loginPage.login("", "123456789").getWelcomeMessage();
            }
        }
        String actualErrorMsg = loginPage.getLblLoginErrorMsg().getText();
        String expectedErrorMsg = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";
        Assert.assertEquals(actualErrorMsg, expectedErrorMsg, "Error message is not displayed as expected");
        Thread.sleep(3000);
    }
@Test
public void TC06() {
    System.out.println("TC06 - Additional Pages display once user logged in");
    HomePage homePage = new HomePage();
    homePage.open();
    LoginPage loginPage = homePage.gotoLoginPage();
    homePage = loginPage.login(Constant.USERNAME, Constant.PASSWORD);

     //Ticket Tab
    try {
        MyTicketPage myTicketPage = homePage.gotoMyTicketPage();

        String actualUrl = Constant.WEBDRIVER.getCurrentUrl();
        String expectedUrl = "http://railwayb2.somee.com/Page/ManageTicket.cshtml";

        Assert.assertEquals(actualUrl, expectedUrl, "Browser is not navigated as expected");
    } catch (org.openqa.selenium.NoSuchElementException e) {
        Assert.fail("\"My ticket\" tab is not displayed");
    }

    // ChangePassword Tab
    try {
        ChangePasswordPage changePasswordPage = homePage.gotoChangePasswordPage();

        String actualUrl = Constant.WEBDRIVER.getCurrentUrl();
        String expectedUrl = "http://railwayb2.somee.com/Account/ChangePassword.cshtml";

        Assert.assertEquals(actualUrl, expectedUrl, "Browser is not navigated as expected");
    } catch (org.openqa.selenium.NoSuchElementException e) {
        Assert.fail("\"Change password\" tab is not displayed");
    }

    // Logout Tab
    try {
        LogoutPage logoutPage = homePage.gotoLogoutPage();

    } catch (org.openqa.selenium.NoSuchElementException e) {
        Assert.fail("\"Logout\" tab is not displayed");
    }
}

    @Test
    public void TC07() throws InterruptedException{
        System.out.println("TC07 - User can create new account");
        HomePage homePage= new HomePage();
        homePage.open();
        RegisterPage registerPage=homePage.gotoRegisterPage();
        registerPage.register("tthueue15284@gmail.com","12345678","12345678","11111111").getWelcomeMessage();
        String actualMessage = registerPage.getLblRegisterMassage().getText();
        String expectedMessage = "Thank you for registering your account";
        Assert.assertEquals(actualMessage, expectedMessage);
        Thread.sleep(6000);
    }
    @Test
    public void TC08() throws InterruptedException{
        System.out.println("TC08 - User can't login with an account hasn't been activated");
        HomePage homePage= new HomePage();
        homePage.open();
        LoginPage loginPage=homePage.gotoLoginPage();
        loginPage.login("tthue2010@gmail.com","12345678").getWelcomeMessage();
        String actualErrors=loginPage.getLblLoginErrorMsg().getText();
        String expectedErrors="Invalid username or password. Please try again.";
        Assert.assertEquals(actualErrors, expectedErrors);
        //Thread.sleep(6000);
    }
    @Test
    public void TC09() throws InterruptedException {
        System.out.println("TC09 - User can change password");
        HomePage homePage = new HomePage();
        homePage.open();
        LoginPage loginPage = homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD).getWelcomeMessage();
        Thread.sleep(3000);
        ChangePasswordPage changePasswordPage = homePage.gotoChangePasswordPage();
        changePasswordPage.changePassword(Constant.PASSWORD, "88888888", "8888888");
        String actualMessage = changePasswordPage.getLblChangePWMassage().getText();
        String expectedMessage = "Your password has been updated";
        Assert.assertEquals(actualMessage, expectedMessage,"Error is not displayed as expected");
    }
    @Test
    public void TC10() {
        System.out.println("TC10 - User can't create account with \"Confirm password\" is not the same with \"Password\"");
        HomePage homePage = new HomePage();
        homePage.open();

        RegisterPage registerPage = homePage.gotoRegisterPage();
        registerPage.register("DTTHuong@gmail.com","12345678","12345679","11111111");

        String ActualMsg = registerPage.getLblRegisterErrorsConfirmPW().getText();
        String ExpectedMsg = "There're errors in the form. Please correct the errors and try again.";

        Assert.assertEquals(ActualMsg, ExpectedMsg, "Error is not displayed as expected");
    }
    @Test
    public void TC11() throws InterruptedException{
        System.out.println("TC11 - User can't create account while password and PID fields are empty");
        HomePage homePage= new HomePage();
        homePage.open();
        RegisterPage registerPage=homePage.gotoRegisterPage();
        registerPage.register("tthuee158@gmail.com","","","").getWelcomeMessage();
        String actualMessage = registerPage.getLblRegisterErrors().getText();
        String expectedMessage = "There're errors in the form. Please correct the errors and try again.";
        String actualErrorsPW = registerPage.getLblRegisterErrorsPW().getText();
        String expectedErrorsPW ="Invalid password length.";
        String actualErrorsPID = registerPage.getLblRegisterErrorsPID().getText();
        String expectedErrorsPID ="Invalid ID length.";


        Assert.assertEquals(actualMessage, expectedMessage,"Error message is not displayed as expected");
        Assert.assertEquals(actualErrorsPW, expectedErrorsPW,"Error message is not displayed as expected");
        Assert.assertEquals(actualErrorsPID, expectedErrorsPID,"Error message is not displayed as expected");
        Thread.sleep(8000);
    }
    @Test
    public void TC12() throws InterruptedException {
        System.out.println("TC12 - Errors display when password reset token is blank");
        HomePage homePage = new HomePage();
        homePage.open();
        LoginPage loginPage = homePage.gotoLoginPage();

        ForgetPWPage forgetPWPage= homePage.gotoForgetPW();
        forgetPWPage.getTxtEmail().sendKeys("huethitran123@gmail.com");
        forgetPWPage.getBtnSendResetPW().click();

        String actualErrorMsg = "Mail box can not open!";
        String expectedErrorMsg = "Mail box opened.";
        Assert.assertEquals(actualErrorMsg,expectedErrorMsg,"Mail box fail, can not change password");

    }
    @Test
    public void TC14() throws InterruptedException {
        System.out.println("TC14 - User can book 1 ticket at a time");
        HomePage homePage = new HomePage();
        homePage.open();
        homePage = homePage.gotoLoginPage().login(Constant.USERNAME,Constant.PASSWORD);
        BookTicketPage bookTicketPage = homePage.gotoBookTicketPage();
        String departDate = LocalDate.now().plusDays(5).format(DateTimeFormatter.ofPattern("M/d/yyyy"));
        String departFrom = "Sài Gòn";
        String arriveAt = "Nha Trang";
        String seatType = "Soft bed with air conditioner";
        Integer ticketAmount = 1;
        String ticketID = bookTicketPage.BookTicket(departDate, departFrom, arriveAt, seatType, ticketAmount);

        // Success Message
        String ActualMsg = bookTicketPage.getBookMessage();
        String ExpectedMsg = "Ticket booked successfully!";
        Assert.assertEquals(ActualMsg, ExpectedMsg, "Success Message is not displayed as expected");
        Thread.sleep(6000);
        // Ticket Information
        List<String> infors = bookTicketPage.getTicketInformation();
        //0: Depart Station, 1: Arrive Station, 2: Seat Type, 3: Depart Date, 4: Book Date, 5: Expired Date, 6: Amount, 7: Total Price

        // Depart Station
        Assert.assertEquals(infors.get(0), departFrom, "Depart Station is not correct");
        // Arrive Station
        Assert.assertEquals(infors.get(1), arriveAt, "Arrive Station is not correct");
        // Seat Type
        Assert.assertEquals(infors.get(2), seatType, "Seat Type is not correct");
        // Depart Date
        Assert.assertEquals(infors.get(3), departDate, "Depart Date is not correct");
        // Amount
        Assert.assertEquals(infors.get(6), String.valueOf(ticketAmount), "Ticket Amount is not correct");

    }

    @Test
    public void TC15() throws InterruptedException {
        System.out.println("TC15 - User can open \"Book ticket\" page by clicking on \"Book ticket\" link in \"Train timetable\" page");
        HomePage homePage = new HomePage();
        homePage.open();
        LoginPage loginPage = homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD).getWelcomeMessage();
        TimeTablePage timeTablePage = homePage.gotoTimeTablePage();
        timeTablePage.timetable().getWelcomeMessage();
        String departure = Constant.WEBDRIVER.findElement(By.xpath("//*[@id=\"content\"]/div[1]/form/fieldset/ol/li[2]/select/option[@selected='selected']")).getText();
        String arrive = Constant.WEBDRIVER.findElement(By.xpath("//*[@id=\"ArriveStation\"]/select/option[@selected='selected']")).getText();
        Assert.assertEquals(departure, "Huế","Book ticket page is loaded with incorrect depart from and arrive at");
        Assert.assertEquals(arrive, "Sài Gòn","Book ticket page is loaded with incorrect depart from and arrive at");
    }
}



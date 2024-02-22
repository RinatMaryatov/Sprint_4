package page.object;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.example.UrlHomePage.URL;
import static org.hamcrest.CoreMatchers.containsString;

public class LocatorsOrder {
    private WebDriver webDriver;

    //Кнопка принятия кук
    private final By buttonCookie = By.xpath(".//button[@id = 'rcc-confirm-button']");

    //Кнопки раздела Заказать самокат(общая информация о клиенте: имя, фамилия, адрес, станция метро, номер)
    //Кнопка Заказать из шапки сайта(начать оформление заказа)
    private  final By buttonOrderScooterStart = By.xpath(".//button[@class =  'Button_Button__ra12g' and text() = 'Заказать']");
    //Кнопка Заказать из раздела Как это работает
    private  final By buttonOrderScooterStartTwo = By.xpath(".//button[@class =  'Button_Button__ra12g' and text() = 'Заказать']");
    //Поле Имя
    private  final  By nameField = By.xpath(".//input[@placeholder = '* Имя']");
    //Поле Фамилия
    private  final  By lastNameField = By.xpath(".//input[@placeholder = '* Фамилия']");
    //Поле адрес:куда привезти самокат
    private  final By addressField = By.xpath(".//input[@placeholder = '* Адрес: куда привезти заказ']");
    //Поле(выпадающий список) станция метро
    private  final  By metroStationField = By.xpath(".//input[@class = 'select-search__input']");
    //Поле Телефон
    private  final By numberField = By.xpath(".//input[@placeholder = '* Телефон: на него позвонит курьер']");
    //Кнопка Далее
    private  final By continueButton = By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM']");


    //Кнопки раздела Про аренду
    //Поле(календарь) Когда привезти самокат
    private  final By deliveryDateField = By.xpath(".//input[@placeholder = '* Когда привезти самокат']");
    //Область календаря
    private final  By calendarDelivery = By.xpath(".//div[@class = 'react-datepicker']");
    //Выбранная дата из календаря
    final By dateFromCalendar = By.xpath(".//div[contains(@aria-label, '17-е февраля 2024 г.')]");
    //Поле(выпадающий список) Срок аренды
    private  final  By rentalPeriodField = By.xpath(".//div[@class = 'Dropdown-placeholder']");
    //Выбранный из списка период аренды
    final By periodFromMenu = By.xpath(".//div[@class =  'Dropdown-option' and text() = 'трое суток'] ");
    //Меню выбора периода аренды
    private  final By rentalPeriodMenu = By.xpath(".//div[@class = 'Dropdown-menu']");
    //Чек бокс Цвет самоката черный
    private  final  By checkBoxBlackColor = By.xpath(".//input[@id = 'black']");
    //Чек бокс Цвет самоката серый
    private  final  By checkBoxGrayColor = By.xpath(".//input[@id = 'grey']");

    //Поле Комментарий для курьера
    private  final By commentFieldForCourier = By.xpath(".//input[@placeholder = '* Когда привезти самокат']");
    //Кнопка Заказать(завершение оформления заказа)
    private  final By buttonOrderScooterFinish = By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM']");


    //Элементы всплывающего окна Хотите оформить заказ?
    //Текст Хотите оформить заказ?(всплывающее окно)
    private  final By textWantToPlaceOrder = By.cssSelector("div[class = 'Order_ModalHeader__3FDaJ']");
    //Кнопка Да (всплывающее окно)
    private  final By orderConfirmationButton = By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']");


    //Элементы всплывающего окна Заказ оформлен
    //Текст, появляющийся в окне Заказ оформлен
    private  final By textOrderIsProcessed = By.xpath(".//div[@class = 'Order_Text__2broi']");


    private final By formaWhoIsTheScooterFor = By.xpath(".//div[@class = 'Order_Form__17u6u']");
    //Методы раздела Заказать самокат(общая информация о клиенте: имя, фамилия, адрес, станция метро, номер)
    public LocatorsOrder(WebDriver webDriver) {this.webDriver = webDriver; }

    public boolean checkShownFormaWhoIsTheScooterFor() {
        return !webDriver.findElements(formaWhoIsTheScooterFor).isEmpty();
    }

    public LocatorsOrder open(){
        webDriver.get(URL);
        return this;
    }

    public LocatorsOrder acceptCookies(){
        webDriver.findElement(buttonCookie).click();
        return this;
    }

    public LocatorsOrder clickOnButtonOrderScooterStart(){
        webDriver.findElement(buttonOrderScooterStart).click();
        return this;
    }

    public LocatorsOrder clickOnButtonOrderScooterStartTwo(){
        WebElement buttonStartOrder = webDriver.findElement(buttonOrderScooterStartTwo);
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", buttonStartOrder);
        webDriver.findElement(buttonOrderScooterStartTwo).click();
        return this;
    }

    public LocatorsOrder setNameField(String name){
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.presenceOfElementLocated(nameField));
        webDriver.findElement(nameField).sendKeys(name);
        return this;
    }

    public LocatorsOrder setLastNameField(String lastName){
        webDriver.findElement(lastNameField).sendKeys(lastName);
        return  this;
    }

    public LocatorsOrder setaddressField(String address){
        webDriver.findElement(addressField).sendKeys(address);
        return  this;
    }

    public LocatorsOrder selectMetroStationField(String metroStation){
        webDriver.findElement(metroStationField).click();
        webDriver.findElement(metroStationField).sendKeys(metroStation);
        WebElement selectMetroStation = webDriver.findElement(metroStationField);
        selectMetroStation.sendKeys(Keys.ARROW_DOWN);
        selectMetroStation.sendKeys(Keys.ENTER);
        return this;
    }

    public LocatorsOrder setNumberField (String number){
        webDriver.findElement(numberField).sendKeys(number);
        return this;
    }

    public LocatorsOrder clickContinueButton(){
        new WebDriverWait(webDriver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(webDriver.findElement(continueButton)));
        webDriver.findElement(continueButton).click();
        return this;
    }

    public LocatorsOrder generalInformationAboutUser(String name, String lastName, String address, String metroStation, String number){
        setNameField(name);
        setLastNameField(lastName);
        setaddressField(address);
        selectMetroStationField(metroStation);
        setNumberField(number);
        clickContinueButton();
        return this;
    }


    //Методы раздела Про аренду
    public LocatorsOrder selectDeliveryDate(String date){
        webDriver.findElement(deliveryDateField).click();
        webDriver.findElement(deliveryDateField).sendKeys(date);
        webDriver.findElement(calendarDelivery);
        webDriver.findElement(dateFromCalendar).click();
        return this;
    }

    public LocatorsOrder selectRentalPeriod(){
        webDriver.findElement(rentalPeriodField).click();
        webDriver.findElement(rentalPeriodMenu);
        webDriver.findElement(periodFromMenu).click();
        return this;
    }

    public LocatorsOrder chooseCheckBoxBlackColor(){
        webDriver.findElement(checkBoxBlackColor).click();
        return  this;
    }
    public LocatorsOrder chooseCheckBoxGrayColor(){
        webDriver.findElement(checkBoxGrayColor).click();
        return  this;
    }

    public LocatorsOrder setCommentFieldForCourier(String comment){
        webDriver.findElement(commentFieldForCourier).sendKeys(comment);
        return this;
    }

    public LocatorsOrder clickButtonOrderScooterFinish(){
        new WebDriverWait(webDriver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(webDriver.findElement(buttonOrderScooterFinish)));
        webDriver.findElement(buttonOrderScooterFinish).click();
        return this;
    }

    //Методы всплывающего окна Хотите оформить заказ?
    public LocatorsOrder checkTextWantToPlaceOrder(){
        boolean checkShown = webDriver.findElements(textWantToPlaceOrder).size() > 0;
        return this;
    }

    public LocatorsOrder clickOrderConfirmationButton(){
        new WebDriverWait(webDriver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(webDriver.findElement(orderConfirmationButton)));
        webDriver.findElement(orderConfirmationButton).click();
        return this;
    }

    //Методы всплывающего окна Заказ оформлен
    public LocatorsOrder checkTextOrderIsProcessed(){
        String textOrder =  webDriver.findElement(textOrderIsProcessed).getText();
        Assert.assertThat(textOrder, containsString("Номер заказа:"));
        Assert.assertThat(textOrder, containsString(".  Запишите его:"));
        Assert.assertThat(textOrder, containsString("пригодится, чтобы отслеживать статус"));
        System.out.println(textOrder);
        return this;
    }

}







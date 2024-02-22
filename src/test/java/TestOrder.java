import org.example.ChromeRule;
import org.example.FirefoxRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import page.object.LocatorsOrder;

@RunWith(Parameterized.class)
public class TestOrder {
    private final String name;
    private final String lastName;
    private final String address;
    private final String metroStation;
    private final String number;
    private final String date;
    private final String comment;

    public TestOrder(String name, String lastName, String address, String metroStation, String number, String date, String comment){
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.metroStation = metroStation;
        this.number = number;
        this.date = date;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] getInformationAboutOrder () {
        return new Object[][]{
                {"Ринат", "Марятов", "ул.Ленина, 52, кв.188", "Сокольники", "+79915385011", "17.02.2024", "Покатаемся!"},
                {"Игорь", "Марятов", "ул.Мысхакское шоссе, 57, кв.189", "Сокольники", "+79915385012", "18.02.2024", "С ветерком!"},
                {"Пётр", "Марятов", "ул.Быстрое шоссе, 53, кв.118", "Сокольники", "+79915385013", "19.02.2024", "Врум-врум"},
                {"Андрей", "Марятов", "ул.Опасное шоссе, 51, кв.128", "Сокольники", "+79915385014", "20.02.2024", "Бип-бип"},
        };

    }

    @Rule
    public ChromeRule chromeRule = new ChromeRule();

    @Test
    public void startOrderBlackScooterFromHat() {
        LocatorsOrder locatorsOrder = new LocatorsOrder(chromeRule.getWebDriver());

        locatorsOrder
                .open()
                .acceptCookies()
                .clickOnButtonOrderScooterStart()
                .generalInformationAboutUser(name, lastName, address, metroStation, number)
                .clickContinueButton()
                .selectDeliveryDate(date)
                .selectRentalPeriod()
                .chooseCheckBoxBlackColor()
                .setCommentFieldForCourier(comment)
                .clickButtonOrderScooterFinish()
                .checkTextWantToPlaceOrder()
                .clickOrderConfirmationButton()
                .checkTextOrderIsProcessed();
    }
    @Test
    public void startOrderGrayScooterFromHat() {
        LocatorsOrder locatorsOrder = new LocatorsOrder(chromeRule.getWebDriver());

        locatorsOrder
                .open()
                .acceptCookies()
                .clickOnButtonOrderScooterStart()
                .generalInformationAboutUser(name, lastName, address, metroStation, number)
                .clickContinueButton()
                .selectDeliveryDate(date)
                .selectRentalPeriod()
                .chooseCheckBoxGrayColor()
                .setCommentFieldForCourier(comment)
                .clickButtonOrderScooterFinish()
                .checkTextWantToPlaceOrder()
                .clickOrderConfirmationButton()
                .checkTextOrderIsProcessed();
    }
    @Test
    public void startOrderBlackScooterFromSectionHomePage(){
        LocatorsOrder locatorsOrder = new LocatorsOrder(chromeRule.getWebDriver());
        locatorsOrder
                .open()
                .clickOnButtonOrderScooterStartTwo()
                .generalInformationAboutUser(name, lastName, address, metroStation, number)
                .clickContinueButton()
                .selectDeliveryDate(date)
                .selectRentalPeriod()
                .chooseCheckBoxBlackColor()
                .setCommentFieldForCourier(comment)
                .clickButtonOrderScooterFinish()
                .checkTextWantToPlaceOrder()
                .clickOrderConfirmationButton()
                .checkTextOrderIsProcessed();

    }
    @Test
    public void startOrderGrayScooterFromSectionHomePage(){
        LocatorsOrder locatorsOrder = new LocatorsOrder(chromeRule.getWebDriver());
        locatorsOrder
                .open()
                .clickOnButtonOrderScooterStartTwo()
                .generalInformationAboutUser(name, lastName, address, metroStation, number)
                .clickContinueButton()
                .selectDeliveryDate(date)
                .selectRentalPeriod()
                .chooseCheckBoxGrayColor()
                .setCommentFieldForCourier(comment)
                .clickButtonOrderScooterFinish()
                .checkTextWantToPlaceOrder()
                .clickOrderConfirmationButton()
                .checkTextOrderIsProcessed();

    }
}










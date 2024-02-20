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
                {"Ринат", "Марятов", "ул.Мысхакское шоссе, 59, кв.18", "Сокольники", "+79915385012", "17.02.2024", "Чик-пирик"},
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
}










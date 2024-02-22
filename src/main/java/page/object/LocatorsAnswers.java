package page.object;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.example.UrlHomePage.URL;

public class LocatorsAnswers {
    private final WebDriver webDriver;

    //Локатор: определение вопросов в блоке Вопросы о важном
    private By getQuestionLocator(Integer index) {
        return By.xpath(String.format(".//div[@id = 'accordion__heading-%d']", index));
    }
    //Локатор: определение ответов в блоке Вопросы о важном
    private By getAnswerLocator(Integer index) {
        return By.xpath(String.format(".//div[@id = 'accordion__panel-%d']", index));
    }
    //Локатор класса последнего вопроса для скролла
    private final By lastQuestion = By.className("accordion__heading");


    //Методы для теста ответов блока Вопросы о важном
    public LocatorsAnswers(WebDriver webDriver) {this.webDriver = webDriver; }

    public LocatorsAnswers open() {webDriver.get(URL); return this; }

    public LocatorsAnswers scrollToTheLastQuestionFromQuestionsImportant() {
        WebElement questionsAboutImportant = webDriver.findElement(lastQuestion);
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", questionsAboutImportant);
        return this;
    }

    public LocatorsAnswers clickOnTheQuestion(Integer index) {
        webDriver.findElement(getQuestionLocator(index)).click();
        new WebDriverWait(webDriver, Duration.ofSeconds(4))
                .until(ExpectedConditions.visibilityOf(webDriver.findElement(getAnswerLocator(index))));
        return this;
    }

    public String getAnswer(Integer index) {
        WebElement answerElement = webDriver.findElement(getAnswerLocator(index));
        return answerElement.getText();
    }
}




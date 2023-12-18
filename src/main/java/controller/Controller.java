package controller;

import base.BasePage;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;

import static util.ConfigReader.getUrl;

public class Controller extends BasePage {

    public void openPage() throws IOException {
        driver.get(getUrl());
    }

    public void selectBetLogic(List<WebElement> elements) {
        int count = 0;
        for (WebElement element : elements) {
            if (count % 3 == 0) {
                System.out.println(element.getText());
                waitUntilElementClickable(element).click();
            }
            count++;

            if (count / 3 == 3) {
                break;
            }
        }
    }

    public void selectBetCardLogic(List<WebElement> elements) {
        WebElement secondElement = elements.get(0);
        secondElement.click();
    }
}

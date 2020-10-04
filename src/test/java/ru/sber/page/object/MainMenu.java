package ru.sber.page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class MainMenu {

    Map<String, WebElement[]> menuNamesWebElementMap;

    public MainMenu(WebDriver driver) {
        List<WebElement> webElements = driver.findElements(By.xpath("//*[@id=\"ctl00_UnitedMenu_UnitedPanel\"]/nav/ul/li[*]/span/.."));
        this.menuNamesWebElementMap = webElements.stream().collect(Collectors.toMap(
                webElement -> webElement.findElement(By.tagName("span")).getText(),
                webElement -> new WebElement[]{webElement.findElement(By.tagName("div")), webElement.findElement(By.tagName("span"))})
        );
    }

    public boolean clickOnSubMenuField(String menuName, String subMenuName) {
        WebElement[] menuElements = menuNamesWebElementMap.get(menuName);
        if (menuElements == null) {
            return false;
        }
        menuElements[1].click();
        List<WebElement> linkElements = menuElements[0].findElements(By.tagName("a"));
        Optional<WebElement> optionalSubMenuItem = linkElements.stream()
                .filter(webElement -> webElement.getText().equals(subMenuName))
                .findFirst();
        if (optionalSubMenuItem.isPresent()) {
            optionalSubMenuItem.get().click();
            return true;
        }
        return false;
    }
}

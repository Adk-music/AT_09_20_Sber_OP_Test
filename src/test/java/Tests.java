
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;
import ru.sber.page.object.MainMenu;

public class Tests extends BeforeTests {


    @Test
    public void firstTest() {
        driver.get("https://www.sberbank-ast.ru");
        MainMenu mainMenu = PageFactory.initElements(driver, MainMenu.class);
        Assertions.assertTrue(mainMenu.clickOnSubMenuField("Главная", "Универсальная торговая платформа"),
                "Пункт меню не существует");
        String currentUrl = driver.getCurrentUrl();
        Assertions.assertEquals(currentUrl, "https://utp.sberbank-ast.ru/");
    }

    @Test
    public void secondTest() {
        driver.get("https://www.sberbank-ast.ru");
        MainMenu mainMenu = PageFactory.initElements(driver, MainMenu.class);
        Assertions.assertTrue(mainMenu.clickOnSubMenuField("Закупки", "Закупки по 223-ФЗ"),
                "Пункт меню не существует");
        String currentUrl = driver.getCurrentUrl();
        Assertions.assertEquals(currentUrl, "https://utp.sberbank-ast.ru/Trade/NBT/Index/0/0/0/0");
    }

    @Test
    public void thirdTest() {
        driver.get("https://www.sberbank-ast.ru");
        MainMenu mainMenu = PageFactory.initElements(driver, MainMenu.class);
        Assertions.assertTrue(mainMenu.clickOnSubMenuField("Продажи", "Приватизация, аренда и продажа прав"),
                "Пункт меню не существует");
        String currentUrl = driver.getCurrentUrl();
        Assertions.assertEquals(currentUrl, "https://utp.sberbank-ast.ru/AP/NBT/Index/0/0/0/0");
    }

    @Test
    public void falseMenuNameTest() {
        driver.get("https://www.sberbank-ast.ru");
        MainMenu mainMenu = PageFactory.initElements(driver, MainMenu.class);
        Assertions.assertFalse(mainMenu.clickOnSubMenuField("Не верное имя меню", "Приватизация, аренда и продажа прав"),
                "Пункт меню не должен существовать");
    }

    @Test
    public void falseSubMenuNameTest() {
        driver.get("https://www.sberbank-ast.ru");
        MainMenu mainMenu = PageFactory.initElements(driver, MainMenu.class);
        Assertions.assertFalse(mainMenu.clickOnSubMenuField("Продажи", "Не верное ипя подменю"),
                "Пункт меню не должен существовать");
    }
}

package mailru.nastasiachernega;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class GitHubTests {

    @BeforeEach
    void configure() {
        Configuration.holdBrowserOpen=true;
    }

    @DisplayName("Check the block enterprise is opened")
    @Test
    void checkTheBlockEnterpriseIsOpened() {
        open("https://github.com/");
        $(".HeaderMenu--logged-out").$(byText("Solutions")).hover();
        actions().moveToElement($(byText("Enterprise"))).click().perform();
        $(".application-main ").shouldHave(text("Build like the best"));
    }

    @DisplayName("Drag and drop test")
    @Test
    void dragAndDropTest() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-a").shouldHave(text("A"));
        $("#column-b").shouldHave(text("B"));
        $("#column-a").dragAndDropTo($("#column-b"));
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }

    @DisplayName("Drag and drop test using selenide.actions()")
    @Test
    void dragAndDropTestUsingSelenideActions() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-a").shouldHave(text("A"));
        $("#column-b").shouldHave(text("B"));
        actions().dragAndDrop($("#column-a"),$("#column-b")).perform();
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }

}

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideDocumentationsTest {

    @BeforeEach
    void setUp() {
        Configuration.baseUrl = "https://github.com";
    }

    @Test
    void softAssertionsPageShouldHaveExampleForJUnit5() {
        open("/selenide/selenide");
        $("#wiki-tab").click();
        $("#wiki-pages-filter").setValue("SoftAssertions");
        $("[data-filterable-for=wiki-pages-filter]")
                .find(byText("SoftAssertions"))
                .click();
        $(".markdown-body")
                .find(byText("3. Using JUnit5 extend test class:"))
                .shouldBe(Condition.visible);
    }
}

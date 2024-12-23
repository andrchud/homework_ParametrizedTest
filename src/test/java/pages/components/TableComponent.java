package pages.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class TableComponent {

    public void checkTable (String key, String value) {
        $(".table").$(byText(key)).sibling(0).shouldHave(text(value));
    }
}

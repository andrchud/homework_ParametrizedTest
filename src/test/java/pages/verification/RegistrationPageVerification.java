package pages.verification;

import com.codeborne.selenide.SelenideElement;
import pages.components.TableComponent;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationPageVerification {

    TableComponent tableComponent = new TableComponent();

    public RegistrationPageVerification checkResultTable(String key, String value) {
        tableComponent.checkTable(key, value);

        return this;
    }
}

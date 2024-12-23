package pages.verification;

import com.codeborne.selenide.SelenideElement;
import pages.components.TableComponent;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationPageVerification {

    static String errorIcon = "url(\"data:image/svg+xml,%3csvg xmlns='http://www.w3.org/2000/svg' width='12' height='12' fill='none' stroke='%23dc3545' viewBox='0 0 12 12'%3e%3ccircle cx='6' cy='6' r='4.5'/%3e%3cpath stroke-linejoin='round' d='M5.8 3.6h.4L6 6.5z'/%3e%3ccircle cx='6' cy='8.2' r='.6' fill='%23dc3545' stroke='none'/%3e%3c/svg%3e\")";
    private final SelenideElement resultsTable = $(".table-responsive"),
            phoneInput = $("#userNumber");

    TableComponent tableComponent = new TableComponent();

    public RegistrationPageVerification checkResultTable(String key, String value){
        tableComponent.checkTable(key,value);

        return this;
    }

    public RegistrationPageVerification checkResultTableInvisibility() {
        resultsTable.shouldNotBe(visible);

        return this;
    }
    public RegistrationPageVerification checkPhoneRequired(){
        phoneInput.shouldHave(cssValue("background-image", errorIcon));

        return this;
    }
}

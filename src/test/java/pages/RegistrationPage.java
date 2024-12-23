package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    private final SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderInput = $("#genterWrapper"),
            phoneInput = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbyCheckbox = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            stateSelector = $("#state"),
            citySelector = $("#city"),
            selectorInput = $("#stateCity-wrapper"),
            submitButton = $("#submit");


    CalendarComponent calendarComponent = new CalendarComponent();

    public RegistrationPage openPage(){
        open("/automation-practice-form");

        return this;
    }

    public RegistrationPage deleteBanners(){
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setEmail(String value) {
        emailInput.setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value) {
        genderInput.$(byText(value)).click();

        return this;
    }
    public RegistrationPage setPhone(String value) {
        phoneInput.setValue(value);

        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationPage setSubjectByInput(String subject) {
        subjectsInput.setValue(subject).pressEnter();

        return this;
    }

    public RegistrationPage setHobbyByCheckBox(String hobby) {
        hobbyCheckbox.$(byText(hobby)).click();

        return this;
    }
    public RegistrationPage uploadFile(String path) {
        uploadPicture.uploadFromClasspath(path);

        return this;
    }
    public RegistrationPage setCurrentAddress(String address) {
        addressInput.setValue(address);

        return this;
    }
    public RegistrationPage setState(String state){
        stateSelector.click();
        selectorInput.$(byText(state)).click();

        return this;
    }

    public RegistrationPage setCity(String city){
        citySelector.click();
        selectorInput.$(byText(city)).click();

        return this;
    }

    public RegistrationPage submit() {
        submitButton.click();

        return this;
    }


}

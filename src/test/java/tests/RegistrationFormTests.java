package tests;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import pages.RegistrationPage;
import pages.verification.RegistrationPageVerification;

import static utils.RandomUtils.*;

@DisplayName("Тесты на форму регистрации")
public class RegistrationFormTests extends TestBase {

    String firstName = getFirstName();
    String lastName = getLastName();
    String gender = getGender();
    String email = getUserEmail();
    String phoneNumber = getUserPhone();
    String dayOfBirth = getDayOfBirth();
    String monthOfBirth = getMonthOfBirth();
    String yearOfBirth = getYearOfBirth();
    String state = getState();
    String city = getCity();


    RegistrationPage registrationPage = new RegistrationPage();
    RegistrationPageVerification registrationVerification = new RegistrationPageVerification();

    @BeforeEach
    void openPageRegistration(){
        registrationPage.openPage();
    }

    @CsvSource(value = {
            "ул Маркса 18 к 1 129",
            "st. Main 12 12342"
    })
    @Tags({
            @Tag("REGRESS"),
            @Tag("POSITIVE"),
    })
    @ParameterizedTest(name = "Форма регистрации отпраялется если заполнить адресс {0}")
    void testRegistrationFormSubmissionWithDifferentAddressesOnMultipleLanguages(String currentAddress){

        String[][] expectedValues = {
                {"Student Name", String.format("%s %s",firstName,lastName)},
                {"Student Email", email},
                {"Gender", gender},
                {"Mobile", phoneNumber},
                {"Date of Birth", String.format("%s %s,%s",dayOfBirth,monthOfBirth,yearOfBirth)},
                {"Address", currentAddress},
                {"State and City", String.format("%s %s",state,city)}
        };

        registrationPage.
                deleteBanners().
                setFirstName(firstName).
                setLastName(lastName).
                setEmail(email).
                setGender(gender).
                setPhone(phoneNumber).
                setDateOfBirth(dayOfBirth,monthOfBirth,yearOfBirth).
                setCurrentAddress(currentAddress).
                setState(state).
                setCity(city).
                submit();
        for (String[] pair : expectedValues) {
            registrationVerification.checkResultTable(pair[0],pair[1]);
        }
    }

    @CsvFileSource(resources = "/test_data/persanalDataForRegistration.csv")
    @Tags({
            @Tag("REGRESS"),
            @Tag("POSITIVE"),
    })
    @ParameterizedTest(name = "Форма регистрации отпраялется если заполнять Имя - {0}, Фамилию - {1}")
    void testRegistrationFormSubmissionInMultipleLanguages(String firstName, String lastName){

        String[][] expectedValues = {
                {"Student Name", String.format("%s %s",firstName,lastName)},
                {"Student Email", " "},
                {"Gender", gender},
                {"Mobile", phoneNumber},
                {"Date of Birth", String.format("%s %s,%s",dayOfBirth,monthOfBirth,yearOfBirth)},
                {"Subjects", " "},
                {"Hobbies", " "},
                {"Picture", " "},
                {"Address", " "},
                {"State and City", " "}
        };

        registrationPage.openPage().
                deleteBanners().
                setFirstName(firstName).
                setLastName(lastName).
                setGender(gender).
                setPhone(phoneNumber).
                setDateOfBirth(dayOfBirth,monthOfBirth,yearOfBirth).
                submit();
        for (String[] pair : expectedValues) {
            registrationVerification.checkResultTable(pair[0],pair[1]);
        }
    }

    @ValueSource(strings = {
            "Male",
            "Female",
            "Other"}
    )
    @Tags({
            @Tag("SMOKE"),
            @Tag("POSITIVE"),
    })
    @ParameterizedTest(name = "Регистрация должна пройти с полом {0}")
    void testRegistrationFormWithDifferentGenders(String gender){
        String[][] expectedValues = {
                {"Student Name", String.format("%s %s",firstName,lastName)},
                {"Student Email", " "},
                {"Gender", gender},
                {"Mobile", phoneNumber},
                {"Date of Birth", String.format("%s %s,%s",dayOfBirth,monthOfBirth,yearOfBirth)},
                {"Subjects", " "},
                {"Hobbies", " "},
                {"Picture", " "},
                {"Address", " "},
                {"State and City", " "}
        };
        registrationPage.
                deleteBanners().
                setFirstName(firstName).
                setLastName(lastName).
                setGender(gender).
                setPhone(phoneNumber).
                setDateOfBirth(dayOfBirth,monthOfBirth,yearOfBirth).
                submit();
        for (String[] pair : expectedValues) {
            registrationVerification.checkResultTable(pair[0],pair[1]);
        }
    }
}

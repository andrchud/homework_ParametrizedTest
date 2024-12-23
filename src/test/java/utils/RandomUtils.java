package utils;

import com.github.javafaker.Faker;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class RandomUtils {
    private static String state;

    static Faker faker = new Faker(new Locale("en-GB"));

    public static String getFirstName() {
        return faker.name().firstName();
    }

    public static String getLastName() {
        return faker.name().lastName();
    }

    public static String getGender() {
        return faker.options().option("Male", "Female", "Other");
    }

    public static String getUserEmail() {
        return faker.internet().emailAddress();
    }

    public static String getUserPhone() {
        return faker.number().digits(10);
    }

    public static String getDayOfBirth() {
        int day = getRandomNumber(1, 25);
        return String.valueOf(day);
    }

    public static String getMonthOfBirth() {
        return faker.options().option("January", "February", "March", "April", "May", "June", "July",
                "August", "September", "October", "November", "December");
    }
    public static String getYearOfBirth() {
        int year = getRandomNumber(1924, 2024);
        return String.valueOf(year);
    }

    public static String getSubject() {
        return faker.options().option("Accounting", "Arts", "Biology",
                "Chemistry", "Civics", "Commerce", "Computer Science", "Economics", "English", "Hindi",
                "History", "Maths", "Physics", "Social Studies");
    }

    public static String getHobby() {
        return faker.options().option("Sports", "Reading", "Music");
    }

    public static String getPicture() {
        return faker.options().option("orshnik.png", "topol.png");
    }

    public static String getStreetAddress() {
        return faker.address().streetAddress();
    }

    public static String getState() {
        state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
        return state;
    }

    public static String getCity() {
        Map<String, List<String>> citiesMap = new HashMap<>() {{
            put("NCR", List.of("Delhi", "Gurgaon", "Noida"));
            put("Uttar Pradesh", List.of("Agra", "Lucknow", "Merrut"));
            put("Haryana", List.of("Karnal", "Panipat"));
            put("Rajasthan", List.of("Jaipur", "Jaiselmer"));
        }};
        List<String> cities = citiesMap.get(state);
        if (cities != null && !cities.isEmpty()) {
            int randomNumber = getRandomNumber(0, cities.size());
            return cities.get(randomNumber);
        }
        return null;
    }

    private static int getRandomNumber(int numberStart, int numberEnd) {
        return faker.number().numberBetween(numberStart, numberEnd);
    }
}

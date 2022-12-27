package tests.data;

import com.github.javafaker.Faker;

import java.util.Locale;

public class UserData {
    private static final Faker faker = new Faker(new Locale("en"));

    public static String invalidEmail = faker.internet().emailAddress();

    public static String invalidPassword = faker.internet().password();

}

package maxim.kim.Tests;

import com.github.javafaker.Faker;

import java.util.Locale;

public class TestData {
    static Faker faker = new Faker();


   public static String firstName = faker.name().firstName();
   public static String secondName = faker.name().lastName();
   public static String email = faker.internet().safeEmailAddress();
   public static String mobilePhone = "7777777777";
   public static String address = faker.address().fullAddress();
   public static String stateAndCity = "NCR Delhi";
   public static String gender = "Male";
   public static String day = "01";
   public static String month = "December";
   public static String year = "1998";

}

package ru.jiehk.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.jiehk.pages.RegistrationFormPage;

public class StudentRegistrationFormTest {

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void formTest() {
        String firstName = "Elena";
        String lastName = "Kosiakova";
        String email = "test@test.ru";
        String gender = "Female";
        String mobile = "1234567890";
        String birthYear = "1997";
        String birthMonth = "January";
        String birthDay = "19";
        String subjects = "Maths";
        String hobby = "Sports";
        String pictureName = "test.jpeg";
        String currentAddress = "Test address";
        String state = "NCR";
        String city = "Noida";

        registrationFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setNumber(mobile)
                .setBirthDate(birthYear, birthMonth, birthDay)
                .setSubjects(subjects)
                .setHobby(hobby)
                .uploadPicture("src/test/resources/" + pictureName)
                .setAddress(currentAddress)
                .setState(state)
                .setCity(city)
                .submitForm()
                .checkResultsTableVisible()
                .checkResults("Student Name", firstName + " " + lastName)
                .checkResults("Student Email", email)
                .checkResults("Gender", gender)
                .checkResults("Mobile", mobile)
                .checkResults("Date of Birth", birthDay + " " + birthMonth + "," + birthYear)
                .checkResults("Subjects", subjects)
                .checkResults("Hobbies", hobby)
                .checkResults("Picture", pictureName)
                .checkResults("Address", currentAddress)
                .checkResults("State and City", state + " " + city);
    }
}

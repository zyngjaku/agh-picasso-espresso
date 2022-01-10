package com.example.espresso;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;

/**
 * Test of MainActivity class
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    @Rule
    public ActivityScenarioRule<MainActivity> activityRule = new ActivityScenarioRule<>(MainActivity.class);

//    @Test
//    public void validateIfExistsByeByeTextOnMainScreen() {
//        onView(withText("Bye bye")).check(matches(isDisplayed()));
//    }

    @Test
    public void validateTextViewHelloAfterStart() {
        onView(withId(R.id.textViewHello)).check(matches(isDisplayed()));
        onView(withId(R.id.textViewHello)).check(matches(withText("Hello World!")));

    }

    @Test
    public void validateTextViewValidationAfterStart() {
        onView(withId(R.id.textViewValidation)).check(matches(not(isDisplayed())));
    }

    @Test
    public void validateEditTextTextPersonNameAfterStart() {
        onView(withId(R.id.editTextTextPersonName)).check(matches(withHint("Type your name")));
        onView(withId(R.id.editTextTextPersonName)).check(matches(withText("")));
    }

    @Test
    public void validateTextViewHelloAfterTypeName() {
        onView(withId(R.id.editTextTextPersonName)).perform(typeText("Test"));

        onView(withId(R.id.textViewHello)).check(matches(isDisplayed()));
        onView(withId(R.id.textViewHello)).check(matches(withText("Hello World!")));

    }

    @Test
    public void validateTextViewValidationAfterTypeName() {
        onView(withId(R.id.editTextTextPersonName)).perform(typeText("Test"));

        onView(withId(R.id.textViewValidation)).check(matches(not(isDisplayed())));
    }

    @Test
    public void validateEditTextTextPersonNameAfterStartTypeNameAndClickButton() {
        onView(withId(R.id.editTextTextPersonName)).perform(typeText("Test"));
        onView(withId(R.id.button)).perform(click());

        onView(withId(R.id.editTextTextPersonName)).check(matches(withText("")));
    }

    @Test
    public void validateEditTextTextPersonNameAfterTypeNameAndClickButton() {
        onView(withId(R.id.editTextTextPersonName)).perform(typeText("Test"));
        onView(withId(R.id.button)).perform(click());

        onView(withId(R.id.editTextTextPersonName)).check(matches(withText("")));
    }

    @Test
    public void validateTextViewHelloAfterTypeNameAndClickButton() {
        onView(withId(R.id.editTextTextPersonName)).perform(typeText("Test"));
        onView(withId(R.id.button)).perform(click());

        onView(withId(R.id.textViewHello)).check(matches(isDisplayed()));
        onView(withId(R.id.textViewHello)).check(matches(withText("Hello Test!")));

    }

    @Test
    public void validateTextViewValidationAfterTypeNameAndClickButton() {
        onView(withId(R.id.editTextTextPersonName)).perform(typeText("Test"));
        onView(withId(R.id.button)).perform(click());

        onView(withId(R.id.textViewValidation)).check(matches(not(isDisplayed())));
    }

    @Test
    public void validateTextViewValidationAfterClickButton() {
        onView(withId(R.id.button)).perform(click());

        onView(withId(R.id.textViewValidation)).check(matches(isDisplayed()));
        onView(withId(R.id.textViewValidation)).check(matches(withText("Field cannot be empty!")));
    }

    @Test
    public void validateTextViewValidationAfterClickButtonAndTypeTextAndClickButton() {
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.editTextTextPersonName)).perform(typeText("Test"));
        onView(withId(R.id.button)).perform(click());

        onView(withId(R.id.textViewValidation)).check(matches(not(isDisplayed())));
    }

    @Test
    public void validateTextViewValidationAfterTypeTextAndClickButtonAndClickButton() {
        onView(withId(R.id.editTextTextPersonName)).perform(typeText("Test"));
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.button)).perform(click());

        onView(withId(R.id.textViewValidation)).check(matches(isDisplayed()));
        onView(withId(R.id.textViewValidation)).check(matches(withText("Field cannot be empty!")));
    }

    @Test
    public void validateTextViewHelloAfterTypeNameWithSmallCharsAndClickButton() {
        onView(withId(R.id.editTextTextPersonName)).perform(typeText("test"));
        onView(withId(R.id.button)).perform(click());

        onView(withId(R.id.textViewHello)).check(matches(withText("Hello Test!")));
    }

    @Test
    public void validateTextViewHelloAfterTypeNameWithUppercaseCharsAndClickButton() {
        onView(withId(R.id.editTextTextPersonName)).perform(typeText("TEST"));
        onView(withId(R.id.button)).perform(click());

        onView(withId(R.id.textViewHello)).check(matches(withText("Hello Test!")));
    }

    @Test
    public void validateTextViewHelloAfterTypeNameWithMixedCharsAndClickButton() {
        onView(withId(R.id.editTextTextPersonName)).perform(typeText("TeSt"));
        onView(withId(R.id.button)).perform(click());

        onView(withId(R.id.textViewHello)).check(matches(withText("Hello Test!")));
    }

    @Test
    public void task() {
        // Place for task implementation.
    }
}
package com.example.helloworld;

import android.content.Context;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasErrorText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.espresso.action.ViewActions.typeText;
import static org.hamcrest.Matchers.allOf;

import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class activity_signup__formTest {
    @Rule
    public ActivityScenarioRule<Signup_Form> activityScenarioRule
            = new ActivityScenarioRule<>(Signup_Form.class);

    @Test
    public void hasTextOnScreen() {
        onView(withId(R.id.textView))
                .check(matches(withText("Date:")));
    }

    @Test
    public void canSignup() throws InterruptedException {
        onView(withId(R.id.text_input_name)).perform(typeText("Tim  Lytvynchuk"));
        onView(withId(R.id.text_input_username)).perform(typeText("Timothy98"));
        onView(withId(R.id.text_input_email)).perform(typeText("Tim@gmail.com"));
        onView(withId(R.id.text_input_occupation)).perform(typeText("CS"));
        onView(withId(R.id.text_input_description)).perform(typeText("I love to hike"));

        onView(withId(R.id.button)).perform(scrollTo(),(click()));

        onView(allOf(withId(R.id.text_input_name))).check(matches(withText("Tim Lytvynchuk")));
        onView(allOf(withId(R.id.text_input_username))).check(matches(withText("Timothy98")));
        onView(allOf(withId(R.id.text_input_email))).check(matches(withText("Tim@gmail.com")));
        onView(allOf(withId(R.id.text_input_occupation))).check(matches(withText("CS")));
        onView(allOf(withId(R.id.text_input_description))).check(matches(withText("I love to hike")));
    }

    @Test
    public void noNameEntered() {
        onView(withId(R.id.text_input_name)).perform(typeText(""));
        onView(withId(R.id.button)).perform(scrollTo(),(click()));
        onView(allOf(withId(R.id.text_input_name), hasErrorText("Enter Name")));
    }

    @Test
    public void noUsernameEntered() {
        onView(withId(R.id.text_input_username)).perform(typeText(""));
        onView(withId(R.id.button)).perform(scrollTo(),(click()));
        onView(allOf(withId(R.id.text_input_username), hasErrorText("Enter Username")));
    }

    @Test
    public void noEmailEntered() {
        onView(withId(R.id.text_input_email)).perform(typeText(""));
        onView(withId(R.id.button)).perform(scrollTo(),(click()));
        onView(allOf(withId(R.id.text_input_email), hasErrorText("Enter Email")));
    }

    @Test
    public void noOccupationEntered() {
        onView(withId(R.id.text_input_occupation)).perform(typeText(""));
        onView(withId(R.id.button)).perform(scrollTo(),(click()));
        onView(allOf(withId(R.id.text_input_occupation), hasErrorText("Enter Occupation")));
    }

    @Test
    public void noDescriptionEntered() {
        onView(withId(R.id.text_input_description)).perform(typeText(""));
        onView(withId(R.id.button)).perform(scrollTo(),(click()));
        onView(allOf(withId(R.id.text_input_description), hasErrorText("Enter Description")));
    }
}
package com.example.learningrxjava;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isEnabled;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertTrue;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest {
    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void buttonIsEnabled() {
        onView(withId(R.id.btn_get_posts)).check(matches(isEnabled()));
    }
    @Test
    public void buttonIsClickable() {
        onView(withId(R.id.btn_get_posts)).check(matches((isClickable())));
    }
    @Test
    public void buttonWithText() {
        onView(withId(R.id.btn_get_posts)).check(matches(withText(R.string.get_posts)));
    }
    /*@Test
    public void checkProgressBarDisplayedOnClick() {
        onView(withId(R.id.btn_get_posts)).perform(click());
        onView(withId(R.id.progressBar)).check(matches(isDisplayed()));
    }*/

}
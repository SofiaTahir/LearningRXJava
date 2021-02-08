package com.example.learningrxjava.Fragments;

import android.content.Context;

import com.example.learningrxjava.MainActivity;
import com.example.learningrxjava.Model.Users;
import com.example.learningrxjava.R;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.core.app.ActivityScenario;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasErrorText;
import static androidx.test.espresso.matcher.ViewMatchers.hasFocus;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isEnabled;
import static androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class UserFragmentTest {
    Context context;
    @Before
    public void setUp() throws Exception {
        ActivityScenario.launch(MainActivity.class);/*
                .onActivity(new ActivityScenario.ActivityAction<MainActivity>() {
                    @Override
                    public void perform(MainActivity activity) {
                        activity.setFragment(new UserFragment());
                    }
                });*/
         context = ApplicationProvider.getApplicationContext();
    }

    @Test
    public void isFragmentInView(){
        onView(withId(R.id.main_view_user_fragment)).check(matches(isDisplayed()));
    }
    @Test
    public void shouldDisplayNoteHintForANewNote() {
        onView((withId(R.id.input_user_id)))
                .check(matches(withHint(R.string.user_id_hint_txt)));
    }
    @Test
    public void shouldDisplayFindPostBtn(){
        onView(withId(R.id.btn_find_user)).check(matches(isEnabled()));
    }
    @Test
    public void checkIfProgressDialogIsDisplayedOnClick(){
        onView(withId(R.id.input_user_id)).perform(typeText("1"));
        onView(withId(R.id.btn_find_user)).perform(click());
        onView(withId(R.id.progressBar)).check(matches(isDisplayed()));
    }

    @Test
    public void checkIfGroupViewsNotVisible(){
        //onView(withId(R.id.group)).check(matches(not(isDisplayed())));
        onView(withId(R.id.group)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.GONE)));
    }

    @Test
    public void showErrorOnEmptyInput(){
        onView(withId(R.id.input_user_id)).perform(typeText(" "));
        onView(withId(R.id.btn_find_user)).perform(click());
        onView(withId(R.id.input_user_id)).check(matches(hasErrorText(context.getString(R.string.empty_input_error))));
    }
    @Test
    public void showErrorOnInvalidInput(){
        onView(withId(R.id.input_user_id)).perform(typeText("11"));
        onView(withId(R.id.btn_find_user)).perform(click());
        onView(withId(R.id.input_user_id)).check(matches(hasErrorText(context.getString(R.string.invalid_input_error))));
    }

    /*@Test
    public void checkCorrectUserDataDisplayed(){
        Users userModel = new Users();
        userModel.setId(2);
        userModel.setName("Ervin Howell");
        userModel.setUsername("Antonette");
        userModel.setEmail("Shanna@melissa.tv");

        TestCase.assertNotNull(userModel);
        onView(withId(R.id.input_user_id)).perform(typeText("1"));
        onView(withId(R.id.btn_find_user)).perform(click());
        onView(withId(R.id.input_username)).check(matches(isDisplayed()));
        //onView(withId(R.id.input_id)).check(matches(withText("1")));


    }*/
    /*@Test
    public void testNavigationPostsFragment(){

        onView(withId(R.id.btn_get_posts)).perform(click());
        onView(withId(R.id.main_view_posts_fragment)).check(matches(isDisplayed()));
    }*/

    @After
    public void tearDown() throws Exception {
    }
}
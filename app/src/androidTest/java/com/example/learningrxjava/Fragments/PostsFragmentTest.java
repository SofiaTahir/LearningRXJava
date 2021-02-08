package com.example.learningrxjava.Fragments;

import android.content.Context;

import com.example.learningrxjava.MainActivity;
import com.example.learningrxjava.Model.Posts;
import com.example.learningrxjava.R;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.test.core.app.ActivityScenario;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.rule.ActivityTestRule;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.*;

public class PostsFragmentTest {
    Context context;
    private List<Posts> postsList= new ArrayList<>();
    @Rule
    public ActivityTestRule<MainActivity> rule = new ActivityTestRule<>(MainActivity.class);
    private MainActivity mainActivity;
    private PostsFragment postsFragment;

    @Before
    public void setUp() throws Exception {
        mainActivity = rule.getActivity();
        context = ApplicationProvider.getApplicationContext();
        postsFragment = new PostsFragment();
        startFragment(postsFragment);
    }
    @Test
    public void isFragmentInView(){
        onView(withId(R.id.main_view_posts_fragment)).check(matches(isDisplayed()));
    }
    @Test
    public void progressBarDisplayed() {
        onView(withId(R.id.progressBar)).check(matches(isDisplayed()));
    }
    @Test
    public void checkEmptyPostsError(){
        onView(withId(R.id.tv_no_results)).check(matches(not(isDisplayed())));
    }

    /*@Test
    public void checkRecyclerviewDisplayed(){
        Posts postModel=new Posts(1,1,"Post 1","This is test post 1.");
        postsList.add(postModel);
        postModel=new Posts(1,2,"Post 2","This is test post 2.");
        postsList.add(postModel);
        postsFragment.displayData(postsList);
    }*/

    @After
    public void tearDown() throws Exception {
    }

    private void startFragment(Fragment fragment) {
        FragmentManager fragmentManager = mainActivity.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment, null);
        fragmentTransaction.commit();
    }
}
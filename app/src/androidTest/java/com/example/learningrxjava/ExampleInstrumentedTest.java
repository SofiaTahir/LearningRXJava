package com.example.learningrxjava;

import android.content.Context;
import android.view.View;
import android.widget.Button;

import com.example.learningrxjava.adapters.PostsAdapter;

import androidx.recyclerview.widget.RecyclerView;
import androidx.test.filters.LargeTest;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Rule
    public ActivityTestRule<MainActivity> rule = new ActivityTestRule<>(MainActivity.class);
    private MainActivity mainActivity;

    @Before
    public void setUp() throws Exception {
        mainActivity = rule.getActivity();
    }

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.learningrxjava", appContext.getPackageName());
    }

    @Test
    public void ensureButtonIsEnabled() throws Exception {
        View viewById = mainActivity.findViewById(R.id.btn_get_posts);
        assertThat(viewById, notNullValue());
        assertThat(viewById, instanceOf(Button.class));
        assertTrue(viewById.isEnabled());
    }

    @After
    public void tearDown() throws Exception {
        mainActivity = null;
    }
}
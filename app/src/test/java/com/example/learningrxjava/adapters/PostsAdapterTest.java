package com.example.learningrxjava.adapters;

import android.content.Context;
import com.example.learningrxjava.Model.Posts;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import java.util.ArrayList;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;


public class PostsAdapterTest {

    private List<Posts> postsList= new ArrayList<>();

    @Mock
    Context mockContext;

    @Before
    public void setup() {
        mockContext = Mockito.mock(Context.class);
        Posts postModel=new Posts(1,1,"Post 1","This is test post 1.");
        postsList.add(postModel);
        postModel=new Posts(1,2,"Post 2","This is test post 2.");
        postsList.add(postModel);
    }


    @Test
    public void testPostsAdapter() {
        PostsAdapter adapter = new PostsAdapter(mockContext, postsList);
        assertThat(adapter).isNotNull();
        int count = adapter.getItemCount();
        assertThat(count).isEqualTo(2);
    }
}
package com.example.learningrxjava.Fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.learningrxjava.Model.Users;
import com.example.learningrxjava.R;
import com.example.learningrxjava.Retrofit.RetrofitClient;
import com.example.learningrxjava.Util;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link UserFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UserFragment extends Fragment {

    private CompositeDisposable disposable;
    private RecyclerView rvPosts;
    private Button btnGetPosts, btnFindUsers;
    private ProgressBar progressBar;
    private Context context;
    private TextView inputID, inputName, inputUsername, inputEmail;
    private Group group;
    private EditText inputUserID;
    private int userID;

    public UserFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment UserFragment.
     */
    public static UserFragment newInstance(String param1, String param2) {
        UserFragment fragment = new UserFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getContext();
        disposable = new CompositeDisposable();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user, container, false);
    }

    @Override
    public void onViewCreated(@androidx.annotation.NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);

        btnFindUsers.setOnClickListener(v -> {
            String id = inputUserID.getText().toString();
            if (!Util.checkStringEmpty(id)) {
                userID = Integer.parseInt(id);
                if (Util.checkIDValid(userID)) {
                    progressBar.setVisibility(View.VISIBLE);
                    callUserService(userID);
                }
                else {
                    inputUserID.setError(getString(R.string.invalid_input_error));
                }
            }
            else {
                inputUserID.setError(getString(R.string.empty_input_error));
            }

        });
        btnGetPosts.setOnClickListener(v -> {
            AppCompatActivity activity = ((AppCompatActivity) context);
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction();
            ft.add(R.id.container, PostsFragment.newInstance(userID));
            ft.addToBackStack("");
            ft.commit();
        });
    }

    private void initViews(View view) {
        progressBar = view.findViewById(R.id.progressBar);
        btnGetPosts = view.findViewById(R.id.btn_get_posts);
        btnFindUsers = view.findViewById(R.id.btn_find_user);
        inputUserID = view.findViewById(R.id.input_user_id);
        inputID = view.findViewById(R.id.input_id);
        inputName = view.findViewById(R.id.input_name);
        inputUsername = view.findViewById(R.id.input_username);
        inputEmail = view.findViewById(R.id.input_email);
        group = view.findViewById(R.id.group);

        progressBar.setVisibility(View.GONE);
        group.setVisibility(View.GONE);
        /*rvPosts.addItemDecoration(new DividerItemDecoration(context,
                DividerItemDecoration.VERTICAL));
        rvPosts.setVisibility(View.GONE);*/
    }

    private void callUserService(int userID){
        RetrofitClient.getRequestApi().getUsers(userID)
                .toObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Users>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        disposable.add(d);
                    }

                    @Override
                    public void onNext(@NonNull Users users) {
                        progressBar.setVisibility(View.GONE);
                        displayUserData(users);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    protected void displayUserData(Users user){
        if (user!=null) {
            group.setVisibility(View.VISIBLE);
            inputID.setText("" + user.getId());
            inputName.setText(user.getName());
            inputUsername.setText(user.getUsername());
            inputEmail.setText(user.getEmail());

        }
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        disposable.clear();
    }
}
package com.example.learningrxjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.learningrxjava.Fragments.UserFragment;
import com.example.learningrxjava.Model.Posts;
import com.example.learningrxjava.Retrofit.RetrofitClient;
import com.example.learningrxjava.Retrofit.WebAPI;
import com.example.learningrxjava.adapters.PostsAdapter;

import java.util.List;

import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState==null){
            setFragment(new UserFragment());
        }



        //Observable<String> animalObservable = getObservable();
        /*Observable<Notes> notesObservable = getObservable();
        DisposableObserver<Notes> notesObserver = getNotesObserver();
        //Observer<String> animalObserver = getAnimalObserver();
        *//*DisposableObserver<String> animalObserver = getAnimalObserver();
        DisposableObserver<String> animalObserverAllCaps = getAnimalObserverAllCaps();*//*

        disposable.add(notesObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Function<Notes, Notes>() {
                    @Override
                    public Notes apply(@NonNull Notes notes) throws Exception {
                        notes.setName(notes.getName().toUpperCase());
                        return notes;
                    }
                }).subscribeWith(notesObserver));*/
        /*disposable.add(animalObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .filter(new Predicate<String>() {
                    @Override
                    public boolean test(@NonNull String s) throws Exception {
                        return s.startsWith("c");
                    }
                }).subscribeWith(animalObserver));
        disposable.add(animalObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .filter(new Predicate<String>() {
                    @Override
                    public boolean test(@NonNull String s) throws Exception {
                        return s.startsWith("d");
                    }
                }).map((Function<String, String>) s -> s.toUpperCase()).subscribeWith(animalObserverAllCaps));*/

        /*animalObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .filter(new Predicate<String>() {
                    @Override
                    public boolean test(@NonNull String s) throws Exception {
                        return s.toLowerCase().startsWith("c");
                    }
                })
                .subscribe(animalObserver);*/


    }






    /*private DisposableObserver<Notes> getNotesObserver() {
        return new DisposableObserver<Notes>() {
            @Override
            public void onNext(@NonNull Notes note) {
                Log.d(TAG, "Name: " + note.getName());
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.d(TAG, "Error: " + e.getMessage());
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete");
            }
        };
    }
    *//*private DisposableObserver<String> getAnimalObserver() {
        return new DisposableObserver<String>() {
            @Override
            public void onNext(@NonNull String s) {
                Log.d(TAG, "Name: " + s);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.d(TAG, "Error: " + e.getMessage());
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete");
            }
        };
    }

    private DisposableObserver<String> getAnimalObserverAllCaps() {
        return new DisposableObserver<String>() {
            @Override
            public void onNext(@NonNull String s) {
                Log.d(TAG, "Name: " + s);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.d(TAG, "Error: " + e.getMessage());
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete");
            }
        };
    }*//*

     *//* private Observer<String> getAnimalObserver(){
         return new Observer<String>() {
             @Override
             public void onSubscribe(@NonNull Disposable d) {
                 Log.d(TAG,"onSubscribe");
                 disposable = d;
             }

             @Override
             public void onNext(@NonNull String s) {
                 Log.d(TAG,"Name: "+ s);
             }

             @Override
             public void onError(@NonNull Throwable e) {
                 Log.d(TAG,"Error: "+ e.getMessage());
             }

             @Override
             public void onComplete() {
                 Log.d(TAG,"onComplete");
             }
         };
     }*//*
    private Observable<Notes> getObservable() {
        List<Notes> notesList = prepareNotes();
        return Observable.create(new ObservableOnSubscribe<Notes>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Notes> emitter) throws Exception {
                for (Notes note : notesList) {
                    if (!emitter.isDisposed()) {
                        emitter.onNext(note);
                    }
                }
                if (!emitter.isDisposed()) {
                    emitter.onComplete();
                }
            }
        });

        *//*return Observable.just("bear","cat", "dog", "parrot");*//*
    }

    private List<Notes> prepareNotes() {
        List<Notes> notesList = new ArrayList<>();
        notesList.add(new Notes(1, "note1"));
        notesList.add(new Notes(2, "note2"));
        notesList.add(new Notes(3, "note3"));
        return notesList;
    }*/
    public void setFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, fragment).commit();
    }


}
package nekono.inno.csgithub.ui.main.presenter;

import android.util.Log;
import android.view.View;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import nekono.inno.csgithub.model.Issue;
import nekono.inno.csgithub.model.retrofit.RestAPI;
import nekono.inno.csgithub.ui.main.view.MainActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import io.reactivex.Observable;

/**
 * Created by ekaterina on 3/22/18.
 * https://android.jlelse.eu/a-simple-android-apps-with-mvp-dagger-rxjava-and-retrofit-4edb214a66d7
 * https://android.jlelse.eu/mvp-dagger-2-rx-clean-modern-android-app-code-74f63c9a6f2f
 */

public class MainActivityPresenterImpl implements MainActivityPresenter{
    private MainActivity view;
    private Retrofit retrofit;


    public MainActivityPresenterImpl(MainActivity view, Retrofit retrofit){
        this.view = view;
        this.retrofit = retrofit;
    }

    @Override
    public void issueClicked(Issue issue) {
        view.showDetailedIssue(issue);
    }


    @Override
    public void requestIssues() {
         retrofit.create(RestAPI.class).getIssues()
                 .subscribeOn(Schedulers.newThread())
                 .observeOn(AndroidSchedulers.mainThread())
                 .subscribe(this::onResult, this::onError);

    }

    private void onResult(List<Issue> issues){
        view.showIssues(issues);
    }

    private void onError(Throwable error){
        Log.e("ErrorTag", "Some error");
        error.printStackTrace();
    }
}

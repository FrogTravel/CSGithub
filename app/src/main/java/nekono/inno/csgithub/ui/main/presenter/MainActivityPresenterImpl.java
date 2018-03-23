package nekono.inno.csgithub.ui.main.presenter;

import android.util.Log;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import nekono.inno.csgithub.model.Issue;
import nekono.inno.csgithub.util.retrofit.RestAPI;
import nekono.inno.csgithub.ui.main.view.MainView;
import retrofit2.Retrofit;

/**
 * Created by ekaterina on 3/22/18.
 */

public class MainActivityPresenterImpl implements MainActivityPresenter{
    private MainView view;
    private Retrofit retrofit;


    public MainActivityPresenterImpl(MainView view, Retrofit retrofit){
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
        error.printStackTrace();
    }
}

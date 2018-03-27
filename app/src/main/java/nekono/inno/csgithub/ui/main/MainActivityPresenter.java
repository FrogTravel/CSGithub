package nekono.inno.csgithub.ui.main;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import nekono.inno.csgithub.model.Issue;
import nekono.inno.csgithub.util.retrofit.RestAPI;
import retrofit2.Retrofit;

/**
 * Created by ekaterina on 3/22/18.
 */

public class MainActivityPresenter implements MainScreen.Presenter{
    private MainScreen.View view;
    private Retrofit retrofit;
    private List<Issue> issues;


    public MainActivityPresenter(MainScreen.View view, Retrofit retrofit){
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

    @Override
    public Issue getIssue(int position) {
        return issues.get(position);
    }

    @Override
    public int getIssuesSize() {
        return issues.size();
    }

    private void onResult(List<Issue> issues){
        this.issues = issues;
        view.showIssues(issues);
    }

    private void onError(Throwable error){
        error.printStackTrace();
    }
}

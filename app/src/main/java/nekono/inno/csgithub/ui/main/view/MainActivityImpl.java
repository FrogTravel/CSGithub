package nekono.inno.csgithub.ui.main.view;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import nekono.inno.csgithub.adapters.IssueAdapter;
import nekono.inno.csgithub.model.modules.App;
import nekono.inno.csgithub.model.Issue;
import nekono.inno.csgithub.R;
import nekono.inno.csgithub.model.modules.NetComponent;
import nekono.inno.csgithub.model.retrofit.RestAPI;
import nekono.inno.csgithub.ui.main.presenter.MainActivityPresenter;
import nekono.inno.csgithub.ui.main.presenter.MainActivityPresenterImpl;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivityImpl extends Activity implements MainActivity, IssueAdapter.OnIssueClickListener {

    @Inject
    Retrofit retrofit;
    @BindView(R.id.issues_recycler)
    RecyclerView issuesRecyclerView;

    private MainActivityPresenter presenter;
    NetComponent netComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((App) getApplication()).getNetComponent().inject(this);
        ButterKnife.bind(this);
        Log.d("ContCheck", this.getApplicationContext().toString());



        presenter = new MainActivityPresenterImpl(this, retrofit);
        presenter.requestIssues();

        issuesRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        //showIssues(isTest);
    }


    private void onResult(List<Issue> issues){
        showIssues(issues);
    }

    private void onError(Throwable error){

    }

    @Override
    public void showIssues(List<Issue> issues) {
        Log.d("ContCheck", this.getApplicationContext().toString());

       issuesRecyclerView.setAdapter(new IssueAdapter(issues, this));
    }

    @Override
    public void showDetailedIssue(Issue issue) {
    }

    @Override
    public void onIssueClick(Issue issue) {
        presenter.issueClicked(issue);
    }


}

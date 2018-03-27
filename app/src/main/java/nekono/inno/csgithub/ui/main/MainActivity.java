package nekono.inno.csgithub.ui.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import nekono.inno.csgithub.ui.main.adapters.IssueAdapter;
import nekono.inno.csgithub.util.modules.App;
import nekono.inno.csgithub.model.Issue;
import nekono.inno.csgithub.R;
import nekono.inno.csgithub.ui.detailed.DetailedActivity;
import retrofit2.Retrofit;

public class MainActivity extends Activity implements MainScreen.View, IssueAdapter.OnIssueClickListener {
    @Inject Retrofit retrofit;
    @BindView(R.id.issues_recycler) RecyclerView issuesRecyclerView;

    private MainScreen.Presenter presenter;

    /**
     * Some magic with dagger and then everything works just fine
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((App) getApplication()).getNetComponent().inject(this);
        ButterKnife.bind(this);

        presenter = new MainActivityPresenter(this, retrofit);
        presenter.requestIssues();

        issuesRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void showIssues(List<Issue> issues) {
       issuesRecyclerView.setAdapter(new IssueAdapter(issues, this));
    }

    /**
     * I choose to pass the issue through intent, more convenient for me
     */
    @Override
    public void showDetailedIssue(Issue issue) {
        Intent intent = new Intent(this, DetailedActivity.class);
        intent.putExtra("Issue", issue);
        startActivity(intent);
    }

    @Override
    public void onIssueClick(Issue issue) {
        presenter.issueClicked(issue);
    }


}

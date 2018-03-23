package nekono.inno.csgithub.ui.main.presenter;

import nekono.inno.csgithub.model.Issue;
import retrofit2.Retrofit;

/**
 * Created by ekaterina on 3/22/18.
 */

public interface MainActivityPresenter {
    void issueClicked(Issue issue);

    void requestIssues();
}

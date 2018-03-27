package nekono.inno.csgithub.ui.main;

import java.util.List;

import nekono.inno.csgithub.model.Issue;

/**
 * Created by ekaterina on 3/28/18.
 */

public interface MainScreen {
    interface View{
        void showIssues(List<Issue> issues);

        void showDetailedIssue(Issue issue);
    }

    interface Presenter{
        void issueClicked(Issue issue);

        void requestIssues();

        Issue getIssue(int position);

        int getIssuesSize();
    }


}

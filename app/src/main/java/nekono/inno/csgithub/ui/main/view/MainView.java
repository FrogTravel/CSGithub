package nekono.inno.csgithub.ui.main.view;

import java.util.List;

import nekono.inno.csgithub.model.Issue;

/**
 * Created by ekaterina on 3/22/18.
 */

public interface MainView {
    void showIssues(List<Issue> issues);

    void showDetailedIssue(Issue issue);
}

package nekono.inno.csgithub.ui.main.view;

import java.util.List;

import nekono.inno.csgithub.model.Issue;
import nekono.inno.csgithub.model.modules.NetComponent;

/**
 * Created by ekaterina on 3/22/18.
 */

public interface MainActivity{
    void showIssues(List<Issue> issues);

    void showDetailedIssue(Issue issue);
}

package nekono.inno.csgithub.ui.detailed;

import java.util.List;

import nekono.inno.csgithub.model.Issue;
import nekono.inno.csgithub.model.Labels;

/**
 * Created by ekaterina on 3/28/18.
 */

public interface DetailedScreen {
    interface View{
        void setLogin(String login);
        void showAvatar(String url);
        void setTitle(String title);
        void setBody(String body);
        void setState(String state);
        void setLabels(List<Labels> labels);
        void setDate(String date);
    }

    interface Presenter{
        void parseIssue(Issue issue);
    }
}

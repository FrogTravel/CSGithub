package nekono.inno.csgithub.ui.detailed;

import nekono.inno.csgithub.model.Issue;

/**
 * Created by ekaterina on 3/24/18.
 */

public class DetailedPresenterImpl implements DetailedPresenter {
    private DetailedView view;


    public DetailedPresenterImpl(DetailedView view){
        this.view = view;
    }

    @Override
    public void parseIssue(Issue issue) {
        view.setLabels(issue.getLabels());
        view.showAvatar(issue.getUser().getAvatar_url());
        view.setLogin(issue.getUser().getLogin());
        view.setBody(issue.getBody());
        view.setState(issue.getState());
        view.setDate(issue.getCreated_at());
        view.setTitle(issue.getTitle());
    }
}
